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

import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDefinitionGroupingSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDefinitionPageSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDefinitionParameterSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDefinitionResourceSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDefinitionTemplateSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideDependsOnSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideGlobalSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideManifestPageSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideManifestResourceSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideManifestSerializer
import dev.ohs.fhir.model.r4b.serializers.ImplementationGuideSerializer
import dev.ohs.fhir.model.r4b.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
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
   * An absolute URI that is used to identify this implementation guide when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this implementation guide is (or will be) published. This URL can be the target of a
   * canonical reference. It SHALL remain the same when the implementation guide is stored on
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
  public val url: Uri,
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
   */
  public val version: String? = null,
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
   * The date (and optionally time) when the implementation guide was published. The date must
   * change when the business version changes and it must change if the status code changes. In
   * addition, it should change when the substantive content of the implementation guide changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the implementation guide. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the implementation guide.
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
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * A copyright statement relating to the implementation guide and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the implementation
   * guide.
   */
  public val copyright: Markdown? = null,
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
  public val license: Enumeration<SPDXLicense>? = null,
  /**
   * The version(s) of the FHIR specification that this ImplementationGuide targets - e.g. describes
   * how to use. The value of this element is the formal version of the specification, without the
   * revision number, e.g. [publication].[major].[minor], which is 4.3.0. for this version.
   *
   * Most implementation guides target a single version - e.g. they describe how to use a particular
   * version, and the profiles and examples etc are valid for that version. But some implementation
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
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          url.toBuilder(),
          name.toBuilder(),
          status,
          packageId.toBuilder(),
          fhirVersion.toMutableList(),
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
          version = this@with.version?.toBuilder()
          title = this@with.title?.toBuilder()
          experimental = this@with.experimental?.toBuilder()
          date = this@with.date?.toBuilder()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          copyright = this@with.copyright?.toBuilder()
          license = this@with.license
          dependsOn = this@with.dependsOn.map { it.toBuilder() }.toMutableList()
          global = this@with.global.map { it.toBuilder() }.toMutableList()
          definition = this@with.definition?.toBuilder()
          manifest = this@with.manifest?.toBuilder()
        }
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
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(uri.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          packageId = this@with.packageId?.toBuilder()
          version = this@with.version?.toBuilder()
        }
      }

    public class Builder(
      /**
       * A canonical reference to the Implementation guide for the dependency.
       *
       * Usually, A canonical reference to the implementation guide is the same as the master
       * location at which the implementation guide is published.
       */
      public var uri: Canonical.Builder
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

      /** The NPM package name for the Implementation Guide that this IG depends on. */
      public var packageId: Id.Builder? = null

      /**
       * The version of the IG that is depended on, when the correct version is required to
       * understand the IG correctly.
       *
       * This follows the syntax of the NPM packaging version field - see [[reference]].
       */
      public var version: String.Builder? = null

      public fun build(): DependsOn =
        DependsOn(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          uri = uri.build(),
          packageId = packageId?.build(),
          version = version?.build(),
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
     * The type of resource that all instances must conform to.
     *
     * The type must match that of the profile that is referred to but is made explicit here as a
     * denormalization so that a system processing the implementation guide resource knows which
     * resources the profile applies to even if the profile itself is not available.
     */
    public val type: Enumeration<ResourceType>,
    /** A reference to the profile that all instances must conform to. */
    public val profile: Canonical,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type, profile.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
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

      public fun build(): Global =
        Global(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
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
    public val resource: List<Resource>,
    /**
     * A page / section in the implementation guide. The root page is the implementation guide home
     * page.
     *
     * Pages automatically become sections if they have sub-pages. By convention, the home page is
     * called index.html.
     */
    public val page: Page? = null,
    /** Defines how IG is built by tools. */
    public val parameter: List<Parameter> = listOf(),
    /** A template for building resources. */
    public val template: List<Template> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(resource.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          grouping = this@with.grouping.map { it.toBuilder() }.toMutableList()
          page = this@with.page?.toBuilder()
          parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
          template = this@with.template.map { it.toBuilder() }.toMutableList()
        }
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
       * The human-readable title to display for the package of resources when rendering the
       * implementation guide.
       */
      public val name: String,
      /** Human readable text describing the package. */
      public val description: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(name.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            description = this@with.description?.toBuilder()
          }
        }

      public class Builder(
        /**
         * The human-readable title to display for the package of resources when rendering the
         * implementation guide.
         */
        public var name: String.Builder
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

        /** Human readable text describing the package. */
        public var description: String.Builder? = null

        public fun build(): Grouping =
          Grouping(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
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
       * [applicable-version](extension-structuredefinition-applicable-version.html) extension.
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
      public val description: String? = null,
      /**
       * If true or a reference, indicates the resource is an example instance. If a reference is
       * present, indicates that the example is an example of the specified profile.
       *
       * Examples:
       * * StructureDefinition -> Any
       * * ValueSet -> expansion
       * * OperationDefinition -> Parameters
       * * Questionnaire -> QuestionnaireResponse.
       */
      public val example: Example? = null,
      /**
       * Reference to the id of the grouping this resource appears in.
       *
       * This must correspond to a package.id element within this implementation guide.
       */
      public val groupingId: Id? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(reference.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            fhirVersion = this@with.fhirVersion.toMutableList()
            name = this@with.name?.toBuilder()
            description = this@with.description?.toBuilder()
            example = this@with.example
            groupingId = this@with.groupingId?.toBuilder()
          }
        }

      public sealed interface Example {
        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asCanonical(): Canonical? = this as? Canonical

        public data class Boolean(public val `value`: dev.ohs.fhir.model.r4b.Boolean) : Example

        public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Example

        public companion object {
          internal fun from(
            booleanValue: dev.ohs.fhir.model.r4b.Boolean?,
            canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
          ): Example? {
            if (booleanValue != null) return Boolean(booleanValue)
            if (canonicalValue != null) return Canonical(canonicalValue)
            return null
          }
        }
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
         * Indicates the FHIR Version(s) this artifact is intended to apply to. If no versions are
         * specified, the resource is assumed to apply to all the versions stated in
         * ImplementationGuide.fhirVersion.
         *
         * The resource SHALL be valid against all the versions it is specified to apply to. If the
         * resource referred to is a StructureDefinition, the fhirVersion stated in the
         * StructureDefinition cannot disagree with the version specified here; the specified
         * versions SHALL include the version specified by the StructureDefinition, and may include
         * additional versions using the
         * [applicable-version](extension-structuredefinition-applicable-version.html) extension.
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
        public var description: String.Builder? = null

        /**
         * If true or a reference, indicates the resource is an example instance. If a reference is
         * present, indicates that the example is an example of the specified profile.
         *
         * Examples:
         * * StructureDefinition -> Any
         * * ValueSet -> expansion
         * * OperationDefinition -> Parameters
         * * Questionnaire -> QuestionnaireResponse.
         */
        public var example: Example? = null

        /**
         * Reference to the id of the grouping this resource appears in.
         *
         * This must correspond to a package.id element within this implementation guide.
         */
        public var groupingId: Id.Builder? = null

        public fun build(): Resource =
          Resource(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            reference = reference.build(),
            fhirVersion = fhirVersion,
            name = name?.build(),
            description = description?.build(),
            example = example,
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
       * The source address for the page.
       *
       * The publishing tool will autogenerate source for list (source = n/a) and inject included
       * implementations for include (source = uri of guide to include).
       */
      public val name: Name,
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
       * The implementation guide breadcrumbs are generated from this structure.
       */
      public val page: List<Page> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(name, title.toBuilder(), generation).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            page = this@with.page.map { it.toBuilder() }.toMutableList()
          }
        }

      public sealed interface Name {
        public fun asUrl(): Url? = this as? Url

        public fun asReference(): Reference? = this as? Reference

        public data class Url(public val `value`: dev.ohs.fhir.model.r4b.Url) : Name

        public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Name

        public companion object {
          internal fun from(
            urlValue: dev.ohs.fhir.model.r4b.Url?,
            referenceValue: dev.ohs.fhir.model.r4b.Reference?,
          ): Name? {
            if (urlValue != null) return Url(urlValue)
            if (referenceValue != null) return Reference(referenceValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * The source address for the page.
         *
         * The publishing tool will autogenerate source for list (source = n/a) and inject included
         * implementations for include (source = uri of guide to include).
         */
        public var name: Name,
        /**
         * A short title used to represent this page in navigational structures such as table of
         * contents, bread crumbs, etc.
         */
        public var title: String.Builder,
        /** A code that indicates how the page is generated. */
        public var generation: Enumeration<GuidePageGeneration>,
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
         * Nested Pages/Sections under this page.
         *
         * The implementation guide breadcrumbs are generated from this structure.
         */
        public var page: MutableList<Builder> = mutableListOf()

        public fun build(): Page =
          Page(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            name = name,
            title = title.build(),
            generation = generation,
            page = page.map { it.build() },
          )
      }
    }

    /** Defines how IG is built by tools. */
    @Serializable(with = ImplementationGuideDefinitionParameterSerializer::class)
    public data class Parameter(
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
       * apply | path-resource | path-pages | path-tx-cache | expansion-parameter |
       * rule-broken-links | generate-xml | generate-json | generate-turtle | html-template.
       */
      public val code: Enumeration<GuideParameterCode>,
      /** Value for named type. */
      public val `value`: String,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(code, `value`.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * apply | path-resource | path-pages | path-tx-cache | expansion-parameter |
         * rule-broken-links | generate-xml | generate-json | generate-turtle | html-template.
         */
        public var code: Enumeration<GuideParameterCode>,
        /** Value for named type. */
        public var `value`: String.Builder,
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

        public fun build(): Parameter =
          Parameter(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code,
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
      /** Type of template specified. */
      public val code: Code,
      /** The source location for the template. */
      public val source: String,
      /** The scope in which the template applies. */
      public val scope: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(code.toBuilder(), source.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            scope = this@with.scope?.toBuilder()
          }
        }

      public class Builder(
        /** Type of template specified. */
        public var code: Code.Builder,
        /** The source location for the template. */
        public var source: String.Builder,
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

        /** The scope in which the template applies. */
        public var scope: String.Builder? = null

        public fun build(): Template =
          Template(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code.build(),
            source = source.build(),
            scope = scope?.build(),
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
       * A logical group of resources. Logical groups can be used when building pages.
       *
       * Groupings are arbitrary sub-divisions of content. Typically, they are used to help build
       * Table of Contents automatically.
       */
      public var grouping: MutableList<Grouping.Builder> = mutableListOf()

      /**
       * A page / section in the implementation guide. The root page is the implementation guide
       * home page.
       *
       * Pages automatically become sections if they have sub-pages. By convention, the home page is
       * called index.html.
       */
      public var page: Page.Builder? = null

      /** Defines how IG is built by tools. */
      public var parameter: MutableList<Parameter.Builder> = mutableListOf()

      /** A template for building resources. */
      public var template: MutableList<Template.Builder> = mutableListOf()

      public fun build(): Definition =
        Definition(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          grouping = grouping.map { it.build() },
          resource = resource.map { it.build() },
          page = page?.build(),
          parameter = parameter.map { it.build() },
          template = template.map { it.build() },
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
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(resource.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          rendering = this@with.rendering?.toBuilder()
          page = this@with.page.map { it.toBuilder() }.toMutableList()
          image = this@with.image.map { it.toBuilder() }.toMutableList()
          other = this@with.other.map { it.toBuilder() }.toMutableList()
        }
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
       * Where this resource is found.
       *
       * Usually this is a relative URL that locates the resource within the implementation guide.
       * If you authoring an implementation guide, and will publish it using the FHIR publication
       * tooling, use a URI that may point to a resource, or to one of various alternative
       * representations (e.g. spreadsheet). The tooling will convert this when it publishes it.
       */
      public val reference: Reference,
      /**
       * If true or a reference, indicates the resource is an example instance. If a reference is
       * present, indicates that the example is an example of the specified profile.
       *
       * Typically, conformance resources and knowledge resources are directly part of the
       * implementation guide, with their normal meaning, and patient linked resources are usually
       * examples. However this is not always true.
       */
      public val example: Example? = null,
      /**
       * The relative path for primary page for this resource within the IG.
       *
       * Appending 'rendering' + "/" + this should resolve to the resource page.
       */
      public val relativePath: Url? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(reference.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            example = this@with.example
            relativePath = this@with.relativePath?.toBuilder()
          }
        }

      public sealed interface Example {
        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asCanonical(): Canonical? = this as? Canonical

        public data class Boolean(public val `value`: dev.ohs.fhir.model.r4b.Boolean) : Example

        public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Example

        public companion object {
          internal fun from(
            booleanValue: dev.ohs.fhir.model.r4b.Boolean?,
            canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
          ): Example? {
            if (booleanValue != null) return Boolean(booleanValue)
            if (canonicalValue != null) return Canonical(canonicalValue)
            return null
          }
        }
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
         * If true or a reference, indicates the resource is an example instance. If a reference is
         * present, indicates that the example is an example of the specified profile.
         *
         * Typically, conformance resources and knowledge resources are directly part of the
         * implementation guide, with their normal meaning, and patient linked resources are usually
         * examples. However this is not always true.
         */
        public var example: Example? = null

        /**
         * The relative path for primary page for this resource within the IG.
         *
         * Appending 'rendering' + "/" + this should resolve to the resource page.
         */
        public var relativePath: Url.Builder? = null

        public fun build(): Resource =
          Resource(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            reference = reference.build(),
            example = example,
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
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(name.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            title = this@with.title?.toBuilder()
            anchor = this@with.anchor.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * Relative path to the page.
         *
         * Appending 'rendering' + "/" + this should resolve to the page.
         */
        public var name: String.Builder
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

        /** Label for the page intended for human display. */
        public var title: String.Builder? = null

        /**
         * The name of an anchor available on the page.
         *
         * Appending 'rendering' + "/" + page.name + "#" + page.anchor should resolve to the anchor.
         */
        public var anchor: MutableList<String.Builder> = mutableListOf()

        public fun build(): Page =
          Page(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            name = name.build(),
            title = title?.build(),
            anchor = anchor.map { it.build() },
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

      public fun build(): Manifest =
        Manifest(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          rendering = rendering?.build(),
          resource = resource.map { it.build() },
          page = page.map { it.build() },
          image = image.map { it.build() },
          other = other.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * An absolute URI that is used to identify this implementation guide when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this implementation guide is (or will be) published. This URL can be the target
     * of a canonical reference. It SHALL remain the same when the implementation guide is stored on
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
     * without the revision number, e.g. [publication].[major].[minor], which is 4.3.0. for this
     * version.
     *
     * Most implementation guides target a single version - e.g. they describe how to use a
     * particular version, and the profiles and examples etc are valid for that version. But some
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
     * The identifier that is used to identify this version of the implementation guide when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the implementation guide author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different implementation guide instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the implementation guide with the format
     * [url]|[version].
     */
    public var version: String.Builder? = null

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
     * The date (and optionally time) when the implementation guide was published. The date must
     * change when the business version changes and it must change if the status code changes. In
     * addition, it should change when the substantive content of the implementation guide changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the implementation guide. Additional specific dates may be
     * added as extensions or be found by consulting Provenances associated with past versions of
     * the resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the implementation guide.
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
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A copyright statement relating to the implementation guide and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the implementation
     * guide.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * The license that applies to this Implementation Guide, using an SPDX license code, or
     * 'not-open-source'.
     */
    public var license: Enumeration<SPDXLicense>? = null

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
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url.build(),
        version = version?.build(),
        name = name.build(),
        title = title?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        copyright = copyright?.build(),
        packageId = packageId.build(),
        license = license,
        fhirVersion = fhirVersion,
        dependsOn = dependsOn.map { it.build() },
        global = global.map { it.build() },
        definition = definition?.build(),
        manifest = manifest?.build(),
      )
  }

  /** A code that indicates how the page is generated. */
  public enum class GuidePageGeneration(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Html("html", "http://hl7.org/fhir/guide-page-generation", "HTML"),
    Markdown("markdown", "http://hl7.org/fhir/guide-page-generation", "Markdown"),
    Xml("xml", "http://hl7.org/fhir/guide-page-generation", "XML"),
    Generated("generated", "http://hl7.org/fhir/guide-page-generation", "Generated");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): GuidePageGeneration =
        when (code) {
          "html" -> Html
          "markdown" -> Markdown
          "xml" -> Xml
          "generated" -> Generated
          else -> throw IllegalArgumentException("Unknown code $code for enum GuidePageGeneration")
        }
    }
  }

  /** Code of parameter that is input to the guide. */
  public enum class GuideParameterCode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Apply("apply", "http://hl7.org/fhir/guide-parameter-code", "Apply Metadata Value"),
    Path_Resource("path-resource", "http://hl7.org/fhir/guide-parameter-code", "Resource Path"),
    Path_Pages("path-pages", "http://hl7.org/fhir/guide-parameter-code", "Pages Path"),
    Path_Tx_Cache(
      "path-tx-cache",
      "http://hl7.org/fhir/guide-parameter-code",
      "Terminology Cache Path",
    ),
    Expansion_Parameter(
      "expansion-parameter",
      "http://hl7.org/fhir/guide-parameter-code",
      "Expansion Profile",
    ),
    Rule_Broken_Links(
      "rule-broken-links",
      "http://hl7.org/fhir/guide-parameter-code",
      "Broken Links Rule",
    ),
    Generate_Xml("generate-xml", "http://hl7.org/fhir/guide-parameter-code", "Generate XML"),
    Generate_Json("generate-json", "http://hl7.org/fhir/guide-parameter-code", "Generate JSON"),
    Generate_Turtle(
      "generate-turtle",
      "http://hl7.org/fhir/guide-parameter-code",
      "Generate Turtle",
    ),
    Html_Template("html-template", "http://hl7.org/fhir/guide-parameter-code", "HTML Template");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): GuideParameterCode =
        when (code) {
          "apply" -> Apply
          "path-resource" -> Path_Resource
          "path-pages" -> Path_Pages
          "path-tx-cache" -> Path_Tx_Cache
          "expansion-parameter" -> Expansion_Parameter
          "rule-broken-links" -> Rule_Broken_Links
          "generate-xml" -> Generate_Xml
          "generate-json" -> Generate_Json
          "generate-turtle" -> Generate_Turtle
          "html-template" -> Html_Template
          else -> throw IllegalArgumentException("Unknown code $code for enum GuideParameterCode")
        }
    }
  }

  /**
   * The license that applies to an Implementation Guide (using an SPDX license Identifiers, or
   * 'not-open-source'). The binding is required but new SPDX license Identifiers are allowed to be
   * used (https://spdx.org/licenses/).
   */
  public enum class SPDXLicense(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Not_Open_Source("not-open-source", "http://hl7.org/fhir/spdx-license", "Not open source"),
    _0BSD("0BSD", "http://hl7.org/fhir/spdx-license", "BSD Zero Clause License"),
    Aal("AAL", "http://hl7.org/fhir/spdx-license", "Attribution Assurance License"),
    Abstyles("Abstyles", "http://hl7.org/fhir/spdx-license", "Abstyles License"),
    Adobe_2006(
      "Adobe-2006",
      "http://hl7.org/fhir/spdx-license",
      "Adobe Systems Incorporated Source Code License Agreement",
    ),
    Adobe_Glyph("Adobe-Glyph", "http://hl7.org/fhir/spdx-license", "Adobe Glyph List License"),
    Adsl("ADSL", "http://hl7.org/fhir/spdx-license", "Amazon Digital Services License"),
    Afl_1_1("AFL-1.1", "http://hl7.org/fhir/spdx-license", "Academic Free License v1.1"),
    Afl_1_2("AFL-1.2", "http://hl7.org/fhir/spdx-license", "Academic Free License v1.2"),
    Afl_2_0("AFL-2.0", "http://hl7.org/fhir/spdx-license", "Academic Free License v2.0"),
    Afl_2_1("AFL-2.1", "http://hl7.org/fhir/spdx-license", "Academic Free License v2.1"),
    Afl_3_0("AFL-3.0", "http://hl7.org/fhir/spdx-license", "Academic Free License v3.0"),
    Afmparse("Afmparse", "http://hl7.org/fhir/spdx-license", "Afmparse License"),
    Agpl_1_0_Only(
      "AGPL-1.0-only",
      "http://hl7.org/fhir/spdx-license",
      "Affero General Public License v1.0 only",
    ),
    Agpl_1_0_Or_Later(
      "AGPL-1.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "Affero General Public License v1.0 or later",
    ),
    Agpl_3_0_Only(
      "AGPL-3.0-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Affero General Public License v3.0 only",
    ),
    Agpl_3_0_Or_Later(
      "AGPL-3.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Affero General Public License v3.0 or later",
    ),
    Aladdin("Aladdin", "http://hl7.org/fhir/spdx-license", "Aladdin Free Public License"),
    Amdplpa("AMDPLPA", "http://hl7.org/fhir/spdx-license", "AMD's plpa_map.c License"),
    Aml("AML", "http://hl7.org/fhir/spdx-license", "Apple MIT License"),
    Ampas(
      "AMPAS",
      "http://hl7.org/fhir/spdx-license",
      "Academy of Motion Picture Arts and Sciences BSD",
    ),
    Antlr_Pd("ANTLR-PD", "http://hl7.org/fhir/spdx-license", "ANTLR Software Rights Notice"),
    Apache_1_0("Apache-1.0", "http://hl7.org/fhir/spdx-license", "Apache License 1.0"),
    Apache_1_1("Apache-1.1", "http://hl7.org/fhir/spdx-license", "Apache License 1.1"),
    Apache_2_0("Apache-2.0", "http://hl7.org/fhir/spdx-license", "Apache License 2.0"),
    Apafml("APAFML", "http://hl7.org/fhir/spdx-license", "Adobe Postscript AFM License"),
    Apl_1_0("APL-1.0", "http://hl7.org/fhir/spdx-license", "Adaptive Public License 1.0"),
    Apsl_1_0("APSL-1.0", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 1.0"),
    Apsl_1_1("APSL-1.1", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 1.1"),
    Apsl_1_2("APSL-1.2", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 1.2"),
    Apsl_2_0("APSL-2.0", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 2.0"),
    Artistic_1_0_Cl8(
      "Artistic-1.0-cl8",
      "http://hl7.org/fhir/spdx-license",
      "Artistic License 1.0 w/clause 8",
    ),
    Artistic_1_0_Perl(
      "Artistic-1.0-Perl",
      "http://hl7.org/fhir/spdx-license",
      "Artistic License 1.0 (Perl)",
    ),
    Artistic_1_0("Artistic-1.0", "http://hl7.org/fhir/spdx-license", "Artistic License 1.0"),
    Artistic_2_0("Artistic-2.0", "http://hl7.org/fhir/spdx-license", "Artistic License 2.0"),
    Bahyph("Bahyph", "http://hl7.org/fhir/spdx-license", "Bahyph License"),
    Barr("Barr", "http://hl7.org/fhir/spdx-license", "Barr License"),
    Beerware("Beerware", "http://hl7.org/fhir/spdx-license", "Beerware License"),
    BitTorrent_1_0(
      "BitTorrent-1.0",
      "http://hl7.org/fhir/spdx-license",
      "BitTorrent Open Source License v1.0",
    ),
    BitTorrent_1_1(
      "BitTorrent-1.1",
      "http://hl7.org/fhir/spdx-license",
      "BitTorrent Open Source License v1.1",
    ),
    Borceux("Borceux", "http://hl7.org/fhir/spdx-license", "Borceux license"),
    Bsd_1_Clause("BSD-1-Clause", "http://hl7.org/fhir/spdx-license", "BSD 1-Clause License"),
    Bsd_2_Clause_FreeBSD(
      "BSD-2-Clause-FreeBSD",
      "http://hl7.org/fhir/spdx-license",
      "BSD 2-Clause FreeBSD License",
    ),
    Bsd_2_Clause_NetBSD(
      "BSD-2-Clause-NetBSD",
      "http://hl7.org/fhir/spdx-license",
      "BSD 2-Clause NetBSD License",
    ),
    Bsd_2_Clause_Patent(
      "BSD-2-Clause-Patent",
      "http://hl7.org/fhir/spdx-license",
      "BSD-2-Clause Plus Patent License",
    ),
    Bsd_2_Clause(
      "BSD-2-Clause",
      "http://hl7.org/fhir/spdx-license",
      "BSD 2-Clause \"Simplified\" License",
    ),
    Bsd_3_Clause_Attribution(
      "BSD-3-Clause-Attribution",
      "http://hl7.org/fhir/spdx-license",
      "BSD with attribution",
    ),
    Bsd_3_Clause_Clear(
      "BSD-3-Clause-Clear",
      "http://hl7.org/fhir/spdx-license",
      "BSD 3-Clause Clear License",
    ),
    Bsd_3_Clause_Lbnl(
      "BSD-3-Clause-LBNL",
      "http://hl7.org/fhir/spdx-license",
      "Lawrence Berkeley National Labs BSD variant license",
    ),
    Bsd_3_Clause_No_Nuclear_License_2014(
      "BSD-3-Clause-No-Nuclear-License-2014",
      "http://hl7.org/fhir/spdx-license",
      "BSD 3-Clause No Nuclear License 2014",
    ),
    Bsd_3_Clause_No_Nuclear_License(
      "BSD-3-Clause-No-Nuclear-License",
      "http://hl7.org/fhir/spdx-license",
      "BSD 3-Clause No Nuclear License",
    ),
    Bsd_3_Clause_No_Nuclear_Warranty(
      "BSD-3-Clause-No-Nuclear-Warranty",
      "http://hl7.org/fhir/spdx-license",
      "BSD 3-Clause No Nuclear Warranty",
    ),
    Bsd_3_Clause(
      "BSD-3-Clause",
      "http://hl7.org/fhir/spdx-license",
      "BSD 3-Clause \"New\" or \"Revised\" License",
    ),
    Bsd_4_Clause_Uc(
      "BSD-4-Clause-UC",
      "http://hl7.org/fhir/spdx-license",
      "BSD-4-Clause (University of California-Specific)",
    ),
    Bsd_4_Clause(
      "BSD-4-Clause",
      "http://hl7.org/fhir/spdx-license",
      "BSD 4-Clause \"Original\" or \"Old\" License",
    ),
    Bsd_Protection("BSD-Protection", "http://hl7.org/fhir/spdx-license", "BSD Protection License"),
    Bsd_Source_Code(
      "BSD-Source-Code",
      "http://hl7.org/fhir/spdx-license",
      "BSD Source Code Attribution",
    ),
    Bsl_1_0("BSL-1.0", "http://hl7.org/fhir/spdx-license", "Boost Software License 1.0"),
    Bzip2_1_0_5(
      "bzip2-1.0.5",
      "http://hl7.org/fhir/spdx-license",
      "bzip2 and libbzip2 License v1.0.5",
    ),
    Bzip2_1_0_6(
      "bzip2-1.0.6",
      "http://hl7.org/fhir/spdx-license",
      "bzip2 and libbzip2 License v1.0.6",
    ),
    Caldera("Caldera", "http://hl7.org/fhir/spdx-license", "Caldera License"),
    Catosl_1_1(
      "CATOSL-1.1",
      "http://hl7.org/fhir/spdx-license",
      "Computer Associates Trusted Open Source License 1.1",
    ),
    Cc_By_1_0(
      "CC-BY-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution 1.0 Generic",
    ),
    Cc_By_2_0(
      "CC-BY-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution 2.0 Generic",
    ),
    Cc_By_2_5(
      "CC-BY-2.5",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution 2.5 Generic",
    ),
    Cc_By_3_0(
      "CC-BY-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution 3.0 Unported",
    ),
    Cc_By_4_0(
      "CC-BY-4.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution 4.0 International",
    ),
    Cc_By_Nc_1_0(
      "CC-BY-NC-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial 1.0 Generic",
    ),
    Cc_By_Nc_2_0(
      "CC-BY-NC-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial 2.0 Generic",
    ),
    Cc_By_Nc_2_5(
      "CC-BY-NC-2.5",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial 2.5 Generic",
    ),
    Cc_By_Nc_3_0(
      "CC-BY-NC-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial 3.0 Unported",
    ),
    Cc_By_Nc_4_0(
      "CC-BY-NC-4.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial 4.0 International",
    ),
    Cc_By_Nc_Nd_1_0(
      "CC-BY-NC-ND-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial No Derivatives 1.0 Generic",
    ),
    Cc_By_Nc_Nd_2_0(
      "CC-BY-NC-ND-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial No Derivatives 2.0 Generic",
    ),
    Cc_By_Nc_Nd_2_5(
      "CC-BY-NC-ND-2.5",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial No Derivatives 2.5 Generic",
    ),
    Cc_By_Nc_Nd_3_0(
      "CC-BY-NC-ND-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial No Derivatives 3.0 Unported",
    ),
    Cc_By_Nc_Nd_4_0(
      "CC-BY-NC-ND-4.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial No Derivatives 4.0 International",
    ),
    Cc_By_Nc_Sa_1_0(
      "CC-BY-NC-SA-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial Share Alike 1.0 Generic",
    ),
    Cc_By_Nc_Sa_2_0(
      "CC-BY-NC-SA-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial Share Alike 2.0 Generic",
    ),
    Cc_By_Nc_Sa_2_5(
      "CC-BY-NC-SA-2.5",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial Share Alike 2.5 Generic",
    ),
    Cc_By_Nc_Sa_3_0(
      "CC-BY-NC-SA-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial Share Alike 3.0 Unported",
    ),
    Cc_By_Nc_Sa_4_0(
      "CC-BY-NC-SA-4.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Non Commercial Share Alike 4.0 International",
    ),
    Cc_By_Nd_1_0(
      "CC-BY-ND-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution No Derivatives 1.0 Generic",
    ),
    Cc_By_Nd_2_0(
      "CC-BY-ND-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution No Derivatives 2.0 Generic",
    ),
    Cc_By_Nd_2_5(
      "CC-BY-ND-2.5",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution No Derivatives 2.5 Generic",
    ),
    Cc_By_Nd_3_0(
      "CC-BY-ND-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution No Derivatives 3.0 Unported",
    ),
    Cc_By_Nd_4_0(
      "CC-BY-ND-4.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution No Derivatives 4.0 International",
    ),
    Cc_By_Sa_1_0(
      "CC-BY-SA-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Share Alike 1.0 Generic",
    ),
    Cc_By_Sa_2_0(
      "CC-BY-SA-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Share Alike 2.0 Generic",
    ),
    Cc_By_Sa_2_5(
      "CC-BY-SA-2.5",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Share Alike 2.5 Generic",
    ),
    Cc_By_Sa_3_0(
      "CC-BY-SA-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Share Alike 3.0 Unported",
    ),
    Cc_By_Sa_4_0(
      "CC-BY-SA-4.0",
      "http://hl7.org/fhir/spdx-license",
      "Creative Commons Attribution Share Alike 4.0 International",
    ),
    CC0_1_0("CC0-1.0", "http://hl7.org/fhir/spdx-license", "Creative Commons Zero v1.0 Universal"),
    Cddl_1_0(
      "CDDL-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Common Development and Distribution License 1.0",
    ),
    Cddl_1_1(
      "CDDL-1.1",
      "http://hl7.org/fhir/spdx-license",
      "Common Development and Distribution License 1.1",
    ),
    Cdla_Permissive_1_0(
      "CDLA-Permissive-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Community Data License Agreement Permissive 1.0",
    ),
    Cdla_Sharing_1_0(
      "CDLA-Sharing-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Community Data License Agreement Sharing 1.0",
    ),
    Cecill_1_0(
      "CECILL-1.0",
      "http://hl7.org/fhir/spdx-license",
      "CeCILL Free Software License Agreement v1.0",
    ),
    Cecill_1_1(
      "CECILL-1.1",
      "http://hl7.org/fhir/spdx-license",
      "CeCILL Free Software License Agreement v1.1",
    ),
    Cecill_2_0(
      "CECILL-2.0",
      "http://hl7.org/fhir/spdx-license",
      "CeCILL Free Software License Agreement v2.0",
    ),
    Cecill_2_1(
      "CECILL-2.1",
      "http://hl7.org/fhir/spdx-license",
      "CeCILL Free Software License Agreement v2.1",
    ),
    Cecill_B(
      "CECILL-B",
      "http://hl7.org/fhir/spdx-license",
      "CeCILL-B Free Software License Agreement",
    ),
    Cecill_C(
      "CECILL-C",
      "http://hl7.org/fhir/spdx-license",
      "CeCILL-C Free Software License Agreement",
    ),
    ClArtistic("ClArtistic", "http://hl7.org/fhir/spdx-license", "Clarified Artistic License"),
    Cnri_Jython("CNRI-Jython", "http://hl7.org/fhir/spdx-license", "CNRI Jython License"),
    Cnri_Python_Gpl_Compatible(
      "CNRI-Python-GPL-Compatible",
      "http://hl7.org/fhir/spdx-license",
      "CNRI Python Open Source GPL Compatible License Agreement",
    ),
    Cnri_Python("CNRI-Python", "http://hl7.org/fhir/spdx-license", "CNRI Python License"),
    Condor_1_1("Condor-1.1", "http://hl7.org/fhir/spdx-license", "Condor Public License v1.1"),
    Cpal_1_0(
      "CPAL-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Common Public Attribution License 1.0",
    ),
    Cpl_1_0("CPL-1.0", "http://hl7.org/fhir/spdx-license", "Common Public License 1.0"),
    Cpol_1_02("CPOL-1.02", "http://hl7.org/fhir/spdx-license", "Code Project Open License 1.02"),
    Crossword("Crossword", "http://hl7.org/fhir/spdx-license", "Crossword License"),
    CrystalStacker("CrystalStacker", "http://hl7.org/fhir/spdx-license", "CrystalStacker License"),
    Cua_Opl_1_0(
      "CUA-OPL-1.0",
      "http://hl7.org/fhir/spdx-license",
      "CUA Office Public License v1.0",
    ),
    Cube("Cube", "http://hl7.org/fhir/spdx-license", "Cube License"),
    Curl("curl", "http://hl7.org/fhir/spdx-license", "curl License"),
    D_Fsl_1_0("D-FSL-1.0", "http://hl7.org/fhir/spdx-license", "Deutsche Freie Software Lizenz"),
    Diffmark("diffmark", "http://hl7.org/fhir/spdx-license", "diffmark license"),
    Doc("DOC", "http://hl7.org/fhir/spdx-license", "DOC License"),
    Dotseqn("Dotseqn", "http://hl7.org/fhir/spdx-license", "Dotseqn License"),
    Dsdp("DSDP", "http://hl7.org/fhir/spdx-license", "DSDP License"),
    Dvipdfm("dvipdfm", "http://hl7.org/fhir/spdx-license", "dvipdfm License"),
    Ecl_1_0("ECL-1.0", "http://hl7.org/fhir/spdx-license", "Educational Community License v1.0"),
    Ecl_2_0("ECL-2.0", "http://hl7.org/fhir/spdx-license", "Educational Community License v2.0"),
    Efl_1_0("EFL-1.0", "http://hl7.org/fhir/spdx-license", "Eiffel Forum License v1.0"),
    Efl_2_0("EFL-2.0", "http://hl7.org/fhir/spdx-license", "Eiffel Forum License v2.0"),
    EGenix("eGenix", "http://hl7.org/fhir/spdx-license", "eGenix.com Public License 1.1.0"),
    Entessa("Entessa", "http://hl7.org/fhir/spdx-license", "Entessa Public License v1.0"),
    Epl_1_0("EPL-1.0", "http://hl7.org/fhir/spdx-license", "Eclipse Public License 1.0"),
    Epl_2_0("EPL-2.0", "http://hl7.org/fhir/spdx-license", "Eclipse Public License 2.0"),
    ErlPL_1_1("ErlPL-1.1", "http://hl7.org/fhir/spdx-license", "Erlang Public License v1.1"),
    EUDatagrid("EUDatagrid", "http://hl7.org/fhir/spdx-license", "EU DataGrid Software License"),
    Eupl_1_0("EUPL-1.0", "http://hl7.org/fhir/spdx-license", "European Union Public License 1.0"),
    Eupl_1_1("EUPL-1.1", "http://hl7.org/fhir/spdx-license", "European Union Public License 1.1"),
    Eupl_1_2("EUPL-1.2", "http://hl7.org/fhir/spdx-license", "European Union Public License 1.2"),
    Eurosym("Eurosym", "http://hl7.org/fhir/spdx-license", "Eurosym License"),
    Fair("Fair", "http://hl7.org/fhir/spdx-license", "Fair License"),
    Frameworx_1_0(
      "Frameworx-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Frameworx Open License 1.0",
    ),
    FreeImage("FreeImage", "http://hl7.org/fhir/spdx-license", "FreeImage Public License v1.0"),
    Fsfap("FSFAP", "http://hl7.org/fhir/spdx-license", "FSF All Permissive License"),
    Fsful("FSFUL", "http://hl7.org/fhir/spdx-license", "FSF Unlimited License"),
    Fsfullr(
      "FSFULLR",
      "http://hl7.org/fhir/spdx-license",
      "FSF Unlimited License (with License Retention)",
    ),
    Ftl("FTL", "http://hl7.org/fhir/spdx-license", "Freetype Project License"),
    Gfdl_1_1_Only(
      "GFDL-1.1-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Free Documentation License v1.1 only",
    ),
    Gfdl_1_1_Or_Later(
      "GFDL-1.1-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Free Documentation License v1.1 or later",
    ),
    Gfdl_1_2_Only(
      "GFDL-1.2-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Free Documentation License v1.2 only",
    ),
    Gfdl_1_2_Or_Later(
      "GFDL-1.2-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Free Documentation License v1.2 or later",
    ),
    Gfdl_1_3_Only(
      "GFDL-1.3-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Free Documentation License v1.3 only",
    ),
    Gfdl_1_3_Or_Later(
      "GFDL-1.3-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Free Documentation License v1.3 or later",
    ),
    Giftware("Giftware", "http://hl7.org/fhir/spdx-license", "Giftware License"),
    GL2PS("GL2PS", "http://hl7.org/fhir/spdx-license", "GL2PS License"),
    Glide("Glide", "http://hl7.org/fhir/spdx-license", "3dfx Glide License"),
    Glulxe("Glulxe", "http://hl7.org/fhir/spdx-license", "Glulxe License"),
    Gnuplot("gnuplot", "http://hl7.org/fhir/spdx-license", "gnuplot License"),
    Gpl_1_0_Only(
      "GPL-1.0-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU General Public License v1.0 only",
    ),
    Gpl_1_0_Or_Later(
      "GPL-1.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU General Public License v1.0 or later",
    ),
    Gpl_2_0_Only(
      "GPL-2.0-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU General Public License v2.0 only",
    ),
    Gpl_2_0_Or_Later(
      "GPL-2.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU General Public License v2.0 or later",
    ),
    Gpl_3_0_Only(
      "GPL-3.0-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU General Public License v3.0 only",
    ),
    Gpl_3_0_Or_Later(
      "GPL-3.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU General Public License v3.0 or later",
    ),
    GSOAP_1_3b("gSOAP-1.3b", "http://hl7.org/fhir/spdx-license", "gSOAP Public License v1.3b"),
    HaskellReport(
      "HaskellReport",
      "http://hl7.org/fhir/spdx-license",
      "Haskell Language Report License",
    ),
    Hpnd("HPND", "http://hl7.org/fhir/spdx-license", "Historical Permission Notice and Disclaimer"),
    Ibm_Pibs(
      "IBM-pibs",
      "http://hl7.org/fhir/spdx-license",
      "IBM PowerPC Initialization and Boot Software",
    ),
    Icu("ICU", "http://hl7.org/fhir/spdx-license", "ICU License"),
    Ijg("IJG", "http://hl7.org/fhir/spdx-license", "Independent JPEG Group License"),
    ImageMagick("ImageMagick", "http://hl7.org/fhir/spdx-license", "ImageMagick License"),
    IMatix(
      "iMatix",
      "http://hl7.org/fhir/spdx-license",
      "iMatix Standard Function Library Agreement",
    ),
    Imlib2("Imlib2", "http://hl7.org/fhir/spdx-license", "Imlib2 License"),
    Info_Zip("Info-ZIP", "http://hl7.org/fhir/spdx-license", "Info-ZIP License"),
    Intel_Acpi(
      "Intel-ACPI",
      "http://hl7.org/fhir/spdx-license",
      "Intel ACPI Software License Agreement",
    ),
    Intel("Intel", "http://hl7.org/fhir/spdx-license", "Intel Open Source License"),
    Interbase_1_0(
      "Interbase-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Interbase Public License v1.0",
    ),
    Ipa("IPA", "http://hl7.org/fhir/spdx-license", "IPA Font License"),
    Ipl_1_0("IPL-1.0", "http://hl7.org/fhir/spdx-license", "IBM Public License v1.0"),
    Isc("ISC", "http://hl7.org/fhir/spdx-license", "ISC License"),
    JasPer_2_0("JasPer-2.0", "http://hl7.org/fhir/spdx-license", "JasPer License"),
    Json("JSON", "http://hl7.org/fhir/spdx-license", "JSON License"),
    Lal_1_2("LAL-1.2", "http://hl7.org/fhir/spdx-license", "Licence Art Libre 1.2"),
    Lal_1_3("LAL-1.3", "http://hl7.org/fhir/spdx-license", "Licence Art Libre 1.3"),
    Latex2e("Latex2e", "http://hl7.org/fhir/spdx-license", "Latex2e License"),
    Leptonica("Leptonica", "http://hl7.org/fhir/spdx-license", "Leptonica License"),
    Lgpl_2_0_Only(
      "LGPL-2.0-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Library General Public License v2 only",
    ),
    Lgpl_2_0_Or_Later(
      "LGPL-2.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Library General Public License v2 or later",
    ),
    Lgpl_2_1_Only(
      "LGPL-2.1-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Lesser General Public License v2.1 only",
    ),
    Lgpl_2_1_Or_Later(
      "LGPL-2.1-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Lesser General Public License v2.1 or later",
    ),
    Lgpl_3_0_Only(
      "LGPL-3.0-only",
      "http://hl7.org/fhir/spdx-license",
      "GNU Lesser General Public License v3.0 only",
    ),
    Lgpl_3_0_Or_Later(
      "LGPL-3.0-or-later",
      "http://hl7.org/fhir/spdx-license",
      "GNU Lesser General Public License v3.0 or later",
    ),
    Lgpllr(
      "LGPLLR",
      "http://hl7.org/fhir/spdx-license",
      "Lesser General Public License For Linguistic Resources",
    ),
    Libpng("Libpng", "http://hl7.org/fhir/spdx-license", "libpng License"),
    Libtiff("libtiff", "http://hl7.org/fhir/spdx-license", "libtiff License"),
    LiLiQ_P_1_1(
      "LiLiQ-P-1.1",
      "http://hl7.org/fhir/spdx-license",
      "Licence Libre du Québec – Permissive version 1.1",
    ),
    LiLiQ_R_1_1(
      "LiLiQ-R-1.1",
      "http://hl7.org/fhir/spdx-license",
      "Licence Libre du Québec – Réciprocité version 1.1",
    ),
    LiLiQ_Rplus_1_1(
      "LiLiQ-Rplus-1.1",
      "http://hl7.org/fhir/spdx-license",
      "Licence Libre du Québec – Réciprocité forte version 1.1",
    ),
    Linux_OpenIB(
      "Linux-OpenIB",
      "http://hl7.org/fhir/spdx-license",
      "Linux Kernel Variant of OpenIB.org license",
    ),
    Lpl_1_0("LPL-1.0", "http://hl7.org/fhir/spdx-license", "Lucent Public License Version 1.0"),
    Lpl_1_02("LPL-1.02", "http://hl7.org/fhir/spdx-license", "Lucent Public License v1.02"),
    Lppl_1_0("LPPL-1.0", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.0"),
    Lppl_1_1("LPPL-1.1", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.1"),
    Lppl_1_2("LPPL-1.2", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.2"),
    Lppl_1_3a(
      "LPPL-1.3a",
      "http://hl7.org/fhir/spdx-license",
      "LaTeX Project Public License v1.3a",
    ),
    Lppl_1_3c(
      "LPPL-1.3c",
      "http://hl7.org/fhir/spdx-license",
      "LaTeX Project Public License v1.3c",
    ),
    MakeIndex("MakeIndex", "http://hl7.org/fhir/spdx-license", "MakeIndex License"),
    MirOS("MirOS", "http://hl7.org/fhir/spdx-license", "MirOS License"),
    Mit_0("MIT-0", "http://hl7.org/fhir/spdx-license", "MIT No Attribution"),
    Mit_Advertising(
      "MIT-advertising",
      "http://hl7.org/fhir/spdx-license",
      "Enlightenment License (e16)",
    ),
    Mit_Cmu("MIT-CMU", "http://hl7.org/fhir/spdx-license", "CMU License"),
    Mit_Enna("MIT-enna", "http://hl7.org/fhir/spdx-license", "enna License"),
    Mit_Feh("MIT-feh", "http://hl7.org/fhir/spdx-license", "feh License"),
    Mit("MIT", "http://hl7.org/fhir/spdx-license", "MIT License"),
    Mitnfa("MITNFA", "http://hl7.org/fhir/spdx-license", "MIT +no-false-attribs license"),
    Motosoto("Motosoto", "http://hl7.org/fhir/spdx-license", "Motosoto License"),
    Mpich2("mpich2", "http://hl7.org/fhir/spdx-license", "mpich2 License"),
    Mpl_1_0("MPL-1.0", "http://hl7.org/fhir/spdx-license", "Mozilla Public License 1.0"),
    Mpl_1_1("MPL-1.1", "http://hl7.org/fhir/spdx-license", "Mozilla Public License 1.1"),
    Mpl_2_0_No_Copyleft_Exception(
      "MPL-2.0-no-copyleft-exception",
      "http://hl7.org/fhir/spdx-license",
      "Mozilla Public License 2.0 (no copyleft exception)",
    ),
    Mpl_2_0("MPL-2.0", "http://hl7.org/fhir/spdx-license", "Mozilla Public License 2.0"),
    Ms_Pl("MS-PL", "http://hl7.org/fhir/spdx-license", "Microsoft Public License"),
    Ms_Rl("MS-RL", "http://hl7.org/fhir/spdx-license", "Microsoft Reciprocal License"),
    Mtll("MTLL", "http://hl7.org/fhir/spdx-license", "Matrix Template Library License"),
    Multics("Multics", "http://hl7.org/fhir/spdx-license", "Multics License"),
    Mup("Mup", "http://hl7.org/fhir/spdx-license", "Mup License"),
    Nasa_1_3("NASA-1.3", "http://hl7.org/fhir/spdx-license", "NASA Open Source Agreement 1.3"),
    Naumen("Naumen", "http://hl7.org/fhir/spdx-license", "Naumen Public License"),
    Nbpl_1_0("NBPL-1.0", "http://hl7.org/fhir/spdx-license", "Net Boolean Public License v1"),
    Ncsa(
      "NCSA",
      "http://hl7.org/fhir/spdx-license",
      "University of Illinois/NCSA Open Source License",
    ),
    Net_Snmp("Net-SNMP", "http://hl7.org/fhir/spdx-license", "Net-SNMP License"),
    NetCDF("NetCDF", "http://hl7.org/fhir/spdx-license", "NetCDF license"),
    Newsletr("Newsletr", "http://hl7.org/fhir/spdx-license", "Newsletr License"),
    Ngpl("NGPL", "http://hl7.org/fhir/spdx-license", "Nethack General Public License"),
    Nlod_1_0(
      "NLOD-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Norwegian Licence for Open Government Data",
    ),
    Nlpl("NLPL", "http://hl7.org/fhir/spdx-license", "No Limit Public License"),
    Nokia("Nokia", "http://hl7.org/fhir/spdx-license", "Nokia Open Source License"),
    Nosl("NOSL", "http://hl7.org/fhir/spdx-license", "Netizen Open Source License"),
    Noweb("Noweb", "http://hl7.org/fhir/spdx-license", "Noweb License"),
    Npl_1_0("NPL-1.0", "http://hl7.org/fhir/spdx-license", "Netscape Public License v1.0"),
    Npl_1_1("NPL-1.1", "http://hl7.org/fhir/spdx-license", "Netscape Public License v1.1"),
    Nposl_3_0(
      "NPOSL-3.0",
      "http://hl7.org/fhir/spdx-license",
      "Non-Profit Open Software License 3.0",
    ),
    Nrl("NRL", "http://hl7.org/fhir/spdx-license", "NRL License"),
    Ntp("NTP", "http://hl7.org/fhir/spdx-license", "NTP License"),
    Occt_Pl(
      "OCCT-PL",
      "http://hl7.org/fhir/spdx-license",
      "Open CASCADE Technology Public License",
    ),
    Oclc_2_0("OCLC-2.0", "http://hl7.org/fhir/spdx-license", "OCLC Research Public License 2.0"),
    ODbL_1_0("ODbL-1.0", "http://hl7.org/fhir/spdx-license", "ODC Open Database License v1.0"),
    Ofl_1_0("OFL-1.0", "http://hl7.org/fhir/spdx-license", "SIL Open Font License 1.0"),
    Ofl_1_1("OFL-1.1", "http://hl7.org/fhir/spdx-license", "SIL Open Font License 1.1"),
    Ogtsl("OGTSL", "http://hl7.org/fhir/spdx-license", "Open Group Test Suite License"),
    Oldap_1_1("OLDAP-1.1", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.1"),
    Oldap_1_2("OLDAP-1.2", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.2"),
    Oldap_1_3("OLDAP-1.3", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.3"),
    Oldap_1_4("OLDAP-1.4", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.4"),
    Oldap_2_0_1(
      "OLDAP-2.0.1",
      "http://hl7.org/fhir/spdx-license",
      "Open LDAP Public License v2.0.1",
    ),
    Oldap_2_0(
      "OLDAP-2.0",
      "http://hl7.org/fhir/spdx-license",
      "Open LDAP Public License v2.0 (or possibly 2.0A and 2.0B)",
    ),
    Oldap_2_1("OLDAP-2.1", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.1"),
    Oldap_2_2_1(
      "OLDAP-2.2.1",
      "http://hl7.org/fhir/spdx-license",
      "Open LDAP Public License v2.2.1",
    ),
    Oldap_2_2_2(
      "OLDAP-2.2.2",
      "http://hl7.org/fhir/spdx-license",
      "Open LDAP Public License 2.2.2",
    ),
    Oldap_2_2("OLDAP-2.2", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.2"),
    Oldap_2_3("OLDAP-2.3", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.3"),
    Oldap_2_4("OLDAP-2.4", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.4"),
    Oldap_2_5("OLDAP-2.5", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.5"),
    Oldap_2_6("OLDAP-2.6", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.6"),
    Oldap_2_7("OLDAP-2.7", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.7"),
    Oldap_2_8("OLDAP-2.8", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.8"),
    Oml("OML", "http://hl7.org/fhir/spdx-license", "Open Market License"),
    OpenSSL("OpenSSL", "http://hl7.org/fhir/spdx-license", "OpenSSL License"),
    Opl_1_0("OPL-1.0", "http://hl7.org/fhir/spdx-license", "Open Public License v1.0"),
    Oset_Pl_2_1(
      "OSET-PL-2.1",
      "http://hl7.org/fhir/spdx-license",
      "OSET Public License version 2.1",
    ),
    Osl_1_0("OSL-1.0", "http://hl7.org/fhir/spdx-license", "Open Software License 1.0"),
    Osl_1_1("OSL-1.1", "http://hl7.org/fhir/spdx-license", "Open Software License 1.1"),
    Osl_2_0("OSL-2.0", "http://hl7.org/fhir/spdx-license", "Open Software License 2.0"),
    Osl_2_1("OSL-2.1", "http://hl7.org/fhir/spdx-license", "Open Software License 2.1"),
    Osl_3_0("OSL-3.0", "http://hl7.org/fhir/spdx-license", "Open Software License 3.0"),
    Pddl_1_0(
      "PDDL-1.0",
      "http://hl7.org/fhir/spdx-license",
      "ODC Public Domain Dedication & License 1.0",
    ),
    Php_3_0("PHP-3.0", "http://hl7.org/fhir/spdx-license", "PHP License v3.0"),
    Php_3_01("PHP-3.01", "http://hl7.org/fhir/spdx-license", "PHP License v3.01"),
    Plexus("Plexus", "http://hl7.org/fhir/spdx-license", "Plexus Classworlds License"),
    PostgreSQL("PostgreSQL", "http://hl7.org/fhir/spdx-license", "PostgreSQL License"),
    Psfrag("psfrag", "http://hl7.org/fhir/spdx-license", "psfrag License"),
    Psutils("psutils", "http://hl7.org/fhir/spdx-license", "psutils License"),
    Python_2_0("Python-2.0", "http://hl7.org/fhir/spdx-license", "Python License 2.0"),
    Qhull("Qhull", "http://hl7.org/fhir/spdx-license", "Qhull License"),
    Qpl_1_0("QPL-1.0", "http://hl7.org/fhir/spdx-license", "Q Public License 1.0"),
    Rdisc("Rdisc", "http://hl7.org/fhir/spdx-license", "Rdisc License"),
    RHeCos_1_1(
      "RHeCos-1.1",
      "http://hl7.org/fhir/spdx-license",
      "Red Hat eCos Public License v1.1",
    ),
    Rpl_1_1("RPL-1.1", "http://hl7.org/fhir/spdx-license", "Reciprocal Public License 1.1"),
    Rpl_1_5("RPL-1.5", "http://hl7.org/fhir/spdx-license", "Reciprocal Public License 1.5"),
    Rpsl_1_0(
      "RPSL-1.0",
      "http://hl7.org/fhir/spdx-license",
      "RealNetworks Public Source License v1.0",
    ),
    Rsa_Md("RSA-MD", "http://hl7.org/fhir/spdx-license", "RSA Message-Digest License"),
    Rscpl("RSCPL", "http://hl7.org/fhir/spdx-license", "Ricoh Source Code Public License"),
    Ruby("Ruby", "http://hl7.org/fhir/spdx-license", "Ruby License"),
    Sax_Pd("SAX-PD", "http://hl7.org/fhir/spdx-license", "Sax Public Domain Notice"),
    Saxpath("Saxpath", "http://hl7.org/fhir/spdx-license", "Saxpath License"),
    Scea("SCEA", "http://hl7.org/fhir/spdx-license", "SCEA Shared Source License"),
    Sendmail("Sendmail", "http://hl7.org/fhir/spdx-license", "Sendmail License"),
    Sgi_B_1_0("SGI-B-1.0", "http://hl7.org/fhir/spdx-license", "SGI Free Software License B v1.0"),
    Sgi_B_1_1("SGI-B-1.1", "http://hl7.org/fhir/spdx-license", "SGI Free Software License B v1.1"),
    Sgi_B_2_0("SGI-B-2.0", "http://hl7.org/fhir/spdx-license", "SGI Free Software License B v2.0"),
    SimPL_2_0("SimPL-2.0", "http://hl7.org/fhir/spdx-license", "Simple Public License 2.0"),
    Sissl_1_2(
      "SISSL-1.2",
      "http://hl7.org/fhir/spdx-license",
      "Sun Industry Standards Source License v1.2",
    ),
    Sissl(
      "SISSL",
      "http://hl7.org/fhir/spdx-license",
      "Sun Industry Standards Source License v1.1",
    ),
    Sleepycat("Sleepycat", "http://hl7.org/fhir/spdx-license", "Sleepycat License"),
    Smlnj("SMLNJ", "http://hl7.org/fhir/spdx-license", "Standard ML of New Jersey License"),
    Smppl("SMPPL", "http://hl7.org/fhir/spdx-license", "Secure Messaging Protocol Public License"),
    Snia("SNIA", "http://hl7.org/fhir/spdx-license", "SNIA Public License 1.1"),
    Spencer_86("Spencer-86", "http://hl7.org/fhir/spdx-license", "Spencer License 86"),
    Spencer_94("Spencer-94", "http://hl7.org/fhir/spdx-license", "Spencer License 94"),
    Spencer_99("Spencer-99", "http://hl7.org/fhir/spdx-license", "Spencer License 99"),
    Spl_1_0("SPL-1.0", "http://hl7.org/fhir/spdx-license", "Sun Public License v1.0"),
    SugarCRM_1_1_3(
      "SugarCRM-1.1.3",
      "http://hl7.org/fhir/spdx-license",
      "SugarCRM Public License v1.1.3",
    ),
    Swl(
      "SWL",
      "http://hl7.org/fhir/spdx-license",
      "Scheme Widget Library (SWL) Software License Agreement",
    ),
    Tcl("TCL", "http://hl7.org/fhir/spdx-license", "TCL/TK License"),
    Tcp_Wrappers("TCP-wrappers", "http://hl7.org/fhir/spdx-license", "TCP Wrappers License"),
    TMate("TMate", "http://hl7.org/fhir/spdx-license", "TMate Open Source License"),
    Torque_1_1(
      "TORQUE-1.1",
      "http://hl7.org/fhir/spdx-license",
      "TORQUE v2.5+ Software License v1.1",
    ),
    Tosl("TOSL", "http://hl7.org/fhir/spdx-license", "Trusster Open Source License"),
    Unicode_Dfs_2015(
      "Unicode-DFS-2015",
      "http://hl7.org/fhir/spdx-license",
      "Unicode License Agreement - Data Files and Software (2015)",
    ),
    Unicode_Dfs_2016(
      "Unicode-DFS-2016",
      "http://hl7.org/fhir/spdx-license",
      "Unicode License Agreement - Data Files and Software (2016)",
    ),
    Unicode_Tou("Unicode-TOU", "http://hl7.org/fhir/spdx-license", "Unicode Terms of Use"),
    Unlicense("Unlicense", "http://hl7.org/fhir/spdx-license", "The Unlicense"),
    Upl_1_0("UPL-1.0", "http://hl7.org/fhir/spdx-license", "Universal Permissive License v1.0"),
    Vim("Vim", "http://hl7.org/fhir/spdx-license", "Vim License"),
    Vostrom(
      "VOSTROM",
      "http://hl7.org/fhir/spdx-license",
      "VOSTROM Public License for Open Source",
    ),
    Vsl_1_0("VSL-1.0", "http://hl7.org/fhir/spdx-license", "Vovida Software License v1.0"),
    W3C_19980720(
      "W3C-19980720",
      "http://hl7.org/fhir/spdx-license",
      "W3C Software Notice and License (1998-07-20)",
    ),
    W3C_20150513(
      "W3C-20150513",
      "http://hl7.org/fhir/spdx-license",
      "W3C Software Notice and Document License (2015-05-13)",
    ),
    W3C("W3C", "http://hl7.org/fhir/spdx-license", "W3C Software Notice and License (2002-12-31)"),
    Watcom_1_0(
      "Watcom-1.0",
      "http://hl7.org/fhir/spdx-license",
      "Sybase Open Watcom Public License 1.0",
    ),
    Wsuipa("Wsuipa", "http://hl7.org/fhir/spdx-license", "Wsuipa License"),
    Wtfpl(
      "WTFPL",
      "http://hl7.org/fhir/spdx-license",
      "Do What The F*ck You Want To Public License",
    ),
    X11("X11", "http://hl7.org/fhir/spdx-license", "X11 License"),
    Xerox("Xerox", "http://hl7.org/fhir/spdx-license", "Xerox License"),
    XFree86_1_1("XFree86-1.1", "http://hl7.org/fhir/spdx-license", "XFree86 License 1.1"),
    Xinetd("xinetd", "http://hl7.org/fhir/spdx-license", "xinetd License"),
    Xnet("Xnet", "http://hl7.org/fhir/spdx-license", "X.Net License"),
    Xpp("xpp", "http://hl7.org/fhir/spdx-license", "XPP License"),
    XSkat("XSkat", "http://hl7.org/fhir/spdx-license", "XSkat License"),
    Ypl_1_0("YPL-1.0", "http://hl7.org/fhir/spdx-license", "Yahoo! Public License v1.0"),
    Ypl_1_1("YPL-1.1", "http://hl7.org/fhir/spdx-license", "Yahoo! Public License v1.1"),
    Zed("Zed", "http://hl7.org/fhir/spdx-license", "Zed License"),
    Zend_2_0("Zend-2.0", "http://hl7.org/fhir/spdx-license", "Zend License v2.0"),
    Zimbra_1_3("Zimbra-1.3", "http://hl7.org/fhir/spdx-license", "Zimbra Public License v1.3"),
    Zimbra_1_4("Zimbra-1.4", "http://hl7.org/fhir/spdx-license", "Zimbra Public License v1.4"),
    Zlib_Acknowledgement(
      "zlib-acknowledgement",
      "http://hl7.org/fhir/spdx-license",
      "zlib/libpng License with Acknowledgement",
    ),
    Zlib("Zlib", "http://hl7.org/fhir/spdx-license", "zlib License"),
    Zpl_1_1("ZPL-1.1", "http://hl7.org/fhir/spdx-license", "Zope Public License 1.1"),
    Zpl_2_0("ZPL-2.0", "http://hl7.org/fhir/spdx-license", "Zope Public License 2.0"),
    Zpl_2_1("ZPL-2.1", "http://hl7.org/fhir/spdx-license", "Zope Public License 2.1");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SPDXLicense =
        when (code) {
          "not-open-source" -> Not_Open_Source
          "0BSD" -> _0BSD
          "AAL" -> Aal
          "Abstyles" -> Abstyles
          "Adobe-2006" -> Adobe_2006
          "Adobe-Glyph" -> Adobe_Glyph
          "ADSL" -> Adsl
          "AFL-1.1" -> Afl_1_1
          "AFL-1.2" -> Afl_1_2
          "AFL-2.0" -> Afl_2_0
          "AFL-2.1" -> Afl_2_1
          "AFL-3.0" -> Afl_3_0
          "Afmparse" -> Afmparse
          "AGPL-1.0-only" -> Agpl_1_0_Only
          "AGPL-1.0-or-later" -> Agpl_1_0_Or_Later
          "AGPL-3.0-only" -> Agpl_3_0_Only
          "AGPL-3.0-or-later" -> Agpl_3_0_Or_Later
          "Aladdin" -> Aladdin
          "AMDPLPA" -> Amdplpa
          "AML" -> Aml
          "AMPAS" -> Ampas
          "ANTLR-PD" -> Antlr_Pd
          "Apache-1.0" -> Apache_1_0
          "Apache-1.1" -> Apache_1_1
          "Apache-2.0" -> Apache_2_0
          "APAFML" -> Apafml
          "APL-1.0" -> Apl_1_0
          "APSL-1.0" -> Apsl_1_0
          "APSL-1.1" -> Apsl_1_1
          "APSL-1.2" -> Apsl_1_2
          "APSL-2.0" -> Apsl_2_0
          "Artistic-1.0-cl8" -> Artistic_1_0_Cl8
          "Artistic-1.0-Perl" -> Artistic_1_0_Perl
          "Artistic-1.0" -> Artistic_1_0
          "Artistic-2.0" -> Artistic_2_0
          "Bahyph" -> Bahyph
          "Barr" -> Barr
          "Beerware" -> Beerware
          "BitTorrent-1.0" -> BitTorrent_1_0
          "BitTorrent-1.1" -> BitTorrent_1_1
          "Borceux" -> Borceux
          "BSD-1-Clause" -> Bsd_1_Clause
          "BSD-2-Clause-FreeBSD" -> Bsd_2_Clause_FreeBSD
          "BSD-2-Clause-NetBSD" -> Bsd_2_Clause_NetBSD
          "BSD-2-Clause-Patent" -> Bsd_2_Clause_Patent
          "BSD-2-Clause" -> Bsd_2_Clause
          "BSD-3-Clause-Attribution" -> Bsd_3_Clause_Attribution
          "BSD-3-Clause-Clear" -> Bsd_3_Clause_Clear
          "BSD-3-Clause-LBNL" -> Bsd_3_Clause_Lbnl
          "BSD-3-Clause-No-Nuclear-License-2014" -> Bsd_3_Clause_No_Nuclear_License_2014
          "BSD-3-Clause-No-Nuclear-License" -> Bsd_3_Clause_No_Nuclear_License
          "BSD-3-Clause-No-Nuclear-Warranty" -> Bsd_3_Clause_No_Nuclear_Warranty
          "BSD-3-Clause" -> Bsd_3_Clause
          "BSD-4-Clause-UC" -> Bsd_4_Clause_Uc
          "BSD-4-Clause" -> Bsd_4_Clause
          "BSD-Protection" -> Bsd_Protection
          "BSD-Source-Code" -> Bsd_Source_Code
          "BSL-1.0" -> Bsl_1_0
          "bzip2-1.0.5" -> Bzip2_1_0_5
          "bzip2-1.0.6" -> Bzip2_1_0_6
          "Caldera" -> Caldera
          "CATOSL-1.1" -> Catosl_1_1
          "CC-BY-1.0" -> Cc_By_1_0
          "CC-BY-2.0" -> Cc_By_2_0
          "CC-BY-2.5" -> Cc_By_2_5
          "CC-BY-3.0" -> Cc_By_3_0
          "CC-BY-4.0" -> Cc_By_4_0
          "CC-BY-NC-1.0" -> Cc_By_Nc_1_0
          "CC-BY-NC-2.0" -> Cc_By_Nc_2_0
          "CC-BY-NC-2.5" -> Cc_By_Nc_2_5
          "CC-BY-NC-3.0" -> Cc_By_Nc_3_0
          "CC-BY-NC-4.0" -> Cc_By_Nc_4_0
          "CC-BY-NC-ND-1.0" -> Cc_By_Nc_Nd_1_0
          "CC-BY-NC-ND-2.0" -> Cc_By_Nc_Nd_2_0
          "CC-BY-NC-ND-2.5" -> Cc_By_Nc_Nd_2_5
          "CC-BY-NC-ND-3.0" -> Cc_By_Nc_Nd_3_0
          "CC-BY-NC-ND-4.0" -> Cc_By_Nc_Nd_4_0
          "CC-BY-NC-SA-1.0" -> Cc_By_Nc_Sa_1_0
          "CC-BY-NC-SA-2.0" -> Cc_By_Nc_Sa_2_0
          "CC-BY-NC-SA-2.5" -> Cc_By_Nc_Sa_2_5
          "CC-BY-NC-SA-3.0" -> Cc_By_Nc_Sa_3_0
          "CC-BY-NC-SA-4.0" -> Cc_By_Nc_Sa_4_0
          "CC-BY-ND-1.0" -> Cc_By_Nd_1_0
          "CC-BY-ND-2.0" -> Cc_By_Nd_2_0
          "CC-BY-ND-2.5" -> Cc_By_Nd_2_5
          "CC-BY-ND-3.0" -> Cc_By_Nd_3_0
          "CC-BY-ND-4.0" -> Cc_By_Nd_4_0
          "CC-BY-SA-1.0" -> Cc_By_Sa_1_0
          "CC-BY-SA-2.0" -> Cc_By_Sa_2_0
          "CC-BY-SA-2.5" -> Cc_By_Sa_2_5
          "CC-BY-SA-3.0" -> Cc_By_Sa_3_0
          "CC-BY-SA-4.0" -> Cc_By_Sa_4_0
          "CC0-1.0" -> CC0_1_0
          "CDDL-1.0" -> Cddl_1_0
          "CDDL-1.1" -> Cddl_1_1
          "CDLA-Permissive-1.0" -> Cdla_Permissive_1_0
          "CDLA-Sharing-1.0" -> Cdla_Sharing_1_0
          "CECILL-1.0" -> Cecill_1_0
          "CECILL-1.1" -> Cecill_1_1
          "CECILL-2.0" -> Cecill_2_0
          "CECILL-2.1" -> Cecill_2_1
          "CECILL-B" -> Cecill_B
          "CECILL-C" -> Cecill_C
          "ClArtistic" -> ClArtistic
          "CNRI-Jython" -> Cnri_Jython
          "CNRI-Python-GPL-Compatible" -> Cnri_Python_Gpl_Compatible
          "CNRI-Python" -> Cnri_Python
          "Condor-1.1" -> Condor_1_1
          "CPAL-1.0" -> Cpal_1_0
          "CPL-1.0" -> Cpl_1_0
          "CPOL-1.02" -> Cpol_1_02
          "Crossword" -> Crossword
          "CrystalStacker" -> CrystalStacker
          "CUA-OPL-1.0" -> Cua_Opl_1_0
          "Cube" -> Cube
          "curl" -> Curl
          "D-FSL-1.0" -> D_Fsl_1_0
          "diffmark" -> Diffmark
          "DOC" -> Doc
          "Dotseqn" -> Dotseqn
          "DSDP" -> Dsdp
          "dvipdfm" -> Dvipdfm
          "ECL-1.0" -> Ecl_1_0
          "ECL-2.0" -> Ecl_2_0
          "EFL-1.0" -> Efl_1_0
          "EFL-2.0" -> Efl_2_0
          "eGenix" -> EGenix
          "Entessa" -> Entessa
          "EPL-1.0" -> Epl_1_0
          "EPL-2.0" -> Epl_2_0
          "ErlPL-1.1" -> ErlPL_1_1
          "EUDatagrid" -> EUDatagrid
          "EUPL-1.0" -> Eupl_1_0
          "EUPL-1.1" -> Eupl_1_1
          "EUPL-1.2" -> Eupl_1_2
          "Eurosym" -> Eurosym
          "Fair" -> Fair
          "Frameworx-1.0" -> Frameworx_1_0
          "FreeImage" -> FreeImage
          "FSFAP" -> Fsfap
          "FSFUL" -> Fsful
          "FSFULLR" -> Fsfullr
          "FTL" -> Ftl
          "GFDL-1.1-only" -> Gfdl_1_1_Only
          "GFDL-1.1-or-later" -> Gfdl_1_1_Or_Later
          "GFDL-1.2-only" -> Gfdl_1_2_Only
          "GFDL-1.2-or-later" -> Gfdl_1_2_Or_Later
          "GFDL-1.3-only" -> Gfdl_1_3_Only
          "GFDL-1.3-or-later" -> Gfdl_1_3_Or_Later
          "Giftware" -> Giftware
          "GL2PS" -> GL2PS
          "Glide" -> Glide
          "Glulxe" -> Glulxe
          "gnuplot" -> Gnuplot
          "GPL-1.0-only" -> Gpl_1_0_Only
          "GPL-1.0-or-later" -> Gpl_1_0_Or_Later
          "GPL-2.0-only" -> Gpl_2_0_Only
          "GPL-2.0-or-later" -> Gpl_2_0_Or_Later
          "GPL-3.0-only" -> Gpl_3_0_Only
          "GPL-3.0-or-later" -> Gpl_3_0_Or_Later
          "gSOAP-1.3b" -> GSOAP_1_3b
          "HaskellReport" -> HaskellReport
          "HPND" -> Hpnd
          "IBM-pibs" -> Ibm_Pibs
          "ICU" -> Icu
          "IJG" -> Ijg
          "ImageMagick" -> ImageMagick
          "iMatix" -> IMatix
          "Imlib2" -> Imlib2
          "Info-ZIP" -> Info_Zip
          "Intel-ACPI" -> Intel_Acpi
          "Intel" -> Intel
          "Interbase-1.0" -> Interbase_1_0
          "IPA" -> Ipa
          "IPL-1.0" -> Ipl_1_0
          "ISC" -> Isc
          "JasPer-2.0" -> JasPer_2_0
          "JSON" -> Json
          "LAL-1.2" -> Lal_1_2
          "LAL-1.3" -> Lal_1_3
          "Latex2e" -> Latex2e
          "Leptonica" -> Leptonica
          "LGPL-2.0-only" -> Lgpl_2_0_Only
          "LGPL-2.0-or-later" -> Lgpl_2_0_Or_Later
          "LGPL-2.1-only" -> Lgpl_2_1_Only
          "LGPL-2.1-or-later" -> Lgpl_2_1_Or_Later
          "LGPL-3.0-only" -> Lgpl_3_0_Only
          "LGPL-3.0-or-later" -> Lgpl_3_0_Or_Later
          "LGPLLR" -> Lgpllr
          "Libpng" -> Libpng
          "libtiff" -> Libtiff
          "LiLiQ-P-1.1" -> LiLiQ_P_1_1
          "LiLiQ-R-1.1" -> LiLiQ_R_1_1
          "LiLiQ-Rplus-1.1" -> LiLiQ_Rplus_1_1
          "Linux-OpenIB" -> Linux_OpenIB
          "LPL-1.0" -> Lpl_1_0
          "LPL-1.02" -> Lpl_1_02
          "LPPL-1.0" -> Lppl_1_0
          "LPPL-1.1" -> Lppl_1_1
          "LPPL-1.2" -> Lppl_1_2
          "LPPL-1.3a" -> Lppl_1_3a
          "LPPL-1.3c" -> Lppl_1_3c
          "MakeIndex" -> MakeIndex
          "MirOS" -> MirOS
          "MIT-0" -> Mit_0
          "MIT-advertising" -> Mit_Advertising
          "MIT-CMU" -> Mit_Cmu
          "MIT-enna" -> Mit_Enna
          "MIT-feh" -> Mit_Feh
          "MIT" -> Mit
          "MITNFA" -> Mitnfa
          "Motosoto" -> Motosoto
          "mpich2" -> Mpich2
          "MPL-1.0" -> Mpl_1_0
          "MPL-1.1" -> Mpl_1_1
          "MPL-2.0-no-copyleft-exception" -> Mpl_2_0_No_Copyleft_Exception
          "MPL-2.0" -> Mpl_2_0
          "MS-PL" -> Ms_Pl
          "MS-RL" -> Ms_Rl
          "MTLL" -> Mtll
          "Multics" -> Multics
          "Mup" -> Mup
          "NASA-1.3" -> Nasa_1_3
          "Naumen" -> Naumen
          "NBPL-1.0" -> Nbpl_1_0
          "NCSA" -> Ncsa
          "Net-SNMP" -> Net_Snmp
          "NetCDF" -> NetCDF
          "Newsletr" -> Newsletr
          "NGPL" -> Ngpl
          "NLOD-1.0" -> Nlod_1_0
          "NLPL" -> Nlpl
          "Nokia" -> Nokia
          "NOSL" -> Nosl
          "Noweb" -> Noweb
          "NPL-1.0" -> Npl_1_0
          "NPL-1.1" -> Npl_1_1
          "NPOSL-3.0" -> Nposl_3_0
          "NRL" -> Nrl
          "NTP" -> Ntp
          "OCCT-PL" -> Occt_Pl
          "OCLC-2.0" -> Oclc_2_0
          "ODbL-1.0" -> ODbL_1_0
          "OFL-1.0" -> Ofl_1_0
          "OFL-1.1" -> Ofl_1_1
          "OGTSL" -> Ogtsl
          "OLDAP-1.1" -> Oldap_1_1
          "OLDAP-1.2" -> Oldap_1_2
          "OLDAP-1.3" -> Oldap_1_3
          "OLDAP-1.4" -> Oldap_1_4
          "OLDAP-2.0.1" -> Oldap_2_0_1
          "OLDAP-2.0" -> Oldap_2_0
          "OLDAP-2.1" -> Oldap_2_1
          "OLDAP-2.2.1" -> Oldap_2_2_1
          "OLDAP-2.2.2" -> Oldap_2_2_2
          "OLDAP-2.2" -> Oldap_2_2
          "OLDAP-2.3" -> Oldap_2_3
          "OLDAP-2.4" -> Oldap_2_4
          "OLDAP-2.5" -> Oldap_2_5
          "OLDAP-2.6" -> Oldap_2_6
          "OLDAP-2.7" -> Oldap_2_7
          "OLDAP-2.8" -> Oldap_2_8
          "OML" -> Oml
          "OpenSSL" -> OpenSSL
          "OPL-1.0" -> Opl_1_0
          "OSET-PL-2.1" -> Oset_Pl_2_1
          "OSL-1.0" -> Osl_1_0
          "OSL-1.1" -> Osl_1_1
          "OSL-2.0" -> Osl_2_0
          "OSL-2.1" -> Osl_2_1
          "OSL-3.0" -> Osl_3_0
          "PDDL-1.0" -> Pddl_1_0
          "PHP-3.0" -> Php_3_0
          "PHP-3.01" -> Php_3_01
          "Plexus" -> Plexus
          "PostgreSQL" -> PostgreSQL
          "psfrag" -> Psfrag
          "psutils" -> Psutils
          "Python-2.0" -> Python_2_0
          "Qhull" -> Qhull
          "QPL-1.0" -> Qpl_1_0
          "Rdisc" -> Rdisc
          "RHeCos-1.1" -> RHeCos_1_1
          "RPL-1.1" -> Rpl_1_1
          "RPL-1.5" -> Rpl_1_5
          "RPSL-1.0" -> Rpsl_1_0
          "RSA-MD" -> Rsa_Md
          "RSCPL" -> Rscpl
          "Ruby" -> Ruby
          "SAX-PD" -> Sax_Pd
          "Saxpath" -> Saxpath
          "SCEA" -> Scea
          "Sendmail" -> Sendmail
          "SGI-B-1.0" -> Sgi_B_1_0
          "SGI-B-1.1" -> Sgi_B_1_1
          "SGI-B-2.0" -> Sgi_B_2_0
          "SimPL-2.0" -> SimPL_2_0
          "SISSL-1.2" -> Sissl_1_2
          "SISSL" -> Sissl
          "Sleepycat" -> Sleepycat
          "SMLNJ" -> Smlnj
          "SMPPL" -> Smppl
          "SNIA" -> Snia
          "Spencer-86" -> Spencer_86
          "Spencer-94" -> Spencer_94
          "Spencer-99" -> Spencer_99
          "SPL-1.0" -> Spl_1_0
          "SugarCRM-1.1.3" -> SugarCRM_1_1_3
          "SWL" -> Swl
          "TCL" -> Tcl
          "TCP-wrappers" -> Tcp_Wrappers
          "TMate" -> TMate
          "TORQUE-1.1" -> Torque_1_1
          "TOSL" -> Tosl
          "Unicode-DFS-2015" -> Unicode_Dfs_2015
          "Unicode-DFS-2016" -> Unicode_Dfs_2016
          "Unicode-TOU" -> Unicode_Tou
          "Unlicense" -> Unlicense
          "UPL-1.0" -> Upl_1_0
          "Vim" -> Vim
          "VOSTROM" -> Vostrom
          "VSL-1.0" -> Vsl_1_0
          "W3C-19980720" -> W3C_19980720
          "W3C-20150513" -> W3C_20150513
          "W3C" -> W3C
          "Watcom-1.0" -> Watcom_1_0
          "Wsuipa" -> Wsuipa
          "WTFPL" -> Wtfpl
          "X11" -> X11
          "Xerox" -> Xerox
          "XFree86-1.1" -> XFree86_1_1
          "xinetd" -> Xinetd
          "Xnet" -> Xnet
          "xpp" -> Xpp
          "XSkat" -> XSkat
          "YPL-1.0" -> Ypl_1_0
          "YPL-1.1" -> Ypl_1_1
          "Zed" -> Zed
          "Zend-2.0" -> Zend_2_0
          "Zimbra-1.3" -> Zimbra_1_3
          "Zimbra-1.4" -> Zimbra_1_4
          "zlib-acknowledgement" -> Zlib_Acknowledgement
          "Zlib" -> Zlib
          "ZPL-1.1" -> Zpl_1_1
          "ZPL-2.0" -> Zpl_2_0
          "ZPL-2.1" -> Zpl_2_1
          else -> throw IllegalArgumentException("Unknown code $code for enum SPDXLicense")
        }
    }
  }
}
