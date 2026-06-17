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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.MedicationRequestDispenseRequestInitialFillSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationRequestDispenseRequestSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationRequestSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationRequestSubstitutionSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An order or request for both supply of the medication and the instructions for administration of
 * the medication to a patient. The resource is called "MedicationRequest" rather than
 * "MedicationPrescription" or "MedicationOrder" to generalize the use across inpatient and
 * outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
 */
@Serializable(with = MedicationRequestSerializer::class)
@SerialName("MedicationRequest")
public data class MedicationRequest(
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
   * Identifiers associated with this medication request that are defined by business processes
   * and/or used to refer to it when a direct URL reference to the resource itself is not
   * appropriate. They are business identifiers assigned to this resource by the performer or other
   * systems and remain constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A code specifying the current state of the order. Generally, this will be active or completed
   * state.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<MedicationrequestStatus>,
  /**
   * Captures the reason for the current state of the MedicationRequest.
   *
   * This is generally only used for "exception" statuses such as "suspended" or "cancelled". The
   * reason why the MedicationRequest was created at all is captured in reasonCode, not here.
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * Whether the request is a proposal, plan, or an original order.
   *
   * It is expected that the type of requester will be restricted for different stages of a
   * MedicationRequest. For example, Proposals can be created by a patient, relatedPerson,
   * Practitioner or Device. Plans can be created by Practitioners, Patients, RelatedPersons and
   * Devices. Original orders can be created by a Practitioner only.
   *
   * An instance-order is an instantiation of a request or order and may be used to populate
   * Medication Administration Record.
   *
   * This element is labeled as a modifier because the intent alters when and how the resource is
   * actually applicable.
   */
  public val intent: Enumeration<MedicationRequestIntent>,
  /**
   * Indicates the type of medication request (for example, where the medication is expected to be
   * consumed or administered (i.e. inpatient or outpatient)).
   *
   * The category can be used to include where the medication is expected to be consumed or other
   * types of requests.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Indicates how quickly the Medication Request should be addressed with respect to other
   * requests.
   */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * If true indicates that the provider is asking for the medication request not to occur.
   *
   * If do not perform is not specified, the request is a positive request e.g. "do perform".
   */
  public val doNotPerform: Boolean? = null,
  /**
   * Indicates if this record was captured as a secondary 'reported' record rather than as an
   * original primary source-of-truth record. It may also indicate the source of the report.
   */
  public val reported: Reported? = null,
  /**
   * Identifies the medication being requested. This is a link to a resource that represents the
   * medication which may be the details of the medication or simply an attribute carrying a code
   * that identifies the medication from a known list of medications.
   *
   * If only a code is specified, then it needs to be a code for a specific product. If more
   * information is required, then the use of the Medication resource is recommended. For example,
   * if you require form or lot number or if the medication is compounded or extemporaneously
   * prepared, then you must reference the Medication resource.
   */
  public val medication: Medication,
  /**
   * A link to a resource representing the person or set of individuals to whom the medication will
   * be given.
   *
   * The subject on a medication request is mandatory. For the secondary use case where the actual
   * subject is not provided, there still must be an anonymized subject specified.
   */
  public val subject: Reference,
  /**
   * The Encounter during which this [x] was created or to which the creation of this record is
   * tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter." If there is a need to link to episodes of care they will be handled
   * with an extension.
   */
  public val encounter: Reference? = null,
  /**
   * Include additional information (for example, patient height and weight) that supports the
   * ordering of the medication.
   */
  public val supportingInformation: List<Reference> = listOf(),
  /** The date (and perhaps time) when the prescription was initially written or authored on. */
  public val authoredOn: DateTime? = null,
  /**
   * The individual, organization, or device that initiated the request and has responsibility for
   * its activation.
   */
  public val requester: Reference? = null,
  /**
   * The specified desired performer of the medication treatment (e.g. the performer of the
   * medication administration).
   */
  public val performer: Reference? = null,
  /**
   * Indicates the type of performer of the administration of the medication.
   *
   * If specified without indicating a performer, this indicates that the performer must be of the
   * specified type. If specified with a performer then it indicates the requirements of the
   * performer if the designated performer is not available.
   */
  public val performerType: CodeableConcept? = null,
  /**
   * The person who entered the order on behalf of another individual for example in the case of a
   * verbal or a telephone order.
   */
  public val recorder: Reference? = null,
  /**
   * The reason or the indication for ordering or not ordering the medication.
   *
   * This could be a diagnosis code. If a full condition record exists or additional detail is
   * needed, use reasonReference.
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * Condition or observation that supports why the medication was ordered.
   *
   * This is a reference to a condition or observation that is the reason for the medication order.
   * If only a code exists, use reasonCode.
   */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * The URL pointing to a protocol, guideline, orderset, or other definition that is adhered to in
   * whole or in part by this MedicationRequest.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this MedicationRequest.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /** A plan or request that is fulfilled in whole or in part by this medication request. */
  public val basedOn: List<Reference> = listOf(),
  /**
   * A shared identifier common to all requests that were authorized more or less simultaneously by
   * a single author, representing the identifier of the requisition or prescription.
   */
  public val groupIdentifier: Identifier? = null,
  /**
   * The description of the overall patte3rn of the administration of the medication to the patient.
   *
   * This attribute should not be confused with the protocol of the medication.
   */
  public val courseOfTherapyType: CodeableConcept? = null,
  /**
   * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be
   * required for delivering the requested service.
   */
  public val insurance: List<Reference> = listOf(),
  /**
   * Extra information about the prescription that could not be conveyed by the other attributes.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * Indicates how the medication is to be used by the patient.
   *
   * There are examples where a medication request may include the option of an oral dose or an
   * Intravenous or Intramuscular dose. For example, "Ondansetron 8mg orally or IV twice a day as
   * needed for nausea" or "Compazine® (prochlorperazine) 5-10mg PO or 25mg PR bid prn nausea or
   * vomiting". In these cases, two medication requests would be created that could be grouped
   * together. The decision on which dose and route of administration to use is based on the
   * patient's condition at the time the dose is needed.
   */
  public val dosageInstruction: List<Dosage> = listOf(),
  /**
   * Indicates the specific details for the dispense or medication supply part of a medication
   * request (also known as a Medication Prescription or Medication Order). Note that this
   * information is not always sent with the order. There may be in some settings (e.g. hospitals)
   * institutional or system support for completing the dispense details in the pharmacy department.
   */
  public val dispenseRequest: DispenseRequest? = null,
  /**
   * Indicates whether or not substitution can or should be part of the dispense. In some cases,
   * substitution must happen, in other cases substitution must not happen. This block explains the
   * prescriber's intent. If nothing is specified substitution may be done.
   */
  public val substitution: Substitution? = null,
  /** A link to a resource representing an earlier order related order or prescription. */
  public val priorPrescription: Reference? = null,
  /**
   * Indicates an actual or potential clinical issue with or between one or more active or proposed
   * clinical actions for a patient; e.g. Drug-drug interaction, duplicate therapy, dosage alert
   * etc.
   *
   * This element can include a detected issue that has been identified either by a decision support
   * system or by a clinician and may include information on the steps that were taken to address
   * the issue.
   */
  public val detectedIssue: List<Reference> = listOf(),
  /**
   * Links to Provenance records for past versions of this resource or fulfilling request or event
   * resources that identify key state transitions or updates that are likely to be relevant to a
   * user looking at the current version of the resource.
   *
   * This might not include provenances for all versions of the request – only those deemed
   * “relevant” or important. This SHALL NOT include the provenance associated with this current
   * version of the resource. (If that provenance is deemed to be a “relevant” change, it will need
   * to be added as part of a later update. Until then, it can be queried directly as the provenance
   * that points to this version using _revinclude All Provenances should have some historical
   * version of this Request as their subject.).
   */
  public val eventHistory: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          intent,
          medication,
          subject.toBuilder(),
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
          statusReason = this@with.statusReason?.toBuilder()
          category = this@with.category.map { it.toBuilder() }.toMutableList()
          priority = this@with.priority
          doNotPerform = this@with.doNotPerform?.toBuilder()
          reported = this@with.reported
          encounter = this@with.encounter?.toBuilder()
          supportingInformation =
            this@with.supportingInformation.map { it.toBuilder() }.toMutableList()
          authoredOn = this@with.authoredOn?.toBuilder()
          requester = this@with.requester?.toBuilder()
          performer = this@with.performer?.toBuilder()
          performerType = this@with.performerType?.toBuilder()
          recorder = this@with.recorder?.toBuilder()
          reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
          reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
          instantiatesCanonical =
            this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
          instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
          basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
          groupIdentifier = this@with.groupIdentifier?.toBuilder()
          courseOfTherapyType = this@with.courseOfTherapyType?.toBuilder()
          insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          dosageInstruction = this@with.dosageInstruction.map { it.toBuilder() }.toMutableList()
          dispenseRequest = this@with.dispenseRequest?.toBuilder()
          substitution = this@with.substitution?.toBuilder()
          priorPrescription = this@with.priorPrescription?.toBuilder()
          detectedIssue = this@with.detectedIssue.map { it.toBuilder() }.toMutableList()
          eventHistory = this@with.eventHistory.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * Indicates the specific details for the dispense or medication supply part of a medication
   * request (also known as a Medication Prescription or Medication Order). Note that this
   * information is not always sent with the order. There may be in some settings (e.g. hospitals)
   * institutional or system support for completing the dispense details in the pharmacy department.
   */
  @Serializable(with = MedicationRequestDispenseRequestSerializer::class)
  public data class DispenseRequest(
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
     * Indicates the quantity or duration for the first dispense of the medication.
     *
     * If populating this element, either the quantity or the duration must be included.
     */
    public val initialFill: InitialFill? = null,
    /** The minimum period of time that must occur between dispenses of the medication. */
    public val dispenseInterval: Duration? = null,
    /**
     * This indicates the validity period of a prescription (stale dating the Prescription).
     *
     * It reflects the prescribers' perspective for the validity of the prescription. Dispenses must
     * not be made against the prescription outside of this period. The lower-bound of the
     * Dispensing Window signifies the earliest date that the prescription can be filled for the
     * first time. If an upper-bound is not specified then the Prescription is open-ended or will
     * default to a stale-date based on regulations.
     */
    public val validityPeriod: Period? = null,
    /**
     * An integer indicating the number of times, in addition to the original dispense, (aka refills
     * or repeats) that the patient can receive the prescribed medication. Usage Notes: This integer
     * does not include the original order dispense. This means that if an order indicates dispense
     * 30 tablets plus "3 repeats", then the order can be dispensed a total of 4 times and the
     * patient can receive a total of 120 tablets. A prescriber may explicitly say that zero refills
     * are permitted after the initial dispense.
     *
     * If displaying "number of authorized fills", add 1 to this number.
     */
    public val numberOfRepeatsAllowed: UnsignedInt? = null,
    /** The amount that is to be dispensed for one fill. */
    public val quantity: Quantity? = null,
    /**
     * Identifies the period time over which the supplied product is expected to be used, or the
     * length of time the dispense is expected to last.
     *
     * In some situations, this attribute may be used instead of quantity to identify the amount
     * supplied by how long it is expected to last, rather than the physical quantity issued, e.g.
     * 90 days supply of medication (based on an ordered dosage). When possible, it is always better
     * to specify quantity, as this tends to be more precise. expectedSupplyDuration will always be
     * an estimate that can be influenced by external factors.
     */
    public val expectedSupplyDuration: Duration? = null,
    /** Indicates the intended dispensing Organization specified by the prescriber. */
    public val performer: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          initialFill = this@with.initialFill?.toBuilder()
          dispenseInterval = this@with.dispenseInterval?.toBuilder()
          validityPeriod = this@with.validityPeriod?.toBuilder()
          numberOfRepeatsAllowed = this@with.numberOfRepeatsAllowed?.toBuilder()
          quantity = this@with.quantity?.toBuilder()
          expectedSupplyDuration = this@with.expectedSupplyDuration?.toBuilder()
          performer = this@with.performer?.toBuilder()
        }
      }

    /** Indicates the quantity or duration for the first dispense of the medication. */
    @Serializable(with = MedicationRequestDispenseRequestInitialFillSerializer::class)
    public data class InitialFill(
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
      /** The amount or quantity to provide as part of the first dispense. */
      public val quantity: Quantity? = null,
      /** The length of time that the first dispense is expected to last. */
      public val duration: Duration? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            quantity = this@with.quantity?.toBuilder()
            duration = this@with.duration?.toBuilder()
          }
        }

      public class Builder() {
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

        /** The amount or quantity to provide as part of the first dispense. */
        public var quantity: Quantity.Builder? = null

        /** The length of time that the first dispense is expected to last. */
        public var duration: Duration.Builder? = null

        public fun build(): InitialFill =
          InitialFill(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            quantity = quantity?.build(),
            duration = duration?.build(),
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
       * Indicates the quantity or duration for the first dispense of the medication.
       *
       * If populating this element, either the quantity or the duration must be included.
       */
      public var initialFill: InitialFill.Builder? = null

      /** The minimum period of time that must occur between dispenses of the medication. */
      public var dispenseInterval: Duration.Builder? = null

      /**
       * This indicates the validity period of a prescription (stale dating the Prescription).
       *
       * It reflects the prescribers' perspective for the validity of the prescription. Dispenses
       * must not be made against the prescription outside of this period. The lower-bound of the
       * Dispensing Window signifies the earliest date that the prescription can be filled for the
       * first time. If an upper-bound is not specified then the Prescription is open-ended or will
       * default to a stale-date based on regulations.
       */
      public var validityPeriod: Period.Builder? = null

      /**
       * An integer indicating the number of times, in addition to the original dispense, (aka
       * refills or repeats) that the patient can receive the prescribed medication. Usage Notes:
       * This integer does not include the original order dispense. This means that if an order
       * indicates dispense 30 tablets plus "3 repeats", then the order can be dispensed a total of
       * 4 times and the patient can receive a total of 120 tablets. A prescriber may explicitly say
       * that zero refills are permitted after the initial dispense.
       *
       * If displaying "number of authorized fills", add 1 to this number.
       */
      public var numberOfRepeatsAllowed: UnsignedInt.Builder? = null

      /** The amount that is to be dispensed for one fill. */
      public var quantity: Quantity.Builder? = null

      /**
       * Identifies the period time over which the supplied product is expected to be used, or the
       * length of time the dispense is expected to last.
       *
       * In some situations, this attribute may be used instead of quantity to identify the amount
       * supplied by how long it is expected to last, rather than the physical quantity issued, e.g.
       * 90 days supply of medication (based on an ordered dosage). When possible, it is always
       * better to specify quantity, as this tends to be more precise. expectedSupplyDuration will
       * always be an estimate that can be influenced by external factors.
       */
      public var expectedSupplyDuration: Duration.Builder? = null

      /** Indicates the intended dispensing Organization specified by the prescriber. */
      public var performer: Reference.Builder? = null

      public fun build(): DispenseRequest =
        DispenseRequest(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          initialFill = initialFill?.build(),
          dispenseInterval = dispenseInterval?.build(),
          validityPeriod = validityPeriod?.build(),
          numberOfRepeatsAllowed = numberOfRepeatsAllowed?.build(),
          quantity = quantity?.build(),
          expectedSupplyDuration = expectedSupplyDuration?.build(),
          performer = performer?.build(),
        )
    }
  }

  /**
   * Indicates whether or not substitution can or should be part of the dispense. In some cases,
   * substitution must happen, in other cases substitution must not happen. This block explains the
   * prescriber's intent. If nothing is specified substitution may be done.
   */
  @Serializable(with = MedicationRequestSubstitutionSerializer::class)
  public data class Substitution(
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
     * True if the prescriber allows a different drug to be dispensed from what was prescribed.
     *
     * This element is labeled as a modifier because whether substitution is allow or not, it cannot
     * be ignored.
     */
    public val allowed: Allowed,
    /**
     * Indicates the reason for the substitution, or why substitution must or must not be performed.
     */
    public val reason: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(allowed).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          reason = this@with.reason?.toBuilder()
        }
      }

    public sealed interface Allowed {
      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Allowed

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
        Allowed

      public companion object {
        internal fun from(
          booleanValue: dev.ohs.fhir.model.r4.Boolean?,
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
        ): Allowed? {
          if (booleanValue != null) return Boolean(booleanValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * True if the prescriber allows a different drug to be dispensed from what was prescribed.
       *
       * This element is labeled as a modifier because whether substitution is allow or not, it
       * cannot be ignored.
       */
      public var allowed: Allowed
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

      /**
       * Indicates the reason for the substitution, or why substitution must or must not be
       * performed.
       */
      public var reason: CodeableConcept.Builder? = null

      public fun build(): Substitution =
        Substitution(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          allowed = allowed,
          reason = reason?.build(),
        )
    }
  }

  public sealed interface Reported {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asReference(): Reference? = this as? Reference

    public data class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Reported

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Reported

    public companion object {
      internal fun from(
        booleanValue: dev.ohs.fhir.model.r4.Boolean?,
        referenceValue: dev.ohs.fhir.model.r4.Reference?,
      ): Reported? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public sealed interface Medication {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
      Medication

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Medication

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4.Reference?,
      ): Medication? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A code specifying the current state of the order. Generally, this will be active or completed
     * state.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<MedicationrequestStatus>,
    /**
     * Whether the request is a proposal, plan, or an original order.
     *
     * It is expected that the type of requester will be restricted for different stages of a
     * MedicationRequest. For example, Proposals can be created by a patient, relatedPerson,
     * Practitioner or Device. Plans can be created by Practitioners, Patients, RelatedPersons and
     * Devices. Original orders can be created by a Practitioner only.
     *
     * An instance-order is an instantiation of a request or order and may be used to populate
     * Medication Administration Record.
     *
     * This element is labeled as a modifier because the intent alters when and how the resource is
     * actually applicable.
     */
    public var intent: Enumeration<MedicationRequestIntent>,
    /**
     * Identifies the medication being requested. This is a link to a resource that represents the
     * medication which may be the details of the medication or simply an attribute carrying a code
     * that identifies the medication from a known list of medications.
     *
     * If only a code is specified, then it needs to be a code for a specific product. If more
     * information is required, then the use of the Medication resource is recommended. For example,
     * if you require form or lot number or if the medication is compounded or extemporaneously
     * prepared, then you must reference the Medication resource.
     */
    public var medication: Medication,
    /**
     * A link to a resource representing the person or set of individuals to whom the medication
     * will be given.
     *
     * The subject on a medication request is mandatory. For the secondary use case where the actual
     * subject is not provided, there still must be an anonymized subject specified.
     */
    public var subject: Reference.Builder,
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
     * Identifiers associated with this medication request that are defined by business processes
     * and/or used to refer to it when a direct URL reference to the resource itself is not
     * appropriate. They are business identifiers assigned to this resource by the performer or
     * other systems and remain constant as the resource is updated and propagates from server to
     * server.
     *
     * This is a business identifier, not a resource identifier.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Captures the reason for the current state of the MedicationRequest.
     *
     * This is generally only used for "exception" statuses such as "suspended" or "cancelled". The
     * reason why the MedicationRequest was created at all is captured in reasonCode, not here.
     */
    public var statusReason: CodeableConcept.Builder? = null

    /**
     * Indicates the type of medication request (for example, where the medication is expected to be
     * consumed or administered (i.e. inpatient or outpatient)).
     *
     * The category can be used to include where the medication is expected to be consumed or other
     * types of requests.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Indicates how quickly the Medication Request should be addressed with respect to other
     * requests.
     */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * If true indicates that the provider is asking for the medication request not to occur.
     *
     * If do not perform is not specified, the request is a positive request e.g. "do perform".
     */
    public var doNotPerform: Boolean.Builder? = null

    /**
     * Indicates if this record was captured as a secondary 'reported' record rather than as an
     * original primary source-of-truth record. It may also indicate the source of the report.
     */
    public var reported: Reported? = null

    /**
     * The Encounter during which this [x] was created or to which the creation of this record is
     * tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter." If there is a need to link to episodes of care they will be
     * handled with an extension.
     */
    public var encounter: Reference.Builder? = null

    /**
     * Include additional information (for example, patient height and weight) that supports the
     * ordering of the medication.
     */
    public var supportingInformation: MutableList<Reference.Builder> = mutableListOf()

    /** The date (and perhaps time) when the prescription was initially written or authored on. */
    public var authoredOn: DateTime.Builder? = null

    /**
     * The individual, organization, or device that initiated the request and has responsibility for
     * its activation.
     */
    public var requester: Reference.Builder? = null

    /**
     * The specified desired performer of the medication treatment (e.g. the performer of the
     * medication administration).
     */
    public var performer: Reference.Builder? = null

    /**
     * Indicates the type of performer of the administration of the medication.
     *
     * If specified without indicating a performer, this indicates that the performer must be of the
     * specified type. If specified with a performer then it indicates the requirements of the
     * performer if the designated performer is not available.
     */
    public var performerType: CodeableConcept.Builder? = null

    /**
     * The person who entered the order on behalf of another individual for example in the case of a
     * verbal or a telephone order.
     */
    public var recorder: Reference.Builder? = null

    /**
     * The reason or the indication for ordering or not ordering the medication.
     *
     * This could be a diagnosis code. If a full condition record exists or additional detail is
     * needed, use reasonReference.
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Condition or observation that supports why the medication was ordered.
     *
     * This is a reference to a condition or observation that is the reason for the medication
     * order. If only a code exists, use reasonCode.
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The URL pointing to a protocol, guideline, orderset, or other definition that is adhered to
     * in whole or in part by this MedicationRequest.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this MedicationRequest.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** A plan or request that is fulfilled in whole or in part by this medication request. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A shared identifier common to all requests that were authorized more or less simultaneously
     * by a single author, representing the identifier of the requisition or prescription.
     */
    public var groupIdentifier: Identifier.Builder? = null

    /**
     * The description of the overall patte3rn of the administration of the medication to the
     * patient.
     *
     * This attribute should not be confused with the protocol of the medication.
     */
    public var courseOfTherapyType: CodeableConcept.Builder? = null

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may
     * be required for delivering the requested service.
     */
    public var insurance: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Extra information about the prescription that could not be conveyed by the other attributes.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Indicates how the medication is to be used by the patient.
     *
     * There are examples where a medication request may include the option of an oral dose or an
     * Intravenous or Intramuscular dose. For example, "Ondansetron 8mg orally or IV twice a day as
     * needed for nausea" or "Compazine® (prochlorperazine) 5-10mg PO or 25mg PR bid prn nausea or
     * vomiting". In these cases, two medication requests would be created that could be grouped
     * together. The decision on which dose and route of administration to use is based on the
     * patient's condition at the time the dose is needed.
     */
    public var dosageInstruction: MutableList<Dosage.Builder> = mutableListOf()

    /**
     * Indicates the specific details for the dispense or medication supply part of a medication
     * request (also known as a Medication Prescription or Medication Order). Note that this
     * information is not always sent with the order. There may be in some settings (e.g. hospitals)
     * institutional or system support for completing the dispense details in the pharmacy
     * department.
     */
    public var dispenseRequest: DispenseRequest.Builder? = null

    /**
     * Indicates whether or not substitution can or should be part of the dispense. In some cases,
     * substitution must happen, in other cases substitution must not happen. This block explains
     * the prescriber's intent. If nothing is specified substitution may be done.
     */
    public var substitution: Substitution.Builder? = null

    /** A link to a resource representing an earlier order related order or prescription. */
    public var priorPrescription: Reference.Builder? = null

    /**
     * Indicates an actual or potential clinical issue with or between one or more active or
     * proposed clinical actions for a patient; e.g. Drug-drug interaction, duplicate therapy,
     * dosage alert etc.
     *
     * This element can include a detected issue that has been identified either by a decision
     * support system or by a clinician and may include information on the steps that were taken to
     * address the issue.
     */
    public var detectedIssue: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Links to Provenance records for past versions of this resource or fulfilling request or event
     * resources that identify key state transitions or updates that are likely to be relevant to a
     * user looking at the current version of the resource.
     *
     * This might not include provenances for all versions of the request – only those deemed
     * “relevant” or important. This SHALL NOT include the provenance associated with this current
     * version of the resource. (If that provenance is deemed to be a “relevant” change, it will
     * need to be added as part of a later update. Until then, it can be queried directly as the
     * provenance that points to this version using _revinclude All Provenances should have some
     * historical version of this Request as their subject.).
     */
    public var eventHistory: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): MedicationRequest =
      MedicationRequest(
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
        statusReason = statusReason?.build(),
        intent = intent,
        category = category.map { it.build() },
        priority = priority,
        doNotPerform = doNotPerform?.build(),
        reported = reported,
        medication = medication,
        subject = subject.build(),
        encounter = encounter?.build(),
        supportingInformation = supportingInformation.map { it.build() },
        authoredOn = authoredOn?.build(),
        requester = requester?.build(),
        performer = performer?.build(),
        performerType = performerType?.build(),
        recorder = recorder?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        instantiatesCanonical = instantiatesCanonical.map { it.build() },
        instantiatesUri = instantiatesUri.map { it.build() },
        basedOn = basedOn.map { it.build() },
        groupIdentifier = groupIdentifier?.build(),
        courseOfTherapyType = courseOfTherapyType?.build(),
        insurance = insurance.map { it.build() },
        note = note.map { it.build() },
        dosageInstruction = dosageInstruction.map { it.build() },
        dispenseRequest = dispenseRequest?.build(),
        substitution = substitution?.build(),
        priorPrescription = priorPrescription?.build(),
        detectedIssue = detectedIssue.map { it.build() },
        eventHistory = eventHistory.map { it.build() },
      )
  }

  /** MedicationRequest Status Codes */
  public enum class MedicationrequestStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Active("active", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "Active"),
    On_Hold("on-hold", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "On Hold"),
    Cancelled("cancelled", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "Cancelled"),
    Completed("completed", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "Completed"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/CodeSystem/medicationrequest-status",
      "Entered in Error",
    ),
    Stopped("stopped", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "Stopped"),
    Draft("draft", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "Draft"),
    Unknown("unknown", "http://hl7.org/fhir/CodeSystem/medicationrequest-status", "Unknown");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): MedicationrequestStatus =
        when (code) {
          "active" -> Active
          "on-hold" -> On_Hold
          "cancelled" -> Cancelled
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "stopped" -> Stopped
          "draft" -> Draft
          "unknown" -> Unknown
          else ->
            throw IllegalArgumentException("Unknown code $code for enum MedicationrequestStatus")
        }
    }
  }

  /** MedicationRequest Intent Codes */
  public enum class MedicationRequestIntent(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Proposal("proposal", "http://hl7.org/fhir/CodeSystem/medicationrequest-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/CodeSystem/medicationrequest-intent", "Plan"),
    Order("order", "http://hl7.org/fhir/CodeSystem/medicationrequest-intent", "Order"),
    Original_Order(
      "original-order",
      "http://hl7.org/fhir/CodeSystem/medicationrequest-intent",
      "Original Order",
    ),
    Reflex_Order(
      "reflex-order",
      "http://hl7.org/fhir/CodeSystem/medicationrequest-intent",
      "Reflex Order",
    ),
    Filler_Order(
      "filler-order",
      "http://hl7.org/fhir/CodeSystem/medicationrequest-intent",
      "Filler Order",
    ),
    Instance_Order(
      "instance-order",
      "http://hl7.org/fhir/CodeSystem/medicationrequest-intent",
      "Instance Order",
    ),
    Option("option", "http://hl7.org/fhir/CodeSystem/medicationrequest-intent", "Option");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): MedicationRequestIntent =
        when (code) {
          "proposal" -> Proposal
          "plan" -> Plan
          "order" -> Order
          "original-order" -> Original_Order
          "reflex-order" -> Reflex_Order
          "filler-order" -> Filler_Order
          "instance-order" -> Instance_Order
          "option" -> Option
          else ->
            throw IllegalArgumentException("Unknown code $code for enum MedicationRequestIntent")
        }
    }
  }

  /** The clinical priority of a diagnostic order. */
  public enum class RequestPriority(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
    Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
    Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
    Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): RequestPriority =
        when (code) {
          "routine" -> Routine
          "urgent" -> Urgent
          "asap" -> Asap
          "stat" -> Stat
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestPriority")
        }
    }
  }
}
