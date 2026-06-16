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

import dev.ohs.fhir.model.r4b.serializers.BundleEntryRequestSerializer
import dev.ohs.fhir.model.r4b.serializers.BundleEntryResponseSerializer
import dev.ohs.fhir.model.r4b.serializers.BundleEntrySearchSerializer
import dev.ohs.fhir.model.r4b.serializers.BundleEntrySerializer
import dev.ohs.fhir.model.r4b.serializers.BundleLinkSerializer
import dev.ohs.fhir.model.r4b.serializers.BundleSerializer
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
   * If a set of search matches, this is the total number of entries of type 'match' across all
   * pages in the search. It does not include search.mode = 'include' or 'outcome' entries and it
   * does not provide a count of the number of entries in the Bundle.
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
   * specific.
   */
  public val link: List<Link> = listOf(),
  /**
   * An entry in a bundle resource - will either contain a resource or information about a resource
   * (transactions and history only).
   */
  public val entry: List<Entry> = listOf(),
  /**
   * Digital Signature - base64 encoded. XML-DSig or a JWT.
   *
   * The signature could be created by the "author" of the bundle or by the originating device.
   * Requirements around inclusion of a signature, verification of signatures and treatment of
   * signed/non-signed bundles is implementation-environment specific.
   */
  public val signature: Signature? = null,
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
     * A name which details the functional use for this link - see
     * [http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1](http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1).
     */
    public val relation: String,
    /** The reference details for the link. */
    public val url: Uri,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(relation.toBuilder(), url.toBuilder()).apply {
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
      public var relation: String.Builder,
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

      public fun build(): Link =
        Link(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          relation = relation.build(),
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
    /** A series of links that provide context to this entry. */
    public val link: List<Link> = listOf(),
    /**
     * The Absolute URL for the resource. The fullUrl SHALL NOT disagree with the id in the
     * resource - i.e. if the fullUrl is not a urn:uuid, the URL shall be version-independent URL
     * consistent with the Resource.id. The fullUrl is a version independent reference to the
     * resource. The fullUrl element SHALL have a value except that:
     * * fullUrl can be empty on a POST (although it does not need to when specifying a temporary id
     *   for reference in the bundle)
     * * Results from operations might involve resources that are not identified.
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
     * Bundle.type.
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
          Builder(method, url.toBuilder()).apply {
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

      /** A series of links that provide context to this entry. */
      public var link: MutableList<Link.Builder> = mutableListOf()

      /**
       * The Absolute URL for the resource. The fullUrl SHALL NOT disagree with the id in the
       * resource - i.e. if the fullUrl is not a urn:uuid, the URL shall be version-independent URL
       * consistent with the Resource.id. The fullUrl is a version independent reference to the
       * resource. The fullUrl element SHALL have a value except that:
       * * fullUrl can be empty on a POST (although it does not need to when specifying a temporary
       *   id for reference in the bundle)
       * * Results from operations might involve resources that are not identified.
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
       * Bundle.type.
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
     * If a set of search matches, this is the total number of entries of type 'match' across all
     * pages in the search. It does not include search.mode = 'include' or 'outcome' entries and it
     * does not provide a count of the number of entries in the Bundle.
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
     * specific.
     */
    public var link: MutableList<Link.Builder> = mutableListOf()

    /**
     * An entry in a bundle resource - will either contain a resource or information about a
     * resource (transactions and history only).
     */
    public var entry: MutableList<Entry.Builder> = mutableListOf()

    /**
     * Digital Signature - base64 encoded. XML-DSig or a JWT.
     *
     * The signature could be created by the "author" of the bundle or by the originating device.
     * Requirements around inclusion of a signature, verification of signatures and treatment of
     * signed/non-signed bundles is implementation-environment specific.
     */
    public var signature: Signature.Builder? = null

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
      )
  }

  /**
   * Why an entry is in the result set - whether it's included as a match or because of an _include
   * requirement, or to convey information or warning information about the search process.
   */
  public enum class SearchEntryMode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Match("match", "http://hl7.org/fhir/search-entry-mode", "Match"),
    Include("include", "http://hl7.org/fhir/search-entry-mode", "Include"),
    Outcome("outcome", "http://hl7.org/fhir/search-entry-mode", "Outcome");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

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
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Get("GET", "http://hl7.org/fhir/http-verb", "GET"),
    Head("HEAD", "http://hl7.org/fhir/http-verb", "HEAD"),
    Post("POST", "http://hl7.org/fhir/http-verb", "POST"),
    Put("PUT", "http://hl7.org/fhir/http-verb", "PUT"),
    Delete("DELETE", "http://hl7.org/fhir/http-verb", "DELETE"),
    Patch("PATCH", "http://hl7.org/fhir/http-verb", "PATCH");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

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
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
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
    Collection("collection", "http://hl7.org/fhir/bundle-type", "Collection");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

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
          else -> throw IllegalArgumentException("Unknown code $code for enum BundleType")
        }
    }
  }
}
