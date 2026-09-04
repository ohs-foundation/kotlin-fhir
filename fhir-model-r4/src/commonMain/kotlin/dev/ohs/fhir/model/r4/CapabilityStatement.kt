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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.CapabilityStatementDocumentSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementImplementationSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementMessagingEndpointSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementMessagingSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementMessagingSupportedMessageSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestInteractionSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestResourceInteractionSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestResourceOperationSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestResourceSearchParamSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestResourceSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestSecuritySerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementRestSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementSerializer
import dev.ohs.fhir.model.r4.serializers.CapabilityStatementSoftwareSerializer
import dev.ohs.fhir.model.r4.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a
 * particular version of FHIR that may be used as a statement of actual server functionality or a
 * statement of required or desired server implementation.
 */
@Serializable(with = CapabilityStatementSerializer::class)
@SerialName("CapabilityStatement")
public data class CapabilityStatement(
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
   * An absolute URI that is used to identify this capability statement when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this capability statement is (or will be) published. This URL can be the target of a
   * canonical reference. It SHALL remain the same when the capability statement is stored on
   * different servers.
   *
   * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances may
   * share the same URL if they have a distinct version.
   *
   * The determination of when to create a new version of a resource (same url, new version) vs.
   * defining a new artifact is up to the author. Considerations for making this decision are found
   * in [Technical and Business Versions](resource.html#versions).
   *
   * In some cases, the resource can no longer be found at the stated url, but the url itself cannot
   * change. Implementations can use the [meta.source](resource.html#meta) element to indicate where
   * the current master source of the resource can be found.
   */
  public val url: Uri? = null,
  /**
   * The identifier that is used to identify this version of the capability statement when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the capability statement author and is not expected to be globally unique. For example, it
   * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence.
   *
   * There may be different capability statement instances that have the same identifier but
   * different versions. The version can be appended to the url in a reference to allow a reference
   * to a particular business version of the capability statement with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the capability statement. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the capability statement.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this capability statement. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of capability statements that are appropriate for use versus not.This is not
   * intended for use with actual capability statements, but where capability statements are used to
   * describe possible or desired systems.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this capability statement is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of capability statements that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the capability statement was published. The date must
   * change when the business version changes and it must change if the status code changes. In
   * addition, it should change when the substantive content of the capability statement changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the capability statement. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime,
  /**
   * The name of the organization or individual that published the capability statement.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the capability
   * statement is the organization or individual primarily responsible for the maintenance and
   * upkeep of the capability statement. This is not necessarily the same individual or organization
   * that developed and initially authored the content. The publisher is the primary point of
   * contact for questions or issues with the capability statement. This item SHOULD be populated
   * unless the information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the capability statement from a consumer's
   * perspective. Typically, this is used when the capability statement describes a desired rather
   * than an actual solution, for example as a formal expression of requirements as part of an RFP.
   *
   * This description can be used to capture details such as why the capability statement was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the capability statement as
   * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
   * information is available from context (e.g. the language of the capability statement is
   * presumed to be the predominant language in the place the capability statement was created).This
   * does not need to be populated if the description is adequately implied by the software or
   * implementation details.
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate capability statement instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the capability statement is intended to be used.
   *
   * It may be possible for the capability statement to be used in jurisdictions other than those
   * for which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this capability statement is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the capability statement. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * capability statement.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the capability statement and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the capability
   * statement.
   */
  public val copyright: Markdown? = null,
  /**
   * The way that this statement is intended to be used, to describe an actual running instance of
   * software, a particular product (kind, not instance of software) or a class of implementation
   * (e.g. a desired purchase).
   */
  public val kind: Enumeration<CapabilityStatementKind>,
  /**
   * Reference to a canonical URL of another CapabilityStatement that this software implements. This
   * capability statement is a published API description that corresponds to a business service. The
   * server may actually implement a subset of the capability statement it claims to implement, so
   * the capability statement must specify the full capability details.
   *
   * HL7 defines the following Services: [Terminology Service](terminology-service.html).
   *
   * Many [Implementation Guides](http://fhir.org/guides/registry) define additional services.
   */
  public val instantiates: List<Canonical> = listOf(),
  /**
   * Reference to a canonical URL of another CapabilityStatement that this software adds to. The
   * capability statement automatically includes everything in the other statement, and it is not
   * duplicated, though the server may repeat the same resources, interactions and operations to add
   * additional details to them.
   *
   * the contents of any directly or indirectly imported CapabilityStatements SHALL NOT overlap,
   * i.e. they cannot refer to the same rest/resource, operations/name, searchparam/name,
   * interaction/code, messaging/endpoint, document/mode pair.
   *
   * A capability statement that imports another CapabilityStatement automatically instantiates it
   * too (though this is often not a very useful statement for the kinds of CapabilityStatements
   * that are suitable for importing).
   */
  public val imports: List<Canonical> = listOf(),
  /**
   * Software that is covered by this capability statement. It is used when the capability statement
   * describes the capabilities of a particular software version, independent of an installation.
   */
  public val software: Software? = null,
  /**
   * Identifies a specific implementation instance that is described by the capability statement -
   * i.e. a particular installation, rather than the capabilities of a software program.
   */
  public val implementation: Implementation? = null,
  /**
   * The version of the FHIR specification that this CapabilityStatement describes (which SHALL be
   * the same as the FHIR version of the CapabilityStatement itself). There is no default value.
   *
   * Servers may implement multiple versions (see [Managing Multiple Versions](versioning.html), and
   * the [$versions](capabilitystatement-operation-versions.html) operation). If they do, and the
   * CapabilityStatement is requested from the server, then this fhirVersion will be either the
   * version requested, or the server's default version.
   */
  public val fhirVersion: Enumeration<FHIRVersion>,
  /**
   * A list of the formats supported by this implementation using their content types.
   *
   * "xml", "json" and "ttl" are allowed, which describe the simple encodings described in the
   * specification (and imply appropriate bundle support). Otherwise, mime types are legal here.
   */
  public val format: List<Code>,
  /**
   * A list of the patch formats supported by this implementation using their content types.
   *
   * At present, the patch mime types application/json-patch+json and application/xml-patch+xml are
   * legal. Generally, if a server supports PATCH, it would be expected to support the patch formats
   * and match the formats it supports, but this is not always possible or necessary.
   */
  public val patchFormat: List<Code> = listOf(),
  /** A list of implementation guides that the server does (or should) support in their entirety. */
  public val implementationGuide: List<Canonical> = listOf(),
  /**
   * A definition of the restful capabilities of the solution, if any.
   *
   * Multiple repetitions allow definition of both client and/or server behaviors or possibly
   * behaviors under different configuration settings (for software or requirements statements).
   */
  public val rest: List<Rest> = listOf(),
  /**
   * A description of the messaging capabilities of the solution.
   *
   * Multiple repetitions allow the documentation of multiple endpoints per solution.
   */
  public val messaging: List<Messaging> = listOf(),
  /** A document definition. */
  public val document: List<Document> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          date.toBuilder(),
          kind,
          fhirVersion,
          format.map { it.toBuilder() }.toMutableList(),
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
          url = this@with.url?.toBuilder()
          version = this@with.version?.toBuilder()
          name = this@with.name?.toBuilder()
          title = this@with.title?.toBuilder()
          experimental = this@with.experimental?.toBuilder()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          purpose = this@with.purpose?.toBuilder()
          copyright = this@with.copyright?.toBuilder()
          instantiates = this@with.instantiates.map { it.toBuilder() }.toMutableList()
          imports = this@with.imports.map { it.toBuilder() }.toMutableList()
          software = this@with.software?.toBuilder()
          implementation = this@with.implementation?.toBuilder()
          patchFormat = this@with.patchFormat.map { it.toBuilder() }.toMutableList()
          implementationGuide = this@with.implementationGuide.map { it.toBuilder() }.toMutableList()
          rest = this@with.rest.map { it.toBuilder() }.toMutableList()
          messaging = this@with.messaging.map { it.toBuilder() }.toMutableList()
          document = this@with.document.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * Software that is covered by this capability statement. It is used when the capability statement
   * describes the capabilities of a particular software version, independent of an installation.
   */
  @Serializable(with = CapabilityStatementSoftwareSerializer::class)
  public data class Software(
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
    /** Name the software is known by. */
    public val name: String,
    /**
     * The version identifier for the software covered by this statement.
     *
     * If possible, a version should be specified, as statements are likely to be different for
     * different versions of software.
     */
    public val version: String? = null,
    /** Date this version of the software was released. */
    public val releaseDate: DateTime? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          version = this@with.version?.toBuilder()
          releaseDate = this@with.releaseDate?.toBuilder()
        }
      }

    public class Builder(
      /** Name the software is known by. */
      public var name: String.Builder
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
       * The version identifier for the software covered by this statement.
       *
       * If possible, a version should be specified, as statements are likely to be different for
       * different versions of software.
       */
      public var version: String.Builder? = null

      /** Date this version of the software was released. */
      public var releaseDate: DateTime.Builder? = null

      public fun build(): Software =
        Software(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          version = version?.build(),
          releaseDate = releaseDate?.build(),
        )
    }
  }

  /**
   * Identifies a specific implementation instance that is described by the capability statement -
   * i.e. a particular installation, rather than the capabilities of a software program.
   */
  @Serializable(with = CapabilityStatementImplementationSerializer::class)
  public data class Implementation(
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
    /** Information about the specific installation that this capability statement relates to. */
    public val description: String,
    /**
     * An absolute base URL for the implementation. This forms the base for REST interfaces as well
     * as the mailbox and document interfaces.
     */
    public val url: Url? = null,
    /**
     * The organization responsible for the management of the instance and oversight of the data on
     * the server at the specified URL.
     */
    public val custodian: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(description.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          url = this@with.url?.toBuilder()
          custodian = this@with.custodian?.toBuilder()
        }
      }

    public class Builder(
      /** Information about the specific installation that this capability statement relates to. */
      public var description: String.Builder
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
       * An absolute base URL for the implementation. This forms the base for REST interfaces as
       * well as the mailbox and document interfaces.
       */
      public var url: Url.Builder? = null

      /**
       * The organization responsible for the management of the instance and oversight of the data
       * on the server at the specified URL.
       */
      public var custodian: Reference.Builder? = null

      public fun build(): Implementation =
        Implementation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description.build(),
          url = url?.build(),
          custodian = custodian?.build(),
        )
    }
  }

  /** A definition of the restful capabilities of the solution, if any. */
  @Serializable(with = CapabilityStatementRestSerializer::class)
  public data class Rest(
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
     * Identifies whether this portion of the statement is describing the ability to initiate or
     * receive restful operations.
     */
    public val mode: Enumeration<RestfulCapabilityMode>,
    /**
     * Information about the system's restful capabilities that apply across all applications, such
     * as security.
     */
    public val documentation: Markdown? = null,
    /**
     * Information about security implementation from an interface perspective - what a client needs
     * to know.
     */
    public val security: Security? = null,
    /**
     * A specification of the restful capabilities of the solution for a specific resource type.
     *
     * Max of one repetition per resource type.
     */
    public val resource: List<Resource> = listOf(),
    /** A specification of restful operations supported by the system. */
    public val interaction: List<Interaction> = listOf(),
    /**
     * Search parameters that are supported for searching all resources for implementations to
     * support and/or make use of - either references to ones defined in the specification, or
     * additional ones defined for/by the implementation.
     *
     * Typically, the only search parameters supported for all searches are those that apply to all
     * resources - tags, profiles, text search etc. These search parameters should include the
     * control search parameters such as _sort, _count, etc. that also apply to this resource
     * (though many will be listed at
     * [CapabilityStatement.rest.searchParam](capabilitystatement-definitions.html#CapabilityStatement.rest.searchParam)).
     * The behavior of some search parameters may be further described by other code or extension
     * elements, or narrative within the capability statement or linked
     * [SearchParameter](searchparameter.html#) definitions.
     */
    public val searchParam: List<Resource.SearchParam> = listOf(),
    /**
     * Definition of an operation or a named query together with its parameters and their meaning
     * and type.
     *
     * CapabilityStatement.rest.operation is for operations invoked at the system level, or for
     * operations that are supported across multiple resource types. Operations linked from
     * CapabilityStatement.rest.operation must have OperationDefinition.system = true, or more than
     * one Operation.resource.
     */
    public val operation: List<Resource.Operation> = listOf(),
    /**
     * An absolute URI which is a reference to the definition of a compartment that the system
     * supports. The reference is to a CompartmentDefinition resource by its canonical URL .
     *
     * At present, the only defined compartments are at
     * [CompartmentDefinition](compartmentdefinition.html).
     */
    public val compartment: List<Canonical> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(mode).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          documentation = this@with.documentation?.toBuilder()
          security = this@with.security?.toBuilder()
          resource = this@with.resource.map { it.toBuilder() }.toMutableList()
          interaction = this@with.interaction.map { it.toBuilder() }.toMutableList()
          searchParam = this@with.searchParam.map { it.toBuilder() }.toMutableList()
          operation = this@with.operation.map { it.toBuilder() }.toMutableList()
          compartment = this@with.compartment.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Information about security implementation from an interface perspective - what a client needs
     * to know.
     */
    @Serializable(with = CapabilityStatementRestSecuritySerializer::class)
    public data class Security(
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
       * Server adds CORS headers when responding to requests - this enables Javascript applications
       * to use the server.
       *
       * The easiest CORS headers to add are Access-Control-Allow-Origin: * &
       * Access-Control-Request-Method: GET, POST, PUT, DELETE. All servers SHOULD support CORS.
       */
      public val cors: Boolean? = null,
      /** Types of security services that are supported/required by the system. */
      public val service: List<CodeableConcept> = listOf(),
      /** General description of how security works. */
      public val description: Markdown? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            cors = this@with.cors?.toBuilder()
            service = this@with.service.map { it.toBuilder() }.toMutableList()
            description = this@with.description?.toBuilder()
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
         * Server adds CORS headers when responding to requests - this enables Javascript
         * applications to use the server.
         *
         * The easiest CORS headers to add are Access-Control-Allow-Origin: * &
         * Access-Control-Request-Method: GET, POST, PUT, DELETE. All servers SHOULD support CORS.
         */
        public var cors: Boolean.Builder? = null

        /** Types of security services that are supported/required by the system. */
        public var service: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** General description of how security works. */
        public var description: Markdown.Builder? = null

        public fun build(): Security =
          Security(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            cors = cors?.build(),
            service = service.map { it.build() },
            description = description?.build(),
          )
      }
    }

    /** A specification of the restful capabilities of the solution for a specific resource type. */
    @Serializable(with = CapabilityStatementRestResourceSerializer::class)
    public data class Resource(
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
      /** A type of resource exposed via the restful interface. */
      public val type: Enumeration<ResourceType>,
      /**
       * A specification of the profile that describes the solution's overall support for the
       * resource, including any constraints on cardinality, bindings, lengths or other limitations.
       * See further discussion in [Using Profiles](profiling.html#profile-uses).
       *
       * The profile applies to all resources of this type - i.e. it is the superset of what is
       * supported by the system.
       */
      public val profile: Canonical? = null,
      /**
       * A list of profiles that represent different use cases supported by the system. For a
       * server, "supported by the system" means the system hosts/produces a set of resources that
       * are conformant to a particular profile, and allows clients that use its services to search
       * using this profile and to find appropriate data. For a client, it means the system will
       * search by this profile and process data according to the guidance implicit in the profile.
       * See further discussion in [Using Profiles](profiling.html#profile-uses).
       *
       * Supported profiles are different than the profile that applies to a particular resource in
       * .rest.resource.profile. The resource profile is a general statement of what features of the
       * resource are supported overall by the system - the sum total of the facilities it supports.
       * A supported profile is a deeper statement about the functionality of the data and services
       * provided by the server (or used by the client). A typical case is a laboratory system that
       * produces a set of different reports - this is the list of types of data that it publishes.
       * A key aspect of declaring profiles here is the question of how the client converts
       * knowledge that the server publishes this data into working with the data; the client can
       * inspect individual resources to determine whether they conform to a particular profile, but
       * how does it find the ones that do? It does so by searching using the _profile parameter, so
       * any resources listed here must be valid values for the _profile resource (using the
       * identifier in the target profile).
       */
      public val supportedProfile: List<Canonical> = listOf(),
      /** Additional information about the resource type used by the system. */
      public val documentation: Markdown? = null,
      /**
       * Identifies a restful operation supported by the solution.
       *
       * In general, a Resource will only appear in a CapabilityStatement if the server actually has
       * some capabilities - e.g. there is at least one interaction supported. However interactions
       * can be omitted to support summarization (_summary = true).
       */
      public val interaction: List<Interaction> = listOf(),
      /**
       * This field is set to no-version to specify that the system does not support (server) or use
       * (client) versioning for this resource type. If this has some other value, the server must
       * at least correctly track and populate the versionId meta-property on resources. If the
       * value is 'versioned-update', then the server supports all the versioning features,
       * including using e-tags for version integrity in the API.
       *
       * If a server supports versionIds correctly, it SHOULD support vread too, but is not required
       * to do so.
       */
      public val versioning: Enumeration<ResourceVersionPolicy>? = null,
      /**
       * A flag for whether the server is able to return past versions as part of the vRead
       * operation.
       *
       * It is useful to support the vRead operation for current operations, even if past versions
       * aren't available.
       */
      public val readHistory: Boolean? = null,
      /**
       * A flag to indicate that the server allows or needs to allow the client to create new
       * identities on the server (that is, the client PUTs to a location where there is no existing
       * resource). Allowing this operation means that the server allows the client to create new
       * identities on the server.
       *
       * Allowing the clients to create new identities on the server means that the system
       * administrator needs to have confidence that the clients do not create clashing identities
       * between them. Obviously, if there is only one client, this won't happen. While creating
       * identities on the client means that the clients need to be managed, it's much more
       * convenient for many scenarios if such management can be put in place.
       */
      public val updateCreate: Boolean? = null,
      /**
       * A flag that indicates that the server supports conditional create.
       *
       * Conditional Create is mainly appropriate for interface engine scripts converting from other
       * formats, such as v2.
       */
      public val conditionalCreate: Boolean? = null,
      /**
       * A code that indicates how the server supports conditional read.
       *
       * Conditional Read is mainly appropriate for interface engine scripts converting from other
       * formats, such as v2.
       */
      public val conditionalRead: Enumeration<ConditionalReadStatus>? = null,
      /**
       * A flag that indicates that the server supports conditional update.
       *
       * Conditional Update is mainly appropriate for interface engine scripts converting from other
       * formats, such as v2.
       */
      public val conditionalUpdate: Boolean? = null,
      /**
       * A code that indicates how the server supports conditional delete.
       *
       * Conditional Delete is mainly appropriate for interface engine scripts converting from other
       * formats, such as v2.
       */
      public val conditionalDelete: Enumeration<ConditionalDeleteStatus>? = null,
      /** A set of flags that defines how references are supported. */
      public val referencePolicy: List<Enumeration<ReferenceHandlingPolicy>> = listOf(),
      /**
       * A list of _include values supported by the server.
       *
       * If this list is empty, the server does not support includes.
       */
      public val searchInclude: List<String> = listOf(),
      /**
       * A list of _revinclude (reverse include) values supported by the server.
       *
       * If this list is empty, the server does not support reverse includes.
       */
      public val searchRevInclude: List<String> = listOf(),
      /**
       * Search parameters for implementations to support and/or make use of - either references to
       * ones defined in the specification, or additional ones defined for/by the implementation.
       *
       * The search parameters should include the control search parameters such as _sort, _count,
       * etc. that also apply to this resource (though many will be listed at
       * [CapabilityStatement.rest.searchParam](capabilitystatement-definitions.html#CapabilityStatement.rest.searchParam)).
       * The behavior of some search parameters may be further described by other code or extension
       * elements, or narrative within the capability statement or linked
       * [SearchParameter](searchparameter.html#) definitions.
       */
      public val searchParam: List<SearchParam> = listOf(),
      /**
       * Definition of an operation or a named query together with its parameters and their meaning
       * and type. Consult the definition of the operation for details about how to invoke the
       * operation, and the parameters.
       *
       * Operations linked from CapabilityStatement.rest.resource.operation must have
       * OperationDefinition.type = true or OperationDefinition.instance = true.
       *
       * If an operation that is listed in multiple CapabilityStatement.rest.resource.operation
       * (e.g. for different resource types), then clients should understand that the operation is
       * only supported on the specified resource types, and that may be a subset of those listed in
       * OperationDefinition.resource.
       */
      public val operation: List<Operation> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            profile = this@with.profile?.toBuilder()
            supportedProfile = this@with.supportedProfile.map { it.toBuilder() }.toMutableList()
            documentation = this@with.documentation?.toBuilder()
            interaction = this@with.interaction.map { it.toBuilder() }.toMutableList()
            versioning = this@with.versioning
            readHistory = this@with.readHistory?.toBuilder()
            updateCreate = this@with.updateCreate?.toBuilder()
            conditionalCreate = this@with.conditionalCreate?.toBuilder()
            conditionalRead = this@with.conditionalRead
            conditionalUpdate = this@with.conditionalUpdate?.toBuilder()
            conditionalDelete = this@with.conditionalDelete
            referencePolicy = this@with.referencePolicy.toMutableList()
            searchInclude = this@with.searchInclude.map { it.toBuilder() }.toMutableList()
            searchRevInclude = this@with.searchRevInclude.map { it.toBuilder() }.toMutableList()
            searchParam = this@with.searchParam.map { it.toBuilder() }.toMutableList()
            operation = this@with.operation.map { it.toBuilder() }.toMutableList()
          }
        }

      /** Identifies a restful operation supported by the solution. */
      @Serializable(with = CapabilityStatementRestResourceInteractionSerializer::class)
      public data class Interaction(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /** Coded identifier of the operation, supported by the system resource. */
        public val code: Enumeration<TypeRestfulInteraction>,
        /**
         * Guidance specific to the implementation of this operation, such as 'delete is a logical
         * delete' or 'updates are only allowed with version id' or 'creates permitted from
         * pre-authorized certificates only'.
         */
        public val documentation: Markdown? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(code).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              documentation = this@with.documentation?.toBuilder()
            }
          }

        public class Builder(
          /** Coded identifier of the operation, supported by the system resource. */
          public var code: Enumeration<TypeRestfulInteraction>
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * Guidance specific to the implementation of this operation, such as 'delete is a logical
           * delete' or 'updates are only allowed with version id' or 'creates permitted from
           * pre-authorized certificates only'.
           */
          public var documentation: Markdown.Builder? = null

          public fun build(): Interaction =
            Interaction(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              code = code,
              documentation = documentation?.build(),
            )
        }
      }

      /**
       * Search parameters for implementations to support and/or make use of - either references to
       * ones defined in the specification, or additional ones defined for/by the implementation.
       */
      @Serializable(with = CapabilityStatementRestResourceSearchParamSerializer::class)
      public data class SearchParam(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The name of the search parameter used in the interface.
         *
         * Parameter names cannot overlap with standard parameter names, and standard parameters
         * cannot be redefined.
         */
        public val name: String,
        /**
         * An absolute URI that is a formal reference to where this parameter was first defined, so
         * that a client can be confident of the meaning of the search parameter (a reference to
         * [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This
         * element SHALL be populated if the search parameter refers to a SearchParameter defined by
         * the FHIR core specification or externally defined IGs.
         *
         * This SHOULD be present, and matches refers to a SearchParameter by its canonical URL. If
         * systems wish to document their support for modifiers, comparators, target resource types,
         * and chained parameters, they should do using a search parameter resource. This element
         * SHALL be populated if the search parameter refers to a SearchParameter defined by the
         * FHIR core specification or externally defined IGs.
         */
        public val definition: Canonical? = null,
        /**
         * The type of value a search parameter refers to, and how the content is interpreted.
         *
         * While this can be looked up from the definition, it is included here as a convenience for
         * systems that autogenerate a query interface based on the server capability statement. It
         * SHALL be the same as the type in the search parameter definition.
         */
        public val type: Enumeration<SearchParamType>,
        /**
         * This allows documentation of any distinct behaviors about how the search parameter is
         * used. For example, text matching algorithms.
         */
        public val documentation: Markdown? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(
                name.toBuilder(),
                type,
              )
              .apply {
                id = this@with.id
                extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
                definition = this@with.definition?.toBuilder()
                documentation = this@with.documentation?.toBuilder()
              }
          }

        public class Builder(
          /**
           * The name of the search parameter used in the interface.
           *
           * Parameter names cannot overlap with standard parameter names, and standard parameters
           * cannot be redefined.
           */
          public var name: String.Builder,
          /**
           * The type of value a search parameter refers to, and how the content is interpreted.
           *
           * While this can be looked up from the definition, it is included here as a convenience
           * for systems that autogenerate a query interface based on the server capability
           * statement. It SHALL be the same as the type in the search parameter definition.
           */
          public var type: Enumeration<SearchParamType>,
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * An absolute URI that is a formal reference to where this parameter was first defined,
           * so that a client can be confident of the meaning of the search parameter (a reference
           * to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This
           * element SHALL be populated if the search parameter refers to a SearchParameter defined
           * by the FHIR core specification or externally defined IGs.
           *
           * This SHOULD be present, and matches refers to a SearchParameter by its canonical URL.
           * If systems wish to document their support for modifiers, comparators, target resource
           * types, and chained parameters, they should do using a search parameter resource. This
           * element SHALL be populated if the search parameter refers to a SearchParameter defined
           * by the FHIR core specification or externally defined IGs.
           */
          public var definition: Canonical.Builder? = null

          /**
           * This allows documentation of any distinct behaviors about how the search parameter is
           * used. For example, text matching algorithms.
           */
          public var documentation: Markdown.Builder? = null

          public fun build(): SearchParam =
            SearchParam(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              name = name.build(),
              definition = definition?.build(),
              type = type,
              documentation = documentation?.build(),
            )
        }
      }

      /**
       * Definition of an operation or a named query together with its parameters and their meaning
       * and type. Consult the definition of the operation for details about how to invoke the
       * operation, and the parameters.
       */
      @Serializable(with = CapabilityStatementRestResourceOperationSerializer::class)
      public data class Operation(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The name of the operation or query. For an operation, this is the name prefixed with $
         * and used in the URL. For a query, this is the name used in the _query parameter when the
         * query is called.
         *
         * The name here SHOULD be the same as the name in the definition, unless there is a name
         * clash and the name cannot be used. The name does not include the "$" portion that is
         * always included in the URL.
         */
        public val name: String,
        /**
         * Where the formal definition can be found. If a server references the base definition of
         * an Operation (i.e. from the specification itself such
         * as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports
         * the full capabilities of the operation - e.g. both GET and POST invocation. If it only
         * supports a subset, it must define its own custom
         * [OperationDefinition](operationdefinition.html#) with a 'base' of the original
         * OperationDefinition. The custom definition would describe the specific subset of
         * functionality supported.
         *
         * This can be used to build an HTML form to invoke the operation, for instance.
         */
        public val definition: Canonical,
        /**
         * Documentation that describes anything special about the operation behavior, possibly
         * detailing different behavior for system, type and instance-level invocation of the
         * operation.
         */
        public val documentation: Markdown? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(name.toBuilder(), definition.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              documentation = this@with.documentation?.toBuilder()
            }
          }

        public class Builder(
          /**
           * The name of the operation or query. For an operation, this is the name prefixed with $
           * and used in the URL. For a query, this is the name used in the _query parameter when
           * the query is called.
           *
           * The name here SHOULD be the same as the name in the definition, unless there is a name
           * clash and the name cannot be used. The name does not include the "$" portion that is
           * always included in the URL.
           */
          public var name: String.Builder,
          /**
           * Where the formal definition can be found. If a server references the base definition of
           * an Operation (i.e. from the specification itself such
           * as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it
           * supports the full capabilities of the operation - e.g. both GET and POST invocation. If
           * it only supports a subset, it must define its own custom
           * [OperationDefinition](operationdefinition.html#) with a 'base' of the original
           * OperationDefinition. The custom definition would describe the specific subset of
           * functionality supported.
           *
           * This can be used to build an HTML form to invoke the operation, for instance.
           */
          public var definition: Canonical.Builder,
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * Documentation that describes anything special about the operation behavior, possibly
           * detailing different behavior for system, type and instance-level invocation of the
           * operation.
           */
          public var documentation: Markdown.Builder? = null

          public fun build(): Operation =
            Operation(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              name = name.build(),
              definition = definition.build(),
              documentation = documentation?.build(),
            )
        }
      }

      public class Builder(
        /** A type of resource exposed via the restful interface. */
        public var type: Enumeration<ResourceType>
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
         * A specification of the profile that describes the solution's overall support for the
         * resource, including any constraints on cardinality, bindings, lengths or other
         * limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).
         *
         * The profile applies to all resources of this type - i.e. it is the superset of what is
         * supported by the system.
         */
        public var profile: Canonical.Builder? = null

        /**
         * A list of profiles that represent different use cases supported by the system. For a
         * server, "supported by the system" means the system hosts/produces a set of resources that
         * are conformant to a particular profile, and allows clients that use its services to
         * search using this profile and to find appropriate data. For a client, it means the system
         * will search by this profile and process data according to the guidance implicit in the
         * profile. See further discussion in [Using Profiles](profiling.html#profile-uses).
         *
         * Supported profiles are different than the profile that applies to a particular resource
         * in .rest.resource.profile. The resource profile is a general statement of what features
         * of the resource are supported overall by the system - the sum total of the facilities it
         * supports. A supported profile is a deeper statement about the functionality of the data
         * and services provided by the server (or used by the client). A typical case is a
         * laboratory system that produces a set of different reports - this is the list of types of
         * data that it publishes. A key aspect of declaring profiles here is the question of how
         * the client converts knowledge that the server publishes this data into working with the
         * data; the client can inspect individual resources to determine whether they conform to a
         * particular profile, but how does it find the ones that do? It does so by searching using
         * the _profile parameter, so any resources listed here must be valid values for the
         * _profile resource (using the identifier in the target profile).
         */
        public var supportedProfile: MutableList<Canonical.Builder> = mutableListOf()

        /** Additional information about the resource type used by the system. */
        public var documentation: Markdown.Builder? = null

        /**
         * Identifies a restful operation supported by the solution.
         *
         * In general, a Resource will only appear in a CapabilityStatement if the server actually
         * has some capabilities - e.g. there is at least one interaction supported. However
         * interactions can be omitted to support summarization (_summary = true).
         */
        public var interaction: MutableList<Interaction.Builder> = mutableListOf()

        /**
         * This field is set to no-version to specify that the system does not support (server) or
         * use (client) versioning for this resource type. If this has some other value, the server
         * must at least correctly track and populate the versionId meta-property on resources. If
         * the value is 'versioned-update', then the server supports all the versioning features,
         * including using e-tags for version integrity in the API.
         *
         * If a server supports versionIds correctly, it SHOULD support vread too, but is not
         * required to do so.
         */
        public var versioning: Enumeration<ResourceVersionPolicy>? = null

        /**
         * A flag for whether the server is able to return past versions as part of the vRead
         * operation.
         *
         * It is useful to support the vRead operation for current operations, even if past versions
         * aren't available.
         */
        public var readHistory: Boolean.Builder? = null

        /**
         * A flag to indicate that the server allows or needs to allow the client to create new
         * identities on the server (that is, the client PUTs to a location where there is no
         * existing resource). Allowing this operation means that the server allows the client to
         * create new identities on the server.
         *
         * Allowing the clients to create new identities on the server means that the system
         * administrator needs to have confidence that the clients do not create clashing identities
         * between them. Obviously, if there is only one client, this won't happen. While creating
         * identities on the client means that the clients need to be managed, it's much more
         * convenient for many scenarios if such management can be put in place.
         */
        public var updateCreate: Boolean.Builder? = null

        /**
         * A flag that indicates that the server supports conditional create.
         *
         * Conditional Create is mainly appropriate for interface engine scripts converting from
         * other formats, such as v2.
         */
        public var conditionalCreate: Boolean.Builder? = null

        /**
         * A code that indicates how the server supports conditional read.
         *
         * Conditional Read is mainly appropriate for interface engine scripts converting from other
         * formats, such as v2.
         */
        public var conditionalRead: Enumeration<ConditionalReadStatus>? = null

        /**
         * A flag that indicates that the server supports conditional update.
         *
         * Conditional Update is mainly appropriate for interface engine scripts converting from
         * other formats, such as v2.
         */
        public var conditionalUpdate: Boolean.Builder? = null

        /**
         * A code that indicates how the server supports conditional delete.
         *
         * Conditional Delete is mainly appropriate for interface engine scripts converting from
         * other formats, such as v2.
         */
        public var conditionalDelete: Enumeration<ConditionalDeleteStatus>? = null

        /** A set of flags that defines how references are supported. */
        public var referencePolicy: MutableList<Enumeration<ReferenceHandlingPolicy>> =
          mutableListOf()

        /**
         * A list of _include values supported by the server.
         *
         * If this list is empty, the server does not support includes.
         */
        public var searchInclude: MutableList<String.Builder> = mutableListOf()

        /**
         * A list of _revinclude (reverse include) values supported by the server.
         *
         * If this list is empty, the server does not support reverse includes.
         */
        public var searchRevInclude: MutableList<String.Builder> = mutableListOf()

        /**
         * Search parameters for implementations to support and/or make use of - either references
         * to ones defined in the specification, or additional ones defined for/by the
         * implementation.
         *
         * The search parameters should include the control search parameters such as _sort, _count,
         * etc. that also apply to this resource (though many will be listed at
         * [CapabilityStatement.rest.searchParam](capabilitystatement-definitions.html#CapabilityStatement.rest.searchParam)).
         * The behavior of some search parameters may be further described by other code or
         * extension elements, or narrative within the capability statement or linked
         * [SearchParameter](searchparameter.html#) definitions.
         */
        public var searchParam: MutableList<SearchParam.Builder> = mutableListOf()

        /**
         * Definition of an operation or a named query together with its parameters and their
         * meaning and type. Consult the definition of the operation for details about how to invoke
         * the operation, and the parameters.
         *
         * Operations linked from CapabilityStatement.rest.resource.operation must have
         * OperationDefinition.type = true or OperationDefinition.instance = true.
         *
         * If an operation that is listed in multiple CapabilityStatement.rest.resource.operation
         * (e.g. for different resource types), then clients should understand that the operation is
         * only supported on the specified resource types, and that may be a subset of those listed
         * in OperationDefinition.resource.
         */
        public var operation: MutableList<Operation.Builder> = mutableListOf()

        public fun build(): Resource =
          Resource(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type,
            profile = profile?.build(),
            supportedProfile = supportedProfile.map { it.build() },
            documentation = documentation?.build(),
            interaction = interaction.map { it.build() },
            versioning = versioning,
            readHistory = readHistory?.build(),
            updateCreate = updateCreate?.build(),
            conditionalCreate = conditionalCreate?.build(),
            conditionalRead = conditionalRead,
            conditionalUpdate = conditionalUpdate?.build(),
            conditionalDelete = conditionalDelete,
            referencePolicy = referencePolicy,
            searchInclude = searchInclude.map { it.build() },
            searchRevInclude = searchRevInclude.map { it.build() },
            searchParam = searchParam.map { it.build() },
            operation = operation.map { it.build() },
          )
      }
    }

    /** A specification of restful operations supported by the system. */
    @Serializable(with = CapabilityStatementRestInteractionSerializer::class)
    public data class Interaction(
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
      /** A coded identifier of the operation, supported by the system. */
      public val code: Enumeration<SystemRestfulInteraction>,
      /**
       * Guidance specific to the implementation of this operation, such as limitations on the kind
       * of transactions allowed, or information about system wide search is implemented.
       */
      public val documentation: Markdown? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(code).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            documentation = this@with.documentation?.toBuilder()
          }
        }

      public class Builder(
        /** A coded identifier of the operation, supported by the system. */
        public var code: Enumeration<SystemRestfulInteraction>
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
         * Guidance specific to the implementation of this operation, such as limitations on the
         * kind of transactions allowed, or information about system wide search is implemented.
         */
        public var documentation: Markdown.Builder? = null

        public fun build(): Interaction =
          Interaction(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code,
            documentation = documentation?.build(),
          )
      }
    }

    public class Builder(
      /**
       * Identifies whether this portion of the statement is describing the ability to initiate or
       * receive restful operations.
       */
      public var mode: Enumeration<RestfulCapabilityMode>
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
       * Information about the system's restful capabilities that apply across all applications,
       * such as security.
       */
      public var documentation: Markdown.Builder? = null

      /**
       * Information about security implementation from an interface perspective - what a client
       * needs to know.
       */
      public var security: Security.Builder? = null

      /**
       * A specification of the restful capabilities of the solution for a specific resource type.
       *
       * Max of one repetition per resource type.
       */
      public var resource: MutableList<Resource.Builder> = mutableListOf()

      /** A specification of restful operations supported by the system. */
      public var interaction: MutableList<Interaction.Builder> = mutableListOf()

      /**
       * Search parameters that are supported for searching all resources for implementations to
       * support and/or make use of - either references to ones defined in the specification, or
       * additional ones defined for/by the implementation.
       *
       * Typically, the only search parameters supported for all searches are those that apply to
       * all resources - tags, profiles, text search etc. These search parameters should include the
       * control search parameters such as _sort, _count, etc. that also apply to this resource
       * (though many will be listed at
       * [CapabilityStatement.rest.searchParam](capabilitystatement-definitions.html#CapabilityStatement.rest.searchParam)).
       * The behavior of some search parameters may be further described by other code or extension
       * elements, or narrative within the capability statement or linked
       * [SearchParameter](searchparameter.html#) definitions.
       */
      public var searchParam: MutableList<Resource.SearchParam.Builder> = mutableListOf()

      /**
       * Definition of an operation or a named query together with its parameters and their meaning
       * and type.
       *
       * CapabilityStatement.rest.operation is for operations invoked at the system level, or for
       * operations that are supported across multiple resource types. Operations linked from
       * CapabilityStatement.rest.operation must have OperationDefinition.system = true, or more
       * than one Operation.resource.
       */
      public var operation: MutableList<Resource.Operation.Builder> = mutableListOf()

      /**
       * An absolute URI which is a reference to the definition of a compartment that the system
       * supports. The reference is to a CompartmentDefinition resource by its canonical URL .
       *
       * At present, the only defined compartments are at
       * [CompartmentDefinition](compartmentdefinition.html).
       */
      public var compartment: MutableList<Canonical.Builder> = mutableListOf()

      public fun build(): Rest =
        Rest(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          mode = mode,
          documentation = documentation?.build(),
          security = security?.build(),
          resource = resource.map { it.build() },
          interaction = interaction.map { it.build() },
          searchParam = searchParam.map { it.build() },
          operation = operation.map { it.build() },
          compartment = compartment.map { it.build() },
        )
    }
  }

  /** A description of the messaging capabilities of the solution. */
  @Serializable(with = CapabilityStatementMessagingSerializer::class)
  public data class Messaging(
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
    /** An endpoint (network accessible address) to which messages and/or replies are to be sent. */
    public val endpoint: List<Endpoint> = listOf(),
    /**
     * Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long the
     * cache length on the receiver should be (if a sender).
     *
     * If this value is missing then the application does not implement (receiver) or depend on
     * (sender) reliable messaging.
     */
    public val reliableCache: UnsignedInt? = null,
    /**
     * Documentation about the system's messaging capabilities for this endpoint not otherwise
     * documented by the capability statement. For example, the process for becoming an authorized
     * messaging exchange partner.
     */
    public val documentation: Markdown? = null,
    /**
     * References to message definitions for messages this system can send or receive.
     *
     * This is a proposed alternative to the messaging.event structure.
     */
    public val supportedMessage: List<SupportedMessage> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
          reliableCache = this@with.reliableCache?.toBuilder()
          documentation = this@with.documentation?.toBuilder()
          supportedMessage = this@with.supportedMessage.map { it.toBuilder() }.toMutableList()
        }
      }

    /** An endpoint (network accessible address) to which messages and/or replies are to be sent. */
    @Serializable(with = CapabilityStatementMessagingEndpointSerializer::class)
    public data class Endpoint(
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
      /** A list of the messaging transport protocol(s) identifiers, supported by this endpoint. */
      public val protocol: Coding,
      /**
       * The network address of the endpoint. For solutions that do not use network addresses for
       * routing, it can be just an identifier.
       */
      public val address: Url,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(protocol.toBuilder(), address.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * A list of the messaging transport protocol(s) identifiers, supported by this endpoint.
         */
        public var protocol: Coding.Builder,
        /**
         * The network address of the endpoint. For solutions that do not use network addresses for
         * routing, it can be just an identifier.
         */
        public var address: Url.Builder,
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

        public fun build(): Endpoint =
          Endpoint(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            protocol = protocol.build(),
            address = address.build(),
          )
      }
    }

    /** References to message definitions for messages this system can send or receive. */
    @Serializable(with = CapabilityStatementMessagingSupportedMessageSerializer::class)
    public data class SupportedMessage(
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
      /** The mode of this event declaration - whether application is sender or receiver. */
      public val mode: Enumeration<EventCapabilityMode>,
      /**
       * Points to a message definition that identifies the messaging event, message structure,
       * allowed responses, etc.
       */
      public val definition: Canonical,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              mode,
              definition.toBuilder(),
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            }
        }

      public class Builder(
        /** The mode of this event declaration - whether application is sender or receiver. */
        public var mode: Enumeration<EventCapabilityMode>,
        /**
         * Points to a message definition that identifies the messaging event, message structure,
         * allowed responses, etc.
         */
        public var definition: Canonical.Builder,
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

        public fun build(): SupportedMessage =
          SupportedMessage(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            mode = mode,
            definition = definition.build(),
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

      /**
       * An endpoint (network accessible address) to which messages and/or replies are to be sent.
       */
      public var endpoint: MutableList<Endpoint.Builder> = mutableListOf()

      /**
       * Length if the receiver's reliable messaging cache in minutes (if a receiver) or how long
       * the cache length on the receiver should be (if a sender).
       *
       * If this value is missing then the application does not implement (receiver) or depend on
       * (sender) reliable messaging.
       */
      public var reliableCache: UnsignedInt.Builder? = null

      /**
       * Documentation about the system's messaging capabilities for this endpoint not otherwise
       * documented by the capability statement. For example, the process for becoming an authorized
       * messaging exchange partner.
       */
      public var documentation: Markdown.Builder? = null

      /**
       * References to message definitions for messages this system can send or receive.
       *
       * This is a proposed alternative to the messaging.event structure.
       */
      public var supportedMessage: MutableList<SupportedMessage.Builder> = mutableListOf()

      public fun build(): Messaging =
        Messaging(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          endpoint = endpoint.map { it.build() },
          reliableCache = reliableCache?.build(),
          documentation = documentation?.build(),
          supportedMessage = supportedMessage.map { it.build() },
        )
    }
  }

  /** A document definition. */
  @Serializable(with = CapabilityStatementDocumentSerializer::class)
  public data class Document(
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
    /** Mode of this document declaration - whether an application is a producer or consumer. */
    public val mode: Enumeration<DocumentMode>,
    /**
     * A description of how the application supports or uses the specified document profile. For
     * example, when documents are created, what action is taken with consumed documents, etc.
     */
    public val documentation: Markdown? = null,
    /**
     * A profile on the document Bundle that constrains which resources are present, and their
     * contents.
     *
     * The profile is actually on the Bundle.
     */
    public val profile: Canonical,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            mode,
            profile.toBuilder(),
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            documentation = this@with.documentation?.toBuilder()
          }
      }

    public class Builder(
      /** Mode of this document declaration - whether an application is a producer or consumer. */
      public var mode: Enumeration<DocumentMode>,
      /**
       * A profile on the document Bundle that constrains which resources are present, and their
       * contents.
       *
       * The profile is actually on the Bundle.
       */
      public var profile: Canonical.Builder,
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
       * A description of how the application supports or uses the specified document profile. For
       * example, when documents are created, what action is taken with consumed documents, etc.
       */
      public var documentation: Markdown.Builder? = null

      public fun build(): Document =
        Document(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          mode = mode,
          documentation = documentation?.build(),
          profile = profile.build(),
        )
    }
  }

  public class Builder(
    /**
     * The status of this capability statement. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of capability statements that are appropriate for use versus not.This is not
     * intended for use with actual capability statements, but where capability statements are used
     * to describe possible or desired systems.
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * The date (and optionally time) when the capability statement was published. The date must
     * change when the business version changes and it must change if the status code changes. In
     * addition, it should change when the substantive content of the capability statement changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the capability statement. Additional specific dates may be
     * added as extensions or be found by consulting Provenances associated with past versions of
     * the resource.
     */
    public var date: DateTime.Builder,
    /**
     * The way that this statement is intended to be used, to describe an actual running instance of
     * software, a particular product (kind, not instance of software) or a class of implementation
     * (e.g. a desired purchase).
     */
    public var kind: Enumeration<CapabilityStatementKind>,
    /**
     * The version of the FHIR specification that this CapabilityStatement describes (which SHALL be
     * the same as the FHIR version of the CapabilityStatement itself). There is no default value.
     *
     * Servers may implement multiple versions (see [Managing Multiple Versions](versioning.html),
     * and the [$versions](capabilitystatement-operation-versions.html) operation). If they do, and
     * the CapabilityStatement is requested from the server, then this fhirVersion will be either
     * the version requested, or the server's default version.
     */
    public var fhirVersion: Enumeration<FHIRVersion>,
    /**
     * A list of the formats supported by this implementation using their content types.
     *
     * "xml", "json" and "ttl" are allowed, which describe the simple encodings described in the
     * specification (and imply appropriate bundle support). Otherwise, mime types are legal here.
     */
    public var format: MutableList<Code.Builder>,
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
     * An absolute URI that is used to identify this capability statement when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this capability statement is (or will be) published. This URL can be the target
     * of a canonical reference. It SHALL remain the same when the capability statement is stored on
     * different servers.
     *
     * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances
     * may share the same URL if they have a distinct version.
     *
     * The determination of when to create a new version of a resource (same url, new version) vs.
     * defining a new artifact is up to the author. Considerations for making this decision are
     * found in [Technical and Business Versions](resource.html#versions).
     *
     * In some cases, the resource can no longer be found at the stated url, but the url itself
     * cannot change. Implementations can use the [meta.source](resource.html#meta) element to
     * indicate where the current master source of the resource can be found.
     */
    public var url: Uri.Builder? = null

    /**
     * The identifier that is used to identify this version of the capability statement when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the capability statement author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different capability statement instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the capability statement with the format
     * [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the capability statement. This name should be usable as
     * an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the capability statement.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this capability statement is authored for testing purposes
     * (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of capability statements that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The name of the organization or individual that published the capability statement.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the
     * capability statement is the organization or individual primarily responsible for the
     * maintenance and upkeep of the capability statement. This is not necessarily the same
     * individual or organization that developed and initially authored the content. The publisher
     * is the primary point of contact for questions or issues with the capability statement. This
     * item SHOULD be populated unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the capability statement from a consumer's
     * perspective. Typically, this is used when the capability statement describes a desired rather
     * than an actual solution, for example as a formal expression of requirements as part of an
     * RFP.
     *
     * This description can be used to capture details such as why the capability statement was
     * built, comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the capability
     * statement as conveyed in the 'text' field of the resource itself. This item SHOULD be
     * populated unless the information is available from context (e.g. the language of the
     * capability statement is presumed to be the predominant language in the place the capability
     * statement was created).This does not need to be populated if the description is adequately
     * implied by the software or implementation details.
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate capability statement instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the capability statement is intended to be used.
     *
     * It may be possible for the capability statement to be used in jurisdictions other than those
     * for which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this capability statement is needed and why it has been designed as it
     * has.
     *
     * This element does not describe the usage of the capability statement. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * capability statement.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the capability statement and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the capability
     * statement.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * Reference to a canonical URL of another CapabilityStatement that this software implements.
     * This capability statement is a published API description that corresponds to a business
     * service. The server may actually implement a subset of the capability statement it claims to
     * implement, so the capability statement must specify the full capability details.
     *
     * HL7 defines the following Services: [Terminology Service](terminology-service.html).
     *
     * Many [Implementation Guides](http://fhir.org/guides/registry) define additional services.
     */
    public var instantiates: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * Reference to a canonical URL of another CapabilityStatement that this software adds to. The
     * capability statement automatically includes everything in the other statement, and it is not
     * duplicated, though the server may repeat the same resources, interactions and operations to
     * add additional details to them.
     *
     * the contents of any directly or indirectly imported CapabilityStatements SHALL NOT overlap,
     * i.e. they cannot refer to the same rest/resource, operations/name, searchparam/name,
     * interaction/code, messaging/endpoint, document/mode pair.
     *
     * A capability statement that imports another CapabilityStatement automatically instantiates it
     * too (though this is often not a very useful statement for the kinds of CapabilityStatements
     * that are suitable for importing).
     */
    public var imports: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * Software that is covered by this capability statement. It is used when the capability
     * statement describes the capabilities of a particular software version, independent of an
     * installation.
     */
    public var software: Software.Builder? = null

    /**
     * Identifies a specific implementation instance that is described by the capability statement -
     * i.e. a particular installation, rather than the capabilities of a software program.
     */
    public var implementation: Implementation.Builder? = null

    /**
     * A list of the patch formats supported by this implementation using their content types.
     *
     * At present, the patch mime types application/json-patch+json and application/xml-patch+xml
     * are legal. Generally, if a server supports PATCH, it would be expected to support the patch
     * formats and match the formats it supports, but this is not always possible or necessary.
     */
    public var patchFormat: MutableList<Code.Builder> = mutableListOf()

    /**
     * A list of implementation guides that the server does (or should) support in their entirety.
     */
    public var implementationGuide: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * A definition of the restful capabilities of the solution, if any.
     *
     * Multiple repetitions allow definition of both client and/or server behaviors or possibly
     * behaviors under different configuration settings (for software or requirements statements).
     */
    public var rest: MutableList<Rest.Builder> = mutableListOf()

    /**
     * A description of the messaging capabilities of the solution.
     *
     * Multiple repetitions allow the documentation of multiple endpoints per solution.
     */
    public var messaging: MutableList<Messaging.Builder> = mutableListOf()

    /** A document definition. */
    public var document: MutableList<Document.Builder> = mutableListOf()

    override fun build(): CapabilityStatement =
      CapabilityStatement(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url?.build(),
        version = version?.build(),
        name = name?.build(),
        title = title?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        kind = kind,
        instantiates = instantiates.map { it.build() },
        imports = imports.map { it.build() },
        software = software?.build(),
        implementation = implementation?.build(),
        fhirVersion = fhirVersion,
        format = format.map { it.build() },
        patchFormat = patchFormat.map { it.build() },
        implementationGuide = implementationGuide.map { it.build() },
        rest = rest.map { it.build() },
        messaging = messaging.map { it.build() },
        document = document.map { it.build() },
      )
  }

  /** The mode of a RESTful capability statement. */
  public enum class RestfulCapabilityMode(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Client("client", "http://hl7.org/fhir/restful-capability-mode", "Client"),
    Server("server", "http://hl7.org/fhir/restful-capability-mode", "Server");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): RestfulCapabilityMode =
        when (code) {
          "client" -> Client
          "server" -> Server
          else ->
            throw IllegalArgumentException("Unknown code $code for enum RestfulCapabilityMode")
        }
    }
  }

  /** How the system supports versioning for a resource. */
  public enum class ResourceVersionPolicy(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    No_Version("no-version", "http://hl7.org/fhir/versioning-policy", "No VersionId Support"),
    Versioned("versioned", "http://hl7.org/fhir/versioning-policy", "Versioned"),
    Versioned_Update(
      "versioned-update",
      "http://hl7.org/fhir/versioning-policy",
      "VersionId tracked fully",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ResourceVersionPolicy =
        when (code) {
          "no-version" -> No_Version
          "versioned" -> Versioned
          "versioned-update" -> Versioned_Update
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ResourceVersionPolicy")
        }
    }
  }

  /** A code that indicates how the server supports conditional read. */
  public enum class ConditionalReadStatus(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Not_Supported("not-supported", "http://hl7.org/fhir/conditional-read-status", "Not Supported"),
    Modified_Since(
      "modified-since",
      "http://hl7.org/fhir/conditional-read-status",
      "If-Modified-Since",
    ),
    Not_Match("not-match", "http://hl7.org/fhir/conditional-read-status", "If-None-Match"),
    Full_Support("full-support", "http://hl7.org/fhir/conditional-read-status", "Full Support");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ConditionalReadStatus =
        when (code) {
          "not-supported" -> Not_Supported
          "modified-since" -> Modified_Since
          "not-match" -> Not_Match
          "full-support" -> Full_Support
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ConditionalReadStatus")
        }
    }
  }

  /** A code that indicates how the server supports conditional delete. */
  public enum class ConditionalDeleteStatus(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Not_Supported(
      "not-supported",
      "http://hl7.org/fhir/conditional-delete-status",
      "Not Supported",
    ),
    Single("single", "http://hl7.org/fhir/conditional-delete-status", "Single Deletes Supported"),
    Multiple(
      "multiple",
      "http://hl7.org/fhir/conditional-delete-status",
      "Multiple Deletes Supported",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ConditionalDeleteStatus =
        when (code) {
          "not-supported" -> Not_Supported
          "single" -> Single
          "multiple" -> Multiple
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ConditionalDeleteStatus")
        }
    }
  }

  /** A set of flags that defines how references are supported. */
  public enum class ReferenceHandlingPolicy(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Literal("literal", "http://hl7.org/fhir/reference-handling-policy", "Literal References"),
    Logical("logical", "http://hl7.org/fhir/reference-handling-policy", "Logical References"),
    Resolves("resolves", "http://hl7.org/fhir/reference-handling-policy", "Resolves References"),
    Enforced(
      "enforced",
      "http://hl7.org/fhir/reference-handling-policy",
      "Reference Integrity Enforced",
    ),
    Local("local", "http://hl7.org/fhir/reference-handling-policy", "Local References Only");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ReferenceHandlingPolicy =
        when (code) {
          "literal" -> Literal
          "logical" -> Logical
          "resolves" -> Resolves
          "enforced" -> Enforced
          "local" -> Local
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ReferenceHandlingPolicy")
        }
    }
  }

  /** Operations supported by REST at the type or instance level. */
  public enum class TypeRestfulInteraction(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Read("read", "http://hl7.org/fhir/restful-interaction", "read"),
    Vread("vread", "http://hl7.org/fhir/restful-interaction", "vread"),
    Update("update", "http://hl7.org/fhir/restful-interaction", "update"),
    Patch("patch", "http://hl7.org/fhir/restful-interaction", "patch"),
    Delete("delete", "http://hl7.org/fhir/restful-interaction", "delete"),
    History_Instance(
      "history-instance",
      "http://hl7.org/fhir/restful-interaction",
      "history-instance",
    ),
    History_Type("history-type", "http://hl7.org/fhir/restful-interaction", "history-type"),
    Create("create", "http://hl7.org/fhir/restful-interaction", "create"),
    Search_Type("search-type", "http://hl7.org/fhir/restful-interaction", "search-type");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): TypeRestfulInteraction =
        when (code) {
          "read" -> Read
          "vread" -> Vread
          "update" -> Update
          "patch" -> Patch
          "delete" -> Delete
          "history-instance" -> History_Instance
          "history-type" -> History_Type
          "create" -> Create
          "search-type" -> Search_Type
          else ->
            throw IllegalArgumentException("Unknown code $code for enum TypeRestfulInteraction")
        }
    }
  }

  /** Operations supported by REST at the system level. */
  public enum class SystemRestfulInteraction(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Transaction("transaction", "http://hl7.org/fhir/restful-interaction", "transaction"),
    Batch("batch", "http://hl7.org/fhir/restful-interaction", "batch"),
    Search_System("search-system", "http://hl7.org/fhir/restful-interaction", "search-system"),
    History_System("history-system", "http://hl7.org/fhir/restful-interaction", "history-system");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): SystemRestfulInteraction =
        when (code) {
          "transaction" -> Transaction
          "batch" -> Batch
          "search-system" -> Search_System
          "history-system" -> History_System
          else ->
            throw IllegalArgumentException("Unknown code $code for enum SystemRestfulInteraction")
        }
    }
  }

  /** The mode of a message capability statement. */
  public enum class EventCapabilityMode(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Sender("sender", "http://hl7.org/fhir/event-capability-mode", "Sender"),
    Receiver("receiver", "http://hl7.org/fhir/event-capability-mode", "Receiver");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): EventCapabilityMode =
        when (code) {
          "sender" -> Sender
          "receiver" -> Receiver
          else -> throw IllegalArgumentException("Unknown code $code for enum EventCapabilityMode")
        }
    }
  }

  /** Whether the application produces or consumes documents. */
  public enum class DocumentMode(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Producer("producer", "http://hl7.org/fhir/document-mode", "Producer"),
    Consumer("consumer", "http://hl7.org/fhir/document-mode", "Consumer");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): DocumentMode =
        when (code) {
          "producer" -> Producer
          "consumer" -> Consumer
          else -> throw IllegalArgumentException("Unknown code $code for enum DocumentMode")
        }
    }
  }

  /** How a capability statement is intended to be used. */
  public enum class CapabilityStatementKind(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Instance("instance", "http://hl7.org/fhir/capability-statement-kind", "Instance"),
    Capability("capability", "http://hl7.org/fhir/capability-statement-kind", "Capability"),
    Requirements("requirements", "http://hl7.org/fhir/capability-statement-kind", "Requirements");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): CapabilityStatementKind =
        when (code) {
          "instance" -> Instance
          "capability" -> Capability
          "requirements" -> Requirements
          else ->
            throw IllegalArgumentException("Unknown code $code for enum CapabilityStatementKind")
        }
    }
  }
}
