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

import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCategorySerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCategoryValueSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicDefinitionByCombinationSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicDurationSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicInstancesSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicTimeFromEventEventSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableCharacteristicTimeFromEventSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceVariableVersionAlgorithmSerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** The EvidenceVariable resource describes an element that knowledge (Evidence) is about. */
@Serializable(with = EvidenceVariableSerializer::class)
@SerialName("EvidenceVariable")
public data class EvidenceVariable(
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
   * An absolute URI that is used to identify this evidence variable when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which an authoritative instance of this
   * evidence variable is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the evidence variable is stored on different servers.
   *
   * In some cases, the resource can no longer be found at the stated url, but the url itself cannot
   * change. Implementations can use the meta.source element to indicate where the current master
   * source of the resource can be found.
   */
  public val url: Uri? = null,
  /**
   * A formal identifier that is used to identify this evidence variable when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this evidence variable outside of FHIR, where it is not possible to
   * use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the evidence variable when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the evidence variable author and is not expected to be globally unique. For example, it might
   * be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence. To provide a version
   * consistent with the Decision Support Service specification, use the format Major.Minor.Revision
   * (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision
   * Support Service specification. Note that a version is required for non-experimental active
   * artifacts.
   *
   * There may be different evidence variable instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the evidence variable with the format [url]|[version]. The
   * version SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
   */
  public val version: String? = null,
  /**
   * Indicates the mechanism used to compare versions to determine which is more current.
   *
   * If set as a string, this is a FHIRPath expression that has two additional context variables
   * passed in - %version1 and %version2 and will return a negative number if version1 is newer, a
   * positive number if version2 is newer, and a 0 if the version ordering can't successfully be
   * determined.
   */
  public val versionAlgorithm: VersionAlgorithm? = null,
  /**
   * A natural language name identifying the evidence variable. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the evidence variable.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The short title provides an alternate title for use in informal descriptive contexts where the
   * full, formal title is not necessary.
   */
  public val shortTitle: String? = null,
  /**
   * The status of this evidence variable. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of evidence variables that are appropriate for use versus not.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this resource is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the evidence variable was last significantly changed. The
   * date must change when the business version changes and it must change if the status code
   * changes. In addition, it should change when the substantive content of the evidence variable
   * changes.
   *
   * The date is often not tracked until the resource is published, but may be present on draft
   * content. Note that this is not the same as the resource last-modified-date, since the resource
   * may be a secondary representation of the evidence variable. Additional specific dates may be
   * added as extensions or be found by consulting Provenances associated with past versions of the
   * resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual responsible for the release and ongoing maintenance
   * of the evidence variable.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the evidence
   * variable is the organization or individual primarily responsible for the maintenance and upkeep
   * of the evidence variable. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the evidence variable. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the evidence variable from a consumer's
   * perspective.
   *
   * This description can be used to capture details such as comments about misuse, instructions for
   * clinical use and interpretation, literature references, examples from the paper world, etc. It
   * is not a rendering of the evidence variable as conveyed in the 'text' field of the resource
   * itself. This item SHOULD be populated unless the information is available from context (e.g.
   * the language of the evidence variable is presumed to be the predominant language in the place
   * the evidence variable was created).
   */
  public val description: Markdown? = null,
  /** A human-readable string to clarify or explain concepts about the resource. */
  public val note: List<Annotation> = listOf(),
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate evidence variable instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * Explanation of why this EvidenceVariable is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the EvidenceVariable. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * EvidenceVariable.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the resource and/or its contents. Copyright statements are
   * generally legal restrictions on the use and publishing of the resource.
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
   * The date on which the resource content was approved by the publisher. Approval happens once
   * when the content is officially approved for usage.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val approvalDate: Date? = null,
  /**
   * The date on which the resource content was last reviewed. Review happens periodically after
   * approval but does not change the original approval date.
   *
   * If specified, this date follows the original approval date.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val lastReviewDate: Date? = null,
  /**
   * The period during which the resource content was or is planned to be in active use.
   *
   * The effective period for an EvidenceVariable determines when the content is applicable for
   * usage and is independent of publication and review dates. For example, a variable intended to
   * be used for the year 2016 might be published in 2015.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val effectivePeriod: Period? = null,
  /**
   * An individiual or organization primarily involved in the creation and maintenance of the
   * content.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   */
  public val author: List<ContactDetail> = listOf(),
  /**
   * An individual or organization primarily responsible for internal coherence of the content.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   */
  public val editor: List<ContactDetail> = listOf(),
  /**
   * An individual or organization asserted by the publisher to be primarily responsible for review
   * of some aspect of the content.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val reviewer: List<ContactDetail> = listOf(),
  /**
   * An individual or organization asserted by the publisher to be responsible for officially
   * endorsing the content for use in some setting.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val endorser: List<ContactDetail> = listOf(),
  /**
   * Related artifacts such as additional documentation, justification, or bibliographic references.
   *
   * Each related artifact is either an attachment, or a reference to another resource, but not
   * both.
   */
  public val relatedArtifact: List<RelatedArtifact> = listOf(),
  /**
   * True if the actual variable measured, false if a conceptual representation of the intended
   * variable.
   */
  public val `actual`: Boolean? = null,
  /**
   * A defining factor of the EvidenceVariable. Multiple characteristics are applied with "and"
   * semantics.
   *
   * Characteristics can be defined flexibly to accommodate different use cases for membership
   * criteria, ranging from simple codes, all the way to using an expression language to express the
   * criteria.
   */
  public val characteristic: List<Characteristic> = listOf(),
  /** The method of handling in statistical analysis. */
  public val handling: Enumeration<EvidenceVariableHandling>? = null,
  /** A grouping for ordinal or polychotomous variables. */
  public val category: List<Category> = listOf(),
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
        shortTitle = this@with.shortTitle?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        copyrightLabel = this@with.copyrightLabel?.toBuilder()
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        effectivePeriod = this@with.effectivePeriod?.toBuilder()
        author = this@with.author.map { it.toBuilder() }.toMutableList()
        editor = this@with.editor.map { it.toBuilder() }.toMutableList()
        reviewer = this@with.reviewer.map { it.toBuilder() }.toMutableList()
        endorser = this@with.endorser.map { it.toBuilder() }.toMutableList()
        relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
        `actual` = this@with.`actual`?.toBuilder()
        characteristic = this@with.characteristic.map { it.toBuilder() }.toMutableList()
        handling = this@with.handling
        category = this@with.category.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * A defining factor of the EvidenceVariable. Multiple characteristics are applied with "and"
   * semantics.
   */
  @Serializable(with = EvidenceVariableCharacteristicSerializer::class)
  public data class Characteristic(
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
    /** Label used for when a characteristic refers to another characteristic. */
    public val linkId: Id? = null,
    /**
     * A short, natural language description of the characteristic that could be used to communicate
     * the criteria to an end-user.
     */
    public val description: Markdown? = null,
    /** A human-readable string to clarify or explain concepts about the characteristic. */
    public val note: List<Annotation> = listOf(),
    /**
     * When true, this characteristic is an exclusion criterion. In other words, not matching this
     * characteristic definition is equivalent to meeting this criterion.
     */
    public val exclude: Boolean? = null,
    /** Defines the characteristic using a Reference. */
    public val definitionReference: Reference? = null,
    /** Defines the characteristic using Canonical. */
    public val definitionCanonical: Canonical? = null,
    /** Defines the characteristic using CodeableConcept. */
    public val definitionCodeableConcept: CodeableConcept? = null,
    /**
     * Defines the characteristic using Expression.
     *
     * When another element provides a definition of the characteristic, the definitionExpression
     * content SHALL match the definition (only adding technical concepts necessary for
     * implementation) without changing the meaning.
     */
    public val definitionExpression: Expression? = null,
    /** Defines the characteristic using id. */
    public val definitionId: Id? = null,
    /** Defines the characteristic using both a type and value[x] elements. */
    public val definitionByTypeAndValue: DefinitionByTypeAndValue? = null,
    /** Defines the characteristic as a combination of two or more characteristics. */
    public val definitionByCombination: DefinitionByCombination? = null,
    /** Number of occurrences meeting the characteristic. */
    public val instances: Instances? = null,
    /** Length of time in which the characteristic is met. */
    public val duration: Duration? = null,
    /** Timing in which the characteristic is determined. */
    public val timeFromEvent: List<TimeFromEvent> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          linkId = this@with.linkId?.toBuilder()
          description = this@with.description?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          exclude = this@with.exclude?.toBuilder()
          definitionReference = this@with.definitionReference?.toBuilder()
          definitionCanonical = this@with.definitionCanonical?.toBuilder()
          definitionCodeableConcept = this@with.definitionCodeableConcept?.toBuilder()
          definitionExpression = this@with.definitionExpression?.toBuilder()
          definitionId = this@with.definitionId?.toBuilder()
          definitionByTypeAndValue = this@with.definitionByTypeAndValue?.toBuilder()
          definitionByCombination = this@with.definitionByCombination?.toBuilder()
          instances = this@with.instances
          duration = this@with.duration
          timeFromEvent = this@with.timeFromEvent.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Defines the characteristic using both a type and value[x] elements. */
    @Serializable(with = EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer::class)
    public data class DefinitionByTypeAndValue(
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
      /** Used to express the type of characteristic. */
      public val type: CodeableConcept,
      /** Method for how the characteristic value was determined. */
      public val method: List<CodeableConcept> = listOf(),
      /** Device used for determining characteristic. */
      public val device: Reference? = null,
      /** Defines the characteristic when paired with characteristic.type. */
      public val `value`: Value,
      /**
       * Defines the reference point for comparison when valueQuantity or valueRange is not compared
       * to zero.
       */
      public val offset: CodeableConcept? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type.toBuilder(), `value`).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            method = this@with.method.map { it.toBuilder() }.toMutableList()
            device = this@with.device?.toBuilder()
            offset = this@with.offset?.toBuilder()
          }
        }

      @Serializable(
        with = EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSerializer::class
      )
      public sealed interface Value {
        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asRange(): Range? = this as? Range

        public fun asReference(): Reference? = this as? Reference

        public fun asId(): Id? = this as? Id

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Value

        public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

        public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

        public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

        public data class Id(public val `value`: dev.ohs.fhir.model.r5.Id) : Value

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            booleanValue: dev.ohs.fhir.model.r5.Boolean?,
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            rangeValue: dev.ohs.fhir.model.r5.Range?,
            referenceValue: dev.ohs.fhir.model.r5.Reference?,
            idValue: dev.ohs.fhir.model.r5.Id?,
          ): Value? {
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (booleanValue != null) return Boolean(booleanValue)
            if (quantityValue != null) return Quantity(quantityValue)
            if (rangeValue != null) return Range(rangeValue)
            if (referenceValue != null) return Reference(referenceValue)
            if (idValue != null) return Id(idValue)
            return null
          }
        }
      }

      public class Builder(
        /** Used to express the type of characteristic. */
        public var type: CodeableConcept.Builder,
        /** Defines the characteristic when paired with characteristic.type. */
        public var `value`: Value,
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

        /** Method for how the characteristic value was determined. */
        public var method: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** Device used for determining characteristic. */
        public var device: Reference.Builder? = null

        /**
         * Defines the reference point for comparison when valueQuantity or valueRange is not
         * compared to zero.
         */
        public var offset: CodeableConcept.Builder? = null

        public fun build(): DefinitionByTypeAndValue =
          DefinitionByTypeAndValue(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.build(),
            method = method.map { it.build() },
            device = device?.build(),
            `value` = `value`,
            offset = offset?.build(),
          )
      }
    }

    /** Defines the characteristic as a combination of two or more characteristics. */
    @Serializable(with = EvidenceVariableCharacteristicDefinitionByCombinationSerializer::class)
    public data class DefinitionByCombination(
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
      /** Used to specify if two or more characteristics are combined with OR or AND. */
      public val code: Enumeration<CharacteristicCombination>,
      /** Provides the value of "n" when "at-least" or "at-most" codes are used. */
      public val threshold: PositiveInt? = null,
      /** A defining factor of the characteristic. */
      public val characteristic: List<Characteristic>,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(code, characteristic.map { it.toBuilder() }.toMutableList()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            threshold = this@with.threshold?.toBuilder()
          }
        }

      public class Builder(
        /** Used to specify if two or more characteristics are combined with OR or AND. */
        public var code: Enumeration<CharacteristicCombination>,
        /** A defining factor of the characteristic. */
        public var characteristic: MutableList<Characteristic.Builder>,
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

        /** Provides the value of "n" when "at-least" or "at-most" codes are used. */
        public var threshold: PositiveInt.Builder? = null

        public fun build(): DefinitionByCombination =
          DefinitionByCombination(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code,
            threshold = threshold?.build(),
            characteristic = characteristic.map { it.build() },
          )
      }
    }

    /** Timing in which the characteristic is determined. */
    @Serializable(with = EvidenceVariableCharacteristicTimeFromEventSerializer::class)
    public data class TimeFromEvent(
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
      /** Human readable description. */
      public val description: Markdown? = null,
      /** A human-readable string to clarify or explain concepts about the timeFromEvent. */
      public val note: List<Annotation> = listOf(),
      /** The event used as a base point (reference point) in time. */
      public val event: Event? = null,
      /** Used to express the observation at a defined amount of time before or after the event. */
      public val quantity: Quantity? = null,
      /** Used to express the observation within a period before and/or after the event. */
      public val range: Range? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            description = this@with.description?.toBuilder()
            note = this@with.note.map { it.toBuilder() }.toMutableList()
            event = this@with.event
            quantity = this@with.quantity?.toBuilder()
            range = this@with.range?.toBuilder()
          }
        }

      @Serializable(with = EvidenceVariableCharacteristicTimeFromEventEventSerializer::class)
      public sealed interface Event {
        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asReference(): Reference? = this as? Reference

        public fun asDateTime(): DateTime? = this as? DateTime

        public fun asId(): Id? = this as? Id

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Event

        public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Event

        public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Event

        public data class Id(public val `value`: dev.ohs.fhir.model.r5.Id) : Event

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            referenceValue: dev.ohs.fhir.model.r5.Reference?,
            dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
            idValue: dev.ohs.fhir.model.r5.Id?,
          ): Event? {
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (referenceValue != null) return Reference(referenceValue)
            if (dateTimeValue != null) return DateTime(dateTimeValue)
            if (idValue != null) return Id(idValue)
            return null
          }
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

        /** Human readable description. */
        public var description: Markdown.Builder? = null

        /** A human-readable string to clarify or explain concepts about the timeFromEvent. */
        public var note: MutableList<Annotation.Builder> = mutableListOf()

        /** The event used as a base point (reference point) in time. */
        public var event: Event? = null

        /**
         * Used to express the observation at a defined amount of time before or after the event.
         */
        public var quantity: Quantity.Builder? = null

        /** Used to express the observation within a period before and/or after the event. */
        public var range: Range.Builder? = null

        public fun build(): TimeFromEvent =
          TimeFromEvent(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            description = description?.build(),
            note = note.map { it.build() },
            event = event,
            quantity = quantity?.build(),
            range = range?.build(),
          )
      }
    }

    @Serializable(with = EvidenceVariableCharacteristicInstancesSerializer::class)
    public sealed interface Instances {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Instances

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Instances

      public companion object {
        internal fun from(
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
        ): Instances? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          return null
        }
      }
    }

    @Serializable(with = EvidenceVariableCharacteristicDurationSerializer::class)
    public sealed interface Duration {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Duration

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Duration

      public companion object {
        internal fun from(
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
        ): Duration? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          return null
        }
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

      /** Label used for when a characteristic refers to another characteristic. */
      public var linkId: Id.Builder? = null

      /**
       * A short, natural language description of the characteristic that could be used to
       * communicate the criteria to an end-user.
       */
      public var description: Markdown.Builder? = null

      /** A human-readable string to clarify or explain concepts about the characteristic. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      /**
       * When true, this characteristic is an exclusion criterion. In other words, not matching this
       * characteristic definition is equivalent to meeting this criterion.
       */
      public var exclude: Boolean.Builder? = null

      /** Defines the characteristic using a Reference. */
      public var definitionReference: Reference.Builder? = null

      /** Defines the characteristic using Canonical. */
      public var definitionCanonical: Canonical.Builder? = null

      /** Defines the characteristic using CodeableConcept. */
      public var definitionCodeableConcept: CodeableConcept.Builder? = null

      /**
       * Defines the characteristic using Expression.
       *
       * When another element provides a definition of the characteristic, the definitionExpression
       * content SHALL match the definition (only adding technical concepts necessary for
       * implementation) without changing the meaning.
       */
      public var definitionExpression: Expression.Builder? = null

      /** Defines the characteristic using id. */
      public var definitionId: Id.Builder? = null

      /** Defines the characteristic using both a type and value[x] elements. */
      public var definitionByTypeAndValue: DefinitionByTypeAndValue.Builder? = null

      /** Defines the characteristic as a combination of two or more characteristics. */
      public var definitionByCombination: DefinitionByCombination.Builder? = null

      /** Number of occurrences meeting the characteristic. */
      public var instances: Instances? = null

      /** Length of time in which the characteristic is met. */
      public var duration: Duration? = null

      /** Timing in which the characteristic is determined. */
      public var timeFromEvent: MutableList<TimeFromEvent.Builder> = mutableListOf()

      public fun build(): Characteristic =
        Characteristic(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          linkId = linkId?.build(),
          description = description?.build(),
          note = note.map { it.build() },
          exclude = exclude?.build(),
          definitionReference = definitionReference?.build(),
          definitionCanonical = definitionCanonical?.build(),
          definitionCodeableConcept = definitionCodeableConcept?.build(),
          definitionExpression = definitionExpression?.build(),
          definitionId = definitionId?.build(),
          definitionByTypeAndValue = definitionByTypeAndValue?.build(),
          definitionByCombination = definitionByCombination?.build(),
          instances = instances,
          duration = duration,
          timeFromEvent = timeFromEvent.map { it.build() },
        )
    }
  }

  /** A grouping for ordinal or polychotomous variables. */
  @Serializable(with = EvidenceVariableCategorySerializer::class)
  public data class Category(
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
    /** Description of the grouping. */
    public val name: String? = null,
    /** Definition of the grouping. */
    public val `value`: Value? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          `value` = this@with.`value`
        }
      }

    @Serializable(with = EvidenceVariableCategoryValueSerializer::class)
    public sealed interface Value {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
        ): Value? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          return null
        }
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

      /** Description of the grouping. */
      public var name: String.Builder? = null

      /** Definition of the grouping. */
      public var `value`: Value? = null

      public fun build(): Category =
        Category(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name?.build(),
          `value` = `value`,
        )
    }
  }

  @Serializable(with = EvidenceVariableVersionAlgorithmSerializer::class)
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
     * The status of this evidence variable. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of evidence variables that are appropriate for use versus not.
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
     * An absolute URI that is used to identify this evidence variable when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance
     * of this evidence variable is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the evidence variable is stored on
     * different servers.
     *
     * In some cases, the resource can no longer be found at the stated url, but the url itself
     * cannot change. Implementations can use the meta.source element to indicate where the current
     * master source of the resource can be found.
     */
    public var url: Uri.Builder? = null

    /**
     * A formal identifier that is used to identify this evidence variable when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this evidence variable outside of FHIR, where it is not
     * possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the evidence variable when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the evidence variable author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence. To provide a version
     * consistent with the Decision Support Service specification, use the format
     * Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer
     * to the Decision Support Service specification. Note that a version is required for
     * non-experimental active artifacts.
     *
     * There may be different evidence variable instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the evidence variable with the format
     * [url]|[version]. The version SHOULD NOT contain a '#' - see
     * [Business Version](resource.html#bv-format).
     */
    public var version: String.Builder? = null

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     *
     * If set as a string, this is a FHIRPath expression that has two additional context variables
     * passed in - %version1 and %version2 and will return a negative number if version1 is newer, a
     * positive number if version2 is newer, and a 0 if the version ordering can't successfully be
     * determined.
     */
    public var versionAlgorithm: VersionAlgorithm? = null

    /**
     * A natural language name identifying the evidence variable. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the evidence variable.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * The short title provides an alternate title for use in informal descriptive contexts where
     * the full, formal title is not necessary.
     */
    public var shortTitle: String.Builder? = null

    /**
     * A Boolean value to indicate that this resource is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the evidence variable was last significantly changed. The
     * date must change when the business version changes and it must change if the status code
     * changes. In addition, it should change when the substantive content of the evidence variable
     * changes.
     *
     * The date is often not tracked until the resource is published, but may be present on draft
     * content. Note that this is not the same as the resource last-modified-date, since the
     * resource may be a secondary representation of the evidence variable. Additional specific
     * dates may be added as extensions or be found by consulting Provenances associated with past
     * versions of the resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual responsible for the release and ongoing
     * maintenance of the evidence variable.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the evidence
     * variable is the organization or individual primarily responsible for the maintenance and
     * upkeep of the evidence variable. This is not necessarily the same individual or organization
     * that developed and initially authored the content. The publisher is the primary point of
     * contact for questions or issues with the evidence variable. This item SHOULD be populated
     * unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the evidence variable from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as comments about misuse, instructions
     * for clinical use and interpretation, literature references, examples from the paper world,
     * etc. It is not a rendering of the evidence variable as conveyed in the 'text' field of the
     * resource itself. This item SHOULD be populated unless the information is available from
     * context (e.g. the language of the evidence variable is presumed to be the predominant
     * language in the place the evidence variable was created).
     */
    public var description: Markdown.Builder? = null

    /** A human-readable string to clarify or explain concepts about the resource. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate evidence variable instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * Explanation of why this EvidenceVariable is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the EvidenceVariable. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * EvidenceVariable.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the resource and/or its contents. Copyright statements are
     * generally legal restrictions on the use and publishing of the resource.
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
     * The date on which the resource content was approved by the publisher. Approval happens once
     * when the content is officially approved for usage.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var approvalDate: Date.Builder? = null

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after
     * approval but does not change the original approval date.
     *
     * If specified, this date follows the original approval date.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var lastReviewDate: Date.Builder? = null

    /**
     * The period during which the resource content was or is planned to be in active use.
     *
     * The effective period for an EvidenceVariable determines when the content is applicable for
     * usage and is independent of publication and review dates. For example, a variable intended to
     * be used for the year 2016 might be published in 2015.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the
     * content.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     */
    public var author: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     */
    public var editor: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization asserted by the publisher to be primarily responsible for
     * review of some aspect of the content.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var reviewer: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization asserted by the publisher to be responsible for officially
     * endorsing the content for use in some setting.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var endorser: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * Related artifacts such as additional documentation, justification, or bibliographic
     * references.
     *
     * Each related artifact is either an attachment, or a reference to another resource, but not
     * both.
     */
    public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

    /**
     * True if the actual variable measured, false if a conceptual representation of the intended
     * variable.
     */
    public var `actual`: Boolean.Builder? = null

    /**
     * A defining factor of the EvidenceVariable. Multiple characteristics are applied with "and"
     * semantics.
     *
     * Characteristics can be defined flexibly to accommodate different use cases for membership
     * criteria, ranging from simple codes, all the way to using an expression language to express
     * the criteria.
     */
    public var characteristic: MutableList<Characteristic.Builder> = mutableListOf()

    /** The method of handling in statistical analysis. */
    public var handling: Enumeration<EvidenceVariableHandling>? = null

    /** A grouping for ordinal or polychotomous variables. */
    public var category: MutableList<Category.Builder> = mutableListOf()

    override fun build(): EvidenceVariable =
      EvidenceVariable(
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
        shortTitle = shortTitle?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        note = note.map { it.build() },
        useContext = useContext.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        copyrightLabel = copyrightLabel?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        author = author.map { it.build() },
        editor = editor.map { it.build() },
        reviewer = reviewer.map { it.build() },
        endorser = endorser.map { it.build() },
        relatedArtifact = relatedArtifact.map { it.build() },
        `actual` = `actual`?.build(),
        characteristic = characteristic.map { it.build() },
        handling = handling,
        category = category.map { it.build() },
      )
  }

  /** Logical grouping of characteristics. */
  public enum class CharacteristicCombination(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    All_Of("all-of", "http://hl7.org/fhir/characteristic-combination", "All of"),
    Any_Of("any-of", "http://hl7.org/fhir/characteristic-combination", "Any of"),
    At_Least("at-least", "http://hl7.org/fhir/characteristic-combination", "At least"),
    At_Most("at-most", "http://hl7.org/fhir/characteristic-combination", "At most"),
    Statistical("statistical", "http://hl7.org/fhir/characteristic-combination", "Statistical"),
    Net_Effect("net-effect", "http://hl7.org/fhir/characteristic-combination", "Net effect"),
    Dataset("dataset", "http://hl7.org/fhir/characteristic-combination", "Dataset");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CharacteristicCombination =
        when (code) {
          "all-of" -> All_Of
          "any-of" -> Any_Of
          "at-least" -> At_Least
          "at-most" -> At_Most
          "statistical" -> Statistical
          "net-effect" -> Net_Effect
          "dataset" -> Dataset
          else ->
            throw IllegalArgumentException("Unknown code $code for enum CharacteristicCombination")
        }
    }
  }

  /**
   * The handling of the variable in statistical analysis for exposures or outcomes (E.g.
   * Dichotomous, Continuous, Descriptive).
   */
  public enum class EvidenceVariableHandling(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Continuous("continuous", "http://hl7.org/fhir/variable-handling", "continuous variable"),
    Dichotomous("dichotomous", "http://hl7.org/fhir/variable-handling", "dichotomous variable"),
    Ordinal("ordinal", "http://hl7.org/fhir/variable-handling", "ordinal variable"),
    Polychotomous(
      "polychotomous",
      "http://hl7.org/fhir/variable-handling",
      "polychotomous variable",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): EvidenceVariableHandling =
        when (code) {
          "continuous" -> Continuous
          "dichotomous" -> Dichotomous
          "ordinal" -> Ordinal
          "polychotomous" -> Polychotomous
          else ->
            throw IllegalArgumentException("Unknown code $code for enum EvidenceVariableHandling")
        }
    }
  }
}
