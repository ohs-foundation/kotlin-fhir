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

import dev.ohs.fhir.model.r4b.serializers.ConceptMapGroupElementSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapGroupElementTargetDependsOnSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapGroupElementTargetSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapGroupSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapGroupUnmappedSerializer
import dev.ohs.fhir.model.r4b.serializers.ConceptMapSerializer
import dev.ohs.fhir.model.r4b.terminologies.ConceptMapEquivalence
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A statement of relationships from one set of concepts to one or more other concepts - either
 * concepts in code systems, or data element/data element concepts, or classes in class models.
 */
@Serializable(with = ConceptMapSerializer::class)
@SerialName("ConceptMap")
public data class ConceptMap(
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
   * An absolute URI that is used to identify this concept map when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this concept map is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the concept map is stored on different servers.
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
   * A formal identifier that is used to identify this concept map when it is represented in other
   * formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this concept map outside of FHIR, where it is not possible to use
   * the logical URI.
   */
  public val identifier: Identifier? = null,
  /**
   * The identifier that is used to identify this version of the concept map when it is referenced
   * in a specification, model, design or instance. This is an arbitrary value managed by the
   * concept map author and is not expected to be globally unique. For example, it might be a
   * timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence.
   *
   * There may be different concept map instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the concept map with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the concept map. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the concept map.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this concept map. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of concept maps that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this concept map is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of concept maps that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the concept map was published. The date must change when
   * the business version changes and it must change if the status code changes. In addition, it
   * should change when the substantive content of the concept map changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the concept map. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the concept map.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the concept map
   * is the organization or individual primarily responsible for the maintenance and upkeep of the
   * concept map. This is not necessarily the same individual or organization that developed and
   * initially authored the content. The publisher is the primary point of contact for questions or
   * issues with the concept map. This item SHOULD be populated unless the information is available
   * from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the concept map from a consumer's perspective.
   *
   * The description is not intended to describe the semantics of the concept map. The description
   * should capture its intended use, which is needed for ensuring integrity for its use in models
   * across future changes.
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate concept map instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the concept map is intended to be used.
   *
   * It may be possible for the concept map to be used in jurisdictions other than those for which
   * it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this concept map is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the concept map. Instead, it provides traceability
   * of ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used to
   * point to source materials or specifications that drove the structure of this concept map.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the concept map and/or its contents. Copyright statements are
   * generally legal restrictions on the use and publishing of the concept map.
   *
   * Frequently the copyright differs between the concept map and codes that are included. The
   * copyright statement should clearly differentiate between these when required.
   */
  public val copyright: Markdown? = null,
  /**
   * Identifier for the source value set that contains the concepts that are being mapped and
   * provides context for the mappings.
   *
   * Should be a version specific reference. URIs SHOULD be absolute. If there is no source or
   * target value set, there is no specified context for the map (not recommended). The source value
   * set may select codes from either an explicit (standard or local) or implicit code system.
   */
  public val source: Source? = null,
  /**
   * The target value set provides context for the mappings. Note that the mapping is made between
   * concepts, not between value sets, but the value set provides important context about how the
   * concept mapping choices are made.
   *
   * Should be a version specific reference. URIs SHOULD be absolute. If there is no source or
   * target value set, the is no specified context for the map.
   */
  public val target: Target? = null,
  /** A group of mappings that all have the same source and target system. */
  public val group: List<Group> = listOf(),
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
        identifier = this@with.identifier?.toBuilder()
        version = this@with.version?.toBuilder()
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
        source = this@with.source
        target = this@with.target
        group = this@with.group.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A group of mappings that all have the same source and target system. */
  @Serializable(with = ConceptMapGroupSerializer::class)
  public data class Group(
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
     * An absolute URI that identifies the source system where the concepts to be mapped are
     * defined.
     *
     * This is not needed if the source value set is specified and it contains concepts from only a
     * single system.
     */
    public val source: Uri? = null,
    /**
     * The specific version of the code system, as determined by the code system authority.
     *
     * The specification of a particular code system version may be required for code systems which
     * lack concept permanence.
     */
    public val sourceVersion: String? = null,
    /**
     * An absolute URI that identifies the target system that the concepts will be mapped to.
     *
     * This is not needed if the target value set is specified and it contains concepts from only a
     * single system. The group target may also be omitted if all of the target element equivalence
     * values are 'unmatched'.
     */
    public val target: Uri? = null,
    /**
     * The specific version of the code system, as determined by the code system authority.
     *
     * The specification of a particular code system version may be required for code systems which
     * lack concept permanence.
     */
    public val targetVersion: String? = null,
    /**
     * Mappings for an individual concept in the source to one or more concepts in the target.
     *
     * Generally, the ideal is that there would only be one mapping for each concept in the source
     * value set, but a given concept may be mapped multiple times with different comments or
     * dependencies.
     */
    public val element: List<Element>,
    /**
     * What to do when there is no mapping for the source concept. "Unmapped" does not include codes
     * that are unmatched, and the unmapped element is ignored in a code is specified to have
     * equivalence = unmatched.
     *
     * This only applies if the source code has a system value that matches the system defined for
     * the group.
     */
    public val unmapped: Unmapped? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(element.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          source = this@with.source?.toBuilder()
          sourceVersion = this@with.sourceVersion?.toBuilder()
          target = this@with.target?.toBuilder()
          targetVersion = this@with.targetVersion?.toBuilder()
          unmapped = this@with.unmapped?.toBuilder()
        }
      }

    /** Mappings for an individual concept in the source to one or more concepts in the target. */
    @Serializable(with = ConceptMapGroupElementSerializer::class)
    public data class Element(
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
      /** Identity (code or path) or the element/item being mapped. */
      public val code: Code? = null,
      /**
       * The display for the code. The display is only provided to help editors when editing the
       * concept map.
       *
       * The display is ignored when processing the map.
       */
      public val display: String? = null,
      /**
       * A concept from the target value set that this concept maps to.
       *
       * Ideally there would only be one map, with equal or equivalent mapping. But multiple maps
       * are allowed for several narrower options, or to assert that other concepts are unmatched.
       */
      public val target: List<Target> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            code = this@with.code?.toBuilder()
            display = this@with.display?.toBuilder()
            target = this@with.target.map { it.toBuilder() }.toMutableList()
          }
        }

      /** A concept from the target value set that this concept maps to. */
      @Serializable(with = ConceptMapGroupElementTargetSerializer::class)
      public data class Target(
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
        /** Identity (code or path) or the element/item that the map refers to. */
        public val code: Code? = null,
        /**
         * The display for the code. The display is only provided to help editors when editing the
         * concept map.
         *
         * The display is ignored when processing the map.
         */
        public val display: String? = null,
        /**
         * The equivalence between the source and target concepts (counting for the dependencies and
         * products). The equivalence is read from target to source (e.g. the target is 'wider' than
         * the source).
         *
         * This element is labeled as a modifier because it may indicate that a target does not
         * apply.
         */
        public val equivalence: Enumeration<ConceptMapEquivalence>,
        /**
         * A description of status/issues in mapping that conveys additional information not
         * represented in the structured data.
         */
        public val comment: String? = null,
        /**
         * A set of additional dependencies for this mapping to hold. This mapping is only
         * applicable if the specified element can be resolved, and it has the specified value.
         */
        public val dependsOn: List<DependsOn> = listOf(),
        /**
         * A set of additional outcomes from this mapping to other elements. To properly execute
         * this mapping, the specified element must be mapped to some data element or source that is
         * in context. The mapping may still be useful without a place for the additional data
         * elements, but the equivalence cannot be relied on.
         */
        public val product: List<DependsOn> = listOf(),
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(equivalence).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              code = this@with.code?.toBuilder()
              display = this@with.display?.toBuilder()
              comment = this@with.comment?.toBuilder()
              dependsOn = this@with.dependsOn.map { it.toBuilder() }.toMutableList()
              product = this@with.product.map { it.toBuilder() }.toMutableList()
            }
          }

        /**
         * A set of additional dependencies for this mapping to hold. This mapping is only
         * applicable if the specified element can be resolved, and it has the specified value.
         */
        @Serializable(with = ConceptMapGroupElementTargetDependsOnSerializer::class)
        public data class DependsOn(
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          override val id: kotlin.String? = null,
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
          override val extension: List<Extension> = listOf(),
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
          override val modifierExtension: List<Extension> = listOf(),
          /**
           * A reference to an element that holds a coded value that corresponds to a code system
           * property. The idea is that the information model carries an element somewhere that is
           * labeled to correspond with a code system property.
           */
          public val `property`: Uri,
          /**
           * An absolute URI that identifies the code system of the dependency code (if the
           * source/dependency is a value set that crosses code systems).
           */
          public val system: Canonical? = null,
          /**
           * Identity (code or path) or the element/item/ValueSet/text that the map depends on /
           * refers to.
           */
          public val `value`: String,
          /**
           * The display for the code. The display is only provided to help editors when editing the
           * concept map.
           *
           * The display is ignored when processing the map.
           */
          public val display: String? = null,
        ) : BackboneElement() {
          public fun toBuilder(): Builder =
            with(this) {
              Builder(`property`.toBuilder(), `value`.toBuilder()).apply {
                id = this@with.id
                extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
                system = this@with.system?.toBuilder()
                display = this@with.display?.toBuilder()
              }
            }

          public class Builder(
            /**
             * A reference to an element that holds a coded value that corresponds to a code system
             * property. The idea is that the information model carries an element somewhere that is
             * labeled to correspond with a code system property.
             */
            public var `property`: Uri.Builder,
            /**
             * Identity (code or path) or the element/item/ValueSet/text that the map depends on /
             * refers to.
             */
            public var `value`: String.Builder,
          ) {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: kotlin.String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and manageable, there
             * is a strict set of governance applied to the definition and use of extensions. Though
             * any implementer can define an extension, there is a set of requirements that SHALL be
             * met as part of the definition of the extension.
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var extension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element and that modifies the understanding of the element in which
             * it is contained and/or the understanding of the containing element's descendants.
             * Usually modifier elements provide negation or qualification. To make the use of
             * extensions safe and manageable, there is a strict set of governance applied to the
             * definition and use of extensions. Though any implementer can define an extension,
             * there is a set of requirements that SHALL be met as part of the definition of the
             * extension. Applications processing a resource are required to check for modifier
             * extensions.
             *
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
             * DomainResource (including cannot change the meaning of modifierExtension itself).
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * An absolute URI that identifies the code system of the dependency code (if the
             * source/dependency is a value set that crosses code systems).
             */
            public var system: Canonical.Builder? = null

            /**
             * The display for the code. The display is only provided to help editors when editing
             * the concept map.
             *
             * The display is ignored when processing the map.
             */
            public var display: String.Builder? = null

            public fun build(): DependsOn =
              DependsOn(
                id = id,
                extension = extension.map { it.build() },
                modifierExtension = modifierExtension.map { it.build() },
                `property` = `property`.build(),
                system = system?.build(),
                `value` = `value`.build(),
                display = display?.build(),
              )
          }
        }

        public class Builder(
          /**
           * The equivalence between the source and target concepts (counting for the dependencies
           * and products). The equivalence is read from target to source (e.g. the target is
           * 'wider' than the source).
           *
           * This element is labeled as a modifier because it may indicate that a target does not
           * apply.
           */
          public var equivalence: Enumeration<ConceptMapEquivalence>
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

          /** Identity (code or path) or the element/item that the map refers to. */
          public var code: Code.Builder? = null

          /**
           * The display for the code. The display is only provided to help editors when editing the
           * concept map.
           *
           * The display is ignored when processing the map.
           */
          public var display: String.Builder? = null

          /**
           * A description of status/issues in mapping that conveys additional information not
           * represented in the structured data.
           */
          public var comment: String.Builder? = null

          /**
           * A set of additional dependencies for this mapping to hold. This mapping is only
           * applicable if the specified element can be resolved, and it has the specified value.
           */
          public var dependsOn: MutableList<DependsOn.Builder> = mutableListOf()

          /**
           * A set of additional outcomes from this mapping to other elements. To properly execute
           * this mapping, the specified element must be mapped to some data element or source that
           * is in context. The mapping may still be useful without a place for the additional data
           * elements, but the equivalence cannot be relied on.
           */
          public var product: MutableList<DependsOn.Builder> = mutableListOf()

          public fun build(): Target =
            Target(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              code = code?.build(),
              display = display?.build(),
              equivalence = equivalence,
              comment = comment?.build(),
              dependsOn = dependsOn.map { it.build() },
              product = product.map { it.build() },
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

        /** Identity (code or path) or the element/item being mapped. */
        public var code: Code.Builder? = null

        /**
         * The display for the code. The display is only provided to help editors when editing the
         * concept map.
         *
         * The display is ignored when processing the map.
         */
        public var display: String.Builder? = null

        /**
         * A concept from the target value set that this concept maps to.
         *
         * Ideally there would only be one map, with equal or equivalent mapping. But multiple maps
         * are allowed for several narrower options, or to assert that other concepts are unmatched.
         */
        public var target: MutableList<Target.Builder> = mutableListOf()

        public fun build(): Element =
          Element(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code?.build(),
            display = display?.build(),
            target = target.map { it.build() },
          )
      }
    }

    /**
     * What to do when there is no mapping for the source concept. "Unmapped" does not include codes
     * that are unmatched, and the unmapped element is ignored in a code is specified to have
     * equivalence = unmatched.
     */
    @Serializable(with = ConceptMapGroupUnmappedSerializer::class)
    public data class Unmapped(
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
       * Defines which action to take if there is no match for the source concept in the target
       * system designated for the group. One of 3 actions are possible: use the unmapped code (this
       * is useful when doing a mapping between versions, and only a few codes have changed), use a
       * fixed code (a default code), or alternatively, a reference to a different concept map can
       * be provided (by canonical URL).
       */
      public val mode: Enumeration<ConceptMapGroupUnmappedMode>,
      /**
       * The fixed code to use when the mode = 'fixed' - all unmapped codes are mapped to a single
       * fixed code.
       */
      public val code: Code? = null,
      /**
       * The display for the code. The display is only provided to help editors when editing the
       * concept map.
       *
       * The display is ignored when processing the map.
       */
      public val display: String? = null,
      /**
       * The canonical reference to an additional ConceptMap resource instance to use for mapping if
       * this ConceptMap resource contains no matching mapping for the source concept.
       */
      public val url: Canonical? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(mode).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            code = this@with.code?.toBuilder()
            display = this@with.display?.toBuilder()
            url = this@with.url?.toBuilder()
          }
        }

      public class Builder(
        /**
         * Defines which action to take if there is no match for the source concept in the target
         * system designated for the group. One of 3 actions are possible: use the unmapped code
         * (this is useful when doing a mapping between versions, and only a few codes have
         * changed), use a fixed code (a default code), or alternatively, a reference to a different
         * concept map can be provided (by canonical URL).
         */
        public var mode: Enumeration<ConceptMapGroupUnmappedMode>
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
         * The fixed code to use when the mode = 'fixed' - all unmapped codes are mapped to a single
         * fixed code.
         */
        public var code: Code.Builder? = null

        /**
         * The display for the code. The display is only provided to help editors when editing the
         * concept map.
         *
         * The display is ignored when processing the map.
         */
        public var display: String.Builder? = null

        /**
         * The canonical reference to an additional ConceptMap resource instance to use for mapping
         * if this ConceptMap resource contains no matching mapping for the source concept.
         */
        public var url: Canonical.Builder? = null

        public fun build(): Unmapped =
          Unmapped(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            mode = mode,
            code = code?.build(),
            display = display?.build(),
            url = url?.build(),
          )
      }
    }

    public class Builder(
      /**
       * Mappings for an individual concept in the source to one or more concepts in the target.
       *
       * Generally, the ideal is that there would only be one mapping for each concept in the source
       * value set, but a given concept may be mapped multiple times with different comments or
       * dependencies.
       */
      public var element: MutableList<Element.Builder>
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
       * An absolute URI that identifies the source system where the concepts to be mapped are
       * defined.
       *
       * This is not needed if the source value set is specified and it contains concepts from only
       * a single system.
       */
      public var source: Uri.Builder? = null

      /**
       * The specific version of the code system, as determined by the code system authority.
       *
       * The specification of a particular code system version may be required for code systems
       * which lack concept permanence.
       */
      public var sourceVersion: String.Builder? = null

      /**
       * An absolute URI that identifies the target system that the concepts will be mapped to.
       *
       * This is not needed if the target value set is specified and it contains concepts from only
       * a single system. The group target may also be omitted if all of the target element
       * equivalence values are 'unmatched'.
       */
      public var target: Uri.Builder? = null

      /**
       * The specific version of the code system, as determined by the code system authority.
       *
       * The specification of a particular code system version may be required for code systems
       * which lack concept permanence.
       */
      public var targetVersion: String.Builder? = null

      /**
       * What to do when there is no mapping for the source concept. "Unmapped" does not include
       * codes that are unmatched, and the unmapped element is ignored in a code is specified to
       * have equivalence = unmatched.
       *
       * This only applies if the source code has a system value that matches the system defined for
       * the group.
       */
      public var unmapped: Unmapped.Builder? = null

      public fun build(): Group =
        Group(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          source = source?.build(),
          sourceVersion = sourceVersion?.build(),
          target = target?.build(),
          targetVersion = targetVersion?.build(),
          element = element.map { it.build() },
          unmapped = unmapped?.build(),
        )
    }
  }

  public sealed interface Source {
    public fun asUri(): Uri? = this as? Uri

    public fun asCanonical(): Canonical? = this as? Canonical

    public data class Uri(public val `value`: dev.ohs.fhir.model.r4b.Uri) : Source

    public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Source

    public companion object {
      internal fun from(
        uriValue: dev.ohs.fhir.model.r4b.Uri?,
        canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
      ): Source? {
        if (uriValue != null) return Uri(uriValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        return null
      }
    }
  }

  public sealed interface Target {
    public fun asUri(): Uri? = this as? Uri

    public fun asCanonical(): Canonical? = this as? Canonical

    public data class Uri(public val `value`: dev.ohs.fhir.model.r4b.Uri) : Target

    public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Target

    public companion object {
      internal fun from(
        uriValue: dev.ohs.fhir.model.r4b.Uri?,
        canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
      ): Target? {
        if (uriValue != null) return Uri(uriValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of this concept map. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of concept maps that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>
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
     * An absolute URI that is used to identify this concept map when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this concept map is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the concept map is stored on different
     * servers.
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
     * A formal identifier that is used to identify this concept map when it is represented in other
     * formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this concept map outside of FHIR, where it is not possible
     * to use the logical URI.
     */
    public var identifier: Identifier.Builder? = null

    /**
     * The identifier that is used to identify this version of the concept map when it is referenced
     * in a specification, model, design or instance. This is an arbitrary value managed by the
     * concept map author and is not expected to be globally unique. For example, it might be a
     * timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
     * that versions can be placed in a lexicographical sequence.
     *
     * There may be different concept map instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the concept map with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the concept map. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the concept map.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this concept map is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of concept maps that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the concept map was published. The date must change when
     * the business version changes and it must change if the status code changes. In addition, it
     * should change when the substantive content of the concept map changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the concept map. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the concept map.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the concept
     * map is the organization or individual primarily responsible for the maintenance and upkeep of
     * the concept map. This is not necessarily the same individual or organization that developed
     * and initially authored the content. The publisher is the primary point of contact for
     * questions or issues with the concept map. This item SHOULD be populated unless the
     * information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the concept map from a consumer's perspective.
     *
     * The description is not intended to describe the semantics of the concept map. The description
     * should capture its intended use, which is needed for ensuring integrity for its use in models
     * across future changes.
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate concept map instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the concept map is intended to be used.
     *
     * It may be possible for the concept map to be used in jurisdictions other than those for which
     * it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this concept map is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the concept map. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * concept map.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the concept map and/or its contents. Copyright statements
     * are generally legal restrictions on the use and publishing of the concept map.
     *
     * Frequently the copyright differs between the concept map and codes that are included. The
     * copyright statement should clearly differentiate between these when required.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * Identifier for the source value set that contains the concepts that are being mapped and
     * provides context for the mappings.
     *
     * Should be a version specific reference. URIs SHOULD be absolute. If there is no source or
     * target value set, there is no specified context for the map (not recommended). The source
     * value set may select codes from either an explicit (standard or local) or implicit code
     * system.
     */
    public var source: Source? = null

    /**
     * The target value set provides context for the mappings. Note that the mapping is made between
     * concepts, not between value sets, but the value set provides important context about how the
     * concept mapping choices are made.
     *
     * Should be a version specific reference. URIs SHOULD be absolute. If there is no source or
     * target value set, the is no specified context for the map.
     */
    public var target: Target? = null

    /** A group of mappings that all have the same source and target system. */
    public var group: MutableList<Group.Builder> = mutableListOf()

    override fun build(): ConceptMap =
      ConceptMap(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url?.build(),
        identifier = identifier?.build(),
        version = version?.build(),
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
        source = source,
        target = target,
        group = group.map { it.build() },
      )
  }

  /** Defines which action to take if there is no match in the group. */
  public enum class ConceptMapGroupUnmappedMode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Provided("provided", "http://hl7.org/fhir/conceptmap-unmapped-mode", "Provided Code"),
    Fixed("fixed", "http://hl7.org/fhir/conceptmap-unmapped-mode", "Fixed Code"),
    Other_Map("other-map", "http://hl7.org/fhir/conceptmap-unmapped-mode", "Other Map");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ConceptMapGroupUnmappedMode =
        when (code) {
          "provided" -> Provided
          "fixed" -> Fixed
          "other-map" -> Other_Map
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum ConceptMapGroupUnmappedMode"
            )
        }
    }
  }
}
