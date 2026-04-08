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

import com.google.fhir.model.r5.serializers.PersonCommunicationSerializer
import com.google.fhir.model.r5.serializers.PersonDeceasedSerializer
import com.google.fhir.model.r5.serializers.PersonLinkSerializer
import com.google.fhir.model.r5.serializers.PersonSerializer
import com.google.fhir.model.r5.terminologies.AdministrativeGender
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Demographics and administrative information about a person independent of a specific
 * health-related context.
 */
@Serializable(with = PersonSerializer::class)
@SerialName("Person")
public data class Person(
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
  /** Identifier for a person within a particular scope. */
  public val identifier: List<Identifier> = listOf(),
  /** Whether this person's record is in active use. */
  public val active: Boolean? = null,
  /**
   * A name associated with the person.
   *
   * Person may have multiple names with different uses or applicable periods.
   */
  public val name: List<HumanName> = listOf(),
  /**
   * A contact detail for the person, e.g. a telephone number or an email address.
   *
   * Person may have multiple ways to be contacted with different uses or applicable periods. May
   * need to have options for contacting the person urgently and also to help with identification.
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * Administrative Gender.
   *
   * The gender might not match the biological sex as determined by genetics, or the individual's
   * preferred identification. Note that for both humans and particularly animals, there are other
   * legitimate possibilities than M and F, though a clear majority of systems and contexts only
   * support M and F.
   */
  public val gender: Enumeration<AdministrativeGender>? = null,
  /**
   * The birth date for the person.
   *
   * At least an estimated year should be provided as a guess if the real DOB is unknown.
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
   * One or more addresses for the person.
   *
   * Person may have multiple addresses with different uses or applicable periods.
   */
  public val address: List<Address> = listOf(),
  /**
   * This field contains a person's most recent marital (civil) status.
   *
   * Many countries maintain a register of births, deaths and marriages, and this would simplify
   * that interaction
   */
  public val maritalStatus: CodeableConcept? = null,
  /**
   * An image that can be displayed as a thumbnail of the person to enhance the identification of
   * the individual.
   */
  public val photo: List<Attachment> = listOf(),
  /**
   * A language which may be used to communicate with the person about his or her health.
   *
   * If no language is specified, this *implies* that the default local language is spoken. If you
   * need to convey proficiency for multiple modes, then you need multiple Person.Communication
   * associations. For animals, language is not a relevant field, and should be absent from the
   * instance. If the Patient does not speak the default local language, then the Interpreter
   * Required Standard can be used to explicitly declare that an interpreter is required.
   *
   * Note that this property should not be used to update any linked/logically linked practitioner
   * resources as it serves as a language that can be used to communicate with patients - however it
   * may be used to inform the value on practitioner, along with their role at the organization
   * (with the practitioner's permission)
   */
  public val communication: List<Communication> = listOf(),
  /** The organization that is the custodian of the person record. */
  public val managingOrganization: Reference? = null,
  /** Link to a resource that concerns the same actual person. */
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
        photo = this@with.photo.map { it.toBuilder() }.toMutableList()
        communication = this@with.communication.map { it.toBuilder() }.toMutableList()
        managingOrganization = this@with.managingOrganization?.toBuilder()
        link = this@with.link.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A language which may be used to communicate with the person about his or her health. */
  @Serializable(with = PersonCommunicationSerializer::class)
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
     * Indicates whether or not the person prefers this language (over other languages he masters up
     * a certain level).
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
       * Indicates whether or not the person prefers this language (over other languages he masters
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

  /** Link to a resource that concerns the same actual person. */
  @Serializable(with = PersonLinkSerializer::class)
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
    /** The resource to which this actual person is associated. */
    public val target: Reference,
    /** Level of assurance that this link is associated with the target resource. */
    public val assurance: Enumeration<IdentityAssuranceLevel>? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(target.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          assurance = this@with.assurance
        }
      }

    public class Builder(
      /** The resource to which this actual person is associated. */
      public var target: Reference.Builder
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

      /** Level of assurance that this link is associated with the target resource. */
      public var assurance: Enumeration<IdentityAssuranceLevel>? = null

      public fun build(): Link =
        Link(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          target = target.build(),
          assurance = assurance,
        )
    }
  }

  @Serializable(with = PersonDeceasedSerializer::class)
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

    /** Identifier for a person within a particular scope. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Whether this person's record is in active use. */
    public var active: Boolean.Builder? = null

    /**
     * A name associated with the person.
     *
     * Person may have multiple names with different uses or applicable periods.
     */
    public var name: MutableList<HumanName.Builder> = mutableListOf()

    /**
     * A contact detail for the person, e.g. a telephone number or an email address.
     *
     * Person may have multiple ways to be contacted with different uses or applicable periods. May
     * need to have options for contacting the person urgently and also to help with identification.
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * Administrative Gender.
     *
     * The gender might not match the biological sex as determined by genetics, or the individual's
     * preferred identification. Note that for both humans and particularly animals, there are other
     * legitimate possibilities than M and F, though a clear majority of systems and contexts only
     * support M and F.
     */
    public var gender: Enumeration<AdministrativeGender>? = null

    /**
     * The birth date for the person.
     *
     * At least an estimated year should be provided as a guess if the real DOB is unknown.
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
     * One or more addresses for the person.
     *
     * Person may have multiple addresses with different uses or applicable periods.
     */
    public var address: MutableList<Address.Builder> = mutableListOf()

    /**
     * This field contains a person's most recent marital (civil) status.
     *
     * Many countries maintain a register of births, deaths and marriages, and this would simplify
     * that interaction
     */
    public var maritalStatus: CodeableConcept.Builder? = null

    /**
     * An image that can be displayed as a thumbnail of the person to enhance the identification of
     * the individual.
     */
    public var photo: MutableList<Attachment.Builder> = mutableListOf()

    /**
     * A language which may be used to communicate with the person about his or her health.
     *
     * If no language is specified, this *implies* that the default local language is spoken. If you
     * need to convey proficiency for multiple modes, then you need multiple Person.Communication
     * associations. For animals, language is not a relevant field, and should be absent from the
     * instance. If the Patient does not speak the default local language, then the Interpreter
     * Required Standard can be used to explicitly declare that an interpreter is required.
     *
     * Note that this property should not be used to update any linked/logically linked practitioner
     * resources as it serves as a language that can be used to communicate with patients - however
     * it may be used to inform the value on practitioner, along with their role at the organization
     * (with the practitioner's permission)
     */
    public var communication: MutableList<Communication.Builder> = mutableListOf()

    /** The organization that is the custodian of the person record. */
    public var managingOrganization: Reference.Builder? = null

    /** Link to a resource that concerns the same actual person. */
    public var link: MutableList<Link.Builder> = mutableListOf()

    override fun build(): Person =
      Person(
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
        photo = photo.map { it.build() },
        communication = communication.map { it.build() },
        managingOrganization = managingOrganization?.build(),
        link = link.map { it.build() },
      )
  }

  /**
   * The level of confidence that this link represents the same actual person, based on NIST
   * Authentication Levels.
   */
  public enum class IdentityAssuranceLevel(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Level1("level1", "http://hl7.org/fhir/identity-assuranceLevel", "Level 1"),
    Level2("level2", "http://hl7.org/fhir/identity-assuranceLevel", "Level 2"),
    Level3("level3", "http://hl7.org/fhir/identity-assuranceLevel", "Level 3"),
    Level4("level4", "http://hl7.org/fhir/identity-assuranceLevel", "Level 4");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): IdentityAssuranceLevel =
        when (code) {
          "level1" -> Level1
          "level2" -> Level2
          "level3" -> Level3
          "level4" -> Level4
          else ->
            throw IllegalArgumentException("Unknown code $code for enum IdentityAssuranceLevel")
        }
    }
  }
}
