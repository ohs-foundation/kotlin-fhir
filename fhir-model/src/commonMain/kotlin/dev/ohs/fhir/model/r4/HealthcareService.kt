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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.HealthcareServiceAvailableTimeSerializer
import dev.ohs.fhir.model.r4.serializers.HealthcareServiceEligibilitySerializer
import dev.ohs.fhir.model.r4.serializers.HealthcareServiceNotAvailableSerializer
import dev.ohs.fhir.model.r4.serializers.HealthcareServiceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** The details of a healthcare service available at a location. */
@Serializable(with = HealthcareServiceSerializer::class)
@SerialName("HealthcareService")
public data class HealthcareService(
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
  /** External identifiers for this item. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * This flag is used to mark the record to not be used. This is not used when a center is closed
   * for maintenance, or for holidays, the notAvailable period is to be used for this.
   *
   * This element is labeled as a modifier because it may be used to mark that the resource was
   * created in error.
   */
  public val active: Boolean? = null,
  /**
   * The organization that provides this healthcare service.
   *
   * This property is recommended to be the same as the Location's managingOrganization, and if not
   * provided should be interpreted as such. If the Location does not have a managing Organization,
   * then this property should be populated.
   */
  public val providedBy: Reference? = null,
  /**
   * Identifies the broad category of service being performed or delivered.
   *
   * Selecting a Service Category then determines the list of relevant service types that can be
   * selected in the primary service type.
   */
  public val category: List<CodeableConcept> = listOf(),
  /** The specific type of service that may be delivered or performed. */
  public val type: List<CodeableConcept> = listOf(),
  /** Collection of specialties handled by the service site. This is more of a medical term. */
  public val specialty: List<CodeableConcept> = listOf(),
  /** The location(s) where this healthcare service may be provided. */
  public val location: List<Reference> = listOf(),
  /** Further description of the service as it would be presented to a consumer while searching. */
  public val name: String? = null,
  /**
   * Any additional description of the service and/or any specific issues not covered by the other
   * attributes, which can be displayed as further detail under the serviceName.
   *
   * Would expect that a user would not see this information on a search results, and it would only
   * be available when viewing the complete details of the service.
   */
  public val comment: String? = null,
  /** Extra details about the service that can't be placed in the other fields. */
  public val extraDetails: Markdown? = null,
  /**
   * If there is a photo/symbol associated with this HealthcareService, it may be included here to
   * facilitate quick identification of the service in a list.
   */
  public val photo: Attachment? = null,
  /**
   * List of contacts related to this specific healthcare service.
   *
   * If this is empty, then refer to the location's contacts.
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * The location(s) that this service is available to (not where the service is provided).
   *
   * The locations referenced by the coverage area can include both specific locations, including
   * areas, and also conceptual domains too (mode = kind), such as a physical area (tri-state area)
   * and some other attribute (covered by Example Care Organization). These types of Locations are
   * often not managed by any specific organization. This could also include generic locations such
   * as "in-home".
   */
  public val coverageArea: List<Reference> = listOf(),
  /**
   * The code(s) that detail the conditions under which the healthcare service is available/offered.
   *
   * The provision means being commissioned by, contractually obliged or financially sourced. Types
   * of costings that may apply to this healthcare service, such if the service may be available for
   * free, some discounts available, or fees apply.
   */
  public val serviceProvisionCode: List<CodeableConcept> = listOf(),
  /**
   * Does this service have specific eligibility requirements that need to be met in order to use
   * the service?
   */
  public val eligibility: List<Eligibility> = listOf(),
  /**
   * Programs that this service is applicable to.
   *
   * Programs are often defined externally to an Organization, commonly by governments; e.g. Home
   * and Community Care Programs, Homeless Program, ….
   */
  public val program: List<CodeableConcept> = listOf(),
  /**
   * Collection of characteristics (attributes).
   *
   * These could be such things as is wheelchair accessible.
   */
  public val characteristic: List<CodeableConcept> = listOf(),
  /**
   * Some services are specifically made available in multiple languages, this property permits a
   * directory to declare the languages this is offered in. Typically this is only provided where a
   * service operates in communities with mixed languages used.
   *
   * When using this property it indicates that the service is available with this language, it is
   * not derived from the practitioners, and not all are required to use this language, just that
   * this language is available while scheduling.
   */
  public val communication: List<CodeableConcept> = listOf(),
  /**
   * Ways that the service accepts referrals, if this is not provided then it is implied that no
   * referral is required.
   */
  public val referralMethod: List<CodeableConcept> = listOf(),
  /**
   * Indicates whether or not a prospective consumer will require an appointment for a particular
   * service at a site to be provided by the Organization. Indicates if an appointment is required
   * for access to this service.
   */
  public val appointmentRequired: Boolean? = null,
  /**
   * A collection of times that the Service Site is available.
   *
   * More detailed availability information may be provided in associated Schedule/Slot resources.
   */
  public val availableTime: List<AvailableTime> = listOf(),
  /**
   * The HealthcareService is not available during this period of time due to the provided reason.
   */
  public val notAvailable: List<NotAvailable> = listOf(),
  /**
   * A description of site availability exceptions, e.g. public holiday availability. Succinctly
   * describing all possible exceptions to normal site availability as details in the available
   * Times and not available Times.
   */
  public val availabilityExceptions: String? = null,
  /**
   * Technical endpoints providing access to services operated for the specific healthcare services
   * defined at this resource.
   */
  public val endpoint: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        active = this@with.active?.toBuilder()
        providedBy = this@with.providedBy?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        type = this@with.type.map { it.toBuilder() }.toMutableList()
        specialty = this@with.specialty.map { it.toBuilder() }.toMutableList()
        location = this@with.location.map { it.toBuilder() }.toMutableList()
        name = this@with.name?.toBuilder()
        comment = this@with.comment?.toBuilder()
        extraDetails = this@with.extraDetails?.toBuilder()
        photo = this@with.photo?.toBuilder()
        telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
        coverageArea = this@with.coverageArea.map { it.toBuilder() }.toMutableList()
        serviceProvisionCode = this@with.serviceProvisionCode.map { it.toBuilder() }.toMutableList()
        eligibility = this@with.eligibility.map { it.toBuilder() }.toMutableList()
        program = this@with.program.map { it.toBuilder() }.toMutableList()
        characteristic = this@with.characteristic.map { it.toBuilder() }.toMutableList()
        communication = this@with.communication.map { it.toBuilder() }.toMutableList()
        referralMethod = this@with.referralMethod.map { it.toBuilder() }.toMutableList()
        appointmentRequired = this@with.appointmentRequired?.toBuilder()
        availableTime = this@with.availableTime.map { it.toBuilder() }.toMutableList()
        notAvailable = this@with.notAvailable.map { it.toBuilder() }.toMutableList()
        availabilityExceptions = this@with.availabilityExceptions?.toBuilder()
        endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * Does this service have specific eligibility requirements that need to be met in order to use
   * the service?
   */
  @Serializable(with = HealthcareServiceEligibilitySerializer::class)
  public data class Eligibility(
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
    /** Coded value for the eligibility. */
    public val code: CodeableConcept? = null,
    /**
     * Describes the eligibility conditions for the service.
     *
     * The description of service eligibility should, in general, not exceed one or two paragraphs.
     * It should be sufficient for a prospective consumer to determine if they are likely to be
     * eligible or not. Where eligibility requirements and conditions are complex, it may simply be
     * noted that an eligibility assessment is required. Where eligibility is determined by an
     * outside source, such as an Act of Parliament, this should be noted, preferably with a
     * reference to a commonly available copy of the source document such as a web page.
     */
    public val comment: Markdown? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code?.toBuilder()
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

      /** Coded value for the eligibility. */
      public var code: CodeableConcept.Builder? = null

      /**
       * Describes the eligibility conditions for the service.
       *
       * The description of service eligibility should, in general, not exceed one or two
       * paragraphs. It should be sufficient for a prospective consumer to determine if they are
       * likely to be eligible or not. Where eligibility requirements and conditions are complex, it
       * may simply be noted that an eligibility assessment is required. Where eligibility is
       * determined by an outside source, such as an Act of Parliament, this should be noted,
       * preferably with a reference to a commonly available copy of the source document such as a
       * web page.
       */
      public var comment: Markdown.Builder? = null

      public fun build(): Eligibility =
        Eligibility(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code?.build(),
          comment = comment?.build(),
        )
    }
  }

  /** A collection of times that the Service Site is available. */
  @Serializable(with = HealthcareServiceAvailableTimeSerializer::class)
  public data class AvailableTime(
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
    /** Indicates which days of the week are available between the start and end Times. */
    public val daysOfWeek: List<Enumeration<DaysOfWeek>> = listOf(),
    /** Is this always available? (hence times are irrelevant) e.g. 24 hour service. */
    public val allDay: Boolean? = null,
    /**
     * The opening time of day. Note: If the AllDay flag is set, then this time is ignored.
     *
     * The time zone is expected to be for where this HealthcareService is provided at.
     */
    public val availableStartTime: Time? = null,
    /**
     * The closing time of day. Note: If the AllDay flag is set, then this time is ignored.
     *
     * The time zone is expected to be for where this HealthcareService is provided at.
     */
    public val availableEndTime: Time? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          daysOfWeek = this@with.daysOfWeek.toMutableList()
          allDay = this@with.allDay?.toBuilder()
          availableStartTime = this@with.availableStartTime?.toBuilder()
          availableEndTime = this@with.availableEndTime?.toBuilder()
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

      /** Indicates which days of the week are available between the start and end Times. */
      public var daysOfWeek: MutableList<Enumeration<DaysOfWeek>> = mutableListOf()

      /** Is this always available? (hence times are irrelevant) e.g. 24 hour service. */
      public var allDay: Boolean.Builder? = null

      /**
       * The opening time of day. Note: If the AllDay flag is set, then this time is ignored.
       *
       * The time zone is expected to be for where this HealthcareService is provided at.
       */
      public var availableStartTime: Time.Builder? = null

      /**
       * The closing time of day. Note: If the AllDay flag is set, then this time is ignored.
       *
       * The time zone is expected to be for where this HealthcareService is provided at.
       */
      public var availableEndTime: Time.Builder? = null

      public fun build(): AvailableTime =
        AvailableTime(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          daysOfWeek = daysOfWeek,
          allDay = allDay?.build(),
          availableStartTime = availableStartTime?.build(),
          availableEndTime = availableEndTime?.build(),
        )
    }
  }

  /**
   * The HealthcareService is not available during this period of time due to the provided reason.
   */
  @Serializable(with = HealthcareServiceNotAvailableSerializer::class)
  public data class NotAvailable(
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
    /** The reason that can be presented to the user as to why this time is not available. */
    public val description: String,
    /** Service is not available (seasonally or for a public holiday) from this date. */
    public val during: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(description.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          during = this@with.during?.toBuilder()
        }
      }

    public class Builder(
      /** The reason that can be presented to the user as to why this time is not available. */
      public var description: String.Builder
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

      /** Service is not available (seasonally or for a public holiday) from this date. */
      public var during: Period.Builder? = null

      public fun build(): NotAvailable =
        NotAvailable(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description.build(),
          during = during?.build(),
        )
    }
  }

  public class Builder() : DomainResource.Builder() {
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

    /** External identifiers for this item. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * This flag is used to mark the record to not be used. This is not used when a center is closed
     * for maintenance, or for holidays, the notAvailable period is to be used for this.
     *
     * This element is labeled as a modifier because it may be used to mark that the resource was
     * created in error.
     */
    public var active: Boolean.Builder? = null

    /**
     * The organization that provides this healthcare service.
     *
     * This property is recommended to be the same as the Location's managingOrganization, and if
     * not provided should be interpreted as such. If the Location does not have a managing
     * Organization, then this property should be populated.
     */
    public var providedBy: Reference.Builder? = null

    /**
     * Identifies the broad category of service being performed or delivered.
     *
     * Selecting a Service Category then determines the list of relevant service types that can be
     * selected in the primary service type.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The specific type of service that may be delivered or performed. */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Collection of specialties handled by the service site. This is more of a medical term. */
    public var specialty: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The location(s) where this healthcare service may be provided. */
    public var location: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Further description of the service as it would be presented to a consumer while searching.
     */
    public var name: String.Builder? = null

    /**
     * Any additional description of the service and/or any specific issues not covered by the other
     * attributes, which can be displayed as further detail under the serviceName.
     *
     * Would expect that a user would not see this information on a search results, and it would
     * only be available when viewing the complete details of the service.
     */
    public var comment: String.Builder? = null

    /** Extra details about the service that can't be placed in the other fields. */
    public var extraDetails: Markdown.Builder? = null

    /**
     * If there is a photo/symbol associated with this HealthcareService, it may be included here to
     * facilitate quick identification of the service in a list.
     */
    public var photo: Attachment.Builder? = null

    /**
     * List of contacts related to this specific healthcare service.
     *
     * If this is empty, then refer to the location's contacts.
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * The location(s) that this service is available to (not where the service is provided).
     *
     * The locations referenced by the coverage area can include both specific locations, including
     * areas, and also conceptual domains too (mode = kind), such as a physical area (tri-state
     * area) and some other attribute (covered by Example Care Organization). These types of
     * Locations are often not managed by any specific organization. This could also include generic
     * locations such as "in-home".
     */
    public var coverageArea: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The code(s) that detail the conditions under which the healthcare service is
     * available/offered.
     *
     * The provision means being commissioned by, contractually obliged or financially sourced.
     * Types of costings that may apply to this healthcare service, such if the service may be
     * available for free, some discounts available, or fees apply.
     */
    public var serviceProvisionCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Does this service have specific eligibility requirements that need to be met in order to use
     * the service?
     */
    public var eligibility: MutableList<Eligibility.Builder> = mutableListOf()

    /**
     * Programs that this service is applicable to.
     *
     * Programs are often defined externally to an Organization, commonly by governments; e.g. Home
     * and Community Care Programs, Homeless Program, ….
     */
    public var program: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Collection of characteristics (attributes).
     *
     * These could be such things as is wheelchair accessible.
     */
    public var characteristic: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Some services are specifically made available in multiple languages, this property permits a
     * directory to declare the languages this is offered in. Typically this is only provided where
     * a service operates in communities with mixed languages used.
     *
     * When using this property it indicates that the service is available with this language, it is
     * not derived from the practitioners, and not all are required to use this language, just that
     * this language is available while scheduling.
     */
    public var communication: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Ways that the service accepts referrals, if this is not provided then it is implied that no
     * referral is required.
     */
    public var referralMethod: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Indicates whether or not a prospective consumer will require an appointment for a particular
     * service at a site to be provided by the Organization. Indicates if an appointment is required
     * for access to this service.
     */
    public var appointmentRequired: Boolean.Builder? = null

    /**
     * A collection of times that the Service Site is available.
     *
     * More detailed availability information may be provided in associated Schedule/Slot resources.
     */
    public var availableTime: MutableList<AvailableTime.Builder> = mutableListOf()

    /**
     * The HealthcareService is not available during this period of time due to the provided reason.
     */
    public var notAvailable: MutableList<NotAvailable.Builder> = mutableListOf()

    /**
     * A description of site availability exceptions, e.g. public holiday availability. Succinctly
     * describing all possible exceptions to normal site availability as details in the available
     * Times and not available Times.
     */
    public var availabilityExceptions: String.Builder? = null

    /**
     * Technical endpoints providing access to services operated for the specific healthcare
     * services defined at this resource.
     */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): HealthcareService =
      HealthcareService(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        active = active?.build(),
        providedBy = providedBy?.build(),
        category = category.map { it.build() },
        type = type.map { it.build() },
        specialty = specialty.map { it.build() },
        location = location.map { it.build() },
        name = name?.build(),
        comment = comment?.build(),
        extraDetails = extraDetails?.build(),
        photo = photo?.build(),
        telecom = telecom.map { it.build() },
        coverageArea = coverageArea.map { it.build() },
        serviceProvisionCode = serviceProvisionCode.map { it.build() },
        eligibility = eligibility.map { it.build() },
        program = program.map { it.build() },
        characteristic = characteristic.map { it.build() },
        communication = communication.map { it.build() },
        referralMethod = referralMethod.map { it.build() },
        appointmentRequired = appointmentRequired?.build(),
        availableTime = availableTime.map { it.build() },
        notAvailable = notAvailable.map { it.build() },
        availabilityExceptions = availabilityExceptions?.build(),
        endpoint = endpoint.map { it.build() },
      )
  }

  /** The days of the week. */
  public enum class DaysOfWeek(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Mon("mon", "http://hl7.org/fhir/days-of-week", "Monday"),
    Tue("tue", "http://hl7.org/fhir/days-of-week", "Tuesday"),
    Wed("wed", "http://hl7.org/fhir/days-of-week", "Wednesday"),
    Thu("thu", "http://hl7.org/fhir/days-of-week", "Thursday"),
    Fri("fri", "http://hl7.org/fhir/days-of-week", "Friday"),
    Sat("sat", "http://hl7.org/fhir/days-of-week", "Saturday"),
    Sun("sun", "http://hl7.org/fhir/days-of-week", "Sunday");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DaysOfWeek =
        when (code) {
          "mon" -> Mon
          "tue" -> Tue
          "wed" -> Wed
          "thu" -> Thu
          "fri" -> Fri
          "sat" -> Sat
          "sun" -> Sun
          else -> throw IllegalArgumentException("Unknown code $code for enum DaysOfWeek")
        }
    }
  }
}
