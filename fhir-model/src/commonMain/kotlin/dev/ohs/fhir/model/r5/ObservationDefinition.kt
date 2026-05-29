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

import dev.ohs.fhir.model.r5.serializers.ObservationDefinitionComponentSerializer
import dev.ohs.fhir.model.r5.serializers.ObservationDefinitionQualifiedValueSerializer
import dev.ohs.fhir.model.r5.serializers.ObservationDefinitionSerializer
import dev.ohs.fhir.model.r5.terminologies.AdministrativeGender
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Set of definitional characteristics for a kind of observation or measurement produced or consumed
 * by an orderable health care service.
 */
@Serializable(with = ObservationDefinitionSerializer::class)
@SerialName("ObservationDefinition")
public data class ObservationDefinition(
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
   * An absolute URL that is used to identify this ObservationDefinition when it is referenced in a
   * specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique,
   * and SHOULD be an address at which this ObservationDefinition is (or will be) published. The URL
   * SHOULD include the major version of the ObservationDefinition. For more information see
   * Technical and Business Versions.
   *
   * Can be a urn:uuid: or a urn:oid:, but real http: addresses are preferred. This is the URI that
   * will be used when making canonical references to this resource.
   */
  public val url: Uri? = null,
  /**
   * Business identifiers assigned to this ObservationDefinition. by the performer and/or other
   * systems. These identifiers remain constant as the resource is updated and propagates from
   * server to server.
   *
   * This is a business identifier, not a resource identifier. It is best practice for the
   * identifier to only appear on a single resource instance, however business practices may
   * occasionally dictate that multiple resource instances with the same identifier can exist -
   * possibly even with different resource types.
   */
  public val identifier: Identifier? = null,
  /**
   * The identifier that is used to identify this version of the ObservationDefinition when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the ObservationDefinition author and is not expected to be globally unique. For example, it
   * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions are orderable.
   *
   * There may be multiple different instances of an observationDefinition that have the same
   * identifier but different versions.
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
   * A natural language name identifying the ObservationDefinition. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /** A short, descriptive, user-friendly title for the ObservationDefinition. */
  public val title: String? = null,
  /**
   * The current state of the ObservationDefinition.
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
   * A flag to indicate that this ObservationDefinition is authored for testing purposes (or
   * education/evaluation/marketing), and is not intended to be used for genuine usage.
   *
   * Allows filtering of ObservationDefinition that are appropriate for use vs. not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the ObservationDefinition was last significantly changed.
   * The date must change when the business version changes and it must change if the status code
   * changes. In addition, it should change when the substantive content of the
   * ObservationDefinition changes.
   *
   * The date is often not tracked until the resource is published, but may be present on draft
   * content. Note that this is not the same as the resource last-modified-date, since the resource
   * may be a secondary representation of the ObservationDefinition. Additional specific dates may
   * be added as extensions or be found by consulting Provenances associated with past versions of
   * the resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for
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
   * A free text natural language description of the ObservationDefinition from the consumer's
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
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate ObservationDefinition instances.
   *
   * When multiple usageContexts are specified, there is no expectation for whether all or any of
   * the contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A jurisdiction in which the ObservationDefinition is intended to be used.
   *
   * It may be possible for the ObservationDefinition to be used in jurisdictions other than those
   * for which it was originally designed or intended.
   *
   * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
   * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
   * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
   * useContext.valueCodeableConcept indicating the jurisdiction.)
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explains why this ObservationDefinition is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the ObservationDefinition. Rather it is for
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * ObservationDefinition.
   */
  public val purpose: Markdown? = null,
  /**
   * Copyright statement relating to the ObservationDefinition and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the
   * ObservationDefinition.
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
   * The period during which the ObservationDefinition content was or is planned to be effective.
   *
   * The effective period for an ObservationDefinition determines when the content is applicable for
   * usage and is independent of publication and review dates. For example, an observation
   * definition intended to be used for the year 2021 might be published in 2020.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val effectivePeriod: Period? = null,
  /**
   * The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to in
   * whole or in part by this definition.
   */
  public val derivedFromCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally-defined observation definition, guideline or other definition
   * that is adhered to in whole or in part by this definition.
   */
  public val derivedFromUri: List<Uri> = listOf(),
  /**
   * A code that describes the intended kind of subject of Observation instances conforming to this
   * ObservationDefinition.
   *
   * Examples: person, animal, device, air, surface ….
   */
  public val subject: List<CodeableConcept> = listOf(),
  /**
   * The type of individual/organization/device that is expected to act upon instances of this
   * definition.
   */
  public val performerType: CodeableConcept? = null,
  /**
   * A code that classifies the general type of observation.
   *
   * This element allows various categorization schemes based on the owner’s definition of the
   * category and effectively multiple categories can be used for one instance of
   * ObservationDefinition. The level of granularity is defined by the category concepts in the
   * value set.
   */
  public val category: List<CodeableConcept> = listOf(),
  /** Describes what will be observed. Sometimes this is called the observation "name". */
  public val code: CodeableConcept,
  /**
   * The data types allowed for the value element of the instance observations conforming to this
   * ObservationDefinition.
   */
  public val permittedDataType: List<Enumeration<ObservationDataType>> = listOf(),
  /**
   * Multiple results allowed for observations conforming to this ObservationDefinition.
   *
   * An example of observation allowing multiple results is "bacteria identified by culture".
   * Conversely, the measurement of a potassium level allows a single result.
   */
  public val multipleResultsAllowed: Boolean? = null,
  /**
   * The site on the subject's body where the observation is to be made.
   *
   * Only used if the defined observation is to be made directly on a body part and if this body
   * part is not implied by code found in ObservationDefinition.code. Not used for in vitro
   * diagnostic observations. Example: 14975008 |Forearm structure|.
   */
  public val bodySite: CodeableConcept? = null,
  /**
   * The method or technique used to perform the observation.
   *
   * Only used if not implicit in observation code Example: 702659008 |Automated count technique|.
   */
  public val method: CodeableConcept? = null,
  /**
   * The kind of specimen that this type of observation is produced on.
   *
   * Only used for in vitro observations. When multiple occurrences of specimen are present, they
   * are to be combined with a logical AND: all specified specimens are needed for the observation.
   */
  public val specimen: List<Reference> = listOf(),
  /**
   * The measurement model of device or actual device used to produce observations of this type.
   *
   * When multiple occurrences of device are present, they are to be combined with a logical OR: at
   * least one of the specified devices is used to produce the observation.
   */
  public val device: List<Reference> = listOf(),
  /**
   * The preferred name to be used when reporting the results of observations conforming to this
   * ObservationDefinition.
   */
  public val preferredReportName: String? = null,
  /**
   * Units allowed for the valueQuantity element in the instance observations conforming to this
   * ObservationDefinition.
   */
  public val permittedUnit: List<Coding> = listOf(),
  /**
   * A set of qualified values associated with a context and a set of conditions - provides a range
   * for quantitative and ordinal observations and a collection of value sets for qualitative
   * observations.
   */
  public val qualifiedValue: List<QualifiedValue> = listOf(),
  /**
   * This ObservationDefinition defines a group observation (e.g. a battery, a panel of tests, a set
   * of vital sign measurements) that includes the target as a member of the group.
   */
  public val hasMember: List<Reference> = listOf(),
  /**
   * Some observations have multiple component observations, expressed as separate code value pairs.
   */
  public val component: List<Component> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, code.toBuilder()).apply {
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
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        effectivePeriod = this@with.effectivePeriod?.toBuilder()
        derivedFromCanonical = this@with.derivedFromCanonical.map { it.toBuilder() }.toMutableList()
        derivedFromUri = this@with.derivedFromUri.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject.map { it.toBuilder() }.toMutableList()
        performerType = this@with.performerType?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        permittedDataType = this@with.permittedDataType.toMutableList()
        multipleResultsAllowed = this@with.multipleResultsAllowed?.toBuilder()
        bodySite = this@with.bodySite?.toBuilder()
        method = this@with.method?.toBuilder()
        specimen = this@with.specimen.map { it.toBuilder() }.toMutableList()
        device = this@with.device.map { it.toBuilder() }.toMutableList()
        preferredReportName = this@with.preferredReportName?.toBuilder()
        permittedUnit = this@with.permittedUnit.map { it.toBuilder() }.toMutableList()
        qualifiedValue = this@with.qualifiedValue.map { it.toBuilder() }.toMutableList()
        hasMember = this@with.hasMember.map { it.toBuilder() }.toMutableList()
        component = this@with.component.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * A set of qualified values associated with a context and a set of conditions - provides a range
   * for quantitative and ordinal observations and a collection of value sets for qualitative
   * observations.
   */
  @Serializable(with = ObservationDefinitionQualifiedValueSerializer::class)
  public data class QualifiedValue(
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
    /** A concept defining the context for this set of qualified values. */
    public val context: CodeableConcept? = null,
    /**
     * The target population this set of qualified values applies to.
     *
     * If this element is not present then the global population is assumed.
     */
    public val appliesTo: List<CodeableConcept> = listOf(),
    /** The gender this set of qualified values applies to. */
    public val gender: Enumeration<AdministrativeGender>? = null,
    /**
     * The age range this set of qualified values applies to.
     *
     * Some analytes vary greatly over age.
     */
    public val age: Range? = null,
    /** The gestational age this set of qualified values applies to. */
    public val gestationalAge: Range? = null,
    /** Text based condition for which the the set of qualified values is valid. */
    public val condition: String? = null,
    /**
     * The category of range of values for continuous or ordinal observations that match the
     * criteria of this set of qualified values.
     */
    public val rangeCategory: Enumeration<ObservationRangeCategory>? = null,
    /**
     * The range of values defined for continuous or ordinal observations that match the criteria of
     * this set of qualified values.
     */
    public val range: Range? = null,
    /**
     * The set of valid coded results for qualitative observations that match the criteria of this
     * set of qualified values.
     */
    public val validCodedValueSet: Canonical? = null,
    /**
     * The set of normal coded results for qualitative observations that match the criteria of this
     * set of qualified values.
     */
    public val normalCodedValueSet: Canonical? = null,
    /**
     * The set of abnormal coded results for qualitative observations that match the criteria of
     * this set of qualified values.
     */
    public val abnormalCodedValueSet: Canonical? = null,
    /**
     * The set of critical coded results for qualitative observations that match the criteria of
     * this set of qualified values.
     */
    public val criticalCodedValueSet: Canonical? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          context = this@with.context?.toBuilder()
          appliesTo = this@with.appliesTo.map { it.toBuilder() }.toMutableList()
          gender = this@with.gender
          age = this@with.age?.toBuilder()
          gestationalAge = this@with.gestationalAge?.toBuilder()
          condition = this@with.condition?.toBuilder()
          rangeCategory = this@with.rangeCategory
          range = this@with.range?.toBuilder()
          validCodedValueSet = this@with.validCodedValueSet?.toBuilder()
          normalCodedValueSet = this@with.normalCodedValueSet?.toBuilder()
          abnormalCodedValueSet = this@with.abnormalCodedValueSet?.toBuilder()
          criticalCodedValueSet = this@with.criticalCodedValueSet?.toBuilder()
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

      /** A concept defining the context for this set of qualified values. */
      public var context: CodeableConcept.Builder? = null

      /**
       * The target population this set of qualified values applies to.
       *
       * If this element is not present then the global population is assumed.
       */
      public var appliesTo: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The gender this set of qualified values applies to. */
      public var gender: Enumeration<AdministrativeGender>? = null

      /**
       * The age range this set of qualified values applies to.
       *
       * Some analytes vary greatly over age.
       */
      public var age: Range.Builder? = null

      /** The gestational age this set of qualified values applies to. */
      public var gestationalAge: Range.Builder? = null

      /** Text based condition for which the the set of qualified values is valid. */
      public var condition: String.Builder? = null

      /**
       * The category of range of values for continuous or ordinal observations that match the
       * criteria of this set of qualified values.
       */
      public var rangeCategory: Enumeration<ObservationRangeCategory>? = null

      /**
       * The range of values defined for continuous or ordinal observations that match the criteria
       * of this set of qualified values.
       */
      public var range: Range.Builder? = null

      /**
       * The set of valid coded results for qualitative observations that match the criteria of this
       * set of qualified values.
       */
      public var validCodedValueSet: Canonical.Builder? = null

      /**
       * The set of normal coded results for qualitative observations that match the criteria of
       * this set of qualified values.
       */
      public var normalCodedValueSet: Canonical.Builder? = null

      /**
       * The set of abnormal coded results for qualitative observations that match the criteria of
       * this set of qualified values.
       */
      public var abnormalCodedValueSet: Canonical.Builder? = null

      /**
       * The set of critical coded results for qualitative observations that match the criteria of
       * this set of qualified values.
       */
      public var criticalCodedValueSet: Canonical.Builder? = null

      public fun build(): QualifiedValue =
        QualifiedValue(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          context = context?.build(),
          appliesTo = appliesTo.map { it.build() },
          gender = gender,
          age = age?.build(),
          gestationalAge = gestationalAge?.build(),
          condition = condition?.build(),
          rangeCategory = rangeCategory,
          range = range?.build(),
          validCodedValueSet = validCodedValueSet?.build(),
          normalCodedValueSet = normalCodedValueSet?.build(),
          abnormalCodedValueSet = abnormalCodedValueSet?.build(),
          criticalCodedValueSet = criticalCodedValueSet?.build(),
        )
    }
  }

  /**
   * Some observations have multiple component observations, expressed as separate code value pairs.
   */
  @Serializable(with = ObservationDefinitionComponentSerializer::class)
  public data class Component(
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
    /** Describes what will be observed. */
    public val code: CodeableConcept,
    /**
     * The data types allowed for the value element of the instance of this component observations.
     */
    public val permittedDataType: List<Enumeration<ObservationDataType>> = listOf(),
    /**
     * Units allowed for the valueQuantity element in the instance observations conforming to this
     * ObservationDefinition.
     */
    public val permittedUnit: List<Coding> = listOf(),
    /**
     * A set of qualified values associated with a context and a set of conditions - provides a
     * range for quantitative and ordinal observations and a collection of value sets for
     * qualitative observations.
     */
    public val qualifiedValue: List<QualifiedValue> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          permittedDataType = this@with.permittedDataType.toMutableList()
          permittedUnit = this@with.permittedUnit.map { it.toBuilder() }.toMutableList()
          qualifiedValue = this@with.qualifiedValue.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Describes what will be observed. */
      public var code: CodeableConcept.Builder
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
       * The data types allowed for the value element of the instance of this component
       * observations.
       */
      public var permittedDataType: MutableList<Enumeration<ObservationDataType>> = mutableListOf()

      /**
       * Units allowed for the valueQuantity element in the instance observations conforming to this
       * ObservationDefinition.
       */
      public var permittedUnit: MutableList<Coding.Builder> = mutableListOf()

      /**
       * A set of qualified values associated with a context and a set of conditions - provides a
       * range for quantitative and ordinal observations and a collection of value sets for
       * qualitative observations.
       */
      public var qualifiedValue: MutableList<QualifiedValue.Builder> = mutableListOf()

      public fun build(): Component =
        Component(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.build(),
          permittedDataType = permittedDataType,
          permittedUnit = permittedUnit.map { it.build() },
          qualifiedValue = qualifiedValue.map { it.build() },
        )
    }
  }

  public sealed interface VersionAlgorithm {
    public fun asString(): String? = this as? String

    public fun asCoding(): Coding? = this as? Coding

    @JvmInline
    public value class String(public val `value`: dev.ohs.fhir.model.r5.String) : VersionAlgorithm

    @JvmInline
    public value class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : VersionAlgorithm

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
     * The current state of the ObservationDefinition.
     *
     * A nominal state-transition diagram can be found in the
     * [Definition pattern](definition.html#statemachine) documentation Unknown does not represent
     * "other" - one of the defined statuses must apply. Unknown is used when the authoring system
     * is not sure what the current status is.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var status: Enumeration<PublicationStatus>,
    /** Describes what will be observed. Sometimes this is called the observation "name". */
    public var code: CodeableConcept.Builder,
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
     * An absolute URL that is used to identify this ObservationDefinition when it is referenced in
     * a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally
     * unique, and SHOULD be an address at which this ObservationDefinition is (or will be)
     * published. The URL SHOULD include the major version of the ObservationDefinition. For more
     * information see Technical and Business Versions.
     *
     * Can be a urn:uuid: or a urn:oid:, but real http: addresses are preferred. This is the URI
     * that will be used when making canonical references to this resource.
     */
    public var url: Uri.Builder? = null

    /**
     * Business identifiers assigned to this ObservationDefinition. by the performer and/or other
     * systems. These identifiers remain constant as the resource is updated and propagates from
     * server to server.
     *
     * This is a business identifier, not a resource identifier. It is best practice for the
     * identifier to only appear on a single resource instance, however business practices may
     * occasionally dictate that multiple resource instances with the same identifier can exist -
     * possibly even with different resource types.
     */
    public var identifier: Identifier.Builder? = null

    /**
     * The identifier that is used to identify this version of the ObservationDefinition when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the ObservationDefinition author and is not expected to be globally unique. For example,
     * it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also
     * no expectation that versions are orderable.
     *
     * There may be multiple different instances of an observationDefinition that have the same
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
     * A natural language name identifying the ObservationDefinition. This name should be usable as
     * an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /** A short, descriptive, user-friendly title for the ObservationDefinition. */
    public var title: String.Builder? = null

    /**
     * A flag to indicate that this ObservationDefinition is authored for testing purposes (or
     * education/evaluation/marketing), and is not intended to be used for genuine usage.
     *
     * Allows filtering of ObservationDefinition that are appropriate for use vs. not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the ObservationDefinition was last significantly changed.
     * The date must change when the business version changes and it must change if the status code
     * changes. In addition, it should change when the substantive content of the
     * ObservationDefinition changes.
     *
     * The date is often not tracked until the resource is published, but may be present on draft
     * content. Note that this is not the same as the resource last-modified-date, since the
     * resource may be a secondary representation of the ObservationDefinition. Additional specific
     * dates may be added as extensions or be found by consulting Provenances associated with past
     * versions of the resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * Helps establish the "authority/credibility" of the ObservationDefinition. May also allow for
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
     * A free text natural language description of the ObservationDefinition from the consumer's
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
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate ObservationDefinition instances.
     *
     * When multiple usageContexts are specified, there is no expectation for whether all or any of
     * the contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A jurisdiction in which the ObservationDefinition is intended to be used.
     *
     * It may be possible for the ObservationDefinition to be used in jurisdictions other than those
     * for which it was originally designed or intended.
     *
     * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
     * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
     * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
     * useContext.valueCodeableConcept indicating the jurisdiction.)
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explains why this ObservationDefinition is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the ObservationDefinition. Rather it is for
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * ObservationDefinition.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * Copyright statement relating to the ObservationDefinition and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the
     * ObservationDefinition.
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
     * The period during which the ObservationDefinition content was or is planned to be effective.
     *
     * The effective period for an ObservationDefinition determines when the content is applicable
     * for usage and is independent of publication and review dates. For example, an observation
     * definition intended to be used for the year 2021 might be published in 2020.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * The canonical URL pointing to another FHIR-defined ObservationDefinition that is adhered to
     * in whole or in part by this definition.
     */
    public var derivedFromCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally-defined observation definition, guideline or other
     * definition that is adhered to in whole or in part by this definition.
     */
    public var derivedFromUri: MutableList<Uri.Builder> = mutableListOf()

    /**
     * A code that describes the intended kind of subject of Observation instances conforming to
     * this ObservationDefinition.
     *
     * Examples: person, animal, device, air, surface ….
     */
    public var subject: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The type of individual/organization/device that is expected to act upon instances of this
     * definition.
     */
    public var performerType: CodeableConcept.Builder? = null

    /**
     * A code that classifies the general type of observation.
     *
     * This element allows various categorization schemes based on the owner’s definition of the
     * category and effectively multiple categories can be used for one instance of
     * ObservationDefinition. The level of granularity is defined by the category concepts in the
     * value set.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The data types allowed for the value element of the instance observations conforming to this
     * ObservationDefinition.
     */
    public var permittedDataType: MutableList<Enumeration<ObservationDataType>> = mutableListOf()

    /**
     * Multiple results allowed for observations conforming to this ObservationDefinition.
     *
     * An example of observation allowing multiple results is "bacteria identified by culture".
     * Conversely, the measurement of a potassium level allows a single result.
     */
    public var multipleResultsAllowed: Boolean.Builder? = null

    /**
     * The site on the subject's body where the observation is to be made.
     *
     * Only used if the defined observation is to be made directly on a body part and if this body
     * part is not implied by code found in ObservationDefinition.code. Not used for in vitro
     * diagnostic observations. Example: 14975008 |Forearm structure|.
     */
    public var bodySite: CodeableConcept.Builder? = null

    /**
     * The method or technique used to perform the observation.
     *
     * Only used if not implicit in observation code Example: 702659008 |Automated count technique|.
     */
    public var method: CodeableConcept.Builder? = null

    /**
     * The kind of specimen that this type of observation is produced on.
     *
     * Only used for in vitro observations. When multiple occurrences of specimen are present, they
     * are to be combined with a logical AND: all specified specimens are needed for the
     * observation.
     */
    public var specimen: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The measurement model of device or actual device used to produce observations of this type.
     *
     * When multiple occurrences of device are present, they are to be combined with a logical OR:
     * at least one of the specified devices is used to produce the observation.
     */
    public var device: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The preferred name to be used when reporting the results of observations conforming to this
     * ObservationDefinition.
     */
    public var preferredReportName: String.Builder? = null

    /**
     * Units allowed for the valueQuantity element in the instance observations conforming to this
     * ObservationDefinition.
     */
    public var permittedUnit: MutableList<Coding.Builder> = mutableListOf()

    /**
     * A set of qualified values associated with a context and a set of conditions - provides a
     * range for quantitative and ordinal observations and a collection of value sets for
     * qualitative observations.
     */
    public var qualifiedValue: MutableList<QualifiedValue.Builder> = mutableListOf()

    /**
     * This ObservationDefinition defines a group observation (e.g. a battery, a panel of tests, a
     * set of vital sign measurements) that includes the target as a member of the group.
     */
    public var hasMember: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Some observations have multiple component observations, expressed as separate code value
     * pairs.
     */
    public var component: MutableList<Component.Builder> = mutableListOf()

    override fun build(): ObservationDefinition =
      ObservationDefinition(
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
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        derivedFromCanonical = derivedFromCanonical.map { it.build() },
        derivedFromUri = derivedFromUri.map { it.build() },
        subject = subject.map { it.build() },
        performerType = performerType?.build(),
        category = category.map { it.build() },
        code = code.build(),
        permittedDataType = permittedDataType,
        multipleResultsAllowed = multipleResultsAllowed?.build(),
        bodySite = bodySite?.build(),
        method = method?.build(),
        specimen = specimen.map { it.build() },
        device = device.map { it.build() },
        preferredReportName = preferredReportName?.build(),
        permittedUnit = permittedUnit.map { it.build() },
        qualifiedValue = qualifiedValue.map { it.build() },
        hasMember = hasMember.map { it.build() },
        component = component.map { it.build() },
      )
  }

  /** Codes identifying the category of observation range. */
  public enum class ObservationRangeCategory(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Reference("reference", "http://hl7.org/fhir/observation-range-category", "reference range"),
    Critical("critical", "http://hl7.org/fhir/observation-range-category", "critical range"),
    Absolute("absolute", "http://hl7.org/fhir/observation-range-category", "absolute range");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ObservationRangeCategory =
        when (code) {
          "reference" -> Reference
          "critical" -> Critical
          "absolute" -> Absolute
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ObservationRangeCategory")
        }
    }
  }

  /** Permitted data type for observation value. */
  public enum class ObservationDataType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Quantity("Quantity", "http://hl7.org/fhir/permitted-data-type", "Quantity"),
    CodeableConcept(
      "CodeableConcept",
      "http://hl7.org/fhir/permitted-data-type",
      "CodeableConcept",
    ),
    String("string", "http://hl7.org/fhir/permitted-data-type", "string"),
    Boolean("boolean", "http://hl7.org/fhir/permitted-data-type", "boolean"),
    Integer("integer", "http://hl7.org/fhir/permitted-data-type", "integer"),
    Range("Range", "http://hl7.org/fhir/permitted-data-type", "Range"),
    Ratio("Ratio", "http://hl7.org/fhir/permitted-data-type", "Ratio"),
    SampledData("SampledData", "http://hl7.org/fhir/permitted-data-type", "SampledData"),
    Time("time", "http://hl7.org/fhir/permitted-data-type", "time"),
    DateTime("dateTime", "http://hl7.org/fhir/permitted-data-type", "dateTime"),
    Period("Period", "http://hl7.org/fhir/permitted-data-type", "Period");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ObservationDataType =
        when (code) {
          "Quantity" -> Quantity
          "CodeableConcept" -> CodeableConcept
          "string" -> String
          "boolean" -> Boolean
          "integer" -> Integer
          "Range" -> Range
          "Ratio" -> Ratio
          "SampledData" -> SampledData
          "time" -> Time
          "dateTime" -> DateTime
          "Period" -> Period
          else -> throw IllegalArgumentException("Unknown code $code for enum ObservationDataType")
        }
    }
  }
}
