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

import dev.ohs.fhir.model.r4.serializers.ExampleScenarioActorSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioInstanceContainedInstanceSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioInstanceSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioInstanceVersionSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioProcessSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioProcessStepAlternativeSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioProcessStepOperationSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioProcessStepSerializer
import dev.ohs.fhir.model.r4.serializers.ExampleScenarioSerializer
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Example of workflow instance. */
@Serializable(with = ExampleScenarioSerializer::class)
@SerialName("ExampleScenario")
public data class ExampleScenario(
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
   * An absolute URI that is used to identify this example scenario when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this example scenario is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the example scenario is stored on different servers.
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
   * A formal identifier that is used to identify this example scenario when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this example scenario outside of FHIR, where it is not possible to
   * use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the example scenario when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the example scenario author and is not expected to be globally unique. For example, it might be
   * a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence.
   *
   * There may be different example scenario instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the example scenario with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the example scenario. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * The status of this example scenario. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of example scenarios that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this example scenario is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of example scenarios that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the example scenario was published. The date must change
   * when the business version changes and it must change if the status code changes. In addition,
   * it should change when the substantive content of the example scenario changes. (e.g. the
   * 'content logical definition').
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the example scenario. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the example scenario.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the example
   * scenario is the organization or individual primarily responsible for the maintenance and upkeep
   * of the example scenario. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the example scenario. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate example scenario instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the example scenario is intended to be used.
   *
   * It may be possible for the example scenario to be used in jurisdictions other than those for
   * which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * A copyright statement relating to the example scenario and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the example scenario.
   *
   * nullFrequently, the copyright differs between the value set and the codes that are included.
   * The copyright statement should clearly differentiate between these when required.
   */
  public val copyright: Markdown? = null,
  /**
   * What the example scenario resource is created for. This should not be used to show the business
   * purpose of the scenario itself, but the purpose of documenting a scenario.
   *
   * This element does not describe the usage of the example scenario. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * example scenario.
   */
  public val purpose: Markdown? = null,
  /** Actor participating in the resource. */
  public val actor: List<Actor> = listOf(),
  /** Each resource and each version that is present in the workflow. */
  public val instance: List<Instance> = listOf(),
  /** Each major process - a group of operations. */
  public val process: List<Process> = listOf(),
  /** Another nested workflow. */
  public val workflow: List<Canonical> = listOf(),
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
        name = this@with.name?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        copyright = this@with.copyright?.toBuilder()
        purpose = this@with.purpose?.toBuilder()
        actor = this@with.actor.map { it.toBuilder() }.toMutableList()
        instance = this@with.instance.map { it.toBuilder() }.toMutableList()
        process = this@with.process.map { it.toBuilder() }.toMutableList()
        workflow = this@with.workflow.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Actor participating in the resource. */
  @Serializable(with = ExampleScenarioActorSerializer::class)
  public data class Actor(
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
     * ID or acronym of actor.
     *
     * should this be called ID or acronym?
     */
    public val actorId: String,
    /** The type of actor - person or system. */
    public val type: Enumeration<ExampleScenarioActorType>,
    /**
     * The name of the actor as shown in the page.
     *
     * Cardinality: is name and description 1..1?
     */
    public val name: String? = null,
    /**
     * The description of the actor.
     *
     * Cardinality: is name and description 1..1?
     */
    public val description: Markdown? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            actorId.toBuilder(),
            type,
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            name = this@with.name?.toBuilder()
            description = this@with.description?.toBuilder()
          }
      }

    public class Builder(
      /**
       * ID or acronym of actor.
       *
       * should this be called ID or acronym?
       */
      public var actorId: String.Builder,
      /** The type of actor - person or system. */
      public var type: Enumeration<ExampleScenarioActorType>,
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
       * The name of the actor as shown in the page.
       *
       * Cardinality: is name and description 1..1?
       */
      public var name: String.Builder? = null

      /**
       * The description of the actor.
       *
       * Cardinality: is name and description 1..1?
       */
      public var description: Markdown.Builder? = null

      public fun build(): Actor =
        Actor(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          actorId = actorId.build(),
          type = type,
          name = name?.build(),
          description = description?.build(),
        )
    }
  }

  /** Each resource and each version that is present in the workflow. */
  @Serializable(with = ExampleScenarioInstanceSerializer::class)
  public data class Instance(
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
    /** The id of the resource for referencing. */
    public val resourceId: String,
    /** The type of the resource. */
    public val resourceType: Enumeration<ResourceType>,
    /** A short name for the resource instance. */
    public val name: String? = null,
    /** Human-friendly description of the resource instance. */
    public val description: Markdown? = null,
    /** A specific version of the resource. */
    public val version: List<Version> = listOf(),
    /** Resources contained in the instance (e.g. the observations contained in a bundle). */
    public val containedInstance: List<ContainedInstance> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            resourceId.toBuilder(),
            resourceType,
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            name = this@with.name?.toBuilder()
            description = this@with.description?.toBuilder()
            version = this@with.version.map { it.toBuilder() }.toMutableList()
            containedInstance = this@with.containedInstance.map { it.toBuilder() }.toMutableList()
          }
      }

    /** A specific version of the resource. */
    @Serializable(with = ExampleScenarioInstanceVersionSerializer::class)
    public data class Version(
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
      /** The identifier of a specific version of a resource. */
      public val versionId: String,
      /** The description of the resource version. */
      public val description: Markdown,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(versionId.toBuilder(), description.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** The identifier of a specific version of a resource. */
        public var versionId: String.Builder,
        /** The description of the resource version. */
        public var description: Markdown.Builder,
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

        public fun build(): Version =
          Version(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            versionId = versionId.build(),
            description = description.build(),
          )
      }
    }

    /** Resources contained in the instance (e.g. the observations contained in a bundle). */
    @Serializable(with = ExampleScenarioInstanceContainedInstanceSerializer::class)
    public data class ContainedInstance(
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
      /** Each resource contained in the instance. */
      public val resourceId: String,
      /** A specific version of a resource contained in the instance. */
      public val versionId: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(resourceId.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            versionId = this@with.versionId?.toBuilder()
          }
        }

      public class Builder(
        /** Each resource contained in the instance. */
        public var resourceId: String.Builder
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

        /** A specific version of a resource contained in the instance. */
        public var versionId: String.Builder? = null

        public fun build(): ContainedInstance =
          ContainedInstance(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            resourceId = resourceId.build(),
            versionId = versionId?.build(),
          )
      }
    }

    public class Builder(
      /** The id of the resource for referencing. */
      public var resourceId: String.Builder,
      /** The type of the resource. */
      public var resourceType: Enumeration<ResourceType>,
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

      /** A short name for the resource instance. */
      public var name: String.Builder? = null

      /** Human-friendly description of the resource instance. */
      public var description: Markdown.Builder? = null

      /** A specific version of the resource. */
      public var version: MutableList<Version.Builder> = mutableListOf()

      /** Resources contained in the instance (e.g. the observations contained in a bundle). */
      public var containedInstance: MutableList<ContainedInstance.Builder> = mutableListOf()

      public fun build(): Instance =
        Instance(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          resourceId = resourceId.build(),
          resourceType = resourceType,
          name = name?.build(),
          description = description?.build(),
          version = version.map { it.build() },
          containedInstance = containedInstance.map { it.build() },
        )
    }
  }

  /** Each major process - a group of operations. */
  @Serializable(with = ExampleScenarioProcessSerializer::class)
  public data class Process(
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
    /** The diagram title of the group of operations. */
    public val title: String,
    /** A longer description of the group of operations. */
    public val description: Markdown? = null,
    /** Description of initial status before the process starts. */
    public val preConditions: Markdown? = null,
    /** Description of final status after the process ends. */
    public val postConditions: Markdown? = null,
    /** Each step of the process. */
    public val step: List<Step> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(title.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          preConditions = this@with.preConditions?.toBuilder()
          postConditions = this@with.postConditions?.toBuilder()
          step = this@with.step.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Each step of the process. */
    @Serializable(with = ExampleScenarioProcessStepSerializer::class)
    public data class Step(
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
      /** Nested process. */
      public val process: List<Process> = listOf(),
      /** If there is a pause in the flow. */
      public val pause: Boolean? = null,
      /** Each interaction or action. */
      public val operation: Operation? = null,
      /**
       * Indicates an alternative step that can be taken instead of the operations on the base step
       * in exceptional/atypical circumstances.
       */
      public val alternative: List<Alternative> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            process = this@with.process.map { it.toBuilder() }.toMutableList()
            pause = this@with.pause?.toBuilder()
            operation = this@with.operation?.toBuilder()
            alternative = this@with.alternative.map { it.toBuilder() }.toMutableList()
          }
        }

      /** Each interaction or action. */
      @Serializable(with = ExampleScenarioProcessStepOperationSerializer::class)
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
        /** The sequential number of the interaction, e.g. 1.2.5. */
        public val number: String,
        /** The type of operation - CRUD. */
        public val type: String? = null,
        /** The human-friendly name of the interaction. */
        public val name: String? = null,
        /** Who starts the transaction. */
        public val initiator: String? = null,
        /** Who receives the transaction. */
        public val `receiver`: String? = null,
        /** A comment to be inserted in the diagram. */
        public val description: Markdown? = null,
        /** Whether the initiator is deactivated right after the transaction. */
        public val initiatorActive: Boolean? = null,
        /** Whether the receiver is deactivated right after the transaction. */
        public val receiverActive: Boolean? = null,
        /** Each resource instance used by the initiator. */
        public val request: Instance.ContainedInstance? = null,
        /** Each resource instance used by the responder. */
        public val response: Instance.ContainedInstance? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(number.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              type = this@with.type?.toBuilder()
              name = this@with.name?.toBuilder()
              initiator = this@with.initiator?.toBuilder()
              `receiver` = this@with.`receiver`?.toBuilder()
              description = this@with.description?.toBuilder()
              initiatorActive = this@with.initiatorActive?.toBuilder()
              receiverActive = this@with.receiverActive?.toBuilder()
              request = this@with.request?.toBuilder()
              response = this@with.response?.toBuilder()
            }
          }

        public class Builder(
          /** The sequential number of the interaction, e.g. 1.2.5. */
          public var number: String.Builder
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

          /** The type of operation - CRUD. */
          public var type: String.Builder? = null

          /** The human-friendly name of the interaction. */
          public var name: String.Builder? = null

          /** Who starts the transaction. */
          public var initiator: String.Builder? = null

          /** Who receives the transaction. */
          public var `receiver`: String.Builder? = null

          /** A comment to be inserted in the diagram. */
          public var description: Markdown.Builder? = null

          /** Whether the initiator is deactivated right after the transaction. */
          public var initiatorActive: Boolean.Builder? = null

          /** Whether the receiver is deactivated right after the transaction. */
          public var receiverActive: Boolean.Builder? = null

          /** Each resource instance used by the initiator. */
          public var request: Instance.ContainedInstance.Builder? = null

          /** Each resource instance used by the responder. */
          public var response: Instance.ContainedInstance.Builder? = null

          public fun build(): Operation =
            Operation(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              number = number.build(),
              type = type?.build(),
              name = name?.build(),
              initiator = initiator?.build(),
              `receiver` = `receiver`?.build(),
              description = description?.build(),
              initiatorActive = initiatorActive?.build(),
              receiverActive = receiverActive?.build(),
              request = request?.build(),
              response = response?.build(),
            )
        }
      }

      /**
       * Indicates an alternative step that can be taken instead of the operations on the base step
       * in exceptional/atypical circumstances.
       */
      @Serializable(with = ExampleScenarioProcessStepAlternativeSerializer::class)
      public data class Alternative(
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
         * The label to display for the alternative that gives a sense of the circumstance in which
         * the alternative should be invoked.
         */
        public val title: String,
        /**
         * A human-readable description of the alternative explaining when the alternative should
         * occur rather than the base step.
         */
        public val description: Markdown? = null,
        /** What happens in each alternative option. */
        public val step: List<Step> = listOf(),
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(title.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              description = this@with.description?.toBuilder()
              step = this@with.step.map { it.toBuilder() }.toMutableList()
            }
          }

        public class Builder(
          /**
           * The label to display for the alternative that gives a sense of the circumstance in
           * which the alternative should be invoked.
           */
          public var title: String.Builder
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
           * A human-readable description of the alternative explaining when the alternative should
           * occur rather than the base step.
           */
          public var description: Markdown.Builder? = null

          /** What happens in each alternative option. */
          public var step: MutableList<Step.Builder> = mutableListOf()

          public fun build(): Alternative =
            Alternative(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              title = title.build(),
              description = description?.build(),
              step = step.map { it.build() },
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

        /** Nested process. */
        public var process: MutableList<Process.Builder> = mutableListOf()

        /** If there is a pause in the flow. */
        public var pause: Boolean.Builder? = null

        /** Each interaction or action. */
        public var operation: Operation.Builder? = null

        /**
         * Indicates an alternative step that can be taken instead of the operations on the base
         * step in exceptional/atypical circumstances.
         */
        public var alternative: MutableList<Alternative.Builder> = mutableListOf()

        public fun build(): Step =
          Step(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            process = process.map { it.build() },
            pause = pause?.build(),
            operation = operation?.build(),
            alternative = alternative.map { it.build() },
          )
      }
    }

    public class Builder(
      /** The diagram title of the group of operations. */
      public var title: String.Builder
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

      /** A longer description of the group of operations. */
      public var description: Markdown.Builder? = null

      /** Description of initial status before the process starts. */
      public var preConditions: Markdown.Builder? = null

      /** Description of final status after the process ends. */
      public var postConditions: Markdown.Builder? = null

      /** Each step of the process. */
      public var step: MutableList<Step.Builder> = mutableListOf()

      public fun build(): Process =
        Process(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          title = title.build(),
          description = description?.build(),
          preConditions = preConditions?.build(),
          postConditions = postConditions?.build(),
          step = step.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of this example scenario. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of example scenarios that are appropriate for use versus not.
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
     * An absolute URI that is used to identify this example scenario when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this example scenario is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the example scenario is stored on
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
     * A formal identifier that is used to identify this example scenario when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this example scenario outside of FHIR, where it is not
     * possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the example scenario when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the example scenario author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different example scenario instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the example scenario with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the example scenario. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A Boolean value to indicate that this example scenario is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of example scenarios that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the example scenario was published. The date must change
     * when the business version changes and it must change if the status code changes. In addition,
     * it should change when the substantive content of the example scenario changes. (e.g. the
     * 'content logical definition').
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the example scenario. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the example scenario.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the example
     * scenario is the organization or individual primarily responsible for the maintenance and
     * upkeep of the example scenario. This is not necessarily the same individual or organization
     * that developed and initially authored the content. The publisher is the primary point of
     * contact for questions or issues with the example scenario. This item SHOULD be populated
     * unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate example scenario instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the example scenario is intended to be used.
     *
     * It may be possible for the example scenario to be used in jurisdictions other than those for
     * which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A copyright statement relating to the example scenario and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the example
     * scenario.
     *
     * nullFrequently, the copyright differs between the value set and the codes that are included.
     * The copyright statement should clearly differentiate between these when required.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * What the example scenario resource is created for. This should not be used to show the
     * business purpose of the scenario itself, but the purpose of documenting a scenario.
     *
     * This element does not describe the usage of the example scenario. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * example scenario.
     */
    public var purpose: Markdown.Builder? = null

    /** Actor participating in the resource. */
    public var actor: MutableList<Actor.Builder> = mutableListOf()

    /** Each resource and each version that is present in the workflow. */
    public var instance: MutableList<Instance.Builder> = mutableListOf()

    /** Each major process - a group of operations. */
    public var process: MutableList<Process.Builder> = mutableListOf()

    /** Another nested workflow. */
    public var workflow: MutableList<Canonical.Builder> = mutableListOf()

    override fun build(): ExampleScenario =
      ExampleScenario(
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
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        copyright = copyright?.build(),
        purpose = purpose?.build(),
        actor = actor.map { it.build() },
        instance = instance.map { it.build() },
        process = process.map { it.build() },
        workflow = workflow.map { it.build() },
      )
  }

  /** The type of actor - system or human. */
  public enum class ExampleScenarioActorType(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Person("person", "http://hl7.org/fhir/examplescenario-actor-type", "Person"),
    Entity("entity", "http://hl7.org/fhir/examplescenario-actor-type", "System");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ExampleScenarioActorType =
        when (code) {
          "person" -> Person
          "entity" -> Entity
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ExampleScenarioActorType")
        }
    }
  }

  /** One of the resource types defined as part of this version of FHIR. */
  public enum class ResourceType(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Account("Account", "http://hl7.org/fhir/resource-types", "Account"),
    ActivityDefinition(
      "ActivityDefinition",
      "http://hl7.org/fhir/resource-types",
      "ActivityDefinition",
    ),
    AdverseEvent("AdverseEvent", "http://hl7.org/fhir/resource-types", "AdverseEvent"),
    AllergyIntolerance(
      "AllergyIntolerance",
      "http://hl7.org/fhir/resource-types",
      "AllergyIntolerance",
    ),
    Appointment("Appointment", "http://hl7.org/fhir/resource-types", "Appointment"),
    AppointmentResponse(
      "AppointmentResponse",
      "http://hl7.org/fhir/resource-types",
      "AppointmentResponse",
    ),
    AuditEvent("AuditEvent", "http://hl7.org/fhir/resource-types", "AuditEvent"),
    Basic("Basic", "http://hl7.org/fhir/resource-types", "Basic"),
    Binary("Binary", "http://hl7.org/fhir/resource-types", "Binary"),
    BiologicallyDerivedProduct(
      "BiologicallyDerivedProduct",
      "http://hl7.org/fhir/resource-types",
      "BiologicallyDerivedProduct",
    ),
    BodyStructure("BodyStructure", "http://hl7.org/fhir/resource-types", "BodyStructure"),
    Bundle("Bundle", "http://hl7.org/fhir/resource-types", "Bundle"),
    CapabilityStatement(
      "CapabilityStatement",
      "http://hl7.org/fhir/resource-types",
      "CapabilityStatement",
    ),
    CarePlan("CarePlan", "http://hl7.org/fhir/resource-types", "CarePlan"),
    CareTeam("CareTeam", "http://hl7.org/fhir/resource-types", "CareTeam"),
    CatalogEntry("CatalogEntry", "http://hl7.org/fhir/resource-types", "CatalogEntry"),
    ChargeItem("ChargeItem", "http://hl7.org/fhir/resource-types", "ChargeItem"),
    ChargeItemDefinition(
      "ChargeItemDefinition",
      "http://hl7.org/fhir/resource-types",
      "ChargeItemDefinition",
    ),
    Claim("Claim", "http://hl7.org/fhir/resource-types", "Claim"),
    ClaimResponse("ClaimResponse", "http://hl7.org/fhir/resource-types", "ClaimResponse"),
    ClinicalImpression(
      "ClinicalImpression",
      "http://hl7.org/fhir/resource-types",
      "ClinicalImpression",
    ),
    CodeSystem("CodeSystem", "http://hl7.org/fhir/resource-types", "CodeSystem"),
    Communication("Communication", "http://hl7.org/fhir/resource-types", "Communication"),
    CommunicationRequest(
      "CommunicationRequest",
      "http://hl7.org/fhir/resource-types",
      "CommunicationRequest",
    ),
    CompartmentDefinition(
      "CompartmentDefinition",
      "http://hl7.org/fhir/resource-types",
      "CompartmentDefinition",
    ),
    Composition("Composition", "http://hl7.org/fhir/resource-types", "Composition"),
    ConceptMap("ConceptMap", "http://hl7.org/fhir/resource-types", "ConceptMap"),
    Condition("Condition", "http://hl7.org/fhir/resource-types", "Condition"),
    Consent("Consent", "http://hl7.org/fhir/resource-types", "Consent"),
    Contract("Contract", "http://hl7.org/fhir/resource-types", "Contract"),
    Coverage("Coverage", "http://hl7.org/fhir/resource-types", "Coverage"),
    CoverageEligibilityRequest(
      "CoverageEligibilityRequest",
      "http://hl7.org/fhir/resource-types",
      "CoverageEligibilityRequest",
    ),
    CoverageEligibilityResponse(
      "CoverageEligibilityResponse",
      "http://hl7.org/fhir/resource-types",
      "CoverageEligibilityResponse",
    ),
    DetectedIssue("DetectedIssue", "http://hl7.org/fhir/resource-types", "DetectedIssue"),
    Device("Device", "http://hl7.org/fhir/resource-types", "Device"),
    DeviceDefinition("DeviceDefinition", "http://hl7.org/fhir/resource-types", "DeviceDefinition"),
    DeviceMetric("DeviceMetric", "http://hl7.org/fhir/resource-types", "DeviceMetric"),
    DeviceRequest("DeviceRequest", "http://hl7.org/fhir/resource-types", "DeviceRequest"),
    DeviceUseStatement(
      "DeviceUseStatement",
      "http://hl7.org/fhir/resource-types",
      "DeviceUseStatement",
    ),
    DiagnosticReport("DiagnosticReport", "http://hl7.org/fhir/resource-types", "DiagnosticReport"),
    DocumentManifest("DocumentManifest", "http://hl7.org/fhir/resource-types", "DocumentManifest"),
    DocumentReference(
      "DocumentReference",
      "http://hl7.org/fhir/resource-types",
      "DocumentReference",
    ),
    DomainResource("DomainResource", "http://hl7.org/fhir/resource-types", "DomainResource"),
    EffectEvidenceSynthesis(
      "EffectEvidenceSynthesis",
      "http://hl7.org/fhir/resource-types",
      "EffectEvidenceSynthesis",
    ),
    Encounter("Encounter", "http://hl7.org/fhir/resource-types", "Encounter"),
    Endpoint("Endpoint", "http://hl7.org/fhir/resource-types", "Endpoint"),
    EnrollmentRequest(
      "EnrollmentRequest",
      "http://hl7.org/fhir/resource-types",
      "EnrollmentRequest",
    ),
    EnrollmentResponse(
      "EnrollmentResponse",
      "http://hl7.org/fhir/resource-types",
      "EnrollmentResponse",
    ),
    EpisodeOfCare("EpisodeOfCare", "http://hl7.org/fhir/resource-types", "EpisodeOfCare"),
    EventDefinition("EventDefinition", "http://hl7.org/fhir/resource-types", "EventDefinition"),
    Evidence("Evidence", "http://hl7.org/fhir/resource-types", "Evidence"),
    EvidenceVariable("EvidenceVariable", "http://hl7.org/fhir/resource-types", "EvidenceVariable"),
    ExampleScenario("ExampleScenario", "http://hl7.org/fhir/resource-types", "ExampleScenario"),
    ExplanationOfBenefit(
      "ExplanationOfBenefit",
      "http://hl7.org/fhir/resource-types",
      "ExplanationOfBenefit",
    ),
    FamilyMemberHistory(
      "FamilyMemberHistory",
      "http://hl7.org/fhir/resource-types",
      "FamilyMemberHistory",
    ),
    Flag("Flag", "http://hl7.org/fhir/resource-types", "Flag"),
    Goal("Goal", "http://hl7.org/fhir/resource-types", "Goal"),
    GraphDefinition("GraphDefinition", "http://hl7.org/fhir/resource-types", "GraphDefinition"),
    Group("Group", "http://hl7.org/fhir/resource-types", "Group"),
    GuidanceResponse("GuidanceResponse", "http://hl7.org/fhir/resource-types", "GuidanceResponse"),
    HealthcareService(
      "HealthcareService",
      "http://hl7.org/fhir/resource-types",
      "HealthcareService",
    ),
    ImagingStudy("ImagingStudy", "http://hl7.org/fhir/resource-types", "ImagingStudy"),
    Immunization("Immunization", "http://hl7.org/fhir/resource-types", "Immunization"),
    ImmunizationEvaluation(
      "ImmunizationEvaluation",
      "http://hl7.org/fhir/resource-types",
      "ImmunizationEvaluation",
    ),
    ImmunizationRecommendation(
      "ImmunizationRecommendation",
      "http://hl7.org/fhir/resource-types",
      "ImmunizationRecommendation",
    ),
    ImplementationGuide(
      "ImplementationGuide",
      "http://hl7.org/fhir/resource-types",
      "ImplementationGuide",
    ),
    InsurancePlan("InsurancePlan", "http://hl7.org/fhir/resource-types", "InsurancePlan"),
    Invoice("Invoice", "http://hl7.org/fhir/resource-types", "Invoice"),
    Library("Library", "http://hl7.org/fhir/resource-types", "Library"),
    Linkage("Linkage", "http://hl7.org/fhir/resource-types", "Linkage"),
    List("List", "http://hl7.org/fhir/resource-types", "List"),
    Location("Location", "http://hl7.org/fhir/resource-types", "Location"),
    Measure("Measure", "http://hl7.org/fhir/resource-types", "Measure"),
    MeasureReport("MeasureReport", "http://hl7.org/fhir/resource-types", "MeasureReport"),
    Media("Media", "http://hl7.org/fhir/resource-types", "Media"),
    Medication("Medication", "http://hl7.org/fhir/resource-types", "Medication"),
    MedicationAdministration(
      "MedicationAdministration",
      "http://hl7.org/fhir/resource-types",
      "MedicationAdministration",
    ),
    MedicationDispense(
      "MedicationDispense",
      "http://hl7.org/fhir/resource-types",
      "MedicationDispense",
    ),
    MedicationKnowledge(
      "MedicationKnowledge",
      "http://hl7.org/fhir/resource-types",
      "MedicationKnowledge",
    ),
    MedicationRequest(
      "MedicationRequest",
      "http://hl7.org/fhir/resource-types",
      "MedicationRequest",
    ),
    MedicationStatement(
      "MedicationStatement",
      "http://hl7.org/fhir/resource-types",
      "MedicationStatement",
    ),
    MedicinalProduct("MedicinalProduct", "http://hl7.org/fhir/resource-types", "MedicinalProduct"),
    MedicinalProductAuthorization(
      "MedicinalProductAuthorization",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductAuthorization",
    ),
    MedicinalProductContraindication(
      "MedicinalProductContraindication",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductContraindication",
    ),
    MedicinalProductIndication(
      "MedicinalProductIndication",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductIndication",
    ),
    MedicinalProductIngredient(
      "MedicinalProductIngredient",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductIngredient",
    ),
    MedicinalProductInteraction(
      "MedicinalProductInteraction",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductInteraction",
    ),
    MedicinalProductManufactured(
      "MedicinalProductManufactured",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductManufactured",
    ),
    MedicinalProductPackaged(
      "MedicinalProductPackaged",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductPackaged",
    ),
    MedicinalProductPharmaceutical(
      "MedicinalProductPharmaceutical",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductPharmaceutical",
    ),
    MedicinalProductUndesirableEffect(
      "MedicinalProductUndesirableEffect",
      "http://hl7.org/fhir/resource-types",
      "MedicinalProductUndesirableEffect",
    ),
    MessageDefinition(
      "MessageDefinition",
      "http://hl7.org/fhir/resource-types",
      "MessageDefinition",
    ),
    MessageHeader("MessageHeader", "http://hl7.org/fhir/resource-types", "MessageHeader"),
    MolecularSequence(
      "MolecularSequence",
      "http://hl7.org/fhir/resource-types",
      "MolecularSequence",
    ),
    NamingSystem("NamingSystem", "http://hl7.org/fhir/resource-types", "NamingSystem"),
    NutritionOrder("NutritionOrder", "http://hl7.org/fhir/resource-types", "NutritionOrder"),
    Observation("Observation", "http://hl7.org/fhir/resource-types", "Observation"),
    ObservationDefinition(
      "ObservationDefinition",
      "http://hl7.org/fhir/resource-types",
      "ObservationDefinition",
    ),
    OperationDefinition(
      "OperationDefinition",
      "http://hl7.org/fhir/resource-types",
      "OperationDefinition",
    ),
    OperationOutcome("OperationOutcome", "http://hl7.org/fhir/resource-types", "OperationOutcome"),
    Organization("Organization", "http://hl7.org/fhir/resource-types", "Organization"),
    OrganizationAffiliation(
      "OrganizationAffiliation",
      "http://hl7.org/fhir/resource-types",
      "OrganizationAffiliation",
    ),
    Parameters("Parameters", "http://hl7.org/fhir/resource-types", "Parameters"),
    Patient("Patient", "http://hl7.org/fhir/resource-types", "Patient"),
    PaymentNotice("PaymentNotice", "http://hl7.org/fhir/resource-types", "PaymentNotice"),
    PaymentReconciliation(
      "PaymentReconciliation",
      "http://hl7.org/fhir/resource-types",
      "PaymentReconciliation",
    ),
    Person("Person", "http://hl7.org/fhir/resource-types", "Person"),
    PlanDefinition("PlanDefinition", "http://hl7.org/fhir/resource-types", "PlanDefinition"),
    Practitioner("Practitioner", "http://hl7.org/fhir/resource-types", "Practitioner"),
    PractitionerRole("PractitionerRole", "http://hl7.org/fhir/resource-types", "PractitionerRole"),
    Procedure("Procedure", "http://hl7.org/fhir/resource-types", "Procedure"),
    Provenance("Provenance", "http://hl7.org/fhir/resource-types", "Provenance"),
    Questionnaire("Questionnaire", "http://hl7.org/fhir/resource-types", "Questionnaire"),
    QuestionnaireResponse(
      "QuestionnaireResponse",
      "http://hl7.org/fhir/resource-types",
      "QuestionnaireResponse",
    ),
    RelatedPerson("RelatedPerson", "http://hl7.org/fhir/resource-types", "RelatedPerson"),
    RequestGroup("RequestGroup", "http://hl7.org/fhir/resource-types", "RequestGroup"),
    ResearchDefinition(
      "ResearchDefinition",
      "http://hl7.org/fhir/resource-types",
      "ResearchDefinition",
    ),
    ResearchElementDefinition(
      "ResearchElementDefinition",
      "http://hl7.org/fhir/resource-types",
      "ResearchElementDefinition",
    ),
    ResearchStudy("ResearchStudy", "http://hl7.org/fhir/resource-types", "ResearchStudy"),
    ResearchSubject("ResearchSubject", "http://hl7.org/fhir/resource-types", "ResearchSubject"),
    Resource("Resource", "http://hl7.org/fhir/resource-types", "Resource"),
    RiskAssessment("RiskAssessment", "http://hl7.org/fhir/resource-types", "RiskAssessment"),
    RiskEvidenceSynthesis(
      "RiskEvidenceSynthesis",
      "http://hl7.org/fhir/resource-types",
      "RiskEvidenceSynthesis",
    ),
    Schedule("Schedule", "http://hl7.org/fhir/resource-types", "Schedule"),
    SearchParameter("SearchParameter", "http://hl7.org/fhir/resource-types", "SearchParameter"),
    ServiceRequest("ServiceRequest", "http://hl7.org/fhir/resource-types", "ServiceRequest"),
    Slot("Slot", "http://hl7.org/fhir/resource-types", "Slot"),
    Specimen("Specimen", "http://hl7.org/fhir/resource-types", "Specimen"),
    SpecimenDefinition(
      "SpecimenDefinition",
      "http://hl7.org/fhir/resource-types",
      "SpecimenDefinition",
    ),
    StructureDefinition(
      "StructureDefinition",
      "http://hl7.org/fhir/resource-types",
      "StructureDefinition",
    ),
    StructureMap("StructureMap", "http://hl7.org/fhir/resource-types", "StructureMap"),
    Subscription("Subscription", "http://hl7.org/fhir/resource-types", "Subscription"),
    Substance("Substance", "http://hl7.org/fhir/resource-types", "Substance"),
    SubstanceNucleicAcid(
      "SubstanceNucleicAcid",
      "http://hl7.org/fhir/resource-types",
      "SubstanceNucleicAcid",
    ),
    SubstancePolymer("SubstancePolymer", "http://hl7.org/fhir/resource-types", "SubstancePolymer"),
    SubstanceProtein("SubstanceProtein", "http://hl7.org/fhir/resource-types", "SubstanceProtein"),
    SubstanceReferenceInformation(
      "SubstanceReferenceInformation",
      "http://hl7.org/fhir/resource-types",
      "SubstanceReferenceInformation",
    ),
    SubstanceSourceMaterial(
      "SubstanceSourceMaterial",
      "http://hl7.org/fhir/resource-types",
      "SubstanceSourceMaterial",
    ),
    SubstanceSpecification(
      "SubstanceSpecification",
      "http://hl7.org/fhir/resource-types",
      "SubstanceSpecification",
    ),
    SupplyDelivery("SupplyDelivery", "http://hl7.org/fhir/resource-types", "SupplyDelivery"),
    SupplyRequest("SupplyRequest", "http://hl7.org/fhir/resource-types", "SupplyRequest"),
    Task("Task", "http://hl7.org/fhir/resource-types", "Task"),
    TerminologyCapabilities(
      "TerminologyCapabilities",
      "http://hl7.org/fhir/resource-types",
      "TerminologyCapabilities",
    ),
    TestReport("TestReport", "http://hl7.org/fhir/resource-types", "TestReport"),
    TestScript("TestScript", "http://hl7.org/fhir/resource-types", "TestScript"),
    ValueSet("ValueSet", "http://hl7.org/fhir/resource-types", "ValueSet"),
    VerificationResult(
      "VerificationResult",
      "http://hl7.org/fhir/resource-types",
      "VerificationResult",
    ),
    VisionPrescription(
      "VisionPrescription",
      "http://hl7.org/fhir/resource-types",
      "VisionPrescription",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ResourceType =
        when (code) {
          "Account" -> Account
          "ActivityDefinition" -> ActivityDefinition
          "AdverseEvent" -> AdverseEvent
          "AllergyIntolerance" -> AllergyIntolerance
          "Appointment" -> Appointment
          "AppointmentResponse" -> AppointmentResponse
          "AuditEvent" -> AuditEvent
          "Basic" -> Basic
          "Binary" -> Binary
          "BiologicallyDerivedProduct" -> BiologicallyDerivedProduct
          "BodyStructure" -> BodyStructure
          "Bundle" -> Bundle
          "CapabilityStatement" -> CapabilityStatement
          "CarePlan" -> CarePlan
          "CareTeam" -> CareTeam
          "CatalogEntry" -> CatalogEntry
          "ChargeItem" -> ChargeItem
          "ChargeItemDefinition" -> ChargeItemDefinition
          "Claim" -> Claim
          "ClaimResponse" -> ClaimResponse
          "ClinicalImpression" -> ClinicalImpression
          "CodeSystem" -> CodeSystem
          "Communication" -> Communication
          "CommunicationRequest" -> CommunicationRequest
          "CompartmentDefinition" -> CompartmentDefinition
          "Composition" -> Composition
          "ConceptMap" -> ConceptMap
          "Condition" -> Condition
          "Consent" -> Consent
          "Contract" -> Contract
          "Coverage" -> Coverage
          "CoverageEligibilityRequest" -> CoverageEligibilityRequest
          "CoverageEligibilityResponse" -> CoverageEligibilityResponse
          "DetectedIssue" -> DetectedIssue
          "Device" -> Device
          "DeviceDefinition" -> DeviceDefinition
          "DeviceMetric" -> DeviceMetric
          "DeviceRequest" -> DeviceRequest
          "DeviceUseStatement" -> DeviceUseStatement
          "DiagnosticReport" -> DiagnosticReport
          "DocumentManifest" -> DocumentManifest
          "DocumentReference" -> DocumentReference
          "DomainResource" -> DomainResource
          "EffectEvidenceSynthesis" -> EffectEvidenceSynthesis
          "Encounter" -> Encounter
          "Endpoint" -> Endpoint
          "EnrollmentRequest" -> EnrollmentRequest
          "EnrollmentResponse" -> EnrollmentResponse
          "EpisodeOfCare" -> EpisodeOfCare
          "EventDefinition" -> EventDefinition
          "Evidence" -> Evidence
          "EvidenceVariable" -> EvidenceVariable
          "ExampleScenario" -> ExampleScenario
          "ExplanationOfBenefit" -> ExplanationOfBenefit
          "FamilyMemberHistory" -> FamilyMemberHistory
          "Flag" -> Flag
          "Goal" -> Goal
          "GraphDefinition" -> GraphDefinition
          "Group" -> Group
          "GuidanceResponse" -> GuidanceResponse
          "HealthcareService" -> HealthcareService
          "ImagingStudy" -> ImagingStudy
          "Immunization" -> Immunization
          "ImmunizationEvaluation" -> ImmunizationEvaluation
          "ImmunizationRecommendation" -> ImmunizationRecommendation
          "ImplementationGuide" -> ImplementationGuide
          "InsurancePlan" -> InsurancePlan
          "Invoice" -> Invoice
          "Library" -> Library
          "Linkage" -> Linkage
          "List" -> List
          "Location" -> Location
          "Measure" -> Measure
          "MeasureReport" -> MeasureReport
          "Media" -> Media
          "Medication" -> Medication
          "MedicationAdministration" -> MedicationAdministration
          "MedicationDispense" -> MedicationDispense
          "MedicationKnowledge" -> MedicationKnowledge
          "MedicationRequest" -> MedicationRequest
          "MedicationStatement" -> MedicationStatement
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
          "MessageDefinition" -> MessageDefinition
          "MessageHeader" -> MessageHeader
          "MolecularSequence" -> MolecularSequence
          "NamingSystem" -> NamingSystem
          "NutritionOrder" -> NutritionOrder
          "Observation" -> Observation
          "ObservationDefinition" -> ObservationDefinition
          "OperationDefinition" -> OperationDefinition
          "OperationOutcome" -> OperationOutcome
          "Organization" -> Organization
          "OrganizationAffiliation" -> OrganizationAffiliation
          "Parameters" -> Parameters
          "Patient" -> Patient
          "PaymentNotice" -> PaymentNotice
          "PaymentReconciliation" -> PaymentReconciliation
          "Person" -> Person
          "PlanDefinition" -> PlanDefinition
          "Practitioner" -> Practitioner
          "PractitionerRole" -> PractitionerRole
          "Procedure" -> Procedure
          "Provenance" -> Provenance
          "Questionnaire" -> Questionnaire
          "QuestionnaireResponse" -> QuestionnaireResponse
          "RelatedPerson" -> RelatedPerson
          "RequestGroup" -> RequestGroup
          "ResearchDefinition" -> ResearchDefinition
          "ResearchElementDefinition" -> ResearchElementDefinition
          "ResearchStudy" -> ResearchStudy
          "ResearchSubject" -> ResearchSubject
          "Resource" -> Resource
          "RiskAssessment" -> RiskAssessment
          "RiskEvidenceSynthesis" -> RiskEvidenceSynthesis
          "Schedule" -> Schedule
          "SearchParameter" -> SearchParameter
          "ServiceRequest" -> ServiceRequest
          "Slot" -> Slot
          "Specimen" -> Specimen
          "SpecimenDefinition" -> SpecimenDefinition
          "StructureDefinition" -> StructureDefinition
          "StructureMap" -> StructureMap
          "Subscription" -> Subscription
          "Substance" -> Substance
          "SubstanceNucleicAcid" -> SubstanceNucleicAcid
          "SubstancePolymer" -> SubstancePolymer
          "SubstanceProtein" -> SubstanceProtein
          "SubstanceReferenceInformation" -> SubstanceReferenceInformation
          "SubstanceSourceMaterial" -> SubstanceSourceMaterial
          "SubstanceSpecification" -> SubstanceSpecification
          "SupplyDelivery" -> SupplyDelivery
          "SupplyRequest" -> SupplyRequest
          "Task" -> Task
          "TerminologyCapabilities" -> TerminologyCapabilities
          "TestReport" -> TestReport
          "TestScript" -> TestScript
          "ValueSet" -> ValueSet
          "VerificationResult" -> VerificationResult
          "VisionPrescription" -> VisionPrescription
          else -> throw IllegalArgumentException("Unknown code $code for enum ResourceType")
        }
    }
  }
}
