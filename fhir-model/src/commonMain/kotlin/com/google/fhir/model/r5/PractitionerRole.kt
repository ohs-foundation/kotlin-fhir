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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.serializers.PractitionerRoleSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has
 * performed at an organization during a period of time.
 */
@Serializable(with = PractitionerRoleSerializer::class)
@SerialName("PractitionerRole")
public data class PractitionerRole(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
   */
  override val id: String? = null,
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
   * Business Identifiers that are specific to a role/location.
   *
   * A specific identifier value (e.g. Minnesota Registration ID) may appear on multiple
   * PractitionerRole instances which could be for different periods, or different Roles (or other
   * reasons). A specific identifier may be included multiple times in the same PractitionerRole
   * instance with different identifier validity periods.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Whether this practitioner role record is in active use. Some systems may use this property to
   * mark non-active practitioners, such as those that are not currently employed.
   *
   * If this value is false, you may refer to the period to see when the role was in active use. If
   * there is no period specified, no inference can be made about when it was active.
   */
  public val active: Boolean? = null,
  /**
   * The period during which the person is authorized to act as a practitioner in these role(s) for
   * the organization.
   *
   * If a practitioner is performing a role within an organization over multiple, non-adjacent
   * periods, there should be a distinct PractitionerRole instance for each period. For example, if
   * a nurse is employed at a hospital, leaves the organization for a period of time due to pandemic
   * related stress, but returns post-pandemic to the same job role, there would be two
   * PractitionerRole instances for the different periods of employment.
   */
  public val period: Period? = null,
  /** Practitioner that is able to provide the defined services for the organization. */
  public val practitioner: Reference? = null,
  /** The organization where the Practitioner performs the roles associated. */
  public val organization: Reference? = null,
  /**
   * Roles which this practitioner is authorized to perform for the organization.
   *
   * A person may have more than one role.
   */
  public val code: List<CodeableConcept> = listOf(),
  /**
   * The specialty of a practitioner that describes the functional role they are practicing at a
   * given organization or location.
   *
   * The specialty represents the functional role a practitioner is playing within an
   * organization/location. This role may require the individual have certain qualifications, which
   * would be represented in the Practitioner.qualifications property. Note that qualifications may
   * or might not relate to or be required by the practicing specialty.
   */
  public val specialty: List<CodeableConcept> = listOf(),
  /** The location(s) at which this practitioner provides care. */
  public val location: List<Reference> = listOf(),
  /**
   * The list of healthcare services that this worker provides for this role's
   * Organization/Location(s).
   */
  public val healthcareService: List<Reference> = listOf(),
  /**
   * The contact details of communication devices available relevant to the specific
   * PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers, email
   * addresses and web sites.
   */
  public val contact: List<ExtendedContactDetail> = listOf(),
  /**
   * Collection of characteristics (attributes).
   *
   * These could be such things as is the service mode used by this role.
   */
  public val characteristic: List<CodeableConcept> = listOf(),
  /**
   * A language the practitioner can use in patient communication. The practitioner may know several
   * languages (listed in practitioner.communication), however these are the languages that could be
   * advertised in a directory for a patient to search.
   *
   * The structure aa-BB with this exact casing is one the most widely used notations for locale.
   * However not all systems code this but instead have it as free text. Hence CodeableConcept
   * instead of code as the data type.
   *
   * Note that for non-patient oriented communication, see Practitioner.communication. Note that all
   * 'person' type resources (Person, RelatedPerson, Patient, Practitioner) have a communication
   * structure that includes preferences. Role or service oriented resources such as
   * HealthcareService and PractitionerRole only include languages that are available for
   * interacting with patients.
   */
  public val communication: List<CodeableConcept> = listOf(),
  /**
   * A collection of times the practitioner is available or performing this role at the location
   * and/or healthcareservice.
   *
   * More detailed availability information may be provided in associated Schedule/Slot resources.
   *
   * Systems may choose to render availability differently than it is exchanged on the interface.
   * For example, rather than "Mon, Tue, Wed, Thur, Fri from 9am-12am; Mon, Tue, Wed, Thur, Fri from
   * 1pm-5pm" as would be implied by two availableTime repetitions, an application could render this
   * information as "Mon-Fri 9-12am and 1-5pm".
   *
   * The NotAvailableTime(s) included indicate the general days/periods where the practitioner is
   * not available (for things such as vacation time, or public holidays).
   */
  public val availability: List<Availability> = listOf(),
  /**
   * Technical endpoints providing access to services operated for the practitioner with this role.
   * Commonly used for locating scheduling services, or identifying where to send referrals
   * electronically.
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
        period = this@with.period?.toBuilder()
        practitioner = this@with.practitioner?.toBuilder()
        organization = this@with.organization?.toBuilder()
        code = this@with.code.map { it.toBuilder() }.toMutableList()
        specialty = this@with.specialty.map { it.toBuilder() }.toMutableList()
        location = this@with.location.map { it.toBuilder() }.toMutableList()
        healthcareService = this@with.healthcareService.map { it.toBuilder() }.toMutableList()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        characteristic = this@with.characteristic.map { it.toBuilder() }.toMutableList()
        communication = this@with.communication.map { it.toBuilder() }.toMutableList()
        availability = this@with.availability.map { it.toBuilder() }.toMutableList()
        endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
      }
    }

  public class Builder() : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    public var id: String? = null

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
     * Business Identifiers that are specific to a role/location.
     *
     * A specific identifier value (e.g. Minnesota Registration ID) may appear on multiple
     * PractitionerRole instances which could be for different periods, or different Roles (or other
     * reasons). A specific identifier may be included multiple times in the same PractitionerRole
     * instance with different identifier validity periods.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Whether this practitioner role record is in active use. Some systems may use this property to
     * mark non-active practitioners, such as those that are not currently employed.
     *
     * If this value is false, you may refer to the period to see when the role was in active use.
     * If there is no period specified, no inference can be made about when it was active.
     */
    public var active: Boolean.Builder? = null

    /**
     * The period during which the person is authorized to act as a practitioner in these role(s)
     * for the organization.
     *
     * If a practitioner is performing a role within an organization over multiple, non-adjacent
     * periods, there should be a distinct PractitionerRole instance for each period. For example,
     * if a nurse is employed at a hospital, leaves the organization for a period of time due to
     * pandemic related stress, but returns post-pandemic to the same job role, there would be two
     * PractitionerRole instances for the different periods of employment.
     */
    public var period: Period.Builder? = null

    /** Practitioner that is able to provide the defined services for the organization. */
    public var practitioner: Reference.Builder? = null

    /** The organization where the Practitioner performs the roles associated. */
    public var organization: Reference.Builder? = null

    /**
     * Roles which this practitioner is authorized to perform for the organization.
     *
     * A person may have more than one role.
     */
    public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The specialty of a practitioner that describes the functional role they are practicing at a
     * given organization or location.
     *
     * The specialty represents the functional role a practitioner is playing within an
     * organization/location. This role may require the individual have certain qualifications,
     * which would be represented in the Practitioner.qualifications property. Note that
     * qualifications may or might not relate to or be required by the practicing specialty.
     */
    public var specialty: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The location(s) at which this practitioner provides care. */
    public var location: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The list of healthcare services that this worker provides for this role's
     * Organization/Location(s).
     */
    public var healthcareService: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The contact details of communication devices available relevant to the specific
     * PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers,
     * email addresses and web sites.
     */
    public var contact: MutableList<ExtendedContactDetail.Builder> = mutableListOf()

    /**
     * Collection of characteristics (attributes).
     *
     * These could be such things as is the service mode used by this role.
     */
    public var characteristic: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A language the practitioner can use in patient communication. The practitioner may know
     * several languages (listed in practitioner.communication), however these are the languages
     * that could be advertised in a directory for a patient to search.
     *
     * The structure aa-BB with this exact casing is one the most widely used notations for locale.
     * However not all systems code this but instead have it as free text. Hence CodeableConcept
     * instead of code as the data type.
     *
     * Note that for non-patient oriented communication, see Practitioner.communication. Note that
     * all 'person' type resources (Person, RelatedPerson, Patient, Practitioner) have a
     * communication structure that includes preferences. Role or service oriented resources such as
     * HealthcareService and PractitionerRole only include languages that are available for
     * interacting with patients.
     */
    public var communication: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A collection of times the practitioner is available or performing this role at the location
     * and/or healthcareservice.
     *
     * More detailed availability information may be provided in associated Schedule/Slot resources.
     *
     * Systems may choose to render availability differently than it is exchanged on the interface.
     * For example, rather than "Mon, Tue, Wed, Thur, Fri from 9am-12am; Mon, Tue, Wed, Thur, Fri
     * from 1pm-5pm" as would be implied by two availableTime repetitions, an application could
     * render this information as "Mon-Fri 9-12am and 1-5pm".
     *
     * The NotAvailableTime(s) included indicate the general days/periods where the practitioner is
     * not available (for things such as vacation time, or public holidays).
     */
    public var availability: MutableList<Availability.Builder> = mutableListOf()

    /**
     * Technical endpoints providing access to services operated for the practitioner with this
     * role. Commonly used for locating scheduling services, or identifying where to send referrals
     * electronically.
     */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): PractitionerRole =
      PractitionerRole(
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
        period = period?.build(),
        practitioner = practitioner?.build(),
        organization = organization?.build(),
        code = code.map { it.build() },
        specialty = specialty.map { it.build() },
        location = location.map { it.build() },
        healthcareService = healthcareService.map { it.build() },
        contact = contact.map { it.build() },
        characteristic = characteristic.map { it.build() },
        communication = communication.map { it.build() },
        availability = availability.map { it.build() },
        endpoint = endpoint.map { it.build() },
      )
  }
}
