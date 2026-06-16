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

import dev.ohs.fhir.model.r5.serializers.SearchParameterComponentSerializer
import dev.ohs.fhir.model.r5.serializers.SearchParameterSerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A search parameter that defines a named search item that can be used to search/filter on a
 * resource.
 */
@Serializable(with = SearchParameterSerializer::class)
@SerialName("SearchParameter")
public data class SearchParameter(
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
   * An absolute URI that is used to identify this search parameter when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which an authoritative instance of this
   * search parameter is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the search parameter is stored on different servers.
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
  public val url: Uri,
  /**
   * A formal identifier that is used to identify this search parameter when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the search parameter when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the search parameter author and is not expected to be globally unique. For example, it might be
   * a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence.
   *
   * There may be different search parameter instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the search parameter with the format [url]|[version]. The
   * version SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
   */
  public val version: String? = null,
  /**
   * Indicates the mechanism used to compare versions to determine which is more current.
   *
   * If set as a string, this is a FHIRPath expression that has two additional context variables
   * passed in - %version1 and %version2 and will return a negative number if version1 is newer, a
   * positive number if version2 and a 0 if the version ordering can't be successfully be
   * determined.
   */
  public val versionAlgorithm: VersionAlgorithm? = null,
  /**
   * A natural language name identifying the search parameter. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String,
  /**
   * A short, descriptive, user-friendly title for the search parameter.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * Where this search parameter is originally defined. If a derivedFrom is provided, then the
   * details in the search parameter must be consistent with the definition from which it is
   * defined. i.e. the parameter should have the same meaning, and (usually) the functionality
   * should be a proper subset of the underlying search parameter.
   *
   * The intent of this is that a server can designate that it provides support for a search
   * parameter defined in the specification itself (e.g.
   * [`value-quantity`](http://hl7.org/fhir/SearchParameter/Observation-value-quantity), but detail
   * how it is supported by the server.
   */
  public val derivedFrom: Canonical? = null,
  /**
   * The status of this search parameter. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of search parameters that are appropriate for use versus not.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this search parameter is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of search parameters that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the search parameter was last significantly changed. The
   * date must change when the business version changes and it must change if the status code
   * changes. In addition, it should change when the substantive content of the search parameter
   * changes.
   *
   * The date is often not tracked until the resource is published, but may be present on draft
   * content. Note that this is not the same as the resource last-modified-date, since the resource
   * may be a secondary representation of the search parameter. Additional specific dates may be
   * added as extensions or be found by consulting Provenances associated with past versions of the
   * resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual tresponsible for the release and ongoing maintenance
   * of the search parameter.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the search
   * parameter is the organization or individual primarily responsible for the maintenance and
   * upkeep of the search parameter. This is not necessarily the same individual or organization
   * that developed and initially authored the content. The publisher is the primary point of
   * contact for questions or issues with the search parameter. This item SHOULD be populated unless
   * the information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * And how it used.
   *
   * This description can be used to capture details such as comments about misuse, instructions for
   * clinical use and interpretation, literature references, examples from the paper world, etc. It
   * is not a rendering of the search parameter as conveyed in the 'text' field of the resource
   * itself. This item SHOULD be populated unless the information is available from context (e.g.
   * the language of the search parameter is presumed to be the predominant language in the place
   * the search parameter was created).
   */
  public val description: Markdown,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate search parameter instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the search parameter is intended to be used.
   *
   * It may be possible for the search parameter to be used in jurisdictions other than those for
   * which it was originally designed or intended.
   *
   * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
   * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
   * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
   * useContext.valueCodeableConcept indicating the jurisdiction.)
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this search parameter is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the search parameter. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * search parameter.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the search parameter and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the search parameter.
   *
   * ...
   */
  public val copyright: Markdown? = null,
  /**
   * A short string (<50 characters), suitable for inclusion in a page footer that identifies the
   * copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All
   * rights reserved', 'Some rights reserved').
   *
   * The (c) symbol should NOT be included in this string. It will be added by software when
   * rendering the notation. Full details about licensing, restrictions, warrantees, etc. goes in
   * the more general 'copyright' element.
   */
  public val copyrightLabel: String? = null,
  /**
   * The label that is recommended to be used in the URL or the parameter name in a parameters
   * resource for this search parameter. In some cases, servers may need to use a different
   * CapabilityStatement searchParam.name to differentiate between multiple SearchParameters that
   * happen to have the same code.
   *
   * For maximum compatibility, use only lowercase ASCII characters. Note that HL7 will never define
   * multiple search parameters with the same code.
   */
  public val code: Code,
  /**
   * The base resource type(s) that this search parameter can be used against.
   *
   * A search parameter must always apply to at least one resource type. When search parameters
   * apply to more than one resource type, they can be used against any of the listed resource
   * types, or in a cross-type search (see [Cross Resource Search](http.html#xres-search)).
   */
  public val base: List<Enumeration<VersionIndependentResourceTypesAll>>,
  /** The type of value that a search parameter may contain, and how the content is interpreted. */
  public val type: Enumeration<SearchParamType>,
  /**
   * A FHIRPath expression that returns a set of elements for the search parameter.
   *
   * Note that the elements returned by the expression are sometimes complex elements where logic is
   * required to determine quite how to handle them; e.g. CodeableConcepts may contain text and/or
   * multiple codings, where the codings themselves contain a code and a system. For composite
   * search parameters, the outcome of the expression must a collection of base elements from which
   * the composites are derived.
   */
  public val expression: String? = null,
  /**
   * How the search parameter relates to the set of elements returned by evaluating the expression
   * query.
   */
  public val processingMode: Enumeration<SearchProcessingModeType>? = null,
  /**
   * FHIRPath expression that defines/sets a complex constraint for when this SearchParameter is
   * applicable.
   */
  public val constraint: String? = null,
  /**
   * Types of resource (if a resource is referenced).
   *
   * In some cases, targets may exist for a search parameter that do not exist for the specified
   * FHIRPath for all of the resources identified in SearchParameter.base. For example, the core
   * clinical-encounter search parameter allows both Encounter and EpisodeOfCare as targets, even
   * though not all of the base resources have EpisodeOfCare as a valid target.
   *
   * However, the list of targets SHOULD cover all targets that might appear that are permitted by
   * the specified FHIRPath.
   */
  public val target: List<Enumeration<VersionIndependentResourceTypesAll>> = listOf(),
  /**
   * Whether multiple values are allowed for each time the parameter exists. Values are separated by
   * commas, and the parameter matches if any of the values match.
   */
  public val multipleOr: Boolean? = null,
  /**
   * Whether multiple parameters are allowed - e.g. more than one parameter with the same name. The
   * search matches if all the parameters match.
   */
  public val multipleAnd: Boolean? = null,
  /**
   * Comparators supported for the search parameter.
   *
   * If no comparators are listed, clients should not expect servers to support any comparators.
   */
  public val comparator: List<Enumeration<SearchComparator>> = listOf(),
  /** A modifier supported for the search parameter. */
  public val modifier: List<Enumeration<SearchModifierCode>> = listOf(),
  /**
   * Contains the names of any search parameters which may be chained to the containing search
   * parameter. Chained parameters may be added to search parameters of type reference and specify
   * that resources will only be returned if they contain a reference to a resource which matches
   * the chained parameter value. Values for this field should be drawn from SearchParameter.code
   * for a parameter on the target resource type.
   *
   * Notes:
   * * Not all systems will declare chain values. If no chain values are specified at all, then no
   *   presumptions can be made about the degree of chaining support available
   * * A server may use a single chain value of '*' to mean that all reference search types
   *   supported can be chained rather than enumerating all chain values
   * * If a particular reference search parameter is supported, but not subsequent chaining, then
   *   just list that search parameter name - e.g. for Patient.practitioner, the chain value would
   *   be ```practitioner```
   * * If a particular reference search parameter is supported with unlimited chaining beneath it,
   *   then follow the search parameter name with '.'. E.g. ```practitioner.```
   * * If there are specific (not unlimited) chaining paths allowed they can be explicitly
   *   enumerated. E.g. ```practitioner.organization```
   */
  public val chain: List<String> = listOf(),
  /** Used to define the parts of a composite search parameter. */
  public val component: List<Component> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          url.toBuilder(),
          name.toBuilder(),
          status,
          description.toBuilder(),
          code.toBuilder(),
          base.toMutableList(),
          type,
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
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          version = this@with.version?.toBuilder()
          versionAlgorithm = this@with.versionAlgorithm
          title = this@with.title?.toBuilder()
          derivedFrom = this@with.derivedFrom?.toBuilder()
          experimental = this@with.experimental?.toBuilder()
          date = this@with.date?.toBuilder()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          purpose = this@with.purpose?.toBuilder()
          copyright = this@with.copyright?.toBuilder()
          copyrightLabel = this@with.copyrightLabel?.toBuilder()
          expression = this@with.expression?.toBuilder()
          processingMode = this@with.processingMode
          constraint = this@with.constraint?.toBuilder()
          target = this@with.target.toMutableList()
          multipleOr = this@with.multipleOr?.toBuilder()
          multipleAnd = this@with.multipleAnd?.toBuilder()
          comparator = this@with.comparator.toMutableList()
          modifier = this@with.modifier.toMutableList()
          chain = this@with.chain.map { it.toBuilder() }.toMutableList()
          component = this@with.component.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Used to define the parts of a composite search parameter. */
  @Serializable(with = SearchParameterComponentSerializer::class)
  public data class Component(
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
    /** The definition of the search parameter that describes this part. */
    public val definition: Canonical,
    /**
     * A sub-expression that defines how to extract values for this component from the output of the
     * main SearchParameter.expression.
     *
     * This expression overrides the expression in the definition and extracts the index values from
     * the outcome of the composite expression.
     */
    public val expression: String,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(definition.toBuilder(), expression.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The definition of the search parameter that describes this part. */
      public var definition: Canonical.Builder,
      /**
       * A sub-expression that defines how to extract values for this component from the output of
       * the main SearchParameter.expression.
       *
       * This expression overrides the expression in the definition and extracts the index values
       * from the outcome of the composite expression.
       */
      public var expression: String.Builder,
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

      public fun build(): Component =
        Component(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          definition = definition.build(),
          expression = expression.build(),
        )
    }
  }

  public sealed interface VersionAlgorithm {
    public fun asString(): String? = this as? String

    public fun asCoding(): Coding? = this as? Coding

    public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : VersionAlgorithm

    public data class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : VersionAlgorithm

    public companion object {
      internal fun from(
        stringValue: dev.ohs.fhir.model.r5.String?,
        codingValue: dev.ohs.fhir.model.r5.Coding?,
      ): VersionAlgorithm? {
        if (stringValue != null) return String(stringValue)
        if (codingValue != null) return Coding(codingValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * An absolute URI that is used to identify this search parameter when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance
     * of this search parameter is (or will be) published. This URL can be the target of a canonical
     * reference. It SHALL remain the same when the search parameter is stored on different servers.
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
    public var url: Uri.Builder,
    /**
     * A natural language name identifying the search parameter. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder,
    /**
     * The status of this search parameter. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of search parameters that are appropriate for use versus not.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * And how it used.
     *
     * This description can be used to capture details such as comments about misuse, instructions
     * for clinical use and interpretation, literature references, examples from the paper world,
     * etc. It is not a rendering of the search parameter as conveyed in the 'text' field of the
     * resource itself. This item SHOULD be populated unless the information is available from
     * context (e.g. the language of the search parameter is presumed to be the predominant language
     * in the place the search parameter was created).
     */
    public var description: Markdown.Builder,
    /**
     * The label that is recommended to be used in the URL or the parameter name in a parameters
     * resource for this search parameter. In some cases, servers may need to use a different
     * CapabilityStatement searchParam.name to differentiate between multiple SearchParameters that
     * happen to have the same code.
     *
     * For maximum compatibility, use only lowercase ASCII characters. Note that HL7 will never
     * define multiple search parameters with the same code.
     */
    public var code: Code.Builder,
    /**
     * The base resource type(s) that this search parameter can be used against.
     *
     * A search parameter must always apply to at least one resource type. When search parameters
     * apply to more than one resource type, they can be used against any of the listed resource
     * types, or in a cross-type search (see [Cross Resource Search](http.html#xres-search)).
     */
    public var base: MutableList<Enumeration<VersionIndependentResourceTypesAll>>,
    /**
     * The type of value that a search parameter may contain, and how the content is interpreted.
     */
    public var type: Enumeration<SearchParamType>,
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
     * A formal identifier that is used to identify this search parameter when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the search parameter when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the search parameter author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different search parameter instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the search parameter with the format [url]|[version]. The
     * version SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
     */
    public var version: String.Builder? = null

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     *
     * If set as a string, this is a FHIRPath expression that has two additional context variables
     * passed in - %version1 and %version2 and will return a negative number if version1 is newer, a
     * positive number if version2 and a 0 if the version ordering can't be successfully be
     * determined.
     */
    public var versionAlgorithm: VersionAlgorithm? = null

    /**
     * A short, descriptive, user-friendly title for the search parameter.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * Where this search parameter is originally defined. If a derivedFrom is provided, then the
     * details in the search parameter must be consistent with the definition from which it is
     * defined. i.e. the parameter should have the same meaning, and (usually) the functionality
     * should be a proper subset of the underlying search parameter.
     *
     * The intent of this is that a server can designate that it provides support for a search
     * parameter defined in the specification itself (e.g.
     * [`value-quantity`](http://hl7.org/fhir/SearchParameter/Observation-value-quantity), but
     * detail how it is supported by the server.
     */
    public var derivedFrom: Canonical.Builder? = null

    /**
     * A Boolean value to indicate that this search parameter is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of search parameters that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the search parameter was last significantly changed. The
     * date must change when the business version changes and it must change if the status code
     * changes. In addition, it should change when the substantive content of the search parameter
     * changes.
     *
     * The date is often not tracked until the resource is published, but may be present on draft
     * content. Note that this is not the same as the resource last-modified-date, since the
     * resource may be a secondary representation of the search parameter. Additional specific dates
     * may be added as extensions or be found by consulting Provenances associated with past
     * versions of the resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual tresponsible for the release and ongoing
     * maintenance of the search parameter.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the search
     * parameter is the organization or individual primarily responsible for the maintenance and
     * upkeep of the search parameter. This is not necessarily the same individual or organization
     * that developed and initially authored the content. The publisher is the primary point of
     * contact for questions or issues with the search parameter. This item SHOULD be populated
     * unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate search parameter instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the search parameter is intended to be used.
     *
     * It may be possible for the search parameter to be used in jurisdictions other than those for
     * which it was originally designed or intended.
     *
     * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
     * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
     * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
     * useContext.valueCodeableConcept indicating the jurisdiction.)
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this search parameter is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the search parameter. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * search parameter.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the search parameter and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the search
     * parameter.
     *
     * ...
     */
    public var copyright: Markdown.Builder? = null

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the
     * copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All
     * rights reserved', 'Some rights reserved').
     *
     * The (c) symbol should NOT be included in this string. It will be added by software when
     * rendering the notation. Full details about licensing, restrictions, warrantees, etc. goes in
     * the more general 'copyright' element.
     */
    public var copyrightLabel: String.Builder? = null

    /**
     * A FHIRPath expression that returns a set of elements for the search parameter.
     *
     * Note that the elements returned by the expression are sometimes complex elements where logic
     * is required to determine quite how to handle them; e.g. CodeableConcepts may contain text
     * and/or multiple codings, where the codings themselves contain a code and a system. For
     * composite search parameters, the outcome of the expression must a collection of base elements
     * from which the composites are derived.
     */
    public var expression: String.Builder? = null

    /**
     * How the search parameter relates to the set of elements returned by evaluating the expression
     * query.
     */
    public var processingMode: Enumeration<SearchProcessingModeType>? = null

    /**
     * FHIRPath expression that defines/sets a complex constraint for when this SearchParameter is
     * applicable.
     */
    public var constraint: String.Builder? = null

    /**
     * Types of resource (if a resource is referenced).
     *
     * In some cases, targets may exist for a search parameter that do not exist for the specified
     * FHIRPath for all of the resources identified in SearchParameter.base. For example, the core
     * clinical-encounter search parameter allows both Encounter and EpisodeOfCare as targets, even
     * though not all of the base resources have EpisodeOfCare as a valid target.
     *
     * However, the list of targets SHOULD cover all targets that might appear that are permitted by
     * the specified FHIRPath.
     */
    public var target: MutableList<Enumeration<VersionIndependentResourceTypesAll>> =
      mutableListOf()

    /**
     * Whether multiple values are allowed for each time the parameter exists. Values are separated
     * by commas, and the parameter matches if any of the values match.
     */
    public var multipleOr: Boolean.Builder? = null

    /**
     * Whether multiple parameters are allowed - e.g. more than one parameter with the same name.
     * The search matches if all the parameters match.
     */
    public var multipleAnd: Boolean.Builder? = null

    /**
     * Comparators supported for the search parameter.
     *
     * If no comparators are listed, clients should not expect servers to support any comparators.
     */
    public var comparator: MutableList<Enumeration<SearchComparator>> = mutableListOf()

    /** A modifier supported for the search parameter. */
    public var modifier: MutableList<Enumeration<SearchModifierCode>> = mutableListOf()

    /**
     * Contains the names of any search parameters which may be chained to the containing search
     * parameter. Chained parameters may be added to search parameters of type reference and specify
     * that resources will only be returned if they contain a reference to a resource which matches
     * the chained parameter value. Values for this field should be drawn from SearchParameter.code
     * for a parameter on the target resource type.
     *
     * Notes:
     * * Not all systems will declare chain values. If no chain values are specified at all, then no
     *   presumptions can be made about the degree of chaining support available
     * * A server may use a single chain value of '*' to mean that all reference search types
     *   supported can be chained rather than enumerating all chain values
     * * If a particular reference search parameter is supported, but not subsequent chaining, then
     *   just list that search parameter name - e.g. for Patient.practitioner, the chain value would
     *   be ```practitioner```
     * * If a particular reference search parameter is supported with unlimited chaining beneath it,
     *   then follow the search parameter name with '.'. E.g. ```practitioner.```
     * * If there are specific (not unlimited) chaining paths allowed they can be explicitly
     *   enumerated. E.g. ```practitioner.organization```
     */
    public var chain: MutableList<String.Builder> = mutableListOf()

    /** Used to define the parts of a composite search parameter. */
    public var component: MutableList<Component.Builder> = mutableListOf()

    override fun build(): SearchParameter =
      SearchParameter(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url.build(),
        identifier = identifier.map { it.build() },
        version = version?.build(),
        versionAlgorithm = versionAlgorithm,
        name = name.build(),
        title = title?.build(),
        derivedFrom = derivedFrom?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        copyrightLabel = copyrightLabel?.build(),
        code = code.build(),
        base = base,
        type = type,
        expression = expression?.build(),
        processingMode = processingMode,
        constraint = constraint?.build(),
        target = target,
        multipleOr = multipleOr?.build(),
        multipleAnd = multipleAnd?.build(),
        comparator = comparator,
        modifier = modifier,
        chain = chain.map { it.build() },
        component = component.map { it.build() },
      )
  }

  /** Current and past FHIR resource types (deleted or renamed), including abstract types */
  public enum class VersionIndependentResourceTypesAll(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Account("Account", "http://hl7.org/fhir/fhir-types", "Account"),
    ActivityDefinition(
      "ActivityDefinition",
      "http://hl7.org/fhir/fhir-types",
      "ActivityDefinition",
    ),
    ActorDefinition("ActorDefinition", "http://hl7.org/fhir/fhir-types", "ActorDefinition"),
    AdministrableProductDefinition(
      "AdministrableProductDefinition",
      "http://hl7.org/fhir/fhir-types",
      "AdministrableProductDefinition",
    ),
    AdverseEvent("AdverseEvent", "http://hl7.org/fhir/fhir-types", "AdverseEvent"),
    AllergyIntolerance(
      "AllergyIntolerance",
      "http://hl7.org/fhir/fhir-types",
      "AllergyIntolerance",
    ),
    Appointment("Appointment", "http://hl7.org/fhir/fhir-types", "Appointment"),
    AppointmentResponse(
      "AppointmentResponse",
      "http://hl7.org/fhir/fhir-types",
      "AppointmentResponse",
    ),
    ArtifactAssessment(
      "ArtifactAssessment",
      "http://hl7.org/fhir/fhir-types",
      "ArtifactAssessment",
    ),
    AuditEvent("AuditEvent", "http://hl7.org/fhir/fhir-types", "AuditEvent"),
    Basic("Basic", "http://hl7.org/fhir/fhir-types", "Basic"),
    Binary("Binary", "http://hl7.org/fhir/fhir-types", "Binary"),
    BiologicallyDerivedProduct(
      "BiologicallyDerivedProduct",
      "http://hl7.org/fhir/fhir-types",
      "BiologicallyDerivedProduct",
    ),
    BiologicallyDerivedProductDispense(
      "BiologicallyDerivedProductDispense",
      "http://hl7.org/fhir/fhir-types",
      "BiologicallyDerivedProductDispense",
    ),
    BodyStructure("BodyStructure", "http://hl7.org/fhir/fhir-types", "BodyStructure"),
    Bundle("Bundle", "http://hl7.org/fhir/fhir-types", "Bundle"),
    CanonicalResource("CanonicalResource", "http://hl7.org/fhir/fhir-types", "CanonicalResource"),
    CapabilityStatement(
      "CapabilityStatement",
      "http://hl7.org/fhir/fhir-types",
      "CapabilityStatement",
    ),
    CarePlan("CarePlan", "http://hl7.org/fhir/fhir-types", "CarePlan"),
    CareTeam("CareTeam", "http://hl7.org/fhir/fhir-types", "CareTeam"),
    ChargeItem("ChargeItem", "http://hl7.org/fhir/fhir-types", "ChargeItem"),
    ChargeItemDefinition(
      "ChargeItemDefinition",
      "http://hl7.org/fhir/fhir-types",
      "ChargeItemDefinition",
    ),
    Citation("Citation", "http://hl7.org/fhir/fhir-types", "Citation"),
    Claim("Claim", "http://hl7.org/fhir/fhir-types", "Claim"),
    ClaimResponse("ClaimResponse", "http://hl7.org/fhir/fhir-types", "ClaimResponse"),
    ClinicalImpression(
      "ClinicalImpression",
      "http://hl7.org/fhir/fhir-types",
      "ClinicalImpression",
    ),
    ClinicalUseDefinition(
      "ClinicalUseDefinition",
      "http://hl7.org/fhir/fhir-types",
      "ClinicalUseDefinition",
    ),
    CodeSystem("CodeSystem", "http://hl7.org/fhir/fhir-types", "CodeSystem"),
    Communication("Communication", "http://hl7.org/fhir/fhir-types", "Communication"),
    CommunicationRequest(
      "CommunicationRequest",
      "http://hl7.org/fhir/fhir-types",
      "CommunicationRequest",
    ),
    CompartmentDefinition(
      "CompartmentDefinition",
      "http://hl7.org/fhir/fhir-types",
      "CompartmentDefinition",
    ),
    Composition("Composition", "http://hl7.org/fhir/fhir-types", "Composition"),
    ConceptMap("ConceptMap", "http://hl7.org/fhir/fhir-types", "ConceptMap"),
    Condition("Condition", "http://hl7.org/fhir/fhir-types", "Condition"),
    ConditionDefinition(
      "ConditionDefinition",
      "http://hl7.org/fhir/fhir-types",
      "ConditionDefinition",
    ),
    Consent("Consent", "http://hl7.org/fhir/fhir-types", "Consent"),
    Contract("Contract", "http://hl7.org/fhir/fhir-types", "Contract"),
    Coverage("Coverage", "http://hl7.org/fhir/fhir-types", "Coverage"),
    CoverageEligibilityRequest(
      "CoverageEligibilityRequest",
      "http://hl7.org/fhir/fhir-types",
      "CoverageEligibilityRequest",
    ),
    CoverageEligibilityResponse(
      "CoverageEligibilityResponse",
      "http://hl7.org/fhir/fhir-types",
      "CoverageEligibilityResponse",
    ),
    DetectedIssue("DetectedIssue", "http://hl7.org/fhir/fhir-types", "DetectedIssue"),
    Device("Device", "http://hl7.org/fhir/fhir-types", "Device"),
    DeviceAssociation("DeviceAssociation", "http://hl7.org/fhir/fhir-types", "DeviceAssociation"),
    DeviceDefinition("DeviceDefinition", "http://hl7.org/fhir/fhir-types", "DeviceDefinition"),
    DeviceDispense("DeviceDispense", "http://hl7.org/fhir/fhir-types", "DeviceDispense"),
    DeviceMetric("DeviceMetric", "http://hl7.org/fhir/fhir-types", "DeviceMetric"),
    DeviceRequest("DeviceRequest", "http://hl7.org/fhir/fhir-types", "DeviceRequest"),
    DeviceUsage("DeviceUsage", "http://hl7.org/fhir/fhir-types", "DeviceUsage"),
    DiagnosticReport("DiagnosticReport", "http://hl7.org/fhir/fhir-types", "DiagnosticReport"),
    DocumentReference("DocumentReference", "http://hl7.org/fhir/fhir-types", "DocumentReference"),
    DomainResource("DomainResource", "http://hl7.org/fhir/fhir-types", "DomainResource"),
    Encounter("Encounter", "http://hl7.org/fhir/fhir-types", "Encounter"),
    EncounterHistory("EncounterHistory", "http://hl7.org/fhir/fhir-types", "EncounterHistory"),
    Endpoint("Endpoint", "http://hl7.org/fhir/fhir-types", "Endpoint"),
    EnrollmentRequest("EnrollmentRequest", "http://hl7.org/fhir/fhir-types", "EnrollmentRequest"),
    EnrollmentResponse(
      "EnrollmentResponse",
      "http://hl7.org/fhir/fhir-types",
      "EnrollmentResponse",
    ),
    EpisodeOfCare("EpisodeOfCare", "http://hl7.org/fhir/fhir-types", "EpisodeOfCare"),
    EventDefinition("EventDefinition", "http://hl7.org/fhir/fhir-types", "EventDefinition"),
    Evidence("Evidence", "http://hl7.org/fhir/fhir-types", "Evidence"),
    EvidenceReport("EvidenceReport", "http://hl7.org/fhir/fhir-types", "EvidenceReport"),
    EvidenceVariable("EvidenceVariable", "http://hl7.org/fhir/fhir-types", "EvidenceVariable"),
    ExampleScenario("ExampleScenario", "http://hl7.org/fhir/fhir-types", "ExampleScenario"),
    ExplanationOfBenefit(
      "ExplanationOfBenefit",
      "http://hl7.org/fhir/fhir-types",
      "ExplanationOfBenefit",
    ),
    FamilyMemberHistory(
      "FamilyMemberHistory",
      "http://hl7.org/fhir/fhir-types",
      "FamilyMemberHistory",
    ),
    Flag("Flag", "http://hl7.org/fhir/fhir-types", "Flag"),
    FormularyItem("FormularyItem", "http://hl7.org/fhir/fhir-types", "FormularyItem"),
    GenomicStudy("GenomicStudy", "http://hl7.org/fhir/fhir-types", "GenomicStudy"),
    Goal("Goal", "http://hl7.org/fhir/fhir-types", "Goal"),
    GraphDefinition("GraphDefinition", "http://hl7.org/fhir/fhir-types", "GraphDefinition"),
    Group("Group", "http://hl7.org/fhir/fhir-types", "Group"),
    GuidanceResponse("GuidanceResponse", "http://hl7.org/fhir/fhir-types", "GuidanceResponse"),
    HealthcareService("HealthcareService", "http://hl7.org/fhir/fhir-types", "HealthcareService"),
    ImagingSelection("ImagingSelection", "http://hl7.org/fhir/fhir-types", "ImagingSelection"),
    ImagingStudy("ImagingStudy", "http://hl7.org/fhir/fhir-types", "ImagingStudy"),
    Immunization("Immunization", "http://hl7.org/fhir/fhir-types", "Immunization"),
    ImmunizationEvaluation(
      "ImmunizationEvaluation",
      "http://hl7.org/fhir/fhir-types",
      "ImmunizationEvaluation",
    ),
    ImmunizationRecommendation(
      "ImmunizationRecommendation",
      "http://hl7.org/fhir/fhir-types",
      "ImmunizationRecommendation",
    ),
    ImplementationGuide(
      "ImplementationGuide",
      "http://hl7.org/fhir/fhir-types",
      "ImplementationGuide",
    ),
    Ingredient("Ingredient", "http://hl7.org/fhir/fhir-types", "Ingredient"),
    InsurancePlan("InsurancePlan", "http://hl7.org/fhir/fhir-types", "InsurancePlan"),
    InventoryItem("InventoryItem", "http://hl7.org/fhir/fhir-types", "InventoryItem"),
    InventoryReport("InventoryReport", "http://hl7.org/fhir/fhir-types", "InventoryReport"),
    Invoice("Invoice", "http://hl7.org/fhir/fhir-types", "Invoice"),
    Library("Library", "http://hl7.org/fhir/fhir-types", "Library"),
    Linkage("Linkage", "http://hl7.org/fhir/fhir-types", "Linkage"),
    List("List", "http://hl7.org/fhir/fhir-types", "List"),
    Location("Location", "http://hl7.org/fhir/fhir-types", "Location"),
    ManufacturedItemDefinition(
      "ManufacturedItemDefinition",
      "http://hl7.org/fhir/fhir-types",
      "ManufacturedItemDefinition",
    ),
    Measure("Measure", "http://hl7.org/fhir/fhir-types", "Measure"),
    MeasureReport("MeasureReport", "http://hl7.org/fhir/fhir-types", "MeasureReport"),
    Medication("Medication", "http://hl7.org/fhir/fhir-types", "Medication"),
    MedicationAdministration(
      "MedicationAdministration",
      "http://hl7.org/fhir/fhir-types",
      "MedicationAdministration",
    ),
    MedicationDispense(
      "MedicationDispense",
      "http://hl7.org/fhir/fhir-types",
      "MedicationDispense",
    ),
    MedicationKnowledge(
      "MedicationKnowledge",
      "http://hl7.org/fhir/fhir-types",
      "MedicationKnowledge",
    ),
    MedicationRequest("MedicationRequest", "http://hl7.org/fhir/fhir-types", "MedicationRequest"),
    MedicationStatement(
      "MedicationStatement",
      "http://hl7.org/fhir/fhir-types",
      "MedicationStatement",
    ),
    MedicinalProductDefinition(
      "MedicinalProductDefinition",
      "http://hl7.org/fhir/fhir-types",
      "MedicinalProductDefinition",
    ),
    MessageDefinition("MessageDefinition", "http://hl7.org/fhir/fhir-types", "MessageDefinition"),
    MessageHeader("MessageHeader", "http://hl7.org/fhir/fhir-types", "MessageHeader"),
    MetadataResource("MetadataResource", "http://hl7.org/fhir/fhir-types", "MetadataResource"),
    MolecularSequence("MolecularSequence", "http://hl7.org/fhir/fhir-types", "MolecularSequence"),
    NamingSystem("NamingSystem", "http://hl7.org/fhir/fhir-types", "NamingSystem"),
    NutritionIntake("NutritionIntake", "http://hl7.org/fhir/fhir-types", "NutritionIntake"),
    NutritionOrder("NutritionOrder", "http://hl7.org/fhir/fhir-types", "NutritionOrder"),
    NutritionProduct("NutritionProduct", "http://hl7.org/fhir/fhir-types", "NutritionProduct"),
    Observation("Observation", "http://hl7.org/fhir/fhir-types", "Observation"),
    ObservationDefinition(
      "ObservationDefinition",
      "http://hl7.org/fhir/fhir-types",
      "ObservationDefinition",
    ),
    OperationDefinition(
      "OperationDefinition",
      "http://hl7.org/fhir/fhir-types",
      "OperationDefinition",
    ),
    OperationOutcome("OperationOutcome", "http://hl7.org/fhir/fhir-types", "OperationOutcome"),
    Organization("Organization", "http://hl7.org/fhir/fhir-types", "Organization"),
    OrganizationAffiliation(
      "OrganizationAffiliation",
      "http://hl7.org/fhir/fhir-types",
      "OrganizationAffiliation",
    ),
    PackagedProductDefinition(
      "PackagedProductDefinition",
      "http://hl7.org/fhir/fhir-types",
      "PackagedProductDefinition",
    ),
    Parameters("Parameters", "http://hl7.org/fhir/fhir-types", "Parameters"),
    Patient("Patient", "http://hl7.org/fhir/fhir-types", "Patient"),
    PaymentNotice("PaymentNotice", "http://hl7.org/fhir/fhir-types", "PaymentNotice"),
    PaymentReconciliation(
      "PaymentReconciliation",
      "http://hl7.org/fhir/fhir-types",
      "PaymentReconciliation",
    ),
    Permission("Permission", "http://hl7.org/fhir/fhir-types", "Permission"),
    Person("Person", "http://hl7.org/fhir/fhir-types", "Person"),
    PlanDefinition("PlanDefinition", "http://hl7.org/fhir/fhir-types", "PlanDefinition"),
    Practitioner("Practitioner", "http://hl7.org/fhir/fhir-types", "Practitioner"),
    PractitionerRole("PractitionerRole", "http://hl7.org/fhir/fhir-types", "PractitionerRole"),
    Procedure("Procedure", "http://hl7.org/fhir/fhir-types", "Procedure"),
    Provenance("Provenance", "http://hl7.org/fhir/fhir-types", "Provenance"),
    Questionnaire("Questionnaire", "http://hl7.org/fhir/fhir-types", "Questionnaire"),
    QuestionnaireResponse(
      "QuestionnaireResponse",
      "http://hl7.org/fhir/fhir-types",
      "QuestionnaireResponse",
    ),
    RegulatedAuthorization(
      "RegulatedAuthorization",
      "http://hl7.org/fhir/fhir-types",
      "RegulatedAuthorization",
    ),
    RelatedPerson("RelatedPerson", "http://hl7.org/fhir/fhir-types", "RelatedPerson"),
    RequestOrchestration(
      "RequestOrchestration",
      "http://hl7.org/fhir/fhir-types",
      "RequestOrchestration",
    ),
    Requirements("Requirements", "http://hl7.org/fhir/fhir-types", "Requirements"),
    ResearchStudy("ResearchStudy", "http://hl7.org/fhir/fhir-types", "ResearchStudy"),
    ResearchSubject("ResearchSubject", "http://hl7.org/fhir/fhir-types", "ResearchSubject"),
    Resource("Resource", "http://hl7.org/fhir/fhir-types", "Resource"),
    RiskAssessment("RiskAssessment", "http://hl7.org/fhir/fhir-types", "RiskAssessment"),
    Schedule("Schedule", "http://hl7.org/fhir/fhir-types", "Schedule"),
    SearchParameter("SearchParameter", "http://hl7.org/fhir/fhir-types", "SearchParameter"),
    ServiceRequest("ServiceRequest", "http://hl7.org/fhir/fhir-types", "ServiceRequest"),
    Slot("Slot", "http://hl7.org/fhir/fhir-types", "Slot"),
    Specimen("Specimen", "http://hl7.org/fhir/fhir-types", "Specimen"),
    SpecimenDefinition(
      "SpecimenDefinition",
      "http://hl7.org/fhir/fhir-types",
      "SpecimenDefinition",
    ),
    StructureDefinition(
      "StructureDefinition",
      "http://hl7.org/fhir/fhir-types",
      "StructureDefinition",
    ),
    StructureMap("StructureMap", "http://hl7.org/fhir/fhir-types", "StructureMap"),
    Subscription("Subscription", "http://hl7.org/fhir/fhir-types", "Subscription"),
    SubscriptionStatus(
      "SubscriptionStatus",
      "http://hl7.org/fhir/fhir-types",
      "SubscriptionStatus",
    ),
    SubscriptionTopic("SubscriptionTopic", "http://hl7.org/fhir/fhir-types", "SubscriptionTopic"),
    Substance("Substance", "http://hl7.org/fhir/fhir-types", "Substance"),
    SubstanceDefinition(
      "SubstanceDefinition",
      "http://hl7.org/fhir/fhir-types",
      "SubstanceDefinition",
    ),
    SubstanceNucleicAcid(
      "SubstanceNucleicAcid",
      "http://hl7.org/fhir/fhir-types",
      "SubstanceNucleicAcid",
    ),
    SubstancePolymer("SubstancePolymer", "http://hl7.org/fhir/fhir-types", "SubstancePolymer"),
    SubstanceProtein("SubstanceProtein", "http://hl7.org/fhir/fhir-types", "SubstanceProtein"),
    SubstanceReferenceInformation(
      "SubstanceReferenceInformation",
      "http://hl7.org/fhir/fhir-types",
      "SubstanceReferenceInformation",
    ),
    SubstanceSourceMaterial(
      "SubstanceSourceMaterial",
      "http://hl7.org/fhir/fhir-types",
      "SubstanceSourceMaterial",
    ),
    SupplyDelivery("SupplyDelivery", "http://hl7.org/fhir/fhir-types", "SupplyDelivery"),
    SupplyRequest("SupplyRequest", "http://hl7.org/fhir/fhir-types", "SupplyRequest"),
    Task("Task", "http://hl7.org/fhir/fhir-types", "Task"),
    TerminologyCapabilities(
      "TerminologyCapabilities",
      "http://hl7.org/fhir/fhir-types",
      "TerminologyCapabilities",
    ),
    TestPlan("TestPlan", "http://hl7.org/fhir/fhir-types", "TestPlan"),
    TestReport("TestReport", "http://hl7.org/fhir/fhir-types", "TestReport"),
    TestScript("TestScript", "http://hl7.org/fhir/fhir-types", "TestScript"),
    Transport("Transport", "http://hl7.org/fhir/fhir-types", "Transport"),
    ValueSet("ValueSet", "http://hl7.org/fhir/fhir-types", "ValueSet"),
    VerificationResult(
      "VerificationResult",
      "http://hl7.org/fhir/fhir-types",
      "VerificationResult",
    ),
    VisionPrescription(
      "VisionPrescription",
      "http://hl7.org/fhir/fhir-types",
      "VisionPrescription",
    ),
    BodySite("BodySite", "http://hl7.org/fhir/fhir-old-types", "BodySite"),
    CatalogEntry("CatalogEntry", "http://hl7.org/fhir/fhir-old-types", "CatalogEntry"),
    Conformance("Conformance", "http://hl7.org/fhir/fhir-old-types", "Conformance"),
    DataElement("DataElement", "http://hl7.org/fhir/fhir-old-types", "DataElement"),
    DeviceComponent("DeviceComponent", "http://hl7.org/fhir/fhir-old-types", "DeviceComponent"),
    DeviceUseRequest("DeviceUseRequest", "http://hl7.org/fhir/fhir-old-types", "DeviceUseRequest"),
    DeviceUseStatement(
      "DeviceUseStatement",
      "http://hl7.org/fhir/fhir-old-types",
      "DeviceUseStatement",
    ),
    DiagnosticOrder("DiagnosticOrder", "http://hl7.org/fhir/fhir-old-types", "DiagnosticOrder"),
    DocumentManifest("DocumentManifest", "http://hl7.org/fhir/fhir-old-types", "DocumentManifest"),
    EffectEvidenceSynthesis(
      "EffectEvidenceSynthesis",
      "http://hl7.org/fhir/fhir-old-types",
      "EffectEvidenceSynthesis",
    ),
    EligibilityRequest(
      "EligibilityRequest",
      "http://hl7.org/fhir/fhir-old-types",
      "EligibilityRequest",
    ),
    EligibilityResponse(
      "EligibilityResponse",
      "http://hl7.org/fhir/fhir-old-types",
      "EligibilityResponse",
    ),
    ExpansionProfile("ExpansionProfile", "http://hl7.org/fhir/fhir-old-types", "ExpansionProfile"),
    ImagingManifest("ImagingManifest", "http://hl7.org/fhir/fhir-old-types", "ImagingManifest"),
    ImagingObjectSelection(
      "ImagingObjectSelection",
      "http://hl7.org/fhir/fhir-old-types",
      "ImagingObjectSelection",
    ),
    Media("Media", "http://hl7.org/fhir/fhir-old-types", "Media"),
    MedicationOrder("MedicationOrder", "http://hl7.org/fhir/fhir-old-types", "MedicationOrder"),
    MedicationUsage("MedicationUsage", "http://hl7.org/fhir/fhir-old-types", "MedicationUsage"),
    MedicinalProduct("MedicinalProduct", "http://hl7.org/fhir/fhir-old-types", "MedicinalProduct"),
    MedicinalProductAuthorization(
      "MedicinalProductAuthorization",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductAuthorization",
    ),
    MedicinalProductContraindication(
      "MedicinalProductContraindication",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductContraindication",
    ),
    MedicinalProductIndication(
      "MedicinalProductIndication",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductIndication",
    ),
    MedicinalProductIngredient(
      "MedicinalProductIngredient",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductIngredient",
    ),
    MedicinalProductInteraction(
      "MedicinalProductInteraction",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductInteraction",
    ),
    MedicinalProductManufactured(
      "MedicinalProductManufactured",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductManufactured",
    ),
    MedicinalProductPackaged(
      "MedicinalProductPackaged",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductPackaged",
    ),
    MedicinalProductPharmaceutical(
      "MedicinalProductPharmaceutical",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductPharmaceutical",
    ),
    MedicinalProductUndesirableEffect(
      "MedicinalProductUndesirableEffect",
      "http://hl7.org/fhir/fhir-old-types",
      "MedicinalProductUndesirableEffect",
    ),
    Order("Order", "http://hl7.org/fhir/fhir-old-types", "Order"),
    OrderResponse("OrderResponse", "http://hl7.org/fhir/fhir-old-types", "OrderResponse"),
    ProcedureRequest("ProcedureRequest", "http://hl7.org/fhir/fhir-old-types", "ProcedureRequest"),
    ProcessRequest("ProcessRequest", "http://hl7.org/fhir/fhir-old-types", "ProcessRequest"),
    ProcessResponse("ProcessResponse", "http://hl7.org/fhir/fhir-old-types", "ProcessResponse"),
    ReferralRequest("ReferralRequest", "http://hl7.org/fhir/fhir-old-types", "ReferralRequest"),
    RequestGroup("RequestGroup", "http://hl7.org/fhir/fhir-old-types", "RequestGroup"),
    ResearchDefinition(
      "ResearchDefinition",
      "http://hl7.org/fhir/fhir-old-types",
      "ResearchDefinition",
    ),
    ResearchElementDefinition(
      "ResearchElementDefinition",
      "http://hl7.org/fhir/fhir-old-types",
      "ResearchElementDefinition",
    ),
    RiskEvidenceSynthesis(
      "RiskEvidenceSynthesis",
      "http://hl7.org/fhir/fhir-old-types",
      "RiskEvidenceSynthesis",
    ),
    Sequence("Sequence", "http://hl7.org/fhir/fhir-old-types", "Sequence"),
    ServiceDefinition(
      "ServiceDefinition",
      "http://hl7.org/fhir/fhir-old-types",
      "ServiceDefinition",
    ),
    SubstanceSpecification(
      "SubstanceSpecification",
      "http://hl7.org/fhir/fhir-old-types",
      "SubstanceSpecification",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): VersionIndependentResourceTypesAll =
        when (code) {
          "Account" -> Account
          "ActivityDefinition" -> ActivityDefinition
          "ActorDefinition" -> ActorDefinition
          "AdministrableProductDefinition" -> AdministrableProductDefinition
          "AdverseEvent" -> AdverseEvent
          "AllergyIntolerance" -> AllergyIntolerance
          "Appointment" -> Appointment
          "AppointmentResponse" -> AppointmentResponse
          "ArtifactAssessment" -> ArtifactAssessment
          "AuditEvent" -> AuditEvent
          "Basic" -> Basic
          "Binary" -> Binary
          "BiologicallyDerivedProduct" -> BiologicallyDerivedProduct
          "BiologicallyDerivedProductDispense" -> BiologicallyDerivedProductDispense
          "BodyStructure" -> BodyStructure
          "Bundle" -> Bundle
          "CanonicalResource" -> CanonicalResource
          "CapabilityStatement" -> CapabilityStatement
          "CarePlan" -> CarePlan
          "CareTeam" -> CareTeam
          "ChargeItem" -> ChargeItem
          "ChargeItemDefinition" -> ChargeItemDefinition
          "Citation" -> Citation
          "Claim" -> Claim
          "ClaimResponse" -> ClaimResponse
          "ClinicalImpression" -> ClinicalImpression
          "ClinicalUseDefinition" -> ClinicalUseDefinition
          "CodeSystem" -> CodeSystem
          "Communication" -> Communication
          "CommunicationRequest" -> CommunicationRequest
          "CompartmentDefinition" -> CompartmentDefinition
          "Composition" -> Composition
          "ConceptMap" -> ConceptMap
          "Condition" -> Condition
          "ConditionDefinition" -> ConditionDefinition
          "Consent" -> Consent
          "Contract" -> Contract
          "Coverage" -> Coverage
          "CoverageEligibilityRequest" -> CoverageEligibilityRequest
          "CoverageEligibilityResponse" -> CoverageEligibilityResponse
          "DetectedIssue" -> DetectedIssue
          "Device" -> Device
          "DeviceAssociation" -> DeviceAssociation
          "DeviceDefinition" -> DeviceDefinition
          "DeviceDispense" -> DeviceDispense
          "DeviceMetric" -> DeviceMetric
          "DeviceRequest" -> DeviceRequest
          "DeviceUsage" -> DeviceUsage
          "DiagnosticReport" -> DiagnosticReport
          "DocumentReference" -> DocumentReference
          "DomainResource" -> DomainResource
          "Encounter" -> Encounter
          "EncounterHistory" -> EncounterHistory
          "Endpoint" -> Endpoint
          "EnrollmentRequest" -> EnrollmentRequest
          "EnrollmentResponse" -> EnrollmentResponse
          "EpisodeOfCare" -> EpisodeOfCare
          "EventDefinition" -> EventDefinition
          "Evidence" -> Evidence
          "EvidenceReport" -> EvidenceReport
          "EvidenceVariable" -> EvidenceVariable
          "ExampleScenario" -> ExampleScenario
          "ExplanationOfBenefit" -> ExplanationOfBenefit
          "FamilyMemberHistory" -> FamilyMemberHistory
          "Flag" -> Flag
          "FormularyItem" -> FormularyItem
          "GenomicStudy" -> GenomicStudy
          "Goal" -> Goal
          "GraphDefinition" -> GraphDefinition
          "Group" -> Group
          "GuidanceResponse" -> GuidanceResponse
          "HealthcareService" -> HealthcareService
          "ImagingSelection" -> ImagingSelection
          "ImagingStudy" -> ImagingStudy
          "Immunization" -> Immunization
          "ImmunizationEvaluation" -> ImmunizationEvaluation
          "ImmunizationRecommendation" -> ImmunizationRecommendation
          "ImplementationGuide" -> ImplementationGuide
          "Ingredient" -> Ingredient
          "InsurancePlan" -> InsurancePlan
          "InventoryItem" -> InventoryItem
          "InventoryReport" -> InventoryReport
          "Invoice" -> Invoice
          "Library" -> Library
          "Linkage" -> Linkage
          "List" -> List
          "Location" -> Location
          "ManufacturedItemDefinition" -> ManufacturedItemDefinition
          "Measure" -> Measure
          "MeasureReport" -> MeasureReport
          "Medication" -> Medication
          "MedicationAdministration" -> MedicationAdministration
          "MedicationDispense" -> MedicationDispense
          "MedicationKnowledge" -> MedicationKnowledge
          "MedicationRequest" -> MedicationRequest
          "MedicationStatement" -> MedicationStatement
          "MedicinalProductDefinition" -> MedicinalProductDefinition
          "MessageDefinition" -> MessageDefinition
          "MessageHeader" -> MessageHeader
          "MetadataResource" -> MetadataResource
          "MolecularSequence" -> MolecularSequence
          "NamingSystem" -> NamingSystem
          "NutritionIntake" -> NutritionIntake
          "NutritionOrder" -> NutritionOrder
          "NutritionProduct" -> NutritionProduct
          "Observation" -> Observation
          "ObservationDefinition" -> ObservationDefinition
          "OperationDefinition" -> OperationDefinition
          "OperationOutcome" -> OperationOutcome
          "Organization" -> Organization
          "OrganizationAffiliation" -> OrganizationAffiliation
          "PackagedProductDefinition" -> PackagedProductDefinition
          "Parameters" -> Parameters
          "Patient" -> Patient
          "PaymentNotice" -> PaymentNotice
          "PaymentReconciliation" -> PaymentReconciliation
          "Permission" -> Permission
          "Person" -> Person
          "PlanDefinition" -> PlanDefinition
          "Practitioner" -> Practitioner
          "PractitionerRole" -> PractitionerRole
          "Procedure" -> Procedure
          "Provenance" -> Provenance
          "Questionnaire" -> Questionnaire
          "QuestionnaireResponse" -> QuestionnaireResponse
          "RegulatedAuthorization" -> RegulatedAuthorization
          "RelatedPerson" -> RelatedPerson
          "RequestOrchestration" -> RequestOrchestration
          "Requirements" -> Requirements
          "ResearchStudy" -> ResearchStudy
          "ResearchSubject" -> ResearchSubject
          "Resource" -> Resource
          "RiskAssessment" -> RiskAssessment
          "Schedule" -> Schedule
          "SearchParameter" -> SearchParameter
          "ServiceRequest" -> ServiceRequest
          "Slot" -> Slot
          "Specimen" -> Specimen
          "SpecimenDefinition" -> SpecimenDefinition
          "StructureDefinition" -> StructureDefinition
          "StructureMap" -> StructureMap
          "Subscription" -> Subscription
          "SubscriptionStatus" -> SubscriptionStatus
          "SubscriptionTopic" -> SubscriptionTopic
          "Substance" -> Substance
          "SubstanceDefinition" -> SubstanceDefinition
          "SubstanceNucleicAcid" -> SubstanceNucleicAcid
          "SubstancePolymer" -> SubstancePolymer
          "SubstanceProtein" -> SubstanceProtein
          "SubstanceReferenceInformation" -> SubstanceReferenceInformation
          "SubstanceSourceMaterial" -> SubstanceSourceMaterial
          "SupplyDelivery" -> SupplyDelivery
          "SupplyRequest" -> SupplyRequest
          "Task" -> Task
          "TerminologyCapabilities" -> TerminologyCapabilities
          "TestPlan" -> TestPlan
          "TestReport" -> TestReport
          "TestScript" -> TestScript
          "Transport" -> Transport
          "ValueSet" -> ValueSet
          "VerificationResult" -> VerificationResult
          "VisionPrescription" -> VisionPrescription
          "BodySite" -> BodySite
          "CatalogEntry" -> CatalogEntry
          "Conformance" -> Conformance
          "DataElement" -> DataElement
          "DeviceComponent" -> DeviceComponent
          "DeviceUseRequest" -> DeviceUseRequest
          "DeviceUseStatement" -> DeviceUseStatement
          "DiagnosticOrder" -> DiagnosticOrder
          "DocumentManifest" -> DocumentManifest
          "EffectEvidenceSynthesis" -> EffectEvidenceSynthesis
          "EligibilityRequest" -> EligibilityRequest
          "EligibilityResponse" -> EligibilityResponse
          "ExpansionProfile" -> ExpansionProfile
          "ImagingManifest" -> ImagingManifest
          "ImagingObjectSelection" -> ImagingObjectSelection
          "Media" -> Media
          "MedicationOrder" -> MedicationOrder
          "MedicationUsage" -> MedicationUsage
          "MedicinalProduct" -> MedicinalProduct
          "MedicinalProductAuthorization" -> MedicinalProductAuthorization
          "MedicinalProductContraindication" -> MedicinalProductContraindication
          "MedicinalProductIndication" -> MedicinalProductIndication
          "MedicinalProductIngredient" -> MedicinalProductIngredient
          "MedicinalProductInteraction" -> MedicinalProductInteraction
          "MedicinalProductManufactured" -> MedicinalProductManufactured
          "MedicinalProductPackaged" -> MedicinalProductPackaged
          "MedicinalProductPharmaceutical" -> MedicinalProductPharmaceutical
          "MedicinalProductUndesirableEffect" -> MedicinalProductUndesirableEffect
          "Order" -> Order
          "OrderResponse" -> OrderResponse
          "ProcedureRequest" -> ProcedureRequest
          "ProcessRequest" -> ProcessRequest
          "ProcessResponse" -> ProcessResponse
          "ReferralRequest" -> ReferralRequest
          "RequestGroup" -> RequestGroup
          "ResearchDefinition" -> ResearchDefinition
          "ResearchElementDefinition" -> ResearchElementDefinition
          "RiskEvidenceSynthesis" -> RiskEvidenceSynthesis
          "Sequence" -> Sequence
          "ServiceDefinition" -> ServiceDefinition
          "SubstanceSpecification" -> SubstanceSpecification
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum VersionIndependentResourceTypesAll"
            )
        }
    }
  }

  /**
   * How a search parameter relates to the set of elements returned by evaluating its expression
   * query.
   */
  public enum class SearchProcessingModeType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Normal("normal", "http://hl7.org/fhir/search-processingmode", "Normal"),
    Phonetic("phonetic", "http://hl7.org/fhir/search-processingmode", "Phonetic"),
    Other("other", "http://hl7.org/fhir/search-processingmode", "Other");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SearchProcessingModeType =
        when (code) {
          "normal" -> Normal
          "phonetic" -> Phonetic
          "other" -> Other
          else ->
            throw IllegalArgumentException("Unknown code $code for enum SearchProcessingModeType")
        }
    }
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
}
