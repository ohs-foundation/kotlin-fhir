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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitAccidentSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitAddItemBodySiteSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitAddItemDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitAddItemDetailSubDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitAddItemSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitBenefitBalanceFinancialSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitBenefitBalanceSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitCareTeamSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitDiagnosisSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitEventSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitInsuranceSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitItemAdjudicationSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitItemBodySiteSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitItemDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitItemDetailSubDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitItemReviewOutcomeSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitItemSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitPayeeSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitPaymentSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitProcedureSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitProcessNoteSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitRelatedSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitSupportingInfoSerializer
import dev.ohs.fhir.model.r5.serializers.ExplanationOfBenefitTotalSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource provides: the claim details; adjudication details from the processing of a Claim;
 * and optionally account balance information, for informing the subscriber of the benefits
 * provided.
 */
@Serializable(with = ExplanationOfBenefitSerializer::class)
@SerialName("ExplanationOfBenefit")
public data class ExplanationOfBenefit(
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
  /** A unique identifier assigned to this explanation of benefit. */
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
  public val status: Enumeration<ExplanationOfBenefitStatus>,
  /**
   * The category of claim, e.g. oral, pharmacy, vision, institutional, professional.
   *
   * The majority of jurisdictions use: oral, pharmacy, vision, professional and institutional, or
   * variants on those terms, as the general styles of claims. The valueset is extensible to
   * accommodate other jurisdictional requirements.
   */
  public val type: CodeableConcept,
  /**
   * A finer grained suite of claim type codes which may convey additional information such as
   * Inpatient vs Outpatient and/or a specialty service.
   *
   * This may contain the local bill type codes such as the US UB-04 bill type code.
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
   * considered and for whom actual for forecast reimbursement is sought.
   */
  public val patient: Reference,
  /**
   * The period for which charges are being submitted.
   *
   * Typically this would be today or in the past for a claim, and today or in the future for
   * preauthorizations and prodeterminations. Typically line item dates of service should fall
   * within the billing period if one is specified.
   */
  public val billablePeriod: Period? = null,
  /** The date this resource was created. */
  public val created: DateTime,
  /** Individual who created the claim, predetermination or preauthorization. */
  public val enterer: Reference? = null,
  /** The party responsible for authorization, adjudication and reimbursement. */
  public val insurer: Reference? = null,
  /**
   * The provider which is responsible for the claim, predetermination or preauthorization.
   *
   * Typically this field would be 1..1 where this party is accountable for the data content within
   * the claim but is not necessarily the facility, provider group or practitioner who provided the
   * products and services listed within this claim resource. This field is the Billing Provider,
   * for example, a facility, provider group, lab or practitioner.
   */
  public val provider: Reference? = null,
  /**
   * The provider-required urgency of processing the request. Typical values include: stat, normal
   * deferred.
   *
   * If a claim processor is unable to complete the processing as per the priority then they should
   * generate an error and not process the request.
   */
  public val priority: CodeableConcept? = null,
  /**
   * A code to indicate whether and for whom funds are to be reserved for future claims.
   *
   * This field is only used for preauthorizations.
   */
  public val fundsReserveRequested: CodeableConcept? = null,
  /**
   * A code, used only on a response to a preauthorization, to indicate whether the benefits payable
   * have been reserved and for whom.
   *
   * Fund would be release by a future claim quoting the preAuthRef of this response. Examples of
   * values include: provider, patient, none.
   */
  public val fundsReserve: CodeableConcept? = null,
  /**
   * Other claims which are related to this claim such as prior submissions or claims for related
   * services or for the same event.
   *
   * For example, for the original treatment and follow-up exams.
   */
  public val related: List<Related> = listOf(),
  /**
   * Prescription is the document/authorization given to the claim author for them to provide
   * products and services for which consideration (reimbursement) is sought. Could be a RX for
   * medications, an 'order' for oxygen or wheelchair or physiotherapy treatments.
   */
  public val prescription: Reference? = null,
  /**
   * Original prescription which has been superseded by this prescription to support the dispensing
   * of pharmacy services, medications or products.
   *
   * For example, a physician may prescribe a medication which the pharmacy determines is
   * contraindicated, or for which the patient has an intolerance, and therefor issues a new
   * prescription for an alternate medication which has the same therapeutic intent. The
   * prescription from the pharmacy becomes the 'prescription' and that from the physician becomes
   * the 'original prescription'.
   */
  public val originalPrescription: Reference? = null,
  /** Information code for an event with a corresponding date or period. */
  public val event: List<Event> = listOf(),
  /**
   * The party to be reimbursed for cost of the products and services according to the terms of the
   * policy.
   *
   * Often providers agree to receive the benefits payable to reduce the near-term costs to the
   * patient. The insurer may decline to pay the provider and may choose to pay the subscriber
   * instead.
   */
  public val payee: Payee? = null,
  /**
   * The referral information received by the claim author, it is not to be used when the author
   * generates a referral for a patient. A copy of that referral may be provided as supporting
   * information. Some insurers require proof of referral to pay for services or to pay specialist
   * rates for services.
   *
   * The referral resource which lists the date, practitioner, reason and other supporting
   * information.
   */
  public val referral: Reference? = null,
  /** Healthcare encounters related to this claim. */
  public val encounter: List<Reference> = listOf(),
  /** Facility where the services were provided. */
  public val facility: Reference? = null,
  /**
   * The business identifier for the instance of the adjudication request: claim predetermination or
   * preauthorization.
   */
  public val claim: Reference? = null,
  /**
   * The business identifier for the instance of the adjudication response: claim, predetermination
   * or preauthorization response.
   */
  public val claimResponse: Reference? = null,
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
   * between zero and the submitted amoutn will be paid (partial).
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
  public val preAuthRef: List<String> = listOf(),
  /**
   * The timeframe during which the supplied preauthorization reference may be quoted on claims to
   * obtain the adjudication as provided.
   *
   * This value is only present on preauthorization adjudications.
   */
  public val preAuthRefPeriod: List<Period> = listOf(),
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
  /** The members of the team who provided the products and services. */
  public val careTeam: List<CareTeam> = listOf(),
  /**
   * Additional information codes regarding exceptions, special considerations, the condition,
   * situation, prior or concurrent issues.
   *
   * Often there are multiple jurisdiction specific valuesets which are required.
   */
  public val supportingInfo: List<SupportingInfo> = listOf(),
  /** Information about diagnoses relevant to the claim items. */
  public val diagnosis: List<Diagnosis> = listOf(),
  /** Procedures performed on the patient relevant to the billing items with the claim. */
  public val procedure: List<Procedure> = listOf(),
  /**
   * This indicates the relative order of a series of EOBs related to different coverages for the
   * same suite of services.
   */
  public val precedence: PositiveInt? = null,
  /**
   * Financial instruments for reimbursement for the health care products and services specified on
   * the claim.
   *
   * All insurance coverages for the patient which may be applicable for reimbursement, of the
   * products and services listed in the claim, are typically provided in the claim to allow
   * insurers to confirm the ordering of the insurance coverages relative to local 'coordination of
   * benefit' rules. One coverage (and only one) with 'focal=true' is to be used in the adjudication
   * of this claim. Coverages appearing before the focal Coverage in the list, and where
   * 'Coverage.subrogation=false', should provide a reference to the ClaimResponse containing the
   * adjudication results of the prior claim.
   */
  public val insurance: List<Insurance> = listOf(),
  /**
   * Details of a accident which resulted in injuries which required the products and services
   * listed in the claim.
   */
  public val accident: Accident? = null,
  /**
   * The amount paid by the patient, in total at the claim claim level or specifically for the item
   * and detail level, to the provider for goods and services.
   */
  public val patientPaid: Money? = null,
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
   * The term of the benefits documented in this response.
   *
   * Not applicable when use=claim.
   */
  public val benefitPeriod: Period? = null,
  /** Balance by Benefit Category. */
  public val benefitBalance: List<BenefitBalance> = listOf(),
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
          billablePeriod = this@with.billablePeriod?.toBuilder()
          enterer = this@with.enterer?.toBuilder()
          insurer = this@with.insurer?.toBuilder()
          provider = this@with.provider?.toBuilder()
          priority = this@with.priority?.toBuilder()
          fundsReserveRequested = this@with.fundsReserveRequested?.toBuilder()
          fundsReserve = this@with.fundsReserve?.toBuilder()
          related = this@with.related.map { it.toBuilder() }.toMutableList()
          prescription = this@with.prescription?.toBuilder()
          originalPrescription = this@with.originalPrescription?.toBuilder()
          event = this@with.event.map { it.toBuilder() }.toMutableList()
          payee = this@with.payee?.toBuilder()
          referral = this@with.referral?.toBuilder()
          encounter = this@with.encounter.map { it.toBuilder() }.toMutableList()
          facility = this@with.facility?.toBuilder()
          claim = this@with.claim?.toBuilder()
          claimResponse = this@with.claimResponse?.toBuilder()
          decision = this@with.decision?.toBuilder()
          disposition = this@with.disposition?.toBuilder()
          preAuthRef = this@with.preAuthRef.map { it.toBuilder() }.toMutableList()
          preAuthRefPeriod = this@with.preAuthRefPeriod.map { it.toBuilder() }.toMutableList()
          diagnosisRelatedGroup = this@with.diagnosisRelatedGroup?.toBuilder()
          careTeam = this@with.careTeam.map { it.toBuilder() }.toMutableList()
          supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
          diagnosis = this@with.diagnosis.map { it.toBuilder() }.toMutableList()
          procedure = this@with.procedure.map { it.toBuilder() }.toMutableList()
          precedence = this@with.precedence?.toBuilder()
          insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
          accident = this@with.accident?.toBuilder()
          patientPaid = this@with.patientPaid?.toBuilder()
          item = this@with.item.map { it.toBuilder() }.toMutableList()
          addItem = this@with.addItem.map { it.toBuilder() }.toMutableList()
          adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
          total = this@with.total.map { it.toBuilder() }.toMutableList()
          payment = this@with.payment?.toBuilder()
          formCode = this@with.formCode?.toBuilder()
          form = this@with.form?.toBuilder()
          processNote = this@with.processNote.map { it.toBuilder() }.toMutableList()
          benefitPeriod = this@with.benefitPeriod?.toBuilder()
          benefitBalance = this@with.benefitBalance.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * Other claims which are related to this claim such as prior submissions or claims for related
   * services or for the same event.
   */
  @Serializable(with = ExplanationOfBenefitRelatedSerializer::class)
  public data class Related(
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
    /** Reference to a related claim. */
    public val claim: Reference? = null,
    /**
     * A code to convey how the claims are related.
     *
     * For example, prior claim or umbrella.
     */
    public val relationship: CodeableConcept? = null,
    /**
     * An alternate organizational reference to the case or file to which this particular claim
     * pertains.
     *
     * For example, Property/Casualty insurer claim number or Workers Compensation case number.
     */
    public val reference: Identifier? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          claim = this@with.claim?.toBuilder()
          relationship = this@with.relationship?.toBuilder()
          reference = this@with.reference?.toBuilder()
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

      /** Reference to a related claim. */
      public var claim: Reference.Builder? = null

      /**
       * A code to convey how the claims are related.
       *
       * For example, prior claim or umbrella.
       */
      public var relationship: CodeableConcept.Builder? = null

      /**
       * An alternate organizational reference to the case or file to which this particular claim
       * pertains.
       *
       * For example, Property/Casualty insurer claim number or Workers Compensation case number.
       */
      public var reference: Identifier.Builder? = null

      public fun build(): Related =
        Related(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          claim = claim?.build(),
          relationship = relationship?.build(),
          reference = reference?.build(),
        )
    }
  }

  /** Information code for an event with a corresponding date or period. */
  @Serializable(with = ExplanationOfBenefitEventSerializer::class)
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

    public sealed interface When {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      @JvmInline
      public value class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : When

      @JvmInline public value class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : When

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
   * The party to be reimbursed for cost of the products and services according to the terms of the
   * policy.
   */
  @Serializable(with = ExplanationOfBenefitPayeeSerializer::class)
  public data class Payee(
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
    /** Type of Party to be reimbursed: Subscriber, provider, other. */
    public val type: CodeableConcept? = null,
    /**
     * Reference to the individual or organization to whom any payment will be made.
     *
     * Not required if the payee is 'subscriber' or 'provider'.
     */
    public val party: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          party = this@with.party?.toBuilder()
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

      /** Type of Party to be reimbursed: Subscriber, provider, other. */
      public var type: CodeableConcept.Builder? = null

      /**
       * Reference to the individual or organization to whom any payment will be made.
       *
       * Not required if the payee is 'subscriber' or 'provider'.
       */
      public var party: Reference.Builder? = null

      public fun build(): Payee =
        Payee(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          party = party?.build(),
        )
    }
  }

  /** The members of the team who provided the products and services. */
  @Serializable(with = ExplanationOfBenefitCareTeamSerializer::class)
  public data class CareTeam(
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
    /** A number to uniquely identify care team entries. */
    public val sequence: PositiveInt,
    /** Member of the team who provided the product or service. */
    public val provider: Reference,
    /**
     * The party who is billing and/or responsible for the claimed products or services.
     *
     * Responsible might not be required when there is only a single provider listed.
     */
    public val responsible: Boolean? = null,
    /**
     * The lead, assisting or supervising practitioner and their discipline if a multidisciplinary
     * team.
     *
     * Role might not be required when there is only a single provider listed.
     */
    public val role: CodeableConcept? = null,
    /** The specialization of the practitioner or provider which is applicable for this service. */
    public val specialty: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder(), provider.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          responsible = this@with.responsible?.toBuilder()
          role = this@with.role?.toBuilder()
          specialty = this@with.specialty?.toBuilder()
        }
      }

    public class Builder(
      /** A number to uniquely identify care team entries. */
      public var sequence: PositiveInt.Builder,
      /** Member of the team who provided the product or service. */
      public var provider: Reference.Builder,
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
       * The party who is billing and/or responsible for the claimed products or services.
       *
       * Responsible might not be required when there is only a single provider listed.
       */
      public var responsible: Boolean.Builder? = null

      /**
       * The lead, assisting or supervising practitioner and their discipline if a multidisciplinary
       * team.
       *
       * Role might not be required when there is only a single provider listed.
       */
      public var role: CodeableConcept.Builder? = null

      /**
       * The specialization of the practitioner or provider which is applicable for this service.
       */
      public var specialty: CodeableConcept.Builder? = null

      public fun build(): CareTeam =
        CareTeam(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          provider = provider.build(),
          responsible = responsible?.build(),
          role = role?.build(),
          specialty = specialty?.build(),
        )
    }
  }

  /**
   * Additional information codes regarding exceptions, special considerations, the condition,
   * situation, prior or concurrent issues.
   */
  @Serializable(with = ExplanationOfBenefitSupportingInfoSerializer::class)
  public data class SupportingInfo(
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
    /** A number to uniquely identify supporting information entries. */
    public val sequence: PositiveInt,
    /**
     * The general class of the information supplied: information; exception; accident, employment;
     * onset, etc.
     *
     * This may contain a category for the local bill type codes.
     */
    public val category: CodeableConcept,
    /**
     * System and code pertaining to the specific information regarding special conditions relating
     * to the setting, treatment or patient for which care is sought.
     *
     * This may contain the local bill type codes such as the US UB-04 bill type code.
     */
    public val code: CodeableConcept? = null,
    /** The date when or period to which this information refers. */
    public val timing: Timing? = null,
    /**
     * Additional data or information such as resources, documents, images etc. including references
     * to the data or the actual inclusion of the data.
     *
     * Could be used to provide references to other resources, document. For example, could contain
     * a PDF in an Attachment of the Police Report for an Accident.
     */
    public val `value`: Value? = null,
    /**
     * Provides the reason in the situation where a reason code is required in addition to the
     * content.
     *
     * For example: the reason for the additional stay, or why a tooth is missing.
     */
    public val reason: Coding? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder(), category.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code?.toBuilder()
          timing = this@with.timing
          `value` = this@with.`value`
          reason = this@with.reason?.toBuilder()
        }
      }

    public sealed interface Timing {
      public fun asDate(): Date? = this as? Date

      public fun asPeriod(): Period? = this as? Period

      @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Timing

      @JvmInline
      public value class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Timing

      public companion object {
        internal fun from(
          dateValue: dev.ohs.fhir.model.r5.Date?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
        ): Timing? {
          if (dateValue != null) return Date(dateValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    public sealed interface Value {
      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asString(): String? = this as? String

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asReference(): Reference? = this as? Reference

      public fun asIdentifier(): Identifier? = this as? Identifier

      @JvmInline
      public value class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      @JvmInline
      public value class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

      @JvmInline
      public value class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      @JvmInline
      public value class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      @JvmInline
      public value class Identifier(public val `value`: dev.ohs.fhir.model.r5.Identifier) : Value

      public companion object {
        internal fun from(
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          identifierValue: dev.ohs.fhir.model.r5.Identifier?,
        ): Value? {
          if (booleanValue != null) return Boolean(booleanValue)
          if (stringValue != null) return String(stringValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (identifierValue != null) return Identifier(identifierValue)
          return null
        }
      }
    }

    public class Builder(
      /** A number to uniquely identify supporting information entries. */
      public var sequence: PositiveInt.Builder,
      /**
       * The general class of the information supplied: information; exception; accident,
       * employment; onset, etc.
       *
       * This may contain a category for the local bill type codes.
       */
      public var category: CodeableConcept.Builder,
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
       * System and code pertaining to the specific information regarding special conditions
       * relating to the setting, treatment or patient for which care is sought.
       *
       * This may contain the local bill type codes such as the US UB-04 bill type code.
       */
      public var code: CodeableConcept.Builder? = null

      /** The date when or period to which this information refers. */
      public var timing: Timing? = null

      /**
       * Additional data or information such as resources, documents, images etc. including
       * references to the data or the actual inclusion of the data.
       *
       * Could be used to provide references to other resources, document. For example, could
       * contain a PDF in an Attachment of the Police Report for an Accident.
       */
      public var `value`: Value? = null

      /**
       * Provides the reason in the situation where a reason code is required in addition to the
       * content.
       *
       * For example: the reason for the additional stay, or why a tooth is missing.
       */
      public var reason: Coding.Builder? = null

      public fun build(): SupportingInfo =
        SupportingInfo(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          category = category.build(),
          code = code?.build(),
          timing = timing,
          `value` = `value`,
          reason = reason?.build(),
        )
    }
  }

  /** Information about diagnoses relevant to the claim items. */
  @Serializable(with = ExplanationOfBenefitDiagnosisSerializer::class)
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
    /**
     * A number to uniquely identify diagnosis entries.
     *
     * Diagnosis are presented in list order to their expected importance: primary, secondary, etc.
     */
    public val sequence: PositiveInt,
    /**
     * The nature of illness or problem in a coded form or as a reference to an external defined
     * Condition.
     */
    public val diagnosis: Diagnosis,
    /**
     * When the condition was observed or the relative ranking.
     *
     * For example: admitting, primary, secondary, discharge.
     */
    public val type: List<CodeableConcept> = listOf(),
    /** Indication of whether the diagnosis was present on admission to a facility. */
    public val onAdmission: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder(), diagnosis).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          onAdmission = this@with.onAdmission?.toBuilder()
        }
      }

    public sealed interface Diagnosis {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Diagnosis

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Diagnosis

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Diagnosis? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * A number to uniquely identify diagnosis entries.
       *
       * Diagnosis are presented in list order to their expected importance: primary, secondary,
       * etc.
       */
      public var sequence: PositiveInt.Builder,
      /**
       * The nature of illness or problem in a coded form or as a reference to an external defined
       * Condition.
       */
      public var diagnosis: Diagnosis,
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
       * When the condition was observed or the relative ranking.
       *
       * For example: admitting, primary, secondary, discharge.
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Indication of whether the diagnosis was present on admission to a facility. */
      public var onAdmission: CodeableConcept.Builder? = null

      public fun build(): ExplanationOfBenefit.Diagnosis =
        ExplanationOfBenefit.Diagnosis(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          diagnosis = diagnosis,
          type = type.map { it.build() },
          onAdmission = onAdmission?.build(),
        )
    }
  }

  /** Procedures performed on the patient relevant to the billing items with the claim. */
  @Serializable(with = ExplanationOfBenefitProcedureSerializer::class)
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
    /** A number to uniquely identify procedure entries. */
    public val sequence: PositiveInt,
    /** When the condition was observed or the relative ranking. */
    public val type: List<CodeableConcept> = listOf(),
    /** Date and optionally time the procedure was performed. */
    public val date: DateTime? = null,
    /**
     * The code or reference to a Procedure resource which identifies the clinical intervention
     * performed.
     */
    public val procedure: Procedure,
    /** Unique Device Identifiers associated with this line item. */
    public val udi: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder(), procedure).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          date = this@with.date?.toBuilder()
          udi = this@with.udi.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Procedure {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Procedure

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Procedure

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Procedure? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /** A number to uniquely identify procedure entries. */
      public var sequence: PositiveInt.Builder,
      /**
       * The code or reference to a Procedure resource which identifies the clinical intervention
       * performed.
       */
      public var procedure: Procedure,
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

      /** When the condition was observed or the relative ranking. */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Date and optionally time the procedure was performed. */
      public var date: DateTime.Builder? = null

      /** Unique Device Identifiers associated with this line item. */
      public var udi: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): ExplanationOfBenefit.Procedure =
        ExplanationOfBenefit.Procedure(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          type = type.map { it.build() },
          date = date?.build(),
          procedure = procedure,
          udi = udi.map { it.build() },
        )
    }
  }

  /**
   * Financial instruments for reimbursement for the health care products and services specified on
   * the claim.
   */
  @Serializable(with = ExplanationOfBenefitInsuranceSerializer::class)
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
     * A flag to indicate that this Coverage is to be used for adjudication of this claim when set
     * to true.
     *
     * A patient may (will) have multiple insurance policies which provide reimbursement for
     * healthcare services and products. For example, a person may also be covered by their spouse's
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
     * Reference numbers previously provided by the insurer to the provider to be quoted on
     * subsequent claims containing services or products related to the prior authorization.
     *
     * This value is an alphanumeric string that may be provided over the phone, via text, via
     * paper, or within a ClaimResponse resource and is not a FHIR Identifier.
     */
    public val preAuthRef: List<String> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(focal.toBuilder(), coverage.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          preAuthRef = this@with.preAuthRef.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * A flag to indicate that this Coverage is to be used for adjudication of this claim when set
       * to true.
       *
       * A patient may (will) have multiple insurance policies which provide reimbursement for
       * healthcare services and products. For example, a person may also be covered by their
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
       * Reference numbers previously provided by the insurer to the provider to be quoted on
       * subsequent claims containing services or products related to the prior authorization.
       *
       * This value is an alphanumeric string that may be provided over the phone, via text, via
       * paper, or within a ClaimResponse resource and is not a FHIR Identifier.
       */
      public var preAuthRef: MutableList<String.Builder> = mutableListOf()

      public fun build(): Insurance =
        Insurance(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          focal = focal.build(),
          coverage = coverage.build(),
          preAuthRef = preAuthRef.map { it.build() },
        )
    }
  }

  /**
   * Details of a accident which resulted in injuries which required the products and services
   * listed in the claim.
   */
  @Serializable(with = ExplanationOfBenefitAccidentSerializer::class)
  public data class Accident(
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
     * Date of an accident event related to the products and services contained in the claim.
     *
     * The date of the accident has to precede the dates of the products and services but within a
     * reasonable timeframe.
     */
    public val date: Date? = null,
    /**
     * The type or context of the accident event for the purposes of selection of potential
     * insurance coverages and determination of coordination between insurers.
     */
    public val type: CodeableConcept? = null,
    /** The physical location of the accident event. */
    public val location: Location? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          date = this@with.date?.toBuilder()
          type = this@with.type?.toBuilder()
          location = this@with.location
        }
      }

    public sealed interface Location {
      public fun asAddress(): Address? = this as? Address

      public fun asReference(): Reference? = this as? Reference

      @JvmInline
      public value class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Location

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Location

      public companion object {
        internal fun from(
          addressValue: dev.ohs.fhir.model.r5.Address?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Location? {
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

      /**
       * Date of an accident event related to the products and services contained in the claim.
       *
       * The date of the accident has to precede the dates of the products and services but within a
       * reasonable timeframe.
       */
      public var date: Date.Builder? = null

      /**
       * The type or context of the accident event for the purposes of selection of potential
       * insurance coverages and determination of coordination between insurers.
       */
      public var type: CodeableConcept.Builder? = null

      /** The physical location of the accident event. */
      public var location: Location? = null

      public fun build(): Accident =
        Accident(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          date = date?.build(),
          type = type?.build(),
          location = location,
        )
    }
  }

  /**
   * A claim line. Either a simple (a product or service) or a 'group' of details which can also be
   * a simple items or groups of sub-details.
   */
  @Serializable(with = ExplanationOfBenefitItemSerializer::class)
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
    /** A number to uniquely identify item entries. */
    public val sequence: PositiveInt,
    /** Care team members related to this service or product. */
    public val careTeamSequence: List<PositiveInt> = listOf(),
    /** Diagnoses applicable for this service or product. */
    public val diagnosisSequence: List<PositiveInt> = listOf(),
    /** Procedures applicable for this service or product. */
    public val procedureSequence: List<PositiveInt> = listOf(),
    /**
     * Exceptions, special conditions and supporting information applicable for this service or
     * product.
     */
    public val informationSequence: List<PositiveInt> = listOf(),
    /**
     * Trace number for tracking purposes. May be defined at the jurisdiction level or between
     * trading partners.
     */
    public val traceNumber: List<Identifier> = listOf(),
    /** The type of revenue or cost center providing the product and/or service. */
    public val revenue: CodeableConcept? = null,
    /**
     * Code to identify the general type of benefits under which products and services are provided.
     *
     * Examples include Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
     */
    public val category: CodeableConcept? = null,
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
     * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for Medical
     * whether the treatment was outside the clinic or out of office hours.
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
    /**
     * The amount paid by the patient, in total at the claim claim level or specifically for the
     * item and detail level, to the provider for goods and services.
     */
    public val patientPaid: Money? = null,
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
     * The total amount claimed for the group (if a grouper) or the line item. Net = unit price *
     * quantity * factor.
     *
     * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
     * assumed to be 1 if not supplied.
     */
    public val net: Money? = null,
    /** Unique Device Identifiers associated with this line item. */
    public val udi: List<Reference> = listOf(),
    /** Physical location where the service is performed or applies. */
    public val bodySite: List<BodySite> = listOf(),
    /** Healthcare encounters related to this claim. */
    public val encounter: List<Reference> = listOf(),
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
    /** Second-tier of goods and services. */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          careTeamSequence = this@with.careTeamSequence.map { it.toBuilder() }.toMutableList()
          diagnosisSequence = this@with.diagnosisSequence.map { it.toBuilder() }.toMutableList()
          procedureSequence = this@with.procedureSequence.map { it.toBuilder() }.toMutableList()
          informationSequence = this@with.informationSequence.map { it.toBuilder() }.toMutableList()
          traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
          revenue = this@with.revenue?.toBuilder()
          category = this@with.category?.toBuilder()
          productOrService = this@with.productOrService?.toBuilder()
          productOrServiceEnd = this@with.productOrServiceEnd?.toBuilder()
          request = this@with.request.map { it.toBuilder() }.toMutableList()
          modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
          programCode = this@with.programCode.map { it.toBuilder() }.toMutableList()
          serviced = this@with.serviced
          location = this@with.location
          patientPaid = this@with.patientPaid?.toBuilder()
          quantity = this@with.quantity?.toBuilder()
          unitPrice = this@with.unitPrice?.toBuilder()
          factor = this@with.factor?.toBuilder()
          tax = this@with.tax?.toBuilder()
          net = this@with.net?.toBuilder()
          udi = this@with.udi.map { it.toBuilder() }.toMutableList()
          bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
          encounter = this@with.encounter.map { it.toBuilder() }.toMutableList()
          noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
          reviewOutcome = this@with.reviewOutcome?.toBuilder()
          adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Physical location where the service is performed or applies. */
    @Serializable(with = ExplanationOfBenefitItemBodySiteSerializer::class)
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
       * For example: Providing a tooth code, allows an insurer to identify a provider performing a
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
         * For example: Providing a tooth code, allows an insurer to identify a provider performing
         * a filling on a tooth that was previously removed.
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

    /** The high-level results of the adjudication if adjudication has been performed. */
    @Serializable(with = ExplanationOfBenefitItemReviewOutcomeSerializer::class)
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
    @Serializable(with = ExplanationOfBenefitItemAdjudicationSerializer::class)
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
       * include: the value submitted, maximum values or percentages allowed or payable under the
       * plan, amounts that the patient is responsible for in-aggregate or pertaining to this item,
       * amounts paid by other coverages, and the benefit payable for this item.
       *
       * For example, codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
       */
      public val category: CodeableConcept,
      /**
       * A code supporting the understanding of the adjudication result and explaining variance from
       * expected amount.
       *
       * For example, may indicate that the funds for this benefit type have been exhausted.
       */
      public val reason: CodeableConcept? = null,
      /**
       * Monetary amount associated with the category.
       *
       * For example, amount submitted, eligible amount, co-payment, and benefit payable.
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
         * may include: the value submitted, maximum values or percentages allowed or payable under
         * the plan, amounts that the patient is responsible for in-aggregate or pertaining to this
         * item, amounts paid by other coverages, and the benefit payable for this item.
         *
         * For example, codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
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
         * For example, may indicate that the funds for this benefit type have been exhausted.
         */
        public var reason: CodeableConcept.Builder? = null

        /**
         * Monetary amount associated with the category.
         *
         * For example, amount submitted, eligible amount, co-payment, and benefit payable.
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

    /** Second-tier of goods and services. */
    @Serializable(with = ExplanationOfBenefitItemDetailSerializer::class)
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
       * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
       * which are simple items.
       */
      public val sequence: PositiveInt,
      /**
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public val traceNumber: List<Identifier> = listOf(),
      /** The type of revenue or cost center providing the product and/or service. */
      public val revenue: CodeableConcept? = null,
      /**
       * Code to identify the general type of benefits under which products and services are
       * provided.
       *
       * Examples include: Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
       */
      public val category: CodeableConcept? = null,
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
       * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
       * Medical whether the treatment was outside the clinic or out of office hours.
       */
      public val modifier: List<CodeableConcept> = listOf(),
      /**
       * Identifies the program under which this may be recovered.
       *
       * For example: Neonatal program, child dental program or drug users recovery program.
       */
      public val programCode: List<CodeableConcept> = listOf(),
      /**
       * The amount paid by the patient, in total at the claim claim level or specifically for the
       * item and detail level, to the provider for goods and services.
       */
      public val patientPaid: Money? = null,
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
       * The total amount claimed for the group (if a grouper) or the line item.detail. Net = unit
       * price * quantity * factor.
       *
       * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
       * assumed to be 1 if not supplied.
       */
      public val net: Money? = null,
      /** Unique Device Identifiers associated with this line item. */
      public val udi: List<Reference> = listOf(),
      /** The numbers associated with notes below which apply to the adjudication of this item. */
      public val noteNumber: List<PositiveInt> = listOf(),
      /** The high-level results of the adjudication if adjudication has been performed. */
      public val reviewOutcome: ReviewOutcome? = null,
      /** The adjudication results. */
      public val adjudication: List<Adjudication> = listOf(),
      /** Third-tier of goods and services. */
      public val subDetail: List<SubDetail> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(sequence.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
            revenue = this@with.revenue?.toBuilder()
            category = this@with.category?.toBuilder()
            productOrService = this@with.productOrService?.toBuilder()
            productOrServiceEnd = this@with.productOrServiceEnd?.toBuilder()
            modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
            programCode = this@with.programCode.map { it.toBuilder() }.toMutableList()
            patientPaid = this@with.patientPaid?.toBuilder()
            quantity = this@with.quantity?.toBuilder()
            unitPrice = this@with.unitPrice?.toBuilder()
            factor = this@with.factor?.toBuilder()
            tax = this@with.tax?.toBuilder()
            net = this@with.net?.toBuilder()
            udi = this@with.udi.map { it.toBuilder() }.toMutableList()
            noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
            reviewOutcome = this@with.reviewOutcome?.toBuilder()
            adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
            subDetail = this@with.subDetail.map { it.toBuilder() }.toMutableList()
          }
        }

      /** Third-tier of goods and services. */
      @Serializable(with = ExplanationOfBenefitItemDetailSubDetailSerializer::class)
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
         * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
         * which are simple items.
         */
        public val sequence: PositiveInt,
        /**
         * Trace number for tracking purposes. May be defined at the jurisdiction level or between
         * trading partners.
         */
        public val traceNumber: List<Identifier> = listOf(),
        /** The type of revenue or cost center providing the product and/or service. */
        public val revenue: CodeableConcept? = null,
        /**
         * Code to identify the general type of benefits under which products and services are
         * provided.
         *
         * Examples include Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
         */
        public val category: CodeableConcept? = null,
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
         * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
         * Medical whether the treatment was outside the clinic or outside of office hours.
         */
        public val modifier: List<CodeableConcept> = listOf(),
        /**
         * Identifies the program under which this may be recovered.
         *
         * For example: Neonatal program, child dental program or drug users recovery program.
         */
        public val programCode: List<CodeableConcept> = listOf(),
        /**
         * The amount paid by the patient, in total at the claim claim level or specifically for the
         * item and detail level, to the provider for goods and services.
         */
        public val patientPaid: Money? = null,
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
         * The total amount claimed for the line item.detail.subDetail. Net = unit price *
         * quantity * factor.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public val net: Money? = null,
        /** Unique Device Identifiers associated with this line item. */
        public val udi: List<Reference> = listOf(),
        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public val noteNumber: List<PositiveInt> = listOf(),
        /** The high-level results of the adjudication if adjudication has been performed. */
        public val reviewOutcome: ReviewOutcome? = null,
        /** The adjudication results. */
        public val adjudication: List<Adjudication> = listOf(),
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(sequence.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
              revenue = this@with.revenue?.toBuilder()
              category = this@with.category?.toBuilder()
              productOrService = this@with.productOrService?.toBuilder()
              productOrServiceEnd = this@with.productOrServiceEnd?.toBuilder()
              modifier = this@with.modifier.map { it.toBuilder() }.toMutableList()
              programCode = this@with.programCode.map { it.toBuilder() }.toMutableList()
              patientPaid = this@with.patientPaid?.toBuilder()
              quantity = this@with.quantity?.toBuilder()
              unitPrice = this@with.unitPrice?.toBuilder()
              factor = this@with.factor?.toBuilder()
              tax = this@with.tax?.toBuilder()
              net = this@with.net?.toBuilder()
              udi = this@with.udi.map { it.toBuilder() }.toMutableList()
              noteNumber = this@with.noteNumber.map { it.toBuilder() }.toMutableList()
              reviewOutcome = this@with.reviewOutcome?.toBuilder()
              adjudication = this@with.adjudication.map { it.toBuilder() }.toMutableList()
            }
          }

        public class Builder(
          /**
           * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
           * which are simple items.
           */
          public var sequence: PositiveInt.Builder
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

          /** The type of revenue or cost center providing the product and/or service. */
          public var revenue: CodeableConcept.Builder? = null

          /**
           * Code to identify the general type of benefits under which products and services are
           * provided.
           *
           * Examples include Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
           */
          public var category: CodeableConcept.Builder? = null

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
           * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
           * Medical whether the treatment was outside the clinic or outside of office hours.
           */
          public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

          /**
           * Identifies the program under which this may be recovered.
           *
           * For example: Neonatal program, child dental program or drug users recovery program.
           */
          public var programCode: MutableList<CodeableConcept.Builder> = mutableListOf()

          /**
           * The amount paid by the patient, in total at the claim claim level or specifically for
           * the item and detail level, to the provider for goods and services.
           */
          public var patientPaid: Money.Builder? = null

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
           * The total amount claimed for the line item.detail.subDetail. Net = unit price *
           * quantity * factor.
           *
           * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
           * assumed to be 1 if not supplied.
           */
          public var net: Money.Builder? = null

          /** Unique Device Identifiers associated with this line item. */
          public var udi: MutableList<Reference.Builder> = mutableListOf()

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
              sequence = sequence.build(),
              traceNumber = traceNumber.map { it.build() },
              revenue = revenue?.build(),
              category = category?.build(),
              productOrService = productOrService?.build(),
              productOrServiceEnd = productOrServiceEnd?.build(),
              modifier = modifier.map { it.build() },
              programCode = programCode.map { it.build() },
              patientPaid = patientPaid?.build(),
              quantity = quantity?.build(),
              unitPrice = unitPrice?.build(),
              factor = factor?.build(),
              tax = tax?.build(),
              net = net?.build(),
              udi = udi.map { it.build() },
              noteNumber = noteNumber.map { it.build() },
              reviewOutcome = reviewOutcome?.build(),
              adjudication = adjudication.map { it.build() },
            )
        }
      }

      public class Builder(
        /**
         * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
         * which are simple items.
         */
        public var sequence: PositiveInt.Builder
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

        /** The type of revenue or cost center providing the product and/or service. */
        public var revenue: CodeableConcept.Builder? = null

        /**
         * Code to identify the general type of benefits under which products and services are
         * provided.
         *
         * Examples include: Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
         */
        public var category: CodeableConcept.Builder? = null

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
         * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
         * Medical whether the treatment was outside the clinic or out of office hours.
         */
        public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Identifies the program under which this may be recovered.
         *
         * For example: Neonatal program, child dental program or drug users recovery program.
         */
        public var programCode: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * The amount paid by the patient, in total at the claim claim level or specifically for the
         * item and detail level, to the provider for goods and services.
         */
        public var patientPaid: Money.Builder? = null

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
         * The total amount claimed for the group (if a grouper) or the line item.detail. Net = unit
         * price * quantity * factor.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public var net: Money.Builder? = null

        /** Unique Device Identifiers associated with this line item. */
        public var udi: MutableList<Reference.Builder> = mutableListOf()

        /** The numbers associated with notes below which apply to the adjudication of this item. */
        public var noteNumber: MutableList<PositiveInt.Builder> = mutableListOf()

        /** The high-level results of the adjudication if adjudication has been performed. */
        public var reviewOutcome: ReviewOutcome.Builder? = null

        /** The adjudication results. */
        public var adjudication: MutableList<Adjudication.Builder> = mutableListOf()

        /** Third-tier of goods and services. */
        public var subDetail: MutableList<SubDetail.Builder> = mutableListOf()

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            sequence = sequence.build(),
            traceNumber = traceNumber.map { it.build() },
            revenue = revenue?.build(),
            category = category?.build(),
            productOrService = productOrService?.build(),
            productOrServiceEnd = productOrServiceEnd?.build(),
            modifier = modifier.map { it.build() },
            programCode = programCode.map { it.build() },
            patientPaid = patientPaid?.build(),
            quantity = quantity?.build(),
            unitPrice = unitPrice?.build(),
            factor = factor?.build(),
            tax = tax?.build(),
            net = net?.build(),
            udi = udi.map { it.build() },
            noteNumber = noteNumber.map { it.build() },
            reviewOutcome = reviewOutcome?.build(),
            adjudication = adjudication.map { it.build() },
            subDetail = subDetail.map { it.build() },
          )
      }
    }

    public sealed interface Serviced {
      public fun asDate(): Date? = this as? Date

      public fun asPeriod(): Period? = this as? Period

      @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Serviced

      @JvmInline
      public value class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Serviced

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

    public sealed interface Location {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asAddress(): Address? = this as? Address

      public fun asReference(): Reference? = this as? Reference

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Location

      @JvmInline
      public value class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Location

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Location

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

    public class Builder(
      /** A number to uniquely identify item entries. */
      public var sequence: PositiveInt.Builder
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

      /** Care team members related to this service or product. */
      public var careTeamSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /** Diagnoses applicable for this service or product. */
      public var diagnosisSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /** Procedures applicable for this service or product. */
      public var procedureSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /**
       * Exceptions, special conditions and supporting information applicable for this service or
       * product.
       */
      public var informationSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /**
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

      /** The type of revenue or cost center providing the product and/or service. */
      public var revenue: CodeableConcept.Builder? = null

      /**
       * Code to identify the general type of benefits under which products and services are
       * provided.
       *
       * Examples include Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
       */
      public var category: CodeableConcept.Builder? = null

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
       * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
       * Medical whether the treatment was outside the clinic or out of office hours.
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

      /**
       * The amount paid by the patient, in total at the claim claim level or specifically for the
       * item and detail level, to the provider for goods and services.
       */
      public var patientPaid: Money.Builder? = null

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
       * The total amount claimed for the group (if a grouper) or the line item. Net = unit price *
       * quantity * factor.
       *
       * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
       * assumed to be 1 if not supplied.
       */
      public var net: Money.Builder? = null

      /** Unique Device Identifiers associated with this line item. */
      public var udi: MutableList<Reference.Builder> = mutableListOf()

      /** Physical location where the service is performed or applies. */
      public var bodySite: MutableList<BodySite.Builder> = mutableListOf()

      /** Healthcare encounters related to this claim. */
      public var encounter: MutableList<Reference.Builder> = mutableListOf()

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

      /** Second-tier of goods and services. */
      public var detail: MutableList<Detail.Builder> = mutableListOf()

      public fun build(): Item =
        Item(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          careTeamSequence = careTeamSequence.map { it.build() },
          diagnosisSequence = diagnosisSequence.map { it.build() },
          procedureSequence = procedureSequence.map { it.build() },
          informationSequence = informationSequence.map { it.build() },
          traceNumber = traceNumber.map { it.build() },
          revenue = revenue?.build(),
          category = category?.build(),
          productOrService = productOrService?.build(),
          productOrServiceEnd = productOrServiceEnd?.build(),
          request = request.map { it.build() },
          modifier = modifier.map { it.build() },
          programCode = programCode.map { it.build() },
          serviced = serviced,
          location = location,
          patientPaid = patientPaid?.build(),
          quantity = quantity?.build(),
          unitPrice = unitPrice?.build(),
          factor = factor?.build(),
          tax = tax?.build(),
          net = net?.build(),
          udi = udi.map { it.build() },
          bodySite = bodySite.map { it.build() },
          encounter = encounter.map { it.build() },
          noteNumber = noteNumber.map { it.build() },
          reviewOutcome = reviewOutcome?.build(),
          adjudication = adjudication.map { it.build() },
          detail = detail.map { it.build() },
        )
    }
  }

  /** The first-tier service adjudications for payor added product or service lines. */
  @Serializable(with = ExplanationOfBenefitAddItemSerializer::class)
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
     * The sequence number of the sub-details woithin the details within the claim item which this
     * line is intended to replace.
     */
    public val subDetailSequence: List<PositiveInt> = listOf(),
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
     * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for Medical
     * whether the treatment was outside the clinic or out of office hours.
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
    /**
     * The amount paid by the patient, in total at the claim claim level or specifically for the
     * item and detail level, to the provider for goods and services.
     */
    public val patientPaid: Money? = null,
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
          subDetailSequence = this@with.subDetailSequence.map { it.toBuilder() }.toMutableList()
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
          patientPaid = this@with.patientPaid?.toBuilder()
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
    @Serializable(with = ExplanationOfBenefitAddItemBodySiteSerializer::class)
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
       * For example, providing a tooth code allows an insurer to identify a provider performing a
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
         * For example, providing a tooth code allows an insurer to identify a provider performing a
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
    @Serializable(with = ExplanationOfBenefitAddItemDetailSerializer::class)
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
       * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
       * Medical whether the treatment was outside the clinic or out of office hours.
       */
      public val modifier: List<CodeableConcept> = listOf(),
      /**
       * The amount paid by the patient, in total at the claim claim level or specifically for the
       * item and detail level, to the provider for goods and services.
       */
      public val patientPaid: Money? = null,
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
            patientPaid = this@with.patientPaid?.toBuilder()
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
      @Serializable(with = ExplanationOfBenefitAddItemDetailSubDetailSerializer::class)
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
         * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
         * Medical whether the treatment was outside the clinic or out of office hours.
         */
        public val modifier: List<CodeableConcept> = listOf(),
        /**
         * The amount paid by the patient, in total at the claim claim level or specifically for the
         * item and detail level, to the provider for goods and services.
         */
        public val patientPaid: Money? = null,
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
              patientPaid = this@with.patientPaid?.toBuilder()
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
           * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
           * Medical whether the treatment was outside the clinic or out of office hours.
           */
          public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

          /**
           * The amount paid by the patient, in total at the claim claim level or specifically for
           * the item and detail level, to the provider for goods and services.
           */
          public var patientPaid: Money.Builder? = null

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
              patientPaid = patientPaid?.build(),
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
         * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
         * Medical whether the treatment was outside the clinic or out of office hours.
         */
        public var modifier: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * The amount paid by the patient, in total at the claim claim level or specifically for the
         * item and detail level, to the provider for goods and services.
         */
        public var patientPaid: Money.Builder? = null

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
            patientPaid = patientPaid?.build(),
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

    public sealed interface Serviced {
      public fun asDate(): Date? = this as? Date

      public fun asPeriod(): Period? = this as? Period

      @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Serviced

      @JvmInline
      public value class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Serviced

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

    public sealed interface Location {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asAddress(): Address? = this as? Address

      public fun asReference(): Reference? = this as? Reference

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Location

      @JvmInline
      public value class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Location

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Location

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
       * The sequence number of the sub-details woithin the details within the claim item which this
       * line is intended to replace.
       */
      public var subDetailSequence: MutableList<PositiveInt.Builder> = mutableListOf()

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
       * For example, in Oral whether the treatment is cosmetic or associated with TMJ, or for
       * Medical whether the treatment was outside the clinic or out of office hours.
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

      /**
       * The amount paid by the patient, in total at the claim claim level or specifically for the
       * item and detail level, to the provider for goods and services.
       */
      public var patientPaid: Money.Builder? = null

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
          subDetailSequence = subDetailSequence.map { it.build() },
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
          patientPaid = patientPaid?.build(),
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
  @Serializable(with = ExplanationOfBenefitTotalSerializer::class)
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
     * For example, codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
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
       * For example, codes indicating: Co-Pay, deductible, eligible, benefit, tax, etc.
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
  @Serializable(with = ExplanationOfBenefitPaymentSerializer::class)
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
    public val type: CodeableConcept? = null,
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
    public val amount: Money? = null,
    /**
     * Issuer's unique identifier for the payment instrument.
     *
     * For example: EFT number or check number.
     */
    public val identifier: Identifier? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          adjustment = this@with.adjustment?.toBuilder()
          adjustmentReason = this@with.adjustmentReason?.toBuilder()
          date = this@with.date?.toBuilder()
          amount = this@with.amount?.toBuilder()
          identifier = this@with.identifier?.toBuilder()
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

      /** Whether this represents partial or complete payment of the benefits payable. */
      public var type: CodeableConcept.Builder? = null

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

      /** Benefits payable less any payment adjustment. */
      public var amount: Money.Builder? = null

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
          type = type?.build(),
          adjustment = adjustment?.build(),
          adjustmentReason = adjustmentReason?.build(),
          date = date?.build(),
          amount = amount?.build(),
          identifier = identifier?.build(),
        )
    }
  }

  /** A note that describes or explains adjudication results in a human readable form. */
  @Serializable(with = ExplanationOfBenefitProcessNoteSerializer::class)
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
    public val text: String? = null,
    /**
     * A code to define the language used in the text of the note.
     *
     * Only required if the language is different from the resource language.
     */
    public val language: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          number = this@with.number?.toBuilder()
          type = this@with.type?.toBuilder()
          text = this@with.text?.toBuilder()
          language = this@with.language?.toBuilder()
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

      /** A number to uniquely identify a note entry. */
      public var number: PositiveInt.Builder? = null

      /** The business purpose of the note text. */
      public var type: CodeableConcept.Builder? = null

      /** The explanation or description associated with the processing. */
      public var text: String.Builder? = null

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
          text = text?.build(),
          language = language?.build(),
        )
    }
  }

  /** Balance by Benefit Category. */
  @Serializable(with = ExplanationOfBenefitBenefitBalanceSerializer::class)
  public data class BenefitBalance(
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
     * Code to identify the general type of benefits under which products and services are provided.
     *
     * Examples include Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
     */
    public val category: CodeableConcept,
    /**
     * True if the indicated class of service is excluded from the plan, missing or False indicates
     * the product or service is included in the coverage.
     */
    public val excluded: Boolean? = null,
    /**
     * A short name or tag for the benefit.
     *
     * For example: MED01, or DENT2.
     */
    public val name: String? = null,
    /**
     * A richer description of the benefit or services covered.
     *
     * For example, 'DENT2 covers 100% of basic, 50% of major but excludes Ortho, Implants and
     * Cosmetic services'.
     */
    public val description: String? = null,
    /**
     * Is a flag to indicate whether the benefits refer to in-network providers or out-of-network
     * providers.
     */
    public val network: CodeableConcept? = null,
    /** Indicates if the benefits apply to an individual or to the family. */
    public val unit: CodeableConcept? = null,
    /**
     * The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual
     * visits'.
     */
    public val term: CodeableConcept? = null,
    /** Benefits Used to date. */
    public val financial: List<Financial> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(category.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          excluded = this@with.excluded?.toBuilder()
          name = this@with.name?.toBuilder()
          description = this@with.description?.toBuilder()
          network = this@with.network?.toBuilder()
          unit = this@with.unit?.toBuilder()
          term = this@with.term?.toBuilder()
          financial = this@with.financial.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Benefits Used to date. */
    @Serializable(with = ExplanationOfBenefitBenefitBalanceFinancialSerializer::class)
    public data class Financial(
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
       * Classification of benefit being provided.
       *
       * For example: deductible, visits, benefit amount.
       */
      public val type: CodeableConcept,
      /** The quantity of the benefit which is permitted under the coverage. */
      public val allowed: Allowed? = null,
      /** The quantity of the benefit which have been consumed to date. */
      public val used: Used? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            allowed = this@with.allowed
            used = this@with.used
          }
        }

      public sealed interface Allowed {
        public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

        public fun asString(): String? = this as? String

        public fun asMoney(): Money? = this as? Money

        @JvmInline
        public value class UnsignedInt(public val `value`: dev.ohs.fhir.model.r5.UnsignedInt) :
          Allowed

        @JvmInline
        public value class String(public val `value`: dev.ohs.fhir.model.r5.String) : Allowed

        @JvmInline
        public value class Money(public val `value`: dev.ohs.fhir.model.r5.Money) : Allowed

        public companion object {
          internal fun from(
            unsignedIntValue: dev.ohs.fhir.model.r5.UnsignedInt?,
            stringValue: dev.ohs.fhir.model.r5.String?,
            moneyValue: dev.ohs.fhir.model.r5.Money?,
          ): Allowed? {
            if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
            if (stringValue != null) return String(stringValue)
            if (moneyValue != null) return Money(moneyValue)
            return null
          }
        }
      }

      public sealed interface Used {
        public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

        public fun asMoney(): Money? = this as? Money

        @JvmInline
        public value class UnsignedInt(public val `value`: dev.ohs.fhir.model.r5.UnsignedInt) :
          Used

        @JvmInline public value class Money(public val `value`: dev.ohs.fhir.model.r5.Money) : Used

        public companion object {
          internal fun from(
            unsignedIntValue: dev.ohs.fhir.model.r5.UnsignedInt?,
            moneyValue: dev.ohs.fhir.model.r5.Money?,
          ): Used? {
            if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
            if (moneyValue != null) return Money(moneyValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * Classification of benefit being provided.
         *
         * For example: deductible, visits, benefit amount.
         */
        public var type: CodeableConcept.Builder
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

        /** The quantity of the benefit which is permitted under the coverage. */
        public var allowed: Allowed? = null

        /** The quantity of the benefit which have been consumed to date. */
        public var used: Used? = null

        public fun build(): Financial =
          Financial(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.build(),
            allowed = allowed,
            used = used,
          )
      }
    }

    public class Builder(
      /**
       * Code to identify the general type of benefits under which products and services are
       * provided.
       *
       * Examples include Medical Care, Periodontics, Renal Dialysis, Vision Coverage.
       */
      public var category: CodeableConcept.Builder
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
       * True if the indicated class of service is excluded from the plan, missing or False
       * indicates the product or service is included in the coverage.
       */
      public var excluded: Boolean.Builder? = null

      /**
       * A short name or tag for the benefit.
       *
       * For example: MED01, or DENT2.
       */
      public var name: String.Builder? = null

      /**
       * A richer description of the benefit or services covered.
       *
       * For example, 'DENT2 covers 100% of basic, 50% of major but excludes Ortho, Implants and
       * Cosmetic services'.
       */
      public var description: String.Builder? = null

      /**
       * Is a flag to indicate whether the benefits refer to in-network providers or out-of-network
       * providers.
       */
      public var network: CodeableConcept.Builder? = null

      /** Indicates if the benefits apply to an individual or to the family. */
      public var unit: CodeableConcept.Builder? = null

      /**
       * The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual
       * visits'.
       */
      public var term: CodeableConcept.Builder? = null

      /** Benefits Used to date. */
      public var financial: MutableList<Financial.Builder> = mutableListOf()

      public fun build(): BenefitBalance =
        BenefitBalance(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category.build(),
          excluded = excluded?.build(),
          name = name?.build(),
          description = description?.build(),
          network = network?.build(),
          unit = unit?.build(),
          term = term?.build(),
          financial = financial.map { it.build() },
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
    public var status: Enumeration<ExplanationOfBenefitStatus>,
    /**
     * The category of claim, e.g. oral, pharmacy, vision, institutional, professional.
     *
     * The majority of jurisdictions use: oral, pharmacy, vision, professional and institutional, or
     * variants on those terms, as the general styles of claims. The valueset is extensible to
     * accommodate other jurisdictional requirements.
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
     * considered and for whom actual for forecast reimbursement is sought.
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

    /** A unique identifier assigned to this explanation of benefit. */
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
     * This may contain the local bill type codes such as the US UB-04 bill type code.
     */
    public var subType: CodeableConcept.Builder? = null

    /**
     * The period for which charges are being submitted.
     *
     * Typically this would be today or in the past for a claim, and today or in the future for
     * preauthorizations and prodeterminations. Typically line item dates of service should fall
     * within the billing period if one is specified.
     */
    public var billablePeriod: Period.Builder? = null

    /** Individual who created the claim, predetermination or preauthorization. */
    public var enterer: Reference.Builder? = null

    /** The party responsible for authorization, adjudication and reimbursement. */
    public var insurer: Reference.Builder? = null

    /**
     * The provider which is responsible for the claim, predetermination or preauthorization.
     *
     * Typically this field would be 1..1 where this party is accountable for the data content
     * within the claim but is not necessarily the facility, provider group or practitioner who
     * provided the products and services listed within this claim resource. This field is the
     * Billing Provider, for example, a facility, provider group, lab or practitioner.
     */
    public var provider: Reference.Builder? = null

    /**
     * The provider-required urgency of processing the request. Typical values include: stat, normal
     * deferred.
     *
     * If a claim processor is unable to complete the processing as per the priority then they
     * should generate an error and not process the request.
     */
    public var priority: CodeableConcept.Builder? = null

    /**
     * A code to indicate whether and for whom funds are to be reserved for future claims.
     *
     * This field is only used for preauthorizations.
     */
    public var fundsReserveRequested: CodeableConcept.Builder? = null

    /**
     * A code, used only on a response to a preauthorization, to indicate whether the benefits
     * payable have been reserved and for whom.
     *
     * Fund would be release by a future claim quoting the preAuthRef of this response. Examples of
     * values include: provider, patient, none.
     */
    public var fundsReserve: CodeableConcept.Builder? = null

    /**
     * Other claims which are related to this claim such as prior submissions or claims for related
     * services or for the same event.
     *
     * For example, for the original treatment and follow-up exams.
     */
    public var related: MutableList<Related.Builder> = mutableListOf()

    /**
     * Prescription is the document/authorization given to the claim author for them to provide
     * products and services for which consideration (reimbursement) is sought. Could be a RX for
     * medications, an 'order' for oxygen or wheelchair or physiotherapy treatments.
     */
    public var prescription: Reference.Builder? = null

    /**
     * Original prescription which has been superseded by this prescription to support the
     * dispensing of pharmacy services, medications or products.
     *
     * For example, a physician may prescribe a medication which the pharmacy determines is
     * contraindicated, or for which the patient has an intolerance, and therefor issues a new
     * prescription for an alternate medication which has the same therapeutic intent. The
     * prescription from the pharmacy becomes the 'prescription' and that from the physician becomes
     * the 'original prescription'.
     */
    public var originalPrescription: Reference.Builder? = null

    /** Information code for an event with a corresponding date or period. */
    public var event: MutableList<Event.Builder> = mutableListOf()

    /**
     * The party to be reimbursed for cost of the products and services according to the terms of
     * the policy.
     *
     * Often providers agree to receive the benefits payable to reduce the near-term costs to the
     * patient. The insurer may decline to pay the provider and may choose to pay the subscriber
     * instead.
     */
    public var payee: Payee.Builder? = null

    /**
     * The referral information received by the claim author, it is not to be used when the author
     * generates a referral for a patient. A copy of that referral may be provided as supporting
     * information. Some insurers require proof of referral to pay for services or to pay specialist
     * rates for services.
     *
     * The referral resource which lists the date, practitioner, reason and other supporting
     * information.
     */
    public var referral: Reference.Builder? = null

    /** Healthcare encounters related to this claim. */
    public var encounter: MutableList<Reference.Builder> = mutableListOf()

    /** Facility where the services were provided. */
    public var facility: Reference.Builder? = null

    /**
     * The business identifier for the instance of the adjudication request: claim predetermination
     * or preauthorization.
     */
    public var claim: Reference.Builder? = null

    /**
     * The business identifier for the instance of the adjudication response: claim,
     * predetermination or preauthorization response.
     */
    public var claimResponse: Reference.Builder? = null

    /**
     * The result of the claim, predetermination, or preauthorization adjudication.
     *
     * The element is used to indicate the current state of the adjudication overall for the claim
     * resource, for example: the request has been held (pended) for adjudication processing, for
     * manual review or other reasons; that it has been processed and will be paid, or the
     * outstanding paid, as submitted (approved); that no amount will be paid (denied); or that some
     * amount between zero and the submitted amoutn will be paid (partial).
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
    public var preAuthRef: MutableList<String.Builder> = mutableListOf()

    /**
     * The timeframe during which the supplied preauthorization reference may be quoted on claims to
     * obtain the adjudication as provided.
     *
     * This value is only present on preauthorization adjudications.
     */
    public var preAuthRefPeriod: MutableList<Period.Builder> = mutableListOf()

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

    /** The members of the team who provided the products and services. */
    public var careTeam: MutableList<CareTeam.Builder> = mutableListOf()

    /**
     * Additional information codes regarding exceptions, special considerations, the condition,
     * situation, prior or concurrent issues.
     *
     * Often there are multiple jurisdiction specific valuesets which are required.
     */
    public var supportingInfo: MutableList<SupportingInfo.Builder> = mutableListOf()

    /** Information about diagnoses relevant to the claim items. */
    public var diagnosis: MutableList<Diagnosis.Builder> = mutableListOf()

    /** Procedures performed on the patient relevant to the billing items with the claim. */
    public var procedure: MutableList<Procedure.Builder> = mutableListOf()

    /**
     * This indicates the relative order of a series of EOBs related to different coverages for the
     * same suite of services.
     */
    public var precedence: PositiveInt.Builder? = null

    /**
     * Financial instruments for reimbursement for the health care products and services specified
     * on the claim.
     *
     * All insurance coverages for the patient which may be applicable for reimbursement, of the
     * products and services listed in the claim, are typically provided in the claim to allow
     * insurers to confirm the ordering of the insurance coverages relative to local 'coordination
     * of benefit' rules. One coverage (and only one) with 'focal=true' is to be used in the
     * adjudication of this claim. Coverages appearing before the focal Coverage in the list, and
     * where 'Coverage.subrogation=false', should provide a reference to the ClaimResponse
     * containing the adjudication results of the prior claim.
     */
    public var insurance: MutableList<Insurance.Builder> = mutableListOf()

    /**
     * Details of a accident which resulted in injuries which required the products and services
     * listed in the claim.
     */
    public var accident: Accident.Builder? = null

    /**
     * The amount paid by the patient, in total at the claim claim level or specifically for the
     * item and detail level, to the provider for goods and services.
     */
    public var patientPaid: Money.Builder? = null

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
     * The term of the benefits documented in this response.
     *
     * Not applicable when use=claim.
     */
    public var benefitPeriod: Period.Builder? = null

    /** Balance by Benefit Category. */
    public var benefitBalance: MutableList<BenefitBalance.Builder> = mutableListOf()

    override fun build(): ExplanationOfBenefit =
      ExplanationOfBenefit(
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
        billablePeriod = billablePeriod?.build(),
        created = created.build(),
        enterer = enterer?.build(),
        insurer = insurer?.build(),
        provider = provider?.build(),
        priority = priority?.build(),
        fundsReserveRequested = fundsReserveRequested?.build(),
        fundsReserve = fundsReserve?.build(),
        related = related.map { it.build() },
        prescription = prescription?.build(),
        originalPrescription = originalPrescription?.build(),
        event = event.map { it.build() },
        payee = payee?.build(),
        referral = referral?.build(),
        encounter = encounter.map { it.build() },
        facility = facility?.build(),
        claim = claim?.build(),
        claimResponse = claimResponse?.build(),
        outcome = outcome,
        decision = decision?.build(),
        disposition = disposition?.build(),
        preAuthRef = preAuthRef.map { it.build() },
        preAuthRefPeriod = preAuthRefPeriod.map { it.build() },
        diagnosisRelatedGroup = diagnosisRelatedGroup?.build(),
        careTeam = careTeam.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        diagnosis = diagnosis.map { it.build() },
        procedure = procedure.map { it.build() },
        precedence = precedence?.build(),
        insurance = insurance.map { it.build() },
        accident = accident?.build(),
        patientPaid = patientPaid?.build(),
        item = item.map { it.build() },
        addItem = addItem.map { it.build() },
        adjudication = adjudication.map { it.build() },
        total = total.map { it.build() },
        payment = payment?.build(),
        formCode = formCode?.build(),
        form = form?.build(),
        processNote = processNote.map { it.build() },
        benefitPeriod = benefitPeriod?.build(),
        benefitBalance = benefitBalance.map { it.build() },
      )
  }

  /** A code specifying the state of the resource instance. */
  public enum class ExplanationOfBenefitStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/explanationofbenefit-status", "Active"),
    Cancelled("cancelled", "http://hl7.org/fhir/explanationofbenefit-status", "Cancelled"),
    Draft("draft", "http://hl7.org/fhir/explanationofbenefit-status", "Draft"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/explanationofbenefit-status",
      "Entered In Error",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ExplanationOfBenefitStatus =
        when (code) {
          "active" -> Active
          "cancelled" -> Cancelled
          "draft" -> Draft
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ExplanationOfBenefitStatus")
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
