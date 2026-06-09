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

import dev.ohs.fhir.model.r5.serializers.TransportInputSerializer
import dev.ohs.fhir.model.r5.serializers.TransportOutputSerializer
import dev.ohs.fhir.model.r5.serializers.TransportRestrictionSerializer
import dev.ohs.fhir.model.r5.serializers.TransportSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Record of transport. */
@Serializable(with = TransportSerializer::class)
@SerialName("Transport")
public data class Transport(
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
   * Identifier for the transport event that is used to identify it across multiple disparate
   * systems.
   *
   * This identifier is typically assigned by the dispenser, and may be used to reference the
   * delivery when exchanging information about it with other systems.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this Transport.
   */
  public val instantiatesCanonical: Canonical? = null,
  /**
   * The URL pointing to an *externally* maintained protocol, guideline, orderset or other
   * definition that is adhered to in whole or in part by this Transport.
   */
  public val instantiatesUri: Uri? = null,
  /**
   * BasedOn refers to a higher-level authorization that triggered the creation of the transport. It
   * references a "request" resource such as a ServiceRequest or Transport, which is distinct from
   * the "request" resource the Transport is seeking to fulfill. This latter resource is referenced
   * by FocusOn. For example, based on a ServiceRequest (= BasedOn), a transport is created to
   * fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab.
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * A shared identifier common to multiple independent Request instances that were
   * activated/authorized more or less simultaneously by a single author. The presence of the same
   * identifier on each request ties those requests together and may have business ramifications in
   * terms of reporting of results, billing, etc. E.g. a requisition number shared by a set of lab
   * tests ordered together, or a prescription number shared by all meds ordered at one time.
   */
  public val groupIdentifier: Identifier? = null,
  /**
   * A larger event of which this particular event is a component or step.
   *
   * Not to be used to link an event to an Encounter - use Event.context for that.
   *
   * [The allowed reference resources may be adjusted as appropriate for the event resource].
   */
  public val partOf: List<Reference> = listOf(),
  /** A code specifying the state of the transport event. */
  public val status: Enumeration<TransportStatus>? = null,
  /**
   * An explanation as to why this transport is held, failed, was refused, etc.
   *
   * This applies to the current status. Look at the history of the transport to see reasons for
   * past statuses.
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a
   * proposed transport, a planned transport, an actionable transport, etc.
   *
   * This element is immutable. Proposed transports, planned transports, etc. must be distinct
   * instances.
   *
   * In most cases, Transports will have an intent of "order".
   */
  public val intent: Enumeration<TransportIntent>,
  /** Indicates how quickly the Transport should be addressed with respect to other requests. */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * A name or code (or both) briefly describing what the transport involves.
   *
   * The title (eg "My Transports", "Outstanding Transports for Patient X") should go into the code.
   */
  public val code: CodeableConcept? = null,
  /** A free-text description of what is to be performed. */
  public val description: String? = null,
  /**
   * The request being actioned or the resource being manipulated by this transport.
   *
   * If multiple resources need to be manipulated, use sub-transports. (This ensures that status can
   * be tracked independently for each referenced resource.).
   */
  public val focus: Reference? = null,
  /**
   * The entity who benefits from the performance of the service specified in the transport (e.g.,
   * the patient).
   */
  public val `for`: Reference? = null,
  /**
   * The healthcare event (e.g. a patient and healthcare provider interaction) during which this
   * transport was created.
   */
  public val encounter: Reference? = null,
  /** Identifies the completion time of the event (the occurrence). */
  public val completionTime: DateTime? = null,
  /** The date and time this transport was created. */
  public val authoredOn: DateTime? = null,
  /** The date and time of last modification to this transport. */
  public val lastModified: DateTime? = null,
  /** The creator of the transport. */
  public val requester: Reference? = null,
  /** The kind of participant that should perform the transport. */
  public val performerType: List<CodeableConcept> = listOf(),
  /**
   * Individual organization or Device currently responsible for transport execution.
   *
   * Transports may be created with an owner not yet identified.
   */
  public val owner: Reference? = null,
  /** Principal physical location where this transport is performed. */
  public val location: Reference? = null,
  /**
   * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be
   * relevant to the Transport.
   */
  public val insurance: List<Reference> = listOf(),
  /** Free-text information captured about the transport as it progresses. */
  public val note: List<Annotation> = listOf(),
  /**
   * Links to Provenance records for past versions of this Transport that identify key state
   * transitions or updates that are likely to be relevant to a user looking at the current version
   * of the transport.
   *
   * This element does not point to the Provenance associated with the *current* version of the
   * resource - as it would be created after this version existed. The Provenance for the current
   * version can be retrieved with a _revinclude.
   */
  public val relevantHistory: List<Reference> = listOf(),
  /**
   * If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is
   * asking for the request to be actioned), this element identifies any limitations on what parts
   * of the referenced request should be actioned.
   */
  public val restriction: Restriction? = null,
  /** Additional information that may be needed in the execution of the transport. */
  public val input: List<Input> = listOf(),
  /** Outputs produced by the Transport. */
  public val output: List<Output> = listOf(),
  /** The desired or final location for the transport. */
  public val requestedLocation: Reference,
  /** The current location for the entity to be transported. */
  public val currentLocation: Reference,
  /**
   * A resource reference indicating why this transport needs to be performed.
   *
   * Transports might be justified based on an Observation, a Condition, a past or planned
   * procedure, etc. This should only be included if there is no focus or if it differs from the
   * reason indicated on the focus. Use the CodeableConcept text element in `Transport.reasonCode`
   * if the data is free (uncoded) text.
   */
  public val reason: CodeableReference? = null,
  /** The transport event prior to this one. */
  public val history: Reference? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(intent, requestedLocation.toBuilder(), currentLocation.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        instantiatesCanonical = this@with.instantiatesCanonical?.toBuilder()
        instantiatesUri = this@with.instantiatesUri?.toBuilder()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        groupIdentifier = this@with.groupIdentifier?.toBuilder()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        status = this@with.status
        statusReason = this@with.statusReason?.toBuilder()
        priority = this@with.priority
        code = this@with.code?.toBuilder()
        description = this@with.description?.toBuilder()
        focus = this@with.focus?.toBuilder()
        `for` = this@with.`for`?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        completionTime = this@with.completionTime?.toBuilder()
        authoredOn = this@with.authoredOn?.toBuilder()
        lastModified = this@with.lastModified?.toBuilder()
        requester = this@with.requester?.toBuilder()
        performerType = this@with.performerType.map { it.toBuilder() }.toMutableList()
        owner = this@with.owner?.toBuilder()
        location = this@with.location?.toBuilder()
        insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        relevantHistory = this@with.relevantHistory.map { it.toBuilder() }.toMutableList()
        restriction = this@with.restriction?.toBuilder()
        input = this@with.input.map { it.toBuilder() }.toMutableList()
        output = this@with.output.map { it.toBuilder() }.toMutableList()
        reason = this@with.reason?.toBuilder()
        history = this@with.history?.toBuilder()
      }
    }

  /**
   * If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e. is
   * asking for the request to be actioned), this element identifies any limitations on what parts
   * of the referenced request should be actioned.
   */
  @Serializable(with = TransportRestrictionSerializer::class)
  public data class Restriction(
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
    /** Indicates the number of times the requested action should occur. */
    public val repetitions: PositiveInt? = null,
    /**
     * Over what time-period is fulfillment sought.
     *
     * Note that period.high is the due date representing the time by which the transport should be
     * completed.
     */
    public val period: Period? = null,
    /**
     * For requests that are targeted to more than one potential recipient/target, to identify who
     * is fulfillment is sought for.
     */
    public val recipient: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          repetitions = this@with.repetitions?.toBuilder()
          period = this@with.period?.toBuilder()
          recipient = this@with.recipient.map { it.toBuilder() }.toMutableList()
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

      /** Indicates the number of times the requested action should occur. */
      public var repetitions: PositiveInt.Builder? = null

      /**
       * Over what time-period is fulfillment sought.
       *
       * Note that period.high is the due date representing the time by which the transport should
       * be completed.
       */
      public var period: Period.Builder? = null

      /**
       * For requests that are targeted to more than one potential recipient/target, to identify who
       * is fulfillment is sought for.
       */
      public var recipient: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Restriction =
        Restriction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          repetitions = repetitions?.build(),
          period = period?.build(),
          recipient = recipient.map { it.build() },
        )
    }
  }

  /** Additional information that may be needed in the execution of the transport. */
  @Serializable(with = TransportInputSerializer::class)
  public data class Input(
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
     * A code or description indicating how the input is intended to be used as part of the
     * transport execution.
     *
     * If referencing a BPMN workflow or Protocol, the "system" is the URL for the workflow
     * definition and the code is the "name" of the required input.
     */
    public val type: CodeableConcept,
    /** The value of the input parameter as a basic type. */
    public val `value`: Value,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder(), `value`).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Value {
      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asCode(): Code? = this as? Code

      public fun asDate(): Date? = this as? Date

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asId(): Id? = this as? Id

      public fun asInstant(): Instant? = this as? Instant

      public fun asInteger(): Integer? = this as? Integer

      public fun asInteger64(): Integer64? = this as? Integer64

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asOid(): Oid? = this as? Oid

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public fun asString(): String? = this as? String

      public fun asTime(): Time? = this as? Time

      public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

      public fun asUri(): Uri? = this as? Uri

      public fun asUrl(): Url? = this as? Url

      public fun asUuid(): Uuid? = this as? Uuid

      public fun asAddress(): Address? = this as? Address

      public fun asAge(): Age? = this as? Age

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asCodeableReference(): CodeableReference? = this as? CodeableReference

      public fun asCoding(): Coding? = this as? Coding

      public fun asContactPoint(): ContactPoint? = this as? ContactPoint

      public fun asCount(): Count? = this as? Count

      public fun asDistance(): Distance? = this as? Distance

      public fun asDuration(): Duration? = this as? Duration

      public fun asHumanName(): HumanName? = this as? HumanName

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asMoney(): Money? = this as? Money

      public fun asPeriod(): Period? = this as? Period

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asRatioRange(): RatioRange? = this as? RatioRange

      public fun asReference(): Reference? = this as? Reference

      public fun asSampledData(): SampledData? = this as? SampledData

      public fun asSignature(): Signature? = this as? Signature

      public fun asTiming(): Timing? = this as? Timing

      public fun asContactDetail(): ContactDetail? = this as? ContactDetail

      public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

      public fun asExpression(): Expression? = this as? Expression

      public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

      public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

      public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

      public fun asUsageContext(): UsageContext? = this as? UsageContext

      public fun asAvailability(): Availability? = this as? Availability

      public fun asExtendedContactDetail(): ExtendedContactDetail? = this as? ExtendedContactDetail

      public fun asDosage(): Dosage? = this as? Dosage

      public fun asMeta(): Meta? = this as? Meta

      public data class Base64Binary(public val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
        Value

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Canonical(public val `value`: dev.ohs.fhir.model.r5.Canonical) : Value

      public data class Code(public val `value`: dev.ohs.fhir.model.r5.Code) : Value

      public data class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Value

      public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Value

      public data class Decimal(public val `value`: dev.ohs.fhir.model.r5.Decimal) : Value

      public data class Id(public val `value`: dev.ohs.fhir.model.r5.Id) : Value

      public data class Instant(public val `value`: dev.ohs.fhir.model.r5.Instant) : Value

      public data class Integer(public val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      public data class Integer64(public val `value`: dev.ohs.fhir.model.r5.Integer64) : Value

      public data class Markdown(public val `value`: dev.ohs.fhir.model.r5.Markdown) : Value

      public data class Oid(public val `value`: dev.ohs.fhir.model.r5.Oid) : Value

      public data class PositiveInt(public val `value`: dev.ohs.fhir.model.r5.PositiveInt) : Value

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Time(public val `value`: dev.ohs.fhir.model.r5.Time) : Value

      public data class UnsignedInt(public val `value`: dev.ohs.fhir.model.r5.UnsignedInt) : Value

      public data class Uri(public val `value`: dev.ohs.fhir.model.r5.Uri) : Value

      public data class Url(public val `value`: dev.ohs.fhir.model.r5.Url) : Value

      public data class Uuid(public val `value`: dev.ohs.fhir.model.r5.Uuid) : Value

      public data class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Value

      public data class Age(public val `value`: dev.ohs.fhir.model.r5.Age) : Value

      public data class Annotation(public val `value`: dev.ohs.fhir.model.r5.Annotation) : Value

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Value

      public data class CodeableReference(
        public val `value`: dev.ohs.fhir.model.r5.CodeableReference
      ) : Value

      public data class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : Value

      public data class ContactPoint(public val `value`: dev.ohs.fhir.model.r5.ContactPoint) :
        Value

      public data class Count(public val `value`: dev.ohs.fhir.model.r5.Count) : Value

      public data class Distance(public val `value`: dev.ohs.fhir.model.r5.Distance) : Value

      public data class Duration(public val `value`: dev.ohs.fhir.model.r5.Duration) : Value

      public data class HumanName(public val `value`: dev.ohs.fhir.model.r5.HumanName) : Value

      public data class Identifier(public val `value`: dev.ohs.fhir.model.r5.Identifier) : Value

      public data class Money(public val `value`: dev.ohs.fhir.model.r5.Money) : Value

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public data class Ratio(public val `value`: dev.ohs.fhir.model.r5.Ratio) : Value

      public data class RatioRange(public val `value`: dev.ohs.fhir.model.r5.RatioRange) : Value

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      public data class SampledData(public val `value`: dev.ohs.fhir.model.r5.SampledData) : Value

      public data class Signature(public val `value`: dev.ohs.fhir.model.r5.Signature) : Value

      public data class Timing(public val `value`: dev.ohs.fhir.model.r5.Timing) : Value

      public data class ContactDetail(public val `value`: dev.ohs.fhir.model.r5.ContactDetail) :
        Value

      public data class DataRequirement(public val `value`: dev.ohs.fhir.model.r5.DataRequirement) :
        Value

      public data class Expression(public val `value`: dev.ohs.fhir.model.r5.Expression) : Value

      public data class ParameterDefinition(
        public val `value`: dev.ohs.fhir.model.r5.ParameterDefinition
      ) : Value

      public data class RelatedArtifact(public val `value`: dev.ohs.fhir.model.r5.RelatedArtifact) :
        Value

      public data class TriggerDefinition(
        public val `value`: dev.ohs.fhir.model.r5.TriggerDefinition
      ) : Value

      public data class UsageContext(public val `value`: dev.ohs.fhir.model.r5.UsageContext) :
        Value

      public data class Availability(public val `value`: dev.ohs.fhir.model.r5.Availability) :
        Value

      public data class ExtendedContactDetail(
        public val `value`: dev.ohs.fhir.model.r5.ExtendedContactDetail
      ) : Value

      public data class Dosage(public val `value`: dev.ohs.fhir.model.r5.Dosage) : Value

      public data class Meta(public val `value`: dev.ohs.fhir.model.r5.Meta) : Value

      public companion object {
        internal fun from(
          base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
          codeValue: dev.ohs.fhir.model.r5.Code?,
          dateValue: dev.ohs.fhir.model.r5.Date?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          decimalValue: dev.ohs.fhir.model.r5.Decimal?,
          idValue: dev.ohs.fhir.model.r5.Id?,
          instantValue: dev.ohs.fhir.model.r5.Instant?,
          integerValue: dev.ohs.fhir.model.r5.Integer?,
          integer64Value: dev.ohs.fhir.model.r5.Integer64?,
          markdownValue: dev.ohs.fhir.model.r5.Markdown?,
          oidValue: dev.ohs.fhir.model.r5.Oid?,
          positiveIntValue: dev.ohs.fhir.model.r5.PositiveInt?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          timeValue: dev.ohs.fhir.model.r5.Time?,
          unsignedIntValue: dev.ohs.fhir.model.r5.UnsignedInt?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
          urlValue: dev.ohs.fhir.model.r5.Url?,
          uuidValue: dev.ohs.fhir.model.r5.Uuid?,
          addressValue: dev.ohs.fhir.model.r5.Address?,
          ageValue: dev.ohs.fhir.model.r5.Age?,
          annotationValue: dev.ohs.fhir.model.r5.Annotation?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          codeableReferenceValue: dev.ohs.fhir.model.r5.CodeableReference?,
          codingValue: dev.ohs.fhir.model.r5.Coding?,
          contactPointValue: dev.ohs.fhir.model.r5.ContactPoint?,
          countValue: dev.ohs.fhir.model.r5.Count?,
          distanceValue: dev.ohs.fhir.model.r5.Distance?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
          humanNameValue: dev.ohs.fhir.model.r5.HumanName?,
          identifierValue: dev.ohs.fhir.model.r5.Identifier?,
          moneyValue: dev.ohs.fhir.model.r5.Money?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          ratioValue: dev.ohs.fhir.model.r5.Ratio?,
          ratioRangeValue: dev.ohs.fhir.model.r5.RatioRange?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          sampledDataValue: dev.ohs.fhir.model.r5.SampledData?,
          signatureValue: dev.ohs.fhir.model.r5.Signature?,
          timingValue: dev.ohs.fhir.model.r5.Timing?,
          contactDetailValue: dev.ohs.fhir.model.r5.ContactDetail?,
          dataRequirementValue: dev.ohs.fhir.model.r5.DataRequirement?,
          expressionValue: dev.ohs.fhir.model.r5.Expression?,
          parameterDefinitionValue: dev.ohs.fhir.model.r5.ParameterDefinition?,
          relatedArtifactValue: dev.ohs.fhir.model.r5.RelatedArtifact?,
          triggerDefinitionValue: dev.ohs.fhir.model.r5.TriggerDefinition?,
          usageContextValue: dev.ohs.fhir.model.r5.UsageContext?,
          availabilityValue: dev.ohs.fhir.model.r5.Availability?,
          extendedContactDetailValue: dev.ohs.fhir.model.r5.ExtendedContactDetail?,
          dosageValue: dev.ohs.fhir.model.r5.Dosage?,
          metaValue: dev.ohs.fhir.model.r5.Meta?,
        ): Value? {
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (codeValue != null) return Code(codeValue)
          if (dateValue != null) return Date(dateValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (idValue != null) return Id(idValue)
          if (instantValue != null) return Instant(instantValue)
          if (integerValue != null) return Integer(integerValue)
          if (integer64Value != null) return Integer64(integer64Value)
          if (markdownValue != null) return Markdown(markdownValue)
          if (oidValue != null) return Oid(oidValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          if (stringValue != null) return String(stringValue)
          if (timeValue != null) return Time(timeValue)
          if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
          if (uriValue != null) return Uri(uriValue)
          if (urlValue != null) return Url(urlValue)
          if (uuidValue != null) return Uuid(uuidValue)
          if (addressValue != null) return Address(addressValue)
          if (ageValue != null) return Age(ageValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (codeableReferenceValue != null) return CodeableReference(codeableReferenceValue)
          if (codingValue != null) return Coding(codingValue)
          if (contactPointValue != null) return ContactPoint(contactPointValue)
          if (countValue != null) return Count(countValue)
          if (distanceValue != null) return Distance(distanceValue)
          if (durationValue != null) return Duration(durationValue)
          if (humanNameValue != null) return HumanName(humanNameValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (moneyValue != null) return Money(moneyValue)
          if (periodValue != null) return Period(periodValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (ratioRangeValue != null) return RatioRange(ratioRangeValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (sampledDataValue != null) return SampledData(sampledDataValue)
          if (signatureValue != null) return Signature(signatureValue)
          if (timingValue != null) return Timing(timingValue)
          if (contactDetailValue != null) return ContactDetail(contactDetailValue)
          if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
          if (expressionValue != null) return Expression(expressionValue)
          if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
          if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
          if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
          if (usageContextValue != null) return UsageContext(usageContextValue)
          if (availabilityValue != null) return Availability(availabilityValue)
          if (extendedContactDetailValue != null)
            return ExtendedContactDetail(extendedContactDetailValue)
          if (dosageValue != null) return Dosage(dosageValue)
          if (metaValue != null) return Meta(metaValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * A code or description indicating how the input is intended to be used as part of the
       * transport execution.
       *
       * If referencing a BPMN workflow or Protocol, the "system" is the URL for the workflow
       * definition and the code is the "name" of the required input.
       */
      public var type: CodeableConcept.Builder,
      /** The value of the input parameter as a basic type. */
      public var `value`: Value,
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

      public fun build(): Input =
        Input(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  /** Outputs produced by the Transport. */
  @Serializable(with = TransportOutputSerializer::class)
  public data class Output(
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
    /** The name of the Output parameter. */
    public val type: CodeableConcept,
    /** The value of the Output parameter as a basic type. */
    public val `value`: Value,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder(), `value`).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Value {
      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asCode(): Code? = this as? Code

      public fun asDate(): Date? = this as? Date

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asId(): Id? = this as? Id

      public fun asInstant(): Instant? = this as? Instant

      public fun asInteger(): Integer? = this as? Integer

      public fun asInteger64(): Integer64? = this as? Integer64

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asOid(): Oid? = this as? Oid

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public fun asString(): String? = this as? String

      public fun asTime(): Time? = this as? Time

      public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

      public fun asUri(): Uri? = this as? Uri

      public fun asUrl(): Url? = this as? Url

      public fun asUuid(): Uuid? = this as? Uuid

      public fun asAddress(): Address? = this as? Address

      public fun asAge(): Age? = this as? Age

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asCodeableReference(): CodeableReference? = this as? CodeableReference

      public fun asCoding(): Coding? = this as? Coding

      public fun asContactPoint(): ContactPoint? = this as? ContactPoint

      public fun asCount(): Count? = this as? Count

      public fun asDistance(): Distance? = this as? Distance

      public fun asDuration(): Duration? = this as? Duration

      public fun asHumanName(): HumanName? = this as? HumanName

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asMoney(): Money? = this as? Money

      public fun asPeriod(): Period? = this as? Period

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asRatioRange(): RatioRange? = this as? RatioRange

      public fun asReference(): Reference? = this as? Reference

      public fun asSampledData(): SampledData? = this as? SampledData

      public fun asSignature(): Signature? = this as? Signature

      public fun asTiming(): Timing? = this as? Timing

      public fun asContactDetail(): ContactDetail? = this as? ContactDetail

      public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

      public fun asExpression(): Expression? = this as? Expression

      public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

      public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

      public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

      public fun asUsageContext(): UsageContext? = this as? UsageContext

      public fun asAvailability(): Availability? = this as? Availability

      public fun asExtendedContactDetail(): ExtendedContactDetail? = this as? ExtendedContactDetail

      public fun asDosage(): Dosage? = this as? Dosage

      public fun asMeta(): Meta? = this as? Meta

      public data class Base64Binary(public val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
        Value

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Canonical(public val `value`: dev.ohs.fhir.model.r5.Canonical) : Value

      public data class Code(public val `value`: dev.ohs.fhir.model.r5.Code) : Value

      public data class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Value

      public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Value

      public data class Decimal(public val `value`: dev.ohs.fhir.model.r5.Decimal) : Value

      public data class Id(public val `value`: dev.ohs.fhir.model.r5.Id) : Value

      public data class Instant(public val `value`: dev.ohs.fhir.model.r5.Instant) : Value

      public data class Integer(public val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      public data class Integer64(public val `value`: dev.ohs.fhir.model.r5.Integer64) : Value

      public data class Markdown(public val `value`: dev.ohs.fhir.model.r5.Markdown) : Value

      public data class Oid(public val `value`: dev.ohs.fhir.model.r5.Oid) : Value

      public data class PositiveInt(public val `value`: dev.ohs.fhir.model.r5.PositiveInt) : Value

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Time(public val `value`: dev.ohs.fhir.model.r5.Time) : Value

      public data class UnsignedInt(public val `value`: dev.ohs.fhir.model.r5.UnsignedInt) : Value

      public data class Uri(public val `value`: dev.ohs.fhir.model.r5.Uri) : Value

      public data class Url(public val `value`: dev.ohs.fhir.model.r5.Url) : Value

      public data class Uuid(public val `value`: dev.ohs.fhir.model.r5.Uuid) : Value

      public data class Address(public val `value`: dev.ohs.fhir.model.r5.Address) : Value

      public data class Age(public val `value`: dev.ohs.fhir.model.r5.Age) : Value

      public data class Annotation(public val `value`: dev.ohs.fhir.model.r5.Annotation) : Value

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Value

      public data class CodeableReference(
        public val `value`: dev.ohs.fhir.model.r5.CodeableReference
      ) : Value

      public data class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : Value

      public data class ContactPoint(public val `value`: dev.ohs.fhir.model.r5.ContactPoint) :
        Value

      public data class Count(public val `value`: dev.ohs.fhir.model.r5.Count) : Value

      public data class Distance(public val `value`: dev.ohs.fhir.model.r5.Distance) : Value

      public data class Duration(public val `value`: dev.ohs.fhir.model.r5.Duration) : Value

      public data class HumanName(public val `value`: dev.ohs.fhir.model.r5.HumanName) : Value

      public data class Identifier(public val `value`: dev.ohs.fhir.model.r5.Identifier) : Value

      public data class Money(public val `value`: dev.ohs.fhir.model.r5.Money) : Value

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public data class Ratio(public val `value`: dev.ohs.fhir.model.r5.Ratio) : Value

      public data class RatioRange(public val `value`: dev.ohs.fhir.model.r5.RatioRange) : Value

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      public data class SampledData(public val `value`: dev.ohs.fhir.model.r5.SampledData) : Value

      public data class Signature(public val `value`: dev.ohs.fhir.model.r5.Signature) : Value

      public data class Timing(public val `value`: dev.ohs.fhir.model.r5.Timing) : Value

      public data class ContactDetail(public val `value`: dev.ohs.fhir.model.r5.ContactDetail) :
        Value

      public data class DataRequirement(public val `value`: dev.ohs.fhir.model.r5.DataRequirement) :
        Value

      public data class Expression(public val `value`: dev.ohs.fhir.model.r5.Expression) : Value

      public data class ParameterDefinition(
        public val `value`: dev.ohs.fhir.model.r5.ParameterDefinition
      ) : Value

      public data class RelatedArtifact(public val `value`: dev.ohs.fhir.model.r5.RelatedArtifact) :
        Value

      public data class TriggerDefinition(
        public val `value`: dev.ohs.fhir.model.r5.TriggerDefinition
      ) : Value

      public data class UsageContext(public val `value`: dev.ohs.fhir.model.r5.UsageContext) :
        Value

      public data class Availability(public val `value`: dev.ohs.fhir.model.r5.Availability) :
        Value

      public data class ExtendedContactDetail(
        public val `value`: dev.ohs.fhir.model.r5.ExtendedContactDetail
      ) : Value

      public data class Dosage(public val `value`: dev.ohs.fhir.model.r5.Dosage) : Value

      public data class Meta(public val `value`: dev.ohs.fhir.model.r5.Meta) : Value

      public companion object {
        internal fun from(
          base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
          codeValue: dev.ohs.fhir.model.r5.Code?,
          dateValue: dev.ohs.fhir.model.r5.Date?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          decimalValue: dev.ohs.fhir.model.r5.Decimal?,
          idValue: dev.ohs.fhir.model.r5.Id?,
          instantValue: dev.ohs.fhir.model.r5.Instant?,
          integerValue: dev.ohs.fhir.model.r5.Integer?,
          integer64Value: dev.ohs.fhir.model.r5.Integer64?,
          markdownValue: dev.ohs.fhir.model.r5.Markdown?,
          oidValue: dev.ohs.fhir.model.r5.Oid?,
          positiveIntValue: dev.ohs.fhir.model.r5.PositiveInt?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          timeValue: dev.ohs.fhir.model.r5.Time?,
          unsignedIntValue: dev.ohs.fhir.model.r5.UnsignedInt?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
          urlValue: dev.ohs.fhir.model.r5.Url?,
          uuidValue: dev.ohs.fhir.model.r5.Uuid?,
          addressValue: dev.ohs.fhir.model.r5.Address?,
          ageValue: dev.ohs.fhir.model.r5.Age?,
          annotationValue: dev.ohs.fhir.model.r5.Annotation?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          codeableReferenceValue: dev.ohs.fhir.model.r5.CodeableReference?,
          codingValue: dev.ohs.fhir.model.r5.Coding?,
          contactPointValue: dev.ohs.fhir.model.r5.ContactPoint?,
          countValue: dev.ohs.fhir.model.r5.Count?,
          distanceValue: dev.ohs.fhir.model.r5.Distance?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
          humanNameValue: dev.ohs.fhir.model.r5.HumanName?,
          identifierValue: dev.ohs.fhir.model.r5.Identifier?,
          moneyValue: dev.ohs.fhir.model.r5.Money?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          ratioValue: dev.ohs.fhir.model.r5.Ratio?,
          ratioRangeValue: dev.ohs.fhir.model.r5.RatioRange?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          sampledDataValue: dev.ohs.fhir.model.r5.SampledData?,
          signatureValue: dev.ohs.fhir.model.r5.Signature?,
          timingValue: dev.ohs.fhir.model.r5.Timing?,
          contactDetailValue: dev.ohs.fhir.model.r5.ContactDetail?,
          dataRequirementValue: dev.ohs.fhir.model.r5.DataRequirement?,
          expressionValue: dev.ohs.fhir.model.r5.Expression?,
          parameterDefinitionValue: dev.ohs.fhir.model.r5.ParameterDefinition?,
          relatedArtifactValue: dev.ohs.fhir.model.r5.RelatedArtifact?,
          triggerDefinitionValue: dev.ohs.fhir.model.r5.TriggerDefinition?,
          usageContextValue: dev.ohs.fhir.model.r5.UsageContext?,
          availabilityValue: dev.ohs.fhir.model.r5.Availability?,
          extendedContactDetailValue: dev.ohs.fhir.model.r5.ExtendedContactDetail?,
          dosageValue: dev.ohs.fhir.model.r5.Dosage?,
          metaValue: dev.ohs.fhir.model.r5.Meta?,
        ): Value? {
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (codeValue != null) return Code(codeValue)
          if (dateValue != null) return Date(dateValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (idValue != null) return Id(idValue)
          if (instantValue != null) return Instant(instantValue)
          if (integerValue != null) return Integer(integerValue)
          if (integer64Value != null) return Integer64(integer64Value)
          if (markdownValue != null) return Markdown(markdownValue)
          if (oidValue != null) return Oid(oidValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          if (stringValue != null) return String(stringValue)
          if (timeValue != null) return Time(timeValue)
          if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
          if (uriValue != null) return Uri(uriValue)
          if (urlValue != null) return Url(urlValue)
          if (uuidValue != null) return Uuid(uuidValue)
          if (addressValue != null) return Address(addressValue)
          if (ageValue != null) return Age(ageValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (codeableReferenceValue != null) return CodeableReference(codeableReferenceValue)
          if (codingValue != null) return Coding(codingValue)
          if (contactPointValue != null) return ContactPoint(contactPointValue)
          if (countValue != null) return Count(countValue)
          if (distanceValue != null) return Distance(distanceValue)
          if (durationValue != null) return Duration(durationValue)
          if (humanNameValue != null) return HumanName(humanNameValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (moneyValue != null) return Money(moneyValue)
          if (periodValue != null) return Period(periodValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (ratioRangeValue != null) return RatioRange(ratioRangeValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (sampledDataValue != null) return SampledData(sampledDataValue)
          if (signatureValue != null) return Signature(signatureValue)
          if (timingValue != null) return Timing(timingValue)
          if (contactDetailValue != null) return ContactDetail(contactDetailValue)
          if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
          if (expressionValue != null) return Expression(expressionValue)
          if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
          if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
          if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
          if (usageContextValue != null) return UsageContext(usageContextValue)
          if (availabilityValue != null) return Availability(availabilityValue)
          if (extendedContactDetailValue != null)
            return ExtendedContactDetail(extendedContactDetailValue)
          if (dosageValue != null) return Dosage(dosageValue)
          if (metaValue != null) return Meta(metaValue)
          return null
        }
      }
    }

    public class Builder(
      /** The name of the Output parameter. */
      public var type: CodeableConcept.Builder,
      /** The value of the Output parameter as a basic type. */
      public var `value`: Value,
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

      public fun build(): Output =
        Output(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  public class Builder(
    /**
     * Indicates the "level" of actionability associated with the Transport, i.e. i+R[9]Cs this a
     * proposed transport, a planned transport, an actionable transport, etc.
     *
     * This element is immutable. Proposed transports, planned transports, etc. must be distinct
     * instances.
     *
     * In most cases, Transports will have an intent of "order".
     */
    public var intent: Enumeration<TransportIntent>,
    /** The desired or final location for the transport. */
    public var requestedLocation: Reference.Builder,
    /** The current location for the entity to be transported. */
    public var currentLocation: Reference.Builder,
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
     * Identifier for the transport event that is used to identify it across multiple disparate
     * systems.
     *
     * This identifier is typically assigned by the dispenser, and may be used to reference the
     * delivery when exchanging information about it with other systems.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that
     * is adhered to in whole or in part by this Transport.
     */
    public var instantiatesCanonical: Canonical.Builder? = null

    /**
     * The URL pointing to an *externally* maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this Transport.
     */
    public var instantiatesUri: Uri.Builder? = null

    /**
     * BasedOn refers to a higher-level authorization that triggered the creation of the transport.
     * It references a "request" resource such as a ServiceRequest or Transport, which is distinct
     * from the "request" resource the Transport is seeking to fulfill. This latter resource is
     * referenced by FocusOn. For example, based on a ServiceRequest (= BasedOn), a transport is
     * created to fulfill a procedureRequest ( = FocusOn ) to transport a specimen to the lab.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A shared identifier common to multiple independent Request instances that were
     * activated/authorized more or less simultaneously by a single author. The presence of the same
     * identifier on each request ties those requests together and may have business ramifications
     * in terms of reporting of results, billing, etc. E.g. a requisition number shared by a set of
     * lab tests ordered together, or a prescription number shared by all meds ordered at one time.
     */
    public var groupIdentifier: Identifier.Builder? = null

    /**
     * A larger event of which this particular event is a component or step.
     *
     * Not to be used to link an event to an Encounter - use Event.context for that.
     *
     * [The allowed reference resources may be adjusted as appropriate for the event resource].
     */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /** A code specifying the state of the transport event. */
    public var status: Enumeration<TransportStatus>? = null

    /**
     * An explanation as to why this transport is held, failed, was refused, etc.
     *
     * This applies to the current status. Look at the history of the transport to see reasons for
     * past statuses.
     */
    public var statusReason: CodeableConcept.Builder? = null

    /** Indicates how quickly the Transport should be addressed with respect to other requests. */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * A name or code (or both) briefly describing what the transport involves.
     *
     * The title (eg "My Transports", "Outstanding Transports for Patient X") should go into the
     * code.
     */
    public var code: CodeableConcept.Builder? = null

    /** A free-text description of what is to be performed. */
    public var description: String.Builder? = null

    /**
     * The request being actioned or the resource being manipulated by this transport.
     *
     * If multiple resources need to be manipulated, use sub-transports. (This ensures that status
     * can be tracked independently for each referenced resource.).
     */
    public var focus: Reference.Builder? = null

    /**
     * The entity who benefits from the performance of the service specified in the transport (e.g.,
     * the patient).
     */
    public var `for`: Reference.Builder? = null

    /**
     * The healthcare event (e.g. a patient and healthcare provider interaction) during which this
     * transport was created.
     */
    public var encounter: Reference.Builder? = null

    /** Identifies the completion time of the event (the occurrence). */
    public var completionTime: DateTime.Builder? = null

    /** The date and time this transport was created. */
    public var authoredOn: DateTime.Builder? = null

    /** The date and time of last modification to this transport. */
    public var lastModified: DateTime.Builder? = null

    /** The creator of the transport. */
    public var requester: Reference.Builder? = null

    /** The kind of participant that should perform the transport. */
    public var performerType: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Individual organization or Device currently responsible for transport execution.
     *
     * Transports may be created with an owner not yet identified.
     */
    public var owner: Reference.Builder? = null

    /** Principal physical location where this transport is performed. */
    public var location: Reference.Builder? = null

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may
     * be relevant to the Transport.
     */
    public var insurance: MutableList<Reference.Builder> = mutableListOf()

    /** Free-text information captured about the transport as it progresses. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Links to Provenance records for past versions of this Transport that identify key state
     * transitions or updates that are likely to be relevant to a user looking at the current
     * version of the transport.
     *
     * This element does not point to the Provenance associated with the *current* version of the
     * resource - as it would be created after this version existed. The Provenance for the current
     * version can be retrieved with a _revinclude.
     */
    public var relevantHistory: MutableList<Reference.Builder> = mutableListOf()

    /**
     * If the Transport.focus is a request resource and the transport is seeking fulfillment (i.e.
     * is asking for the request to be actioned), this element identifies any limitations on what
     * parts of the referenced request should be actioned.
     */
    public var restriction: Restriction.Builder? = null

    /** Additional information that may be needed in the execution of the transport. */
    public var input: MutableList<Input.Builder> = mutableListOf()

    /** Outputs produced by the Transport. */
    public var output: MutableList<Output.Builder> = mutableListOf()

    /**
     * A resource reference indicating why this transport needs to be performed.
     *
     * Transports might be justified based on an Observation, a Condition, a past or planned
     * procedure, etc. This should only be included if there is no focus or if it differs from the
     * reason indicated on the focus. Use the CodeableConcept text element in `Transport.reasonCode`
     * if the data is free (uncoded) text.
     */
    public var reason: CodeableReference.Builder? = null

    /** The transport event prior to this one. */
    public var history: Reference.Builder? = null

    override fun build(): Transport =
      Transport(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiatesCanonical = instantiatesCanonical?.build(),
        instantiatesUri = instantiatesUri?.build(),
        basedOn = basedOn.map { it.build() },
        groupIdentifier = groupIdentifier?.build(),
        partOf = partOf.map { it.build() },
        status = status,
        statusReason = statusReason?.build(),
        intent = intent,
        priority = priority,
        code = code?.build(),
        description = description?.build(),
        focus = focus?.build(),
        `for` = `for`?.build(),
        encounter = encounter?.build(),
        completionTime = completionTime?.build(),
        authoredOn = authoredOn?.build(),
        lastModified = lastModified?.build(),
        requester = requester?.build(),
        performerType = performerType.map { it.build() },
        owner = owner?.build(),
        location = location?.build(),
        insurance = insurance.map { it.build() },
        note = note.map { it.build() },
        relevantHistory = relevantHistory.map { it.build() },
        restriction = restriction?.build(),
        input = input.map { it.build() },
        output = output.map { it.build() },
        requestedLocation = requestedLocation.build(),
        currentLocation = currentLocation.build(),
        reason = reason?.build(),
        history = history?.build(),
      )
  }

  /** Status of the transport */
  public enum class TransportStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    In_Progress("in-progress", "http://hl7.org/fhir/transport-status", "In Progress"),
    Completed("completed", "http://hl7.org/fhir/transport-status", "Completed"),
    Abandoned("abandoned", "http://hl7.org/fhir/transport-status", "Abandoned"),
    Cancelled("cancelled", "http://hl7.org/fhir/transport-status", "Cancelled"),
    Planned("planned", "http://hl7.org/fhir/transport-status", "Planned"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/transport-status",
      "Entered In Error",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): TransportStatus =
        when (code) {
          "in-progress" -> In_Progress
          "completed" -> Completed
          "abandoned" -> Abandoned
          "cancelled" -> Cancelled
          "planned" -> Planned
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum TransportStatus")
        }
    }
  }

  /** Distinguishes whether the transport is a proposal, plan or full order. */
  public enum class TransportIntent(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Unknown("unknown", "http://hl7.org/fhir/transport-intent", "Unknown"),
    Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
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
      public fun fromCode(code: kotlin.String): TransportIntent =
        when (code) {
          "unknown" -> Unknown
          "proposal" -> Proposal
          "plan" -> Plan
          "order" -> Order
          "original-order" -> Original_Order
          "reflex-order" -> Reflex_Order
          "filler-order" -> Filler_Order
          "instance-order" -> Instance_Order
          "option" -> Option
          else -> throw IllegalArgumentException("Unknown code $code for enum TransportIntent")
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
