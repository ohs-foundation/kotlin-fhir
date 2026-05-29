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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.ServiceRequestSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of a request for service such as diagnostic investigations, treatments, or operations to
 * be performed.
 */
@Serializable(with = ServiceRequestSerializer::class)
@SerialName("ServiceRequest")
public data class ServiceRequest(
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
   * Identifiers assigned to this order instance by the orderer and/or the receiver and/or order
   * fulfiller.
   *
   * The identifier.type element is used to distinguish between the identifiers assigned by the
   * orderer (known as the 'Placer' in HL7 v2) and the producer of the observations in response to
   * the order (known as the 'Filler' in HL7 v2). For further discussion and examples see the
   * resource notes section below.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this ServiceRequest.
   *
   * Note: This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this ServiceRequest.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /** Plan/proposal/order fulfilled by this request. */
  public val basedOn: List<Reference> = listOf(),
  /** The request takes the place of the referenced completed or terminated request(s). */
  public val replaces: List<Reference> = listOf(),
  /**
   * A shared identifier common to all service requests that were authorized more or less
   * simultaneously by a single author, representing the composite or group identifier.
   *
   * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling another)
   * or by having a common requisition. Requests that are part of the same requisition are generally
   * treated independently from the perspective of changing their state or maintaining them after
   * initial creation.
   */
  public val requisition: Identifier? = null,
  /**
   * The status of the order.
   *
   * The status is generally fully in the control of the requester - they determine whether the
   * order is draft or active and, after it has been activated, competed, cancelled or suspended.
   * States relating to the activities of the performer are reflected on either the corresponding
   * event (see [Event Pattern](event.html) for general discussion) or using the [Task](task.html)
   * resource.
   */
  public val status: Enumeration<RequestStatus>,
  /**
   * Whether the request is a proposal, plan, an original order or a reflex order.
   *
   * This element is labeled as a modifier because the intent alters when and how the resource is
   * actually applicable.
   */
  public val intent: Enumeration<RequestIntent>,
  /**
   * A code that classifies the service for searching, sorting and display purposes (e.g. "Surgical
   * Procedure").
   *
   * There may be multiple axis of categorization depending on the context or use case for
   * retrieving or displaying the resource. The level of granularity is defined by the category
   * concepts in the value set.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Indicates how quickly the ServiceRequest should be addressed with respect to other requests.
   */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * Set this to true if the record is saying that the service/procedure should NOT be performed.
   *
   * In general, only the code and timeframe will be present, though occasional additional
   * qualifiers such as body site or even performer could be included to narrow the scope of the
   * prohibition. If the ServiceRequest.code and ServiceRequest.doNotPerform both contain negation,
   * that will reinforce prohibition and should not have a double negative interpretation.
   */
  public val doNotPerform: Boolean? = null,
  /**
   * A code that identifies a particular service (i.e., procedure, diagnostic investigation, or
   * panel of investigations) that have been requested.
   *
   * Many laboratory and radiology procedure codes embed the specimen/organ system in the test order
   * name, for example, serum or serum/plasma glucose, or a chest x-ray. The specimen might not be
   * recorded separately from the test code.
   */
  public val code: CodeableConcept? = null,
  /**
   * Additional details and instructions about the how the services are to be delivered. For
   * example, and order for a urinary catheter may have an order detail for an external or
   * indwelling catheter, or an order for a bandage may require additional instructions specifying
   * how the bandage should be applied.
   *
   * For information from the medical record intended to support the delivery of the requested
   * services, use the `supportingInformation` element.
   */
  public val orderDetail: List<CodeableConcept> = listOf(),
  /**
   * An amount of service being requested which can be a quantity ( for example $1,500 home
   * modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy
   * per fraction).
   */
  public val quantity: Quantity? = null,
  /**
   * On whom or what the service is to be performed. This is usually a human patient, but can also
   * be requested on animals, groups of humans or animals, devices such as dialysis machines, or
   * even locations (typically for environmental scans).
   */
  public val subject: Reference,
  /**
   * An encounter that provides additional information about the healthcare context in which this
   * request is made.
   */
  public val encounter: Reference? = null,
  /** The date/time at which the requested service should occur. */
  public val occurrence: Occurrence? = null,
  /**
   * If a CodeableConcept is present, it indicates the pre-condition for performing the service. For
   * example "pain", "on flare-up", etc.
   */
  public val asNeeded: AsNeeded? = null,
  /** When the request transitioned to being actionable. */
  public val authoredOn: DateTime? = null,
  /**
   * The individual who initiated the request and has responsibility for its activation.
   *
   * This not the dispatcher, but rather who is the authorizer. This element is not intended to
   * handle delegation which would generally be managed through the Provenance resource.
   */
  public val requester: Reference? = null,
  /**
   * Desired type of performer for doing the requested service.
   *
   * This is a role, not a participation type. In other words, does not describe the task but
   * describes the capacity. For example, “compounding pharmacy”, “psychiatrist” or “internal
   * referral”.
   */
  public val performerType: CodeableConcept? = null,
  /**
   * The desired performer for doing the requested service. For example, the surgeon,
   * dermatopathologist, endoscopist, etc.
   *
   * If multiple performers are present, it is interpreted as a list of *alternative* performers
   * without any preference regardless of order. If order of preference is needed use the
   * [request-performerOrder extension](extension-request-performerorder.html). Use CareTeam to
   * represent a group of performers (for example, Practitioner A *and* Practitioner B).
   */
  public val performer: List<Reference> = listOf(),
  /**
   * The preferred location(s) where the procedure should actually happen in coded or free text
   * form. E.g. at home or nursing day care center.
   */
  public val locationCode: List<CodeableConcept> = listOf(),
  /**
   * A reference to the the preferred location(s) where the procedure should actually happen. E.g.
   * at home or nursing day care center.
   */
  public val locationReference: List<Reference> = listOf(),
  /**
   * An explanation or justification for why this service is being requested in coded or textual
   * form. This is often for billing purposes. May relate to the resources referred to in
   * `supportingInfo`.
   *
   * This element represents why the referral is being made and may be used to decide how the
   * service will be performed, or even if it will be performed at all. Use `CodeableConcept.text`
   * element if the data is free (uncoded) text as shown in the
   * [CT Scan example](servicerequest-example-di.html).
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * Indicates another resource that provides a justification for why this service is being
   * requested. May relate to the resources referred to in `supportingInfo`.
   *
   * This element represents why the referral is being made and may be used to decide how the
   * service will be performed, or even if it will be performed at all. To be as specific as
   * possible, a reference to *Observation* or *Condition* should be used if available. Otherwise
   * when referencing *DiagnosticReport* it should contain a finding in
   * `DiagnosticReport.conclusion` and/or `DiagnosticReport.conclusionCode`. When using a reference
   * to *DocumentReference*, the target document should contain clear findings language providing
   * the relevant reason for this service request. Use the CodeableConcept text element in
   * `ServiceRequest.reasonCode` if the data is free (uncoded) text as shown in the
   * [CT Scan example](servicerequest-example-di.html).
   */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be
   * needed for delivering the requested service.
   */
  public val insurance: List<Reference> = listOf(),
  /**
   * Additional clinical information about the patient or specimen that may influence the services
   * or their interpretations. This information includes diagnosis, clinical findings and other
   * observations. In laboratory ordering these are typically referred to as "ask at order entry
   * questions (AOEs)". This includes observations explicitly requested by the producer (filler) to
   * provide context or supporting information needed to complete the order. For example, reporting
   * the amount of inspired oxygen for blood gas measurements.
   *
   * To represent information about how the services are to be delivered use the `instructions`
   * element.
   */
  public val supportingInfo: List<Reference> = listOf(),
  /**
   * One or more specimens that the laboratory procedure will use.
   *
   * Many diagnostic procedures need a specimen, but the request itself is not actually about the
   * specimen. This element is for when the diagnostic is requested on already existing specimens
   * and the request points to the specimen it applies to. Conversely, if the request is entered
   * first with an unknown specimen, then the [Specimen](specimen.html) resource points to the
   * ServiceRequest.
   */
  public val specimen: List<Reference> = listOf(),
  /**
   * Anatomic location where the procedure should be performed. This is the target site.
   *
   * Only used if not implicit in the code found in ServiceRequest.code. If the use case requires
   * BodySite to be handled as a separate resource instead of an inline coded element (e.g. to
   * identify and track separately) then use the standard extension
   * [procedure-targetBodyStructure](extension-procedure-targetbodystructure.html).
   */
  public val bodySite: List<CodeableConcept> = listOf(),
  /**
   * Any other notes and comments made about the service request. For example, internal billing
   * notes.
   */
  public val note: List<Annotation> = listOf(),
  /** Instructions in terms that are understood by the patient or consumer. */
  public val patientInstruction: String? = null,
  /**
   * Key events in the history of the request.
   *
   * This might not include provenances for all versions of the request – only those deemed
   * “relevant” or important. This SHALL NOT include the Provenance associated with this current
   * version of the resource. (If that provenance is deemed to be a “relevant” change, it will need
   * to be added as part of a later update. Until then, it can be queried directly as the Provenance
   * that points to this version using _revinclude All Provenances should have some historical
   * version of this Request as their subject.
   */
  public val relevantHistory: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, intent, subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        instantiatesCanonical =
          this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
        instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        replaces = this@with.replaces.map { it.toBuilder() }.toMutableList()
        requisition = this@with.requisition?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        priority = this@with.priority
        doNotPerform = this@with.doNotPerform?.toBuilder()
        code = this@with.code?.toBuilder()
        orderDetail = this@with.orderDetail.map { it.toBuilder() }.toMutableList()
        quantity = this@with.quantity
        encounter = this@with.encounter?.toBuilder()
        occurrence = this@with.occurrence
        asNeeded = this@with.asNeeded
        authoredOn = this@with.authoredOn?.toBuilder()
        requester = this@with.requester?.toBuilder()
        performerType = this@with.performerType?.toBuilder()
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        locationCode = this@with.locationCode.map { it.toBuilder() }.toMutableList()
        locationReference = this@with.locationReference.map { it.toBuilder() }.toMutableList()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
        supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
        specimen = this@with.specimen.map { it.toBuilder() }.toMutableList()
        bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        patientInstruction = this@with.patientInstruction?.toBuilder()
        relevantHistory = this@with.relevantHistory.map { it.toBuilder() }.toMutableList()
      }
    }

  public sealed interface Quantity {
    public fun asQuantity(): Quantity? = this as? Quantity

    public fun asRatio(): Ratio? = this as? Ratio

    public fun asRange(): Range? = this as? Range

    @JvmInline
    public value class Quantity(public val `value`: dev.ohs.fhir.model.r4b.Quantity) :
      ServiceRequest.Quantity

    @JvmInline
    public value class Ratio(public val `value`: dev.ohs.fhir.model.r4b.Ratio) :
      ServiceRequest.Quantity

    @JvmInline
    public value class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) :
      ServiceRequest.Quantity

    public companion object {
      internal fun from(
        quantityValue: dev.ohs.fhir.model.r4b.Quantity?,
        ratioValue: dev.ohs.fhir.model.r4b.Ratio?,
        rangeValue: dev.ohs.fhir.model.r4b.Range?,
      ): ServiceRequest.Quantity? {
        if (quantityValue != null) return Quantity(quantityValue)
        if (ratioValue != null) return Ratio(ratioValue)
        if (rangeValue != null) return Range(rangeValue)
        return null
      }
    }
  }

  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public fun asTiming(): Timing? = this as? Timing

    @JvmInline
    public value class DateTime(public val `value`: dev.ohs.fhir.model.r4b.DateTime) : Occurrence

    @JvmInline
    public value class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) : Occurrence

    @JvmInline
    public value class Timing(public val `value`: dev.ohs.fhir.model.r4b.Timing) : Occurrence

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

  public sealed interface AsNeeded {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    @JvmInline
    public value class Boolean(public val `value`: dev.ohs.fhir.model.r4b.Boolean) : AsNeeded

    @JvmInline
    public value class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept) :
      AsNeeded

    public companion object {
      internal fun from(
        booleanValue: dev.ohs.fhir.model.r4b.Boolean?,
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
      ): AsNeeded? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of the order.
     *
     * The status is generally fully in the control of the requester - they determine whether the
     * order is draft or active and, after it has been activated, competed, cancelled or suspended.
     * States relating to the activities of the performer are reflected on either the corresponding
     * event (see [Event Pattern](event.html) for general discussion) or using the [Task](task.html)
     * resource.
     */
    public var status: Enumeration<RequestStatus>,
    /**
     * Whether the request is a proposal, plan, an original order or a reflex order.
     *
     * This element is labeled as a modifier because the intent alters when and how the resource is
     * actually applicable.
     */
    public var intent: Enumeration<RequestIntent>,
    /**
     * On whom or what the service is to be performed. This is usually a human patient, but can also
     * be requested on animals, groups of humans or animals, devices such as dialysis machines, or
     * even locations (typically for environmental scans).
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
     * Identifiers assigned to this order instance by the orderer and/or the receiver and/or order
     * fulfiller.
     *
     * The identifier.type element is used to distinguish between the identifiers assigned by the
     * orderer (known as the 'Placer' in HL7 v2) and the producer of the observations in response to
     * the order (known as the 'Filler' in HL7 v2). For further discussion and examples see the
     * resource notes section below.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
     * adhered to in whole or in part by this ServiceRequest.
     *
     * Note: This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this ServiceRequest.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** Plan/proposal/order fulfilled by this request. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** The request takes the place of the referenced completed or terminated request(s). */
    public var replaces: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A shared identifier common to all service requests that were authorized more or less
     * simultaneously by a single author, representing the composite or group identifier.
     *
     * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling
     * another) or by having a common requisition. Requests that are part of the same requisition
     * are generally treated independently from the perspective of changing their state or
     * maintaining them after initial creation.
     */
    public var requisition: Identifier.Builder? = null

    /**
     * A code that classifies the service for searching, sorting and display purposes (e.g.
     * "Surgical Procedure").
     *
     * There may be multiple axis of categorization depending on the context or use case for
     * retrieving or displaying the resource. The level of granularity is defined by the category
     * concepts in the value set.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Indicates how quickly the ServiceRequest should be addressed with respect to other requests.
     */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * Set this to true if the record is saying that the service/procedure should NOT be performed.
     *
     * In general, only the code and timeframe will be present, though occasional additional
     * qualifiers such as body site or even performer could be included to narrow the scope of the
     * prohibition. If the ServiceRequest.code and ServiceRequest.doNotPerform both contain
     * negation, that will reinforce prohibition and should not have a double negative
     * interpretation.
     */
    public var doNotPerform: Boolean.Builder? = null

    /**
     * A code that identifies a particular service (i.e., procedure, diagnostic investigation, or
     * panel of investigations) that have been requested.
     *
     * Many laboratory and radiology procedure codes embed the specimen/organ system in the test
     * order name, for example, serum or serum/plasma glucose, or a chest x-ray. The specimen might
     * not be recorded separately from the test code.
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * Additional details and instructions about the how the services are to be delivered. For
     * example, and order for a urinary catheter may have an order detail for an external or
     * indwelling catheter, or an order for a bandage may require additional instructions specifying
     * how the bandage should be applied.
     *
     * For information from the medical record intended to support the delivery of the requested
     * services, use the `supportingInformation` element.
     */
    public var orderDetail: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * An amount of service being requested which can be a quantity ( for example $1,500 home
     * modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8
     * Gy per fraction).
     */
    public var quantity: Quantity? = null

    /**
     * An encounter that provides additional information about the healthcare context in which this
     * request is made.
     */
    public var encounter: Reference.Builder? = null

    /** The date/time at which the requested service should occur. */
    public var occurrence: Occurrence? = null

    /**
     * If a CodeableConcept is present, it indicates the pre-condition for performing the service.
     * For example "pain", "on flare-up", etc.
     */
    public var asNeeded: AsNeeded? = null

    /** When the request transitioned to being actionable. */
    public var authoredOn: DateTime.Builder? = null

    /**
     * The individual who initiated the request and has responsibility for its activation.
     *
     * This not the dispatcher, but rather who is the authorizer. This element is not intended to
     * handle delegation which would generally be managed through the Provenance resource.
     */
    public var requester: Reference.Builder? = null

    /**
     * Desired type of performer for doing the requested service.
     *
     * This is a role, not a participation type. In other words, does not describe the task but
     * describes the capacity. For example, “compounding pharmacy”, “psychiatrist” or “internal
     * referral”.
     */
    public var performerType: CodeableConcept.Builder? = null

    /**
     * The desired performer for doing the requested service. For example, the surgeon,
     * dermatopathologist, endoscopist, etc.
     *
     * If multiple performers are present, it is interpreted as a list of *alternative* performers
     * without any preference regardless of order. If order of preference is needed use the
     * [request-performerOrder extension](extension-request-performerorder.html). Use CareTeam to
     * represent a group of performers (for example, Practitioner A *and* Practitioner B).
     */
    public var performer: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The preferred location(s) where the procedure should actually happen in coded or free text
     * form. E.g. at home or nursing day care center.
     */
    public var locationCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A reference to the the preferred location(s) where the procedure should actually happen. E.g.
     * at home or nursing day care center.
     */
    public var locationReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * An explanation or justification for why this service is being requested in coded or textual
     * form. This is often for billing purposes. May relate to the resources referred to in
     * `supportingInfo`.
     *
     * This element represents why the referral is being made and may be used to decide how the
     * service will be performed, or even if it will be performed at all. Use `CodeableConcept.text`
     * element if the data is free (uncoded) text as shown in the
     * [CT Scan example](servicerequest-example-di.html).
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Indicates another resource that provides a justification for why this service is being
     * requested. May relate to the resources referred to in `supportingInfo`.
     *
     * This element represents why the referral is being made and may be used to decide how the
     * service will be performed, or even if it will be performed at all. To be as specific as
     * possible, a reference to *Observation* or *Condition* should be used if available. Otherwise
     * when referencing *DiagnosticReport* it should contain a finding in
     * `DiagnosticReport.conclusion` and/or `DiagnosticReport.conclusionCode`. When using a
     * reference to *DocumentReference*, the target document should contain clear findings language
     * providing the relevant reason for this service request. Use the CodeableConcept text element
     * in `ServiceRequest.reasonCode` if the data is free (uncoded) text as shown in the
     * [CT Scan example](servicerequest-example-di.html).
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may
     * be needed for delivering the requested service.
     */
    public var insurance: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Additional clinical information about the patient or specimen that may influence the services
     * or their interpretations. This information includes diagnosis, clinical findings and other
     * observations. In laboratory ordering these are typically referred to as "ask at order entry
     * questions (AOEs)". This includes observations explicitly requested by the producer (filler)
     * to provide context or supporting information needed to complete the order. For example,
     * reporting the amount of inspired oxygen for blood gas measurements.
     *
     * To represent information about how the services are to be delivered use the `instructions`
     * element.
     */
    public var supportingInfo: MutableList<Reference.Builder> = mutableListOf()

    /**
     * One or more specimens that the laboratory procedure will use.
     *
     * Many diagnostic procedures need a specimen, but the request itself is not actually about the
     * specimen. This element is for when the diagnostic is requested on already existing specimens
     * and the request points to the specimen it applies to. Conversely, if the request is entered
     * first with an unknown specimen, then the [Specimen](specimen.html) resource points to the
     * ServiceRequest.
     */
    public var specimen: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Anatomic location where the procedure should be performed. This is the target site.
     *
     * Only used if not implicit in the code found in ServiceRequest.code. If the use case requires
     * BodySite to be handled as a separate resource instead of an inline coded element (e.g. to
     * identify and track separately) then use the standard extension
     * [procedure-targetBodyStructure](extension-procedure-targetbodystructure.html).
     */
    public var bodySite: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Any other notes and comments made about the service request. For example, internal billing
     * notes.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Instructions in terms that are understood by the patient or consumer. */
    public var patientInstruction: String.Builder? = null

    /**
     * Key events in the history of the request.
     *
     * This might not include provenances for all versions of the request – only those deemed
     * “relevant” or important. This SHALL NOT include the Provenance associated with this current
     * version of the resource. (If that provenance is deemed to be a “relevant” change, it will
     * need to be added as part of a later update. Until then, it can be queried directly as the
     * Provenance that points to this version using _revinclude All Provenances should have some
     * historical version of this Request as their subject.
     */
    public var relevantHistory: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): ServiceRequest =
      ServiceRequest(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiatesCanonical = instantiatesCanonical.map { it.build() },
        instantiatesUri = instantiatesUri.map { it.build() },
        basedOn = basedOn.map { it.build() },
        replaces = replaces.map { it.build() },
        requisition = requisition?.build(),
        status = status,
        intent = intent,
        category = category.map { it.build() },
        priority = priority,
        doNotPerform = doNotPerform?.build(),
        code = code?.build(),
        orderDetail = orderDetail.map { it.build() },
        quantity = quantity,
        subject = subject.build(),
        encounter = encounter?.build(),
        occurrence = occurrence,
        asNeeded = asNeeded,
        authoredOn = authoredOn?.build(),
        requester = requester?.build(),
        performerType = performerType?.build(),
        performer = performer.map { it.build() },
        locationCode = locationCode.map { it.build() },
        locationReference = locationReference.map { it.build() },
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        insurance = insurance.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        specimen = specimen.map { it.build() },
        bodySite = bodySite.map { it.build() },
        note = note.map { it.build() },
        patientInstruction = patientInstruction?.build(),
        relevantHistory = relevantHistory.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of a request. */
  public enum class RequestStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Draft("draft", "http://hl7.org/fhir/request-status", "Draft"),
    Active("active", "http://hl7.org/fhir/request-status", "Active"),
    On_Hold("on-hold", "http://hl7.org/fhir/request-status", "On Hold"),
    Revoked("revoked", "http://hl7.org/fhir/request-status", "Revoked"),
    Completed("completed", "http://hl7.org/fhir/request-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/request-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/request-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestStatus =
        when (code) {
          "draft" -> Draft
          "active" -> Active
          "on-hold" -> On_Hold
          "revoked" -> Revoked
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestStatus")
        }
    }
  }

  /** Codes indicating the degree of authority/intentionality associated with a request. */
  public enum class RequestIntent(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
    Directive("directive", "http://hl7.org/fhir/request-intent", "Directive"),
    Order("order", "http://hl7.org/fhir/request-intent", "Order"),
    Original_Order("original-order", "http://hl7.org/fhir/request-intent", "Original Order"),
    Reflex_Order("reflex-order", "http://hl7.org/fhir/request-intent", "Reflex Order"),
    Filler_Order("filler-order", "http://hl7.org/fhir/request-intent", "Filler Order"),
    Instance_Order("instance-order", "http://hl7.org/fhir/request-intent", "Instance Order"),
    Option("option", "http://hl7.org/fhir/request-intent", "Option");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestIntent =
        when (code) {
          "proposal" -> Proposal
          "plan" -> Plan
          "directive" -> Directive
          "order" -> Order
          "original-order" -> Original_Order
          "reflex-order" -> Reflex_Order
          "filler-order" -> Filler_Order
          "instance-order" -> Instance_Order
          "option" -> Option
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestIntent")
        }
    }
  }

  /** Identifies the level of importance to be assigned to actioning the request. */
  public enum class RequestPriority(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
    Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
    Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
    Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestPriority =
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
