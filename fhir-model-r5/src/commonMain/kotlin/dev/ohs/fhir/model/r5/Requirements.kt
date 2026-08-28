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

import dev.ohs.fhir.model.r5.serializers.RequirementsSerializer
import dev.ohs.fhir.model.r5.serializers.RequirementsStatementSerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The Requirements resource is used to describe an actor - a human or an application that plays a
 * role in data exchange, and that may have obligations associated with the role the actor plays.
 */
@Serializable(with = RequirementsSerializer::class)
@SerialName("Requirements")
public data class Requirements(
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
   * An absolute URI that is used to identify this Requirements when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which an authoritative instance of this
   * Requirements is (or will be) published. This URL can be the target of a canonical reference. It
   * SHALL remain the same when the Requirements is stored on different servers.
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
   * A formal identifier that is used to identify this Requirements when it is represented in other
   * formats, or referenced in a specification, model, design or an instance.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the Requirements when it is referenced
   * in a specification, model, design or instance. This is an arbitrary value managed by the
   * Requirements author and is not expected to be globally unique. For example, it might be a
   * timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence.
   *
   * There may be different Requirements instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the Requirements with the format [url]|[version]. The version
   * SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
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
   * A natural language name identifying the Requirements. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the Requirements.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this Requirements. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of Requirements that are appropriate for use versus not.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this Requirements is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of Requirements that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the Requirements was published. The date must change when
   * the business version changes and it must change if the status code changes. In addition, it
   * should change when the substantive content of the Requirements changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the Requirements. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual responsible for the release and ongoing maintenance
   * of the Requirements.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the
   * Requirements is the organization or individual primarily responsible for the maintenance and
   * upkeep of the Requirements. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the Requirements. This item SHOULD be populated unless the information
   * is available from context.
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
   * A free text natural language description of the requirements.
   *
   * This description can be used for a general description of the requirements, and which covers
   * why it was defined.
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate Requirements instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the Requirements is intended to be used.
   *
   * It may be possible for the Requirements to be used in jurisdictions other than those for which
   * it was originally designed or intended
   *
   * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
   * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
   * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
   * useContext.valueCodeableConcept indicating the jurisdiction.).
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this Requirements is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the Requirements. Instead, it provides traceability
   * of ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used to
   * point to source materials or specifications that drove the structure of this Requirements.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the Requirements and/or its contents. Copyright statements
   * are generally legal restrictions on the use and publishing of the Requirements.
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
   * Another set of Requirements that this set of Requirements builds on and updates.
   *
   * Existing statements (by key) may be narrowed or clarified, and additional statements added.
   */
  public val derivedFrom: List<Canonical> = listOf(),
  /**
   * A reference to another artifact that created this set of requirements. This could be a Profile,
   * etc., or external regulation, or business requirements expressed elsewhere.
   */
  public val reference: List<Url> = listOf(),
  /**
   * An actor these requirements are in regard to.
   *
   * If more than one actor is specified, then it's up to the statements to describe in narrative if
   * they don't apply to all actors.
   */
  public val actor: List<Canonical> = listOf(),
  /** The actual statement of requirement, in markdown format. */
  public val statement: List<Statement> = listOf(),
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
        url = this@with.url?.toBuilder()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        version = this@with.version?.toBuilder()
        versionAlgorithm = this@with.versionAlgorithm
        name = this@with.name?.toBuilder()
        title = this@with.title?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        copyrightLabel = this@with.copyrightLabel?.toBuilder()
        derivedFrom = this@with.derivedFrom.map { it.toBuilder() }.toMutableList()
        reference = this@with.reference.map { it.toBuilder() }.toMutableList()
        actor = this@with.actor.map { it.toBuilder() }.toMutableList()
        statement = this@with.statement.map { it.toBuilder() }.toMutableList()
      }
    }

  /** The actual statement of requirement, in markdown format. */
  @Serializable(with = RequirementsStatementSerializer::class)
  public data class Statement(
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
     * Key that identifies this statement (unique within this resource).
     *
     * Refer directly to the statement by {url}#{key}
     */
    public val key: Id,
    /**
     * A short human usable label for this statement.
     *
     * The key is intended for computers, while this is intended for humans. In its absence, the key
     * should be convenient for a human to say (e.g. not a UUID)
     */
    public val label: String? = null,
    /**
     * A short human usable label for this statement.
     *
     * The conformance code is extracted from the requirement to make indexing and display easier.
     * The requirement needs to express the conformance verbs directly in the markdown content. It's
     * not unusual to mix verbs in a single sentence (e.g. System SHALL do X and SHOULD do Y)
     */
    public val conformance: List<Enumeration<ConformanceExpectation>> = listOf(),
    /**
     * This boolean flag is set to true of the text of the requirement is conditional on something
     * e.g. it includes lanauage like 'if x then y'. This conditionality flag is introduced for
     * purposes of filtering and colour highlighting etc.
     *
     * There is no intent that the conditional statement by evaluatable
     */
    public val conditionality: Boolean? = null,
    /** The actual requirement for human consumption. */
    public val requirement: Markdown,
    /**
     * Another statement on one of the requirements that this requirement clarifies or restricts.
     *
     * This can be just a key, if there is only one matching statement in the requirements
     * statements referenced in Requirements.derivedFrom. If there is more than one, it should be in
     * the format ```url#key```
     */
    public val derivedFrom: String? = null,
    /**
     * A larger requirement that this requirement helps to refine and enable.
     *
     * Follows the same convention as statement.derivedFrom, where a reference is the canonical of
     * the Requirements followed by '#' and the 'key' of the specific requirement.
     */
    public val parent: String? = null,
    /**
     * A reference to another artifact that satisfies this requirement. This could be a Profile,
     * extension, or an element in one of those, or a CapabilityStatement, OperationDefinition,
     * SearchParameter, CodeSystem(/code), ValueSet, Libary etc.
     *
     * This is for use when the requirement is met be a pre-existing artifact e.g. a rule that's met
     * by the base FHIR spec, or a national implementation guide.
     */
    public val satisfiedBy: List<Url> = listOf(),
    /**
     * A reference to another artifact that created this requirement. This could be a Profile, etc.,
     * or external regulation, or business requirements expressed elsewhere.
     */
    public val reference: List<Url> = listOf(),
    /**
     * Who asked for this statement to be a requirement. By default, it's assumed that the publisher
     * knows who it is if it matters.
     */
    public val source: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(key.toBuilder(), requirement.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          label = this@with.label?.toBuilder()
          conformance = this@with.conformance.toMutableList()
          conditionality = this@with.conditionality?.toBuilder()
          derivedFrom = this@with.derivedFrom?.toBuilder()
          parent = this@with.parent?.toBuilder()
          satisfiedBy = this@with.satisfiedBy.map { it.toBuilder() }.toMutableList()
          reference = this@with.reference.map { it.toBuilder() }.toMutableList()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Key that identifies this statement (unique within this resource).
       *
       * Refer directly to the statement by {url}#{key}
       */
      public var key: Id.Builder,
      /** The actual requirement for human consumption. */
      public var requirement: Markdown.Builder,
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
       * A short human usable label for this statement.
       *
       * The key is intended for computers, while this is intended for humans. In its absence, the
       * key should be convenient for a human to say (e.g. not a UUID)
       */
      public var label: String.Builder? = null

      /**
       * A short human usable label for this statement.
       *
       * The conformance code is extracted from the requirement to make indexing and display easier.
       * The requirement needs to express the conformance verbs directly in the markdown content.
       * It's not unusual to mix verbs in a single sentence (e.g. System SHALL do X and SHOULD do Y)
       */
      public var conformance: MutableList<Enumeration<ConformanceExpectation>> = mutableListOf()

      /**
       * This boolean flag is set to true of the text of the requirement is conditional on something
       * e.g. it includes lanauage like 'if x then y'. This conditionality flag is introduced for
       * purposes of filtering and colour highlighting etc.
       *
       * There is no intent that the conditional statement by evaluatable
       */
      public var conditionality: Boolean.Builder? = null

      /**
       * Another statement on one of the requirements that this requirement clarifies or restricts.
       *
       * This can be just a key, if there is only one matching statement in the requirements
       * statements referenced in Requirements.derivedFrom. If there is more than one, it should be
       * in the format ```url#key```
       */
      public var derivedFrom: String.Builder? = null

      /**
       * A larger requirement that this requirement helps to refine and enable.
       *
       * Follows the same convention as statement.derivedFrom, where a reference is the canonical of
       * the Requirements followed by '#' and the 'key' of the specific requirement.
       */
      public var parent: String.Builder? = null

      /**
       * A reference to another artifact that satisfies this requirement. This could be a Profile,
       * extension, or an element in one of those, or a CapabilityStatement, OperationDefinition,
       * SearchParameter, CodeSystem(/code), ValueSet, Libary etc.
       *
       * This is for use when the requirement is met be a pre-existing artifact e.g. a rule that's
       * met by the base FHIR spec, or a national implementation guide.
       */
      public var satisfiedBy: MutableList<Url.Builder> = mutableListOf()

      /**
       * A reference to another artifact that created this requirement. This could be a Profile,
       * etc., or external regulation, or business requirements expressed elsewhere.
       */
      public var reference: MutableList<Url.Builder> = mutableListOf()

      /**
       * Who asked for this statement to be a requirement. By default, it's assumed that the
       * publisher knows who it is if it matters.
       */
      public var source: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Statement =
        Statement(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          key = key.build(),
          label = label?.build(),
          conformance = conformance,
          conditionality = conditionality?.build(),
          requirement = requirement.build(),
          derivedFrom = derivedFrom?.build(),
          parent = parent?.build(),
          satisfiedBy = satisfiedBy.map { it.build() },
          reference = reference.map { it.build() },
          source = source.map { it.build() },
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
     * The status of this Requirements. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of Requirements that are appropriate for use versus not.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var status: Enumeration<PublicationStatus>
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
     * An absolute URI that is used to identify this Requirements when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance
     * of this Requirements is (or will be) published. This URL can be the target of a canonical
     * reference. It SHALL remain the same when the Requirements is stored on different servers.
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
     * A formal identifier that is used to identify this Requirements when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the Requirements when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the Requirements author and is not expected to be globally unique. For example, it might
     * be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different Requirements instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the Requirements with the format [url]|[version]. The version
     * SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
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
     * A natural language name identifying the Requirements. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the Requirements.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this Requirements is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of Requirements that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the Requirements was published. The date must change when
     * the business version changes and it must change if the status code changes. In addition, it
     * should change when the substantive content of the Requirements changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the Requirements. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual responsible for the release and ongoing
     * maintenance of the Requirements.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the
     * Requirements is the organization or individual primarily responsible for the maintenance and
     * upkeep of the Requirements. This is not necessarily the same individual or organization that
     * developed and initially authored the content. The publisher is the primary point of contact
     * for questions or issues with the Requirements. This item SHOULD be populated unless the
     * information is available from context.
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
     * A free text natural language description of the requirements.
     *
     * This description can be used for a general description of the requirements, and which covers
     * why it was defined.
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate Requirements instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the Requirements is intended to be used.
     *
     * It may be possible for the Requirements to be used in jurisdictions other than those for
     * which it was originally designed or intended
     *
     * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
     * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
     * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
     * useContext.valueCodeableConcept indicating the jurisdiction.).
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this Requirements is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the Requirements. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * Requirements.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the Requirements and/or its contents. Copyright statements
     * are generally legal restrictions on the use and publishing of the Requirements.
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
     * Another set of Requirements that this set of Requirements builds on and updates.
     *
     * Existing statements (by key) may be narrowed or clarified, and additional statements added.
     */
    public var derivedFrom: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * A reference to another artifact that created this set of requirements. This could be a
     * Profile, etc., or external regulation, or business requirements expressed elsewhere.
     */
    public var reference: MutableList<Url.Builder> = mutableListOf()

    /**
     * An actor these requirements are in regard to.
     *
     * If more than one actor is specified, then it's up to the statements to describe in narrative
     * if they don't apply to all actors.
     */
    public var actor: MutableList<Canonical.Builder> = mutableListOf()

    /** The actual statement of requirement, in markdown format. */
    public var statement: MutableList<Statement.Builder> = mutableListOf()

    override fun build(): Requirements =
      Requirements(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url?.build(),
        identifier = identifier.map { it.build() },
        version = version?.build(),
        versionAlgorithm = versionAlgorithm,
        name = name?.build(),
        title = title?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        copyrightLabel = copyrightLabel?.build(),
        derivedFrom = derivedFrom.map { it.build() },
        reference = reference.map { it.build() },
        actor = actor.map { it.build() },
        statement = statement.map { it.build() },
      )
  }

  /** Description Needed Here */
  public enum class ConformanceExpectation(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Shall("SHALL", "http://hl7.org/fhir/conformance-expectation", "SHALL"),
    Should("SHOULD", "http://hl7.org/fhir/conformance-expectation", "SHOULD"),
    May("MAY", "http://hl7.org/fhir/conformance-expectation", "MAY"),
    Should_Not("SHOULD-NOT", "http://hl7.org/fhir/conformance-expectation", "SHOULD-NOT");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ConformanceExpectation =
        fromCodeOrNull(code)
          ?: throw IllegalArgumentException("Unknown code $code for enum ConformanceExpectation")

      public fun fromCodeOrNull(code: kotlin.String?): ConformanceExpectation? =
        when (code) {
          "SHALL" -> Shall
          "SHOULD" -> Should
          "MAY" -> May
          "SHOULD-NOT" -> Should_Not
          else -> null
        }
    }
  }
}
