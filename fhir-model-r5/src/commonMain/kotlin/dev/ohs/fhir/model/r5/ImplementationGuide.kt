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

import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDefinitionGroupingSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDefinitionPageSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDefinitionParameterSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDefinitionResourceSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDefinitionTemplateSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideDependsOnSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideGlobalSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideManifestPageSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideManifestResourceSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideManifestSerializer
import dev.ohs.fhir.model.r5.serializers.ImplementationGuideSerializer
import dev.ohs.fhir.model.r5.terminologies.FHIRVersion
import dev.ohs.fhir.model.r5.terminologies.GuidePageGeneration
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
import dev.ohs.fhir.model.r5.terminologies.SPDXLicense
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A set of rules of how a particular interoperability or standards problem is solved - typically
 * through the use of FHIR resources. This resource is used to gather all the parts of an
 * implementation guide into a logical whole and to publish a computable definition of all the
 * parts.
 */
@Serializable(with = ImplementationGuideSerializer::class)
@SerialName("ImplementationGuide")
public data class ImplementationGuide(
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
   * An absolute URI that is used to identify this implementation guide when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which an authoritative instance of this
   * implementation guide is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the implementation guide is stored on different
   * servers.
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
   * A formal identifier that is used to identify this implementation guide when it is represented
   * in other formats, or referenced in a specification, model, design or an instance.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the implementation guide when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the implementation guide author and is not expected to be globally unique. For example, it
   * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence.
   *
   * There may be different implementation guide instances that have the same identifier but
   * different versions. The version can be appended to the url in a reference to allow a reference
   * to a particular business version of the implementation guide with the format [url]|[version].
   * The version SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
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
   * A natural language name identifying the implementation guide. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String,
  /**
   * A short, descriptive, user-friendly title for the implementation guide.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this implementation guide. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of implementation guides that are appropriate for use versus not.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this implementation guide is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of implementation guides that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the implementation guide was last significantly changed.
   * The date must change when the business version changes and it must change if the status code
   * changes. In addition, it should change when the substantive content of the implementation guide
   * changes.
   *
   * The date is often not tracked until the resource is published, but may be present on draft
   * content. Note that this is not the same as the resource last-modified-date, since the resource
   * may be a secondary representation of the implementation guide. Additional specific dates may be
   * added as extensions or be found by consulting Provenances associated with past versions of the
   * resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual responsible for the release and ongoing maintenance
   * of the implementation guide.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the
   * implementation guide is the organization or individual primarily responsible for the
   * maintenance and upkeep of the implementation guide. This is not necessarily the same individual
   * or organization that developed and initially authored the content. The publisher is the primary
   * point of contact for questions or issues with the implementation guide. This item SHOULD be
   * populated unless the information is available from context.
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
   * A free text natural language description of the implementation guide from a consumer's
   * perspective.
   *
   * This description can be used to capture details such as why the implementation guide was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the implementation guide as
   * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
   * information is available from context (e.g. the language of the implementation guide is
   * presumed to be the predominant language in the place the implementation guide was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate implementation guide instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the implementation guide is intended to be used.
   *
   * It may be possible for the implementation guide to be used in jurisdictions other than those
   * for which it was originally designed or intended.
   *
   * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
   * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
   * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
   * useContext.valueCodeableConcept indicating the jurisdiction.)
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this implementation guide is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the implementation guide. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * implementation guide.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the implementation guide and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the implementation
   * guide.
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
   * The NPM package name for this Implementation Guide, used in the NPM package distribution, which
   * is the primary mechanism by which FHIR based tooling manages IG dependencies. This value must
   * be globally unique, and should be assigned with care.
   *
   * Many (if not all) IG publishing tools will require that this element be present. For
   * implementation guides published through HL7 or the FHIR foundation, the FHIR product director
   * assigns package IDs.
   */
  public val packageId: Id,
  /**
   * The license that applies to this Implementation Guide, using an SPDX license code, or
   * 'not-open-source'.
   */
  public val license: ExtensibleEnumeration<SPDXLicense>? = null,
  /**
   * The version(s) of the FHIR specification that this ImplementationGuide targets - e.g. describes
   * how to use. The value of this element is the formal version of the specification, without the
   * revision number, e.g. [publication].[major].[minor], which is 4.6.0. for this version.
   *
   * Most implementation guides target a single version - e.g. they describe how to use a particular
   * version, and the profiles and examples etc. are valid for that version. But some implementation
   * guides describe how to use multiple different versions of FHIR to solve the same problem, or in
   * concert with each other. Typically, the requirement to support multiple versions arises as
   * implementation matures and different implementation communities are stuck at different versions
   * by regulation or market dynamics.
   */
  public val fhirVersion: List<Enumeration<FHIRVersion>>,
  /**
   * Another implementation guide that this implementation depends on. Typically, an implementation
   * guide uses value sets, profiles etc.defined in other implementation guides.
   */
  public val dependsOn: List<DependsOn> = listOf(),
  /**
   * A set of profiles that all resources covered by this implementation guide must conform to.
   *
   * See [Default Profiles](implementationguide.html#default) for a discussion of which resources
   * are 'covered' by an implementation guide.
   */
  public val global: List<Global> = listOf(),
  /**
   * The information needed by an IG publisher tool to publish the whole implementation guide.
   *
   * Principally, this consists of information abuot source resource and file locations, and build
   * parameters and templates.
   */
  public val definition: Definition? = null,
  /** Information about an assembled implementation guide, created by the publication tooling. */
  public val manifest: Manifest? = null,
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        url.toBuilder(),
        name.toBuilder(),
        status,
        packageId.toBuilder(),
        fhirVersion.toMutableList(),
      )
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.identifier = identifier.toBuilderList()
    builder.version = version?.toBuilder()
    builder.versionAlgorithm = versionAlgorithm
    builder.title = title?.toBuilder()
    builder.experimental = experimental?.toBuilder()
    builder.date = date?.toBuilder()
    builder.publisher = publisher?.toBuilder()
    builder.contact = contact.toBuilderList()
    builder.description = description?.toBuilder()
    builder.useContext = useContext.toBuilderList()
    builder.jurisdiction = jurisdiction.toBuilderList()
    builder.purpose = purpose?.toBuilder()
    builder.copyright = copyright?.toBuilder()
    builder.copyrightLabel = copyrightLabel?.toBuilder()
    builder.license = license
    builder.dependsOn = dependsOn.toBuilderList()
    builder.global = global.toBuilderList()
    builder.definition = definition?.toBuilder()
    builder.manifest = manifest?.toBuilder()
    return builder
  }

  /**
   * Another implementation guide that this implementation depends on. Typically, an implementation
   * guide uses value sets, profiles etc.defined in other implementation guides.
   */
  @Serializable(with = ImplementationGuideDependsOnSerializer::class)
  public data class DependsOn(
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
     * A canonical reference to the Implementation guide for the dependency.
     *
     * Usually, A canonical reference to the implementation guide is the same as the master location
     * at which the implementation guide is published.
     */
    public val uri: Canonical,
    /** The NPM package name for the Implementation Guide that this IG depends on. */
    public val packageId: Id? = null,
    /**
     * The version of the IG that is depended on, when the correct version is required to understand
     * the IG correctly.
     *
     * This follows the syntax of the NPM packaging version field - see [[reference]].
     */
    public val version: String? = null,
    /**
     * A description explaining the nature of the dependency on the listed IG.
     *
     * This doesn't need to enumerate every resource used, but should give some sense of why the
     * dependency exists. It will be used in the rendered list of dependencies
     */
    public val reason: Markdown? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(uri.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.packageId = packageId?.toBuilder()
      builder.version = version?.toBuilder()
      builder.reason = reason?.toBuilder()
      return builder
    }

    public class Builder(
      /**
       * A canonical reference to the Implementation guide for the dependency.
       *
       * Usually, A canonical reference to the implementation guide is the same as the master
       * location at which the implementation guide is published.
       */
      public var uri: Canonical.Builder
    ) : FhirBuilder {
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

      /** The NPM package name for the Implementation Guide that this IG depends on. */
      public var packageId: Id.Builder? = null

      /**
       * The version of the IG that is depended on, when the correct version is required to
       * understand the IG correctly.
       *
       * This follows the syntax of the NPM packaging version field - see [[reference]].
       */
      public var version: String.Builder? = null

      /**
       * A description explaining the nature of the dependency on the listed IG.
       *
       * This doesn't need to enumerate every resource used, but should give some sense of why the
       * dependency exists. It will be used in the rendered list of dependencies
       */
      public var reason: Markdown.Builder? = null

      override fun build(): DependsOn =
        DependsOn(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          uri = uri.build(),
          packageId = packageId?.build(),
          version = version?.build(),
          reason = reason?.build(),
        )
    }
  }

  /** A set of profiles that all resources covered by this implementation guide must conform to. */
  @Serializable(with = ImplementationGuideGlobalSerializer::class)
  public data class Global(
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
     * The type of resource that all instances must conform to.
     *
     * The type must match that of the profile that is referred to but is made explicit here as a
     * denormalization so that a system processing the implementation guide resource knows which
     * resources the profile applies to even if the profile itself is not available.
     */
    public val type: Enumeration<ResourceType>,
    /** A reference to the profile that all instances must conform to. */
    public val profile: Canonical,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder =
        Builder(
          type,
          profile.toBuilder(),
        )
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public class Builder(
      /**
       * The type of resource that all instances must conform to.
       *
       * The type must match that of the profile that is referred to but is made explicit here as a
       * denormalization so that a system processing the implementation guide resource knows which
       * resources the profile applies to even if the profile itself is not available.
       */
      public var type: Enumeration<ResourceType>,
      /** A reference to the profile that all instances must conform to. */
      public var profile: Canonical.Builder,
    ) : FhirBuilder {
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

      override fun build(): Global =
        Global(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type,
          profile = profile.build(),
        )
    }
  }

  /** The information needed by an IG publisher tool to publish the whole implementation guide. */
  @Serializable(with = ImplementationGuideDefinitionSerializer::class)
  public data class Definition(
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
     * A logical group of resources. Logical groups can be used when building pages.
     *
     * Groupings are arbitrary sub-divisions of content. Typically, they are used to help build
     * Table of Contents automatically.
     */
    public val grouping: List<Grouping> = listOf(),
    /**
     * A resource that is part of the implementation guide. Conformance resources (value set,
     * structure definition, capability statements etc.) are obvious candidates for inclusion, but
     * any kind of resource can be included as an example resource.
     */
    public val resource: List<Resource> = listOf(),
    /**
     * A page / section in the implementation guide. The root page is the implementation guide home
     * page.
     *
     * Pages automatically become sections if they have sub-pages. By convention, the home page is
     * called index.html.
     */
    public val page: Page? = null,
    /**
     * A set of parameters that defines how the implementation guide is built. The parameters are
     * defined by the relevant tools that build the implementation guides.
     *
     * see [confluence](https://confluence.hl7.org/display/FHIR/Implementation+Guide+Parameters) for
     * the parameters defined by the HL7 IG publisher.
     */
    public val parameter: List<Parameter> = listOf(),
    /** A template for building resources. */
    public val template: List<Template> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.grouping = grouping.toBuilderList()
      builder.resource = resource.toBuilderList()
      builder.page = page?.toBuilder()
      builder.parameter = parameter.toBuilderList()
      builder.template = template.toBuilderList()
      return builder
    }

    /** A logical group of resources. Logical groups can be used when building pages. */
    @Serializable(with = ImplementationGuideDefinitionGroupingSerializer::class)
    public data class Grouping(
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
       * The human-readable title to display for the package of resources when rendering the
       * implementation guide.
       */
      public val name: String,
      /** Human readable text describing the package. */
      public val description: Markdown? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(name.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.description = description?.toBuilder()
        return builder
      }

      public class Builder(
        /**
         * The human-readable title to display for the package of resources when rendering the
         * implementation guide.
         */
        public var name: String.Builder
      ) : FhirBuilder {
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

        /** Human readable text describing the package. */
        public var description: Markdown.Builder? = null

        override fun build(): Grouping =
          Grouping(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            name = name.build(),
            description = description?.build(),
          )
      }
    }

    /**
     * A resource that is part of the implementation guide. Conformance resources (value set,
     * structure definition, capability statements etc.) are obvious candidates for inclusion, but
     * any kind of resource can be included as an example resource.
     */
    @Serializable(with = ImplementationGuideDefinitionResourceSerializer::class)
    public data class Resource(
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
       * Where this resource is found.
       *
       * Usually this is a relative URL that locates the resource within the implementation guide.
       * If you authoring an implementation guide, and will publish it using the FHIR publication
       * tooling, use a URI that may point to a resource, or to one of various alternative
       * representations (e.g. spreadsheet). The tooling will convert this when it publishes it.
       */
      public val reference: Reference,
      /**
       * Indicates the FHIR Version(s) this artifact is intended to apply to. If no versions are
       * specified, the resource is assumed to apply to all the versions stated in
       * ImplementationGuide.fhirVersion.
       *
       * The resource SHALL be valid against all the versions it is specified to apply to. If the
       * resource referred to is a StructureDefinition, the fhirVersion stated in the
       * StructureDefinition cannot disagree with the version specified here; the specified versions
       * SHALL include the version specified by the StructureDefinition, and may include additional
       * versions using the
       * [http://hl7.org/fhir/StructureDefinition/structuredefinition-applicable-version](http://hl7.org/fhir/extensions/StructureDefinition-structuredefinition-applicable-version.html)
       * extension.
       */
      public val fhirVersion: List<Enumeration<FHIRVersion>> = listOf(),
      /**
       * A human assigned name for the resource. All resources SHOULD have a name, but the name may
       * be extracted from the resource (e.g. ValueSet.name).
       */
      public val name: String? = null,
      /**
       * A description of the reason that a resource has been included in the implementation guide.
       *
       * This is mostly used with examples to explain why it is present (though they can have
       * extensive comments in the examples).
       */
      public val description: Markdown? = null,
      /** If true, indicates the resource is an example instance. */
      public val isExample: Boolean? = null,
      /**
       * If present, indicates profile(s) the instance is valid against.
       *
       * Examples:
       *
       * * StructureDefinition -> Any
       * * ValueSet -> expansion
       * * OperationDefinition -> Parameters
       * * Questionnaire -> QuestionnaireResponse.
       */
      public val profile: List<Canonical> = listOf(),
      /**
       * Reference to the id of the grouping this resource appears in.
       *
       * This must correspond to a group.id element within this implementation guide.
       */
      public val groupingId: Id? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(reference.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.fhirVersion = fhirVersion.toMutableList()
        builder.name = name?.toBuilder()
        builder.description = description?.toBuilder()
        builder.isExample = isExample?.toBuilder()
        builder.profile = profile.toBuilderList()
        builder.groupingId = groupingId?.toBuilder()
        return builder
      }

      public class Builder(
        /**
         * Where this resource is found.
         *
         * Usually this is a relative URL that locates the resource within the implementation guide.
         * If you authoring an implementation guide, and will publish it using the FHIR publication
         * tooling, use a URI that may point to a resource, or to one of various alternative
         * representations (e.g. spreadsheet). The tooling will convert this when it publishes it.
         */
        public var reference: Reference.Builder
      ) : FhirBuilder {
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
         * Indicates the FHIR Version(s) this artifact is intended to apply to. If no versions are
         * specified, the resource is assumed to apply to all the versions stated in
         * ImplementationGuide.fhirVersion.
         *
         * The resource SHALL be valid against all the versions it is specified to apply to. If the
         * resource referred to is a StructureDefinition, the fhirVersion stated in the
         * StructureDefinition cannot disagree with the version specified here; the specified
         * versions SHALL include the version specified by the StructureDefinition, and may include
         * additional versions using the
         * [http://hl7.org/fhir/StructureDefinition/structuredefinition-applicable-version](http://hl7.org/fhir/extensions/StructureDefinition-structuredefinition-applicable-version.html)
         * extension.
         */
        public var fhirVersion: MutableList<Enumeration<FHIRVersion>> = mutableListOf()

        /**
         * A human assigned name for the resource. All resources SHOULD have a name, but the name
         * may be extracted from the resource (e.g. ValueSet.name).
         */
        public var name: String.Builder? = null

        /**
         * A description of the reason that a resource has been included in the implementation
         * guide.
         *
         * This is mostly used with examples to explain why it is present (though they can have
         * extensive comments in the examples).
         */
        public var description: Markdown.Builder? = null

        /** If true, indicates the resource is an example instance. */
        public var isExample: Boolean.Builder? = null

        /**
         * If present, indicates profile(s) the instance is valid against.
         *
         * Examples:
         *
         * * StructureDefinition -> Any
         * * ValueSet -> expansion
         * * OperationDefinition -> Parameters
         * * Questionnaire -> QuestionnaireResponse.
         */
        public var profile: MutableList<Canonical.Builder> = mutableListOf()

        /**
         * Reference to the id of the grouping this resource appears in.
         *
         * This must correspond to a group.id element within this implementation guide.
         */
        public var groupingId: Id.Builder? = null

        override fun build(): Resource =
          Resource(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            reference = reference.build(),
            fhirVersion = fhirVersion,
            name = name?.build(),
            description = description?.build(),
            isExample = isExample?.build(),
            profile = profile.buildList(),
            groupingId = groupingId?.build(),
          )
      }
    }

    /**
     * A page / section in the implementation guide. The root page is the implementation guide home
     * page.
     */
    @Serializable(with = ImplementationGuideDefinitionPageSerializer::class)
    public data class Page(
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
       * Indicates the URL or the actual content to provide for the page.
       *
       * If absent and the page isn't a generated page, this may be inferred from the page name by
       * checking input locations. String is used for XHTML content - sent as an escaped string.
       * FHIR tooling can't support 'direct' XHTML anywhere other than in narrative.
       */
      public val source: Source? = null,
      /**
       * The url by which the page should be known when published.
       *
       * This SHALL be a local reference, expressed with respect to the root of the IG output
       * folder. No suffix is required. If no suffix is specified, .html will be appended.
       */
      public val name: Url,
      /**
       * A short title used to represent this page in navigational structures such as table of
       * contents, bread crumbs, etc.
       */
      public val title: String,
      /** A code that indicates how the page is generated. */
      public val generation: Enumeration<GuidePageGeneration>,
      /**
       * Nested Pages/Sections under this page.
       *
       * The implementation guide breadcrumbs may be generated from this structure.
       */
      public val page: List<Page> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder =
          Builder(
            name.toBuilder(),
            title.toBuilder(),
            generation,
          )
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.source = source
        builder.page = page.toBuilderList()
        return builder
      }

      public sealed interface Source : FhirChoice {
        public fun asUrl(): Url? = this as? Url

        public fun asString(): String? = this as? String

        public fun asMarkdown(): Markdown? = this as? Markdown

        public data class Url(override val `value`: dev.ohs.fhir.model.r5.Url) : Source

        public data class String(override val `value`: dev.ohs.fhir.model.r5.String) : Source

        public data class Markdown(override val `value`: dev.ohs.fhir.model.r5.Markdown) : Source

        public companion object {
          internal fun from(
            urlValue: dev.ohs.fhir.model.r5.Url?,
            stringValue: dev.ohs.fhir.model.r5.String?,
            markdownValue: dev.ohs.fhir.model.r5.Markdown?,
          ): Source? {
            if (urlValue != null) return Url(urlValue)
            if (stringValue != null) return String(stringValue)
            if (markdownValue != null) return Markdown(markdownValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * The url by which the page should be known when published.
         *
         * This SHALL be a local reference, expressed with respect to the root of the IG output
         * folder. No suffix is required. If no suffix is specified, .html will be appended.
         */
        public var name: Url.Builder,
        /**
         * A short title used to represent this page in navigational structures such as table of
         * contents, bread crumbs, etc.
         */
        public var title: String.Builder,
        /** A code that indicates how the page is generated. */
        public var generation: Enumeration<GuidePageGeneration>,
      ) : FhirBuilder {
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
         * Indicates the URL or the actual content to provide for the page.
         *
         * If absent and the page isn't a generated page, this may be inferred from the page name by
         * checking input locations. String is used for XHTML content - sent as an escaped string.
         * FHIR tooling can't support 'direct' XHTML anywhere other than in narrative.
         */
        public var source: Source? = null

        /**
         * Nested Pages/Sections under this page.
         *
         * The implementation guide breadcrumbs may be generated from this structure.
         */
        public var page: MutableList<Builder> = mutableListOf()

        override fun build(): Page =
          Page(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            source = source,
            name = name.build(),
            title = title.build(),
            generation = generation,
            page = page.buildList(),
          )
      }
    }

    /**
     * A set of parameters that defines how the implementation guide is built. The parameters are
     * defined by the relevant tools that build the implementation guides.
     */
    @Serializable(with = ImplementationGuideDefinitionParameterSerializer::class)
    public data class Parameter(
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
      /** A tool-specific code that defines the parameter. */
      public val code: Coding,
      /** Value for named type. */
      public val `value`: String,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(code.toBuilder(), `value`.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        return builder
      }

      public class Builder(
        /** A tool-specific code that defines the parameter. */
        public var code: Coding.Builder,
        /** Value for named type. */
        public var `value`: String.Builder,
      ) : FhirBuilder {
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

        override fun build(): Parameter =
          Parameter(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            code = code.build(),
            `value` = `value`.build(),
          )
      }
    }

    /** A template for building resources. */
    @Serializable(with = ImplementationGuideDefinitionTemplateSerializer::class)
    public data class Template(
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
      /** Type of template specified. */
      public val code: Code,
      /** The source location for the template. */
      public val source: String,
      /** The scope in which the template applies. */
      public val scope: String? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(code.toBuilder(), source.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.scope = scope?.toBuilder()
        return builder
      }

      public class Builder(
        /** Type of template specified. */
        public var code: Code.Builder,
        /** The source location for the template. */
        public var source: String.Builder,
      ) : FhirBuilder {
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

        /** The scope in which the template applies. */
        public var scope: String.Builder? = null

        override fun build(): Template =
          Template(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            code = code.build(),
            source = source.build(),
            scope = scope?.build(),
          )
      }
    }

    public class Builder() : FhirBuilder {
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
       * A logical group of resources. Logical groups can be used when building pages.
       *
       * Groupings are arbitrary sub-divisions of content. Typically, they are used to help build
       * Table of Contents automatically.
       */
      public var grouping: MutableList<Grouping.Builder> = mutableListOf()

      /**
       * A resource that is part of the implementation guide. Conformance resources (value set,
       * structure definition, capability statements etc.) are obvious candidates for inclusion, but
       * any kind of resource can be included as an example resource.
       */
      public var resource: MutableList<Resource.Builder> = mutableListOf()

      /**
       * A page / section in the implementation guide. The root page is the implementation guide
       * home page.
       *
       * Pages automatically become sections if they have sub-pages. By convention, the home page is
       * called index.html.
       */
      public var page: Page.Builder? = null

      /**
       * A set of parameters that defines how the implementation guide is built. The parameters are
       * defined by the relevant tools that build the implementation guides.
       *
       * see [confluence](https://confluence.hl7.org/display/FHIR/Implementation+Guide+Parameters)
       * for the parameters defined by the HL7 IG publisher.
       */
      public var parameter: MutableList<Parameter.Builder> = mutableListOf()

      /** A template for building resources. */
      public var template: MutableList<Template.Builder> = mutableListOf()

      override fun build(): Definition =
        Definition(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          grouping = grouping.buildList(),
          resource = resource.buildList(),
          page = page?.build(),
          parameter = parameter.buildList(),
          template = template.buildList(),
        )
    }
  }

  /** Information about an assembled implementation guide, created by the publication tooling. */
  @Serializable(with = ImplementationGuideManifestSerializer::class)
  public data class Manifest(
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
    /** A pointer to official web page, PDF or other rendering of the implementation guide. */
    public val rendering: Url? = null,
    /**
     * A resource that is part of the implementation guide. Conformance resources (value set,
     * structure definition, capability statements etc.) are obvious candidates for inclusion, but
     * any kind of resource can be included as an example resource.
     */
    public val resource: List<Resource>,
    /** Information about a page within the IG. */
    public val page: List<Page> = listOf(),
    /** Indicates a relative path to an image that exists within the IG. */
    public val image: List<String> = listOf(),
    /**
     * Indicates the relative path of an additional non-page, non-image file that is part of the
     * IG - e.g. zip, jar and similar files that could be the target of a hyperlink in a derived IG.
     */
    public val other: List<String> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(resource.toBuilderList())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.rendering = rendering?.toBuilder()
      builder.page = page.toBuilderList()
      builder.image = image.toBuilderList()
      builder.other = other.toBuilderList()
      return builder
    }

    /**
     * A resource that is part of the implementation guide. Conformance resources (value set,
     * structure definition, capability statements etc.) are obvious candidates for inclusion, but
     * any kind of resource can be included as an example resource.
     */
    @Serializable(with = ImplementationGuideManifestResourceSerializer::class)
    public data class Resource(
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
       * Where this resource is found.
       *
       * Usually this is a relative URL that locates the resource within the implementation guide.
       * If you authoring an implementation guide, and will publish it using the FHIR publication
       * tooling, use a URI that may point to a resource, or to one of various alternative
       * representations (e.g. spreadsheet). The tooling will convert this when it publishes it.
       */
      public val reference: Reference,
      /** If true, indicates the resource is an example instance. */
      public val isExample: Boolean? = null,
      /**
       * If present, indicates profile(s) the instance is valid against.
       *
       * Examples:
       *
       * * StructureDefinition -> Any
       * * ValueSet -> expansion
       * * OperationDefinition -> Parameters
       * * Questionnaire -> QuestionnaireResponse.
       */
      public val profile: List<Canonical> = listOf(),
      /**
       * The relative path for primary page for this resource within the IG.
       *
       * Appending 'rendering' + "/" + this should resolve to the resource page.
       */
      public val relativePath: Url? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(reference.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.isExample = isExample?.toBuilder()
        builder.profile = profile.toBuilderList()
        builder.relativePath = relativePath?.toBuilder()
        return builder
      }

      public class Builder(
        /**
         * Where this resource is found.
         *
         * Usually this is a relative URL that locates the resource within the implementation guide.
         * If you authoring an implementation guide, and will publish it using the FHIR publication
         * tooling, use a URI that may point to a resource, or to one of various alternative
         * representations (e.g. spreadsheet). The tooling will convert this when it publishes it.
         */
        public var reference: Reference.Builder
      ) : FhirBuilder {
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

        /** If true, indicates the resource is an example instance. */
        public var isExample: Boolean.Builder? = null

        /**
         * If present, indicates profile(s) the instance is valid against.
         *
         * Examples:
         *
         * * StructureDefinition -> Any
         * * ValueSet -> expansion
         * * OperationDefinition -> Parameters
         * * Questionnaire -> QuestionnaireResponse.
         */
        public var profile: MutableList<Canonical.Builder> = mutableListOf()

        /**
         * The relative path for primary page for this resource within the IG.
         *
         * Appending 'rendering' + "/" + this should resolve to the resource page.
         */
        public var relativePath: Url.Builder? = null

        override fun build(): Resource =
          Resource(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            reference = reference.build(),
            isExample = isExample?.build(),
            profile = profile.buildList(),
            relativePath = relativePath?.build(),
          )
      }
    }

    /** Information about a page within the IG. */
    @Serializable(with = ImplementationGuideManifestPageSerializer::class)
    public data class Page(
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
       * Relative path to the page.
       *
       * Appending 'rendering' + "/" + this should resolve to the page.
       */
      public val name: String,
      /** Label for the page intended for human display. */
      public val title: String? = null,
      /**
       * The name of an anchor available on the page.
       *
       * Appending 'rendering' + "/" + page.name + "#" + page.anchor should resolve to the anchor.
       */
      public val anchor: List<String> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(name.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.title = title?.toBuilder()
        builder.anchor = anchor.toBuilderList()
        return builder
      }

      public class Builder(
        /**
         * Relative path to the page.
         *
         * Appending 'rendering' + "/" + this should resolve to the page.
         */
        public var name: String.Builder
      ) : FhirBuilder {
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

        /** Label for the page intended for human display. */
        public var title: String.Builder? = null

        /**
         * The name of an anchor available on the page.
         *
         * Appending 'rendering' + "/" + page.name + "#" + page.anchor should resolve to the anchor.
         */
        public var anchor: MutableList<String.Builder> = mutableListOf()

        override fun build(): Page =
          Page(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            name = name.build(),
            title = title?.build(),
            anchor = anchor.buildList(),
          )
      }
    }

    public class Builder(
      /**
       * A resource that is part of the implementation guide. Conformance resources (value set,
       * structure definition, capability statements etc.) are obvious candidates for inclusion, but
       * any kind of resource can be included as an example resource.
       */
      public var resource: MutableList<Resource.Builder>
    ) : FhirBuilder {
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

      /** A pointer to official web page, PDF or other rendering of the implementation guide. */
      public var rendering: Url.Builder? = null

      /** Information about a page within the IG. */
      public var page: MutableList<Page.Builder> = mutableListOf()

      /** Indicates a relative path to an image that exists within the IG. */
      public var image: MutableList<String.Builder> = mutableListOf()

      /**
       * Indicates the relative path of an additional non-page, non-image file that is part of the
       * IG - e.g. zip, jar and similar files that could be the target of a hyperlink in a derived
       * IG.
       */
      public var other: MutableList<String.Builder> = mutableListOf()

      override fun build(): Manifest =
        Manifest(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          rendering = rendering?.build(),
          resource = resource.buildList(),
          page = page.buildList(),
          image = image.buildList(),
          other = other.buildList(),
        )
    }
  }

  public sealed interface VersionAlgorithm : FhirChoice {
    public fun asString(): String? = this as? String

    public fun asCoding(): Coding? = this as? Coding

    public data class String(override val `value`: dev.ohs.fhir.model.r5.String) : VersionAlgorithm

    public data class Coding(override val `value`: dev.ohs.fhir.model.r5.Coding) : VersionAlgorithm

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
     * An absolute URI that is used to identify this implementation guide when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance
     * of this implementation guide is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the implementation guide is stored on
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
    public var url: Uri.Builder,
    /**
     * A natural language name identifying the implementation guide. This name should be usable as
     * an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder,
    /**
     * The status of this implementation guide. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of implementation guides that are appropriate for use versus not.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * The NPM package name for this Implementation Guide, used in the NPM package distribution,
     * which is the primary mechanism by which FHIR based tooling manages IG dependencies. This
     * value must be globally unique, and should be assigned with care.
     *
     * Many (if not all) IG publishing tools will require that this element be present. For
     * implementation guides published through HL7 or the FHIR foundation, the FHIR product director
     * assigns package IDs.
     */
    public var packageId: Id.Builder,
    /**
     * The version(s) of the FHIR specification that this ImplementationGuide targets - e.g.
     * describes how to use. The value of this element is the formal version of the specification,
     * without the revision number, e.g. [publication].[major].[minor], which is 4.6.0. for this
     * version.
     *
     * Most implementation guides target a single version - e.g. they describe how to use a
     * particular version, and the profiles and examples etc. are valid for that version. But some
     * implementation guides describe how to use multiple different versions of FHIR to solve the
     * same problem, or in concert with each other. Typically, the requirement to support multiple
     * versions arises as implementation matures and different implementation communities are stuck
     * at different versions by regulation or market dynamics.
     */
    public var fhirVersion: MutableList<Enumeration<FHIRVersion>>,
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
     * A formal identifier that is used to identify this implementation guide when it is represented
     * in other formats, or referenced in a specification, model, design or an instance.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the implementation guide when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the implementation guide author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different implementation guide instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the implementation guide with the format
     * [url]|[version]. The version SHOULD NOT contain a '#' - see
     * [Business Version](resource.html#bv-format).
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
     * A short, descriptive, user-friendly title for the implementation guide.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this implementation guide is authored for testing purposes
     * (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of implementation guides that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the implementation guide was last significantly changed.
     * The date must change when the business version changes and it must change if the status code
     * changes. In addition, it should change when the substantive content of the implementation
     * guide changes.
     *
     * The date is often not tracked until the resource is published, but may be present on draft
     * content. Note that this is not the same as the resource last-modified-date, since the
     * resource may be a secondary representation of the implementation guide. Additional specific
     * dates may be added as extensions or be found by consulting Provenances associated with past
     * versions of the resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual responsible for the release and ongoing
     * maintenance of the implementation guide.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the
     * implementation guide is the organization or individual primarily responsible for the
     * maintenance and upkeep of the implementation guide. This is not necessarily the same
     * individual or organization that developed and initially authored the content. The publisher
     * is the primary point of contact for questions or issues with the implementation guide. This
     * item SHOULD be populated unless the information is available from context.
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
     * A free text natural language description of the implementation guide from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as why the implementation guide was
     * built, comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the implementation
     * guide as conveyed in the 'text' field of the resource itself. This item SHOULD be populated
     * unless the information is available from context (e.g. the language of the implementation
     * guide is presumed to be the predominant language in the place the implementation guide was
     * created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate implementation guide instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the implementation guide is intended to be used.
     *
     * It may be possible for the implementation guide to be used in jurisdictions other than those
     * for which it was originally designed or intended.
     *
     * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
     * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
     * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
     * useContext.valueCodeableConcept indicating the jurisdiction.)
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this implementation guide is needed and why it has been designed as it
     * has.
     *
     * This element does not describe the usage of the implementation guide. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * implementation guide.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the implementation guide and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the implementation
     * guide.
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
     * The license that applies to this Implementation Guide, using an SPDX license code, or
     * 'not-open-source'.
     */
    public var license: ExtensibleEnumeration<SPDXLicense>? = null

    /**
     * Another implementation guide that this implementation depends on. Typically, an
     * implementation guide uses value sets, profiles etc.defined in other implementation guides.
     */
    public var dependsOn: MutableList<DependsOn.Builder> = mutableListOf()

    /**
     * A set of profiles that all resources covered by this implementation guide must conform to.
     *
     * See [Default Profiles](implementationguide.html#default) for a discussion of which resources
     * are 'covered' by an implementation guide.
     */
    public var global: MutableList<Global.Builder> = mutableListOf()

    /**
     * The information needed by an IG publisher tool to publish the whole implementation guide.
     *
     * Principally, this consists of information abuot source resource and file locations, and build
     * parameters and templates.
     */
    public var definition: Definition.Builder? = null

    /** Information about an assembled implementation guide, created by the publication tooling. */
    public var manifest: Manifest.Builder? = null

    override fun build(): ImplementationGuide =
      ImplementationGuide(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        url = url.build(),
        identifier = identifier.buildList(),
        version = version?.build(),
        versionAlgorithm = versionAlgorithm,
        name = name.build(),
        title = title?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.buildList(),
        description = description?.build(),
        useContext = useContext.buildList(),
        jurisdiction = jurisdiction.buildList(),
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        copyrightLabel = copyrightLabel?.build(),
        packageId = packageId.build(),
        license = license,
        fhirVersion = fhirVersion,
        dependsOn = dependsOn.buildList(),
        global = global.buildList(),
        definition = definition?.build(),
        manifest = manifest?.build(),
      )
  }
}
