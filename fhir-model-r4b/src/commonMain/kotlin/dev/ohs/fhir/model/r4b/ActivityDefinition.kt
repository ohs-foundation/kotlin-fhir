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

import dev.ohs.fhir.model.r4b.serializers.ActivityDefinitionDynamicValueSerializer
import dev.ohs.fhir.model.r4b.serializers.ActivityDefinitionParticipantSerializer
import dev.ohs.fhir.model.r4b.serializers.ActivityDefinitionSerializer
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.RequestResourceType
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource allows for the definition of some activity to be performed, independent of a
 * particular patient, practitioner, or other performance context.
 */
@Serializable(with = ActivityDefinitionSerializer::class)
@SerialName("ActivityDefinition")
public data class ActivityDefinition(
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
   * An absolute URI that is used to identify this activity definition when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this activity definition is (or will be) published. This URL can be the target of a
   * canonical reference. It SHALL remain the same when the activity definition is stored on
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
   * A formal identifier that is used to identify this activity definition when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this activity definition outside of FHIR, where it is not possible
   * to use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the activity definition when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the activity definition author and is not expected to be globally unique. For example, it might
   * be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence. To provide a version
   * consistent with the Decision Support Service specification, use the format Major.Minor.Revision
   * (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision
   * Support Service specification. Note that a version is required for non-experimental active
   * assets.
   *
   * There may be different activity definition instances that have the same identifier but
   * different versions. The version can be appended to the url in a reference to allow a reference
   * to a particular business version of the activity definition with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the activity definition. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the activity definition.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * An explanatory or alternate title for the activity definition giving additional information
   * about its content.
   */
  public val subtitle: String? = null,
  /**
   * The status of this activity definition. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of activity definitions that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this activity definition is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of activity definitions that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * A code, group definition, or canonical reference that describes or identifies the intended
   * subject of the activity being defined. Canonical references are allowed to support the
   * definition of protocols for drug and substance quality specifications, and is allowed to
   * reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition,
   * ManufacturedItemDefinition, or PackagedProductDefinition resource.
   *
   * Note that the choice of canonical for the subject element was introduced in R4B to support
   * pharmaceutical quality use cases. To ensure as much backwards-compatibility as possible, it is
   * recommended to only use the new canonical type with these use cases.
   */
  public val subject: Subject? = null,
  /**
   * The date (and optionally time) when the activity definition was published. The date must change
   * when the business version changes and it must change if the status code changes. In addition,
   * it should change when the substantive content of the activity definition changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the activity definition. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the activity definition.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the activity
   * definition is the organization or individual primarily responsible for the maintenance and
   * upkeep of the activity definition. This is not necessarily the same individual or organization
   * that developed and initially authored the content. The publisher is the primary point of
   * contact for questions or issues with the activity definition. This item SHOULD be populated
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
   * A free text natural language description of the activity definition from a consumer's
   * perspective.
   *
   * This description can be used to capture details such as why the activity definition was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the activity definition as
   * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
   * information is available from context (e.g. the language of the activity definition is presumed
   * to be the predominant language in the place the activity definition was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate activity definition instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the activity definition is intended to be used.
   *
   * It may be possible for the activity definition to be used in jurisdictions other than those for
   * which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this activity definition is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the activity definition. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * activity definition.
   */
  public val purpose: Markdown? = null,
  /** A detailed description of how the activity definition is used from a clinical perspective. */
  public val usage: String? = null,
  /**
   * A copyright statement relating to the activity definition and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the activity
   * definition.
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
   * The period during which the activity definition content was or is planned to be in active use.
   *
   * The effective period for a activity definition determines when the content is applicable for
   * usage and is independent of publication and review dates. For example, a measure intended to be
   * used for the year 2016 might be published in 2015.
   */
  public val effectivePeriod: Period? = null,
  /**
   * Descriptive topics related to the content of the activity. Topics provide a high-level
   * categorization of the activity that can be useful for filtering and searching.
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
  /**
   * A reference to a Library resource containing any formal logic used by the activity definition.
   */
  public val library: List<Canonical> = listOf(),
  /**
   * A description of the kind of resource the activity definition is representing. For example, a
   * MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this
   * is a Request resource.
   *
   * May determine what types of extensions are permitted.
   */
  public val kind: Enumeration<RequestResourceType>? = null,
  /** A profile to which the target of the activity definition is expected to conform. */
  public val profile: Canonical? = null,
  /**
   * Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of
   * encounter.
   *
   * Tends to be less relevant for activities involving particular products.
   */
  public val code: CodeableConcept? = null,
  /**
   * Indicates the level of authority/intentionality associated with the activity and where the
   * request should fit into the workflow chain.
   */
  public val intent: Enumeration<RequestIntent>? = null,
  /** Indicates how quickly the activity should be addressed with respect to other requests. */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * Set this to true if the definition is to indicate that a particular activity should NOT be
   * performed. If true, this element should be interpreted to reinforce a negative coding. For
   * example NPO as a code with a doNotPerform of true would still indicate to NOT perform the
   * action.
   *
   * This element is not intended to be used to communicate a decision support response to cancel an
   * order in progress. That should be done with the "remove" type of a PlanDefinition or
   * RequestGroup.
   */
  public val doNotPerform: Boolean? = null,
  /** The period, timing or frequency upon which the described activity is to occur. */
  public val timing: Timing? = null,
  /**
   * Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic,
   * etc.
   *
   * May reference a specific clinical location or may just identify a type of location.
   */
  public val location: Reference? = null,
  /** Indicates who should participate in performing the action described. */
  public val participant: List<Participant> = listOf(),
  /** Identifies the food, drug or other product being consumed or supplied in the activity. */
  public val product: Product? = null,
  /** Identifies the quantity expected to be consumed at once (per dose, per meal, etc.). */
  public val quantity: Quantity? = null,
  /**
   * Provides detailed dosage instructions in the same way that they are described for
   * MedicationRequest resources.
   *
   * If a dosage instruction is used, the definition should not specify timing or quantity.
   */
  public val dosage: List<Dosage> = listOf(),
  /**
   * Indicates the sites on the subject's body where the procedure should be performed (I.e. the
   * target sites).
   *
   * Only used if not implicit in the code found in ServiceRequest.type.
   */
  public val bodySite: List<CodeableConcept> = listOf(),
  /**
   * Defines specimen requirements for the action to be performed, such as required specimens for a
   * lab test.
   */
  public val specimenRequirement: List<Reference> = listOf(),
  /**
   * Defines observation requirements for the action to be performed, such as body weight or surface
   * area.
   */
  public val observationRequirement: List<Reference> = listOf(),
  /** Defines the observations that are expected to be produced by the action. */
  public val observationResultRequirement: List<Reference> = listOf(),
  /**
   * A reference to a StructureMap resource that defines a transform that can be executed to produce
   * the intent resource using the ActivityDefinition instance as the input.
   *
   * Note that if both a transform and dynamic values are specified, the dynamic values will be
   * applied to the result of the transform.
   */
  public val transform: Canonical? = null,
  /**
   * Dynamic values that will be evaluated to produce values for elements of the resulting resource.
   * For example, if the dosage of a medication must be computed based on the patient's weight, a
   * dynamic value would be used to specify an expression that calculated the weight, and the path
   * on the request resource that would contain the result.
   *
   * Dynamic values are applied in the order in which they are defined in the ActivityDefinition.
   * Note that if both a transform and dynamic values are specified, the dynamic values will be
   * applied to the result of the transform.
   */
  public val dynamicValue: List<DynamicValue> = listOf(),
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
        library = this@with.library.map { it.toBuilder() }.toMutableList()
        kind = this@with.kind
        profile = this@with.profile?.toBuilder()
        code = this@with.code?.toBuilder()
        intent = this@with.intent
        priority = this@with.priority
        doNotPerform = this@with.doNotPerform?.toBuilder()
        timing = this@with.timing
        location = this@with.location?.toBuilder()
        participant = this@with.participant.map { it.toBuilder() }.toMutableList()
        product = this@with.product
        quantity = this@with.quantity?.toBuilder()
        dosage = this@with.dosage.map { it.toBuilder() }.toMutableList()
        bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
        specimenRequirement = this@with.specimenRequirement.map { it.toBuilder() }.toMutableList()
        observationRequirement =
          this@with.observationRequirement.map { it.toBuilder() }.toMutableList()
        observationResultRequirement =
          this@with.observationResultRequirement.map { it.toBuilder() }.toMutableList()
        transform = this@with.transform?.toBuilder()
        dynamicValue = this@with.dynamicValue.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Indicates who should participate in performing the action described. */
  @Serializable(with = ActivityDefinitionParticipantSerializer::class)
  public data class Participant(
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
    /** The type of participant in the action. */
    public val type: Enumeration<ActionParticipantType>,
    /** The role the participant should play in performing the described action. */
    public val role: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          role = this@with.role?.toBuilder()
        }
      }

    public class Builder(
      /** The type of participant in the action. */
      public var type: Enumeration<ActionParticipantType>
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

      /** The role the participant should play in performing the described action. */
      public var role: CodeableConcept.Builder? = null

      public fun build(): Participant =
        Participant(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          role = role?.build(),
        )
    }
  }

  /**
   * Dynamic values that will be evaluated to produce values for elements of the resulting resource.
   * For example, if the dosage of a medication must be computed based on the patient's weight, a
   * dynamic value would be used to specify an expression that calculated the weight, and the path
   * on the request resource that would contain the result.
   */
  @Serializable(with = ActivityDefinitionDynamicValueSerializer::class)
  public data class DynamicValue(
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
     * The path to the element to be customized. This is the path on the resource that will hold the
     * result of the calculation defined by the expression. The specified path SHALL be a FHIRPath
     * resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of
     * identifiers, constant indexers, and a restricted subset of functions. The path is allowed to
     * contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse
     * multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple)
     * for full details).
     *
     * The path attribute contains a [Simple FHIRPath Subset](fhirpath.html#simple) that allows path
     * traversal, but not calculation.
     */
    public val path: String,
    /**
     * An expression specifying the value of the customized element.
     *
     * The expression may be inlined, or may be a reference to a named expression within a logic
     * library referenced by the library element.
     */
    public val expression: Expression,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(path.toBuilder(), expression.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The path to the element to be customized. This is the path on the resource that will hold
       * the result of the calculation defined by the expression. The specified path SHALL be a
       * FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL
       * consist only of identifiers, constant indexers, and a restricted subset of functions. The
       * path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers
       * ([x]) to traverse multiple-cardinality sub-elements (see the
       * [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
       *
       * The path attribute contains a [Simple FHIRPath Subset](fhirpath.html#simple) that allows
       * path traversal, but not calculation.
       */
      public var path: String.Builder,
      /**
       * An expression specifying the value of the customized element.
       *
       * The expression may be inlined, or may be a reference to a named expression within a logic
       * library referenced by the library element.
       */
      public var expression: Expression.Builder,
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

      public fun build(): DynamicValue =
        DynamicValue(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          path = path.build(),
          expression = expression.build(),
        )
    }
  }

  public sealed interface Subject {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public fun asCanonical(): Canonical? = this as? Canonical

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept) :
      Subject

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Subject

    public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Subject

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
      ): Subject? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        return null
      }
    }
  }

  public sealed interface Timing {
    public fun asTiming(): Timing? = this as? Timing

    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asAge(): Age? = this as? Age

    public fun asPeriod(): Period? = this as? Period

    public fun asRange(): Range? = this as? Range

    public fun asDuration(): Duration? = this as? Duration

    public data class Timing(public val `value`: dev.ohs.fhir.model.r4b.Timing) :
      ActivityDefinition.Timing

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4b.DateTime) :
      ActivityDefinition.Timing

    public data class Age(public val `value`: dev.ohs.fhir.model.r4b.Age) :
      ActivityDefinition.Timing

    public data class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) :
      ActivityDefinition.Timing

    public data class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) :
      ActivityDefinition.Timing

    public data class Duration(public val `value`: dev.ohs.fhir.model.r4b.Duration) :
      ActivityDefinition.Timing

    public companion object {
      internal fun from(
        timingValue: dev.ohs.fhir.model.r4b.Timing?,
        dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
        ageValue: dev.ohs.fhir.model.r4b.Age?,
        periodValue: dev.ohs.fhir.model.r4b.Period?,
        rangeValue: dev.ohs.fhir.model.r4b.Range?,
        durationValue: dev.ohs.fhir.model.r4b.Duration?,
      ): ActivityDefinition.Timing? {
        if (timingValue != null) return Timing(timingValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (ageValue != null) return Age(ageValue)
        if (periodValue != null) return Period(periodValue)
        if (rangeValue != null) return Range(rangeValue)
        if (durationValue != null) return Duration(durationValue)
        return null
      }
    }
  }

  public sealed interface Product {
    public fun asReference(): Reference? = this as? Reference

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Product

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept) :
      Product

    public companion object {
      internal fun from(
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
      ): Product? {
        if (referenceValue != null) return Reference(referenceValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of this activity definition. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of activity definitions that are appropriate for use versus not.
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
     * An absolute URI that is used to identify this activity definition when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this activity definition is (or will be) published. This URL can be the target of
     * a canonical reference. It SHALL remain the same when the activity definition is stored on
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
     * A formal identifier that is used to identify this activity definition when it is represented
     * in other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this activity definition outside of FHIR, where it is not
     * possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the activity definition when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the activity definition author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence. To provide a version
     * consistent with the Decision Support Service specification, use the format
     * Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer
     * to the Decision Support Service specification. Note that a version is required for
     * non-experimental active assets.
     *
     * There may be different activity definition instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the activity definition with the format
     * [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the activity definition. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the activity definition.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * An explanatory or alternate title for the activity definition giving additional information
     * about its content.
     */
    public var subtitle: String.Builder? = null

    /**
     * A Boolean value to indicate that this activity definition is authored for testing purposes
     * (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of activity definitions that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * A code, group definition, or canonical reference that describes or identifies the intended
     * subject of the activity being defined. Canonical references are allowed to support the
     * definition of protocols for drug and substance quality specifications, and is allowed to
     * reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition,
     * ManufacturedItemDefinition, or PackagedProductDefinition resource.
     *
     * Note that the choice of canonical for the subject element was introduced in R4B to support
     * pharmaceutical quality use cases. To ensure as much backwards-compatibility as possible, it
     * is recommended to only use the new canonical type with these use cases.
     */
    public var subject: Subject? = null

    /**
     * The date (and optionally time) when the activity definition was published. The date must
     * change when the business version changes and it must change if the status code changes. In
     * addition, it should change when the substantive content of the activity definition changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the activity definition. Additional specific dates may be added
     * as extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the activity definition.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the activity
     * definition is the organization or individual primarily responsible for the maintenance and
     * upkeep of the activity definition. This is not necessarily the same individual or
     * organization that developed and initially authored the content. The publisher is the primary
     * point of contact for questions or issues with the activity definition. This item SHOULD be
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
     * A free text natural language description of the activity definition from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as why the activity definition was
     * built, comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the activity
     * definition as conveyed in the 'text' field of the resource itself. This item SHOULD be
     * populated unless the information is available from context (e.g. the language of the activity
     * definition is presumed to be the predominant language in the place the activity definition
     * was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate activity definition instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the activity definition is intended to be used.
     *
     * It may be possible for the activity definition to be used in jurisdictions other than those
     * for which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this activity definition is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the activity definition. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * activity definition.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A detailed description of how the activity definition is used from a clinical perspective.
     */
    public var usage: String.Builder? = null

    /**
     * A copyright statement relating to the activity definition and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the activity
     * definition.
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
     * The period during which the activity definition content was or is planned to be in active
     * use.
     *
     * The effective period for a activity definition determines when the content is applicable for
     * usage and is independent of publication and review dates. For example, a measure intended to
     * be used for the year 2016 might be published in 2015.
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * Descriptive topics related to the content of the activity. Topics provide a high-level
     * categorization of the activity that can be useful for filtering and searching.
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

    /**
     * A reference to a Library resource containing any formal logic used by the activity
     * definition.
     */
    public var library: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * A description of the kind of resource the activity definition is representing. For example, a
     * MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always,
     * this is a Request resource.
     *
     * May determine what types of extensions are permitted.
     */
    public var kind: Enumeration<RequestResourceType>? = null

    /** A profile to which the target of the activity definition is expected to conform. */
    public var profile: Canonical.Builder? = null

    /**
     * Detailed description of the type of activity; e.g. What lab test, what procedure, what kind
     * of encounter.
     *
     * Tends to be less relevant for activities involving particular products.
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * Indicates the level of authority/intentionality associated with the activity and where the
     * request should fit into the workflow chain.
     */
    public var intent: Enumeration<RequestIntent>? = null

    /** Indicates how quickly the activity should be addressed with respect to other requests. */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * Set this to true if the definition is to indicate that a particular activity should NOT be
     * performed. If true, this element should be interpreted to reinforce a negative coding. For
     * example NPO as a code with a doNotPerform of true would still indicate to NOT perform the
     * action.
     *
     * This element is not intended to be used to communicate a decision support response to cancel
     * an order in progress. That should be done with the "remove" type of a PlanDefinition or
     * RequestGroup.
     */
    public var doNotPerform: Boolean.Builder? = null

    /** The period, timing or frequency upon which the described activity is to occur. */
    public var timing: Timing? = null

    /**
     * Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic,
     * etc.
     *
     * May reference a specific clinical location or may just identify a type of location.
     */
    public var location: Reference.Builder? = null

    /** Indicates who should participate in performing the action described. */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /** Identifies the food, drug or other product being consumed or supplied in the activity. */
    public var product: Product? = null

    /** Identifies the quantity expected to be consumed at once (per dose, per meal, etc.). */
    public var quantity: Quantity.Builder? = null

    /**
     * Provides detailed dosage instructions in the same way that they are described for
     * MedicationRequest resources.
     *
     * If a dosage instruction is used, the definition should not specify timing or quantity.
     */
    public var dosage: MutableList<Dosage.Builder> = mutableListOf()

    /**
     * Indicates the sites on the subject's body where the procedure should be performed (I.e. the
     * target sites).
     *
     * Only used if not implicit in the code found in ServiceRequest.type.
     */
    public var bodySite: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Defines specimen requirements for the action to be performed, such as required specimens for
     * a lab test.
     */
    public var specimenRequirement: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Defines observation requirements for the action to be performed, such as body weight or
     * surface area.
     */
    public var observationRequirement: MutableList<Reference.Builder> = mutableListOf()

    /** Defines the observations that are expected to be produced by the action. */
    public var observationResultRequirement: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A reference to a StructureMap resource that defines a transform that can be executed to
     * produce the intent resource using the ActivityDefinition instance as the input.
     *
     * Note that if both a transform and dynamic values are specified, the dynamic values will be
     * applied to the result of the transform.
     */
    public var transform: Canonical.Builder? = null

    /**
     * Dynamic values that will be evaluated to produce values for elements of the resulting
     * resource. For example, if the dosage of a medication must be computed based on the patient's
     * weight, a dynamic value would be used to specify an expression that calculated the weight,
     * and the path on the request resource that would contain the result.
     *
     * Dynamic values are applied in the order in which they are defined in the ActivityDefinition.
     * Note that if both a transform and dynamic values are specified, the dynamic values will be
     * applied to the result of the transform.
     */
    public var dynamicValue: MutableList<DynamicValue.Builder> = mutableListOf()

    override fun build(): ActivityDefinition =
      ActivityDefinition(
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
        library = library.map { it.build() },
        kind = kind,
        profile = profile?.build(),
        code = code?.build(),
        intent = intent,
        priority = priority,
        doNotPerform = doNotPerform?.build(),
        timing = timing,
        location = location?.build(),
        participant = participant.map { it.build() },
        product = product,
        quantity = quantity?.build(),
        dosage = dosage.map { it.build() },
        bodySite = bodySite.map { it.build() },
        specimenRequirement = specimenRequirement.map { it.build() },
        observationRequirement = observationRequirement.map { it.build() },
        observationResultRequirement = observationResultRequirement.map { it.build() },
        transform = transform?.build(),
        dynamicValue = dynamicValue.map { it.build() },
      )
  }

  /** The type of participant for the action. */
  public enum class ActionParticipantType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Patient("patient", "http://hl7.org/fhir/action-participant-type", "Patient"),
    Practitioner("practitioner", "http://hl7.org/fhir/action-participant-type", "Practitioner"),
    Related_Person(
      "related-person",
      "http://hl7.org/fhir/action-participant-type",
      "Related Person",
    ),
    Device("device", "http://hl7.org/fhir/action-participant-type", "Device");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionParticipantType =
        when (code) {
          "patient" -> Patient
          "practitioner" -> Practitioner
          "related-person" -> Related_Person
          "device" -> Device
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionParticipantType")
        }
    }
  }

  /** Codes indicating the degree of authority/intentionality associated with a request. */
  public enum class RequestIntent(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
    Directive("directive", "http://hl7.org/fhir/request-intent", "Directive"),
    Order("order", "http://hl7.org/fhir/request-intent", "Order"),
    Original_Order("original-order", "http://hl7.org/fhir/request-intent", "Original Order"),
    Reflex_Order("reflex-order", "http://hl7.org/fhir/request-intent", "Reflex Order"),
    Filler_Order("filler-order", "http://hl7.org/fhir/request-intent", "Filler Order"),
    Instance_Order("instance-order", "http://hl7.org/fhir/request-intent", "Instance Order"),
    Option("option", "http://hl7.org/fhir/request-intent", "Option");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestIntent =
        when (code) {
          "proposal" -> Proposal
          "plan" -> Plan
          "directive" -> Directive
          "order" -> Order
          "original-order" -> Original_Order
          "reflex-order" -> Reflex_Order
          "filler-order" -> Filler_Order
          "instance-order" -> Instance_Order
          "option" -> Option
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestIntent")
        }
    }
  }

  /** Identifies the level of importance to be assigned to actioning the request. */
  public enum class RequestPriority(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
    Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
    Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
    Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestPriority =
        when (code) {
          "routine" -> Routine
          "urgent" -> Urgent
          "asap" -> Asap
          "stat" -> Stat
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestPriority")
        }
    }
  }
}
