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

import dev.ohs.fhir.model.r5.serializers.ClaimResponseAddItemBodySiteSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseAddItemDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseAddItemDetailSubDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseAddItemLocationSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseAddItemSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseAddItemServicedSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseErrorSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseEventSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseEventWhenSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseInsuranceSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseItemAdjudicationSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseItemDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseItemDetailSubDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseItemReviewOutcomeSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseItemSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponsePaymentSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseProcessNoteSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimResponseTotalSerializer
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
  /** A unique identifier assigned to this claim response. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Trace number for tracking purposes. May be defined at the jurisdiction level or between trading
   * partners.
   */
  public val traceNumber: List<Identifier> = listOf(),
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
   * A code to indicate whether the nature of the request is: Claim - A request to an Insurer to
   * adjudicate the supplied charges for health care goods and services under the identified policy
   * and to pay the determined Benefit amount, if any; Preauthorization - A request to an Insurer to
   * adjudicate the supplied proposed future charges for health care goods and services under the
   * identified policy and to approve the services and provide the expected benefit amounts and
   * potentially to reserve funds to pay the benefits when Claims for the indicated services are
   * later submitted; or, Pre-determination - A request to an Insurer to adjudicate the supplied
   * 'what if' charges for health care goods and services under the identified policy and report
   * back what the Benefit payable would be had the services actually been provided.
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
  public val insurer: Reference? = null,
  /**
   * The provider which is responsible for the claim, predetermination or preauthorization.
   *
   * Typically this field would be 1..1 where this party is accountable for the data content within
   * the claim but is not necessarily the facility, provider group or practitioner who provided the
   * products and services listed within this claim resource. This field is the Billing Provider,
   * for example, a facility, provider group, lab or practitioner..
   */
  public val requestor: Reference? = null,
  /** Original request resource reference. */
  public val request: Reference? = null,
  /**
   * The outcome of the claim, predetermination, or preauthorization processing.
   *
   * The resource may be used to indicate that the Claim/Preauthorization/Pre-determination has been
   * received but processing has not begun (queued); that it has been processed and one or more
   * errors have been detected (error); no errors were detected and some of the adjudication
   * processing has been performed (partial); or all of the adjudication processing has completed
   * without errors (complete).
   */
  public val outcome: Enumeration<ClaimProcessingCodes>,
  /**
   * The result of the claim, predetermination, or preauthorization adjudication.
   *
   * The element is used to indicate the current state of the adjudication overall for the claim
   * resource, for example: the request has been held (pended) for adjudication processing, for
   * manual review or other reasons; that it has been processed and will be paid, or the outstanding
   * paid, as submitted (approved); that no amount will be paid (denied); or that some amount
   * between zero and the submitted amount will be paid (partial).
   */
  public val decision: CodeableConcept? = null,
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
  /** Information code for an event with a corresponding date or period. */
  public val event: List<Event> = listOf(),
  /** Type of Party to be reimbursed: subscriber, provider, other. */
  public val payeeType: CodeableConcept? = null,
  /**
   * Healthcare encounters related to this claim.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: List<Reference> = listOf(),
  /**
   * A package billing code or bundle code used to group products and services to a particular
   * health condition (such as heart attack) which is based on a predetermined grouping code system.
   *
   * For example DRG (Diagnosis Related Group) or a bundled billing code. A patient may have a
   * diagnosis of a Myocardial Infarction and a DRG for HeartAttack would be assigned. The Claim
   * item (and possible subsequent claims) would refer to the DRG for those line items that were for
   * services related to the heart attack event.
   */
  public val diagnosisRelatedGroup: CodeableConcept? = null,
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
      Builder(status, type.toBuilder(), use, patient.toBuilder(), created.toBuilder(), outcome)
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
          traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
          subType = this@with.subType?.toBuilder()
          insurer = this@with.insurer?.toBuilder()
          requestor = this@with.requestor?.toBuilder()
          request = this@with.request?.toBuilder()
          decision = this@with.decision?.toBuilder()
          disposition = this@with.disposition?.toBuilder()
          preAuthRef = this@with.preAuthRef?.toBuilder()
          preAuthPeriod = this@with.preAuthPeriod?.toBuilder()
          event = this@with.event.map { it.toBuilder() }.toMutableList()
          payeeType = this@with.payeeType?.toBuilder()
          encounter = this@with.encounter.map { it.toBuilder() }.toMutableList()
          diagnosisRelatedGroup = this@with.diagnosisRelatedGroup?.toBuilder()
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

  /** Information code for an event with a corresponding date or period. */
  @Serializable(with = ClaimResponseEventSerializer::class)
  public data class Event(
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
    /** A coded event such as when a service is expected or a card printed. */
    public val type: CodeableConcept,
    /**
     * A date or period in the past or future indicating when the event occurred or is expectd to
     * occur.
     */
    public val `when`: When,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder(), `when`).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    @Serializable(with = ClaimResponseEventWhenSerializer::class)
    public sealed interface When {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : When

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : When

      public companion object {
        internal fun from(
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
        ): When? {
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    public class Builder(
      /** A coded event such as when a service is expected or a card printed. */
      public var type: CodeableConcept.Builder,
      /**
       * A date or period in the past or future indicating when the event occurred or is expectd to
       * occur.
       */
      public var `when`: When,
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

      public fun build(): Event =
        Event(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `when` = `when`,
        )
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
    /** A number to uniquely reference the claim item entries. */
    public val itemSequence: PositiveInt,
    /**
     * Trace number for tracking purposes. May be defined at the jurisdiction level or between
     * trading partners.
     */
    public val traceNumber: List<Identifier> = listOf(),
    /** The numbers associated with notes below which apply to the adjudication of this item. */
    public val noteNumber: List<PositiveInt> = listOf(),
    /** The high-level results of the adjudication if adjudication has been performed. */
    public val reviewOutcome: ReviewOutcome? = null,
    /**
     * If this item is a group then the values here are a summary of the adjudication of the detail
     * items. If this item is a simple product or service then this is the result of the
     * adjudication of this item.
     */
    public val adjudication: List<Adjudication> = listOf(),
    /**
     * A claim detail. Either a simple (a product or service) or a 'group' of sub-details which are
     * simple items.
     */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(itemSequence.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
          noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
          reviewOutcome = this@with.reviewOutcome?.toBuilder()
          adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
        }
      }

    /** The high-level results of the adjudication if adjudication has been performed. */
    @Serializable(with = ClaimResponseItemReviewOutcomeSerializer::class)
    public data class ReviewOutcome(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * The result of the claim, predetermination, or preauthorization adjudication.
       *
       * The element is used to indicate the current state of the adjudication overall for the claim
       * resource, for example: the request has been held (pended) for adjudication processing, for
       * manual review or other reasons; that it has been processed and will be paid, or the
       * outstanding paid, as submitted (approved); that no amount will be paid (denied); or that
       * some amount between zero and the submitted amount will be paid (partial).
       */
      public val decision: CodeableConcept? = null,
      /**
       * The reasons for the result of the claim, predetermination, or preauthorization
       * adjudication.
       */
      public val reason: List<CodeableConcept> = listOf(),
      /**
       * Reference from the Insurer which is used in later communications which refers to this
       * adjudication.
       *
       * This value is only present on preauthorization adjudications.
       */
      public val preAuthRef: String? = null,
      /** The time frame during which this authorization is effective. */
      public val preAuthPeriod: Period? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            decision = this@with.decision?.toBuilder()
            reason = this@with.reason.map { it.toBuilder() }.toMutableList()
            preAuthRef = this@with.preAuthRef?.toBuilder()
            preAuthPeriod = this@with.preAuthPeriod?.toBuilder()
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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
         * The result of the claim, predetermination, or preauthorization adjudication.
         *
         * The element is used to indicate the current state of the adjudication overall for the
         * claim resource, for example: the request has been held (pended) for adjudication
         * processing, for manual review or other reasons; that it has been processed and will be
         * paid, or the outstanding paid, as submitted (approved); that no amount will be paid
         * (denied); or that some amount between zero and the submitted amount will be paid
         * (partial).
         */
        public var decision: CodeableConcept.Builder? = null

        /**
         * The reasons for the result of the claim, predetermination, or preauthorization
         * adjudication.
         */
        public var reason: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Reference from the Insurer which is used in later communications which refers to this
         * adjudication.
         *
         * This value is only present on preauthorization adjudications.
         */
        public var preAuthRef: String.Builder? = null

        /** The time frame during which this authorization is effective. */
        public var preAuthPeriod: Period.Builder? = null

        public fun build(): ReviewOutcome =
          ReviewOutcome(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            decision = decision?.build(),
            reason = reason.map { it.build() },
            preAuthRef = preAuthRef?.build(),
            preAuthPeriod = preAuthPeriod?.build(),
          )
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
      override val extension: List<Extension> = listOf(),
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
      public val quantity: Quantity? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(category.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            reason = this@with.reason?.toBuilder()
            amount = this@with.amount?.toBuilder()
            quantity = this@with.quantity?.toBuilder()
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
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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
        public var quantity: Quantity.Builder? = null

        public fun build(): Adjudication =
          Adjudication(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            category = category.build(),
            reason = reason?.build(),
            amount = amount?.build(),
            quantity = quantity?.build(),
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** A number to uniquely reference the claim detail entry. */
      public val detailSequence: PositiveInt,
      /**
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public val traceNumber: List<Identifier> = listOf(),
      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public val noteNumber: List<PositiveInt> = listOf(),
      /** The high-level results of the adjudication if adjudication has been performed. */
      public val reviewOutcome: ReviewOutcome? = null,
      /** The adjudication results. */
      public val adjudication: List<Adjudication> = listOf(),
      /** A sub-detail adjudication of a simple product or service. */
      public val subDetail: List<SubDetail> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(detailSequence.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
            noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
            reviewOutcome = this@with.reviewOutcome?.toBuilder()
            adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
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
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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
        /**
         * Trace number for tracking purposes. May be defined at the jurisdiction level or between
         * trading partners.
         */
        public val traceNumber: List<Identifier> = listOf(),
        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public val noteNumber: List<PositiveInt> = listOf(),
        /** The high-level results of the adjudication if adjudication has been performed. */
        public val reviewOutcome: ReviewOutcome? = null,
        /** The adjudication results. */
        public val adjudication: List<Adjudication> = listOf(),
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(subDetailSequence.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
              noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              reviewOutcome = this@with.reviewOutcome?.toBuilder()
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
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and managable, there is a strict set of governance applied to the
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
           * Trace number for tracking purposes. May be defined at the jurisdiction level or between
           * trading partners.
           */
          public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

          /**
           * The numbers associated with notes below which apply to the adjudication of this item.
           */
          public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

          /** The high-level results of the adjudication if adjudication has been performed. */
          public var reviewOutcome: ReviewOutcome.Builder? = null

          /** The adjudication results. */
          public var adjudication: MutableList<Adjudication.Builder> = mutableListOf()

          public fun build(): SubDetail =
            SubDetail(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              subDetailSequence = subDetailSequence.build(),
              traceNumber = traceNumber.map { it.build() },
              noteNumber = noteNumber.map { it.build() },
              reviewOutcome = reviewOutcome?.build(),
              adjudication = adjudication.map { it.build() },
            )
        }
      }

      public class Builder(
        /** A number to uniquely reference the claim detail entry. */
        public var detailSequence: PositiveInt.Builder
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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
         * Trace number for tracking purposes. May be defined at the jurisdiction level or between
         * trading partners.
         */
        public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

        /** The high-level results of the adjudication if adjudication has been performed. */
        public var reviewOutcome: ReviewOutcome.Builder? = null

        /** The adjudication results. */
        public var adjudication: MutableList<Adjudication.Builder> = mutableListOf()

        /** A sub-detail adjudication of a simple product or service. */
        public var subDetail: MutableList<SubDetail.Builder> = mutableListOf()

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            detailSequence = detailSequence.build(),
            traceNumber = traceNumber.map { it.build() },
            noteNumber = noteNumber.map { it.build() },
            reviewOutcome = reviewOutcome?.build(),
            adjudication = adjudication.map { it.build() },
            subDetail = subDetail.map { it.build() },
          )
      }
    }

    public class Builder(
      /** A number to uniquely reference the claim item entries. */
      public var itemSequence: PositiveInt.Builder
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
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

      /** The high-level results of the adjudication if adjudication has been performed. */
      public var reviewOutcome: ReviewOutcome.Builder? = null

      /**
       * If this item is a group then the values here are a summary of the adjudication of the
       * detail items. If this item is a simple product or service then this is the result of the
       * adjudication of this item.
       */
      public var adjudication: MutableList<Adjudication.Builder> = mutableListOf()

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
          traceNumber = traceNumber.map { it.build() },
          noteNumber = noteNumber.map { it.build() },
          reviewOutcome = reviewOutcome?.build(),
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
    /**
     * Trace number for tracking purposes. May be defined at the jurisdiction level or between
     * trading partners.
     */
    public val traceNumber: List<Identifier> = listOf(),
    /** The providers who are authorized for the services rendered to the patient. */
    public val provider: List<Reference> = listOf(),
    /** The type of revenue or cost center providing the product and/or service. */
    public val revenue: CodeableConcept? = null,
    /**
     * When the value is a group code then this item collects a set of related item details,
     * otherwise this contains the product, service, drug or other billing code for the item. This
     * element may be the start of a range of .productOrService codes used in conjunction with
     * .productOrServiceEnd or it may be a solo element where .productOrServiceEnd is not used.
     *
     * If this is an actual service or product line, i.e. not a Group, then use code to indicate the
     * Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN, RxNorm,
     * ACHI, CCI). If a grouping item then use a group code to indicate the type of thing being
     * grouped e.g. 'glasses' or 'compound'.
     */
    public val productOrService: CodeableConcept? = null,
    /**
     * This contains the end of a range of product, service, drug or other billing codes for the
     * item. This element is not used when the .productOrService is a group code. This value may
     * only be present when a .productOfService code has been provided to convey the start of the
     * range. Typically this value may be used only with preauthorizations and not with claims.
     */
    public val productOrServiceEnd: CodeableConcept? = null,
    /** Request or Referral for Goods or Service to be rendered. */
    public val request: List<Reference> = listOf(),
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
    /** The total of taxes applicable for this product or service. */
    public val tax: Money? = null,
    /**
     * The total amount claimed for the group (if a grouper) or the addItem. Net = unit price *
     * quantity * factor.
     *
     * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
     * assumed to be 1 if not supplied.
     */
    public val net: Money? = null,
    /** Physical location where the service is performed or applies. */
    public val bodySite: List<BodySite> = listOf(),
    /** The numbers associated with notes below which apply to the adjudication of this item. */
    public val noteNumber: List<PositiveInt> = listOf(),
    /** The high-level results of the adjudication if adjudication has been performed. */
    public val reviewOutcome: Item.ReviewOutcome? = null,
    /** The adjudication results. */
    public val adjudication: List<Item.Adjudication> = listOf(),
    /** The second-tier service adjudications for payor added services. */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          itemSequence = this@with.itemSequence.map { it.toBuilder() }.toMutableList()
          detailSequence = this@with.detailSequence.map { it.toBuilder() }.toMutableList()
          subdetailSequence = this@with.subdetailSequence.map { it.toBuilder() }.toMutableList()
          traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
          provider = this@with.provider.map { it.toBuilder() }.toMutableList()
          revenue = this@with.revenue?.toBuilder()
          productOrService = this@with.productOrService?.toBuilder()
          productOrServiceEnd = this@with.productOrServiceEnd?.toBuilder()
          request = this@with.request.map { it.toBuilder() }.toMutableList()
          modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
          programCode = this@with.programCode.map { it.toBuilder() }.toMutableList()
          serviced = this@with.serviced
          location = this@with.location
          quantity = this@with.quantity?.toBuilder()
          unitPrice = this@with.unitPrice?.toBuilder()
          factor = this@with.factor?.toBuilder()
          tax = this@with.tax?.toBuilder()
          net = this@with.net?.toBuilder()
          bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
          noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
          reviewOutcome = this@with.reviewOutcome?.toBuilder()
          adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Physical location where the service is performed or applies. */
    @Serializable(with = ClaimResponseAddItemBodySiteSerializer::class)
    public data class BodySite(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * Physical service site on the patient (limb, tooth, etc.).
       *
       * For example: Providing a tooth code allows an insurer to identify a provider performing a
       * filling on a tooth that was previously removed.
       */
      public val site: List<CodeableReference>,
      /** A region or surface of the bodySite, e.g. limb region or tooth surface(s). */
      public val subSite: List<CodeableConcept> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(site.map { it.toBuilder() }.toMutableList()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            subSite = this@with.subSite.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * Physical service site on the patient (limb, tooth, etc.).
         *
         * For example: Providing a tooth code allows an insurer to identify a provider performing a
         * filling on a tooth that was previously removed.
         */
        public var site: MutableList<CodeableReference.Builder>
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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

        /** A region or surface of the bodySite, e.g. limb region or tooth surface(s). */
        public var subSite: MutableList<CodeableConcept.Builder> = mutableListOf()

        public fun build(): BodySite =
          BodySite(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            site = site.map { it.build() },
            subSite = subSite.map { it.build() },
          )
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public val traceNumber: List<Identifier> = listOf(),
      /** The type of revenue or cost center providing the product and/or service. */
      public val revenue: CodeableConcept? = null,
      /**
       * When the value is a group code then this item collects a set of related item details,
       * otherwise this contains the product, service, drug or other billing code for the item. This
       * element may be the start of a range of .productOrService codes used in conjunction with
       * .productOrServiceEnd or it may be a solo element where .productOrServiceEnd is not used.
       *
       * If this is an actual service or product line, i.e. not a Group, then use code to indicate
       * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
       * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of thing
       * being grouped e.g. 'glasses' or 'compound'.
       */
      public val productOrService: CodeableConcept? = null,
      /**
       * This contains the end of a range of product, service, drug or other billing codes for the
       * item. This element is not used when the .productOrService is a group code. This value may
       * only be present when a .productOfService code has been provided to convey the start of the
       * range. Typically this value may be used only with preauthorizations and not with claims.
       */
      public val productOrServiceEnd: CodeableConcept? = null,
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
      /** The total of taxes applicable for this product or service. */
      public val tax: Money? = null,
      /**
       * The total amount claimed for the group (if a grouper) or the addItem.detail. Net = unit
       * price * quantity * factor.
       *
       * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
       * assumed to be 1 if not supplied.
       */
      public val net: Money? = null,
      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public val noteNumber: List<PositiveInt> = listOf(),
      /** The high-level results of the adjudication if adjudication has been performed. */
      public val reviewOutcome: Item.ReviewOutcome? = null,
      /** The adjudication results. */
      public val adjudication: List<Item.Adjudication> = listOf(),
      /** The third-tier service adjudications for payor added services. */
      public val subDetail: List<SubDetail> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
            revenue = this@with.revenue?.toBuilder()
            productOrService = this@with.productOrService?.toBuilder()
            productOrServiceEnd = this@with.productOrServiceEnd?.toBuilder()
            modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
            quantity = this@with.quantity?.toBuilder()
            unitPrice = this@with.unitPrice?.toBuilder()
            factor = this@with.factor?.toBuilder()
            tax = this@with.tax?.toBuilder()
            net = this@with.net?.toBuilder()
            noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
            reviewOutcome = this@with.reviewOutcome?.toBuilder()
            adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
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
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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
         * Trace number for tracking purposes. May be defined at the jurisdiction level or between
         * trading partners.
         */
        public val traceNumber: List<Identifier> = listOf(),
        /** The type of revenue or cost center providing the product and/or service. */
        public val revenue: CodeableConcept? = null,
        /**
         * When the value is a group code then this item collects a set of related item details,
         * otherwise this contains the product, service, drug or other billing code for the item.
         * This element may be the start of a range of .productOrService codes used in conjunction
         * with .productOrServiceEnd or it may be a solo element where .productOrServiceEnd is not
         * used.
         *
         * If this is an actual service or product line, i.e. not a Group, then use code to indicate
         * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
         * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of
         * thing being grouped e.g. 'glasses' or 'compound'.
         */
        public val productOrService: CodeableConcept? = null,
        /**
         * This contains the end of a range of product, service, drug or other billing codes for the
         * item. This element is not used when the .productOrService is a group code. This value may
         * only be present when a .productOfService code has been provided to convey the start of
         * the range. Typically this value may be used only with preauthorizations and not with
         * claims.
         */
        public val productOrServiceEnd: CodeableConcept? = null,
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
        /** The total of taxes applicable for this product or service. */
        public val tax: Money? = null,
        /**
         * The total amount claimed for the addItem.detail.subDetail. Net = unit price * quantity *
         * factor.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public val net: Money? = null,
        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public val noteNumber: List<PositiveInt> = listOf(),
        /** The high-level results of the adjudication if adjudication has been performed. */
        public val reviewOutcome: Item.ReviewOutcome? = null,
        /** The adjudication results. */
        public val adjudication: List<Item.Adjudication> = listOf(),
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder().apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
              revenue = this@with.revenue?.toBuilder()
              productOrService = this@with.productOrService?.toBuilder()
              productOrServiceEnd = this@with.productOrServiceEnd?.toBuilder()
              modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
              quantity = this@with.quantity?.toBuilder()
              unitPrice = this@with.unitPrice?.toBuilder()
              factor = this@with.factor?.toBuilder()
              tax = this@with.tax?.toBuilder()
              net = this@with.net?.toBuilder()
              noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              reviewOutcome = this@with.reviewOutcome?.toBuilder()
              adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
            }
          }

        public class Builder() {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and managable, there is a strict set of governance applied to the
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
           * Trace number for tracking purposes. May be defined at the jurisdiction level or between
           * trading partners.
           */
          public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

          /** The type of revenue or cost center providing the product and/or service. */
          public var revenue: CodeableConcept.Builder? = null

          /**
           * When the value is a group code then this item collects a set of related item details,
           * otherwise this contains the product, service, drug or other billing code for the item.
           * This element may be the start of a range of .productOrService codes used in conjunction
           * with .productOrServiceEnd or it may be a solo element where .productOrServiceEnd is not
           * used.
           *
           * If this is an actual service or product line, i.e. not a Group, then use code to
           * indicate the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10,
           * NCPDP, DIN, RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate
           * the type of thing being grouped e.g. 'glasses' or 'compound'.
           */
          public var productOrService: CodeableConcept.Builder? = null

          /**
           * This contains the end of a range of product, service, drug or other billing codes for
           * the item. This element is not used when the .productOrService is a group code. This
           * value may only be present when a .productOfService code has been provided to convey the
           * start of the range. Typically this value may be used only with preauthorizations and
           * not with claims.
           */
          public var productOrServiceEnd: CodeableConcept.Builder? = null

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

          /** The total of taxes applicable for this product or service. */
          public var tax: Money.Builder? = null

          /**
           * The total amount claimed for the addItem.detail.subDetail. Net = unit price *
           * quantity * factor.
           *
           * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
           * assumed to be 1 if not supplied.
           */
          public var net: Money.Builder? = null

          /**
           * The numbers associated with notes below which apply to the adjudication of this item.
           */
          public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

          /** The high-level results of the adjudication if adjudication has been performed. */
          public var reviewOutcome: Item.ReviewOutcome.Builder? = null

          /** The adjudication results. */
          public var adjudication: MutableList<Item.Adjudication.Builder> = mutableListOf()

          public fun build(): SubDetail =
            SubDetail(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              traceNumber = traceNumber.map { it.build() },
              revenue = revenue?.build(),
              productOrService = productOrService?.build(),
              productOrServiceEnd = productOrServiceEnd?.build(),
              modifier = modifier.map { it.build() },
              quantity = quantity?.build(),
              unitPrice = unitPrice?.build(),
              factor = factor?.build(),
              tax = tax?.build(),
              net = net?.build(),
              noteNumber = noteNumber.map { it.build() },
              reviewOutcome = reviewOutcome?.build(),
              adjudication = adjudication.map { it.build() },
            )
        }
      }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
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
         * and managable, there is a strict set of governance applied to the definition and use of
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
         * Trace number for tracking purposes. May be defined at the jurisdiction level or between
         * trading partners.
         */
        public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

        /** The type of revenue or cost center providing the product and/or service. */
        public var revenue: CodeableConcept.Builder? = null

        /**
         * When the value is a group code then this item collects a set of related item details,
         * otherwise this contains the product, service, drug or other billing code for the item.
         * This element may be the start of a range of .productOrService codes used in conjunction
         * with .productOrServiceEnd or it may be a solo element where .productOrServiceEnd is not
         * used.
         *
         * If this is an actual service or product line, i.e. not a Group, then use code to indicate
         * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
         * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of
         * thing being grouped e.g. 'glasses' or 'compound'.
         */
        public var productOrService: CodeableConcept.Builder? = null

        /**
         * This contains the end of a range of product, service, drug or other billing codes for the
         * item. This element is not used when the .productOrService is a group code. This value may
         * only be present when a .productOfService code has been provided to convey the start of
         * the range. Typically this value may be used only with preauthorizations and not with
         * claims.
         */
        public var productOrServiceEnd: CodeableConcept.Builder? = null

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

        /** The total of taxes applicable for this product or service. */
        public var tax: Money.Builder? = null

        /**
         * The total amount claimed for the group (if a grouper) or the addItem.detail. Net = unit
         * price * quantity * factor.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public var net: Money.Builder? = null

        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

        /** The high-level results of the adjudication if adjudication has been performed. */
        public var reviewOutcome: Item.ReviewOutcome.Builder? = null

        /** The adjudication results. */
        public var adjudication: MutableList<Item.Adjudication.Builder> = mutableListOf()

        /** The third-tier service adjudications for payor added services. */
        public var subDetail: MutableList<SubDetail.Builder> = mutableListOf()

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            traceNumber = traceNumber.map { it.build() },
            revenue = revenue?.build(),
            productOrService = productOrService?.build(),
            productOrServiceEnd = productOrServiceEnd?.build(),
            modifier = modifier.map { it.build() },
            quantity = quantity?.build(),
            unitPrice = unitPrice?.build(),
            factor = factor?.build(),
            tax = tax?.build(),
            net = net?.build(),
            noteNumber = noteNumber.map { it.build() },
            reviewOutcome = reviewOutcome?.build(),
            adjudication = adjudication.map { it.build() },
            subDetail = subDetail.map { it.build() },
          )
      }
    }

    @Serializable(with = ClaimResponseAddItemServicedSerializer::class)
    public sealed interface Serviced {
      public fun asDate(): Date? = this as? Date

      public fun asPeriod(): Period? = this as? Period

      public data class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Serviced

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Serviced

      public companion object {
        internal fun from(
          dateValue: dev.ohs.fhir.model.r5.Date?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
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

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Location

      public data class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Location

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Location

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          addressValue: dev.ohs.fhir.model.r5.Address?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Location? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (addressValue != null) return Address(addressValue)
          if (referenceValue != null) return Reference(referenceValue)
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

      /**
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

      /** The providers who are authorized for the services rendered to the patient. */
      public var provider: MutableList<Reference.Builder> = mutableListOf()

      /** The type of revenue or cost center providing the product and/or service. */
      public var revenue: CodeableConcept.Builder? = null

      /**
       * When the value is a group code then this item collects a set of related item details,
       * otherwise this contains the product, service, drug or other billing code for the item. This
       * element may be the start of a range of .productOrService codes used in conjunction with
       * .productOrServiceEnd or it may be a solo element where .productOrServiceEnd is not used.
       *
       * If this is an actual service or product line, i.e. not a Group, then use code to indicate
       * the Professional Service or Product supplied (e.g. CTP, HCPCS, USCLS, ICD10, NCPDP, DIN,
       * RxNorm, ACHI, CCI). If a grouping item then use a group code to indicate the type of thing
       * being grouped e.g. 'glasses' or 'compound'.
       */
      public var productOrService: CodeableConcept.Builder? = null

      /**
       * This contains the end of a range of product, service, drug or other billing codes for the
       * item. This element is not used when the .productOrService is a group code. This value may
       * only be present when a .productOfService code has been provided to convey the start of the
       * range. Typically this value may be used only with preauthorizations and not with claims.
       */
      public var productOrServiceEnd: CodeableConcept.Builder? = null

      /** Request or Referral for Goods or Service to be rendered. */
      public var request: MutableList<Reference.Builder> = mutableListOf()

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

      /** The total of taxes applicable for this product or service. */
      public var tax: Money.Builder? = null

      /**
       * The total amount claimed for the group (if a grouper) or the addItem. Net = unit price *
       * quantity * factor.
       *
       * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
       * assumed to be 1 if not supplied.
       */
      public var net: Money.Builder? = null

      /** Physical location where the service is performed or applies. */
      public var bodySite: MutableList<BodySite.Builder> = mutableListOf()

      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

      /** The high-level results of the adjudication if adjudication has been performed. */
      public var reviewOutcome: Item.ReviewOutcome.Builder? = null

      /** The adjudication results. */
      public var adjudication: MutableList<Item.Adjudication.Builder> = mutableListOf()

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
          traceNumber = traceNumber.map { it.build() },
          provider = provider.map { it.build() },
          revenue = revenue?.build(),
          productOrService = productOrService?.build(),
          productOrServiceEnd = productOrServiceEnd?.build(),
          request = request.map { it.build() },
          modifier = modifier.map { it.build() },
          programCode = programCode.map { it.build() },
          serviced = serviced,
          location = location,
          quantity = quantity?.build(),
          unitPrice = unitPrice?.build(),
          factor = factor?.build(),
          tax = tax?.build(),
          net = net?.build(),
          bodySite = bodySite.map { it.build() },
          noteNumber = noteNumber.map { it.build() },
          reviewOutcome = reviewOutcome?.build(),
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
    /** A number to uniquely identify a note entry. */
    public val number: PositiveInt? = null,
    /** The business purpose of the note text. */
    public val type: CodeableConcept? = null,
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
          type = this@with.type?.toBuilder()
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

      /** A number to uniquely identify a note entry. */
      public var number: PositiveInt.Builder? = null

      /** The business purpose of the note text. */
      public var type: CodeableConcept.Builder? = null

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
          type = type?.build(),
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
    /**
     * A [simple subset of FHIRPath](fhirpath.html#simple) limited to element names, repetition
     * indicators and the default child accessor that identifies one of the elements in the resource
     * that caused this issue to be raised.
     *
     * The root of the FHIRPath is the resource or bundle that generated OperationOutcome. Each
     * FHIRPath SHALL resolve to a single node.
     */
    public val expression: List<String> = listOf(),
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
          expression = this@with.expression.map { it.toBuilder() }.toMutableList()
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

      /**
       * A [simple subset of FHIRPath](fhirpath.html#simple) limited to element names, repetition
       * indicators and the default child accessor that identifies one of the elements in the
       * resource that caused this issue to be raised.
       *
       * The root of the FHIRPath is the resource or bundle that generated OperationOutcome. Each
       * FHIRPath SHALL resolve to a single node.
       */
      public var expression: MutableList<String.Builder> = mutableListOf()

      public fun build(): Error =
        Error(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          itemSequence = itemSequence?.build(),
          detailSequence = detailSequence?.build(),
          subDetailSequence = subDetailSequence?.build(),
          code = code.build(),
          expression = expression.map { it.build() },
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
     * A code to indicate whether the nature of the request is: Claim - A request to an Insurer to
     * adjudicate the supplied charges for health care goods and services under the identified
     * policy and to pay the determined Benefit amount, if any; Preauthorization - A request to an
     * Insurer to adjudicate the supplied proposed future charges for health care goods and services
     * under the identified policy and to approve the services and provide the expected benefit
     * amounts and potentially to reserve funds to pay the benefits when Claims for the indicated
     * services are later submitted; or, Pre-determination - A request to an Insurer to adjudicate
     * the supplied 'what if' charges for health care goods and services under the identified policy
     * and report back what the Benefit payable would be had the services actually been provided.
     */
    public var use: Enumeration<Use>,
    /**
     * The party to whom the professional services and/or products have been supplied or are being
     * considered and for whom actual for facast reimbursement is sought.
     */
    public var patient: Reference.Builder,
    /** The date this resource was created. */
    public var created: DateTime.Builder,
    /**
     * The outcome of the claim, predetermination, or preauthorization processing.
     *
     * The resource may be used to indicate that the Claim/Preauthorization/Pre-determination has
     * been received but processing has not begun (queued); that it has been processed and one or
     * more errors have been detected (error); no errors were detected and some of the adjudication
     * processing has been performed (partial); or all of the adjudication processing has completed
     * without errors (complete).
     */
    public var outcome: Enumeration<ClaimProcessingCodes>,
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

    /** A unique identifier assigned to this claim response. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Trace number for tracking purposes. May be defined at the jurisdiction level or between
     * trading partners.
     */
    public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A finer grained suite of claim type codes which may convey additional information such as
     * Inpatient vs Outpatient and/or a specialty service.
     *
     * This may contain the local bill type codes, for example the US UB-04 bill type code or the
     * CMS bill type.
     */
    public var subType: CodeableConcept.Builder? = null

    /** The party responsible for authorization, adjudication and reimbursement. */
    public var insurer: Reference.Builder? = null

    /**
     * The provider which is responsible for the claim, predetermination or preauthorization.
     *
     * Typically this field would be 1..1 where this party is accountable for the data content
     * within the claim but is not necessarily the facility, provider group or practitioner who
     * provided the products and services listed within this claim resource. This field is the
     * Billing Provider, for example, a facility, provider group, lab or practitioner..
     */
    public var requestor: Reference.Builder? = null

    /** Original request resource reference. */
    public var request: Reference.Builder? = null

    /**
     * The result of the claim, predetermination, or preauthorization adjudication.
     *
     * The element is used to indicate the current state of the adjudication overall for the claim
     * resource, for example: the request has been held (pended) for adjudication processing, for
     * manual review or other reasons; that it has been processed and will be paid, or the
     * outstanding paid, as submitted (approved); that no amount will be paid (denied); or that some
     * amount between zero and the submitted amount will be paid (partial).
     */
    public var decision: CodeableConcept.Builder? = null

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

    /** Information code for an event with a corresponding date or period. */
    public var event: MutableList<Event.Builder> = mutableListOf()

    /** Type of Party to be reimbursed: subscriber, provider, other. */
    public var payeeType: CodeableConcept.Builder? = null

    /**
     * Healthcare encounters related to this claim.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A package billing code or bundle code used to group products and services to a particular
     * health condition (such as heart attack) which is based on a predetermined grouping code
     * system.
     *
     * For example DRG (Diagnosis Related Group) or a bundled billing code. A patient may have a
     * diagnosis of a Myocardial Infarction and a DRG for HeartAttack would be assigned. The Claim
     * item (and possible subsequent claims) would refer to the DRG for those line items that were
     * for services related to the heart attack event.
     */
    public var diagnosisRelatedGroup: CodeableConcept.Builder? = null

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
        traceNumber = traceNumber.map { it.build() },
        status = status,
        type = type.build(),
        subType = subType?.build(),
        use = use,
        patient = patient.build(),
        created = created.build(),
        insurer = insurer?.build(),
        requestor = requestor?.build(),
        request = request?.build(),
        outcome = outcome,
        decision = decision?.build(),
        disposition = disposition?.build(),
        preAuthRef = preAuthRef?.build(),
        preAuthPeriod = preAuthPeriod?.build(),
        event = event.map { it.build() },
        payeeType = payeeType?.build(),
        encounter = encounter.map { it.build() },
        diagnosisRelatedGroup = diagnosisRelatedGroup?.build(),
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

  /** This value set includes Claim Processing Outcome codes. */
  public enum class ClaimProcessingCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Queued("queued", "http://hl7.org/fhir/claim-outcome", "Queued"),
    Complete("complete", "http://hl7.org/fhir/claim-outcome", "Processing Complete"),
    Error("error", "http://hl7.org/fhir/claim-outcome", "Error"),
    Partial("partial", "http://hl7.org/fhir/claim-outcome", "Partial Processing");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ClaimProcessingCodes =
        when (code) {
          "queued" -> Queued
          "complete" -> Complete
          "error" -> Error
          "partial" -> Partial
          else -> throw IllegalArgumentException("Unknown code $code for enum ClaimProcessingCodes")
        }
    }
  }
}
