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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.PaymentReconciliationAllocationSerializer
import dev.ohs.fhir.model.r5.serializers.PaymentReconciliationProcessNoteSerializer
import dev.ohs.fhir.model.r5.serializers.PaymentReconciliationSerializer
import dev.ohs.fhir.model.r5.terminologies.NoteType
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource provides the details including amount of a payment and allocates the payment items
 * being paid.
 */
@Serializable(with = PaymentReconciliationSerializer::class)
@SerialName("PaymentReconciliation")
public data class PaymentReconciliation(
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
  /** A unique identifier assigned to this payment reconciliation. */
  public val identifier: List<Identifier> = listOf(),
  /** Code to indicate the nature of the payment such as payment, adjustment. */
  public val type: CodeableConcept,
  /**
   * The status of the resource instance.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<FinancialResourceStatusCodes>,
  /**
   * The workflow or activity which gave rise to or during which the payment ocurred such as a
   * kiosk, deposit on account, periodic payment etc.
   */
  public val kind: CodeableConcept? = null,
  /**
   * The period of time for which payments have been gathered into this bulk payment for settlement.
   */
  public val period: Period? = null,
  /** The date when the resource was created. */
  public val created: DateTime,
  /** Payment enterer if not the actual payment issuer. */
  public val enterer: Reference? = null,
  /** The type of the source such as patient or insurance. */
  public val issuerType: CodeableConcept? = null,
  /**
   * The party who generated the payment.
   *
   * This party is also responsible for the reconciliation.
   */
  public val paymentIssuer: Reference? = null,
  /** Original request resource reference. */
  public val request: Reference? = null,
  /** The practitioner who is responsible for the services rendered to the patient. */
  public val requestor: Reference? = null,
  /**
   * The outcome of a request for a reconciliation.
   *
   * The resource may be used to indicate that: the request has been held (queued) for processing;
   * that it has been processed and errors found (error); that no errors were found and that some of
   * the adjudication has been undertaken (partial) or that all of the adjudication has been
   * undertaken (complete).
   */
  public val outcome: Enumeration<PaymentOutcome>? = null,
  /** A human readable description of the status of the request for the reconciliation. */
  public val disposition: String? = null,
  /** The date of payment as indicated on the financial instrument. */
  public val date: Date,
  /**
   * The location of the site or device for electronic transfers or physical location for cash
   * payments.
   */
  public val location: Reference? = null,
  /** The means of payment such as check, card cash, or electronic funds transfer. */
  public val method: CodeableConcept? = null,
  /** The card brand such as debit, Visa, Amex etc. used if a card is the method of payment. */
  public val cardBrand: String? = null,
  /**
   * A portion of the account number, often the last 4 digits, used for verification not charging
   * purposes.
   */
  public val accountNumber: String? = null,
  /** The year and month (YYYY-MM) when the instrument, typically card, expires. */
  public val expirationDate: Date? = null,
  /** The name of the card processor, etf processor, bank for checks. */
  public val processor: String? = null,
  /** The check number, eft reference, car processor reference. */
  public val referenceNumber: String? = null,
  /** An alphanumeric issued by the processor to confirm the successful issuance of payment. */
  public val authorization: String? = null,
  /**
   * The amount offered by the issuer, typically applies to cash when the issuer provides an amount
   * in bank note denominations equal to or excess of the amount actually being paid.
   */
  public val tenderedAmount: Money? = null,
  /**
   * The amount returned by the receiver which is excess to the amount payable, often referred to as
   * 'change'.
   */
  public val returnedAmount: Money? = null,
  /** Total payment amount as indicated on the financial instrument. */
  public val amount: Money,
  /**
   * Issuer's unique identifier for the payment instrument.
   *
   * For example: EFT number or check number.
   */
  public val paymentIdentifier: Identifier? = null,
  /** Distribution of the payment amount for a previously acknowledged payable. */
  public val allocation: List<Allocation> = listOf(),
  /**
   * A code for the form to be used for printing the content.
   *
   * May be needed to identify specific jurisdictional forms.
   */
  public val formCode: CodeableConcept? = null,
  /** A note that describes or explains the processing in a human readable form. */
  public val processNote: List<ProcessNote> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          type.toBuilder(),
          status,
          created.toBuilder(),
          date.toBuilder(),
          amount.toBuilder(),
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
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          kind = this@with.kind?.toBuilder()
          period = this@with.period?.toBuilder()
          enterer = this@with.enterer?.toBuilder()
          issuerType = this@with.issuerType?.toBuilder()
          paymentIssuer = this@with.paymentIssuer?.toBuilder()
          request = this@with.request?.toBuilder()
          requestor = this@with.requestor?.toBuilder()
          outcome = this@with.outcome
          disposition = this@with.disposition?.toBuilder()
          location = this@with.location?.toBuilder()
          method = this@with.method?.toBuilder()
          cardBrand = this@with.cardBrand?.toBuilder()
          accountNumber = this@with.accountNumber?.toBuilder()
          expirationDate = this@with.expirationDate?.toBuilder()
          processor = this@with.processor?.toBuilder()
          referenceNumber = this@with.referenceNumber?.toBuilder()
          authorization = this@with.authorization?.toBuilder()
          tenderedAmount = this@with.tenderedAmount?.toBuilder()
          returnedAmount = this@with.returnedAmount?.toBuilder()
          paymentIdentifier = this@with.paymentIdentifier?.toBuilder()
          allocation = this@with.allocation.map { it.toBuilder() }.toMutableList()
          formCode = this@with.formCode?.toBuilder()
          processNote = this@with.processNote.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Distribution of the payment amount for a previously acknowledged payable. */
  @Serializable(with = PaymentReconciliationAllocationSerializer::class)
  public data class Allocation(
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
    /** Unique identifier for the current payment item for the referenced payable. */
    public val identifier: Identifier? = null,
    /** Unique identifier for the prior payment item for the referenced payable. */
    public val predecessor: Identifier? = null,
    /** Specific resource to which the payment/adjustment/advance applies. */
    public val target: Reference? = null,
    /**
     * Identifies the claim line item, encounter or other sub-element being paid. Note payment may
     * be partial, that is not match the then outstanding balance or amount incurred.
     */
    public val targetItem: TargetItem? = null,
    /**
     * The Encounter to which this payment applies, may be completed by the receiver, used for
     * search.
     */
    public val encounter: Reference? = null,
    /**
     * The Account to which this payment applies, may be completed by the receiver, used for search.
     */
    public val account: Reference? = null,
    /**
     * Code to indicate the nature of the payment.
     *
     * For example: payment, adjustment, funds advance, etc.
     */
    public val type: CodeableConcept? = null,
    /** The party which submitted the claim or financial transaction. */
    public val submitter: Reference? = null,
    /** A resource, such as a ClaimResponse, which contains a commitment to payment. */
    public val response: Reference? = null,
    /** The date from the response resource containing a commitment to pay. */
    public val date: Date? = null,
    /**
     * A reference to the individual who is responsible for inquiries regarding the response and its
     * payment.
     */
    public val responsible: Reference? = null,
    /** The party which is receiving the payment. */
    public val payee: Reference? = null,
    /** The monetary amount allocated from the total payment to the payable. */
    public val amount: Money? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier?.toBuilder()
          predecessor = this@with.predecessor?.toBuilder()
          target = this@with.target?.toBuilder()
          targetItem = this@with.targetItem
          encounter = this@with.encounter?.toBuilder()
          account = this@with.account?.toBuilder()
          type = this@with.type?.toBuilder()
          submitter = this@with.submitter?.toBuilder()
          response = this@with.response?.toBuilder()
          date = this@with.date?.toBuilder()
          responsible = this@with.responsible?.toBuilder()
          payee = this@with.payee?.toBuilder()
          amount = this@with.amount?.toBuilder()
        }
      }

    public sealed interface TargetItem {
      public fun asString(): String? = this as? String

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : TargetItem

      public data class Identifier(public val `value`: dev.ohs.fhir.model.r5.Identifier) :
        TargetItem

      public data class PositiveInt(public val `value`: dev.ohs.fhir.model.r5.PositiveInt) :
        TargetItem

      public companion object {
        internal fun from(
          stringValue: dev.ohs.fhir.model.r5.String?,
          identifierValue: dev.ohs.fhir.model.r5.Identifier?,
          positiveIntValue: dev.ohs.fhir.model.r5.PositiveInt?,
        ): TargetItem? {
          if (stringValue != null) return String(stringValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          return null
        }
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

      /** Unique identifier for the current payment item for the referenced payable. */
      public var identifier: Identifier.Builder? = null

      /** Unique identifier for the prior payment item for the referenced payable. */
      public var predecessor: Identifier.Builder? = null

      /** Specific resource to which the payment/adjustment/advance applies. */
      public var target: Reference.Builder? = null

      /**
       * Identifies the claim line item, encounter or other sub-element being paid. Note payment may
       * be partial, that is not match the then outstanding balance or amount incurred.
       */
      public var targetItem: TargetItem? = null

      /**
       * The Encounter to which this payment applies, may be completed by the receiver, used for
       * search.
       */
      public var encounter: Reference.Builder? = null

      /**
       * The Account to which this payment applies, may be completed by the receiver, used for
       * search.
       */
      public var account: Reference.Builder? = null

      /**
       * Code to indicate the nature of the payment.
       *
       * For example: payment, adjustment, funds advance, etc.
       */
      public var type: CodeableConcept.Builder? = null

      /** The party which submitted the claim or financial transaction. */
      public var submitter: Reference.Builder? = null

      /** A resource, such as a ClaimResponse, which contains a commitment to payment. */
      public var response: Reference.Builder? = null

      /** The date from the response resource containing a commitment to pay. */
      public var date: Date.Builder? = null

      /**
       * A reference to the individual who is responsible for inquiries regarding the response and
       * its payment.
       */
      public var responsible: Reference.Builder? = null

      /** The party which is receiving the payment. */
      public var payee: Reference.Builder? = null

      /** The monetary amount allocated from the total payment to the payable. */
      public var amount: Money.Builder? = null

      public fun build(): Allocation =
        Allocation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier?.build(),
          predecessor = predecessor?.build(),
          target = target?.build(),
          targetItem = targetItem,
          encounter = encounter?.build(),
          account = account?.build(),
          type = type?.build(),
          submitter = submitter?.build(),
          response = response?.build(),
          date = date?.build(),
          responsible = responsible?.build(),
          payee = payee?.build(),
          amount = amount?.build(),
        )
    }
  }

  /** A note that describes or explains the processing in a human readable form. */
  @Serializable(with = PaymentReconciliationProcessNoteSerializer::class)
  public data class ProcessNote(
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
    /** The business purpose of the note text. */
    public val type: Enumeration<NoteType>? = null,
    /** The explanation or description associated with the processing. */
    public val text: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type
          text = this@with.text?.toBuilder()
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

      /** The business purpose of the note text. */
      public var type: Enumeration<NoteType>? = null

      /** The explanation or description associated with the processing. */
      public var text: String.Builder? = null

      public fun build(): ProcessNote =
        ProcessNote(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          text = text?.build(),
        )
    }
  }

  public class Builder(
    /** Code to indicate the nature of the payment such as payment, adjustment. */
    public var type: CodeableConcept.Builder,
    /**
     * The status of the resource instance.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<FinancialResourceStatusCodes>,
    /** The date when the resource was created. */
    public var created: DateTime.Builder,
    /** The date of payment as indicated on the financial instrument. */
    public var date: Date.Builder,
    /** Total payment amount as indicated on the financial instrument. */
    public var amount: Money.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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

    /** A unique identifier assigned to this payment reconciliation. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The workflow or activity which gave rise to or during which the payment ocurred such as a
     * kiosk, deposit on account, periodic payment etc.
     */
    public var kind: CodeableConcept.Builder? = null

    /**
     * The period of time for which payments have been gathered into this bulk payment for
     * settlement.
     */
    public var period: Period.Builder? = null

    /** Payment enterer if not the actual payment issuer. */
    public var enterer: Reference.Builder? = null

    /** The type of the source such as patient or insurance. */
    public var issuerType: CodeableConcept.Builder? = null

    /**
     * The party who generated the payment.
     *
     * This party is also responsible for the reconciliation.
     */
    public var paymentIssuer: Reference.Builder? = null

    /** Original request resource reference. */
    public var request: Reference.Builder? = null

    /** The practitioner who is responsible for the services rendered to the patient. */
    public var requestor: Reference.Builder? = null

    /**
     * The outcome of a request for a reconciliation.
     *
     * The resource may be used to indicate that: the request has been held (queued) for processing;
     * that it has been processed and errors found (error); that no errors were found and that some
     * of the adjudication has been undertaken (partial) or that all of the adjudication has been
     * undertaken (complete).
     */
    public var outcome: Enumeration<PaymentOutcome>? = null

    /** A human readable description of the status of the request for the reconciliation. */
    public var disposition: String.Builder? = null

    /**
     * The location of the site or device for electronic transfers or physical location for cash
     * payments.
     */
    public var location: Reference.Builder? = null

    /** The means of payment such as check, card cash, or electronic funds transfer. */
    public var method: CodeableConcept.Builder? = null

    /** The card brand such as debit, Visa, Amex etc. used if a card is the method of payment. */
    public var cardBrand: String.Builder? = null

    /**
     * A portion of the account number, often the last 4 digits, used for verification not charging
     * purposes.
     */
    public var accountNumber: String.Builder? = null

    /** The year and month (YYYY-MM) when the instrument, typically card, expires. */
    public var expirationDate: Date.Builder? = null

    /** The name of the card processor, etf processor, bank for checks. */
    public var processor: String.Builder? = null

    /** The check number, eft reference, car processor reference. */
    public var referenceNumber: String.Builder? = null

    /** An alphanumeric issued by the processor to confirm the successful issuance of payment. */
    public var authorization: String.Builder? = null

    /**
     * The amount offered by the issuer, typically applies to cash when the issuer provides an
     * amount in bank note denominations equal to or excess of the amount actually being paid.
     */
    public var tenderedAmount: Money.Builder? = null

    /**
     * The amount returned by the receiver which is excess to the amount payable, often referred to
     * as 'change'.
     */
    public var returnedAmount: Money.Builder? = null

    /**
     * Issuer's unique identifier for the payment instrument.
     *
     * For example: EFT number or check number.
     */
    public var paymentIdentifier: Identifier.Builder? = null

    /** Distribution of the payment amount for a previously acknowledged payable. */
    public var allocation: MutableList<Allocation.Builder> = mutableListOf()

    /**
     * A code for the form to be used for printing the content.
     *
     * May be needed to identify specific jurisdictional forms.
     */
    public var formCode: CodeableConcept.Builder? = null

    /** A note that describes or explains the processing in a human readable form. */
    public var processNote: MutableList<ProcessNote.Builder> = mutableListOf()

    override fun build(): PaymentReconciliation =
      PaymentReconciliation(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        type = type.build(),
        status = status,
        kind = kind?.build(),
        period = period?.build(),
        created = created.build(),
        enterer = enterer?.build(),
        issuerType = issuerType?.build(),
        paymentIssuer = paymentIssuer?.build(),
        request = request?.build(),
        requestor = requestor?.build(),
        outcome = outcome,
        disposition = disposition?.build(),
        date = date.build(),
        location = location?.build(),
        method = method?.build(),
        cardBrand = cardBrand?.build(),
        accountNumber = accountNumber?.build(),
        expirationDate = expirationDate?.build(),
        processor = processor?.build(),
        referenceNumber = referenceNumber?.build(),
        authorization = authorization?.build(),
        tenderedAmount = tenderedAmount?.build(),
        returnedAmount = returnedAmount?.build(),
        amount = amount.build(),
        paymentIdentifier = paymentIdentifier?.build(),
        allocation = allocation.map { it.build() },
        formCode = formCode?.build(),
        processNote = processNote.map { it.build() },
      )
  }

  /** This value set includes Status codes. */
  public enum class FinancialResourceStatusCodes(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Active("active", "http://hl7.org/fhir/fm-status", "Active"),
    Cancelled("cancelled", "http://hl7.org/fhir/fm-status", "Cancelled"),
    Draft("draft", "http://hl7.org/fhir/fm-status", "Draft"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/fm-status", "Entered in Error");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): FinancialResourceStatusCodes =
        when (code) {
          "active" -> Active
          "cancelled" -> Cancelled
          "draft" -> Draft
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum FinancialResourceStatusCodes"
            )
        }
    }
  }

  /** The outcome of the processing. */
  public enum class PaymentOutcome(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Queued("queued", "http://hl7.org/fhir/payment-outcome", "Queued"),
    Complete("complete", "http://hl7.org/fhir/payment-outcome", "Processing Complete"),
    Error("error", "http://hl7.org/fhir/payment-outcome", "Error"),
    Partial("partial", "http://hl7.org/fhir/payment-outcome", "Partial Processing");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): PaymentOutcome =
        when (code) {
          "queued" -> Queued
          "complete" -> Complete
          "error" -> Error
          "partial" -> Partial
          else -> throw IllegalArgumentException("Unknown code $code for enum PaymentOutcome")
        }
    }
  }
}
