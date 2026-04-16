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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.AccountBalanceSerializer
import dev.ohs.fhir.model.r5.serializers.AccountCoverageSerializer
import dev.ohs.fhir.model.r5.serializers.AccountDiagnosisSerializer
import dev.ohs.fhir.model.r5.serializers.AccountGuarantorSerializer
import dev.ohs.fhir.model.r5.serializers.AccountProcedureSerializer
import dev.ohs.fhir.model.r5.serializers.AccountRelatedAccountSerializer
import dev.ohs.fhir.model.r5.serializers.AccountSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A financial tool for tracking value accrued for a particular purpose. In the healthcare field,
 * used to track charges for a patient, cost centers, etc.
 */
@Serializable(with = AccountSerializer::class)
@SerialName("Account")
public data class Account(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
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
   * Unique identifier used to reference the account. Might or might not be intended for human use
   * (e.g. credit card number).
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Indicates whether the account is presently used/usable or not.
   *
   * This element is labeled as a modifier because the status contains the codes inactive and
   * entered-in-error that mark the Account as not currently valid.
   */
  public val status: Enumeration<AccountStatus>,
  /**
   * The BillingStatus tracks the lifecycle of the account through the billing process. It indicates
   * how transactions are treated when they are allocated to the account.
   */
  public val billingStatus: CodeableConcept? = null,
  /** Categorizes the account for reporting and searching purposes. */
  public val type: CodeableConcept? = null,
  /** Name used for the account when displaying it to humans in reports, etc. */
  public val name: String? = null,
  /**
   * Identifies the entity which incurs the expenses. While the immediate recipients of services or
   * goods might be entities related to the subject, the expenses were ultimately incurred by the
   * subject of the Account.
   *
   * Accounts can be applied to non-patients for tracking other non-patient related activities, such
   * as group services (patients not tracked, and costs charged to another body), or might not be
   * allocated.
   */
  public val subject: List<Reference> = listOf(),
  /**
   * The date range of services associated with this account.
   *
   * It is possible for transactions to be posted outside the service period, as long as the service
   * was provided within the defined service period.
   */
  public val servicePeriod: Period? = null,
  /**
   * The party(s) that are responsible for covering the payment of this account, and what order
   * should they be applied to the account.
   *
   * Typically. this may be some form of insurance, internal charges, or self-pay.
   *
   * Local or jurisdictional business rules may determine which coverage covers which types of
   * billable items charged to the account, and in which order. Where the order is important, a
   * local/jurisdictional extension may be defined to specify the order for the type of charge.
   */
  public val coverage: List<Coverage> = listOf(),
  /**
   * Indicates the service area, hospital, department, etc. with responsibility for managing the
   * Account.
   */
  public val owner: Reference? = null,
  /** Provides additional information about what the account tracks and how it is used. */
  public val description: Markdown? = null,
  /** The parties responsible for balancing the account if other payment options fall short. */
  public val guarantor: List<Guarantor> = listOf(),
  /**
   * When using an account for billing a specific Encounter the set of diagnoses that are relevant
   * for billing are stored here on the account where they are able to be sequenced appropriately
   * prior to processing to produce claim(s).
   */
  public val diagnosis: List<Diagnosis> = listOf(),
  /**
   * When using an account for billing a specific Encounter the set of procedures that are relevant
   * for billing are stored here on the account where they are able to be sequenced appropriately
   * prior to processing to produce claim(s).
   */
  public val procedure: List<Procedure> = listOf(),
  /** Other associated accounts related to this account. */
  public val relatedAccount: List<RelatedAccount> = listOf(),
  /** The default currency for the account. */
  public val currency: CodeableConcept? = null,
  /**
   * The calculated account balances - these are calculated and processed by the finance system.
   *
   * The balances with a `term` that is not current are usually generated/updated by an invoicing or
   * similar process.
   */
  public val balance: List<Balance> = listOf(),
  /**
   * Time the balance amount was calculated.
   *
   * The total(s) are not typically updated using the restful API but more often by back-end
   * processes included in a typical finance system.
   */
  public val calculatedAt: Instant? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        billingStatus = this@with.billingStatus?.toBuilder()
        type = this@with.type?.toBuilder()
        name = this@with.name?.toBuilder()
        subject = this@with.subject.map { it.toBuilder() }.toMutableList()
        servicePeriod = this@with.servicePeriod?.toBuilder()
        coverage = this@with.coverage.map { it.toBuilder() }.toMutableList()
        owner = this@with.owner?.toBuilder()
        description = this@with.description?.toBuilder()
        guarantor = this@with.guarantor.map { it.toBuilder() }.toMutableList()
        diagnosis = this@with.diagnosis.map { it.toBuilder() }.toMutableList()
        procedure = this@with.procedure.map { it.toBuilder() }.toMutableList()
        relatedAccount = this@with.relatedAccount.map { it.toBuilder() }.toMutableList()
        currency = this@with.currency?.toBuilder()
        balance = this@with.balance.map { it.toBuilder() }.toMutableList()
        calculatedAt = this@with.calculatedAt?.toBuilder()
      }
    }

  /**
   * The party(s) that are responsible for covering the payment of this account, and what order
   * should they be applied to the account.
   */
  @Serializable(with = AccountCoverageSerializer::class)
  public data class Coverage(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
     * The party(s) that contribute to payment (or part of) of the charges applied to this account
     * (including self-pay).
     *
     * A coverage may only be responsible for specific types of charges, and the sequence of the
     * coverages in the account could be important when processing billing.
     */
    public val coverage: Reference,
    /**
     * The priority of the coverage in the context of this account.
     *
     * It is common in some jurisdictions for there to be multiple coverages allocated to an
     * account, and a sequence is required to order the settling of the account (often with
     * insurance claiming).
     */
    public val priority: PositiveInt? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(coverage.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          priority = this@with.priority?.toBuilder()
        }
      }

    public class Builder(
      /**
       * The party(s) that contribute to payment (or part of) of the charges applied to this account
       * (including self-pay).
       *
       * A coverage may only be responsible for specific types of charges, and the sequence of the
       * coverages in the account could be important when processing billing.
       */
      public var coverage: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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
       * The priority of the coverage in the context of this account.
       *
       * It is common in some jurisdictions for there to be multiple coverages allocated to an
       * account, and a sequence is required to order the settling of the account (often with
       * insurance claiming).
       */
      public var priority: PositiveInt.Builder? = null

      public fun build(): Coverage =
        Coverage(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          coverage = coverage.build(),
          priority = priority?.build(),
        )
    }
  }

  /** The parties responsible for balancing the account if other payment options fall short. */
  @Serializable(with = AccountGuarantorSerializer::class)
  public data class Guarantor(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    /** The entity who is responsible. */
    public val party: Reference,
    /**
     * A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.
     */
    public val onHold: Boolean? = null,
    /** The timeframe during which the guarantor accepts responsibility for the account. */
    public val period: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(party.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          onHold = this@with.onHold?.toBuilder()
          period = this@with.period?.toBuilder()
        }
      }

    public class Builder(
      /** The entity who is responsible. */
      public var party: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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
       * A guarantor may be placed on credit hold or otherwise have their role temporarily
       * suspended.
       */
      public var onHold: Boolean.Builder? = null

      /** The timeframe during which the guarantor accepts responsibility for the account. */
      public var period: Period.Builder? = null

      public fun build(): Guarantor =
        Guarantor(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          party = party.build(),
          onHold = onHold?.build(),
          period = period?.build(),
        )
    }
  }

  /**
   * When using an account for billing a specific Encounter the set of diagnoses that are relevant
   * for billing are stored here on the account where they are able to be sequenced appropriately
   * prior to processing to produce claim(s).
   */
  @Serializable(with = AccountDiagnosisSerializer::class)
  public data class Diagnosis(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    /** Ranking of the diagnosis (for each type). */
    public val sequence: PositiveInt? = null,
    /** The diagnosis relevant to the account. */
    public val condition: CodeableReference,
    /** Ranking of the diagnosis (for each type). */
    public val dateOfDiagnosis: DateTime? = null,
    /**
     * Type that this diagnosis has relevant to the account (e.g. admission, billing, discharge …).
     */
    public val type: List<CodeableConcept> = listOf(),
    /** Was the Diagnosis present on Admission in the related Encounter. */
    public val onAdmission: Boolean? = null,
    /**
     * The package code can be used to group diagnoses that may be priced or delivered as a single
     * product. Such as DRGs.
     */
    public val packageCode: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(condition.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          sequence = this@with.sequence?.toBuilder()
          dateOfDiagnosis = this@with.dateOfDiagnosis?.toBuilder()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          onAdmission = this@with.onAdmission?.toBuilder()
          packageCode = this@with.packageCode.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The diagnosis relevant to the account. */
      public var condition: CodeableReference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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

      /** Ranking of the diagnosis (for each type). */
      public var sequence: PositiveInt.Builder? = null

      /** Ranking of the diagnosis (for each type). */
      public var dateOfDiagnosis: DateTime.Builder? = null

      /**
       * Type that this diagnosis has relevant to the account (e.g. admission, billing, discharge
       * …).
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Was the Diagnosis present on Admission in the related Encounter. */
      public var onAdmission: Boolean.Builder? = null

      /**
       * The package code can be used to group diagnoses that may be priced or delivered as a single
       * product. Such as DRGs.
       */
      public var packageCode: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Diagnosis =
        Diagnosis(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence?.build(),
          condition = condition.build(),
          dateOfDiagnosis = dateOfDiagnosis?.build(),
          type = type.map { it.build() },
          onAdmission = onAdmission?.build(),
          packageCode = packageCode.map { it.build() },
        )
    }
  }

  /**
   * When using an account for billing a specific Encounter the set of procedures that are relevant
   * for billing are stored here on the account where they are able to be sequenced appropriately
   * prior to processing to produce claim(s).
   */
  @Serializable(with = AccountProcedureSerializer::class)
  public data class Procedure(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    /** Ranking of the procedure (for each type). */
    public val sequence: PositiveInt? = null,
    /** The procedure relevant to the account. */
    public val code: CodeableReference,
    /**
     * Date of the procedure when using a coded procedure. If using a reference to a procedure, then
     * the date on the procedure should be used.
     */
    public val dateOfService: DateTime? = null,
    /** How this procedure value should be used in charging the account. */
    public val type: List<CodeableConcept> = listOf(),
    /**
     * The package code can be used to group procedures that may be priced or delivered as a single
     * product. Such as DRGs.
     */
    public val packageCode: List<CodeableConcept> = listOf(),
    /** Any devices that were associated with the procedure relevant to the account. */
    public val device: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          sequence = this@with.sequence?.toBuilder()
          dateOfService = this@with.dateOfService?.toBuilder()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          packageCode = this@with.packageCode.map { it.toBuilder() }.toMutableList()
          device = this@with.device.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The procedure relevant to the account. */
      public var code: CodeableReference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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

      /** Ranking of the procedure (for each type). */
      public var sequence: PositiveInt.Builder? = null

      /**
       * Date of the procedure when using a coded procedure. If using a reference to a procedure,
       * then the date on the procedure should be used.
       */
      public var dateOfService: DateTime.Builder? = null

      /** How this procedure value should be used in charging the account. */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The package code can be used to group procedures that may be priced or delivered as a
       * single product. Such as DRGs.
       */
      public var packageCode: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Any devices that were associated with the procedure relevant to the account. */
      public var device: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Procedure =
        Procedure(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence?.build(),
          code = code.build(),
          dateOfService = dateOfService?.build(),
          type = type.map { it.build() },
          packageCode = packageCode.map { it.build() },
          device = device.map { it.build() },
        )
    }
  }

  /** Other associated accounts related to this account. */
  @Serializable(with = AccountRelatedAccountSerializer::class)
  public data class RelatedAccount(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    /** Relationship of the associated Account. */
    public val relationship: CodeableConcept? = null,
    /** Reference to an associated Account. */
    public val account: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(account.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          relationship = this@with.relationship?.toBuilder()
        }
      }

    public class Builder(
      /** Reference to an associated Account. */
      public var account: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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

      /** Relationship of the associated Account. */
      public var relationship: CodeableConcept.Builder? = null

      public fun build(): RelatedAccount =
        RelatedAccount(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          relationship = relationship?.build(),
          account = account.build(),
        )
    }
  }

  /**
   * The calculated account balances - these are calculated and processed by the finance system.
   *
   * The balances with a `term` that is not current are usually generated/updated by an invoicing or
   * similar process.
   */
  @Serializable(with = AccountBalanceSerializer::class)
  public data class Balance(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    /** Who is expected to pay this part of the balance. */
    public val aggregate: CodeableConcept? = null,
    /**
     * The term of the account balances - The balance value is the amount that was outstanding for
     * this age.
     */
    public val term: CodeableConcept? = null,
    /**
     * The amount is only an estimated value - this is likely common for `current` term balances,
     * but not with known terms (that were generated by a backend process).
     */
    public val estimate: Boolean? = null,
    /** The actual balance value calculated for the age defined in the term property. */
    public val amount: Money,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(amount.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          aggregate = this@with.aggregate?.toBuilder()
          term = this@with.term?.toBuilder()
          estimate = this@with.estimate?.toBuilder()
        }
      }

    public class Builder(
      /** The actual balance value calculated for the age defined in the term property. */
      public var amount: Money.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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

      /** Who is expected to pay this part of the balance. */
      public var aggregate: CodeableConcept.Builder? = null

      /**
       * The term of the account balances - The balance value is the amount that was outstanding for
       * this age.
       */
      public var term: CodeableConcept.Builder? = null

      /**
       * The amount is only an estimated value - this is likely common for `current` term balances,
       * but not with known terms (that were generated by a backend process).
       */
      public var estimate: Boolean.Builder? = null

      public fun build(): Balance =
        Balance(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          aggregate = aggregate?.build(),
          term = term?.build(),
          estimate = estimate?.build(),
          amount = amount.build(),
        )
    }
  }

  public class Builder(
    /**
     * Indicates whether the account is presently used/usable or not.
     *
     * This element is labeled as a modifier because the status contains the codes inactive and
     * entered-in-error that mark the Account as not currently valid.
     */
    public var status: Enumeration<AccountStatus>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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
     * Unique identifier used to reference the account. Might or might not be intended for human use
     * (e.g. credit card number).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The BillingStatus tracks the lifecycle of the account through the billing process. It
     * indicates how transactions are treated when they are allocated to the account.
     */
    public var billingStatus: CodeableConcept.Builder? = null

    /** Categorizes the account for reporting and searching purposes. */
    public var type: CodeableConcept.Builder? = null

    /** Name used for the account when displaying it to humans in reports, etc. */
    public var name: String.Builder? = null

    /**
     * Identifies the entity which incurs the expenses. While the immediate recipients of services
     * or goods might be entities related to the subject, the expenses were ultimately incurred by
     * the subject of the Account.
     *
     * Accounts can be applied to non-patients for tracking other non-patient related activities,
     * such as group services (patients not tracked, and costs charged to another body), or might
     * not be allocated.
     */
    public var subject: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The date range of services associated with this account.
     *
     * It is possible for transactions to be posted outside the service period, as long as the
     * service was provided within the defined service period.
     */
    public var servicePeriod: Period.Builder? = null

    /**
     * The party(s) that are responsible for covering the payment of this account, and what order
     * should they be applied to the account.
     *
     * Typically. this may be some form of insurance, internal charges, or self-pay.
     *
     * Local or jurisdictional business rules may determine which coverage covers which types of
     * billable items charged to the account, and in which order. Where the order is important, a
     * local/jurisdictional extension may be defined to specify the order for the type of charge.
     */
    public var coverage: MutableList<Coverage.Builder> = mutableListOf()

    /**
     * Indicates the service area, hospital, department, etc. with responsibility for managing the
     * Account.
     */
    public var owner: Reference.Builder? = null

    /** Provides additional information about what the account tracks and how it is used. */
    public var description: Markdown.Builder? = null

    /** The parties responsible for balancing the account if other payment options fall short. */
    public var guarantor: MutableList<Guarantor.Builder> = mutableListOf()

    /**
     * When using an account for billing a specific Encounter the set of diagnoses that are relevant
     * for billing are stored here on the account where they are able to be sequenced appropriately
     * prior to processing to produce claim(s).
     */
    public var diagnosis: MutableList<Diagnosis.Builder> = mutableListOf()

    /**
     * When using an account for billing a specific Encounter the set of procedures that are
     * relevant for billing are stored here on the account where they are able to be sequenced
     * appropriately prior to processing to produce claim(s).
     */
    public var procedure: MutableList<Procedure.Builder> = mutableListOf()

    /** Other associated accounts related to this account. */
    public var relatedAccount: MutableList<RelatedAccount.Builder> = mutableListOf()

    /** The default currency for the account. */
    public var currency: CodeableConcept.Builder? = null

    /**
     * The calculated account balances - these are calculated and processed by the finance system.
     *
     * The balances with a `term` that is not current are usually generated/updated by an invoicing
     * or similar process.
     */
    public var balance: MutableList<Balance.Builder> = mutableListOf()

    /**
     * Time the balance amount was calculated.
     *
     * The total(s) are not typically updated using the restful API but more often by back-end
     * processes included in a typical finance system.
     */
    public var calculatedAt: Instant.Builder? = null

    override fun build(): Account =
      Account(
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
        billingStatus = billingStatus?.build(),
        type = type?.build(),
        name = name?.build(),
        subject = subject.map { it.build() },
        servicePeriod = servicePeriod?.build(),
        coverage = coverage.map { it.build() },
        owner = owner?.build(),
        description = description?.build(),
        guarantor = guarantor.map { it.build() },
        diagnosis = diagnosis.map { it.build() },
        procedure = procedure.map { it.build() },
        relatedAccount = relatedAccount.map { it.build() },
        currency = currency?.build(),
        balance = balance.map { it.build() },
        calculatedAt = calculatedAt?.build(),
      )
  }

  /** Indicates whether the account is available to be used. */
  public enum class AccountStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/account-status", "Active"),
    Inactive("inactive", "http://hl7.org/fhir/account-status", "Inactive"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/account-status", "Entered in error"),
    On_Hold("on-hold", "http://hl7.org/fhir/account-status", "On Hold"),
    Unknown("unknown", "http://hl7.org/fhir/account-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AccountStatus =
        when (code) {
          "active" -> Active
          "inactive" -> Inactive
          "entered-in-error" -> Entered_In_Error
          "on-hold" -> On_Hold
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum AccountStatus")
        }
    }
  }
}
