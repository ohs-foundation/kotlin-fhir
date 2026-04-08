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

import com.google.fhir.model.r5.serializers.PatientCommunicationSerializer
import com.google.fhir.model.r5.serializers.PatientContactSerializer
import com.google.fhir.model.r5.serializers.PatientDeceasedSerializer
import com.google.fhir.model.r5.serializers.PatientLinkSerializer
import com.google.fhir.model.r5.serializers.PatientMultipleBirthSerializer
import com.google.fhir.model.r5.serializers.PatientSerializer
import com.google.fhir.model.r5.terminologies.AdministrativeGender
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Demographics and other administrative information about an individual or animal receiving care or
 * other health-related services.
 */
@Serializable(with = PatientSerializer::class)
@SerialName("Patient")
public data class Patient(
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
  /** An identifier for this patient. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Whether this patient record is in active use. Many systems use this property to mark as
   * non-current patients, such as those that have not been seen for a period of time based on an
   * organization's business rules.
   *
   * It is often used to filter patient lists to exclude inactive patients
   *
   * Deceased patients may also be marked as inactive for the same reasons, but may be active for
   * some time after death.
   *
   * If a record is inactive, and linked to an active record, then future patient/record updates
   * should occur on the other patient.
   */
  public val active: Boolean? = null,
  /**
   * A name associated with the individual.
   *
   * A patient may have multiple names with different uses or applicable periods. For animals, the
   * name is a "HumanName" in the sense that is assigned and used by humans and has the same
   * patterns. Animal names may be communicated as given names, and optionally may include a family
   * name.
   */
  public val name: List<HumanName> = listOf(),
  /**
   * A contact detail (e.g. a telephone number or an email address) by which the individual may be
   * contacted.
   *
   * A Patient may have multiple ways to be contacted with different uses or applicable periods. May
   * need to have options for contacting the person urgently and also to help with identification.
   * The address might not go directly to the individual, but may reach another party that is able
   * to proxy for the patient (i.e. home phone, or pet owner's phone).
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * Administrative Gender - the gender that the patient is considered to have for administration
   * and record keeping purposes.
   *
   * The gender might not match the biological sex as determined by genetics or the individual's
   * preferred identification. Note that for both humans and particularly animals, there are other
   * legitimate possibilities than male and female, though the vast majority of systems and contexts
   * only support male and female. Systems providing decision support or enforcing business rules
   * should ideally do this on the basis of Observations dealing with the specific sex or gender
   * aspect of interest (anatomical, chromosomal, social, etc.) However, because these observations
   * are infrequently recorded, defaulting to the administrative gender is common practice. Where
   * such defaulting occurs, rule enforcement should allow for the variation between administrative
   * and biological, chromosomal and other gender aspects. For example, an alert about a
   * hysterectomy on a male should be handled as a warning or overridable error, not a "hard" error.
   * See the Patient Gender and Sex section for additional information about communicating patient
   * gender and sex.
   */
  public val gender: Enumeration<AdministrativeGender>? = null,
  /**
   * The date of birth for the individual.
   *
   * Partial dates are allowed if the specific date of birth is unknown. There is a standard
   * extension "patient-birthTime" available that should be used where Time is required (such as in
   * maternity/infant care systems).
   */
  public val birthDate: Date? = null,
  /**
   * Indicates if the individual is deceased or not.
   *
   * If there's no value in the instance, it means there is no statement on whether or not the
   * individual is deceased. Most systems will interpret the absence of a value as a sign of the
   * person being alive.
   */
  public val deceased: Deceased? = null,
  /**
   * An address for the individual.
   *
   * Patient may have multiple addresses with different uses or applicable periods.
   */
  public val address: List<Address> = listOf(),
  /** This field contains a patient's most recent marital (civil) status. */
  public val maritalStatus: CodeableConcept? = null,
  /**
   * Indicates whether the patient is part of a multiple (boolean) or indicates the actual birth
   * order (integer).
   *
   * Where the valueInteger is provided, the number is the birth number in the sequence. E.g. The
   * middle birth in triplets would be valueInteger=2 and the third born would have valueInteger=3
   * If a boolean value was provided for this triplets example, then all 3 patient records would
   * have valueBoolean=true (the ordering is not indicated).
   */
  public val multipleBirth: MultipleBirth? = null,
  /**
   * Image of the patient.
   *
   * Guidelines:
   * * Use id photos, not clinical photos.
   * * Limit dimensions to thumbnail.
   * * Keep byte count low to ease resource updates.
   */
  public val photo: List<Attachment> = listOf(),
  /**
   * A contact party (e.g. guardian, partner, friend) for the patient.
   *
   * Contact covers all kinds of contact parties: family members, business contacts, guardians,
   * caregivers. Not applicable to register pedigree and family ties beyond use of having contact.
   */
  public val contact: List<Contact> = listOf(),
  /**
   * A language which may be used to communicate with the patient about his or her health.
   *
   * If no language is specified, this *implies* that the default local language is spoken. If you
   * need to convey proficiency for multiple modes, then you need multiple Patient.Communication
   * associations. For animals, language is not a relevant field, and should be absent from the
   * instance. If the Patient does not speak the default local language, then the Interpreter
   * Required Standard can be used to explicitly declare that an interpreter is required.
   */
  public val communication: List<Communication> = listOf(),
  /**
   * Patient's nominated care provider.
   *
   * This may be the primary care provider (in a GP context), or it may be a patient nominated care
   * manager in a community/disability setting, or even organization that will provide people to
   * perform the care provider roles. It is not to be used to record Care Teams, these should be in
   * a CareTeam resource that may be linked to the CarePlan or EpisodeOfCare resources. Multiple GPs
   * may be recorded against the patient for various reasons, such as a student that has his home GP
   * listed along with the GP at university during the school semesters, or a "fly-in/fly-out"
   * worker that has the onsite GP also included with his home GP to remain aware of medical issues.
   *
   * Jurisdictions may decide that they can profile this down to 1 if desired, or 1 per type.
   */
  public val generalPractitioner: List<Reference> = listOf(),
  /**
   * Organization that is the custodian of the patient record.
   *
   * There is only one managing organization for a specific patient record. Other organizations will
   * have their own Patient record, and may use the Link property to join the records together (or a
   * Person resource which can include confidence ratings for the association).
   */
  public val managingOrganization: Reference? = null,
  /**
   * Link to a Patient or RelatedPerson resource that concerns the same actual individual.
   *
   * There is no assumption that linked patient records have mutual links.
   */
  public val link: List<Link> = listOf(),
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
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
        gender = this@with.gender
        birthDate = this@with.birthDate?.toBuilder()
        deceased = this@with.deceased
        address = this@with.address.map { it.toBuilder() }.toMutableList()
        maritalStatus = this@with.maritalStatus?.toBuilder()
        multipleBirth = this@with.multipleBirth
        photo = this@with.photo.map { it.toBuilder() }.toMutableList()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        communication = this@with.communication.map { it.toBuilder() }.toMutableList()
        generalPractitioner = this@with.generalPractitioner.map { it.toBuilder() }.toMutableList()
        managingOrganization = this@with.managingOrganization?.toBuilder()
        link = this@with.link.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A contact party (e.g. guardian, partner, friend) for the patient. */
  @Serializable(with = PatientContactSerializer::class)
  public data class Contact(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** The nature of the relationship between the patient and the contact person. */
    public val relationship: List<CodeableConcept> = listOf(),
    /** A name associated with the contact person. */
    public val name: HumanName? = null,
    /**
     * A contact detail for the person, e.g. a telephone number or an email address.
     *
     * Contact may have multiple ways to be contacted with different uses or applicable periods. May
     * need to have options for contacting the person urgently, and also to help with
     * identification.
     */
    public val telecom: List<ContactPoint> = listOf(),
    /** Address for the contact person. */
    public val address: Address? = null,
    /**
     * Administrative Gender - the gender that the contact person is considered to have for
     * administration and record keeping purposes.
     */
    public val gender: Enumeration<AdministrativeGender>? = null,
    /**
     * Organization on behalf of which the contact is acting or for which the contact is working.
     */
    public val organization: Reference? = null,
    /**
     * The period during which this contact person or organization is valid to be contacted relating
     * to this patient.
     */
    public val period: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          relationship = this@with.relationship.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
          address = this@with.address?.toBuilder()
          gender = this@with.gender
          organization = this@with.organization?.toBuilder()
          period = this@with.period?.toBuilder()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** The nature of the relationship between the patient and the contact person. */
      public var relationship: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A name associated with the contact person. */
      public var name: HumanName.Builder? = null

      /**
       * A contact detail for the person, e.g. a telephone number or an email address.
       *
       * Contact may have multiple ways to be contacted with different uses or applicable periods.
       * May need to have options for contacting the person urgently, and also to help with
       * identification.
       */
      public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

      /** Address for the contact person. */
      public var address: Address.Builder? = null

      /**
       * Administrative Gender - the gender that the contact person is considered to have for
       * administration and record keeping purposes.
       */
      public var gender: Enumeration<AdministrativeGender>? = null

      /**
       * Organization on behalf of which the contact is acting or for which the contact is working.
       */
      public var organization: Reference.Builder? = null

      /**
       * The period during which this contact person or organization is valid to be contacted
       * relating to this patient.
       */
      public var period: Period.Builder? = null

      public fun build(): Contact =
        Contact(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          relationship = relationship.map { it.build() },
          name = name?.build(),
          telecom = telecom.map { it.build() },
          address = address?.build(),
          gender = gender,
          organization = organization?.build(),
          period = period?.build(),
        )
    }
  }

  /** A language which may be used to communicate with the patient about his or her health. */
  @Serializable(with = PatientCommunicationSerializer::class)
  public data class Communication(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen
     * and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or
     * "en-US" for American English versus "en-AU" for Australian English.
     *
     * The structure aa-BB with this exact casing is one the most widely used notations for locale.
     * However not all systems actually code this but instead have it as free text. Hence
     * CodeableConcept instead of code as the data type.
     */
    public val language: CodeableConcept,
    /**
     * Indicates whether or not the patient prefers this language (over other languages he masters
     * up a certain level).
     *
     * This language is specifically identified for communicating healthcare information.
     */
    public val preferred: Boolean? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(language.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          preferred = this@with.preferred?.toBuilder()
        }
      }

    public class Builder(
      /**
       * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen
       * and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or
       * "en-US" for American English versus "en-AU" for Australian English.
       *
       * The structure aa-BB with this exact casing is one the most widely used notations for
       * locale. However not all systems actually code this but instead have it as free text. Hence
       * CodeableConcept instead of code as the data type.
       */
      public var language: CodeableConcept.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * Indicates whether or not the patient prefers this language (over other languages he masters
       * up a certain level).
       *
       * This language is specifically identified for communicating healthcare information.
       */
      public var preferred: Boolean.Builder? = null

      public fun build(): Communication =
        Communication(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          language = language.build(),
          preferred = preferred?.build(),
        )
    }
  }

  /** Link to a Patient or RelatedPerson resource that concerns the same actual individual. */
  @Serializable(with = PatientLinkSerializer::class)
  public data class Link(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * Link to a Patient or RelatedPerson resource that concerns the same actual individual.
     *
     * Referencing a RelatedPerson here removes the need to use a Person record to associate a
     * Patient and RelatedPerson as the same individual.
     */
    public val other: Reference,
    /** The type of link between this patient resource and another patient resource. */
    public val type: Enumeration<LinkType>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(other.toBuilder(), type).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Link to a Patient or RelatedPerson resource that concerns the same actual individual.
       *
       * Referencing a RelatedPerson here removes the need to use a Person record to associate a
       * Patient and RelatedPerson as the same individual.
       */
      public var other: Reference.Builder,
      /** The type of link between this patient resource and another patient resource. */
      public var type: Enumeration<LinkType>,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      public fun build(): Link =
        Link(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          other = other.build(),
          type = type,
        )
    }
  }

  @Serializable(with = PatientDeceasedSerializer::class)
  public sealed interface Deceased {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asDateTime(): DateTime? = this as? DateTime

    public data class Boolean(public val `value`: com.google.fhir.model.r5.Boolean) : Deceased

    public data class DateTime(public val `value`: com.google.fhir.model.r5.DateTime) : Deceased

    public companion object {
      internal fun from(
        booleanValue: com.google.fhir.model.r5.Boolean?,
        dateTimeValue: com.google.fhir.model.r5.DateTime?,
      ): Deceased? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        return null
      }
    }
  }

  @Serializable(with = PatientMultipleBirthSerializer::class)
  public sealed interface MultipleBirth {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asInteger(): Integer? = this as? Integer

    public data class Boolean(public val `value`: com.google.fhir.model.r5.Boolean) : MultipleBirth

    public data class Integer(public val `value`: com.google.fhir.model.r5.Integer) : MultipleBirth

    public companion object {
      internal fun from(
        booleanValue: com.google.fhir.model.r5.Boolean?,
        integerValue: com.google.fhir.model.r5.Integer?,
      ): MultipleBirth? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (integerValue != null) return Integer(integerValue)
        return null
      }
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

    /** An identifier for this patient. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Whether this patient record is in active use. Many systems use this property to mark as
     * non-current patients, such as those that have not been seen for a period of time based on an
     * organization's business rules.
     *
     * It is often used to filter patient lists to exclude inactive patients
     *
     * Deceased patients may also be marked as inactive for the same reasons, but may be active for
     * some time after death.
     *
     * If a record is inactive, and linked to an active record, then future patient/record updates
     * should occur on the other patient.
     */
    public var active: Boolean.Builder? = null

    /**
     * A name associated with the individual.
     *
     * A patient may have multiple names with different uses or applicable periods. For animals, the
     * name is a "HumanName" in the sense that is assigned and used by humans and has the same
     * patterns. Animal names may be communicated as given names, and optionally may include a
     * family name.
     */
    public var name: MutableList<HumanName.Builder> = mutableListOf()

    /**
     * A contact detail (e.g. a telephone number or an email address) by which the individual may be
     * contacted.
     *
     * A Patient may have multiple ways to be contacted with different uses or applicable periods.
     * May need to have options for contacting the person urgently and also to help with
     * identification. The address might not go directly to the individual, but may reach another
     * party that is able to proxy for the patient (i.e. home phone, or pet owner's phone).
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * Administrative Gender - the gender that the patient is considered to have for administration
     * and record keeping purposes.
     *
     * The gender might not match the biological sex as determined by genetics or the individual's
     * preferred identification. Note that for both humans and particularly animals, there are other
     * legitimate possibilities than male and female, though the vast majority of systems and
     * contexts only support male and female. Systems providing decision support or enforcing
     * business rules should ideally do this on the basis of Observations dealing with the specific
     * sex or gender aspect of interest (anatomical, chromosomal, social, etc.) However, because
     * these observations are infrequently recorded, defaulting to the administrative gender is
     * common practice. Where such defaulting occurs, rule enforcement should allow for the
     * variation between administrative and biological, chromosomal and other gender aspects. For
     * example, an alert about a hysterectomy on a male should be handled as a warning or
     * overridable error, not a "hard" error. See the Patient Gender and Sex section for additional
     * information about communicating patient gender and sex.
     */
    public var gender: Enumeration<AdministrativeGender>? = null

    /**
     * The date of birth for the individual.
     *
     * Partial dates are allowed if the specific date of birth is unknown. There is a standard
     * extension "patient-birthTime" available that should be used where Time is required (such as
     * in maternity/infant care systems).
     */
    public var birthDate: Date.Builder? = null

    /**
     * Indicates if the individual is deceased or not.
     *
     * If there's no value in the instance, it means there is no statement on whether or not the
     * individual is deceased. Most systems will interpret the absence of a value as a sign of the
     * person being alive.
     */
    public var deceased: Deceased? = null

    /**
     * An address for the individual.
     *
     * Patient may have multiple addresses with different uses or applicable periods.
     */
    public var address: MutableList<Address.Builder> = mutableListOf()

    /** This field contains a patient's most recent marital (civil) status. */
    public var maritalStatus: CodeableConcept.Builder? = null

    /**
     * Indicates whether the patient is part of a multiple (boolean) or indicates the actual birth
     * order (integer).
     *
     * Where the valueInteger is provided, the number is the birth number in the sequence. E.g. The
     * middle birth in triplets would be valueInteger=2 and the third born would have valueInteger=3
     * If a boolean value was provided for this triplets example, then all 3 patient records would
     * have valueBoolean=true (the ordering is not indicated).
     */
    public var multipleBirth: MultipleBirth? = null

    /**
     * Image of the patient.
     *
     * Guidelines:
     * * Use id photos, not clinical photos.
     * * Limit dimensions to thumbnail.
     * * Keep byte count low to ease resource updates.
     */
    public var photo: MutableList<Attachment.Builder> = mutableListOf()

    /**
     * A contact party (e.g. guardian, partner, friend) for the patient.
     *
     * Contact covers all kinds of contact parties: family members, business contacts, guardians,
     * caregivers. Not applicable to register pedigree and family ties beyond use of having contact.
     */
    public var contact: MutableList<Contact.Builder> = mutableListOf()

    /**
     * A language which may be used to communicate with the patient about his or her health.
     *
     * If no language is specified, this *implies* that the default local language is spoken. If you
     * need to convey proficiency for multiple modes, then you need multiple Patient.Communication
     * associations. For animals, language is not a relevant field, and should be absent from the
     * instance. If the Patient does not speak the default local language, then the Interpreter
     * Required Standard can be used to explicitly declare that an interpreter is required.
     */
    public var communication: MutableList<Communication.Builder> = mutableListOf()

    /**
     * Patient's nominated care provider.
     *
     * This may be the primary care provider (in a GP context), or it may be a patient nominated
     * care manager in a community/disability setting, or even organization that will provide people
     * to perform the care provider roles. It is not to be used to record Care Teams, these should
     * be in a CareTeam resource that may be linked to the CarePlan or EpisodeOfCare resources.
     * Multiple GPs may be recorded against the patient for various reasons, such as a student that
     * has his home GP listed along with the GP at university during the school semesters, or a
     * "fly-in/fly-out" worker that has the onsite GP also included with his home GP to remain aware
     * of medical issues.
     *
     * Jurisdictions may decide that they can profile this down to 1 if desired, or 1 per type.
     */
    public var generalPractitioner: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Organization that is the custodian of the patient record.
     *
     * There is only one managing organization for a specific patient record. Other organizations
     * will have their own Patient record, and may use the Link property to join the records
     * together (or a Person resource which can include confidence ratings for the association).
     */
    public var managingOrganization: Reference.Builder? = null

    /**
     * Link to a Patient or RelatedPerson resource that concerns the same actual individual.
     *
     * There is no assumption that linked patient records have mutual links.
     */
    public var link: MutableList<Link.Builder> = mutableListOf()

    override fun build(): Patient =
      Patient(
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
        name = name.map { it.build() },
        telecom = telecom.map { it.build() },
        gender = gender,
        birthDate = birthDate?.build(),
        deceased = deceased,
        address = address.map { it.build() },
        maritalStatus = maritalStatus?.build(),
        multipleBirth = multipleBirth,
        photo = photo.map { it.build() },
        contact = contact.map { it.build() },
        communication = communication.map { it.build() },
        generalPractitioner = generalPractitioner.map { it.build() },
        managingOrganization = managingOrganization?.build(),
        link = link.map { it.build() },
      )
  }

  /** The type of link between this Patient resource and another Patient/RelatedPerson resource. */
  public enum class LinkType(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Replaced_By("replaced-by", "http://hl7.org/fhir/link-type", "Replaced-by"),
    Replaces("replaces", "http://hl7.org/fhir/link-type", "Replaces"),
    Refer("refer", "http://hl7.org/fhir/link-type", "Refer"),
    Seealso("seealso", "http://hl7.org/fhir/link-type", "See also");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): LinkType =
        when (code) {
          "replaced-by" -> Replaced_By
          "replaces" -> Replaces
          "refer" -> Refer
          "seealso" -> Seealso
          else -> throw IllegalArgumentException("Unknown code $code for enum LinkType")
        }
    }
  }
}
