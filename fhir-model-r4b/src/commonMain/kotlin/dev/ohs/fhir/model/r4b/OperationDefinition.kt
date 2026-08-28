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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionOverloadSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionParameterBindingSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionParameterReferencedFromSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionParameterSerializer
import dev.ohs.fhir.model.r4b.serializers.OperationDefinitionSerializer
import dev.ohs.fhir.model.r4b.terminologies.BindingStrength
import dev.ohs.fhir.model.r4b.terminologies.FHIRAllTypes
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A formal computable definition of an operation (on the RESTful interface) or a named query (using
 * the search interaction).
 */
@Serializable(with = OperationDefinitionSerializer::class)
@SerialName("OperationDefinition")
public data class OperationDefinition(
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
   * An absolute URI that is used to identify this operation definition when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this operation definition is (or will be) published. This URL can be the target of a
   * canonical reference. It SHALL remain the same when the operation definition is stored on
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
   * The identifier that is used to identify this version of the operation definition when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the operation definition author and is not expected to be globally unique. For example, it
   * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence.
   *
   * There may be different operation definition instances that have the same identifier but
   * different versions. The version can be appended to the url in a reference to allow a reference
   * to a particular business version of the operation definition with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the operation definition. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String,
  /**
   * A short, descriptive, user-friendly title for the operation definition.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this operation definition. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of operation definitions that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * Whether this is an operation or a named query.
   *
   * Named queries are invoked differently, and have different capabilities.
   */
  public val kind: Enumeration<OperationKind>,
  /**
   * A Boolean value to indicate that this operation definition is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of operation definitions that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the operation definition was published. The date must
   * change when the business version changes and it must change if the status code changes. In
   * addition, it should change when the substantive content of the operation definition changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the operation definition. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the operation definition.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the operation
   * definition is the organization or individual primarily responsible for the maintenance and
   * upkeep of the operation definition. This is not necessarily the same individual or organization
   * that developed and initially authored the content. The publisher is the primary point of
   * contact for questions or issues with the operation definition. This item SHOULD be populated
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
   * A free text natural language description of the operation definition from a consumer's
   * perspective.
   *
   * This description can be used to capture details such as why the operation definition was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the operation definition as
   * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
   * information is available from context (e.g. the language of the operation definition is
   * presumed to be the predominant language in the place the operation definition was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate operation definition instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the operation definition is intended to be used.
   *
   * It may be possible for the operation definition to be used in jurisdictions other than those
   * for which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this operation definition is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the operation definition. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * operation definition.
   */
  public val purpose: Markdown? = null,
  /**
   * Whether the operation affects state. Side effects such as producing audit trail entries do not
   * count as 'affecting state'.
   *
   * What http methods can be used for the operation depends on the .affectsState value and whether
   * the input parameters are primitive or complex:
   *
   * 1. Servers SHALL support POST method for all operations.
   *
   * 2. Servers SHALL support GET method if all the parameters for the operation are primitive or
   *    there are no parameters and the operation has affectsState = false.
   */
  public val affectsState: Boolean? = null,
  /** The name used to invoke the operation. */
  public val code: Code,
  /** Additional information about how to use this operation or named query. */
  public val comment: Markdown? = null,
  /**
   * Indicates that this operation definition is a constraining profile on the base.
   *
   * A constrained profile can make optional parameters required or not used and clarify
   * documentation.
   */
  public val base: Canonical? = null,
  /**
   * The types on which this operation can be executed.
   *
   * If the type is an abstract resource ("Resource" or "DomainResource") then the operation can be
   * invoked on any concrete specialization.
   */
  public val resource: List<Enumeration<ResourceType>> = listOf(),
  /**
   * Indicates whether this operation or named query can be invoked at the system level (e.g.
   * without needing to choose a resource type for the context).
   */
  public val system: Boolean,
  /**
   * Indicates whether this operation or named query can be invoked at the resource type level for
   * any given resource type level (e.g. without needing to choose a specific resource id for the
   * context).
   */
  public val type: Boolean,
  /**
   * Indicates whether this operation can be invoked on a particular instance of one of the given
   * types.
   */
  public val instance: Boolean,
  /**
   * Additional validation information for the in parameters - a single profile that covers all the
   * parameters. The profile is a constraint on the parameters resource as a whole.
   *
   * If present the profile shall not conflict with what is specified in the parameters in the
   * operation definition (max/min etc.), though it may provide additional constraints. The
   * constraints expressed in the profile apply whether the operation is invoked by a POST wih
   * parameters or not.
   */
  public val inputProfile: Canonical? = null,
  /**
   * Additional validation information for the out parameters - a single profile that covers all the
   * parameters. The profile is a constraint on the parameters resource.
   *
   * If present the profile shall not conflict with what is specified in the parameters in the
   * operation definition (max/min etc.), though it may provide additional constraints. The
   * constraints expressed in the profile apply whether the operation is invoked by a POST wih
   * parameters or not.
   */
  public val outputProfile: Canonical? = null,
  /**
   * The parameters for the operation/query.
   *
   * Query Definitions only have one output parameter, named "result". This might not be described,
   * but can be to allow a profile to be defined.
   */
  public val parameter: List<Parameter> = listOf(),
  /**
   * Defines an appropriate combination of parameters to use when invoking this operation, to help
   * code generators when generating overloaded parameter sets for this operation.
   *
   * The combinations are suggestions as to which sets of parameters to use together, but the
   * combinations are not intended to be authoritative.
   */
  public val overload: List<Overload> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          name.toBuilder(),
          status,
          kind,
          code.toBuilder(),
          system.toBuilder(),
          type.toBuilder(),
          instance.toBuilder(),
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
          title = this@with.title?.toBuilder()
          experimental = this@with.experimental?.toBuilder()
          date = this@with.date?.toBuilder()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          purpose = this@with.purpose?.toBuilder()
          affectsState = this@with.affectsState?.toBuilder()
          comment = this@with.comment?.toBuilder()
          base = this@with.base?.toBuilder()
          resource = this@with.resource.toMutableList()
          inputProfile = this@with.inputProfile?.toBuilder()
          outputProfile = this@with.outputProfile?.toBuilder()
          parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
          overload = this@with.overload.map { it.toBuilder() }.toMutableList()
        }
    }

  /** The parameters for the operation/query. */
  @Serializable(with = OperationDefinitionParameterSerializer::class)
  public data class Parameter(
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
     * The name of used to identify the parameter.
     *
     * This name must be a token (start with a letter in a..z, and only contain letters, numerals,
     * and underscore. Note that for search parameters (type = string, with a search type), the name
     * may be altered by the search modifiers.
     */
    public val name: Code,
    /**
     * Whether this is an input or an output parameter.
     *
     * If a parameter name is used for both an input and an output parameter, the parameter should
     * be defined twice.
     */
    public val use: Enumeration<OperationParameterUse>,
    /** The minimum number of times this parameter SHALL appear in the request or response. */
    public val min: Integer,
    /**
     * The maximum number of times this element is permitted to appear in the request or response.
     */
    public val max: String,
    /** Describes the meaning or use of this parameter. */
    public val documentation: String? = null,
    /**
     * The type for this parameter.
     *
     * if there is no stated parameter, then the parameter is a multi-part parameter; type and must
     * have at least one part defined.
     */
    public val type: Enumeration<FHIRAllTypes>? = null,
    /**
     * Used when the type is "Reference" or "canonical", and identifies a profile structure or
     * implementation Guide that applies to the target of the reference this parameter refers to. If
     * any profiles are specified, then the content must conform to at least one of them. The URL
     * can be a local reference - to a contained StructureDefinition, or a reference to another
     * StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide
     * is specified, the target resource SHALL conform to at least one profile defined in the
     * implementation guide.
     *
     * Often, these profiles are the base definitions from the spec (e.g.
     * http://hl7.org/fhir/StructureDefinition/Patient).
     */
    public val targetProfile: List<Canonical> = listOf(),
    /**
     * How the parameter is understood as a search parameter. This is only used if the parameter
     * type is 'string'.
     */
    public val searchType: Enumeration<SearchParamType>? = null,
    /** Binds to a value set if this parameter is coded (code, Coding, CodeableConcept). */
    public val binding: Binding? = null,
    /**
     * Identifies other resource parameters within the operation invocation that are expected to
     * resolve to this resource.
     *
     * Resolution applies if the referenced parameter exists.
     */
    public val referencedFrom: List<ReferencedFrom> = listOf(),
    /**
     * The parts of a nested Parameter.
     *
     * Query Definitions only have one output parameter, named "result". This might not be
     * described, but can be to allow a profile to be defined.
     */
    public val part: List<Parameter> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            name.toBuilder(),
            use,
            min.toBuilder(),
            max.toBuilder(),
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            documentation = this@with.documentation?.toBuilder()
            type = this@with.type
            targetProfile = this@with.targetProfile.map { it.toBuilder() }.toMutableList()
            searchType = this@with.searchType
            binding = this@with.binding?.toBuilder()
            referencedFrom = this@with.referencedFrom.map { it.toBuilder() }.toMutableList()
            part = this@with.part.map { it.toBuilder() }.toMutableList()
          }
      }

    /** Binds to a value set if this parameter is coded (code, Coding, CodeableConcept). */
    @Serializable(with = OperationDefinitionParameterBindingSerializer::class)
    public data class Binding(
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
       * Indicates the degree of conformance expectations associated with this binding - that is,
       * the degree to which the provided value set must be adhered to in the instances.
       *
       * For further discussion, see [Using Terminologies](terminologies.html).
       */
      public val strength: Enumeration<BindingStrength>,
      /**
       * Points to the value set or external definition (e.g. implicit value set) that identifies
       * the set of codes to be used.
       *
       * For value sets with a referenceResource, the display can contain the value set description.
       * The reference may be version-specific or not.
       */
      public val valueSet: Canonical,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              strength,
              valueSet.toBuilder(),
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            }
        }

      public class Builder(
        /**
         * Indicates the degree of conformance expectations associated with this binding - that is,
         * the degree to which the provided value set must be adhered to in the instances.
         *
         * For further discussion, see [Using Terminologies](terminologies.html).
         */
        public var strength: Enumeration<BindingStrength>,
        /**
         * Points to the value set or external definition (e.g. implicit value set) that identifies
         * the set of codes to be used.
         *
         * For value sets with a referenceResource, the display can contain the value set
         * description. The reference may be version-specific or not.
         */
        public var valueSet: Canonical.Builder,
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

        public fun build(): Binding =
          Binding(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            strength = strength,
            valueSet = valueSet.build(),
          )
      }
    }

    /**
     * Identifies other resource parameters within the operation invocation that are expected to
     * resolve to this resource.
     */
    @Serializable(with = OperationDefinitionParameterReferencedFromSerializer::class)
    public data class ReferencedFrom(
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
       * The name of the parameter or dot-separated path of parameter names pointing to the resource
       * parameter that is expected to contain a reference to this resource.
       */
      public val source: String,
      /**
       * The id of the element in the referencing resource that is expected to resolve to this
       * resource.
       */
      public val sourceId: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(source.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            sourceId = this@with.sourceId?.toBuilder()
          }
        }

      public class Builder(
        /**
         * The name of the parameter or dot-separated path of parameter names pointing to the
         * resource parameter that is expected to contain a reference to this resource.
         */
        public var source: String.Builder
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
         * The id of the element in the referencing resource that is expected to resolve to this
         * resource.
         */
        public var sourceId: String.Builder? = null

        public fun build(): ReferencedFrom =
          ReferencedFrom(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            source = source.build(),
            sourceId = sourceId?.build(),
          )
      }
    }

    public class Builder(
      /**
       * The name of used to identify the parameter.
       *
       * This name must be a token (start with a letter in a..z, and only contain letters, numerals,
       * and underscore. Note that for search parameters (type = string, with a search type), the
       * name may be altered by the search modifiers.
       */
      public var name: Code.Builder,
      /**
       * Whether this is an input or an output parameter.
       *
       * If a parameter name is used for both an input and an output parameter, the parameter should
       * be defined twice.
       */
      public var use: Enumeration<OperationParameterUse>,
      /** The minimum number of times this parameter SHALL appear in the request or response. */
      public var min: Integer.Builder,
      /**
       * The maximum number of times this element is permitted to appear in the request or response.
       */
      public var max: String.Builder,
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

      /** Describes the meaning or use of this parameter. */
      public var documentation: String.Builder? = null

      /**
       * The type for this parameter.
       *
       * if there is no stated parameter, then the parameter is a multi-part parameter; type and
       * must have at least one part defined.
       */
      public var type: Enumeration<FHIRAllTypes>? = null

      /**
       * Used when the type is "Reference" or "canonical", and identifies a profile structure or
       * implementation Guide that applies to the target of the reference this parameter refers to.
       * If any profiles are specified, then the content must conform to at least one of them. The
       * URL can be a local reference - to a contained StructureDefinition, or a reference to
       * another StructureDefinition or Implementation Guide by a canonical URL. When an
       * implementation guide is specified, the target resource SHALL conform to at least one
       * profile defined in the implementation guide.
       *
       * Often, these profiles are the base definitions from the spec (e.g.
       * http://hl7.org/fhir/StructureDefinition/Patient).
       */
      public var targetProfile: MutableList<Canonical.Builder> = mutableListOf()

      /**
       * How the parameter is understood as a search parameter. This is only used if the parameter
       * type is 'string'.
       */
      public var searchType: Enumeration<SearchParamType>? = null

      /** Binds to a value set if this parameter is coded (code, Coding, CodeableConcept). */
      public var binding: Binding.Builder? = null

      /**
       * Identifies other resource parameters within the operation invocation that are expected to
       * resolve to this resource.
       *
       * Resolution applies if the referenced parameter exists.
       */
      public var referencedFrom: MutableList<ReferencedFrom.Builder> = mutableListOf()

      /**
       * The parts of a nested Parameter.
       *
       * Query Definitions only have one output parameter, named "result". This might not be
       * described, but can be to allow a profile to be defined.
       */
      public var part: MutableList<Builder> = mutableListOf()

      public fun build(): Parameter =
        Parameter(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          use = use,
          min = min.build(),
          max = max.build(),
          documentation = documentation?.build(),
          type = type,
          targetProfile = targetProfile.map { it.build() },
          searchType = searchType,
          binding = binding?.build(),
          referencedFrom = referencedFrom.map { it.build() },
          part = part.map { it.build() },
        )
    }
  }

  /**
   * Defines an appropriate combination of parameters to use when invoking this operation, to help
   * code generators when generating overloaded parameter sets for this operation.
   */
  @Serializable(with = OperationDefinitionOverloadSerializer::class)
  public data class Overload(
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
    /** Name of parameter to include in overload. */
    public val parameterName: List<String> = listOf(),
    /** Comments to go on overload. */
    public val comment: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          parameterName = this@with.parameterName.map { it.toBuilder() }.toMutableList()
          comment = this@with.comment?.toBuilder()
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

      /** Name of parameter to include in overload. */
      public var parameterName: MutableList<String.Builder> = mutableListOf()

      /** Comments to go on overload. */
      public var comment: String.Builder? = null

      public fun build(): Overload =
        Overload(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          parameterName = parameterName.map { it.build() },
          comment = comment?.build(),
        )
    }
  }

  public class Builder(
    /**
     * A natural language name identifying the operation definition. This name should be usable as
     * an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder,
    /**
     * The status of this operation definition. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of operation definitions that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * Whether this is an operation or a named query.
     *
     * Named queries are invoked differently, and have different capabilities.
     */
    public var kind: Enumeration<OperationKind>,
    /** The name used to invoke the operation. */
    public var code: Code.Builder,
    /**
     * Indicates whether this operation or named query can be invoked at the system level (e.g.
     * without needing to choose a resource type for the context).
     */
    public var system: Boolean.Builder,
    /**
     * Indicates whether this operation or named query can be invoked at the resource type level for
     * any given resource type level (e.g. without needing to choose a specific resource id for the
     * context).
     */
    public var type: Boolean.Builder,
    /**
     * Indicates whether this operation can be invoked on a particular instance of one of the given
     * types.
     */
    public var instance: Boolean.Builder,
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
     * An absolute URI that is used to identify this operation definition when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this operation definition is (or will be) published. This URL can be the target
     * of a canonical reference. It SHALL remain the same when the operation definition is stored on
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
     * The identifier that is used to identify this version of the operation definition when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the operation definition author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different operation definition instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the operation definition with the format
     * [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the operation definition.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this operation definition is authored for testing purposes
     * (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of operation definitions that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the operation definition was published. The date must
     * change when the business version changes and it must change if the status code changes. In
     * addition, it should change when the substantive content of the operation definition changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the operation definition. Additional specific dates may be
     * added as extensions or be found by consulting Provenances associated with past versions of
     * the resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the operation definition.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the operation
     * definition is the organization or individual primarily responsible for the maintenance and
     * upkeep of the operation definition. This is not necessarily the same individual or
     * organization that developed and initially authored the content. The publisher is the primary
     * point of contact for questions or issues with the operation definition. This item SHOULD be
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
     * A free text natural language description of the operation definition from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as why the operation definition was
     * built, comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the operation
     * definition as conveyed in the 'text' field of the resource itself. This item SHOULD be
     * populated unless the information is available from context (e.g. the language of the
     * operation definition is presumed to be the predominant language in the place the operation
     * definition was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate operation definition instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the operation definition is intended to be used.
     *
     * It may be possible for the operation definition to be used in jurisdictions other than those
     * for which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this operation definition is needed and why it has been designed as it
     * has.
     *
     * This element does not describe the usage of the operation definition. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * operation definition.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * Whether the operation affects state. Side effects such as producing audit trail entries do
     * not count as 'affecting state'.
     *
     * What http methods can be used for the operation depends on the .affectsState value and
     * whether the input parameters are primitive or complex:
     *
     * 1. Servers SHALL support POST method for all operations.
     *
     * 2. Servers SHALL support GET method if all the parameters for the operation are primitive or
     *    there are no parameters and the operation has affectsState = false.
     */
    public var affectsState: Boolean.Builder? = null

    /** Additional information about how to use this operation or named query. */
    public var comment: Markdown.Builder? = null

    /**
     * Indicates that this operation definition is a constraining profile on the base.
     *
     * A constrained profile can make optional parameters required or not used and clarify
     * documentation.
     */
    public var base: Canonical.Builder? = null

    /**
     * The types on which this operation can be executed.
     *
     * If the type is an abstract resource ("Resource" or "DomainResource") then the operation can
     * be invoked on any concrete specialization.
     */
    public var resource: MutableList<Enumeration<ResourceType>> = mutableListOf()

    /**
     * Additional validation information for the in parameters - a single profile that covers all
     * the parameters. The profile is a constraint on the parameters resource as a whole.
     *
     * If present the profile shall not conflict with what is specified in the parameters in the
     * operation definition (max/min etc.), though it may provide additional constraints. The
     * constraints expressed in the profile apply whether the operation is invoked by a POST wih
     * parameters or not.
     */
    public var inputProfile: Canonical.Builder? = null

    /**
     * Additional validation information for the out parameters - a single profile that covers all
     * the parameters. The profile is a constraint on the parameters resource.
     *
     * If present the profile shall not conflict with what is specified in the parameters in the
     * operation definition (max/min etc.), though it may provide additional constraints. The
     * constraints expressed in the profile apply whether the operation is invoked by a POST wih
     * parameters or not.
     */
    public var outputProfile: Canonical.Builder? = null

    /**
     * The parameters for the operation/query.
     *
     * Query Definitions only have one output parameter, named "result". This might not be
     * described, but can be to allow a profile to be defined.
     */
    public var parameter: MutableList<Parameter.Builder> = mutableListOf()

    /**
     * Defines an appropriate combination of parameters to use when invoking this operation, to help
     * code generators when generating overloaded parameter sets for this operation.
     *
     * The combinations are suggestions as to which sets of parameters to use together, but the
     * combinations are not intended to be authoritative.
     */
    public var overload: MutableList<Overload.Builder> = mutableListOf()

    override fun build(): OperationDefinition =
      OperationDefinition(
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
        name = name.build(),
        title = title?.build(),
        status = status,
        kind = kind,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        affectsState = affectsState?.build(),
        code = code.build(),
        comment = comment?.build(),
        base = base?.build(),
        resource = resource,
        system = system.build(),
        type = type.build(),
        instance = instance.build(),
        inputProfile = inputProfile?.build(),
        outputProfile = outputProfile?.build(),
        parameter = parameter.map { it.build() },
        overload = overload.map { it.build() },
      )
  }

  /** Whether an operation parameter is an input or an output parameter. */
  public enum class OperationParameterUse(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    In("in", "http://hl7.org/fhir/operation-parameter-use", "In"),
    Out("out", "http://hl7.org/fhir/operation-parameter-use", "Out");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): OperationParameterUse =
        fromCodeOrNull(code)
          ?: throw IllegalArgumentException("Unknown code $code for enum OperationParameterUse")

      public fun fromCodeOrNull(code: kotlin.String?): OperationParameterUse? =
        when (code) {
          "in" -> In
          "out" -> Out
          else -> null
        }
    }
  }

  /** Whether an operation is a normal operation or a query. */
  public enum class OperationKind(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Operation("operation", "http://hl7.org/fhir/operation-kind", "Operation"),
    Query("query", "http://hl7.org/fhir/operation-kind", "Query");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): OperationKind =
        fromCodeOrNull(code)
          ?: throw IllegalArgumentException("Unknown code $code for enum OperationKind")

      public fun fromCodeOrNull(code: kotlin.String?): OperationKind? =
        when (code) {
          "operation" -> Operation
          "query" -> Query
          else -> null
        }
    }
  }
}
