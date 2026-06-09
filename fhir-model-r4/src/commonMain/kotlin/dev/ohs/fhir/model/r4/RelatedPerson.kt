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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.RelatedPersonCommunicationSerializer
import dev.ohs.fhir.model.r4.serializers.RelatedPersonSerializer
import dev.ohs.fhir.model.r4.terminologies.AdministrativeGender
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a person that is involved in the care for a patient, but who is not the target
 * of healthcare, nor has a formal responsibility in the care process.
 */
@Serializable(with = RelatedPersonSerializer::class)
@SerialName("RelatedPerson")
public data class RelatedPerson(
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
  /** Identifier for a person within a particular scope. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Whether this related person record is in active use.
   *
   * This element is labeled as a modifier because it may be used to mark that the resource was
   * created in error.
   */
  public val active: Boolean? = null,
  /** The patient this person is related to. */
  public val patient: Reference,
  /** The nature of the relationship between a patient and the related person. */
  public val relationship: List<CodeableConcept> = listOf(),
  /** A name associated with the person. */
  public val name: List<HumanName> = listOf(),
  /**
   * A contact detail for the person, e.g. a telephone number or an email address.
   *
   * Person may have multiple ways to be contacted with different uses or applicable periods. May
   * need to have options for contacting the person urgently, and also to help with identification.
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * Administrative Gender - the gender that the person is considered to have for administration and
   * record keeping purposes.
   */
  public val gender: Enumeration<AdministrativeGender>? = null,
  /** The date on which the related person was born. */
  public val birthDate: Date? = null,
  /** Address where the related person can be contacted or visited. */
  public val address: List<Address> = listOf(),
  /** Image of the person. */
  public val photo: List<Attachment> = listOf(),
  /**
   * The period of time during which this relationship is or was active. If there are no dates
   * defined, then the interval is unknown.
   */
  public val period: Period? = null,
  /**
   * A language which may be used to communicate with about the patient's health.
   *
   * If no language is specified, this *implies* that the default local language is spoken. If you
   * need to convey proficiency for multiple modes, then you need multiple
   * RelatedPerson.Communication associations. If the RelatedPerson does not speak the default local
   * language, then the Interpreter Required Standard can be used to explicitly declare that an
   * interpreter is required.
   */
  public val communication: List<Communication> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(patient.toBuilder()).apply {
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
        relationship = this@with.relationship.map { it.toBuilder() }.toMutableList()
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
        gender = this@with.gender
        birthDate = this@with.birthDate?.toBuilder()
        address = this@with.address.map { it.toBuilder() }.toMutableList()
        photo = this@with.photo.map { it.toBuilder() }.toMutableList()
        period = this@with.period?.toBuilder()
        communication = this@with.communication.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A language which may be used to communicate with about the patient's health. */
  @Serializable(with = RelatedPersonCommunicationSerializer::class)
  public data class Communication(
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
    /**
     * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen
     * and the ISO-3166-1 alpha 2 code for the region in upper case; e.g. "en" for English, or
     * "en-US" for American English versus "en-EN" for England English.
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
       * "en-US" for American English versus "en-EN" for England English.
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

  public class Builder(
    /** The patient this person is related to. */
    public var patient: Reference.Builder
  ) : DomainResource.Builder() {
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

    /** Identifier for a person within a particular scope. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Whether this related person record is in active use.
     *
     * This element is labeled as a modifier because it may be used to mark that the resource was
     * created in error.
     */
    public var active: Boolean.Builder? = null

    /** The nature of the relationship between a patient and the related person. */
    public var relationship: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** A name associated with the person. */
    public var name: MutableList<HumanName.Builder> = mutableListOf()

    /**
     * A contact detail for the person, e.g. a telephone number or an email address.
     *
     * Person may have multiple ways to be contacted with different uses or applicable periods. May
     * need to have options for contacting the person urgently, and also to help with
     * identification.
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * Administrative Gender - the gender that the person is considered to have for administration
     * and record keeping purposes.
     */
    public var gender: Enumeration<AdministrativeGender>? = null

    /** The date on which the related person was born. */
    public var birthDate: Date.Builder? = null

    /** Address where the related person can be contacted or visited. */
    public var address: MutableList<Address.Builder> = mutableListOf()

    /** Image of the person. */
    public var photo: MutableList<Attachment.Builder> = mutableListOf()

    /**
     * The period of time during which this relationship is or was active. If there are no dates
     * defined, then the interval is unknown.
     */
    public var period: Period.Builder? = null

    /**
     * A language which may be used to communicate with about the patient's health.
     *
     * If no language is specified, this *implies* that the default local language is spoken. If you
     * need to convey proficiency for multiple modes, then you need multiple
     * RelatedPerson.Communication associations. If the RelatedPerson does not speak the default
     * local language, then the Interpreter Required Standard can be used to explicitly declare that
     * an interpreter is required.
     */
    public var communication: MutableList<Communication.Builder> = mutableListOf()

    override fun build(): RelatedPerson =
      RelatedPerson(
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
        patient = patient.build(),
        relationship = relationship.map { it.build() },
        name = name.map { it.build() },
        telecom = telecom.map { it.build() },
        gender = gender,
        birthDate = birthDate?.build(),
        address = address.map { it.build() },
        photo = photo.map { it.build() },
        period = period?.build(),
        communication = communication.map { it.build() },
      )
  }
}
