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

import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionTypeTestedContainerAdditiveSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionTypeTestedContainerSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionTypeTestedHandlingSerializer
import dev.ohs.fhir.model.r5.serializers.SpecimenDefinitionTypeTestedSerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A kind of specimen with associated set of requirements. */
@Serializable(with = SpecimenDefinitionSerializer::class)
@SerialName("SpecimenDefinition")
public data class SpecimenDefinition(
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
   * An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a
   * specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique,
   * and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL
   * SHOULD include the major version of the SpecimenDefinition. For more information see Technical
   * and Business Versions.
   *
   * Can be a urn:uuid: or a urn:oid:, but real http: addresses are preferred. This is the URI that
   * will be used when making canonical references to this resource.
   */
  public val url: Uri? = null,
  /** A business identifier assigned to this SpecimenDefinition. */
  public val identifier: Identifier? = null,
  /**
   * The identifier that is used to identify this version of the SpecimenDefinition when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the SpecimenDefinition author and is not expected to be globally unique.
   *
   * There may be multiple different instances of a SpecimenDefinition that have the same identifier
   * but different versions.
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
   * A natural language name identifying the {{title}}. This name should be usable as an identifier
   * for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /** A short, descriptive, user-friendly title for the SpecimenDefinition. */
  public val title: String? = null,
  /**
   * The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in
   * whole or in part by this definition.
   */
  public val derivedFromCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally-defined type of specimen, guideline or other definition that
   * is adhered to in whole or in part by this definition.
   */
  public val derivedFromUri: List<Uri> = listOf(),
  /**
   * The current state of theSpecimenDefinition.
   *
   * A nominal state-transition diagram can be found in the
   * [Definition pattern](definition.html#statemachine) documentation Unknown does not represent
   * "other" - one of the defined statuses must apply. Unknown is used when the authoring system is
   * not sure what the current status is.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A flag to indicate that this SpecimenDefinition is not authored for genuine usage.
   *
   * Allows filtering of SpecimenDefinition that are appropriate for use vs. not.
   */
  public val experimental: Boolean? = null,
  /**
   * A code or group definition that describes the intended subject from which this kind of specimen
   * is to be collected.
   *
   * Examples: person, animal, device, water ….
   */
  public val subject: Subject? = null,
  /**
   * For draft definitions, indicates the date of initial creation. For active definitions,
   * represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * Helps establish the "authority/credibility" of the SpecimenDefinition. May also allow for
   * contact.
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
   * A free text natural language description of the SpecimenDefinition from the consumer's
   * perspective.
   *
   * This description can be used to capture details such as comments about misuse, instructions for
   * clinical use and interpretation, literature references, examples from the paper world, etc. It
   * is not a rendering of the module as conveyed in the text field of the resource itself. This
   * item SHOULD be populated unless the information is available from context.
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These terms may be used to assist with indexing and searching of specimen definitions.
   *
   * When multiple usageContexts are specified, there is no expectation for whether all or any of
   * the contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A jurisdiction in which the SpecimenDefinition is intended to be used.
   *
   * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
   * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
   * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
   * useContext.valueCodeableConcept indicating the jurisdiction.)
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explains why this SpecimeDefinition is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the SpecimenDefinition. Rather it is for
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * SpecimenDefinition.
   */
  public val purpose: Markdown? = null,
  /**
   * Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the
   * SpecimenDefinition.
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
   * The date on which the asset content was approved by the publisher. Approval happens once when
   * the content is officially approved for usage.
   *
   * The date may be more recent than the approval date because of minor changes / editorial
   * corrections.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val approvalDate: Date? = null,
  /**
   * The date on which the asset content was last reviewed. Review happens periodically after that,
   * but doesn't change the original approval date.
   *
   * If specified, this is usually after the approval date.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val lastReviewDate: Date? = null,
  /**
   * The period during which the SpecimenDefinition content was or is planned to be effective.
   *
   * The effective period for a SpecimenDefinition determines when the content is applicable for
   * usage and is independent of publication and review dates.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val effectivePeriod: Period? = null,
  /** The kind of material to be collected. */
  public val typeCollected: CodeableConcept? = null,
  /** Preparation of the patient for specimen collection. */
  public val patientPreparation: List<CodeableConcept> = listOf(),
  /** Time aspect of specimen collection (duration or offset). */
  public val timeAspect: String? = null,
  /** The action to be performed for collecting the specimen. */
  public val collection: List<CodeableConcept> = listOf(),
  /** Specimen conditioned in a container as expected by the testing laboratory. */
  public val typeTested: List<TypeTested> = listOf(),
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
        versionAlgorithm = this@with.versionAlgorithm
        name = this@with.name?.toBuilder()
        title = this@with.title?.toBuilder()
        derivedFromCanonical = this@with.derivedFromCanonical.map { it.toBuilder() }.toMutableList()
        derivedFromUri = this@with.derivedFromUri.map { it.toBuilder() }.toMutableList()
        experimental = this@with.experimental?.toBuilder()
        subject = this@with.subject
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        copyrightLabel = this@with.copyrightLabel?.toBuilder()
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        effectivePeriod = this@with.effectivePeriod?.toBuilder()
        typeCollected = this@with.typeCollected?.toBuilder()
        patientPreparation = this@with.patientPreparation.map { it.toBuilder() }.toMutableList()
        timeAspect = this@with.timeAspect?.toBuilder()
        collection = this@with.collection.map { it.toBuilder() }.toMutableList()
        typeTested = this@with.typeTested.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Specimen conditioned in a container as expected by the testing laboratory. */
  @Serializable(with = SpecimenDefinitionTypeTestedSerializer::class)
  public data class TypeTested(
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
    /** Primary of secondary specimen. */
    public val isDerived: Boolean? = null,
    /** The kind of specimen conditioned for testing expected by lab. */
    public val type: CodeableConcept? = null,
    /** The preference for this type of conditioned specimen. */
    public val preference: Enumeration<SpecimenContainedPreference>,
    /** The specimen's container. */
    public val container: Container? = null,
    /** Requirements for delivery and special handling of this kind of conditioned specimen. */
    public val requirement: Markdown? = null,
    /**
     * The usual time that a specimen of this kind is retained after the ordered tests are
     * completed, for the purpose of additional testing.
     */
    public val retentionTime: Duration? = null,
    /** Specimen can be used by only one test or panel if the value is "true". */
    public val singleUse: Boolean? = null,
    /** Criterion for rejection of the specimen in its container by the laboratory. */
    public val rejectionCriterion: List<CodeableConcept> = listOf(),
    /**
     * Set of instructions for preservation/transport of the specimen at a defined temperature
     * interval, prior the testing process.
     */
    public val handling: List<Handling> = listOf(),
    /** Where the specimen will be tested: e.g., lab, sector, device or any combination of these. */
    public val testingDestination: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(preference).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          isDerived = this@with.isDerived?.toBuilder()
          type = this@with.type?.toBuilder()
          container = this@with.container?.toBuilder()
          requirement = this@with.requirement?.toBuilder()
          retentionTime = this@with.retentionTime?.toBuilder()
          singleUse = this@with.singleUse?.toBuilder()
          rejectionCriterion = this@with.rejectionCriterion.map { it.toBuilder() }.toMutableList()
          handling = this@with.handling.map { it.toBuilder() }.toMutableList()
          testingDestination = this@with.testingDestination.map { it.toBuilder() }.toMutableList()
        }
      }

    /** The specimen's container. */
    @Serializable(with = SpecimenDefinitionTypeTestedContainerSerializer::class)
    public data class Container(
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
       * The type of material of the container.
       *
       * Examples: glass, plastic, metal.
       */
      public val material: CodeableConcept? = null,
      /** The type of container used to contain this kind of specimen. */
      public val type: CodeableConcept? = null,
      /** Color of container cap. */
      public val cap: CodeableConcept? = null,
      /** The textual description of the kind of container. */
      public val description: Markdown? = null,
      /** The capacity (volume or other measure) of this kind of container. */
      public val capacity: Quantity? = null,
      /** The minimum volume to be conditioned in the container. */
      public val minimumVolume: MinimumVolume? = null,
      /**
       * Substance introduced in the kind of container to preserve, maintain or enhance the
       * specimen. Examples: Formalin, Citrate, EDTA.
       */
      public val additive: List<Additive> = listOf(),
      /** Special processing that should be applied to the container for this kind of specimen. */
      public val preparation: Markdown? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            material = this@with.material?.toBuilder()
            type = this@with.type?.toBuilder()
            cap = this@with.cap?.toBuilder()
            description = this@with.description?.toBuilder()
            capacity = this@with.capacity?.toBuilder()
            minimumVolume = this@with.minimumVolume
            additive = this@with.additive.map { it.toBuilder() }.toMutableList()
            preparation = this@with.preparation?.toBuilder()
          }
        }

      /**
       * Substance introduced in the kind of container to preserve, maintain or enhance the
       * specimen. Examples: Formalin, Citrate, EDTA.
       */
      @Serializable(with = SpecimenDefinitionTypeTestedContainerAdditiveSerializer::class)
      public data class Additive(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * Substance introduced in the kind of container to preserve, maintain or enhance the
         * specimen. Examples: Formalin, Citrate, EDTA.
         */
        public val additive: Additive,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(additive).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            }
          }

        public sealed interface Additive {
          public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

          public fun asReference(): Reference? = this as? Reference

          public data class CodeableConcept(
            public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
          ) : Additive

          public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) :
            Additive

          public companion object {
            internal fun from(
              codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
              referenceValue: dev.ohs.fhir.model.r5.Reference?,
            ): Additive? {
              if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
              if (referenceValue != null) return Reference(referenceValue)
              return null
            }
          }
        }

        public class Builder(
          /**
           * Substance introduced in the kind of container to preserve, maintain or enhance the
           * specimen. Examples: Formalin, Citrate, EDTA.
           */
          public var additive: Additive
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and managable, there is a strict set of governance applied to the
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

          public fun build(): Container.Additive =
            Container.Additive(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              additive = additive,
            )
        }
      }

      public sealed interface MinimumVolume {
        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asString(): String? = this as? String

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) :
          MinimumVolume

        public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : MinimumVolume

        public companion object {
          internal fun from(
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            stringValue: dev.ohs.fhir.model.r5.String?,
          ): MinimumVolume? {
            if (quantityValue != null) return Quantity(quantityValue)
            if (stringValue != null) return String(stringValue)
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

        /**
         * The type of material of the container.
         *
         * Examples: glass, plastic, metal.
         */
        public var material: CodeableConcept.Builder? = null

        /** The type of container used to contain this kind of specimen. */
        public var type: CodeableConcept.Builder? = null

        /** Color of container cap. */
        public var cap: CodeableConcept.Builder? = null

        /** The textual description of the kind of container. */
        public var description: Markdown.Builder? = null

        /** The capacity (volume or other measure) of this kind of container. */
        public var capacity: Quantity.Builder? = null

        /** The minimum volume to be conditioned in the container. */
        public var minimumVolume: MinimumVolume? = null

        /**
         * Substance introduced in the kind of container to preserve, maintain or enhance the
         * specimen. Examples: Formalin, Citrate, EDTA.
         */
        public var additive: MutableList<Additive.Builder> = mutableListOf()

        /** Special processing that should be applied to the container for this kind of specimen. */
        public var preparation: Markdown.Builder? = null

        public fun build(): Container =
          Container(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            material = material?.build(),
            type = type?.build(),
            cap = cap?.build(),
            description = description?.build(),
            capacity = capacity?.build(),
            minimumVolume = minimumVolume,
            additive = additive.map { it.build() },
            preparation = preparation?.build(),
          )
      }
    }

    /**
     * Set of instructions for preservation/transport of the specimen at a defined temperature
     * interval, prior the testing process.
     */
    @Serializable(with = SpecimenDefinitionTypeTestedHandlingSerializer::class)
    public data class Handling(
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
       * It qualifies the interval of temperature, which characterizes an occurrence of handling.
       * Conditions that are not related to temperature may be handled in the instruction element.
       */
      public val temperatureQualifier: CodeableConcept? = null,
      /** The temperature interval for this set of handling instructions. */
      public val temperatureRange: Range? = null,
      /** The maximum time interval of preservation of the specimen with these conditions. */
      public val maxDuration: Duration? = null,
      /**
       * Additional textual instructions for the preservation or transport of the specimen. For
       * instance, 'Protect from light exposure'.
       */
      public val instruction: Markdown? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            temperatureQualifier = this@with.temperatureQualifier?.toBuilder()
            temperatureRange = this@with.temperatureRange?.toBuilder()
            maxDuration = this@with.maxDuration?.toBuilder()
            instruction = this@with.instruction?.toBuilder()
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

        /**
         * It qualifies the interval of temperature, which characterizes an occurrence of handling.
         * Conditions that are not related to temperature may be handled in the instruction element.
         */
        public var temperatureQualifier: CodeableConcept.Builder? = null

        /** The temperature interval for this set of handling instructions. */
        public var temperatureRange: Range.Builder? = null

        /** The maximum time interval of preservation of the specimen with these conditions. */
        public var maxDuration: Duration.Builder? = null

        /**
         * Additional textual instructions for the preservation or transport of the specimen. For
         * instance, 'Protect from light exposure'.
         */
        public var instruction: Markdown.Builder? = null

        public fun build(): Handling =
          Handling(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            temperatureQualifier = temperatureQualifier?.build(),
            temperatureRange = temperatureRange?.build(),
            maxDuration = maxDuration?.build(),
            instruction = instruction?.build(),
          )
      }
    }

    public class Builder(
      /** The preference for this type of conditioned specimen. */
      public var preference: Enumeration<SpecimenContainedPreference>
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

      /** Primary of secondary specimen. */
      public var isDerived: Boolean.Builder? = null

      /** The kind of specimen conditioned for testing expected by lab. */
      public var type: CodeableConcept.Builder? = null

      /** The specimen's container. */
      public var container: Container.Builder? = null

      /** Requirements for delivery and special handling of this kind of conditioned specimen. */
      public var requirement: Markdown.Builder? = null

      /**
       * The usual time that a specimen of this kind is retained after the ordered tests are
       * completed, for the purpose of additional testing.
       */
      public var retentionTime: Duration.Builder? = null

      /** Specimen can be used by only one test or panel if the value is "true". */
      public var singleUse: Boolean.Builder? = null

      /** Criterion for rejection of the specimen in its container by the laboratory. */
      public var rejectionCriterion: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Set of instructions for preservation/transport of the specimen at a defined temperature
       * interval, prior the testing process.
       */
      public var handling: MutableList<Handling.Builder> = mutableListOf()

      /**
       * Where the specimen will be tested: e.g., lab, sector, device or any combination of these.
       */
      public var testingDestination: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): TypeTested =
        TypeTested(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          isDerived = isDerived?.build(),
          type = type?.build(),
          preference = preference,
          container = container?.build(),
          requirement = requirement?.build(),
          retentionTime = retentionTime?.build(),
          singleUse = singleUse?.build(),
          rejectionCriterion = rejectionCriterion.map { it.build() },
          handling = handling.map { it.build() },
          testingDestination = testingDestination.map { it.build() },
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

  public sealed interface Subject {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
      Subject

    public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Subject

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r5.Reference?,
      ): Subject? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The current state of theSpecimenDefinition.
     *
     * A nominal state-transition diagram can be found in the
     * [Definition pattern](definition.html#statemachine) documentation Unknown does not represent
     * "other" - one of the defined statuses must apply. Unknown is used when the authoring system
     * is not sure what the current status is.
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
     * An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a
     * specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique,
     * and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL
     * SHOULD include the major version of the SpecimenDefinition. For more information see
     * Technical and Business Versions.
     *
     * Can be a urn:uuid: or a urn:oid:, but real http: addresses are preferred. This is the URI
     * that will be used when making canonical references to this resource.
     */
    public var url: Uri.Builder? = null

    /** A business identifier assigned to this SpecimenDefinition. */
    public var identifier: Identifier.Builder? = null

    /**
     * The identifier that is used to identify this version of the SpecimenDefinition when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the SpecimenDefinition author and is not expected to be globally unique.
     *
     * There may be multiple different instances of a SpecimenDefinition that have the same
     * identifier but different versions.
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
     * A natural language name identifying the {{title}}. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /** A short, descriptive, user-friendly title for the SpecimenDefinition. */
    public var title: String.Builder? = null

    /**
     * The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in
     * whole or in part by this definition.
     */
    public var derivedFromCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally-defined type of specimen, guideline or other definition
     * that is adhered to in whole or in part by this definition.
     */
    public var derivedFromUri: MutableList<Uri.Builder> = mutableListOf()

    /**
     * A flag to indicate that this SpecimenDefinition is not authored for genuine usage.
     *
     * Allows filtering of SpecimenDefinition that are appropriate for use vs. not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * A code or group definition that describes the intended subject from which this kind of
     * specimen is to be collected.
     *
     * Examples: person, animal, device, water ….
     */
    public var subject: Subject? = null

    /**
     * For draft definitions, indicates the date of initial creation. For active definitions,
     * represents the date of activation. For withdrawn definitions, indicates the date of
     * withdrawal.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * Helps establish the "authority/credibility" of the SpecimenDefinition. May also allow for
     * contact.
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
     * A free text natural language description of the SpecimenDefinition from the consumer's
     * perspective.
     *
     * This description can be used to capture details such as comments about misuse, instructions
     * for clinical use and interpretation, literature references, examples from the paper world,
     * etc. It is not a rendering of the module as conveyed in the text field of the resource
     * itself. This item SHOULD be populated unless the information is available from context.
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These terms may be used to assist with indexing and searching of specimen definitions.
     *
     * When multiple usageContexts are specified, there is no expectation for whether all or any of
     * the contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A jurisdiction in which the SpecimenDefinition is intended to be used.
     *
     * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
     * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
     * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
     * useContext.valueCodeableConcept indicating the jurisdiction.)
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explains why this SpecimeDefinition is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the SpecimenDefinition. Rather it is for
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * SpecimenDefinition.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the
     * SpecimenDefinition.
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
     * The date on which the asset content was approved by the publisher. Approval happens once when
     * the content is officially approved for usage.
     *
     * The date may be more recent than the approval date because of minor changes / editorial
     * corrections.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var approvalDate: Date.Builder? = null

    /**
     * The date on which the asset content was last reviewed. Review happens periodically after
     * that, but doesn't change the original approval date.
     *
     * If specified, this is usually after the approval date.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var lastReviewDate: Date.Builder? = null

    /**
     * The period during which the SpecimenDefinition content was or is planned to be effective.
     *
     * The effective period for a SpecimenDefinition determines when the content is applicable for
     * usage and is independent of publication and review dates.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var effectivePeriod: Period.Builder? = null

    /** The kind of material to be collected. */
    public var typeCollected: CodeableConcept.Builder? = null

    /** Preparation of the patient for specimen collection. */
    public var patientPreparation: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Time aspect of specimen collection (duration or offset). */
    public var timeAspect: String.Builder? = null

    /** The action to be performed for collecting the specimen. */
    public var collection: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Specimen conditioned in a container as expected by the testing laboratory. */
    public var typeTested: MutableList<TypeTested.Builder> = mutableListOf()

    override fun build(): SpecimenDefinition =
      SpecimenDefinition(
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
        versionAlgorithm = versionAlgorithm,
        name = name?.build(),
        title = title?.build(),
        derivedFromCanonical = derivedFromCanonical.map { it.build() },
        derivedFromUri = derivedFromUri.map { it.build() },
        status = status,
        experimental = experimental?.build(),
        subject = subject,
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        copyrightLabel = copyrightLabel?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        typeCollected = typeCollected?.build(),
        patientPreparation = patientPreparation.map { it.build() },
        timeAspect = timeAspect?.build(),
        collection = collection.map { it.build() },
        typeTested = typeTested.map { it.build() },
      )
  }

  /** Degree of preference of a type of conditioned specimen. */
  public enum class SpecimenContainedPreference(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Preferred("preferred", "http://hl7.org/fhir/specimen-contained-preference", "Preferred"),
    Alternate("alternate", "http://hl7.org/fhir/specimen-contained-preference", "Alternate");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SpecimenContainedPreference =
        when (code) {
          "preferred" -> Preferred
          "alternate" -> Alternate
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum SpecimenContainedPreference"
            )
        }
    }
  }
}
