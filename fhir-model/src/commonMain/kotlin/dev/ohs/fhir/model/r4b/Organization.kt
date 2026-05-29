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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.OrganizationContactSerializer
import dev.ohs.fhir.model.r4b.serializers.OrganizationSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A formally or informally recognized grouping of people or organizations formed for the purpose of
 * achieving some form of collective action. Includes companies, institutions, corporations,
 * departments, community groups, healthcare practice groups, payer/insurer, etc.
 */
@Serializable(with = OrganizationSerializer::class)
@SerialName("Organization")
public data class Organization(
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
   * Identifier for the organization that is used to identify the organization across multiple
   * disparate systems.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Whether the organization's record is still in active use.
   *
   * This active flag is not intended to be used to mark an organization as temporarily closed or
   * under construction. Instead the Location(s) within the Organization should have the suspended
   * status. If further details of the reason for the suspension are required, then an extension on
   * this element should be used.
   *
   * This element is labeled as a modifier because it may be used to mark that the resource was
   * created in error.
   */
  public val active: Boolean? = null,
  /**
   * The kind(s) of organization that this is.
   *
   * Organizations can be corporations, wards, sections, clinical teams, government departments,
   * etc. Note that code is generally a classifier of the type of organization; in many
   * applications, codes are used to identity a particular organization (say, ward) as opposed to
   * another of the same type - these are identifiers, not codes
   *
   * When considering if multiple types are appropriate, you should evaluate if child organizations
   * would be a more appropriate use of the concept, as different types likely are in different
   * sub-areas of the organization. This is most likely to be used where type values have orthogonal
   * values, such as a religious, academic and medical center.
   *
   * We expect that some jurisdictions will profile this optionality to be a single cardinality.
   */
  public val type: List<CodeableConcept> = listOf(),
  /**
   * A name associated with the organization.
   *
   * If the name of an organization changes, consider putting the old name in the alias column so
   * that it can still be located through searches.
   */
  public val name: String? = null,
  /**
   * A list of alternate names that the organization is known as, or was known as in the past.
   *
   * There are no dates associated with the alias/historic names, as this is not intended to track
   * when names were used, but to assist in searching so that older names can still result in
   * identifying the organization.
   */
  public val alias: List<String> = listOf(),
  /**
   * A contact detail for the organization.
   *
   * The use code 'home' is not to be used. Note that these contacts are not the contact details of
   * people who are employed by or represent the organization, but official contacts for the
   * organization itself.
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * An address for the organization.
   *
   * Organization may have multiple addresses with different uses or applicable periods. The use
   * code 'home' is not to be used.
   */
  public val address: List<Address> = listOf(),
  /** The organization of which this organization forms a part. */
  public val partOf: Reference? = null,
  /**
   * Contact for the organization for a certain purpose.
   *
   * Where multiple contacts for the same purpose are provided there is a standard extension that
   * can be used to determine which one is the preferred contact to use.
   */
  public val contact: List<Contact> = listOf(),
  /** Technical endpoints providing access to services operated for the organization. */
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
        type = this@with.type.map { it.toBuilder() }.toMutableList()
        name = this@with.name?.toBuilder()
        alias = this@with.alias.map { it.toBuilder() }.toMutableList()
        telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
        address = this@with.address.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Contact for the organization for a certain purpose. */
  @Serializable(with = OrganizationContactSerializer::class)
  public data class Contact(
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
    /** Indicates a purpose for which the contact can be reached. */
    public val purpose: CodeableConcept? = null,
    /** A name associated with the contact. */
    public val name: HumanName? = null,
    /**
     * A contact detail (e.g. a telephone number or an email address) by which the party may be
     * contacted.
     */
    public val telecom: List<ContactPoint> = listOf(),
    /** Visiting or postal addresses for the contact. */
    public val address: Address? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          purpose = this@with.purpose?.toBuilder()
          name = this@with.name?.toBuilder()
          telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
          address = this@with.address?.toBuilder()
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

      /** Indicates a purpose for which the contact can be reached. */
      public var purpose: CodeableConcept.Builder? = null

      /** A name associated with the contact. */
      public var name: HumanName.Builder? = null

      /**
       * A contact detail (e.g. a telephone number or an email address) by which the party may be
       * contacted.
       */
      public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

      /** Visiting or postal addresses for the contact. */
      public var address: Address.Builder? = null

      public fun build(): Contact =
        Contact(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          purpose = purpose?.build(),
          name = name?.build(),
          telecom = telecom.map { it.build() },
          address = address?.build(),
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

    /**
     * Identifier for the organization that is used to identify the organization across multiple
     * disparate systems.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Whether the organization's record is still in active use.
     *
     * This active flag is not intended to be used to mark an organization as temporarily closed or
     * under construction. Instead the Location(s) within the Organization should have the suspended
     * status. If further details of the reason for the suspension are required, then an extension
     * on this element should be used.
     *
     * This element is labeled as a modifier because it may be used to mark that the resource was
     * created in error.
     */
    public var active: Boolean.Builder? = null

    /**
     * The kind(s) of organization that this is.
     *
     * Organizations can be corporations, wards, sections, clinical teams, government departments,
     * etc. Note that code is generally a classifier of the type of organization; in many
     * applications, codes are used to identity a particular organization (say, ward) as opposed to
     * another of the same type - these are identifiers, not codes
     *
     * When considering if multiple types are appropriate, you should evaluate if child
     * organizations would be a more appropriate use of the concept, as different types likely are
     * in different sub-areas of the organization. This is most likely to be used where type values
     * have orthogonal values, such as a religious, academic and medical center.
     *
     * We expect that some jurisdictions will profile this optionality to be a single cardinality.
     */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A name associated with the organization.
     *
     * If the name of an organization changes, consider putting the old name in the alias column so
     * that it can still be located through searches.
     */
    public var name: String.Builder? = null

    /**
     * A list of alternate names that the organization is known as, or was known as in the past.
     *
     * There are no dates associated with the alias/historic names, as this is not intended to track
     * when names were used, but to assist in searching so that older names can still result in
     * identifying the organization.
     */
    public var alias: MutableList<String.Builder> = mutableListOf()

    /**
     * A contact detail for the organization.
     *
     * The use code 'home' is not to be used. Note that these contacts are not the contact details
     * of people who are employed by or represent the organization, but official contacts for the
     * organization itself.
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * An address for the organization.
     *
     * Organization may have multiple addresses with different uses or applicable periods. The use
     * code 'home' is not to be used.
     */
    public var address: MutableList<Address.Builder> = mutableListOf()

    /** The organization of which this organization forms a part. */
    public var partOf: Reference.Builder? = null

    /**
     * Contact for the organization for a certain purpose.
     *
     * Where multiple contacts for the same purpose are provided there is a standard extension that
     * can be used to determine which one is the preferred contact to use.
     */
    public var contact: MutableList<Contact.Builder> = mutableListOf()

    /** Technical endpoints providing access to services operated for the organization. */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): Organization =
      Organization(
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
        type = type.map { it.build() },
        name = name?.build(),
        alias = alias.map { it.build() },
        telecom = telecom.map { it.build() },
        address = address.map { it.build() },
        partOf = partOf?.build(),
        contact = contact.map { it.build() },
        endpoint = endpoint.map { it.build() },
      )
  }
}
