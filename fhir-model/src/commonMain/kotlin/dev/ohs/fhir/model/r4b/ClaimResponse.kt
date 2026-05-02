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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.ClaimResponseAddItemDetailSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseAddItemDetailSubDetailSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseAddItemLocationSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseAddItemSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseAddItemServicedSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseErrorSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseInsuranceSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseItemAdjudicationSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseItemDetailSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseItemDetailSubDetailSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseItemSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponsePaymentSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseProcessNoteSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseSerializer
import com.google.fhir.model.r4b.serializers.ClaimResponseTotalSerializer
import com.google.fhir.model.r4b.terminologies.NoteType
import com.google.fhir.model.r4b.terminologies.RemittanceOutcome
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** This resource provides the adjudication details from the processing of a Claim resource. */
@Serializable(with = ClaimResponseSerializer::class)
@SerialName("ClaimResponse")
public data class ClaimResponse(
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
  /** A unique identifier assigned to this claim response. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status of the resource instance.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<FinancialResourceStatusCodes>,
  /**
   * A finer grained suite of claim type codes which may convey additional information such as
   * Inpatient vs Outpatient and/or a specialty service.
   *
   * This may contain the local bill type codes, for example the US UB-04 bill type code or the CMS
   * bill type.
   */
  public val type: CodeableConcept,
  /**
   * A finer grained suite of claim type codes which may convey additional information such as
   * Inpatient vs Outpatient and/or a specialty service.
   *
   * This may contain the local bill type codes, for example the US UB-04 bill type code or the CMS
   * bill type.
   */
  public val subType: CodeableConcept? = null,
  /**
   * A code to indicate whether the nature of the request is: to request adjudication of products
   * and services previously rendered; or requesting authorization and adjudication for provision in
   * the future; or requesting the non-binding adjudication of the listed products and services
   * which could be provided in the future.
   */
  public val use: Enumeration<Use>,
  /**
   * The party to whom the professional services and/or products have been supplied or are being
   * considered and for whom actual for facast reimbursement is sought.
   */
  public val patient: Reference,
  /** The date this resource was created. */
  public val created: DateTime,
  /** The party responsible for authorization, adjudication and reimbursement. */
  public val insurer: Reference,
  /**
   * The provider which is responsible for the claim, predetermination or preauthorization.
   *
   * Typically this field would be 1..1 where this party is responsible for the claim but not
   * necessarily professionally responsible for the provision of the individual products and
   * services listed below.
   */
  public val requestor: Reference? = null,
  /** Original request resource reference. */
  public val request: Reference? = null,
  /**
   * The outcome of the claim, predetermination, or preauthorization processing.
   *
   * The resource may be used to indicate that: the request has been held (queued) for processing;
   * that it has been processed and errors found (error); that no errors were found and that some of
   * the adjudication has been undertaken (partial) or that all of the adjudication has been
   * undertaken (complete).
   */
  public val outcome: Enumeration<RemittanceOutcome>,
  /** A human readable description of the status of the adjudication. */
  public val disposition: String? = null,
  /**
   * Reference from the Insurer which is used in later communications which refers to this
   * adjudication.
   *
   * This value is only present on preauthorization adjudications.
   */
  public val preAuthRef: String? = null,
  /** The time frame during which this authorization is effective. */
  public val preAuthPeriod: Period? = null,
  /** Type of Party to be reimbursed: subscriber, provider, other. */
  public val payeeType: CodeableConcept? = null,
  /**
   * A claim line. Either a simple (a product or service) or a 'group' of details which can also be
   * a simple items or groups of sub-details.
   */
  public val item: List<Item> = listOf(),
  /** The first-tier service adjudications for payor added product or service lines. */
  public val addItem: List<AddItem> = listOf(),
  /**
   * The adjudication results which are presented at the header level rather than at the line-item
   * or add-item levels.
   */
  public val adjudication: List<Item.Adjudication> = listOf(),
  /**
   * Categorized monetary totals for the adjudication.
   *
   * Totals for amounts submitted, co-pays, benefits payable etc.
   */
  public val total: List<Total> = listOf(),
  /** Payment details for the adjudication of the claim. */
  public val payment: Payment? = null,
  /**
   * A code, used only on a response to a preauthorization, to indicate whether the benefits payable
   * have been reserved and for whom.
   *
   * Fund would be release by a future claim quoting the preAuthRef of this response. Examples of
   * values include: provider, patient, none.
   */
  public val fundsReserve: CodeableConcept? = null,
  /**
   * A code for the form to be used for printing the content.
   *
   * May be needed to identify specific jurisdictional forms.
   */
  public val formCode: CodeableConcept? = null,
  /**
   * The actual form, by reference or inclusion, for printing the content or an EOB.
   *
   * Needed to permit insurers to include the actual form.
   */
  public val form: Attachment? = null,
  /** A note that describes or explains adjudication results in a human readable form. */
  public val processNote: List<ProcessNote> = listOf(),
  /**
   * Request for additional supporting or authorizing information.
   *
   * For example: professional reports, documents, images, clinical resources, or accident reports.
   */
  public val communicationRequest: List<Reference> = listOf(),
  /**
   * Financial instruments for reimbursement for the health care products and services specified on
   * the claim.
   *
   * All insurance coverages for the patient which may be applicable for reimbursement, of the
   * products and services listed in the claim, are typically provided in the claim to allow
   * insurers to confirm the ordering of the insurance coverages relative to local 'coordination of
   * benefit' rules. One coverage (and only one) with 'focal=true' is to be used in the adjudication
   * of this claim. Coverages appearing before the focal Coverage in the list, and where
   * 'subrogation=false', should provide a reference to the ClaimResponse containing the
   * adjudication results of the prior claim.
   */
  public val insurance: List<Insurance> = listOf(),
  /**
   * Errors encountered during the processing of the adjudication.
   *
   * If the request contains errors then an error element should be provided and no adjudication
   * related sections (item, addItem, or payment) should be present.
   */
  public val error: List<Error> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          type.toBuilder(),
          use,
          patient.toBuilder(),
          created.toBuilder(),
          insurer.toBuilder(),
          outcome,
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
          subType = this@with.subType?.toBuilder()
          requestor = this@with.requestor?.toBuilder()
          request = this@with.request?.toBuilder()
          disposition = this@with.disposition?.toBuilder()
          preAuthRef = this@with.preAuthRef?.toBuilder()
          preAuthPeriod = this@with.preAuthPeriod?.toBuilder()
          payeeType = this@with.payeeType?.toBuilder()
          item = this@with.item.map { it.toBuilder() }.toMutableList()
          addItem = this@with.addItem.map { it.toBuilder() }.toMutableList()
          adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
          total = this@with.total.map { it.toBuilder() }.toMutableList()
          payment = this@with.payment?.toBuilder()
          fundsReserve = this@with.fundsReserve?.toBuilder()
          formCode = this@with.formCode?.toBuilder()
          form = this@with.form?.toBuilder()
          processNote = this@with.processNote.map { it.toBuilder() }.toMutableList()
          communicationRequest =
            this@with.communicationRequest.map { it.toBuilder() }.toMutableList()
          insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
          error = this@with.error.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * A claim line. Either a simple (a product or service) or a 'group' of details which can also be
   * a simple items or groups of sub-details.
   */
  @Serializable(with = ClaimResponseItemSerializer::class)
  public data class Item(
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
    /** A number to uniquely reference the claim item entries. */
    public val itemSequence: PositiveInt,
    /** The numbers associated with notes below which apply to the adjudication of this item. */
    public val noteNumber: List<PositiveInt> = listOf(),
    /**
     * If this item is a group then the values here are a summary of the adjudication of the detail
     * items. If this item is a simple product or service then this is the result of the
     * adjudication of this item.
     */
    public val adjudication: List<Adjudication>,
    /**
     * A claim detail. Either a simple (a product or service) or a 'group' of sub-details which are
     * simple items.
     */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(itemSequence.toBuilder(), adjudication.map { it.toBuilder() }.toMutableList())
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
            detail = this@with.detail.map { it.toBuilder() }.toMutableList()
          }
      }

    /**
     * If this item is a group then the values here are a summary of the adjudication of the detail
     * items. If this item is a simple product or service then this is the result of the
     * adjudication of this item.
     */
    @Serializable(with = ClaimResponseItemAdjudicationSerializer::class)
    public data class Adjudication(
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
      /**
       * A code to indicate the information type of this adjudication record. Information types may
       * include the value submitted, maximum values or percentages allowed or payable under the
       * plan, amounts that: the patient is responsible for in aggregate or pertaining to this item;
       * amounts paid by other coverages; and, the benefit payable for this item.
       *
       * For example codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
       */
      public val category: CodeableConcept,
      /**
       * A code supporting the understanding of the adjudication result and explaining variance from
       * expected amount.
       *
       * For example may indicate that the funds for this benefit type have been exhausted.
       */
      public val reason: CodeableConcept? = null,
      /**
       * Monetary amount associated with the category.
       *
       * For example: amount submitted, eligible amount, co-payment, and benefit payable.
       */
      public val amount: Money? = null,
      /**
       * A non-monetary value associated with the category. Mutually exclusive to the amount element
       * above.
       *
       * For example: eligible percentage or co-payment percentage.
       */
      public val `value`: Decimal? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(category.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            reason = this@with.reason?.toBuilder()
            amount = this@with.amount?.toBuilder()
            `value` = this@with.`value`?.toBuilder()
          }
        }

      public class Builder(
        /**
         * A code to indicate the information type of this adjudication record. Information types
         * may include the value submitted, maximum values or percentages allowed or payable under
         * the plan, amounts that: the patient is responsible for in aggregate or pertaining to this
         * item; amounts paid by other coverages; and, the benefit payable for this item.
         *
         * For example codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
         */
        public var category: CodeableConcept.Builder
      ) {
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

        /**
         * A code supporting the understanding of the adjudication result and explaining variance
         * from expected amount.
         *
         * For example may indicate that the funds for this benefit type have been exhausted.
         */
        public var reason: CodeableConcept.Builder? = null

        /**
         * Monetary amount associated with the category.
         *
         * For example: amount submitted, eligible amount, co-payment, and benefit payable.
         */
        public var amount: Money.Builder? = null

        /**
         * A non-monetary value associated with the category. Mutually exclusive to the amount
         * element above.
         *
         * For example: eligible percentage or co-payment percentage.
         */
        public var `value`: Decimal.Builder? = null

        public fun build(): Adjudication =
          Adjudication(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            category = category.build(),
            reason = reason?.build(),
            amount = amount?.build(),
            `value` = `value`?.build(),
          )
      }
    }

    /**
     * A claim detail. Either a simple (a product or service) or a 'group' of sub-details which are
     * simple items.
     */
    @Serializable(with = ClaimResponseItemDetailSerializer::class)
    public data class Detail(
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
      /** A number to uniquely reference the claim detail entry. */
      public val detailSequence: PositiveInt,
      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public val noteNumber: List<PositiveInt> = listOf(),
      /** The adjudication results. */
      public val adjudication: List<Adjudication>,
      /** A sub-detail adjudication of a simple product or service. */
      public val subDetail: List<SubDetail> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(detailSequence.toBuilder(), adjudication.map { it.toBuilder() }.toMutableList())
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              subDetail = this@with.subDetail.map { it.toBuilder() }.toMutableList()
            }
        }

      /** A sub-detail adjudication of a simple product or service. */
      @Serializable(with = ClaimResponseItemDetailSubDetailSerializer::class)
      public data class SubDetail(
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
        /** A number to uniquely reference the claim sub-detail entry. */
        public val subDetailSequence: PositiveInt,
        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public val noteNumber: List<PositiveInt> = listOf(),
        /** The adjudication results. */
        public val adjudication: List<Adjudication> = listOf(),
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(subDetailSequence.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
            }
          }

        public class Builder(
          /** A number to uniquely reference the claim sub-detail entry. */
          public var subDetailSequence: PositiveInt.Builder
        ) {
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
           * The numbers associated with notes below which apply to the adjudication of this item.
           */
          public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

          /** The adjudication results. */
          public var adjudication: MutableList<Adjudication.Builder> = mutableListOf()

          public fun build(): SubDetail =
            SubDetail(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              subDetailSequence = subDetailSequence.build(),
              noteNumber = noteNumber.map { it.build() },
              adjudication = adjudication.map { it.build() },
            )
        }
      }

      public class Builder(
        /** A number to uniquely reference the claim detail entry. */
        public var detailSequence: PositiveInt.Builder,
        /** The adjudication results. */
        public var adjudication: MutableList<Adjudication.Builder>,
      ) {
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

        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

        /** A sub-detail adjudication of a simple product or service. */
        public var subDetail: MutableList<SubDetail.Builder> = mutableListOf()

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            detailSequence = detailSequence.build(),
            noteNumber = noteNumber.map { it.build() },
            adjudication = adjudication.map { it.build() },
            subDetail = subDetail.map { it.build() },
          )
      }
    }

    public class Builder(
      /** A number to uniquely reference the claim item entries. */
      public var itemSequence: PositiveInt.Builder,
      /**
       * If this item is a group then the values here are a summary of the adjudication of the
       * detail items. If this item is a simple product or service then this is the result of the
       * adjudication of this item.
       */
      public var adjudication: MutableList<Adjudication.Builder>,
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

      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

      /**
       * A claim detail. Either a simple (a product or service) or a 'group' of sub-details which
       * are simple items.
       */
      public var detail: MutableList<Detail.Builder> = mutableListOf()

      public fun build(): Item =
        Item(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          itemSequence = itemSequence.build(),
          noteNumber = noteNumber.map { it.build() },
          adjudication = adjudication.map { it.build() },
          detail = detail.map { it.build() },
        )
    }
  }

  /** The first-tier service adjudications for payor added product or service lines. */
  @Serializable(with = ClaimResponseAddItemSerializer::class)
  public data class AddItem(
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
    /** Claim items which this service line is intended to replace. */
    public val itemSequence: List<PositiveInt> = listOf(),
    /**
     * The sequence number of the details within the claim item which this line is intended to
     * replace.
     */
    public val detailSequence: List<PositiveInt> = listOf(),
    /**
     * The sequence number of the sub-details within the details within the claim item which this
     * line is intended to replace.
     */
    public val subdetailSequence: List<PositiveInt> = listOf(),
    /** The providers who are authorized for the services rendered to the patient. */
    public val provider: List<Reference> = listOf(),
    /**
     * When the value is a group code then this item collects a set of related claim details,
     * otherwise this contains the product, service, drug or other billing code for the item.
     *
     * If this is an actual service or product line, i.e. not a Group, then use code to indicate the
     * Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN, RxNorm,
     * ACHI, CCI). If a grouping item then use a group code to indicate the type of thing being
     * grouped e.g. 'glasses' or 'compound'.
     */
    public val productOrService: CodeableConcept,
    /**
     * Item typification or modifiers codes to convey additional context for the product or service.
     *
     * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for Medical
     * whether the treatment was outside the clinic or outside of office hours.
     */
    public val modifier: List<CodeableConcept> = listOf(),
    /**
     * Identifies the program under which this may be recovered.
     *
     * For example: Neonatal program, child dental program or drug users recovery program.
     */
    public val programCode: List<CodeableConcept> = listOf(),
    /** The date or dates when the service or product was supplied, performed or completed. */
    public val serviced: Serviced? = null,
    /** Where the product or service was provided. */
    public val location: Location? = null,
    /** The number of repetitions of a service or product. */
    public val quantity: Quantity? = null,
    /**
     * If the item is not a group then this is the fee for the product or service, otherwise this is
     * the total of the fees for the details of the group.
     */
    public val unitPrice: Money? = null,
    /**
     * A real number that represents a multiplier used in determining the overall value of services
     * delivered and/or goods received. The concept of a Factor allows for a discount or surcharge
     * multiplier to be applied to a monetary amount.
     *
     * To show a 10% senior's discount, the value entered is: 0.90 (1.00 - 0.10).
     */
    public val factor: Decimal? = null,
    /**
     * The quantity times the unit price for an additional service or product or charge.
     *
     * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
     * assumed to be 1 if not supplied.
     */
    public val net: Money? = null,
    /**
     * Physical service site on the patient (limb, tooth, etc.).
     *
     * For example: Providing a tooth code allows an insurer to identify a provider performing a
     * filling on a tooth that was previously removed.
     */
    public val bodySite: CodeableConcept? = null,
    /** A region or surface of the bodySite, e.g. limb region or tooth surface(s). */
    public val subSite: List<CodeableConcept> = listOf(),
    /** The numbers associated with notes below which apply to the adjudication of this item. */
    public val noteNumber: List<PositiveInt> = listOf(),
    /** The adjudication results. */
    public val adjudication: List<Item.Adjudication>,
    /** The second-tier service adjudications for payor added services. */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(productOrService.toBuilder(), adjudication.map { it.toBuilder() }.toMutableList())
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            itemSequence = this@with.itemSequence.map { it.toBuilder() }.toMutableList()
            detailSequence = this@with.detailSequence.map { it.toBuilder() }.toMutableList()
            subdetailSequence = this@with.subdetailSequence.map { it.toBuilder() }.toMutableList()
            provider = this@with.provider.map { it.toBuilder() }.toMutableList()
            modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
            programCode = this@with.programCode.map { it.toBuilder() }.toMutableList()
            serviced = this@with.serviced
            location = this@with.location
            quantity = this@with.quantity?.toBuilder()
            unitPrice = this@with.unitPrice?.toBuilder()
            factor = this@with.factor?.toBuilder()
            net = this@with.net?.toBuilder()
            bodySite = this@with.bodySite?.toBuilder()
            subSite = this@with.subSite.map { it.toBuilder() }.toMutableList()
            noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
            detail = this@with.detail.map { it.toBuilder() }.toMutableList()
          }
      }

    /** The second-tier service adjudications for payor added services. */
    @Serializable(with = ClaimResponseAddItemDetailSerializer::class)
    public data class Detail(
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
      /**
       * When the value is a group code then this item collects a set of related claim details,
       * otherwise this contains the product, service, drug or other billing code for the item.
       *
       * If this is an actual service or product line, i.e. not a Group, then use code to indicate
       * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
       * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of thing
       * being grouped e.g. 'glasses' or 'compound'.
       */
      public val productOrService: CodeableConcept,
      /**
       * Item typification or modifiers codes to convey additional context for the product or
       * service.
       *
       * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
       * Medical whether the treatment was outside the clinic or outside of office hours.
       */
      public val modifier: List<CodeableConcept> = listOf(),
      /** The number of repetitions of a service or product. */
      public val quantity: Quantity? = null,
      /**
       * If the item is not a group then this is the fee for the product or service, otherwise this
       * is the total of the fees for the details of the group.
       */
      public val unitPrice: Money? = null,
      /**
       * A real number that represents a multiplier used in determining the overall value of
       * services delivered and/or goods received. The concept of a Factor allows for a discount or
       * surcharge multiplier to be applied to a monetary amount.
       *
       * To show a 10% senior's discount, the value entered is: 0.90 (1.00 - 0.10).
       */
      public val factor: Decimal? = null,
      /**
       * The quantity times the unit price for an additional service or product or charge.
       *
       * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
       * assumed to be 1 if not supplied.
       */
      public val net: Money? = null,
      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public val noteNumber: List<PositiveInt> = listOf(),
      /** The adjudication results. */
      public val adjudication: List<Item.Adjudication>,
      /** The third-tier service adjudications for payor added services. */
      public val subDetail: List<SubDetail> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(productOrService.toBuilder(), adjudication.map { it.toBuilder() }.toMutableList())
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
              quantity = this@with.quantity?.toBuilder()
              unitPrice = this@with.unitPrice?.toBuilder()
              factor = this@with.factor?.toBuilder()
              net = this@with.net?.toBuilder()
              noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              subDetail = this@with.subDetail.map { it.toBuilder() }.toMutableList()
            }
        }

      /** The third-tier service adjudications for payor added services. */
      @Serializable(with = ClaimResponseAddItemDetailSubDetailSerializer::class)
      public data class SubDetail(
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
         * When the value is a group code then this item collects a set of related claim details,
         * otherwise this contains the product, service, drug or other billing code for the item.
         *
         * If this is an actual service or product line, i.e. not a Group, then use code to indicate
         * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
         * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of
         * thing being grouped e.g. 'glasses' or 'compound'.
         */
        public val productOrService: CodeableConcept,
        /**
         * Item typification or modifiers codes to convey additional context for the product or
         * service.
         *
         * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
         * Medical whether the treatment was outside the clinic or outside of office hours.
         */
        public val modifier: List<CodeableConcept> = listOf(),
        /** The number of repetitions of a service or product. */
        public val quantity: Quantity? = null,
        /**
         * If the item is not a group then this is the fee for the product or service, otherwise
         * this is the total of the fees for the details of the group.
         */
        public val unitPrice: Money? = null,
        /**
         * A real number that represents a multiplier used in determining the overall value of
         * services delivered and/or goods received. The concept of a Factor allows for a discount
         * or surcharge multiplier to be applied to a monetary amount.
         *
         * To show a 10% senior's discount, the value entered is: 0.90 (1.00 - 0.10).
         */
        public val factor: Decimal? = null,
        /**
         * The quantity times the unit price for an additional service or product or charge.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public val net: Money? = null,
        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public val noteNumber: List<PositiveInt> = listOf(),
        /** The adjudication results. */
        public val adjudication: List<Item.Adjudication>,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(
                productOrService.toBuilder(),
                adjudication.map { it.toBuilder() }.toMutableList(),
              )
              .apply {
                id = this@with.id
                extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
                modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
                quantity = this@with.quantity?.toBuilder()
                unitPrice = this@with.unitPrice?.toBuilder()
                factor = this@with.factor?.toBuilder()
                net = this@with.net?.toBuilder()
                noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              }
          }

        public class Builder(
          /**
           * When the value is a group code then this item collects a set of related claim details,
           * otherwise this contains the product, service, drug or other billing code for the item.
           *
           * If this is an actual service or product line, i.e. not a Group, then use code to
           * indicate the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10,
           * NCPDP, DIN, RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate
           * the type of thing being grouped e.g. 'glasses' or 'compound'.
           */
          public var productOrService: CodeableConcept.Builder,
          /** The adjudication results. */
          public var adjudication: MutableList<Item.Adjudication.Builder>,
        ) {
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
           * Item typification or modifiers codes to convey additional context for the product or
           * service.
           *
           * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
           * Medical whether the treatment was outside the clinic or outside of office hours.
           */
          public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

          /** The number of repetitions of a service or product. */
          public var quantity: Quantity.Builder? = null

          /**
           * If the item is not a group then this is the fee for the product or service, otherwise
           * this is the total of the fees for the details of the group.
           */
          public var unitPrice: Money.Builder? = null

          /**
           * A real number that represents a multiplier used in determining the overall value of
           * services delivered and/or goods received. The concept of a Factor allows for a discount
           * or surcharge multiplier to be applied to a monetary amount.
           *
           * To show a 10% senior's discount, the value entered is: 0.90 (1.00 - 0.10).
           */
          public var factor: Decimal.Builder? = null

          /**
           * The quantity times the unit price for an additional service or product or charge.
           *
           * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
           * assumed to be 1 if not supplied.
           */
          public var net: Money.Builder? = null

          /**
           * The numbers associated with notes below which apply to the adjudication of this item.
           */
          public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

          public fun build(): SubDetail =
            SubDetail(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              productOrService = productOrService.build(),
              modifier = modifier.map { it.build() },
              quantity = quantity?.build(),
              unitPrice = unitPrice?.build(),
              factor = factor?.build(),
              net = net?.build(),
              noteNumber = noteNumber.map { it.build() },
              adjudication = adjudication.map { it.build() },
            )
        }
      }

      public class Builder(
        /**
         * When the value is a group code then this item collects a set of related claim details,
         * otherwise this contains the product, service, drug or other billing code for the item.
         *
         * If this is an actual service or product line, i.e. not a Group, then use code to indicate
         * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
         * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of
         * thing being grouped e.g. 'glasses' or 'compound'.
         */
        public var productOrService: CodeableConcept.Builder,
        /** The adjudication results. */
        public var adjudication: MutableList<Item.Adjudication.Builder>,
      ) {
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

        /**
         * Item typification or modifiers codes to convey additional context for the product or
         * service.
         *
         * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
         * Medical whether the treatment was outside the clinic or outside of office hours.
         */
        public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** The number of repetitions of a service or product. */
        public var quantity: Quantity.Builder? = null

        /**
         * If the item is not a group then this is the fee for the product or service, otherwise
         * this is the total of the fees for the details of the group.
         */
        public var unitPrice: Money.Builder? = null

        /**
         * A real number that represents a multiplier used in determining the overall value of
         * services delivered and/or goods received. The concept of a Factor allows for a discount
         * or surcharge multiplier to be applied to a monetary amount.
         *
         * To show a 10% senior's discount, the value entered is: 0.90 (1.00 - 0.10).
         */
        public var factor: Decimal.Builder? = null

        /**
         * The quantity times the unit price for an additional service or product or charge.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public var net: Money.Builder? = null

        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

        /** The third-tier service adjudications for payor added services. */
        public var subDetail: MutableList<SubDetail.Builder> = mutableListOf()

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            productOrService = productOrService.build(),
            modifier = modifier.map { it.build() },
            quantity = quantity?.build(),
            unitPrice = unitPrice?.build(),
            factor = factor?.build(),
            net = net?.build(),
            noteNumber = noteNumber.map { it.build() },
            adjudication = adjudication.map { it.build() },
            subDetail = subDetail.map { it.build() },
          )
      }
    }

    @Serializable(with = ClaimResponseAddItemServicedSerializer::class)
    public sealed interface Serviced {
      public fun asDate(): Date? = this as? Date

      public fun asPeriod(): Period? = this as? Period

      public data class Date(public val `value`: com.google.fhir.model.r4b.Date) : Serviced

      public data class Period(public val `value`: com.google.fhir.model.r4b.Period) : Serviced

      public companion object {
        internal fun from(
          dateValue: com.google.fhir.model.r4b.Date?,
          periodValue: com.google.fhir.model.r4b.Period?,
        ): Serviced? {
          if (dateValue != null) return Date(dateValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    @Serializable(with = ClaimResponseAddItemLocationSerializer::class)
    public sealed interface Location {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asAddress(): Address? = this as? Address

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(
        public val `value`: com.google.fhir.model.r4b.CodeableConcept
      ) : Location

      public data class Address(public val `value`: com.google.fhir.model.r4b.Address) : Location

      public data class Reference(public val `value`: com.google.fhir.model.r4b.Reference) :
        Location

      public companion object {
        internal fun from(
          codeableConceptValue: com.google.fhir.model.r4b.CodeableConcept?,
          addressValue: com.google.fhir.model.r4b.Address?,
          referenceValue: com.google.fhir.model.r4b.Reference?,
        ): Location? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (addressValue != null) return Address(addressValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * When the value is a group code then this item collects a set of related claim details,
       * otherwise this contains the product, service, drug or other billing code for the item.
       *
       * If this is an actual service or product line, i.e. not a Group, then use code to indicate
       * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
       * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of thing
       * being grouped e.g. 'glasses' or 'compound'.
       */
      public var productOrService: CodeableConcept.Builder,
      /** The adjudication results. */
      public var adjudication: MutableList<Item.Adjudication.Builder>,
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

      /** Claim items which this service line is intended to replace. */
      public var itemSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /**
       * The sequence number of the details within the claim item which this line is intended to
       * replace.
       */
      public var detailSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /**
       * The sequence number of the sub-details within the details within the claim item which this
       * line is intended to replace.
       */
      public var subdetailSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /** The providers who are authorized for the services rendered to the patient. */
      public var provider: MutableList<Reference.Builder> = mutableListOf()

      /**
       * Item typification or modifiers codes to convey additional context for the product or
       * service.
       *
       * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
       * Medical whether the treatment was outside the clinic or outside of office hours.
       */
      public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Identifies the program under which this may be recovered.
       *
       * For example: Neonatal program, child dental program or drug users recovery program.
       */
      public var programCode: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The date or dates when the service or product was supplied, performed or completed. */
      public var serviced: Serviced? = null

      /** Where the product or service was provided. */
      public var location: Location? = null

      /** The number of repetitions of a service or product. */
      public var quantity: Quantity.Builder? = null

      /**
       * If the item is not a group then this is the fee for the product or service, otherwise this
       * is the total of the fees for the details of the group.
       */
      public var unitPrice: Money.Builder? = null

      /**
       * A real number that represents a multiplier used in determining the overall value of
       * services delivered and/or goods received. The concept of a Factor allows for a discount or
       * surcharge multiplier to be applied to a monetary amount.
       *
       * To show a 10% senior's discount, the value entered is: 0.90 (1.00 - 0.10).
       */
      public var factor: Decimal.Builder? = null

      /**
       * The quantity times the unit price for an additional service or product or charge.
       *
       * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
       * assumed to be 1 if not supplied.
       */
      public var net: Money.Builder? = null

      /**
       * Physical service site on the patient (limb, tooth, etc.).
       *
       * For example: Providing a tooth code allows an insurer to identify a provider performing a
       * filling on a tooth that was previously removed.
       */
      public var bodySite: CodeableConcept.Builder? = null

      /** A region or surface of the bodySite, e.g. limb region or tooth surface(s). */
      public var subSite: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

      /** The second-tier service adjudications for payor added services. */
      public var detail: MutableList<Detail.Builder> = mutableListOf()

      public fun build(): AddItem =
        AddItem(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          itemSequence = itemSequence.map { it.build() },
          detailSequence = detailSequence.map { it.build() },
          subdetailSequence = subdetailSequence.map { it.build() },
          provider = provider.map { it.build() },
          productOrService = productOrService.build(),
          modifier = modifier.map { it.build() },
          programCode = programCode.map { it.build() },
          serviced = serviced,
          location = location,
          quantity = quantity?.build(),
          unitPrice = unitPrice?.build(),
          factor = factor?.build(),
          net = net?.build(),
          bodySite = bodySite?.build(),
          subSite = subSite.map { it.build() },
          noteNumber = noteNumber.map { it.build() },
          adjudication = adjudication.map { it.build() },
          detail = detail.map { it.build() },
        )
    }
  }

  /** Categorized monetary totals for the adjudication. */
  @Serializable(with = ClaimResponseTotalSerializer::class)
  public data class Total(
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
     * A code to indicate the information type of this adjudication record. Information types may
     * include: the value submitted, maximum values or percentages allowed or payable under the
     * plan, amounts that the patient is responsible for in aggregate or pertaining to this item,
     * amounts paid by other coverages, and the benefit payable for this item.
     *
     * For example codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
     */
    public val category: CodeableConcept,
    /** Monetary total amount associated with the category. */
    public val amount: Money,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(category.toBuilder(), amount.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * A code to indicate the information type of this adjudication record. Information types may
       * include: the value submitted, maximum values or percentages allowed or payable under the
       * plan, amounts that the patient is responsible for in aggregate or pertaining to this item,
       * amounts paid by other coverages, and the benefit payable for this item.
       *
       * For example codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
       */
      public var category: CodeableConcept.Builder,
      /** Monetary total amount associated with the category. */
      public var amount: Money.Builder,
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

      public fun build(): Total =
        Total(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category.build(),
          amount = amount.build(),
        )
    }
  }

  /** Payment details for the adjudication of the claim. */
  @Serializable(with = ClaimResponsePaymentSerializer::class)
  public data class Payment(
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
    /** Whether this represents partial or complete payment of the benefits payable. */
    public val type: CodeableConcept,
    /**
     * Total amount of all adjustments to this payment included in this transaction which are not
     * related to this claim's adjudication.
     *
     * Insurers will deduct amounts owing from the provider (adjustment), such as a prior
     * overpayment, from the amount owing to the provider (benefits payable) when payment is made to
     * the provider.
     */
    public val adjustment: Money? = null,
    /** Reason for the payment adjustment. */
    public val adjustmentReason: CodeableConcept? = null,
    /** Estimated date the payment will be issued or the actual issue date of payment. */
    public val date: Date? = null,
    /** Benefits payable less any payment adjustment. */
    public val amount: Money,
    /**
     * Issuer's unique identifier for the payment instrument.
     *
     * For example: EFT number or check number.
     */
    public val identifier: Identifier? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder(), amount.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          adjustment = this@with.adjustment?.toBuilder()
          adjustmentReason = this@with.adjustmentReason?.toBuilder()
          date = this@with.date?.toBuilder()
          identifier = this@with.identifier?.toBuilder()
        }
      }

    public class Builder(
      /** Whether this represents partial or complete payment of the benefits payable. */
      public var type: CodeableConcept.Builder,
      /** Benefits payable less any payment adjustment. */
      public var amount: Money.Builder,
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

      /**
       * Total amount of all adjustments to this payment included in this transaction which are not
       * related to this claim's adjudication.
       *
       * Insurers will deduct amounts owing from the provider (adjustment), such as a prior
       * overpayment, from the amount owing to the provider (benefits payable) when payment is made
       * to the provider.
       */
      public var adjustment: Money.Builder? = null

      /** Reason for the payment adjustment. */
      public var adjustmentReason: CodeableConcept.Builder? = null

      /** Estimated date the payment will be issued or the actual issue date of payment. */
      public var date: Date.Builder? = null

      /**
       * Issuer's unique identifier for the payment instrument.
       *
       * For example: EFT number or check number.
       */
      public var identifier: Identifier.Builder? = null

      public fun build(): Payment =
        Payment(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          adjustment = adjustment?.build(),
          adjustmentReason = adjustmentReason?.build(),
          date = date?.build(),
          amount = amount.build(),
          identifier = identifier?.build(),
        )
    }
  }

  /** A note that describes or explains adjudication results in a human readable form. */
  @Serializable(with = ClaimResponseProcessNoteSerializer::class)
  public data class ProcessNote(
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
    /** A number to uniquely identify a note entry. */
    public val number: PositiveInt? = null,
    /** The business purpose of the note text. */
    public val type: Enumeration<NoteType>? = null,
    /** The explanation or description associated with the processing. */
    public val text: String,
    /**
     * A code to define the language used in the text of the note.
     *
     * Only required if the language is different from the resource language.
     */
    public val language: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(text.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          number = this@with.number?.toBuilder()
          type = this@with.type
          language = this@with.language?.toBuilder()
        }
      }

    public class Builder(
      /** The explanation or description associated with the processing. */
      public var text: String.Builder
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

      /** A number to uniquely identify a note entry. */
      public var number: PositiveInt.Builder? = null

      /** The business purpose of the note text. */
      public var type: Enumeration<NoteType>? = null

      /**
       * A code to define the language used in the text of the note.
       *
       * Only required if the language is different from the resource language.
       */
      public var language: CodeableConcept.Builder? = null

      public fun build(): ProcessNote =
        ProcessNote(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          number = number?.build(),
          type = type,
          text = text.build(),
          language = language?.build(),
        )
    }
  }

  /**
   * Financial instruments for reimbursement for the health care products and services specified on
   * the claim.
   */
  @Serializable(with = ClaimResponseInsuranceSerializer::class)
  public data class Insurance(
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
     * A number to uniquely identify insurance entries and provide a sequence of coverages to convey
     * coordination of benefit order.
     */
    public val sequence: PositiveInt,
    /**
     * A flag to indicate that this Coverage is to be used for adjudication of this claim when set
     * to true.
     *
     * A patient may (will) have multiple insurance policies which provide reimbursement for
     * healthcare services and products. For example a person may also be covered by their spouse's
     * policy and both appear in the list (and may be from the same insurer). This flag will be set
     * to true for only one of the listed policies and that policy will be used for adjudicating
     * this claim. Other claims would be created to request adjudication against the other listed
     * policies.
     */
    public val focal: Boolean,
    /**
     * Reference to the insurance card level information contained in the Coverage resource. The
     * coverage issuing insurer will use these details to locate the patient's actual coverage
     * within the insurer's information system.
     */
    public val coverage: Reference,
    /**
     * A business agreement number established between the provider and the insurer for special
     * business processing purposes.
     */
    public val businessArrangement: String? = null,
    /**
     * The result of the adjudication of the line items for the Coverage specified in this
     * insurance.
     *
     * Must not be specified when 'focal=true' for this insurance.
     */
    public val claimResponse: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder(), focal.toBuilder(), coverage.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          businessArrangement = this@with.businessArrangement?.toBuilder()
          claimResponse = this@with.claimResponse?.toBuilder()
        }
      }

    public class Builder(
      /**
       * A number to uniquely identify insurance entries and provide a sequence of coverages to
       * convey coordination of benefit order.
       */
      public var sequence: PositiveInt.Builder,
      /**
       * A flag to indicate that this Coverage is to be used for adjudication of this claim when set
       * to true.
       *
       * A patient may (will) have multiple insurance policies which provide reimbursement for
       * healthcare services and products. For example a person may also be covered by their
       * spouse's policy and both appear in the list (and may be from the same insurer). This flag
       * will be set to true for only one of the listed policies and that policy will be used for
       * adjudicating this claim. Other claims would be created to request adjudication against the
       * other listed policies.
       */
      public var focal: Boolean.Builder,
      /**
       * Reference to the insurance card level information contained in the Coverage resource. The
       * coverage issuing insurer will use these details to locate the patient's actual coverage
       * within the insurer's information system.
       */
      public var coverage: Reference.Builder,
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

      /**
       * A business agreement number established between the provider and the insurer for special
       * business processing purposes.
       */
      public var businessArrangement: String.Builder? = null

      /**
       * The result of the adjudication of the line items for the Coverage specified in this
       * insurance.
       *
       * Must not be specified when 'focal=true' for this insurance.
       */
      public var claimResponse: Reference.Builder? = null

      public fun build(): Insurance =
        Insurance(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          focal = focal.build(),
          coverage = coverage.build(),
          businessArrangement = businessArrangement?.build(),
          claimResponse = claimResponse?.build(),
        )
    }
  }

  /** Errors encountered during the processing of the adjudication. */
  @Serializable(with = ClaimResponseErrorSerializer::class)
  public data class Error(
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
     * The sequence number of the line item submitted which contains the error. This value is
     * omitted when the error occurs outside of the item structure.
     */
    public val itemSequence: PositiveInt? = null,
    /**
     * The sequence number of the detail within the line item submitted which contains the error.
     * This value is omitted when the error occurs outside of the item structure.
     */
    public val detailSequence: PositiveInt? = null,
    /**
     * The sequence number of the sub-detail within the detail within the line item submitted which
     * contains the error. This value is omitted when the error occurs outside of the item
     * structure.
     */
    public val subDetailSequence: PositiveInt? = null,
    /**
     * An error code, from a specified code system, which details why the claim could not be
     * adjudicated.
     */
    public val code: CodeableConcept,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          itemSequence = this@with.itemSequence?.toBuilder()
          detailSequence = this@with.detailSequence?.toBuilder()
          subDetailSequence = this@with.subDetailSequence?.toBuilder()
        }
      }

    public class Builder(
      /**
       * An error code, from a specified code system, which details why the claim could not be
       * adjudicated.
       */
      public var code: CodeableConcept.Builder
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

      /**
       * The sequence number of the line item submitted which contains the error. This value is
       * omitted when the error occurs outside of the item structure.
       */
      public var itemSequence: PositiveInt.Builder? = null

      /**
       * The sequence number of the detail within the line item submitted which contains the error.
       * This value is omitted when the error occurs outside of the item structure.
       */
      public var detailSequence: PositiveInt.Builder? = null

      /**
       * The sequence number of the sub-detail within the detail within the line item submitted
       * which contains the error. This value is omitted when the error occurs outside of the item
       * structure.
       */
      public var subDetailSequence: PositiveInt.Builder? = null

      public fun build(): Error =
        Error(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          itemSequence = itemSequence?.build(),
          detailSequence = detailSequence?.build(),
          subDetailSequence = subDetailSequence?.build(),
          code = code.build(),
        )
    }
  }

  public class Builder(
    /**
     * The status of the resource instance.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<FinancialResourceStatusCodes>,
    /**
     * A finer grained suite of claim type codes which may convey additional information such as
     * Inpatient vs Outpatient and/or a specialty service.
     *
     * This may contain the local bill type codes, for example the US UB-04 bill type code or the
     * CMS bill type.
     */
    public var type: CodeableConcept.Builder,
    /**
     * A code to indicate whether the nature of the request is: to request adjudication of products
     * and services previously rendered; or requesting authorization and adjudication for provision
     * in the future; or requesting the non-binding adjudication of the listed products and services
     * which could be provided in the future.
     */
    public var use: Enumeration<Use>,
    /**
     * The party to whom the professional services and/or products have been supplied or are being
     * considered and for whom actual for facast reimbursement is sought.
     */
    public var patient: Reference.Builder,
    /** The date this resource was created. */
    public var created: DateTime.Builder,
    /** The party responsible for authorization, adjudication and reimbursement. */
    public var insurer: Reference.Builder,
    /**
     * The outcome of the claim, predetermination, or preauthorization processing.
     *
     * The resource may be used to indicate that: the request has been held (queued) for processing;
     * that it has been processed and errors found (error); that no errors were found and that some
     * of the adjudication has been undertaken (partial) or that all of the adjudication has been
     * undertaken (complete).
     */
    public var outcome: Enumeration<RemittanceOutcome>,
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

    /** A unique identifier assigned to this claim response. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A finer grained suite of claim type codes which may convey additional information such as
     * Inpatient vs Outpatient and/or a specialty service.
     *
     * This may contain the local bill type codes, for example the US UB-04 bill type code or the
     * CMS bill type.
     */
    public var subType: CodeableConcept.Builder? = null

    /**
     * The provider which is responsible for the claim, predetermination or preauthorization.
     *
     * Typically this field would be 1..1 where this party is responsible for the claim but not
     * necessarily professionally responsible for the provision of the individual products and
     * services listed below.
     */
    public var requestor: Reference.Builder? = null

    /** Original request resource reference. */
    public var request: Reference.Builder? = null

    /** A human readable description of the status of the adjudication. */
    public var disposition: String.Builder? = null

    /**
     * Reference from the Insurer which is used in later communications which refers to this
     * adjudication.
     *
     * This value is only present on preauthorization adjudications.
     */
    public var preAuthRef: String.Builder? = null

    /** The time frame during which this authorization is effective. */
    public var preAuthPeriod: Period.Builder? = null

    /** Type of Party to be reimbursed: subscriber, provider, other. */
    public var payeeType: CodeableConcept.Builder? = null

    /**
     * A claim line. Either a simple (a product or service) or a 'group' of details which can also
     * be a simple items or groups of sub-details.
     */
    public var item: MutableList<Item.Builder> = mutableListOf()

    /** The first-tier service adjudications for payor added product or service lines. */
    public var addItem: MutableList<AddItem.Builder> = mutableListOf()

    /**
     * The adjudication results which are presented at the header level rather than at the line-item
     * or add-item levels.
     */
    public var adjudication: MutableList<Item.Adjudication.Builder> = mutableListOf()

    /**
     * Categorized monetary totals for the adjudication.
     *
     * Totals for amounts submitted, co-pays, benefits payable etc.
     */
    public var total: MutableList<Total.Builder> = mutableListOf()

    /** Payment details for the adjudication of the claim. */
    public var payment: Payment.Builder? = null

    /**
     * A code, used only on a response to a preauthorization, to indicate whether the benefits
     * payable have been reserved and for whom.
     *
     * Fund would be release by a future claim quoting the preAuthRef of this response. Examples of
     * values include: provider, patient, none.
     */
    public var fundsReserve: CodeableConcept.Builder? = null

    /**
     * A code for the form to be used for printing the content.
     *
     * May be needed to identify specific jurisdictional forms.
     */
    public var formCode: CodeableConcept.Builder? = null

    /**
     * The actual form, by reference or inclusion, for printing the content or an EOB.
     *
     * Needed to permit insurers to include the actual form.
     */
    public var form: Attachment.Builder? = null

    /** A note that describes or explains adjudication results in a human readable form. */
    public var processNote: MutableList<ProcessNote.Builder> = mutableListOf()

    /**
     * Request for additional supporting or authorizing information.
     *
     * For example: professional reports, documents, images, clinical resources, or accident
     * reports.
     */
    public var communicationRequest: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Financial instruments for reimbursement for the health care products and services specified
     * on the claim.
     *
     * All insurance coverages for the patient which may be applicable for reimbursement, of the
     * products and services listed in the claim, are typically provided in the claim to allow
     * insurers to confirm the ordering of the insurance coverages relative to local 'coordination
     * of benefit' rules. One coverage (and only one) with 'focal=true' is to be used in the
     * adjudication of this claim. Coverages appearing before the focal Coverage in the list, and
     * where 'subrogation=false', should provide a reference to the ClaimResponse containing the
     * adjudication results of the prior claim.
     */
    public var insurance: MutableList<Insurance.Builder> = mutableListOf()

    /**
     * Errors encountered during the processing of the adjudication.
     *
     * If the request contains errors then an error element should be provided and no adjudication
     * related sections (item, addItem, or payment) should be present.
     */
    public var error: MutableList<Error.Builder> = mutableListOf()

    override fun build(): ClaimResponse =
      ClaimResponse(
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
        type = type.build(),
        subType = subType?.build(),
        use = use,
        patient = patient.build(),
        created = created.build(),
        insurer = insurer.build(),
        requestor = requestor?.build(),
        request = request?.build(),
        outcome = outcome,
        disposition = disposition?.build(),
        preAuthRef = preAuthRef?.build(),
        preAuthPeriod = preAuthPeriod?.build(),
        payeeType = payeeType?.build(),
        item = item.map { it.build() },
        addItem = addItem.map { it.build() },
        adjudication = adjudication.map { it.build() },
        total = total.map { it.build() },
        payment = payment?.build(),
        fundsReserve = fundsReserve?.build(),
        formCode = formCode?.build(),
        form = form?.build(),
        processNote = processNote.map { it.build() },
        communicationRequest = communicationRequest.map { it.build() },
        insurance = insurance.map { it.build() },
        error = error.map { it.build() },
      )
  }

  /** This value set includes Status codes. */
  public enum class FinancialResourceStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/fm-status", "Active"),
    Cancelled("cancelled", "http://hl7.org/fhir/fm-status", "Cancelled"),
    Draft("draft", "http://hl7.org/fhir/fm-status", "Draft"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/fm-status", "Entered in Error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

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

  /** The purpose of the Claim: predetermination, preauthorization, claim. */
  public enum class Use(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Claim("claim", "http://hl7.org/fhir/claim-use", "Claim"),
    Preauthorization("preauthorization", "http://hl7.org/fhir/claim-use", "Preauthorization"),
    Predetermination("predetermination", "http://hl7.org/fhir/claim-use", "Predetermination");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): Use =
        when (code) {
          "claim" -> Claim
          "preauthorization" -> Preauthorization
          "predetermination" -> Predetermination
          else -> throw IllegalArgumentException("Unknown code $code for enum Use")
        }
    }
  }
}
