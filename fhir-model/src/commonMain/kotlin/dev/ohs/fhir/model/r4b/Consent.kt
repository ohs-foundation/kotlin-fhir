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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.ConsentPolicySerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentProvisionActorSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentProvisionDataSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentProvisionSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentSourceSerializer
import dev.ohs.fhir.model.r4b.serializers.ConsentVerificationSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of a healthcare consumer’s choices, which permits or denies identified recipient(s) or
 * recipient role(s) to perform one or more actions within a given policy context, for specific
 * purposes and periods of time.
 */
@Serializable(with = ConsentSerializer::class)
@SerialName("Consent")
public data class Consent(
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
  /**
   * Unique identifier for this copy of the Consent Statement.
   *
   * This identifier identifies this copy of the consent. Where this identifier is also used
   * elsewhere as the identifier for a consent record (e.g. a CDA consent document) then the consent
   * details are expected to be the same.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Indicates the current state of this consent.
   *
   * This element is labeled as a modifier because the status contains the codes rejected and
   * entered-in-error that mark the Consent as not currently valid.
   */
  public val status: Enumeration<ConsentState>,
  /**
   * A selector of the type of consent being presented: ADR, Privacy, Treatment, Research. This list
   * is now extensible.
   */
  public val scope: CodeableConcept,
  /**
   * A classification of the type of consents found in the statement. This element supports indexing
   * and retrieval of consent statements.
   */
  public val category: List<CodeableConcept>,
  /**
   * The patient/healthcare consumer to whom this consent applies.
   *
   * Commonly, the patient the consent pertains to is the author, but for young and old people, it
   * may be some other person.
   */
  public val patient: Reference? = null,
  /**
   * When this Consent was issued / created / indexed.
   *
   * This is not the time of the original consent, but the time that this statement was made or
   * derived.
   */
  public val dateTime: DateTime? = null,
  /**
   * Either the Grantor, which is the entity responsible for granting the rights listed in a Consent
   * Directive or the Grantee, which is the entity responsible for complying with the Consent
   * Directive, including any obligations or limitations on authorizations and enforcement of
   * prohibitions.
   *
   * Commonly, the patient the consent pertains to is the consentor, but particularly for young and
   * old people, it may be some other person - e.g. a legal guardian.
   */
  public val performer: List<Reference> = listOf(),
  /** The organization that manages the consent, and the framework within which it is executed. */
  public val organization: List<Reference> = listOf(),
  /**
   * The source on which this consent statement is based. The source might be a scanned original
   * paper form, or a reference to a consent that links back to such a source, a reference to a
   * document repository (e.g. XDS) that stores the original consent document.
   *
   * The source can be contained inline (Attachment), referenced directly (Consent), referenced in a
   * consent repository (DocumentReference), or simply by an identifier (Identifier), e.g. a CDA
   * document id.
   */
  public val source: Source? = null,
  /**
   * The references to the policies that are included in this consent scope. Policies may be
   * organizational, but are often defined jurisdictionally, or in law.
   */
  public val policy: List<Policy> = listOf(),
  /**
   * A reference to the specific base computable regulation or policy.
   *
   * If the policyRule is absent, computable consent would need to be constructed from the elements
   * of the Consent resource.
   */
  public val policyRule: CodeableConcept? = null,
  /**
   * Whether a treatment instruction (e.g. artificial respiration yes or no) was verified with the
   * patient, his/her family or another authorized person.
   */
  public val verification: List<Verification> = listOf(),
  /**
   * An exception to the base policy of this consent. An exception can be an addition or removal of
   * access permissions.
   */
  public val provision: Provision? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, scope.toBuilder(), category.map { it.toBuilder() }.toMutableList()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        patient = this@with.patient?.toBuilder()
        dateTime = this@with.dateTime?.toBuilder()
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        organization = this@with.organization.map { it.toBuilder() }.toMutableList()
        source = this@with.source
        policy = this@with.policy.map { it.toBuilder() }.toMutableList()
        policyRule = this@with.policyRule?.toBuilder()
        verification = this@with.verification.map { it.toBuilder() }.toMutableList()
        provision = this@with.provision?.toBuilder()
      }
    }

  /**
   * The references to the policies that are included in this consent scope. Policies may be
   * organizational, but are often defined jurisdictionally, or in law.
   */
  @Serializable(with = ConsentPolicySerializer::class)
  public data class Policy(
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
     * Entity or Organization having regulatory jurisdiction or accountability for enforcing
     * policies pertaining to Consent Directives.
     */
    public val authority: Uri? = null,
    /**
     * The references to the policies that are included in this consent scope. Policies may be
     * organizational, but are often defined jurisdictionally, or in law.
     *
     * This element is for discoverability / documentation and does not modify or qualify the policy
     * rules.
     */
    public val uri: Uri? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          authority = this@with.authority?.toBuilder()
          uri = this@with.uri?.toBuilder()
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
       * Entity or Organization having regulatory jurisdiction or accountability for enforcing
       * policies pertaining to Consent Directives.
       */
      public var authority: Uri.Builder? = null

      /**
       * The references to the policies that are included in this consent scope. Policies may be
       * organizational, but are often defined jurisdictionally, or in law.
       *
       * This element is for discoverability / documentation and does not modify or qualify the
       * policy rules.
       */
      public var uri: Uri.Builder? = null

      public fun build(): Policy =
        Policy(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          authority = authority?.build(),
          uri = uri?.build(),
        )
    }
  }

  /**
   * Whether a treatment instruction (e.g. artificial respiration yes or no) was verified with the
   * patient, his/her family or another authorized person.
   */
  @Serializable(with = ConsentVerificationSerializer::class)
  public data class Verification(
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
    /** Has the instruction been verified. */
    public val verified: Boolean,
    /** Who verified the instruction (Patient, Relative or other Authorized Person). */
    public val verifiedWith: Reference? = null,
    /** Date verification was collected. */
    public val verificationDate: DateTime? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(verified.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          verifiedWith = this@with.verifiedWith?.toBuilder()
          verificationDate = this@with.verificationDate?.toBuilder()
        }
      }

    public class Builder(
      /** Has the instruction been verified. */
      public var verified: Boolean.Builder
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

      /** Who verified the instruction (Patient, Relative or other Authorized Person). */
      public var verifiedWith: Reference.Builder? = null

      /** Date verification was collected. */
      public var verificationDate: DateTime.Builder? = null

      public fun build(): Verification =
        Verification(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          verified = verified.build(),
          verifiedWith = verifiedWith?.build(),
          verificationDate = verificationDate?.build(),
        )
    }
  }

  /**
   * An exception to the base policy of this consent. An exception can be an addition or removal of
   * access permissions.
   */
  @Serializable(with = ConsentProvisionSerializer::class)
  public data class Provision(
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
     * Action to take - permit or deny - when the rule conditions are met. Not permitted in root
     * rule, required in all nested rules.
     */
    public val type: Enumeration<ConsentProvisionType>? = null,
    /** The timeframe in this rule is valid. */
    public val period: Period? = null,
    /**
     * Who or what is controlled by this rule. Use group to identify a set of actors by some
     * property they share (e.g. 'admitting officers').
     */
    public val actor: List<Actor> = listOf(),
    /**
     * Actions controlled by this Rule.
     *
     * Note that this is the direct action (not the grounds for the action covered in the purpose
     * element). At present, the only action in the understood and tested scope of this resource is
     * 'read'.
     */
    public val action: List<CodeableConcept> = listOf(),
    /**
     * A security label, comprised of 0..* security label fields (Privacy tags), which define which
     * resources are controlled by this exception.
     *
     * If the consent specifies a security label of "R" then it applies to all resources that are
     * labeled "R" or lower. E.g. for Confidentiality, it's a high water mark. For other kinds of
     * security labels, subsumption logic applies. When the purpose of use tag is on the data,
     * access request purpose of use shall not conflict.
     */
    public val securityLabel: List<Coding> = listOf(),
    /**
     * The context of the activities a user is taking - why the user is accessing the data - that
     * are controlled by this rule.
     *
     * When the purpose of use tag is on the data, access request purpose of use shall not conflict.
     */
    public val purpose: List<Coding> = listOf(),
    /**
     * The class of information covered by this rule. The type can be a FHIR resource type, a
     * profile on a type, or a CDA document, or some other type that indicates what sort of
     * information the consent relates to.
     *
     * Multiple types are or'ed together. The intention of the contentType element is that the codes
     * refer to profiles or document types defined in a standard or an implementation guide
     * somewhere.
     */
    public val `class`: List<Coding> = listOf(),
    /**
     * If this code is found in an instance, then the rule applies.
     *
     * Typical use of this is a Document code with class = CDA.
     */
    public val code: List<CodeableConcept> = listOf(),
    /**
     * Clinical or Operational Relevant period of time that bounds the data controlled by this rule.
     *
     * This has a different sense to the Consent.period - that is when the consent agreement holds.
     * This is the time period of the data that is controlled by the agreement.
     */
    public val dataPeriod: Period? = null,
    /** The resources controlled by this rule if specific resources are referenced. */
    public val `data`: List<Data> = listOf(),
    /** Rules which provide exceptions to the base rule or subrules. */
    public val provision: List<Provision> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type
          period = this@with.period?.toBuilder()
          actor = this@with.actor.map { it.toBuilder() }.toMutableList()
          action = this@with.action.map { it.toBuilder() }.toMutableList()
          securityLabel = this@with.securityLabel.map { it.toBuilder() }.toMutableList()
          purpose = this@with.purpose.map { it.toBuilder() }.toMutableList()
          `class` = this@with.`class`.map { it.toBuilder() }.toMutableList()
          code = this@with.code.map { it.toBuilder() }.toMutableList()
          dataPeriod = this@with.dataPeriod?.toBuilder()
          `data` = this@with.`data`.map { it.toBuilder() }.toMutableList()
          provision = this@with.provision.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Who or what is controlled by this rule. Use group to identify a set of actors by some
     * property they share (e.g. 'admitting officers').
     */
    @Serializable(with = ConsentProvisionActorSerializer::class)
    public data class Actor(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: String? = null,
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
      /**
       * How the individual is involved in the resources content that is described in the exception.
       */
      public val role: CodeableConcept,
      /**
       * The resource that identifies the actor. To identify actors by type, use group to identify a
       * set of actors by some property they share (e.g. 'admitting officers').
       */
      public val reference: Reference,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(role.toBuilder(), reference.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * How the individual is involved in the resources content that is described in the
         * exception.
         */
        public var role: CodeableConcept.Builder,
        /**
         * The resource that identifies the actor. To identify actors by type, use group to identify
         * a set of actors by some property they share (e.g. 'admitting officers').
         */
        public var reference: Reference.Builder,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: String? = null

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

        public fun build(): Actor =
          Actor(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            role = role.build(),
            reference = reference.build(),
          )
      }
    }

    /** The resources controlled by this rule if specific resources are referenced. */
    @Serializable(with = ConsentProvisionDataSerializer::class)
    public data class Data(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: String? = null,
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
      /** How the resource reference is interpreted when testing consent restrictions. */
      public val meaning: Enumeration<ConsentDataMeaning>,
      /**
       * A reference to a specific resource that defines which resources are covered by this
       * consent.
       */
      public val reference: Reference,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(meaning, reference.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** How the resource reference is interpreted when testing consent restrictions. */
        public var meaning: Enumeration<ConsentDataMeaning>,
        /**
         * A reference to a specific resource that defines which resources are covered by this
         * consent.
         */
        public var reference: Reference.Builder,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: String? = null

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

        public fun build(): Data =
          Data(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            meaning = meaning,
            reference = reference.build(),
          )
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
       * Action to take - permit or deny - when the rule conditions are met. Not permitted in root
       * rule, required in all nested rules.
       */
      public var type: Enumeration<ConsentProvisionType>? = null

      /** The timeframe in this rule is valid. */
      public var period: Period.Builder? = null

      /**
       * Who or what is controlled by this rule. Use group to identify a set of actors by some
       * property they share (e.g. 'admitting officers').
       */
      public var actor: MutableList<Actor.Builder> = mutableListOf()

      /**
       * Actions controlled by this Rule.
       *
       * Note that this is the direct action (not the grounds for the action covered in the purpose
       * element). At present, the only action in the understood and tested scope of this resource
       * is 'read'.
       */
      public var action: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * A security label, comprised of 0..* security label fields (Privacy tags), which define
       * which resources are controlled by this exception.
       *
       * If the consent specifies a security label of "R" then it applies to all resources that are
       * labeled "R" or lower. E.g. for Confidentiality, it's a high water mark. For other kinds of
       * security labels, subsumption logic applies. When the purpose of use tag is on the data,
       * access request purpose of use shall not conflict.
       */
      public var securityLabel: MutableList<Coding.Builder> = mutableListOf()

      /**
       * The context of the activities a user is taking - why the user is accessing the data - that
       * are controlled by this rule.
       *
       * When the purpose of use tag is on the data, access request purpose of use shall not
       * conflict.
       */
      public var purpose: MutableList<Coding.Builder> = mutableListOf()

      /**
       * The class of information covered by this rule. The type can be a FHIR resource type, a
       * profile on a type, or a CDA document, or some other type that indicates what sort of
       * information the consent relates to.
       *
       * Multiple types are or'ed together. The intention of the contentType element is that the
       * codes refer to profiles or document types defined in a standard or an implementation guide
       * somewhere.
       */
      public var `class`: MutableList<Coding.Builder> = mutableListOf()

      /**
       * If this code is found in an instance, then the rule applies.
       *
       * Typical use of this is a Document code with class = CDA.
       */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Clinical or Operational Relevant period of time that bounds the data controlled by this
       * rule.
       *
       * This has a different sense to the Consent.period - that is when the consent agreement
       * holds. This is the time period of the data that is controlled by the agreement.
       */
      public var dataPeriod: Period.Builder? = null

      /** The resources controlled by this rule if specific resources are referenced. */
      public var `data`: MutableList<Data.Builder> = mutableListOf()

      /** Rules which provide exceptions to the base rule or subrules. */
      public var provision: MutableList<Builder> = mutableListOf()

      public fun build(): Provision =
        Provision(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          period = period?.build(),
          actor = actor.map { it.build() },
          action = action.map { it.build() },
          securityLabel = securityLabel.map { it.build() },
          purpose = purpose.map { it.build() },
          `class` = `class`.map { it.build() },
          code = code.map { it.build() },
          dataPeriod = dataPeriod?.build(),
          `data` = `data`.map { it.build() },
          provision = provision.map { it.build() },
        )
    }
  }

  @Serializable(with = ConsentSourceSerializer::class)
  public sealed interface Source {
    public fun asAttachment(): Attachment? = this as? Attachment

    public fun asReference(): Reference? = this as? Reference

    public data class Attachment(public val `value`: dev.ohs.fhir.model.r4b.Attachment) : Source

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Source

    public companion object {
      internal fun from(
        attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
      ): Source? {
        if (attachmentValue != null) return Attachment(attachmentValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * Indicates the current state of this consent.
     *
     * This element is labeled as a modifier because the status contains the codes rejected and
     * entered-in-error that mark the Consent as not currently valid.
     */
    public var status: Enumeration<ConsentState>,
    /**
     * A selector of the type of consent being presented: ADR, Privacy, Treatment, Research. This
     * list is now extensible.
     */
    public var scope: CodeableConcept.Builder,
    /**
     * A classification of the type of consents found in the statement. This element supports
     * indexing and retrieval of consent statements.
     */
    public var category: MutableList<CodeableConcept.Builder>,
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

    /**
     * Unique identifier for this copy of the Consent Statement.
     *
     * This identifier identifies this copy of the consent. Where this identifier is also used
     * elsewhere as the identifier for a consent record (e.g. a CDA consent document) then the
     * consent details are expected to be the same.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The patient/healthcare consumer to whom this consent applies.
     *
     * Commonly, the patient the consent pertains to is the author, but for young and old people, it
     * may be some other person.
     */
    public var patient: Reference.Builder? = null

    /**
     * When this Consent was issued / created / indexed.
     *
     * This is not the time of the original consent, but the time that this statement was made or
     * derived.
     */
    public var dateTime: DateTime.Builder? = null

    /**
     * Either the Grantor, which is the entity responsible for granting the rights listed in a
     * Consent Directive or the Grantee, which is the entity responsible for complying with the
     * Consent Directive, including any obligations or limitations on authorizations and enforcement
     * of prohibitions.
     *
     * Commonly, the patient the consent pertains to is the consentor, but particularly for young
     * and old people, it may be some other person - e.g. a legal guardian.
     */
    public var performer: MutableList<Reference.Builder> = mutableListOf()

    /** The organization that manages the consent, and the framework within which it is executed. */
    public var organization: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The source on which this consent statement is based. The source might be a scanned original
     * paper form, or a reference to a consent that links back to such a source, a reference to a
     * document repository (e.g. XDS) that stores the original consent document.
     *
     * The source can be contained inline (Attachment), referenced directly (Consent), referenced in
     * a consent repository (DocumentReference), or simply by an identifier (Identifier), e.g. a CDA
     * document id.
     */
    public var source: Source? = null

    /**
     * The references to the policies that are included in this consent scope. Policies may be
     * organizational, but are often defined jurisdictionally, or in law.
     */
    public var policy: MutableList<Policy.Builder> = mutableListOf()

    /**
     * A reference to the specific base computable regulation or policy.
     *
     * If the policyRule is absent, computable consent would need to be constructed from the
     * elements of the Consent resource.
     */
    public var policyRule: CodeableConcept.Builder? = null

    /**
     * Whether a treatment instruction (e.g. artificial respiration yes or no) was verified with the
     * patient, his/her family or another authorized person.
     */
    public var verification: MutableList<Verification.Builder> = mutableListOf()

    /**
     * An exception to the base policy of this consent. An exception can be an addition or removal
     * of access permissions.
     */
    public var provision: Provision.Builder? = null

    override fun build(): Consent =
      Consent(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        status = status,
        scope = scope.build(),
        category = category.map { it.build() },
        patient = patient?.build(),
        dateTime = dateTime?.build(),
        performer = performer.map { it.build() },
        organization = organization.map { it.build() },
        source = source,
        policy = policy.map { it.build() },
        policyRule = policyRule?.build(),
        verification = verification.map { it.build() },
        provision = provision?.build(),
      )
  }

  /** How a rule statement is applied, such as adding additional consent or removing consent. */
  public enum class ConsentProvisionType(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Deny("deny", "http://hl7.org/fhir/consent-provision-type", "Opt Out"),
    Permit("permit", "http://hl7.org/fhir/consent-provision-type", "Opt In");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): ConsentProvisionType =
        when (code) {
          "deny" -> Deny
          "permit" -> Permit
          else -> throw IllegalArgumentException("Unknown code $code for enum ConsentProvisionType")
        }
    }
  }

  /** How a resource reference is interpreted when testing consent restrictions. */
  public enum class ConsentDataMeaning(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Instance("instance", "http://hl7.org/fhir/consent-data-meaning", "Instance"),
    Related("related", "http://hl7.org/fhir/consent-data-meaning", "Related"),
    Dependents("dependents", "http://hl7.org/fhir/consent-data-meaning", "Dependents"),
    Authoredby("authoredby", "http://hl7.org/fhir/consent-data-meaning", "AuthoredBy");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): ConsentDataMeaning =
        when (code) {
          "instance" -> Instance
          "related" -> Related
          "dependents" -> Dependents
          "authoredby" -> Authoredby
          else -> throw IllegalArgumentException("Unknown code $code for enum ConsentDataMeaning")
        }
    }
  }

  /** Indicates the state of the consent. */
  public enum class ConsentState(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Draft("draft", "http://hl7.org/fhir/consent-state-codes", "Pending"),
    Proposed("proposed", "http://hl7.org/fhir/consent-state-codes", "Proposed"),
    Active("active", "http://hl7.org/fhir/consent-state-codes", "Active"),
    Rejected("rejected", "http://hl7.org/fhir/consent-state-codes", "Rejected"),
    Inactive("inactive", "http://hl7.org/fhir/consent-state-codes", "Inactive"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/consent-state-codes",
      "Entered in Error",
    );

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): ConsentState =
        when (code) {
          "draft" -> Draft
          "proposed" -> Proposed
          "active" -> Active
          "rejected" -> Rejected
          "inactive" -> Inactive
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum ConsentState")
        }
    }
  }
}
