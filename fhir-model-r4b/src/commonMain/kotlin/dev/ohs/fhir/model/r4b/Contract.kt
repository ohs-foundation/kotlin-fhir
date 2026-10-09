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

import dev.ohs.fhir.model.r4b.serializers.ContractContentDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractFriendlySerializer
import dev.ohs.fhir.model.r4b.serializers.ContractLegalSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractRuleSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractSignerSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermActionSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermActionSubjectSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermAssetContextSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermAssetSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermAssetValuedItemSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermOfferAnswerSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermOfferPartySerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermOfferSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermSecurityLabelSerializer
import dev.ohs.fhir.model.r4b.serializers.ContractTermSerializer
import dev.ohs.fhir.model.r4b.terminologies.ContractResourcePublicationStatusCodes
import dev.ohs.fhir.model.r4b.terminologies.ContractResourceStatusCodes
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or
 * agreement.
 */
@Serializable(with = ContractSerializer::class)
@SerialName("Contract")
public data class Contract(
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
  /** Unique identifier for this Contract or a derivative that references a Source Contract. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Canonical identifier for this contract, represented as a URI (globally unique).
   *
   * Used in a domain that uses a supplied contract repository.
   */
  public val url: Uri? = null,
  /**
   * An edition identifier used for business purposes to label business significant variants.
   *
   * Note - This is a business versionId, not a resource version id (see discussion
   * http://build.fhir.org/resource.html#versions) Comments - There may be different contract
   * instances that have the same identifier but different versions. The version can be appended to
   * the url in a reference to allow a reference to a particular business version of the plan
   * definition with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * The status of the resource instance.
   *
   * This element is labeled as a modifier because the status contains codes that mark the contract
   * as not currently valid or active.
   */
  public val status: Enumeration<ContractResourceStatusCodes>? = null,
  /**
   * Legal states of the formation of a legal instrument, which is a formally executed written
   * document that can be formally attributed to its author, records and formally expresses a
   * legally enforceable act, process, or contractual duty, obligation, or right, and therefore
   * evidences that act, process, or agreement.
   */
  public val legalState: CodeableConcept? = null,
  /**
   * The URL pointing to a FHIR-defined Contract Definition that is adhered to in whole or part by
   * this Contract.
   */
  public val instantiatesCanonical: Reference? = null,
  /**
   * The URL pointing to an externally maintained definition that is adhered to in whole or in part
   * by this Contract.
   */
  public val instantiatesUri: Uri? = null,
  /**
   * The minimal content derived from the basal information source at a specific stage in its
   * lifecycle.
   */
  public val contentDerivative: CodeableConcept? = null,
  /** When this Contract was issued. */
  public val issued: DateTime? = null,
  /** Relevant time or time-period when this Contract is applicable. */
  public val applies: Period? = null,
  /**
   * Event resulting in discontinuation or termination of this Contract instance by one or more
   * parties to the contract.
   */
  public val expirationType: CodeableConcept? = null,
  /**
   * The target entity impacted by or of interest to parties to the agreement.
   *
   * The Contract.subject is an entity that has some role with respect to the Contract.topic and
   * Contract.topic.term, which is of focal interest to the parties to the contract and likely
   * impacted in a significant way by the Contract.action/Contract.action.reason and the
   * Contract.term.action/Contract.action.reason. In many cases, the Contract.subject is a
   * Contract.signer if the subject is an adult; has a legal interest in the contract; and
   * incompetent to participate in the contract agreement.
   */
  public val subject: List<Reference> = listOf(),
  /**
   * A formally or informally recognized grouping of people, principals, organizations, or
   * jurisdictions formed for the purpose of achieving some form of collective action such as the
   * promulgation, administration and enforcement of contracts and policies.
   */
  public val authority: List<Reference> = listOf(),
  /**
   * Recognized governance framework or system operating with a circumscribed scope in accordance
   * with specified principles, policies, processes or procedures for managing rights, actions, or
   * behaviors of parties or principals relative to resources.
   */
  public val domain: List<Reference> = listOf(),
  /** Sites in which the contract is complied with, exercised, or in force. */
  public val site: List<Reference> = listOf(),
  /**
   * A natural language name identifying this Contract definition, derivative, or instance in any
   * legal state. Provides additional information about its content. This name should be usable as
   * an identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for this Contract definition, derivative, or instance
   * in any legal state.t giving additional information about its content.
   */
  public val title: String? = null,
  /**
   * An explanatory or alternate user-friendly title for this Contract definition, derivative, or
   * instance in any legal state.t giving additional information about its content.
   */
  public val subtitle: String? = null,
  /**
   * Alternative representation of the title for this Contract definition, derivative, or instance
   * in any legal state., e.g., a domain specific contract number related to legislation.
   */
  public val alias: List<String> = listOf(),
  /**
   * The individual or organization that authored the Contract definition, derivative, or instance
   * in any legal state.
   */
  public val author: Reference? = null,
  /**
   * A selector of legal concerns for this Contract definition, derivative, or instance in any legal
   * state.
   */
  public val scope: CodeableConcept? = null,
  /**
   * Narrows the range of legal concerns to focus on the achievement of specific contractual
   * objectives.
   */
  public val topic: Topic? = null,
  /**
   * A high-level category for the legal instrument, whether constructed as a Contract definition,
   * derivative, or instance in any legal state. Provides additional information about its content
   * within the context of the Contract's scope to distinguish the kinds of systems that would be
   * interested in the contract.
   */
  public val type: CodeableConcept? = null,
  /**
   * Sub-category for the Contract that distinguishes the kinds of systems that would be interested
   * in the Contract within the context of the Contract's scope.
   */
  public val subType: List<CodeableConcept> = listOf(),
  /**
   * Precusory content developed with a focus and intent of supporting the formation a Contract
   * instance, which may be associated with and transformable into a Contract.
   */
  public val contentDefinition: ContentDefinition? = null,
  /**
   * One or more Contract Provisions, which may be related and conveyed as a group, and may contain
   * nested groups.
   */
  public val term: List<Term> = listOf(),
  /**
   * Information that may be needed by/relevant to the performer in their execution of this term
   * action.
   */
  public val supportingInfo: List<Reference> = listOf(),
  /**
   * Links to Provenance records for past versions of this Contract definition, derivative, or
   * instance, which identify key state transitions or updates that are likely to be relevant to a
   * user looking at the current version of the Contract. The Provence.entity indicates the target
   * that was changed in the update.
   * http://build.fhir.org/provenance-definitions.html#Provenance.entity.
   */
  public val relevantHistory: List<Reference> = listOf(),
  /**
   * Parties with legal standing in the Contract, including the principal parties, the grantor(s)
   * and grantee(s), which are any person or organization bound by the contract, and any ancillary
   * parties, which facilitate the execution of the contract such as a notary or witness.
   *
   * Signers who are principal parties to the contract are bound by the Contract.activity related to
   * the Contract.topic, and the Contract.term(s), which either extend or restrict the overall
   * action on the topic by, for example, stipulating specific policies or obligations constraining
   * actions, action reason, or agents with respect to some or all of the topic. For example,
   * specifying how policies or obligations shall constrain actions and action reasons permitted or
   * denied on all or a subset of the Contract.topic (e.g., all or a portion of property being
   * transferred by the contract), agents (e.g., who can resell, assign interests, or alter the
   * property being transferred by the contract), actions, and action reasons; or with respect to
   * Contract.terms, stipulating, extending, or limiting the Contract.period of applicability or
   * valuation of items under consideration.
   */
  public val signer: List<Signer> = listOf(),
  /**
   * The "patient friendly language" versionof the Contract in whole or in parts. "Patient friendly
   * language" means the representation of the Contract and Contract Provisions in a manner that is
   * readily accessible and understandable by a layperson in accordance with best practices for
   * communication styles that ensure that those agreeing to or signing the Contract understand the
   * roles, actions, obligations, responsibilities, and implication of the agreement.
   */
  public val friendly: List<Friendly> = listOf(),
  /** List of Legal expressions or representations of this Contract. */
  public val legal: List<Legal> = listOf(),
  /** List of Computable Policy Rule Language Representations of this Contract. */
  public val rule: List<Rule> = listOf(),
  /**
   * Legally binding Contract: This is the signed and legally recognized representation of the
   * Contract, which is considered the "source of truth" and which would be the basis for legal
   * action related to enforcement of this Contract.
   */
  public val legallyBinding: LegallyBinding? = null,
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder()
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.identifier = identifier.toBuilderList()
    builder.url = url?.toBuilder()
    builder.version = version?.toBuilder()
    builder.status = status
    builder.legalState = legalState?.toBuilder()
    builder.instantiatesCanonical = instantiatesCanonical?.toBuilder()
    builder.instantiatesUri = instantiatesUri?.toBuilder()
    builder.contentDerivative = contentDerivative?.toBuilder()
    builder.issued = issued?.toBuilder()
    builder.applies = applies?.toBuilder()
    builder.expirationType = expirationType?.toBuilder()
    builder.subject = subject.toBuilderList()
    builder.authority = authority.toBuilderList()
    builder.domain = domain.toBuilderList()
    builder.site = site.toBuilderList()
    builder.name = name?.toBuilder()
    builder.title = title?.toBuilder()
    builder.subtitle = subtitle?.toBuilder()
    builder.alias = alias.toBuilderList()
    builder.author = author?.toBuilder()
    builder.scope = scope?.toBuilder()
    builder.topic = topic
    builder.type = type?.toBuilder()
    builder.subType = subType.toBuilderList()
    builder.contentDefinition = contentDefinition?.toBuilder()
    builder.term = term.toBuilderList()
    builder.supportingInfo = supportingInfo.toBuilderList()
    builder.relevantHistory = relevantHistory.toBuilderList()
    builder.signer = signer.toBuilderList()
    builder.friendly = friendly.toBuilderList()
    builder.legal = legal.toBuilderList()
    builder.rule = rule.toBuilderList()
    builder.legallyBinding = legallyBinding
    return builder
  }

  /**
   * Precusory content developed with a focus and intent of supporting the formation a Contract
   * instance, which may be associated with and transformable into a Contract.
   */
  @Serializable(with = ContractContentDefinitionSerializer::class)
  public data class ContentDefinition(
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
     * Precusory content structure and use, i.e., a boilerplate, template, application for a
     * contract such as an insurance policy or benefits under a program, e.g., workers compensation.
     */
    public val type: CodeableConcept,
    /** Detailed Precusory content type. */
    public val subType: CodeableConcept? = null,
    /** The individual or organization that published the Contract precursor content. */
    public val publisher: Reference? = null,
    /**
     * The date (and optionally time) when the contract was published. The date must change when the
     * business version changes and it must change if the status code changes. In addition, it
     * should change when the substantive content of the contract changes.
     */
    public val publicationDate: DateTime? = null,
    /**
     * amended | appended | cancelled | disputed | entered-in-error | executable | executed |
     * negotiable | offered | policy | rejected | renewed | revoked | resolved | terminated.
     */
    public val publicationStatus: Enumeration<ContractResourcePublicationStatusCodes>,
    /**
     * A copyright statement relating to Contract precursor content. Copyright statements are
     * generally legal restrictions on the use and publishing of the Contract precursor content.
     */
    public val copyright: Markdown? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder =
        Builder(
          type.toBuilder(),
          publicationStatus,
        )
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.subType = subType?.toBuilder()
      builder.publisher = publisher?.toBuilder()
      builder.publicationDate = publicationDate?.toBuilder()
      builder.copyright = copyright?.toBuilder()
      return builder
    }

    public class Builder(
      /**
       * Precusory content structure and use, i.e., a boilerplate, template, application for a
       * contract such as an insurance policy or benefits under a program, e.g., workers
       * compensation.
       */
      public var type: CodeableConcept.Builder,
      /**
       * amended | appended | cancelled | disputed | entered-in-error | executable | executed |
       * negotiable | offered | policy | rejected | renewed | revoked | resolved | terminated.
       */
      public var publicationStatus: Enumeration<ContractResourcePublicationStatusCodes>,
    ) : FhirBuilder {
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

      /** Detailed Precusory content type. */
      public var subType: CodeableConcept.Builder? = null

      /** The individual or organization that published the Contract precursor content. */
      public var publisher: Reference.Builder? = null

      /**
       * The date (and optionally time) when the contract was published. The date must change when
       * the business version changes and it must change if the status code changes. In addition, it
       * should change when the substantive content of the contract changes.
       */
      public var publicationDate: DateTime.Builder? = null

      /**
       * A copyright statement relating to Contract precursor content. Copyright statements are
       * generally legal restrictions on the use and publishing of the Contract precursor content.
       */
      public var copyright: Markdown.Builder? = null

      override fun build(): ContentDefinition =
        ContentDefinition(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type.build(),
          subType = subType?.build(),
          publisher = publisher?.build(),
          publicationDate = publicationDate?.build(),
          publicationStatus = publicationStatus,
          copyright = copyright?.build(),
        )
    }
  }

  /**
   * One or more Contract Provisions, which may be related and conveyed as a group, and may contain
   * nested groups.
   */
  @Serializable(with = ContractTermSerializer::class)
  public data class Term(
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
    /** Unique identifier for this particular Contract Provision. */
    public val identifier: Identifier? = null,
    /** When this Contract Provision was issued. */
    public val issued: DateTime? = null,
    /** Relevant time or time-period when this Contract Provision is applicable. */
    public val applies: Period? = null,
    /** The entity that the term applies to. */
    public val topic: Topic? = null,
    /**
     * A legal clause or condition contained within a contract that requires one or both parties to
     * perform a particular requirement by some specified time or prevents one or both parties from
     * performing a particular requirement by some specified time.
     */
    public val type: CodeableConcept? = null,
    /** A specialized legal clause or condition based on overarching contract type. */
    public val subType: CodeableConcept? = null,
    /** Statement of a provision in a policy or a contract. */
    public val text: String? = null,
    /**
     * Security labels that protect the handling of information about the term and its elements,
     * which may be specifically identified..
     */
    public val securityLabel: List<SecurityLabel> = listOf(),
    /** The matter of concern in the context of this provision of the agrement. */
    public val offer: Offer,
    /** Contract Term Asset List. */
    public val asset: List<Asset> = listOf(),
    /**
     * An actor taking a role in an activity for which it can be assigned some degree of
     * responsibility for the activity taking place.
     *
     * Several agents may be associated (i.e. has some responsibility for an activity) with an
     * activity and vice-versa. For example, in cases of actions initiated by one user for other
     * users, or in events that involve more than one user, hardware device, software, or system
     * process. However, only one user may be the initiator/requestor for the event.
     */
    public val action: List<Action> = listOf(),
    /** Nested group of Contract Provisions. */
    public val group: List<Term> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(offer.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.identifier = identifier?.toBuilder()
      builder.issued = issued?.toBuilder()
      builder.applies = applies?.toBuilder()
      builder.topic = topic
      builder.type = type?.toBuilder()
      builder.subType = subType?.toBuilder()
      builder.text = text?.toBuilder()
      builder.securityLabel = securityLabel.toBuilderList()
      builder.asset = asset.toBuilderList()
      builder.action = action.toBuilderList()
      builder.group = group.toBuilderList()
      return builder
    }

    /**
     * Security labels that protect the handling of information about the term and its elements,
     * which may be specifically identified..
     */
    @Serializable(with = ContractTermSecurityLabelSerializer::class)
    public data class SecurityLabel(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Number used to link this term or term element to the applicable Security Label. */
      public val number: List<UnsignedInt> = listOf(),
      /**
       * Security label privacy tag that species the level of confidentiality protection required
       * for this term and/or term elements.
       */
      public val classification: Coding,
      /**
       * Security label privacy tag that species the applicable privacy and security policies
       * governing this term and/or term elements.
       */
      public val category: List<Coding> = listOf(),
      /**
       * Security label privacy tag that species the manner in which term and/or term elements are
       * to be protected.
       */
      public val control: List<Coding> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(classification.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.number = number.toBuilderList()
        builder.category = category.toBuilderList()
        builder.control = control.toBuilderList()
        return builder
      }

      public class Builder(
        /**
         * Security label privacy tag that species the level of confidentiality protection required
         * for this term and/or term elements.
         */
        public var classification: Coding.Builder
      ) : FhirBuilder {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Number used to link this term or term element to the applicable Security Label. */
        public var number: MutableList<UnsignedInt.Builder> = mutableListOf()

        /**
         * Security label privacy tag that species the applicable privacy and security policies
         * governing this term and/or term elements.
         */
        public var category: MutableList<Coding.Builder> = mutableListOf()

        /**
         * Security label privacy tag that species the manner in which term and/or term elements are
         * to be protected.
         */
        public var control: MutableList<Coding.Builder> = mutableListOf()

        override fun build(): SecurityLabel =
          SecurityLabel(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            number = number.buildList(),
            classification = classification.build(),
            category = category.buildList(),
            control = control.buildList(),
          )
      }
    }

    /** The matter of concern in the context of this provision of the agrement. */
    @Serializable(with = ContractTermOfferSerializer::class)
    public data class Offer(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Unique identifier for this particular Contract Provision. */
      public val identifier: List<Identifier> = listOf(),
      /** Offer Recipient. */
      public val party: List<Party> = listOf(),
      /**
       * The owner of an asset has the residual control rights over the asset: the right to decide
       * all usages of the asset in any way not inconsistent with a prior contract, custom, or law
       * (Hart, 1995, p. 30).
       *
       * The Contract.topic may be an application for or offer of a policy or service (e.g., uri to
       * a consent directive form or a health insurance policy), which becomes the Contract once
       * accepted by both the grantor and grantee. The Contract Resource may function simply as the
       * computable representation of the executed contract, which may be the attached to the
       * Contract Resource as the “binding” or as the “friendly” electronic form. For example, a
       * Contract Resource may be automatically populated with the values expressed in a related
       * QuestionnaireResponse. However, the Contract Resource may be considered the legally binding
       * contract if it is the only “executed” form of this contract, and includes the signatures as
       * *The Contract Resource may function as the computable representation of an application or
       * offer in a pre-executed Contract if the grantor has not entered any values. In this case,
       * it is populated with values in a “legal” form of the application or offer or by the values
       * in an associated Questionnaire. If the grantor has filled in the legal form or the
       * associated Questionnaire Response, then these values are used to populate a pre-executed
       * Contract Resource. If the Contract.topic is considered an application or offer, then the
       * policy is often required to be attached as the “legal” basis for the application to ensure
       * “informed consent” to the contract, and that any discrepancy between the application and
       * the policy are interpreted against the policy. Implementers should check organizational and
       * jurisdictional policies to determine the relationship among multiple representations of a
       * contract pre- and post-execution.
       */
      public val topic: Reference? = null,
      /**
       * Type of Contract Provision such as specific requirements, purposes for actions,
       * obligations, prohibitions, e.g. life time maximum benefit.
       */
      public val type: CodeableConcept? = null,
      /**
       * Type of choice made by accepting party with respect to an offer made by an offeror/
       * grantee.
       */
      public val decision: CodeableConcept? = null,
      /** How the decision about a Contract was conveyed. */
      public val decisionMode: List<CodeableConcept> = listOf(),
      /** Response to offer text. */
      public val answer: List<Answer> = listOf(),
      /** Human readable form of this Contract Offer. */
      public val text: String? = null,
      /**
       * The id of the clause or question text of the offer in the referenced
       * questionnaire/response.
       */
      public val linkId: List<String> = listOf(),
      /** Security labels that protects the offer. */
      public val securityLabelNumber: List<UnsignedInt> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.identifier = identifier.toBuilderList()
        builder.party = party.toBuilderList()
        builder.topic = topic?.toBuilder()
        builder.type = type?.toBuilder()
        builder.decision = decision?.toBuilder()
        builder.decisionMode = decisionMode.toBuilderList()
        builder.answer = answer.toBuilderList()
        builder.text = text?.toBuilder()
        builder.linkId = linkId.toBuilderList()
        builder.securityLabelNumber = securityLabelNumber.toBuilderList()
        return builder
      }

      /** Offer Recipient. */
      @Serializable(with = ContractTermOfferPartySerializer::class)
      public data class Party(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /** Participant in the offer. */
        public val reference: List<Reference>,
        /** How the party participates in the offer. */
        public val role: CodeableConcept,
      ) : BackboneElement(), FhirBuildable {
        override fun toBuilder(): Builder {
          val builder =
            Builder(
              reference.toBuilderList(),
              role.toBuilder(),
            )
          builder.id = id
          builder.extension = extension.toBuilderList()
          builder.modifierExtension = modifierExtension.toBuilderList()
          return builder
        }

        public class Builder(
          /** Participant in the offer. */
          public var reference: MutableList<Reference.Builder>,
          /** How the party participates in the offer. */
          public var role: CodeableConcept.Builder,
        ) : FhirBuilder {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          override fun build(): Party =
            Party(
              id = id,
              extension = extension.buildList(),
              modifierExtension = modifierExtension.buildList(),
              reference = reference.buildList(),
              role = role.build(),
            )
        }
      }

      /** Response to offer text. */
      @Serializable(with = ContractTermOfferAnswerSerializer::class)
      public data class Answer(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * Response to an offer clause or question text, which enables selection of values to be
         * agreed to, e.g., the period of participation, the date of occupancy of a rental,
         * warrently duration, or whether biospecimen may be used for further research.
         */
        public val `value`: Value,
      ) : BackboneElement(), FhirBuildable {
        override fun toBuilder(): Builder {
          val builder = Builder(`value`)
          builder.id = id
          builder.extension = extension.toBuilderList()
          builder.modifierExtension = modifierExtension.toBuilderList()
          return builder
        }

        public sealed interface Value : FhirChoice {
          public fun asBoolean(): Boolean? = this as? Boolean

          public fun asDecimal(): Decimal? = this as? Decimal

          public fun asInteger(): Integer? = this as? Integer

          public fun asDate(): Date? = this as? Date

          public fun asDateTime(): DateTime? = this as? DateTime

          public fun asTime(): Time? = this as? Time

          public fun asString(): String? = this as? String

          public fun asUri(): Uri? = this as? Uri

          public fun asAttachment(): Attachment? = this as? Attachment

          public fun asCoding(): Coding? = this as? Coding

          public fun asQuantity(): Quantity? = this as? Quantity

          public fun asReference(): Reference? = this as? Reference

          public data class Boolean(override val `value`: dev.ohs.fhir.model.r4b.Boolean) : Value

          public data class Decimal(override val `value`: dev.ohs.fhir.model.r4b.Decimal) : Value

          public data class Integer(override val `value`: dev.ohs.fhir.model.r4b.Integer) : Value

          public data class Date(override val `value`: dev.ohs.fhir.model.r4b.Date) : Value

          public data class DateTime(override val `value`: dev.ohs.fhir.model.r4b.DateTime) : Value

          public data class Time(override val `value`: dev.ohs.fhir.model.r4b.Time) : Value

          public data class String(override val `value`: dev.ohs.fhir.model.r4b.String) : Value

          public data class Uri(override val `value`: dev.ohs.fhir.model.r4b.Uri) : Value

          public data class Attachment(override val `value`: dev.ohs.fhir.model.r4b.Attachment) :
            Value

          public data class Coding(override val `value`: dev.ohs.fhir.model.r4b.Coding) : Value

          public data class Quantity(override val `value`: dev.ohs.fhir.model.r4b.Quantity) : Value

          public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) :
            Value

          public companion object {
            internal fun from(
              booleanValue: dev.ohs.fhir.model.r4b.Boolean?,
              decimalValue: dev.ohs.fhir.model.r4b.Decimal?,
              integerValue: dev.ohs.fhir.model.r4b.Integer?,
              dateValue: dev.ohs.fhir.model.r4b.Date?,
              dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
              timeValue: dev.ohs.fhir.model.r4b.Time?,
              stringValue: dev.ohs.fhir.model.r4b.String?,
              uriValue: dev.ohs.fhir.model.r4b.Uri?,
              attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
              codingValue: dev.ohs.fhir.model.r4b.Coding?,
              quantityValue: dev.ohs.fhir.model.r4b.Quantity?,
              referenceValue: dev.ohs.fhir.model.r4b.Reference?,
            ): Value? {
              if (booleanValue != null) return Boolean(booleanValue)
              if (decimalValue != null) return Decimal(decimalValue)
              if (integerValue != null) return Integer(integerValue)
              if (dateValue != null) return Date(dateValue)
              if (dateTimeValue != null) return DateTime(dateTimeValue)
              if (timeValue != null) return Time(timeValue)
              if (stringValue != null) return String(stringValue)
              if (uriValue != null) return Uri(uriValue)
              if (attachmentValue != null) return Attachment(attachmentValue)
              if (codingValue != null) return Coding(codingValue)
              if (quantityValue != null) return Quantity(quantityValue)
              if (referenceValue != null) return Reference(referenceValue)
              return null
            }
          }
        }

        public class Builder(
          /**
           * Response to an offer clause or question text, which enables selection of values to be
           * agreed to, e.g., the period of participation, the date of occupancy of a rental,
           * warrently duration, or whether biospecimen may be used for further research.
           */
          public var `value`: Value
        ) : FhirBuilder {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          override fun build(): Answer =
            Answer(
              id = id,
              extension = extension.buildList(),
              modifierExtension = modifierExtension.buildList(),
              `value` = `value`,
            )
        }
      }

      public class Builder() : FhirBuilder {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Unique identifier for this particular Contract Provision. */
        public var identifier: MutableList<Identifier.Builder> = mutableListOf()

        /** Offer Recipient. */
        public var party: MutableList<Party.Builder> = mutableListOf()

        /**
         * The owner of an asset has the residual control rights over the asset: the right to decide
         * all usages of the asset in any way not inconsistent with a prior contract, custom, or law
         * (Hart, 1995, p. 30).
         *
         * The Contract.topic may be an application for or offer of a policy or service (e.g., uri
         * to a consent directive form or a health insurance policy), which becomes the Contract
         * once accepted by both the grantor and grantee. The Contract Resource may function simply
         * as the computable representation of the executed contract, which may be the attached to
         * the Contract Resource as the “binding” or as the “friendly” electronic form. For example,
         * a Contract Resource may be automatically populated with the values expressed in a related
         * QuestionnaireResponse. However, the Contract Resource may be considered the legally
         * binding contract if it is the only “executed” form of this contract, and includes the
         * signatures as *The Contract Resource may function as the computable representation of an
         * application or offer in a pre-executed Contract if the grantor has not entered any
         * values. In this case, it is populated with values in a “legal” form of the application or
         * offer or by the values in an associated Questionnaire. If the grantor has filled in the
         * legal form or the associated Questionnaire Response, then these values are used to
         * populate a pre-executed Contract Resource. If the Contract.topic is considered an
         * application or offer, then the policy is often required to be attached as the “legal”
         * basis for the application to ensure “informed consent” to the contract, and that any
         * discrepancy between the application and the policy are interpreted against the policy.
         * Implementers should check organizational and jurisdictional policies to determine the
         * relationship among multiple representations of a contract pre- and post-execution.
         */
        public var topic: Reference.Builder? = null

        /**
         * Type of Contract Provision such as specific requirements, purposes for actions,
         * obligations, prohibitions, e.g. life time maximum benefit.
         */
        public var type: CodeableConcept.Builder? = null

        /**
         * Type of choice made by accepting party with respect to an offer made by an offeror/
         * grantee.
         */
        public var decision: CodeableConcept.Builder? = null

        /** How the decision about a Contract was conveyed. */
        public var decisionMode: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** Response to offer text. */
        public var answer: MutableList<Answer.Builder> = mutableListOf()

        /** Human readable form of this Contract Offer. */
        public var text: String.Builder? = null

        /**
         * The id of the clause or question text of the offer in the referenced
         * questionnaire/response.
         */
        public var linkId: MutableList<String.Builder> = mutableListOf()

        /** Security labels that protects the offer. */
        public var securityLabelNumber: MutableList<UnsignedInt.Builder> = mutableListOf()

        override fun build(): Offer =
          Offer(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            identifier = identifier.buildList(),
            party = party.buildList(),
            topic = topic?.build(),
            type = type?.build(),
            decision = decision?.build(),
            decisionMode = decisionMode.buildList(),
            answer = answer.buildList(),
            text = text?.build(),
            linkId = linkId.buildList(),
            securityLabelNumber = securityLabelNumber.buildList(),
          )
      }
    }

    /** Contract Term Asset List. */
    @Serializable(with = ContractTermAssetSerializer::class)
    public data class Asset(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Differentiates the kind of the asset . */
      public val scope: CodeableConcept? = null,
      /** Target entity type about which the term may be concerned. */
      public val type: List<CodeableConcept> = listOf(),
      /** Associated entities. */
      public val typeReference: List<Reference> = listOf(),
      /** May be a subtype or part of an offered asset. */
      public val subtype: List<CodeableConcept> = listOf(),
      /**
       * Specifies the applicability of the term to an asset resource instance, and instances it
       * refers to orinstances that refer to it, and/or are owned by the offeree.
       */
      public val relationship: Coding? = null,
      /** Circumstance of the asset. */
      public val context: List<Context> = listOf(),
      /**
       * Description of the quality and completeness of the asset that imay be a factor in its
       * valuation.
       */
      public val condition: String? = null,
      /** Type of Asset availability for use or ownership. */
      public val periodType: List<CodeableConcept> = listOf(),
      /** Asset relevant contractual time period. */
      public val period: List<Period> = listOf(),
      /** Time period of asset use. */
      public val usePeriod: List<Period> = listOf(),
      /**
       * Clause or question text (Prose Object) concerning the asset in a linked form, such as a
       * QuestionnaireResponse used in the formation of the contract.
       */
      public val text: String? = null,
      /**
       * Id [identifier??] of the clause or question text about the asset in the referenced form or
       * QuestionnaireResponse.
       */
      public val linkId: List<String> = listOf(),
      /** Response to assets. */
      public val answer: List<Offer.Answer> = listOf(),
      /** Security labels that protects the asset. */
      public val securityLabelNumber: List<UnsignedInt> = listOf(),
      /** Contract Valued Item List. */
      public val valuedItem: List<ValuedItem> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.scope = scope?.toBuilder()
        builder.type = type.toBuilderList()
        builder.typeReference = typeReference.toBuilderList()
        builder.subtype = subtype.toBuilderList()
        builder.relationship = relationship?.toBuilder()
        builder.context = context.toBuilderList()
        builder.condition = condition?.toBuilder()
        builder.periodType = periodType.toBuilderList()
        builder.period = period.toBuilderList()
        builder.usePeriod = usePeriod.toBuilderList()
        builder.text = text?.toBuilder()
        builder.linkId = linkId.toBuilderList()
        builder.answer = answer.toBuilderList()
        builder.securityLabelNumber = securityLabelNumber.toBuilderList()
        builder.valuedItem = valuedItem.toBuilderList()
        return builder
      }

      /** Circumstance of the asset. */
      @Serializable(with = ContractTermAssetContextSerializer::class)
      public data class Context(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * Asset context reference may include the creator, custodian, or owning Person or
         * Organization (e.g., bank, repository), location held, e.g., building, jurisdiction.
         */
        public val reference: Reference? = null,
        /**
         * Coded representation of the context generally or of the Referenced entity, such as the
         * asset holder type or location.
         */
        public val code: List<CodeableConcept> = listOf(),
        /** Context description. */
        public val text: String? = null,
      ) : BackboneElement(), FhirBuildable {
        override fun toBuilder(): Builder {
          val builder = Builder()
          builder.id = id
          builder.extension = extension.toBuilderList()
          builder.modifierExtension = modifierExtension.toBuilderList()
          builder.reference = reference?.toBuilder()
          builder.code = code.toBuilderList()
          builder.text = text?.toBuilder()
          return builder
        }

        public class Builder() : FhirBuilder {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * Asset context reference may include the creator, custodian, or owning Person or
           * Organization (e.g., bank, repository), location held, e.g., building, jurisdiction.
           */
          public var reference: Reference.Builder? = null

          /**
           * Coded representation of the context generally or of the Referenced entity, such as the
           * asset holder type or location.
           */
          public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

          /** Context description. */
          public var text: String.Builder? = null

          override fun build(): Context =
            Context(
              id = id,
              extension = extension.buildList(),
              modifierExtension = modifierExtension.buildList(),
              reference = reference?.build(),
              code = code.buildList(),
              text = text?.build(),
            )
        }
      }

      /** Contract Valued Item List. */
      @Serializable(with = ContractTermAssetValuedItemSerializer::class)
      public data class ValuedItem(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /** Specific type of Contract Valued Item that may be priced. */
        public val entity: Entity? = null,
        /** Identifies a Contract Valued Item instance. */
        public val identifier: Identifier? = null,
        /** Indicates the time during which this Contract ValuedItem information is effective. */
        public val effectiveTime: DateTime? = null,
        /**
         * Specifies the units by which the Contract Valued Item is measured or counted, and
         * quantifies the countable or measurable Contract Valued Item instances.
         */
        public val quantity: Quantity? = null,
        /** A Contract Valued Item unit valuation measure. */
        public val unitPrice: Money? = null,
        /**
         * A real number that represents a multiplier used in determining the overall value of the
         * Contract Valued Item delivered. The concept of a Factor allows for a discount or
         * surcharge multiplier to be applied to a monetary amount.
         */
        public val factor: Decimal? = null,
        /**
         * An amount that expresses the weighting (based on difficulty, cost and/or resource
         * intensiveness) associated with the Contract Valued Item delivered. The concept of Points
         * allows for assignment of point values for a Contract Valued Item, such that a monetary
         * amount can be assigned to each point.
         */
        public val points: Decimal? = null,
        /**
         * Expresses the product of the Contract Valued Item unitQuantity and the unitPriceAmt. For
         * example, the formula: unit Quantity * unit Price (Cost per Point) * factor Number *
         * points = net Amount. Quantity, factor and points are assumed to be 1 if not supplied.
         */
        public val net: Money? = null,
        /** Terms of valuation. */
        public val payment: String? = null,
        /** When payment is due. */
        public val paymentDate: DateTime? = null,
        /** Who will make payment. */
        public val responsible: Reference? = null,
        /** Who will receive payment. */
        public val recipient: Reference? = null,
        /**
         * Id of the clause or question text related to the context of this valuedItem in the
         * referenced form or QuestionnaireResponse.
         */
        public val linkId: List<String> = listOf(),
        /** A set of security labels that define which terms are controlled by this condition. */
        public val securityLabelNumber: List<UnsignedInt> = listOf(),
      ) : BackboneElement(), FhirBuildable {
        override fun toBuilder(): Builder {
          val builder = Builder()
          builder.id = id
          builder.extension = extension.toBuilderList()
          builder.modifierExtension = modifierExtension.toBuilderList()
          builder.entity = entity
          builder.identifier = identifier?.toBuilder()
          builder.effectiveTime = effectiveTime?.toBuilder()
          builder.quantity = quantity?.toBuilder()
          builder.unitPrice = unitPrice?.toBuilder()
          builder.factor = factor?.toBuilder()
          builder.points = points?.toBuilder()
          builder.net = net?.toBuilder()
          builder.payment = payment?.toBuilder()
          builder.paymentDate = paymentDate?.toBuilder()
          builder.responsible = responsible?.toBuilder()
          builder.recipient = recipient?.toBuilder()
          builder.linkId = linkId.toBuilderList()
          builder.securityLabelNumber = securityLabelNumber.toBuilderList()
          return builder
        }

        public sealed interface Entity : FhirChoice {
          public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

          public fun asReference(): Reference? = this as? Reference

          public data class CodeableConcept(
            override val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
          ) : Entity

          public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) :
            Entity

          public companion object {
            internal fun from(
              codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
              referenceValue: dev.ohs.fhir.model.r4b.Reference?,
            ): Entity? {
              if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
              if (referenceValue != null) return Reference(referenceValue)
              return null
            }
          }
        }

        public class Builder() : FhirBuilder {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /** Specific type of Contract Valued Item that may be priced. */
          public var entity: Entity? = null

          /** Identifies a Contract Valued Item instance. */
          public var identifier: Identifier.Builder? = null

          /** Indicates the time during which this Contract ValuedItem information is effective. */
          public var effectiveTime: DateTime.Builder? = null

          /**
           * Specifies the units by which the Contract Valued Item is measured or counted, and
           * quantifies the countable or measurable Contract Valued Item instances.
           */
          public var quantity: Quantity.Builder? = null

          /** A Contract Valued Item unit valuation measure. */
          public var unitPrice: Money.Builder? = null

          /**
           * A real number that represents a multiplier used in determining the overall value of the
           * Contract Valued Item delivered. The concept of a Factor allows for a discount or
           * surcharge multiplier to be applied to a monetary amount.
           */
          public var factor: Decimal.Builder? = null

          /**
           * An amount that expresses the weighting (based on difficulty, cost and/or resource
           * intensiveness) associated with the Contract Valued Item delivered. The concept of
           * Points allows for assignment of point values for a Contract Valued Item, such that a
           * monetary amount can be assigned to each point.
           */
          public var points: Decimal.Builder? = null

          /**
           * Expresses the product of the Contract Valued Item unitQuantity and the unitPriceAmt.
           * For example, the formula: unit Quantity * unit Price (Cost per Point) * factor Number *
           * points = net Amount. Quantity, factor and points are assumed to be 1 if not supplied.
           */
          public var net: Money.Builder? = null

          /** Terms of valuation. */
          public var payment: String.Builder? = null

          /** When payment is due. */
          public var paymentDate: DateTime.Builder? = null

          /** Who will make payment. */
          public var responsible: Reference.Builder? = null

          /** Who will receive payment. */
          public var recipient: Reference.Builder? = null

          /**
           * Id of the clause or question text related to the context of this valuedItem in the
           * referenced form or QuestionnaireResponse.
           */
          public var linkId: MutableList<String.Builder> = mutableListOf()

          /** A set of security labels that define which terms are controlled by this condition. */
          public var securityLabelNumber: MutableList<UnsignedInt.Builder> = mutableListOf()

          override fun build(): ValuedItem =
            ValuedItem(
              id = id,
              extension = extension.buildList(),
              modifierExtension = modifierExtension.buildList(),
              entity = entity,
              identifier = identifier?.build(),
              effectiveTime = effectiveTime?.build(),
              quantity = quantity?.build(),
              unitPrice = unitPrice?.build(),
              factor = factor?.build(),
              points = points?.build(),
              net = net?.build(),
              payment = payment?.build(),
              paymentDate = paymentDate?.build(),
              responsible = responsible?.build(),
              recipient = recipient?.build(),
              linkId = linkId.buildList(),
              securityLabelNumber = securityLabelNumber.buildList(),
            )
        }
      }

      public class Builder() : FhirBuilder {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Differentiates the kind of the asset . */
        public var scope: CodeableConcept.Builder? = null

        /** Target entity type about which the term may be concerned. */
        public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** Associated entities. */
        public var typeReference: MutableList<Reference.Builder> = mutableListOf()

        /** May be a subtype or part of an offered asset. */
        public var subtype: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Specifies the applicability of the term to an asset resource instance, and instances it
         * refers to orinstances that refer to it, and/or are owned by the offeree.
         */
        public var relationship: Coding.Builder? = null

        /** Circumstance of the asset. */
        public var context: MutableList<Context.Builder> = mutableListOf()

        /**
         * Description of the quality and completeness of the asset that imay be a factor in its
         * valuation.
         */
        public var condition: String.Builder? = null

        /** Type of Asset availability for use or ownership. */
        public var periodType: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** Asset relevant contractual time period. */
        public var period: MutableList<Period.Builder> = mutableListOf()

        /** Time period of asset use. */
        public var usePeriod: MutableList<Period.Builder> = mutableListOf()

        /**
         * Clause or question text (Prose Object) concerning the asset in a linked form, such as a
         * QuestionnaireResponse used in the formation of the contract.
         */
        public var text: String.Builder? = null

        /**
         * Id [identifier??] of the clause or question text about the asset in the referenced form
         * or QuestionnaireResponse.
         */
        public var linkId: MutableList<String.Builder> = mutableListOf()

        /** Response to assets. */
        public var answer: MutableList<Offer.Answer.Builder> = mutableListOf()

        /** Security labels that protects the asset. */
        public var securityLabelNumber: MutableList<UnsignedInt.Builder> = mutableListOf()

        /** Contract Valued Item List. */
        public var valuedItem: MutableList<ValuedItem.Builder> = mutableListOf()

        override fun build(): Asset =
          Asset(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            scope = scope?.build(),
            type = type.buildList(),
            typeReference = typeReference.buildList(),
            subtype = subtype.buildList(),
            relationship = relationship?.build(),
            context = context.buildList(),
            condition = condition?.build(),
            periodType = periodType.buildList(),
            period = period.buildList(),
            usePeriod = usePeriod.buildList(),
            text = text?.build(),
            linkId = linkId.buildList(),
            answer = answer.buildList(),
            securityLabelNumber = securityLabelNumber.buildList(),
            valuedItem = valuedItem.buildList(),
          )
      }
    }

    /**
     * An actor taking a role in an activity for which it can be assigned some degree of
     * responsibility for the activity taking place.
     */
    @Serializable(with = ContractTermActionSerializer::class)
    public data class Action(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** True if the term prohibits the action. */
      public val doNotPerform: Boolean? = null,
      /**
       * Activity or service obligation to be done or not done, performed or not performed,
       * effectuated or not by this Contract term.
       */
      public val type: CodeableConcept,
      /** Entity of the action. */
      public val subject: List<Subject> = listOf(),
      /** Reason or purpose for the action stipulated by this Contract Provision. */
      public val intent: CodeableConcept,
      /**
       * Id [identifier??] of the clause or question text related to this action in the referenced
       * form or QuestionnaireResponse.
       */
      public val linkId: List<String> = listOf(),
      /** Current state of the term action. */
      public val status: CodeableConcept,
      /** Encounter or Episode with primary association to specified term activity. */
      public val context: Reference? = null,
      /**
       * Id [identifier??] of the clause or question text related to the requester of this action in
       * the referenced form or QuestionnaireResponse.
       */
      public val contextLinkId: List<String> = listOf(),
      /** When action happens. */
      public val occurrence: Occurrence? = null,
      /** Who or what initiated the action and has responsibility for its activation. */
      public val requester: List<Reference> = listOf(),
      /**
       * Id [identifier??] of the clause or question text related to the requester of this action in
       * the referenced form or QuestionnaireResponse.
       */
      public val requesterLinkId: List<String> = listOf(),
      /**
       * The type of individual that is desired or required to perform or not perform the action.
       */
      public val performerType: List<CodeableConcept> = listOf(),
      /**
       * The type of role or competency of an individual desired or required to perform or not
       * perform the action.
       */
      public val performerRole: CodeableConcept? = null,
      /** Indicates who or what is being asked to perform (or not perform) the ction. */
      public val performer: Reference? = null,
      /**
       * Id [identifier??] of the clause or question text related to the reason type or reference of
       * this action in the referenced form or QuestionnaireResponse.
       */
      public val performerLinkId: List<String> = listOf(),
      /**
       * Rationale for the action to be performed or not performed. Describes why the action is
       * permitted or prohibited.
       */
      public val reasonCode: List<CodeableConcept> = listOf(),
      /**
       * Indicates another resource whose existence justifies permitting or not permitting this
       * action.
       */
      public val reasonReference: List<Reference> = listOf(),
      /** Describes why the action is to be performed or not performed in textual form. */
      public val reason: List<String> = listOf(),
      /**
       * Id [identifier??] of the clause or question text related to the reason type or reference of
       * this action in the referenced form or QuestionnaireResponse.
       */
      public val reasonLinkId: List<String> = listOf(),
      /**
       * Comments made about the term action made by the requester, performer, subject or other
       * participants.
       */
      public val note: List<Annotation> = listOf(),
      /** Security labels that protects the action. */
      public val securityLabelNumber: List<UnsignedInt> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(type.toBuilder(), intent.toBuilder(), status.toBuilder())
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.doNotPerform = doNotPerform?.toBuilder()
        builder.subject = subject.toBuilderList()
        builder.linkId = linkId.toBuilderList()
        builder.context = context?.toBuilder()
        builder.contextLinkId = contextLinkId.toBuilderList()
        builder.occurrence = occurrence
        builder.requester = requester.toBuilderList()
        builder.requesterLinkId = requesterLinkId.toBuilderList()
        builder.performerType = performerType.toBuilderList()
        builder.performerRole = performerRole?.toBuilder()
        builder.performer = performer?.toBuilder()
        builder.performerLinkId = performerLinkId.toBuilderList()
        builder.reasonCode = reasonCode.toBuilderList()
        builder.reasonReference = reasonReference.toBuilderList()
        builder.reason = reason.toBuilderList()
        builder.reasonLinkId = reasonLinkId.toBuilderList()
        builder.note = note.toBuilderList()
        builder.securityLabelNumber = securityLabelNumber.toBuilderList()
        return builder
      }

      /** Entity of the action. */
      @Serializable(with = ContractTermActionSubjectSerializer::class)
      public data class Subject(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /** The entity the action is performed or not performed on or for. */
        public val reference: List<Reference>,
        /** Role type of agent assigned roles in this Contract. */
        public val role: CodeableConcept? = null,
      ) : BackboneElement(), FhirBuildable {
        override fun toBuilder(): Builder {
          val builder = Builder(reference.toBuilderList())
          builder.id = id
          builder.extension = extension.toBuilderList()
          builder.modifierExtension = modifierExtension.toBuilderList()
          builder.role = role?.toBuilder()
          return builder
        }

        public class Builder(
          /** The entity the action is performed or not performed on or for. */
          public var reference: MutableList<Reference.Builder>
        ) : FhirBuilder {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /** Role type of agent assigned roles in this Contract. */
          public var role: CodeableConcept.Builder? = null

          override fun build(): Subject =
            Subject(
              id = id,
              extension = extension.buildList(),
              modifierExtension = modifierExtension.buildList(),
              reference = reference.buildList(),
              role = role?.build(),
            )
        }
      }

      public sealed interface Occurrence : FhirChoice {
        public fun asDateTime(): DateTime? = this as? DateTime

        public fun asPeriod(): Period? = this as? Period

        public fun asTiming(): Timing? = this as? Timing

        public data class DateTime(override val `value`: dev.ohs.fhir.model.r4b.DateTime) :
          Occurrence

        public data class Period(override val `value`: dev.ohs.fhir.model.r4b.Period) : Occurrence

        public data class Timing(override val `value`: dev.ohs.fhir.model.r4b.Timing) : Occurrence

        public companion object {
          internal fun from(
            dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
            periodValue: dev.ohs.fhir.model.r4b.Period?,
            timingValue: dev.ohs.fhir.model.r4b.Timing?,
          ): Occurrence? {
            if (dateTimeValue != null) return DateTime(dateTimeValue)
            if (periodValue != null) return Period(periodValue)
            if (timingValue != null) return Timing(timingValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * Activity or service obligation to be done or not done, performed or not performed,
         * effectuated or not by this Contract term.
         */
        public var type: CodeableConcept.Builder,
        /** Reason or purpose for the action stipulated by this Contract Provision. */
        public var intent: CodeableConcept.Builder,
        /** Current state of the term action. */
        public var status: CodeableConcept.Builder,
      ) : FhirBuilder {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and manageable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** True if the term prohibits the action. */
        public var doNotPerform: Boolean.Builder? = null

        /** Entity of the action. */
        public var subject: MutableList<Subject.Builder> = mutableListOf()

        /**
         * Id [identifier??] of the clause or question text related to this action in the referenced
         * form or QuestionnaireResponse.
         */
        public var linkId: MutableList<String.Builder> = mutableListOf()

        /** Encounter or Episode with primary association to specified term activity. */
        public var context: Reference.Builder? = null

        /**
         * Id [identifier??] of the clause or question text related to the requester of this action
         * in the referenced form or QuestionnaireResponse.
         */
        public var contextLinkId: MutableList<String.Builder> = mutableListOf()

        /** When action happens. */
        public var occurrence: Occurrence? = null

        /** Who or what initiated the action and has responsibility for its activation. */
        public var requester: MutableList<Reference.Builder> = mutableListOf()

        /**
         * Id [identifier??] of the clause or question text related to the requester of this action
         * in the referenced form or QuestionnaireResponse.
         */
        public var requesterLinkId: MutableList<String.Builder> = mutableListOf()

        /**
         * The type of individual that is desired or required to perform or not perform the action.
         */
        public var performerType: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * The type of role or competency of an individual desired or required to perform or not
         * perform the action.
         */
        public var performerRole: CodeableConcept.Builder? = null

        /** Indicates who or what is being asked to perform (or not perform) the ction. */
        public var performer: Reference.Builder? = null

        /**
         * Id [identifier??] of the clause or question text related to the reason type or reference
         * of this action in the referenced form or QuestionnaireResponse.
         */
        public var performerLinkId: MutableList<String.Builder> = mutableListOf()

        /**
         * Rationale for the action to be performed or not performed. Describes why the action is
         * permitted or prohibited.
         */
        public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Indicates another resource whose existence justifies permitting or not permitting this
         * action.
         */
        public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

        /** Describes why the action is to be performed or not performed in textual form. */
        public var reason: MutableList<String.Builder> = mutableListOf()

        /**
         * Id [identifier??] of the clause or question text related to the reason type or reference
         * of this action in the referenced form or QuestionnaireResponse.
         */
        public var reasonLinkId: MutableList<String.Builder> = mutableListOf()

        /**
         * Comments made about the term action made by the requester, performer, subject or other
         * participants.
         */
        public var note: MutableList<Annotation.Builder> = mutableListOf()

        /** Security labels that protects the action. */
        public var securityLabelNumber: MutableList<UnsignedInt.Builder> = mutableListOf()

        override fun build(): Action =
          Action(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            doNotPerform = doNotPerform?.build(),
            type = type.build(),
            subject = subject.buildList(),
            intent = intent.build(),
            linkId = linkId.buildList(),
            status = status.build(),
            context = context?.build(),
            contextLinkId = contextLinkId.buildList(),
            occurrence = occurrence,
            requester = requester.buildList(),
            requesterLinkId = requesterLinkId.buildList(),
            performerType = performerType.buildList(),
            performerRole = performerRole?.build(),
            performer = performer?.build(),
            performerLinkId = performerLinkId.buildList(),
            reasonCode = reasonCode.buildList(),
            reasonReference = reasonReference.buildList(),
            reason = reason.buildList(),
            reasonLinkId = reasonLinkId.buildList(),
            note = note.buildList(),
            securityLabelNumber = securityLabelNumber.buildList(),
          )
      }
    }

    public sealed interface Topic : FhirChoice {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
      ) : Topic

      public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) : Topic

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        ): Topic? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /** The matter of concern in the context of this provision of the agrement. */
      public var offer: Offer.Builder
    ) : FhirBuilder {
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

      /** Unique identifier for this particular Contract Provision. */
      public var identifier: Identifier.Builder? = null

      /** When this Contract Provision was issued. */
      public var issued: DateTime.Builder? = null

      /** Relevant time or time-period when this Contract Provision is applicable. */
      public var applies: Period.Builder? = null

      /** The entity that the term applies to. */
      public var topic: Topic? = null

      /**
       * A legal clause or condition contained within a contract that requires one or both parties
       * to perform a particular requirement by some specified time or prevents one or both parties
       * from performing a particular requirement by some specified time.
       */
      public var type: CodeableConcept.Builder? = null

      /** A specialized legal clause or condition based on overarching contract type. */
      public var subType: CodeableConcept.Builder? = null

      /** Statement of a provision in a policy or a contract. */
      public var text: String.Builder? = null

      /**
       * Security labels that protect the handling of information about the term and its elements,
       * which may be specifically identified..
       */
      public var securityLabel: MutableList<SecurityLabel.Builder> = mutableListOf()

      /** Contract Term Asset List. */
      public var asset: MutableList<Asset.Builder> = mutableListOf()

      /**
       * An actor taking a role in an activity for which it can be assigned some degree of
       * responsibility for the activity taking place.
       *
       * Several agents may be associated (i.e. has some responsibility for an activity) with an
       * activity and vice-versa. For example, in cases of actions initiated by one user for other
       * users, or in events that involve more than one user, hardware device, software, or system
       * process. However, only one user may be the initiator/requestor for the event.
       */
      public var action: MutableList<Action.Builder> = mutableListOf()

      /** Nested group of Contract Provisions. */
      public var group: MutableList<Builder> = mutableListOf()

      override fun build(): Term =
        Term(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          identifier = identifier?.build(),
          issued = issued?.build(),
          applies = applies?.build(),
          topic = topic,
          type = type?.build(),
          subType = subType?.build(),
          text = text?.build(),
          securityLabel = securityLabel.buildList(),
          offer = offer.build(),
          asset = asset.buildList(),
          action = action.buildList(),
          group = group.buildList(),
        )
    }
  }

  /**
   * Parties with legal standing in the Contract, including the principal parties, the grantor(s)
   * and grantee(s), which are any person or organization bound by the contract, and any ancillary
   * parties, which facilitate the execution of the contract such as a notary or witness.
   */
  @Serializable(with = ContractSignerSerializer::class)
  public data class Signer(
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
    /** Role of this Contract signer, e.g. notary, grantee. */
    public val type: Coding,
    /** Party which is a signator to this Contract. */
    public val party: Reference,
    /** Legally binding Contract DSIG signature contents in Base64. */
    public val signature: List<Signature>,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder =
        Builder(
          type.toBuilder(),
          party.toBuilder(),
          signature.toBuilderList(),
        )
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public class Builder(
      /** Role of this Contract signer, e.g. notary, grantee. */
      public var type: Coding.Builder,
      /** Party which is a signator to this Contract. */
      public var party: Reference.Builder,
      /** Legally binding Contract DSIG signature contents in Base64. */
      public var signature: MutableList<Signature.Builder>,
    ) : FhirBuilder {
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

      override fun build(): Signer =
        Signer(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type.build(),
          party = party.build(),
          signature = signature.buildList(),
        )
    }
  }

  /**
   * The "patient friendly language" versionof the Contract in whole or in parts. "Patient friendly
   * language" means the representation of the Contract and Contract Provisions in a manner that is
   * readily accessible and understandable by a layperson in accordance with best practices for
   * communication styles that ensure that those agreeing to or signing the Contract understand the
   * roles, actions, obligations, responsibilities, and implication of the agreement.
   */
  @Serializable(with = ContractFriendlySerializer::class)
  public data class Friendly(
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
     * Human readable rendering of this Contract in a format and representation intended to enhance
     * comprehension and ensure understandability.
     */
    public val content: Content,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(content)
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public sealed interface Content : FhirChoice {
      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asReference(): Reference? = this as? Reference

      public data class Attachment(override val `value`: dev.ohs.fhir.model.r4b.Attachment) :
        Content

      public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) : Content

      public companion object {
        internal fun from(
          attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
          referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        ): Content? {
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * Human readable rendering of this Contract in a format and representation intended to
       * enhance comprehension and ensure understandability.
       */
      public var content: Content
    ) : FhirBuilder {
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

      override fun build(): Friendly =
        Friendly(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          content = content,
        )
    }
  }

  /** List of Legal expressions or representations of this Contract. */
  @Serializable(with = ContractLegalSerializer::class)
  public data class Legal(
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
    /** Contract legal text in human renderable form. */
    public val content: Content,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(content)
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public sealed interface Content : FhirChoice {
      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asReference(): Reference? = this as? Reference

      public data class Attachment(override val `value`: dev.ohs.fhir.model.r4b.Attachment) :
        Content

      public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) : Content

      public companion object {
        internal fun from(
          attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
          referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        ): Content? {
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /** Contract legal text in human renderable form. */
      public var content: Content
    ) : FhirBuilder {
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

      override fun build(): Legal =
        Legal(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          content = content,
        )
    }
  }

  /** List of Computable Policy Rule Language Representations of this Contract. */
  @Serializable(with = ContractRuleSerializer::class)
  public data class Rule(
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
    /** Computable Contract conveyed using a policy rule language (e.g. XACML, DKAL, SecPal). */
    public val content: Content,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(content)
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public sealed interface Content : FhirChoice {
      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asReference(): Reference? = this as? Reference

      public data class Attachment(override val `value`: dev.ohs.fhir.model.r4b.Attachment) :
        Content

      public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) : Content

      public companion object {
        internal fun from(
          attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
          referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        ): Content? {
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /** Computable Contract conveyed using a policy rule language (e.g. XACML, DKAL, SecPal). */
      public var content: Content
    ) : FhirBuilder {
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

      override fun build(): Rule =
        Rule(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          content = content,
        )
    }
  }

  public sealed interface Topic : FhirChoice {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(
      override val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
    ) : Topic

    public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) : Topic

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
      ): Topic? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public sealed interface LegallyBinding : FhirChoice {
    public fun asAttachment(): Attachment? = this as? Attachment

    public fun asReference(): Reference? = this as? Reference

    public data class Attachment(override val `value`: dev.ohs.fhir.model.r4b.Attachment) :
      LegallyBinding

    public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) :
      LegallyBinding

    public companion object {
      internal fun from(
        attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
      ): LegallyBinding? {
        if (attachmentValue != null) return Attachment(attachmentValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
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
    override var id: kotlin.String? = null

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

    /** Unique identifier for this Contract or a derivative that references a Source Contract. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Canonical identifier for this contract, represented as a URI (globally unique).
     *
     * Used in a domain that uses a supplied contract repository.
     */
    public var url: Uri.Builder? = null

    /**
     * An edition identifier used for business purposes to label business significant variants.
     *
     * Note - This is a business versionId, not a resource version id (see discussion
     * http://build.fhir.org/resource.html#versions) Comments - There may be different contract
     * instances that have the same identifier but different versions. The version can be appended
     * to the url in a reference to allow a reference to a particular business version of the plan
     * definition with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * The status of the resource instance.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * contract as not currently valid or active.
     */
    public var status: Enumeration<ContractResourceStatusCodes>? = null

    /**
     * Legal states of the formation of a legal instrument, which is a formally executed written
     * document that can be formally attributed to its author, records and formally expresses a
     * legally enforceable act, process, or contractual duty, obligation, or right, and therefore
     * evidences that act, process, or agreement.
     */
    public var legalState: CodeableConcept.Builder? = null

    /**
     * The URL pointing to a FHIR-defined Contract Definition that is adhered to in whole or part by
     * this Contract.
     */
    public var instantiatesCanonical: Reference.Builder? = null

    /**
     * The URL pointing to an externally maintained definition that is adhered to in whole or in
     * part by this Contract.
     */
    public var instantiatesUri: Uri.Builder? = null

    /**
     * The minimal content derived from the basal information source at a specific stage in its
     * lifecycle.
     */
    public var contentDerivative: CodeableConcept.Builder? = null

    /** When this Contract was issued. */
    public var issued: DateTime.Builder? = null

    /** Relevant time or time-period when this Contract is applicable. */
    public var applies: Period.Builder? = null

    /**
     * Event resulting in discontinuation or termination of this Contract instance by one or more
     * parties to the contract.
     */
    public var expirationType: CodeableConcept.Builder? = null

    /**
     * The target entity impacted by or of interest to parties to the agreement.
     *
     * The Contract.subject is an entity that has some role with respect to the Contract.topic and
     * Contract.topic.term, which is of focal interest to the parties to the contract and likely
     * impacted in a significant way by the Contract.action/Contract.action.reason and the
     * Contract.term.action/Contract.action.reason. In many cases, the Contract.subject is a
     * Contract.signer if the subject is an adult; has a legal interest in the contract; and
     * incompetent to participate in the contract agreement.
     */
    public var subject: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A formally or informally recognized grouping of people, principals, organizations, or
     * jurisdictions formed for the purpose of achieving some form of collective action such as the
     * promulgation, administration and enforcement of contracts and policies.
     */
    public var authority: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Recognized governance framework or system operating with a circumscribed scope in accordance
     * with specified principles, policies, processes or procedures for managing rights, actions, or
     * behaviors of parties or principals relative to resources.
     */
    public var domain: MutableList<Reference.Builder> = mutableListOf()

    /** Sites in which the contract is complied with, exercised, or in force. */
    public var site: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A natural language name identifying this Contract definition, derivative, or instance in any
     * legal state. Provides additional information about its content. This name should be usable as
     * an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for this Contract definition, derivative, or
     * instance in any legal state.t giving additional information about its content.
     */
    public var title: String.Builder? = null

    /**
     * An explanatory or alternate user-friendly title for this Contract definition, derivative, or
     * instance in any legal state.t giving additional information about its content.
     */
    public var subtitle: String.Builder? = null

    /**
     * Alternative representation of the title for this Contract definition, derivative, or instance
     * in any legal state., e.g., a domain specific contract number related to legislation.
     */
    public var alias: MutableList<String.Builder> = mutableListOf()

    /**
     * The individual or organization that authored the Contract definition, derivative, or instance
     * in any legal state.
     */
    public var author: Reference.Builder? = null

    /**
     * A selector of legal concerns for this Contract definition, derivative, or instance in any
     * legal state.
     */
    public var scope: CodeableConcept.Builder? = null

    /**
     * Narrows the range of legal concerns to focus on the achievement of specific contractual
     * objectives.
     */
    public var topic: Topic? = null

    /**
     * A high-level category for the legal instrument, whether constructed as a Contract definition,
     * derivative, or instance in any legal state. Provides additional information about its content
     * within the context of the Contract's scope to distinguish the kinds of systems that would be
     * interested in the contract.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * Sub-category for the Contract that distinguishes the kinds of systems that would be
     * interested in the Contract within the context of the Contract's scope.
     */
    public var subType: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Precusory content developed with a focus and intent of supporting the formation a Contract
     * instance, which may be associated with and transformable into a Contract.
     */
    public var contentDefinition: ContentDefinition.Builder? = null

    /**
     * One or more Contract Provisions, which may be related and conveyed as a group, and may
     * contain nested groups.
     */
    public var term: MutableList<Term.Builder> = mutableListOf()

    /**
     * Information that may be needed by/relevant to the performer in their execution of this term
     * action.
     */
    public var supportingInfo: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Links to Provenance records for past versions of this Contract definition, derivative, or
     * instance, which identify key state transitions or updates that are likely to be relevant to a
     * user looking at the current version of the Contract. The Provence.entity indicates the target
     * that was changed in the update.
     * http://build.fhir.org/provenance-definitions.html#Provenance.entity.
     */
    public var relevantHistory: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Parties with legal standing in the Contract, including the principal parties, the grantor(s)
     * and grantee(s), which are any person or organization bound by the contract, and any ancillary
     * parties, which facilitate the execution of the contract such as a notary or witness.
     *
     * Signers who are principal parties to the contract are bound by the Contract.activity related
     * to the Contract.topic, and the Contract.term(s), which either extend or restrict the overall
     * action on the topic by, for example, stipulating specific policies or obligations
     * constraining actions, action reason, or agents with respect to some or all of the topic. For
     * example, specifying how policies or obligations shall constrain actions and action reasons
     * permitted or denied on all or a subset of the Contract.topic (e.g., all or a portion of
     * property being transferred by the contract), agents (e.g., who can resell, assign interests,
     * or alter the property being transferred by the contract), actions, and action reasons; or
     * with respect to Contract.terms, stipulating, extending, or limiting the Contract.period of
     * applicability or valuation of items under consideration.
     */
    public var signer: MutableList<Signer.Builder> = mutableListOf()

    /**
     * The "patient friendly language" versionof the Contract in whole or in parts. "Patient
     * friendly language" means the representation of the Contract and Contract Provisions in a
     * manner that is readily accessible and understandable by a layperson in accordance with best
     * practices for communication styles that ensure that those agreeing to or signing the Contract
     * understand the roles, actions, obligations, responsibilities, and implication of the
     * agreement.
     */
    public var friendly: MutableList<Friendly.Builder> = mutableListOf()

    /** List of Legal expressions or representations of this Contract. */
    public var legal: MutableList<Legal.Builder> = mutableListOf()

    /** List of Computable Policy Rule Language Representations of this Contract. */
    public var rule: MutableList<Rule.Builder> = mutableListOf()

    /**
     * Legally binding Contract: This is the signed and legally recognized representation of the
     * Contract, which is considered the "source of truth" and which would be the basis for legal
     * action related to enforcement of this Contract.
     */
    public var legallyBinding: LegallyBinding? = null

    override fun build(): Contract =
      Contract(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        url = url?.build(),
        version = version?.build(),
        status = status,
        legalState = legalState?.build(),
        instantiatesCanonical = instantiatesCanonical?.build(),
        instantiatesUri = instantiatesUri?.build(),
        contentDerivative = contentDerivative?.build(),
        issued = issued?.build(),
        applies = applies?.build(),
        expirationType = expirationType?.build(),
        subject = subject.buildList(),
        authority = authority.buildList(),
        domain = domain.buildList(),
        site = site.buildList(),
        name = name?.build(),
        title = title?.build(),
        subtitle = subtitle?.build(),
        alias = alias.buildList(),
        author = author?.build(),
        scope = scope?.build(),
        topic = topic,
        type = type?.build(),
        subType = subType.buildList(),
        contentDefinition = contentDefinition?.build(),
        term = term.buildList(),
        supportingInfo = supportingInfo.buildList(),
        relevantHistory = relevantHistory.buildList(),
        signer = signer.buildList(),
        friendly = friendly.buildList(),
        legal = legal.buildList(),
        rule = rule.buildList(),
        legallyBinding = legallyBinding,
      )
  }
}
