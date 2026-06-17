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

import dev.ohs.fhir.model.r5.serializers.ClaimAccidentSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimCareTeamSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimDiagnosisSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimEventSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimInsuranceSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimItemBodySiteSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimItemDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimItemDetailSubDetailSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimItemSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimPayeeSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimProcedureSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimRelatedSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimSerializer
import dev.ohs.fhir.model.r5.serializers.ClaimSupportingInfoSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A provider issued list of professional services and products which have been provided, or are to
 * be provided, to a patient which is sent to an insurer for reimbursement.
 */
@Serializable(with = ClaimSerializer::class)
@SerialName("Claim")
public data class Claim(
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
  /** A unique identifier assigned to this claim. */
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
   * The category of claim, e.g. oral, pharmacy, vision, institutional, professional.
   *
   * The code system provides oral, pharmacy, vision, professional and institutional claim types.
   * Those supported depends on the requirements of the jurisdiction. The valueset is extensible to
   * accommodate other types of claims as required by the jurisdiction.
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
   * considered and for whom actual or forecast reimbursement is sought.
   */
  public val patient: Reference,
  /**
   * The period for which charges are being submitted.
   *
   * Typically this would be today or in the past for a claim, and today or in the future for
   * preauthorizations and predeterminations. Typically line item dates of service should fall
   * within the billing period if one is specified.
   */
  public val billablePeriod: Period? = null,
  /**
   * The date this resource was created.
   *
   * This field is independent of the date of creation of the resource as it may reflect the
   * creation date of a source document prior to digitization. Typically for claims all services
   * must be completed as of this date.
   */
  public val created: DateTime,
  /** Individual who created the claim, predetermination or preauthorization. */
  public val enterer: Reference? = null,
  /** The Insurer who is target of the request. */
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
   * The provider-required urgency of processing the request. Typical values include: stat, normal,
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
   * contraindicated, or for which the patient has an intolerance, and therefore issues a new
   * prescription for an alternate medication which has the same therapeutic intent. The
   * prescription from the pharmacy becomes the 'prescription' and that from the physician becomes
   * the 'original prescription'.
   */
  public val originalPrescription: Reference? = null,
  /**
   * The party to be reimbursed for cost of the products and services according to the terms of the
   * policy.
   *
   * Often providers agree to receive the benefits payable to reduce the near-term costs to the
   * patient. The insurer may decline to pay the provider and choose to pay the subscriber instead.
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
  /**
   * Healthcare encounters related to this claim.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: List<Reference> = listOf(),
  /** Facility where the services were provided. */
  public val facility: Reference? = null,
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
  /** Information code for an event with a corresponding date or period. */
  public val event: List<Event> = listOf(),
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
   * Details of an accident which resulted in injuries which required the products and services
   * listed in the claim.
   */
  public val accident: Accident? = null,
  /**
   * The amount paid by the patient, in total at the claim claim level or specifically for the item
   * and detail level, to the provider for goods and services.
   */
  public val patientPaid: Money? = null,
  /**
   * A claim line. Either a simple product or service or a 'group' of details which can each be a
   * simple items or groups of sub-details.
   */
  public val item: List<Item> = listOf(),
  /** The total value of the all the items in the claim. */
  public val total: Money? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          type.toBuilder(),
          use,
          patient.toBuilder(),
          created.toBuilder(),
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
          traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
          subType = this@with.subType?.toBuilder()
          billablePeriod = this@with.billablePeriod?.toBuilder()
          enterer = this@with.enterer?.toBuilder()
          insurer = this@with.insurer?.toBuilder()
          provider = this@with.provider?.toBuilder()
          priority = this@with.priority?.toBuilder()
          fundsReserve = this@with.fundsReserve?.toBuilder()
          related = this@with.related.map { it.toBuilder() }.toMutableList()
          prescription = this@with.prescription?.toBuilder()
          originalPrescription = this@with.originalPrescription?.toBuilder()
          payee = this@with.payee?.toBuilder()
          referral = this@with.referral?.toBuilder()
          encounter = this@with.encounter.map { it.toBuilder() }.toMutableList()
          facility = this@with.facility?.toBuilder()
          diagnosisRelatedGroup = this@with.diagnosisRelatedGroup?.toBuilder()
          event = this@with.event.map { it.toBuilder() }.toMutableList()
          careTeam = this@with.careTeam.map { it.toBuilder() }.toMutableList()
          supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
          diagnosis = this@with.diagnosis.map { it.toBuilder() }.toMutableList()
          procedure = this@with.procedure.map { it.toBuilder() }.toMutableList()
          insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
          accident = this@with.accident?.toBuilder()
          patientPaid = this@with.patientPaid?.toBuilder()
          item = this@with.item.map { it.toBuilder() }.toMutableList()
          total = this@with.total?.toBuilder()
        }
    }

  /**
   * Other claims which are related to this claim such as prior submissions or claims for related
   * services or for the same event.
   */
  @Serializable(with = ClaimRelatedSerializer::class)
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
     * For example, Property/Casualty insurer claim # or Workers Compensation case # .
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
       * For example, Property/Casualty insurer claim # or Workers Compensation case # .
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

  /**
   * The party to be reimbursed for cost of the products and services according to the terms of the
   * policy.
   */
  @Serializable(with = ClaimPayeeSerializer::class)
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
    /** Type of Party to be reimbursed: subscriber, provider, other. */
    public val type: CodeableConcept,
    /**
     * Reference to the individual or organization to whom any payment will be made.
     *
     * Not required if the payee is 'subscriber' or 'provider'.
     */
    public val party: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          party = this@with.party?.toBuilder()
        }
      }

    public class Builder(
      /** Type of Party to be reimbursed: subscriber, provider, other. */
      public var type: CodeableConcept.Builder
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
          type = type.build(),
          party = party?.build(),
        )
    }
  }

  /** Information code for an event with a corresponding date or period. */
  @Serializable(with = ClaimEventSerializer::class)
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
        Builder(
            type.toBuilder(),
            `when`,
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
      }

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

  /** The members of the team who provided the products and services. */
  @Serializable(with = ClaimCareTeamSerializer::class)
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
  @Serializable(with = ClaimSupportingInfoSerializer::class)
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
     */
    public val code: CodeableConcept? = null,
    /** The date when or period to which this information refers. */
    public val timing: Timing? = null,
    /**
     * Additional data or information such as resources, documents, images etc. including references
     * to the data or the actual inclusion of the data.
     *
     * Could be used to provide references to other resources, document. For example could contain a
     * PDF in an Attachment of the Police Report for an Accident.
     */
    public val `value`: Value? = null,
    /**
     * Provides the reason in the situation where a reason code is required in addition to the
     * content.
     *
     * For example: the reason for the additional stay, or why a tooth is missing.
     */
    public val reason: CodeableConcept? = null,
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

      public data class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Timing

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Timing

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

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      public data class Identifier(public val `value`: dev.ohs.fhir.model.r5.Identifier) : Value

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
       */
      public var code: CodeableConcept.Builder? = null

      /** The date when or period to which this information refers. */
      public var timing: Timing? = null

      /**
       * Additional data or information such as resources, documents, images etc. including
       * references to the data or the actual inclusion of the data.
       *
       * Could be used to provide references to other resources, document. For example could contain
       * a PDF in an Attachment of the Police Report for an Accident.
       */
      public var `value`: Value? = null

      /**
       * Provides the reason in the situation where a reason code is required in addition to the
       * content.
       *
       * For example: the reason for the additional stay, or why a tooth is missing.
       */
      public var reason: CodeableConcept.Builder? = null

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
  @Serializable(with = ClaimDiagnosisSerializer::class)
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
        Builder(
            sequence.toBuilder(),
            diagnosis,
          )
          .apply {
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

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Diagnosis

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Diagnosis

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

      public fun build(): Claim.Diagnosis =
        Claim.Diagnosis(
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
  @Serializable(with = ClaimProcedureSerializer::class)
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
    /**
     * When the condition was observed or the relative ranking.
     *
     * For example: primary, secondary.
     */
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
        Builder(
            sequence.toBuilder(),
            procedure,
          )
          .apply {
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

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Procedure

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Procedure

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

      /**
       * When the condition was observed or the relative ranking.
       *
       * For example: primary, secondary.
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Date and optionally time the procedure was performed. */
      public var date: DateTime.Builder? = null

      /** Unique Device Identifiers associated with this line item. */
      public var udi: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Claim.Procedure =
        Claim.Procedure(
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
  @Serializable(with = ClaimInsuranceSerializer::class)
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
     * The business identifier to be used when the claim is sent for adjudication against this
     * insurance policy.
     *
     * Only required in jurisdictions where insurers, rather than the provider, are required to send
     * claims to insurers that appear after them in the list. This element is not required when
     * 'subrogation=true'.
     */
    public val identifier: Identifier? = null,
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
     * Reference numbers previously provided by the insurer to the provider to be quoted on
     * subsequent claims containing services or products related to the prior authorization.
     *
     * This value is an alphanumeric string that may be provided over the phone, via text, via
     * paper, or within a ClaimResponse resource and is not a FHIR Identifier.
     */
    public val preAuthRef: List<String> = listOf(),
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
          identifier = this@with.identifier?.toBuilder()
          businessArrangement = this@with.businessArrangement?.toBuilder()
          preAuthRef = this@with.preAuthRef.map { it.toBuilder() }.toMutableList()
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
       * The business identifier to be used when the claim is sent for adjudication against this
       * insurance policy.
       *
       * Only required in jurisdictions where insurers, rather than the provider, are required to
       * send claims to insurers that appear after them in the list. This element is not required
       * when 'subrogation=true'.
       */
      public var identifier: Identifier.Builder? = null

      /**
       * A business agreement number established between the provider and the insurer for special
       * business processing purposes.
       */
      public var businessArrangement: String.Builder? = null

      /**
       * Reference numbers previously provided by the insurer to the provider to be quoted on
       * subsequent claims containing services or products related to the prior authorization.
       *
       * This value is an alphanumeric string that may be provided over the phone, via text, via
       * paper, or within a ClaimResponse resource and is not a FHIR Identifier.
       */
      public var preAuthRef: MutableList<String.Builder> = mutableListOf()

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
          identifier = identifier?.build(),
          coverage = coverage.build(),
          businessArrangement = businessArrangement?.build(),
          preAuthRef = preAuthRef.map { it.build() },
          claimResponse = claimResponse?.build(),
        )
    }
  }

  /**
   * Details of an accident which resulted in injuries which required the products and services
   * listed in the claim.
   */
  @Serializable(with = ClaimAccidentSerializer::class)
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
    public val date: Date,
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
        Builder(date.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          location = this@with.location
        }
      }

    public sealed interface Location {
      public fun asAddress(): Address? = this as? Address

      public fun asReference(): Reference? = this as? Reference

      public data class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Location

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Location

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

    public class Builder(
      /**
       * Date of an accident event related to the products and services contained in the claim.
       *
       * The date of the accident has to precede the dates of the products and services but within a
       * reasonable timeframe.
       */
      public var date: Date.Builder
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
          date = date.build(),
          type = type?.build(),
          location = location,
        )
    }
  }

  /**
   * A claim line. Either a simple product or service or a 'group' of details which can each be a
   * simple items or groups of sub-details.
   */
  @Serializable(with = ClaimItemSerializer::class)
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
    /**
     * Trace number for tracking purposes. May be defined at the jurisdiction level or between
     * trading partners.
     */
    public val traceNumber: List<Identifier> = listOf(),
    /** CareTeam members related to this service or product. */
    public val careTeamSequence: List<PositiveInt> = listOf(),
    /** Diagnosis applicable for this service or product. */
    public val diagnosisSequence: List<PositiveInt> = listOf(),
    /** Procedures applicable for this service or product. */
    public val procedureSequence: List<PositiveInt> = listOf(),
    /**
     * Exceptions, special conditions and supporting information applicable for this service or
     * product.
     */
    public val informationSequence: List<PositiveInt> = listOf(),
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
    /**
     * Healthcare encounters related to this claim.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public val encounter: List<Reference> = listOf(),
    /**
     * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which
     * are simple items.
     */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(sequence.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          traceNumber = this@with.traceNumber.map { it.toBuilder() }.toMutableList()
          careTeamSequence = this@with.careTeamSequence.map { it.toBuilder() }.toMutableList()
          diagnosisSequence = this@with.diagnosisSequence.map { it.toBuilder() }.toMutableList()
          procedureSequence = this@with.procedureSequence.map { it.toBuilder() }.toMutableList()
          informationSequence = this@with.informationSequence.map { it.toBuilder() }.toMutableList()
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
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Physical location where the service is performed or applies. */
    @Serializable(with = ClaimItemBodySiteSerializer::class)
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

    /**
     * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which
     * are simple items.
     */
    @Serializable(with = ClaimItemDetailSerializer::class)
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
      /** A number to uniquely identify item entries. */
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
      /**
       * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
       * which are simple items.
       */
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
            subDetail = this@with.subDetail.map { it.toBuilder() }.toMutableList()
          }
        }

      /**
       * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
       * which are simple items.
       */
      @Serializable(with = ClaimItemDetailSubDetailSerializer::class)
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
        /** A number to uniquely identify item entries. */
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
         * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
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
         * The total amount claimed for line item.detail.subDetail. Net = unit price * quantity *
         * factor.
         *
         * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
         * assumed to be 1 if not supplied.
         */
        public val net: Money? = null,
        /** Unique Device Identifiers associated with this line item. */
        public val udi: List<Reference> = listOf(),
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
           * For example in Oral whether the treatment is cosmetic or associated with TMJ, or for
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
           * The total amount claimed for line item.detail.subDetail. Net = unit price * quantity *
           * factor.
           *
           * For example, the formula: quantity * unitPrice * factor = net. Quantity and factor are
           * assumed to be 1 if not supplied.
           */
          public var net: Money.Builder? = null

          /** Unique Device Identifiers associated with this line item. */
          public var udi: MutableList<Reference.Builder> = mutableListOf()

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
            )
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

        /**
         * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
         * which are simple items.
         */
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
            subDetail = subDetail.map { it.build() },
          )
      }
    }

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

      /**
       * Trace number for tracking purposes. May be defined at the jurisdiction level or between
       * trading partners.
       */
      public var traceNumber: MutableList<Identifier.Builder> = mutableListOf()

      /** CareTeam members related to this service or product. */
      public var careTeamSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /** Diagnosis applicable for this service or product. */
      public var diagnosisSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /** Procedures applicable for this service or product. */
      public var procedureSequence: MutableList<PositiveInt.Builder> = mutableListOf()

      /**
       * Exceptions, special conditions and supporting information applicable for this service or
       * product.
       */
      public var informationSequence: MutableList<PositiveInt.Builder> = mutableListOf()

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

      /**
       * Healthcare encounters related to this claim.
       *
       * This will typically be the encounter the event occurred within, but some activities may be
       * initiated prior to or after the official completion of an encounter but still be tied to
       * the context of the encounter.
       */
      public var encounter: MutableList<Reference.Builder> = mutableListOf()

      /**
       * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details
       * which are simple items.
       */
      public var detail: MutableList<Detail.Builder> = mutableListOf()

      public fun build(): Item =
        Item(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence.build(),
          traceNumber = traceNumber.map { it.build() },
          careTeamSequence = careTeamSequence.map { it.build() },
          diagnosisSequence = diagnosisSequence.map { it.build() },
          procedureSequence = procedureSequence.map { it.build() },
          informationSequence = informationSequence.map { it.build() },
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
          detail = detail.map { it.build() },
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
     * The category of claim, e.g. oral, pharmacy, vision, institutional, professional.
     *
     * The code system provides oral, pharmacy, vision, professional and institutional claim types.
     * Those supported depends on the requirements of the jurisdiction. The valueset is extensible
     * to accommodate other types of claims as required by the jurisdiction.
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
     * considered and for whom actual or forecast reimbursement is sought.
     */
    public var patient: Reference.Builder,
    /**
     * The date this resource was created.
     *
     * This field is independent of the date of creation of the resource as it may reflect the
     * creation date of a source document prior to digitization. Typically for claims all services
     * must be completed as of this date.
     */
    public var created: DateTime.Builder,
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

    /** A unique identifier assigned to this claim. */
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

    /**
     * The period for which charges are being submitted.
     *
     * Typically this would be today or in the past for a claim, and today or in the future for
     * preauthorizations and predeterminations. Typically line item dates of service should fall
     * within the billing period if one is specified.
     */
    public var billablePeriod: Period.Builder? = null

    /** Individual who created the claim, predetermination or preauthorization. */
    public var enterer: Reference.Builder? = null

    /** The Insurer who is target of the request. */
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
     * The provider-required urgency of processing the request. Typical values include: stat,
     * normal, deferred.
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
     * contraindicated, or for which the patient has an intolerance, and therefore issues a new
     * prescription for an alternate medication which has the same therapeutic intent. The
     * prescription from the pharmacy becomes the 'prescription' and that from the physician becomes
     * the 'original prescription'.
     */
    public var originalPrescription: Reference.Builder? = null

    /**
     * The party to be reimbursed for cost of the products and services according to the terms of
     * the policy.
     *
     * Often providers agree to receive the benefits payable to reduce the near-term costs to the
     * patient. The insurer may decline to pay the provider and choose to pay the subscriber
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

    /**
     * Healthcare encounters related to this claim.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: MutableList<Reference.Builder> = mutableListOf()

    /** Facility where the services were provided. */
    public var facility: Reference.Builder? = null

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

    /** Information code for an event with a corresponding date or period. */
    public var event: MutableList<Event.Builder> = mutableListOf()

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
     * Details of an accident which resulted in injuries which required the products and services
     * listed in the claim.
     */
    public var accident: Accident.Builder? = null

    /**
     * The amount paid by the patient, in total at the claim claim level or specifically for the
     * item and detail level, to the provider for goods and services.
     */
    public var patientPaid: Money.Builder? = null

    /**
     * A claim line. Either a simple product or service or a 'group' of details which can each be a
     * simple items or groups of sub-details.
     */
    public var item: MutableList<Item.Builder> = mutableListOf()

    /** The total value of the all the items in the claim. */
    public var total: Money.Builder? = null

    override fun build(): Claim =
      Claim(
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
        fundsReserve = fundsReserve?.build(),
        related = related.map { it.build() },
        prescription = prescription?.build(),
        originalPrescription = originalPrescription?.build(),
        payee = payee?.build(),
        referral = referral?.build(),
        encounter = encounter.map { it.build() },
        facility = facility?.build(),
        diagnosisRelatedGroup = diagnosisRelatedGroup?.build(),
        event = event.map { it.build() },
        careTeam = careTeam.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        diagnosis = diagnosis.map { it.build() },
        procedure = procedure.map { it.build() },
        insurance = insurance.map { it.build() },
        accident = accident?.build(),
        patientPaid = patientPaid?.build(),
        item = item.map { it.build() },
        total = total?.build(),
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
