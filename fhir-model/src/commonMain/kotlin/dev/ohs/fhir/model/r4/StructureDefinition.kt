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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.StructureDefinitionContextSerializer
import com.google.fhir.model.r4.serializers.StructureDefinitionDifferentialSerializer
import com.google.fhir.model.r4.serializers.StructureDefinitionMappingSerializer
import com.google.fhir.model.r4.serializers.StructureDefinitionSerializer
import com.google.fhir.model.r4.serializers.StructureDefinitionSnapshotSerializer
import com.google.fhir.model.r4.terminologies.FHIRVersion
import com.google.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A definition of a FHIR structure. This resource is used to describe the underlying resources,
 * data types defined in FHIR, and also for describing extensions and constraints on resources and
 * data types.
 */
@Serializable(with = StructureDefinitionSerializer::class)
@SerialName("StructureDefinition")
public data class StructureDefinition(
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
   * An absolute URI that is used to identify this structure definition when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this structure definition is (or will be) published. This URL can be the target of a
   * canonical reference. It SHALL remain the same when the structure definition is stored on
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
   * A formal identifier that is used to identify this structure definition when it is represented
   * in other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this structure definition outside of FHIR, where it is not possible
   * to use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the structure definition when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the structure definition author and is not expected to be globally unique. For example, it
   * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence.
   *
   * There may be different structure definition instances that have the same identifier but
   * different versions. The version can be appended to the url in a reference to allow a reference
   * to a particular business version of the structure definition with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the structure definition. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.Some Examples:
   * * O2SatObservation
   * * PresentationReport
   * * Immunization2
   * * AcmeAdmissionRecordOld.
   */
  public val name: String,
  /**
   * A short, descriptive, user-friendly title for the structure definition.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.Applications don't have to use this name but can always fall back to it. The
   * title also corresponds to the label for the root element.
   */
  public val title: String? = null,
  /**
   * The status of this structure definition. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of structure definitions that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this structure definition is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of structure definitions that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the structure definition was published. The date must
   * change when the business version changes and it must change if the status code changes. In
   * addition, it should change when the substantive content of the structure definition changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the structure definition. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the structure definition.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the structure
   * definition is the organization or individual primarily responsible for the maintenance and
   * upkeep of the structure definition. This is not necessarily the same individual or organization
   * that developed and initially authored the content. The publisher is the primary point of
   * contact for questions or issues with the structure definition. This item SHOULD be populated
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
   * A free text natural language description of the structure definition from a consumer's
   * perspective.
   *
   * This description can be used to capture details such as why the structure definition was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the structure definition as
   * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
   * information is available from context (e.g. the language of the structure definition is
   * presumed to be the predominant language in the place the structure definition was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate structure definition instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the structure definition is intended to be used.
   *
   * It may be possible for the structure definition to be used in jurisdictions other than those
   * for which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this structure definition is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the structure definition. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * structure definition.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the structure definition and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the structure
   * definition.
   */
  public val copyright: Markdown? = null,
  /**
   * A set of key words or terms from external terminologies that may be used to assist with
   * indexing and searching of templates nby describing the use of this structure definition, or the
   * content it describes.
   */
  public val keyword: List<Coding> = listOf(),
  /**
   * The version of the FHIR specification on which this StructureDefinition is based - this is the
   * formal version of the specification, without the revision number, e.g.
   * [publication].[major].[minor], which is 4.0.1. for this version.
   *
   * A StructureDefinition does not need to specify the target it applies to as StructureDefinitions
   * will often be valid across multiple versions of FHIR. FHIR tooling can determine whether a
   * StructureDefinition is consistent with a particular StructureDefinition if desired.
   */
  public val fhirVersion: Enumeration<FHIRVersion>? = null,
  /** An external specification that the content is mapped to. */
  public val mapping: List<Mapping> = listOf(),
  /** Defines the kind of structure that this definition is describing. */
  public val kind: Enumeration<StructureDefinitionKind>,
  /**
   * Whether structure this definition describes is abstract or not - that is, whether the structure
   * is not intended to be instantiated. For Resources and Data types, abstract types will never be
   * exchanged between systems.
   *
   * Abstract Resources cannot be instantiated - a concrete sub-type must be used. Abstract
   * datatypes and extensions cannot be used in an instance. For logical models, the exact
   * implication of "abstract" will rest with the author, depending how the logical model is used.
   * Flagging a constraint structure as abstract conveys design intent but makes no difference to
   * how the structure definition is handled. Note that inline declared elements that are given the
   * type "Element" in the StructureDefinition, but have children described, are anonymous concrete
   * types that specialize Element.
   */
  public val `abstract`: Boolean,
  /**
   * Identifies the types of resource or data type elements to which the extension can be applied.
   */
  public val context: List<Context> = listOf(),
  /**
   * A set of rules as FHIRPath Invariants about when the extension can be used (e.g. co-occurrence
   * variants for the extension). All the rules must be true.
   *
   * The rules are only evaluated when the extension is present. When evaluating the invariant, the
   * FHIRPath focus is the element that holds the extension, and %extension refers to the extension
   * itself.
   */
  public val contextInvariant: List<String> = listOf(),
  /**
   * The type this structure describes. If the derivation kind is 'specialization' then this is the
   * master definition for a type, and there is always one of these (a data type, an extension, a
   * resource, including abstract ones). Otherwise the structure definition is a constraint on the
   * stated type (and in this case, the type cannot be an abstract type). References are URLs that
   * are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference to
   * http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical
   * models.
   *
   * Note that in the case of constraints, the type could be determined by chasing through the
   * baseDefinition references until a concrete structure (derivation = specialization) is reached,
   * or by looking at the path of the first element in the snapshot - if present - but providing the
   * type directly makes for simpler tooling and indexing.
   *
   * The type must match the elements defined in the differential and the snapshot. For all FHIR
   * defined types, the path name of the element will start with the type name. For logical models,
   * where the type is a URL, the type name SHOULD start with the tail of the type URL where
   * required.
   */
  public val type: Uri,
  /**
   * An absolute URI that is the base structure from which this type is derived, either by
   * specialization or constraint.
   *
   * If differential constraints are specified in this structure, they are applied to the base in a
   * "differential" fashion. If there is no base, then the differential constraints cannot be
   * provided (snapshot only). Differential structures are useful for the editing perspective, and
   * snapshot structures are suitable for operational use. The FHIR Project provides a number of
   * tools/services to populate snapshots from differential constraints. Logical Models have a base
   * of "Element" or another logical model.
   */
  public val baseDefinition: Canonical? = null,
  /**
   * How the type relates to the baseDefinition.
   *
   * If the definition is a specialization, then it adds new elements in the differential, and the
   * snapshot includes the inherited elements. If the definition is a constraint, then it cannot
   * define new elements, it can only make new rules about existing content (see
   * [Profiling Resources](profiling.html#resources)).
   */
  public val derivation: Enumeration<TypeDerivationRule>? = null,
  /**
   * A snapshot view is expressed in a standalone form that can be used and interpreted without
   * considering the base StructureDefinition.
   */
  public val snapshot: Snapshot? = null,
  /**
   * A differential view is expressed relative to the base StructureDefinition - a statement of
   * differences that it applies.
   */
  public val differential: Differential? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          url.toBuilder(),
          name.toBuilder(),
          status,
          kind,
          `abstract`.toBuilder(),
          type.toBuilder(),
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
          keyword = this@with.keyword.map { it.toBuilder() }.toMutableList()
          fhirVersion = this@with.fhirVersion
          mapping = this@with.mapping.map { it.toBuilder() }.toMutableList()
          context = this@with.context.map { it.toBuilder() }.toMutableList()
          contextInvariant = this@with.contextInvariant.map { it.toBuilder() }.toMutableList()
          baseDefinition = this@with.baseDefinition?.toBuilder()
          derivation = this@with.derivation
          snapshot = this@with.snapshot?.toBuilder()
          differential = this@with.differential?.toBuilder()
        }
    }

  /** An external specification that the content is mapped to. */
  @Serializable(with = StructureDefinitionMappingSerializer::class)
  public data class Mapping(
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
     * An Internal id that is used to identify this mapping set when specific mappings are made.
     *
     * The specification is described once, with general comments, and then specific mappings are
     * made that reference this declaration.
     */
    public val identity: Id,
    /**
     * An absolute URI that identifies the specification that this mapping is expressed to.
     *
     * A formal identity for the specification being mapped to helps with identifying maps
     * consistently.
     */
    public val uri: Uri? = null,
    /** A name for the specification that is being mapped to. */
    public val name: String? = null,
    /**
     * Comments about this mapping, including version notes, issues, scope limitations, and other
     * important notes for usage.
     */
    public val comment: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(identity.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          uri = this@with.uri?.toBuilder()
          name = this@with.name?.toBuilder()
          comment = this@with.comment?.toBuilder()
        }
      }

    public class Builder(
      /**
       * An Internal id that is used to identify this mapping set when specific mappings are made.
       *
       * The specification is described once, with general comments, and then specific mappings are
       * made that reference this declaration.
       */
      public var identity: Id.Builder
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
       * An absolute URI that identifies the specification that this mapping is expressed to.
       *
       * A formal identity for the specification being mapped to helps with identifying maps
       * consistently.
       */
      public var uri: Uri.Builder? = null

      /** A name for the specification that is being mapped to. */
      public var name: String.Builder? = null

      /**
       * Comments about this mapping, including version notes, issues, scope limitations, and other
       * important notes for usage.
       */
      public var comment: String.Builder? = null

      public fun build(): Mapping =
        Mapping(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identity = identity.build(),
          uri = uri?.build(),
          name = name?.build(),
          comment = comment?.build(),
        )
    }
  }

  /**
   * Identifies the types of resource or data type elements to which the extension can be applied.
   */
  @Serializable(with = StructureDefinitionContextSerializer::class)
  public data class Context(
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
     * Defines how to interpret the expression that defines what the context of the extension is.
     */
    public val type: Enumeration<ExtensionContextType>,
    /** An expression that defines where an extension can be used in resources. */
    public val expression: String,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type, expression.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Defines how to interpret the expression that defines what the context of the extension is.
       */
      public var type: Enumeration<ExtensionContextType>,
      /** An expression that defines where an extension can be used in resources. */
      public var expression: String.Builder,
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

      public fun build(): Context =
        Context(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          expression = expression.build(),
        )
    }
  }

  /**
   * A snapshot view is expressed in a standalone form that can be used and interpreted without
   * considering the base StructureDefinition.
   */
  @Serializable(with = StructureDefinitionSnapshotSerializer::class)
  public data class Snapshot(
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
    /** Captures constraints on each element within the resource. */
    public val element: List<ElementDefinition>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(element.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Captures constraints on each element within the resource. */
      public var element: MutableList<ElementDefinition.Builder>
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

      public fun build(): Snapshot =
        Snapshot(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          element = element.map { it.build() },
        )
    }
  }

  /**
   * A differential view is expressed relative to the base StructureDefinition - a statement of
   * differences that it applies.
   */
  @Serializable(with = StructureDefinitionDifferentialSerializer::class)
  public data class Differential(
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
    /** Captures constraints on each element within the resource. */
    public val element: List<ElementDefinition>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(element.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Captures constraints on each element within the resource. */
      public var element: MutableList<ElementDefinition.Builder>
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

      public fun build(): Differential =
        Differential(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          element = element.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * An absolute URI that is used to identify this structure definition when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this structure definition is (or will be) published. This URL can be the target
     * of a canonical reference. It SHALL remain the same when the structure definition is stored on
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
     * A natural language name identifying the structure definition. This name should be usable as
     * an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.Some Examples:
     * * O2SatObservation
     * * PresentationReport
     * * Immunization2
     * * AcmeAdmissionRecordOld.
     */
    public var name: String.Builder,
    /**
     * The status of this structure definition. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of structure definitions that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
    /** Defines the kind of structure that this definition is describing. */
    public var kind: Enumeration<StructureDefinitionKind>,
    /**
     * Whether structure this definition describes is abstract or not - that is, whether the
     * structure is not intended to be instantiated. For Resources and Data types, abstract types
     * will never be exchanged between systems.
     *
     * Abstract Resources cannot be instantiated - a concrete sub-type must be used. Abstract
     * datatypes and extensions cannot be used in an instance. For logical models, the exact
     * implication of "abstract" will rest with the author, depending how the logical model is used.
     * Flagging a constraint structure as abstract conveys design intent but makes no difference to
     * how the structure definition is handled. Note that inline declared elements that are given
     * the type "Element" in the StructureDefinition, but have children described, are anonymous
     * concrete types that specialize Element.
     */
    public var `abstract`: Boolean.Builder,
    /**
     * The type this structure describes. If the derivation kind is 'specialization' then this is
     * the master definition for a type, and there is always one of these (a data type, an
     * extension, a resource, including abstract ones). Otherwise the structure definition is a
     * constraint on the stated type (and in this case, the type cannot be an abstract type).
     * References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g.
     * "string" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are
     * only allowed in logical models.
     *
     * Note that in the case of constraints, the type could be determined by chasing through the
     * baseDefinition references until a concrete structure (derivation = specialization) is
     * reached, or by looking at the path of the first element in the snapshot - if present - but
     * providing the type directly makes for simpler tooling and indexing.
     *
     * The type must match the elements defined in the differential and the snapshot. For all FHIR
     * defined types, the path name of the element will start with the type name. For logical
     * models, where the type is a URL, the type name SHOULD start with the tail of the type URL
     * where required.
     */
    public var type: Uri.Builder,
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
     * A formal identifier that is used to identify this structure definition when it is represented
     * in other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this structure definition outside of FHIR, where it is not
     * possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the structure definition when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the structure definition author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different structure definition instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the structure definition with the format
     * [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the structure definition.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.Applications don't have to use this name but can always fall back to it. The
     * title also corresponds to the label for the root element.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this structure definition is authored for testing purposes
     * (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of structure definitions that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the structure definition was published. The date must
     * change when the business version changes and it must change if the status code changes. In
     * addition, it should change when the substantive content of the structure definition changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the structure definition. Additional specific dates may be
     * added as extensions or be found by consulting Provenances associated with past versions of
     * the resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the structure definition.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the structure
     * definition is the organization or individual primarily responsible for the maintenance and
     * upkeep of the structure definition. This is not necessarily the same individual or
     * organization that developed and initially authored the content. The publisher is the primary
     * point of contact for questions or issues with the structure definition. This item SHOULD be
     * populated unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the structure definition from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as why the structure definition was
     * built, comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the structure
     * definition as conveyed in the 'text' field of the resource itself. This item SHOULD be
     * populated unless the information is available from context (e.g. the language of the
     * structure definition is presumed to be the predominant language in the place the structure
     * definition was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate structure definition instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the structure definition is intended to be used.
     *
     * It may be possible for the structure definition to be used in jurisdictions other than those
     * for which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this structure definition is needed and why it has been designed as it
     * has.
     *
     * This element does not describe the usage of the structure definition. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * structure definition.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the structure definition and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the structure
     * definition.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * A set of key words or terms from external terminologies that may be used to assist with
     * indexing and searching of templates nby describing the use of this structure definition, or
     * the content it describes.
     */
    public var keyword: MutableList<Coding.Builder> = mutableListOf()

    /**
     * The version of the FHIR specification on which this StructureDefinition is based - this is
     * the formal version of the specification, without the revision number, e.g.
     * [publication].[major].[minor], which is 4.0.1. for this version.
     *
     * A StructureDefinition does not need to specify the target it applies to as
     * StructureDefinitions will often be valid across multiple versions of FHIR. FHIR tooling can
     * determine whether a StructureDefinition is consistent with a particular StructureDefinition
     * if desired.
     */
    public var fhirVersion: Enumeration<FHIRVersion>? = null

    /** An external specification that the content is mapped to. */
    public var mapping: MutableList<Mapping.Builder> = mutableListOf()

    /**
     * Identifies the types of resource or data type elements to which the extension can be applied.
     */
    public var context: MutableList<Context.Builder> = mutableListOf()

    /**
     * A set of rules as FHIRPath Invariants about when the extension can be used (e.g.
     * co-occurrence variants for the extension). All the rules must be true.
     *
     * The rules are only evaluated when the extension is present. When evaluating the invariant,
     * the FHIRPath focus is the element that holds the extension, and %extension refers to the
     * extension itself.
     */
    public var contextInvariant: MutableList<String.Builder> = mutableListOf()

    /**
     * An absolute URI that is the base structure from which this type is derived, either by
     * specialization or constraint.
     *
     * If differential constraints are specified in this structure, they are applied to the base in
     * a "differential" fashion. If there is no base, then the differential constraints cannot be
     * provided (snapshot only). Differential structures are useful for the editing perspective, and
     * snapshot structures are suitable for operational use. The FHIR Project provides a number of
     * tools/services to populate snapshots from differential constraints. Logical Models have a
     * base of "Element" or another logical model.
     */
    public var baseDefinition: Canonical.Builder? = null

    /**
     * How the type relates to the baseDefinition.
     *
     * If the definition is a specialization, then it adds new elements in the differential, and the
     * snapshot includes the inherited elements. If the definition is a constraint, then it cannot
     * define new elements, it can only make new rules about existing content (see
     * [Profiling Resources](profiling.html#resources)).
     */
    public var derivation: Enumeration<TypeDerivationRule>? = null

    /**
     * A snapshot view is expressed in a standalone form that can be used and interpreted without
     * considering the base StructureDefinition.
     */
    public var snapshot: Snapshot.Builder? = null

    /**
     * A differential view is expressed relative to the base StructureDefinition - a statement of
     * differences that it applies.
     */
    public var differential: Differential.Builder? = null

    override fun build(): StructureDefinition =
      StructureDefinition(
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
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        keyword = keyword.map { it.build() },
        fhirVersion = fhirVersion,
        mapping = mapping.map { it.build() },
        kind = kind,
        `abstract` = `abstract`.build(),
        context = context.map { it.build() },
        contextInvariant = contextInvariant.map { it.build() },
        type = type.build(),
        baseDefinition = baseDefinition?.build(),
        derivation = derivation,
        snapshot = snapshot?.build(),
        differential = differential?.build(),
      )
  }

  /** How an extension context is interpreted. */
  public enum class ExtensionContextType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Fhirpath("fhirpath", "http://hl7.org/fhir/extension-context-type", "FHIRPath"),
    Element("element", "http://hl7.org/fhir/extension-context-type", "Element ID"),
    Extension("extension", "http://hl7.org/fhir/extension-context-type", "Extension URL");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ExtensionContextType =
        when (code) {
          "fhirpath" -> Fhirpath
          "element" -> Element
          "extension" -> Extension
          else -> throw IllegalArgumentException("Unknown code $code for enum ExtensionContextType")
        }
    }
  }

  /** Defines the type of structure that a definition is describing. */
  public enum class StructureDefinitionKind(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Primitive_Type(
      "primitive-type",
      "http://hl7.org/fhir/structure-definition-kind",
      "Primitive Data Type",
    ),
    Complex_Type(
      "complex-type",
      "http://hl7.org/fhir/structure-definition-kind",
      "Complex Data Type",
    ),
    Resource("resource", "http://hl7.org/fhir/structure-definition-kind", "Resource"),
    Logical("logical", "http://hl7.org/fhir/structure-definition-kind", "Logical");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): StructureDefinitionKind =
        when (code) {
          "primitive-type" -> Primitive_Type
          "complex-type" -> Complex_Type
          "resource" -> Resource
          "logical" -> Logical
          else ->
            throw IllegalArgumentException("Unknown code $code for enum StructureDefinitionKind")
        }
    }
  }

  /** How a type relates to its baseDefinition. */
  public enum class TypeDerivationRule(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Specialization("specialization", "http://hl7.org/fhir/type-derivation-rule", "Specialization"),
    Constraint("constraint", "http://hl7.org/fhir/type-derivation-rule", "Constraint");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): TypeDerivationRule =
        when (code) {
          "specialization" -> Specialization
          "constraint" -> Constraint
          else -> throw IllegalArgumentException("Unknown code $code for enum TypeDerivationRule")
        }
    }
  }
}
