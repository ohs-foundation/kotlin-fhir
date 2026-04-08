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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.PractitionerQualificationSerializer
import com.google.fhir.model.r4.serializers.PractitionerSerializer
import com.google.fhir.model.r4.terminologies.AdministrativeGender
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A person who is directly or indirectly involved in the provisioning of healthcare. */
@Serializable(with = PractitionerSerializer::class)
@SerialName("Practitioner")
public data class Practitioner(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
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
  /** An identifier that applies to this person in this role. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Whether this practitioner's record is in active use.
   *
   * If the practitioner is not in use by one organization, then it should mark the period on the
   * PractitonerRole with an end date (even if they are active) as they may be active in another
   * role.
   */
  public val active: Boolean? = null,
  /**
   * The name(s) associated with the practitioner.
   *
   * The selection of the use property should ensure that there is a single usual name specified,
   * and others use the nickname (alias), old, or other values as appropriate.
   *
   * In general, select the value to be used in the ResourceReference.display based on this:
   * 1. There is more than 1 name
   * 2. Use = usual
   * 3. Period is current to the date of the usage
   * 4. Use = official
   * 5. Other order as decided by internal business rules.
   */
  public val name: List<HumanName> = listOf(),
  /**
   * A contact detail for the practitioner, e.g. a telephone number or an email address.
   *
   * Person may have multiple ways to be contacted with different uses or applicable periods. May
   * need to have options for contacting the person urgently and to help with identification. These
   * typically will have home numbers, or mobile numbers that are not role specific.
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * Address(es) of the practitioner that are not role specific (typically home address). Work
   * addresses are not typically entered in this property as they are usually role dependent.
   *
   * The PractitionerRole does not have an address value on it, as it is expected that the location
   * property be used for this purpose (which has an address).
   */
  public val address: List<Address> = listOf(),
  /**
   * Administrative Gender - the gender that the person is considered to have for administration and
   * record keeping purposes.
   */
  public val gender: Enumeration<AdministrativeGender>? = null,
  /** The date of birth for the practitioner. */
  public val birthDate: Date? = null,
  /** Image of the person. */
  public val photo: List<Attachment> = listOf(),
  /**
   * The official certifications, training, and licenses that authorize or otherwise pertain to the
   * provision of care by the practitioner. For example, a medical license issued by a medical board
   * authorizing the practitioner to practice medicine within a certian locality.
   */
  public val qualification: List<Qualification> = listOf(),
  /**
   * A language the practitioner can use in patient communication.
   *
   * The structure aa-BB with this exact casing is one the most widely used notations for locale.
   * However not all systems code this but instead have it as free text. Hence CodeableConcept
   * instead of code as the data type.
   */
  public val communication: List<CodeableConcept> = listOf(),
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
        address = this@with.address.map { it.toBuilder() }.toMutableList()
        gender = this@with.gender
        birthDate = this@with.birthDate?.toBuilder()
        photo = this@with.photo.map { it.toBuilder() }.toMutableList()
        qualification = this@with.qualification.map { it.toBuilder() }.toMutableList()
        communication = this@with.communication.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * The official certifications, training, and licenses that authorize or otherwise pertain to the
   * provision of care by the practitioner. For example, a medical license issued by a medical board
   * authorizing the practitioner to practice medicine within a certian locality.
   */
  @Serializable(with = PractitionerQualificationSerializer::class)
  public data class Qualification(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** An identifier that applies to this person's qualification in this role. */
    public val identifier: List<Identifier> = listOf(),
    /** Coded representation of the qualification. */
    public val code: CodeableConcept,
    /** Period during which the qualification is valid. */
    public val period: Period? = null,
    /** Organization that regulates and issues the qualification. */
    public val issuer: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          period = this@with.period?.toBuilder()
          issuer = this@with.issuer?.toBuilder()
        }
      }

    public class Builder(
      /** Coded representation of the qualification. */
      public var code: CodeableConcept.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** An identifier that applies to this person's qualification in this role. */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** Period during which the qualification is valid. */
      public var period: Period.Builder? = null

      /** Organization that regulates and issues the qualification. */
      public var issuer: Reference.Builder? = null

      public fun build(): Qualification =
        Qualification(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier.map { it.build() },
          code = code.build(),
          period = period?.build(),
          issuer = issuer?.build(),
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

    /** An identifier that applies to this person in this role. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Whether this practitioner's record is in active use.
     *
     * If the practitioner is not in use by one organization, then it should mark the period on the
     * PractitonerRole with an end date (even if they are active) as they may be active in another
     * role.
     */
    public var active: Boolean.Builder? = null

    /**
     * The name(s) associated with the practitioner.
     *
     * The selection of the use property should ensure that there is a single usual name specified,
     * and others use the nickname (alias), old, or other values as appropriate.
     *
     * In general, select the value to be used in the ResourceReference.display based on this:
     * 1. There is more than 1 name
     * 2. Use = usual
     * 3. Period is current to the date of the usage
     * 4. Use = official
     * 5. Other order as decided by internal business rules.
     */
    public var name: MutableList<HumanName.Builder> = mutableListOf()

    /**
     * A contact detail for the practitioner, e.g. a telephone number or an email address.
     *
     * Person may have multiple ways to be contacted with different uses or applicable periods. May
     * need to have options for contacting the person urgently and to help with identification.
     * These typically will have home numbers, or mobile numbers that are not role specific.
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * Address(es) of the practitioner that are not role specific (typically home address). Work
     * addresses are not typically entered in this property as they are usually role dependent.
     *
     * The PractitionerRole does not have an address value on it, as it is expected that the
     * location property be used for this purpose (which has an address).
     */
    public var address: MutableList<Address.Builder> = mutableListOf()

    /**
     * Administrative Gender - the gender that the person is considered to have for administration
     * and record keeping purposes.
     */
    public var gender: Enumeration<AdministrativeGender>? = null

    /** The date of birth for the practitioner. */
    public var birthDate: Date.Builder? = null

    /** Image of the person. */
    public var photo: MutableList<Attachment.Builder> = mutableListOf()

    /**
     * The official certifications, training, and licenses that authorize or otherwise pertain to
     * the provision of care by the practitioner. For example, a medical license issued by a medical
     * board authorizing the practitioner to practice medicine within a certian locality.
     */
    public var qualification: MutableList<Qualification.Builder> = mutableListOf()

    /**
     * A language the practitioner can use in patient communication.
     *
     * The structure aa-BB with this exact casing is one the most widely used notations for locale.
     * However not all systems code this but instead have it as free text. Hence CodeableConcept
     * instead of code as the data type.
     */
    public var communication: MutableList<CodeableConcept.Builder> = mutableListOf()

    override fun build(): Practitioner =
      Practitioner(
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
        address = address.map { it.build() },
        gender = gender,
        birthDate = birthDate?.build(),
        photo = photo.map { it.build() },
        qualification = qualification.map { it.build() },
        communication = communication.map { it.build() },
      )
  }
}
