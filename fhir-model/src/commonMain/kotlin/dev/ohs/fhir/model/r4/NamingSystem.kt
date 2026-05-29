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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.NamingSystemSerializer
import dev.ohs.fhir.model.r4.serializers.NamingSystemUniqueIdSerializer
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A curated namespace that issues unique symbols within that namespace for the identification of
 * concepts, people, devices, etc. Represents a "System" used within the Identifier and Coding data
 * types.
 */
@Serializable(with = NamingSystemSerializer::class)
@SerialName("NamingSystem")
public data class NamingSystem(
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
   * A natural language name identifying the naming system. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.The"symbolic name" for an OID would be
   * captured as an extension.
   */
  public val name: String,
  /**
   * The status of this naming system. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of naming systems that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /** Indicates the purpose for the naming system - what kinds of things does it make unique? */
  public val kind: Enumeration<NamingSystemType>,
  /**
   * The date (and optionally time) when the naming system was published. The date must change when
   * the business version changes and it must change if the status code changes. In addition, it
   * should change when the substantive content of the naming system changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the naming system. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime,
  /**
   * The name of the organization or individual that published the naming system.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the naming
   * system is the organization or individual primarily responsible for the maintenance and upkeep
   * of the naming system. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the naming system. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * The name of the organization that is responsible for issuing identifiers or codes for this
   * namespace and ensuring their non-collision.
   *
   * This is the primary organization. Responsibility for some aspects of a namespace may be
   * delegated.
   */
  public val responsible: String? = null,
  /**
   * Categorizes a naming system for easier search by grouping related naming systems.
   *
   * This will most commonly be used for identifier namespaces, but categories could potentially be
   * useful for code systems and authorities as well.
   */
  public val type: CodeableConcept? = null,
  /**
   * A free text natural language description of the naming system from a consumer's perspective.
   * Details about what the namespace identifies including scope, granularity, version labeling,
   * etc.
   *
   * This description can be used to capture details such as why the naming system was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the naming system as conveyed in
   * the 'text' field of the resource itself. This item SHOULD be populated unless the information
   * is available from context (e.g. the language of the naming system is presumed to be the
   * predominant language in the place the naming system was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate naming system instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the naming system is intended to be used.
   *
   * It may be possible for the naming system to be used in jurisdictions other than those for which
   * it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Provides guidance on the use of the namespace, including the handling of formatting characters,
   * use of upper vs. lower case, etc.
   */
  public val usage: String? = null,
  /**
   * Indicates how the system may be identified when referenced in electronic exchange.
   *
   * Multiple identifiers may exist, either due to duplicate registration, regional rules, needs of
   * different communication technologies, etc.
   */
  public val uniqueId: List<UniqueId>,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          name.toBuilder(),
          status,
          kind,
          date.toBuilder(),
          uniqueId.map { it.toBuilder() }.toMutableList(),
        )
        .apply {
          id = this@with.id
          meta = this@with.meta?.toBuilder()
          implicitRules = this@with.implicitRules?.toBuilder()
          language = this@with.language?.toBuilder()
          text = this@with.text?.toBuilder()
          contained = this@with.contained.map { it.toBuilder() }.toMutableList()
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          responsible = this@with.responsible?.toBuilder()
          type = this@with.type?.toBuilder()
          description = this@with.description?.toBuilder()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          usage = this@with.usage?.toBuilder()
        }
    }

  /** Indicates how the system may be identified when referenced in electronic exchange. */
  @Serializable(with = NamingSystemUniqueIdSerializer::class)
  public data class UniqueId(
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
     * Identifies the unique identifier scheme used for this particular identifier.
     *
     * Different identifier types may be used in different types of communications (OIDs for v3,
     * URIs for FHIR, etc.). Other includes RUIDs from v3, standard v2 code name strings, etc.
     */
    public val type: Enumeration<NamingSystemIdentifierType>,
    /**
     * The string that should be sent over the wire to identify the code system or identifier
     * system.
     *
     * If the value is a URI intended for use as FHIR system identifier, the URI should not contain
     * "\" or "?" or "," since this makes escaping very difficult.
     */
    public val `value`: String,
    /** Indicates whether this identifier is the "preferred" identifier of this type. */
    public val preferred: Boolean? = null,
    /**
     * Notes about the past or intended usage of this identifier.
     *
     * e.g. "must be used in Germany" or "was initially published in error with this value".
     */
    public val comment: String? = null,
    /**
     * Identifies the period of time over which this identifier is considered appropriate to refer
     * to the naming system. Outside of this window, the identifier might be non-deterministic.
     *
     * Within a registry, a given identifier should only be "active" for a single namespace at a
     * time. (Ideally, an identifier should only ever be associated with a single namespace across
     * all time).
     */
    public val period: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type, `value`.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          preferred = this@with.preferred?.toBuilder()
          comment = this@with.comment?.toBuilder()
          period = this@with.period?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Identifies the unique identifier scheme used for this particular identifier.
       *
       * Different identifier types may be used in different types of communications (OIDs for v3,
       * URIs for FHIR, etc.). Other includes RUIDs from v3, standard v2 code name strings, etc.
       */
      public var type: Enumeration<NamingSystemIdentifierType>,
      /**
       * The string that should be sent over the wire to identify the code system or identifier
       * system.
       *
       * If the value is a URI intended for use as FHIR system identifier, the URI should not
       * contain "\" or "?" or "," since this makes escaping very difficult.
       */
      public var `value`: String.Builder,
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

      /** Indicates whether this identifier is the "preferred" identifier of this type. */
      public var preferred: Boolean.Builder? = null

      /**
       * Notes about the past or intended usage of this identifier.
       *
       * e.g. "must be used in Germany" or "was initially published in error with this value".
       */
      public var comment: String.Builder? = null

      /**
       * Identifies the period of time over which this identifier is considered appropriate to refer
       * to the naming system. Outside of this window, the identifier might be non-deterministic.
       *
       * Within a registry, a given identifier should only be "active" for a single namespace at a
       * time. (Ideally, an identifier should only ever be associated with a single namespace across
       * all time).
       */
      public var period: Period.Builder? = null

      public fun build(): UniqueId =
        UniqueId(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          `value` = `value`.build(),
          preferred = preferred?.build(),
          comment = comment?.build(),
          period = period?.build(),
        )
    }
  }

  public class Builder(
    /**
     * A natural language name identifying the naming system. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.The"symbolic name" for an OID would be
     * captured as an extension.
     */
    public var name: String.Builder,
    /**
     * The status of this naming system. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of naming systems that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
    /** Indicates the purpose for the naming system - what kinds of things does it make unique? */
    public var kind: Enumeration<NamingSystemType>,
    /**
     * The date (and optionally time) when the naming system was published. The date must change
     * when the business version changes and it must change if the status code changes. In addition,
     * it should change when the substantive content of the naming system changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the naming system. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder,
    /**
     * Indicates how the system may be identified when referenced in electronic exchange.
     *
     * Multiple identifiers may exist, either due to duplicate registration, regional rules, needs
     * of different communication technologies, etc.
     */
    public var uniqueId: MutableList<UniqueId.Builder>,
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
     * The name of the organization or individual that published the naming system.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the naming
     * system is the organization or individual primarily responsible for the maintenance and upkeep
     * of the naming system. This is not necessarily the same individual or organization that
     * developed and initially authored the content. The publisher is the primary point of contact
     * for questions or issues with the naming system. This item SHOULD be populated unless the
     * information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * The name of the organization that is responsible for issuing identifiers or codes for this
     * namespace and ensuring their non-collision.
     *
     * This is the primary organization. Responsibility for some aspects of a namespace may be
     * delegated.
     */
    public var responsible: String.Builder? = null

    /**
     * Categorizes a naming system for easier search by grouping related naming systems.
     *
     * This will most commonly be used for identifier namespaces, but categories could potentially
     * be useful for code systems and authorities as well.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * A free text natural language description of the naming system from a consumer's perspective.
     * Details about what the namespace identifies including scope, granularity, version labeling,
     * etc.
     *
     * This description can be used to capture details such as why the naming system was built,
     * comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the naming system as
     * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
     * information is available from context (e.g. the language of the naming system is presumed to
     * be the predominant language in the place the naming system was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate naming system instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the naming system is intended to be used.
     *
     * It may be possible for the naming system to be used in jurisdictions other than those for
     * which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Provides guidance on the use of the namespace, including the handling of formatting
     * characters, use of upper vs. lower case, etc.
     */
    public var usage: String.Builder? = null

    override fun build(): NamingSystem =
      NamingSystem(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        name = name.build(),
        status = status,
        kind = kind,
        date = date.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        responsible = responsible?.build(),
        type = type?.build(),
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        usage = usage?.build(),
        uniqueId = uniqueId.map { it.build() },
      )
  }

  /** Identifies the style of unique identifier used to identify a namespace. */
  public enum class NamingSystemIdentifierType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Oid("oid", "http://hl7.org/fhir/namingsystem-identifier-type", "OID"),
    Uuid("uuid", "http://hl7.org/fhir/namingsystem-identifier-type", "UUID"),
    Uri("uri", "http://hl7.org/fhir/namingsystem-identifier-type", "URI"),
    Other("other", "http://hl7.org/fhir/namingsystem-identifier-type", "Other");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): NamingSystemIdentifierType =
        when (code) {
          "oid" -> Oid
          "uuid" -> Uuid
          "uri" -> Uri
          "other" -> Other
          else ->
            throw IllegalArgumentException("Unknown code $code for enum NamingSystemIdentifierType")
        }
    }
  }

  /** Identifies the purpose of the naming system. */
  public enum class NamingSystemType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Codesystem("codesystem", "http://hl7.org/fhir/namingsystem-type", "Code System"),
    Identifier("identifier", "http://hl7.org/fhir/namingsystem-type", "Identifier"),
    Root("root", "http://hl7.org/fhir/namingsystem-type", "Root");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): NamingSystemType =
        when (code) {
          "codesystem" -> Codesystem
          "identifier" -> Identifier
          "root" -> Root
          else -> throw IllegalArgumentException("Unknown code $code for enum NamingSystemType")
        }
    }
  }
}
