/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.LibrarySerializer
import com.google.fhir.model.r4b.serializers.LibrarySubjectSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The Library resource is a general-purpose container for knowledge asset definitions. It can be
 * used to describe and expose existing knowledge assets such as logic libraries and information
 * model descriptions, as well as to describe a collection of knowledge assets.
 */
@Serializable(with = LibrarySerializer::class)
@SerialName("Library")
public data class Library(
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
   * An absolute URI that is used to identify this library when it is referenced in a specification,
   * model, design or an instance; also called its canonical identifier. This SHOULD be globally
   * unique and SHOULD be a literal address at which at which an authoritative instance of this
   * library is (or will be) published. This URL can be the target of a canonical reference. It
   * SHALL remain the same when the library is stored on different servers.
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
   * A formal identifier that is used to identify this library when it is represented in other
   * formats, or referenced in a specification, model, design or an instance. e.g. CMS or NQF
   * identifiers for a measure artifact. Note that at least one identifier is required for
   * non-experimental active artifacts.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this library outside of FHIR, where it is not possible to use the
   * logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the library when it is referenced in a
   * specification, model, design or instance. This is an arbitrary value managed by the library
   * author and is not expected to be globally unique. For example, it might be a timestamp (e.g.
   * yyyymmdd) if a managed version is not available. There is also no expectation that versions can
   * be placed in a lexicographical sequence. To provide a version consistent with the Decision
   * Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more
   * information on versioning knowledge assets, refer to the Decision Support Service
   * specification. Note that a version is required for non-experimental active artifacts.
   *
   * There may be different library instances that have the same identifier but different versions.
   * The version can be appended to the url in a reference to allow a reference to a particular
   * business version of the library with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the library. This name should be usable as an identifier
   * for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the library.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * An explanatory or alternate title for the library giving additional information about its
   * content.
   */
  public val subtitle: String? = null,
  /**
   * The status of this library. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of libraries that are appropriate for use vs. not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this library is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of librarys that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * Identifies the type of library such as a Logic Library, Model Definition, Asset Collection, or
   * Module Definition.
   */
  public val type: CodeableConcept,
  /**
   * A code or group definition that describes the intended subject of the contents of the library.
   */
  public val subject: Subject? = null,
  /**
   * The date (and optionally time) when the library was published. The date must change when the
   * business version changes and it must change if the status code changes. In addition, it should
   * change when the substantive content of the library changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the library. Additional specific dates may be added as extensions
   * or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the library.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the library is
   * the organization or individual primarily responsible for the maintenance and upkeep of the
   * library. This is not necessarily the same individual or organization that developed and
   * initially authored the content. The publisher is the primary point of contact for questions or
   * issues with the library. This item SHOULD be populated unless the information is available from
   * context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the library from a consumer's perspective.
   *
   * This description can be used to capture details such as why the library was built, comments
   * about misuse, instructions for clinical use and interpretation, literature references, examples
   * from the paper world, etc. It is not a rendering of the library as conveyed in the 'text' field
   * of the resource itself. This item SHOULD be populated unless the information is available from
   * context (e.g. the language of the library is presumed to be the predominant language in the
   * place the library was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate library instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the library is intended to be used.
   *
   * It may be possible for the library to be used in jurisdictions other than those for which it
   * was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this library is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the library. Instead, it provides traceability of
   * ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used to
   * point to source materials or specifications that drove the structure of this library.
   */
  public val purpose: Markdown? = null,
  /** A detailed description of how the library is used from a clinical perspective. */
  public val usage: String? = null,
  /**
   * A copyright statement relating to the library and/or its contents. Copyright statements are
   * generally legal restrictions on the use and publishing of the library.
   */
  public val copyright: Markdown? = null,
  /**
   * The date on which the resource content was approved by the publisher. Approval happens once
   * when the content is officially approved for usage.
   *
   * The 'date' element may be more recent than the approval date because of minor changes or
   * editorial corrections.
   */
  public val approvalDate: Date? = null,
  /**
   * The date on which the resource content was last reviewed. Review happens periodically after
   * approval but does not change the original approval date.
   *
   * If specified, this date follows the original approval date.
   */
  public val lastReviewDate: Date? = null,
  /**
   * The period during which the library content was or is planned to be in active use.
   *
   * The effective period for a library determines when the content is applicable for usage and is
   * independent of publication and review dates. For example, a measure intended to be used for the
   * year 2016 might be published in 2015.
   */
  public val effectivePeriod: Period? = null,
  /**
   * Descriptive topics related to the content of the library. Topics provide a high-level
   * categorization of the library that can be useful for filtering and searching.
   */
  public val topic: List<CodeableConcept> = listOf(),
  /**
   * An individiual or organization primarily involved in the creation and maintenance of the
   * content.
   */
  public val author: List<ContactDetail> = listOf(),
  /** An individual or organization primarily responsible for internal coherence of the content. */
  public val editor: List<ContactDetail> = listOf(),
  /**
   * An individual or organization primarily responsible for review of some aspect of the content.
   */
  public val reviewer: List<ContactDetail> = listOf(),
  /**
   * An individual or organization responsible for officially endorsing the content for use in some
   * setting.
   */
  public val endorser: List<ContactDetail> = listOf(),
  /**
   * Related artifacts such as additional documentation, justification, or bibliographic references.
   *
   * Each related artifact is either an attachment, or a reference to another resource, but not
   * both.
   */
  public val relatedArtifact: List<RelatedArtifact> = listOf(),
  /** The parameter element defines parameters used by the library. */
  public val parameter: List<ParameterDefinition> = listOf(),
  /**
   * Describes a set of data that must be provided in order to be able to successfully perform the
   * computations defined by the library.
   */
  public val dataRequirement: List<DataRequirement> = listOf(),
  /**
   * The content of the library as an Attachment. The content may be a reference to a url, or may be
   * directly embedded as a base-64 string. Either way, the contentType of the attachment determines
   * how to interpret the content.
   */
  public val content: List<Attachment> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, type.toBuilder()).apply {
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
        name = this@with.name?.toBuilder()
        title = this@with.title?.toBuilder()
        subtitle = this@with.subtitle?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        subject = this@with.subject
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        usage = this@with.usage?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        effectivePeriod = this@with.effectivePeriod?.toBuilder()
        topic = this@with.topic.map { it.toBuilder() }.toMutableList()
        author = this@with.author.map { it.toBuilder() }.toMutableList()
        editor = this@with.editor.map { it.toBuilder() }.toMutableList()
        reviewer = this@with.reviewer.map { it.toBuilder() }.toMutableList()
        endorser = this@with.endorser.map { it.toBuilder() }.toMutableList()
        relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
        parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
        dataRequirement = this@with.dataRequirement.map { it.toBuilder() }.toMutableList()
        content = this@with.content.map { it.toBuilder() }.toMutableList()
      }
    }

  @Serializable(with = LibrarySubjectSerializer::class)
  public sealed interface Subject {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4b.CodeableConcept
    ) : Subject

    public data class Reference(public val `value`: com.google.fhir.model.r4b.Reference) : Subject

    public companion object {
      internal fun from(
        codeableConceptValue: com.google.fhir.model.r4b.CodeableConcept?,
        referenceValue: com.google.fhir.model.r4b.Reference?,
      ): Subject? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of this library. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of libraries that are appropriate for use vs. not.
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * Identifies the type of library such as a Logic Library, Model Definition, Asset Collection,
     * or Module Definition.
     */
    public var type: CodeableConcept.Builder,
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
     * An absolute URI that is used to identify this library when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this library is (or will be) published. This URL can be the target of a canonical
     * reference. It SHALL remain the same when the library is stored on different servers.
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
     * A formal identifier that is used to identify this library when it is represented in other
     * formats, or referenced in a specification, model, design or an instance. e.g. CMS or NQF
     * identifiers for a measure artifact. Note that at least one identifier is required for
     * non-experimental active artifacts.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this library outside of FHIR, where it is not possible to
     * use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the library when it is referenced in
     * a specification, model, design or instance. This is an arbitrary value managed by the library
     * author and is not expected to be globally unique. For example, it might be a timestamp (e.g.
     * yyyymmdd) if a managed version is not available. There is also no expectation that versions
     * can be placed in a lexicographical sequence. To provide a version consistent with the
     * Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For
     * more information on versioning knowledge assets, refer to the Decision Support Service
     * specification. Note that a version is required for non-experimental active artifacts.
     *
     * There may be different library instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the library with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the library. This name should be usable as an identifier
     * for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the library.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * An explanatory or alternate title for the library giving additional information about its
     * content.
     */
    public var subtitle: String.Builder? = null

    /**
     * A Boolean value to indicate that this library is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of librarys that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * A code or group definition that describes the intended subject of the contents of the
     * library.
     */
    public var subject: Subject? = null

    /**
     * The date (and optionally time) when the library was published. The date must change when the
     * business version changes and it must change if the status code changes. In addition, it
     * should change when the substantive content of the library changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the library. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the library.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the library
     * is the organization or individual primarily responsible for the maintenance and upkeep of the
     * library. This is not necessarily the same individual or organization that developed and
     * initially authored the content. The publisher is the primary point of contact for questions
     * or issues with the library. This item SHOULD be populated unless the information is available
     * from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the library from a consumer's perspective.
     *
     * This description can be used to capture details such as why the library was built, comments
     * about misuse, instructions for clinical use and interpretation, literature references,
     * examples from the paper world, etc. It is not a rendering of the library as conveyed in the
     * 'text' field of the resource itself. This item SHOULD be populated unless the information is
     * available from context (e.g. the language of the library is presumed to be the predominant
     * language in the place the library was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate library instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the library is intended to be used.
     *
     * It may be possible for the library to be used in jurisdictions other than those for which it
     * was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this library is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the library. Instead, it provides traceability of
     * ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used to
     * point to source materials or specifications that drove the structure of this library.
     */
    public var purpose: Markdown.Builder? = null

    /** A detailed description of how the library is used from a clinical perspective. */
    public var usage: String.Builder? = null

    /**
     * A copyright statement relating to the library and/or its contents. Copyright statements are
     * generally legal restrictions on the use and publishing of the library.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once
     * when the content is officially approved for usage.
     *
     * The 'date' element may be more recent than the approval date because of minor changes or
     * editorial corrections.
     */
    public var approvalDate: Date.Builder? = null

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after
     * approval but does not change the original approval date.
     *
     * If specified, this date follows the original approval date.
     */
    public var lastReviewDate: Date.Builder? = null

    /**
     * The period during which the library content was or is planned to be in active use.
     *
     * The effective period for a library determines when the content is applicable for usage and is
     * independent of publication and review dates. For example, a measure intended to be used for
     * the year 2016 might be published in 2015.
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * Descriptive topics related to the content of the library. Topics provide a high-level
     * categorization of the library that can be useful for filtering and searching.
     */
    public var topic: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the
     * content.
     */
    public var author: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     */
    public var editor: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization primarily responsible for review of some aspect of the content.
     */
    public var reviewer: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization responsible for officially endorsing the content for use in
     * some setting.
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

    /** The parameter element defines parameters used by the library. */
    public var parameter: MutableList<ParameterDefinition.Builder> = mutableListOf()

    /**
     * Describes a set of data that must be provided in order to be able to successfully perform the
     * computations defined by the library.
     */
    public var dataRequirement: MutableList<DataRequirement.Builder> = mutableListOf()

    /**
     * The content of the library as an Attachment. The content may be a reference to a url, or may
     * be directly embedded as a base-64 string. Either way, the contentType of the attachment
     * determines how to interpret the content.
     */
    public var content: MutableList<Attachment.Builder> = mutableListOf()

    override fun build(): Library =
      Library(
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
        name = name?.build(),
        title = title?.build(),
        subtitle = subtitle?.build(),
        status = status,
        experimental = experimental?.build(),
        type = type.build(),
        subject = subject,
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        usage = usage?.build(),
        copyright = copyright?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        topic = topic.map { it.build() },
        author = author.map { it.build() },
        editor = editor.map { it.build() },
        reviewer = reviewer.map { it.build() },
        endorser = endorser.map { it.build() },
        relatedArtifact = relatedArtifact.map { it.build() },
        parameter = parameter.map { it.build() },
        dataRequirement = dataRequirement.map { it.build() },
        content = content.map { it.build() },
      )
  }
}
