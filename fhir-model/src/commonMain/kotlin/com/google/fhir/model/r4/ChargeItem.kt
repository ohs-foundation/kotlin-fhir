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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.ChargeItemOccurrenceSerializer
import com.google.fhir.model.r4.serializers.ChargeItemPerformerSerializer
import com.google.fhir.model.r4.serializers.ChargeItemProductSerializer
import com.google.fhir.model.r4.serializers.ChargeItemSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The resource ChargeItem describes the provision of healthcare provider products for a certain
 * patient, therefore referring not only to the product, but containing in addition details of the
 * provision, like date, time, amounts and participating organizations and persons. Main Usage of
 * the ChargeItem is to enable the billing process and internal cost allocation.
 */
@Serializable(with = ChargeItemSerializer::class)
@SerialName("ChargeItem")
public data class ChargeItem(
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
  /** Identifiers assigned to this event performer or other systems. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * References the (external) source of pricing information, rules of application for the code this
   * ChargeItem uses.
   */
  public val definitionUri: List<Uri> = listOf(),
  /**
   * References the source of pricing information, rules of application for the code this ChargeItem
   * uses.
   */
  public val definitionCanonical: List<Canonical> = listOf(),
  /**
   * The current state of the ChargeItem.
   *
   * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
   * when the authoring system is not sure what the current status is.
   *
   * This element is labeled as a modifier because the status contains the code entered-in-error
   * that marks the charge item as not currently valid.
   */
  public val status: Enumeration<ChargeItemStatus>,
  /** ChargeItems can be grouped to larger ChargeItems covering the whole set. */
  public val partOf: List<Reference> = listOf(),
  /** A code that identifies the charge, like a billing code. */
  public val code: CodeableConcept,
  /** The individual or set of individuals the action is being or was performed on. */
  public val subject: Reference,
  /** The encounter or episode of care that establishes the context for this event. */
  public val context: Reference? = null,
  /**
   * Date/time(s) or duration when the charged service was applied.
   *
   * The list of types may be constrained as appropriate for the type of charge item.
   */
  public val occurrence: Occurrence? = null,
  /** Indicates who or what performed or participated in the charged service. */
  public val performer: List<Performer> = listOf(),
  /**
   * The organization requesting the service.
   *
   * Practitioners and Devices can be associated with multiple organizations. It has to be made
   * clear, on behalf of which Organization the services have been rendered.
   */
  public val performingOrganization: Reference? = null,
  /**
   * The organization performing the service.
   *
   * The rendered Service might not be associated with a Request. This property indicates which
   * Organization requested the services to be rendered. (In many cases, this may just be the
   * Department associated with the Encounter.location).
   */
  public val requestingOrganization: Reference? = null,
  /**
   * The financial cost center permits the tracking of charge attribution.
   *
   * The costCenter could either be given as a reference to an Organization(Role) resource or as the
   * identifier of the cost center determined by Reference.identifier.value and
   * Reference.identifier.system, depending on use case requirements.
   */
  public val costCenter: Reference? = null,
  /**
   * Quantity of which the charge item has been serviced.
   *
   * In many cases this may just be a value, if the underlying units are implicit in the definition
   * of the charge item code.
   */
  public val quantity: Quantity? = null,
  /**
   * The anatomical location where the related service has been applied.
   *
   * Only used if not implicit in code found in Condition.code. If the use case requires attributes
   * from the BodySite resource (e.g. to identify and track separately) then use the standard
   * extension [bodySite](extension-bodysite.html). May be a summary code, or a reference to a very
   * precise definition of the location, or both.
   */
  public val bodysite: List<CodeableConcept> = listOf(),
  /**
   * Factor overriding the factor determined by the rules associated with the code.
   *
   * There is no reason to carry the factor in the instance of a ChargeItem unless special
   * circumstances require a manual override. The factors are usually defined by a set of rules in a
   * back catalogue of the billing codes (see ChargeItem.definition). Derived profiles may require a
   * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
   */
  public val factorOverride: Decimal? = null,
  /**
   * Total price of the charge overriding the list price associated with the code.
   *
   * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
   * require a manual override. The list prices or are usually defined in a back catalogue of the
   * billing codes (see ChargeItem.definition). Derived profiles may require a
   * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
   */
  public val priceOverride: Money? = null,
  /**
   * If the list price or the rule-based factor associated with the code is overridden, this
   * attribute can capture a text to indicate the reason for this action.
   *
   * Derived Profiles may choose to add invariants requiring this field to be populated if either
   * priceOverride or factorOverride have been filled.
   */
  public val overrideReason: String? = null,
  /**
   * The device, practitioner, etc. who entered the charge item.
   *
   * The enterer is also the person considered responsible for factor/price overrides if applicable.
   */
  public val enterer: Reference? = null,
  /**
   * Date the charge item was entered.
   *
   * The actual date when the service associated with the charge has been rendered is captured in
   * occurrence[x].
   */
  public val enteredDate: DateTime? = null,
  /**
   * Describes why the event occurred in coded or textual form.
   *
   * If the application of the charge item requires a reason to be given, it can be captured here.
   * Textual reasons can be captured using reasonCode.text.
   */
  public val reason: List<CodeableConcept> = listOf(),
  /** Indicated the rendered service that caused this charge. */
  public val service: List<Reference> = listOf(),
  /**
   * Identifies the device, food, drug or other product being charged either by type code or
   * reference to an instance.
   */
  public val product: Product? = null,
  /**
   * Account into which this ChargeItems belongs.
   *
   * Systems posting the ChargeItems might not always be able to determine, which accounts the Items
   * need to be places into. It is up to the postprocessing Financial System to apply internal rules
   * to decide based on the Encounter/EpisodeOfCare/Patient/Coverage context and the type of
   * ChargeItem, which Account is appropriate.
   */
  public val account: List<Reference> = listOf(),
  /** Comments made about the event by the performer, subject or other participants. */
  public val note: List<Annotation> = listOf(),
  /** Further information supporting this charge. */
  public val supportingInformation: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, code.toBuilder(), subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        definitionUri = this@with.definitionUri.map { it.toBuilder() }.toMutableList()
        definitionCanonical = this@with.definitionCanonical.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        context = this@with.context?.toBuilder()
        occurrence = this@with.occurrence
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        performingOrganization = this@with.performingOrganization?.toBuilder()
        requestingOrganization = this@with.requestingOrganization?.toBuilder()
        costCenter = this@with.costCenter?.toBuilder()
        quantity = this@with.quantity?.toBuilder()
        bodysite = this@with.bodysite.map { it.toBuilder() }.toMutableList()
        factorOverride = this@with.factorOverride?.toBuilder()
        priceOverride = this@with.priceOverride?.toBuilder()
        overrideReason = this@with.overrideReason?.toBuilder()
        enterer = this@with.enterer?.toBuilder()
        enteredDate = this@with.enteredDate?.toBuilder()
        reason = this@with.reason.map { it.toBuilder() }.toMutableList()
        service = this@with.service.map { it.toBuilder() }.toMutableList()
        product = this@with.product
        account = this@with.account.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        supportingInformation =
          this@with.supportingInformation.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Indicates who or what performed or participated in the charged service. */
  @Serializable(with = ChargeItemPerformerSerializer::class)
  public data class Performer(
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
     * Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest,
     * etc.).
     */
    public val function: CodeableConcept? = null,
    /** The device, practitioner, etc. who performed or participated in the service. */
    public val actor: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(actor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function?.toBuilder()
        }
      }

    public class Builder(
      /** The device, practitioner, etc. who performed or participated in the service. */
      public var actor: Reference.Builder
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
       * Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest,
       * etc.).
       */
      public var function: CodeableConcept.Builder? = null

      public fun build(): Performer =
        Performer(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  @Serializable(with = ChargeItemOccurrenceSerializer::class)
  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public fun asTiming(): Timing? = this as? Timing

    public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : Occurrence

    public data class Period(public val `value`: com.google.fhir.model.r4.Period) : Occurrence

    public data class Timing(public val `value`: com.google.fhir.model.r4.Timing) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: com.google.fhir.model.r4.DateTime?,
        periodValue: com.google.fhir.model.r4.Period?,
        timingValue: com.google.fhir.model.r4.Timing?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        if (timingValue != null) return Timing(timingValue)
        return null
      }
    }
  }

  @Serializable(with = ChargeItemProductSerializer::class)
  public sealed interface Product {
    public fun asReference(): Reference? = this as? Reference

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) : Product

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4.CodeableConcept
    ) : Product

    public companion object {
      internal fun from(
        referenceValue: com.google.fhir.model.r4.Reference?,
        codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
      ): Product? {
        if (referenceValue != null) return Reference(referenceValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The current state of the ChargeItem.
     *
     * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
     * when the authoring system is not sure what the current status is.
     *
     * This element is labeled as a modifier because the status contains the code entered-in-error
     * that marks the charge item as not currently valid.
     */
    public var status: Enumeration<ChargeItemStatus>,
    /** A code that identifies the charge, like a billing code. */
    public var code: CodeableConcept.Builder,
    /** The individual or set of individuals the action is being or was performed on. */
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

    /** Identifiers assigned to this event performer or other systems. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * References the (external) source of pricing information, rules of application for the code
     * this ChargeItem uses.
     */
    public var definitionUri: MutableList<Uri.Builder> = mutableListOf()

    /**
     * References the source of pricing information, rules of application for the code this
     * ChargeItem uses.
     */
    public var definitionCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /** ChargeItems can be grouped to larger ChargeItems covering the whole set. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /** The encounter or episode of care that establishes the context for this event. */
    public var context: Reference.Builder? = null

    /**
     * Date/time(s) or duration when the charged service was applied.
     *
     * The list of types may be constrained as appropriate for the type of charge item.
     */
    public var occurrence: Occurrence? = null

    /** Indicates who or what performed or participated in the charged service. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /**
     * The organization requesting the service.
     *
     * Practitioners and Devices can be associated with multiple organizations. It has to be made
     * clear, on behalf of which Organization the services have been rendered.
     */
    public var performingOrganization: Reference.Builder? = null

    /**
     * The organization performing the service.
     *
     * The rendered Service might not be associated with a Request. This property indicates which
     * Organization requested the services to be rendered. (In many cases, this may just be the
     * Department associated with the Encounter.location).
     */
    public var requestingOrganization: Reference.Builder? = null

    /**
     * The financial cost center permits the tracking of charge attribution.
     *
     * The costCenter could either be given as a reference to an Organization(Role) resource or as
     * the identifier of the cost center determined by Reference.identifier.value and
     * Reference.identifier.system, depending on use case requirements.
     */
    public var costCenter: Reference.Builder? = null

    /**
     * Quantity of which the charge item has been serviced.
     *
     * In many cases this may just be a value, if the underlying units are implicit in the
     * definition of the charge item code.
     */
    public var quantity: Quantity.Builder? = null

    /**
     * The anatomical location where the related service has been applied.
     *
     * Only used if not implicit in code found in Condition.code. If the use case requires
     * attributes from the BodySite resource (e.g. to identify and track separately) then use the
     * standard extension [bodySite](extension-bodysite.html). May be a summary code, or a reference
     * to a very precise definition of the location, or both.
     */
    public var bodysite: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Factor overriding the factor determined by the rules associated with the code.
     *
     * There is no reason to carry the factor in the instance of a ChargeItem unless special
     * circumstances require a manual override. The factors are usually defined by a set of rules in
     * a back catalogue of the billing codes (see ChargeItem.definition). Derived profiles may
     * require a ChargeItem.overrideReason to be provided if either factor or price are manually
     * overridden.
     */
    public var factorOverride: Decimal.Builder? = null

    /**
     * Total price of the charge overriding the list price associated with the code.
     *
     * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
     * require a manual override. The list prices or are usually defined in a back catalogue of the
     * billing codes (see ChargeItem.definition). Derived profiles may require a
     * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
     */
    public var priceOverride: Money.Builder? = null

    /**
     * If the list price or the rule-based factor associated with the code is overridden, this
     * attribute can capture a text to indicate the reason for this action.
     *
     * Derived Profiles may choose to add invariants requiring this field to be populated if either
     * priceOverride or factorOverride have been filled.
     */
    public var overrideReason: String.Builder? = null

    /**
     * The device, practitioner, etc. who entered the charge item.
     *
     * The enterer is also the person considered responsible for factor/price overrides if
     * applicable.
     */
    public var enterer: Reference.Builder? = null

    /**
     * Date the charge item was entered.
     *
     * The actual date when the service associated with the charge has been rendered is captured in
     * occurrence[x].
     */
    public var enteredDate: DateTime.Builder? = null

    /**
     * Describes why the event occurred in coded or textual form.
     *
     * If the application of the charge item requires a reason to be given, it can be captured here.
     * Textual reasons can be captured using reasonCode.text.
     */
    public var reason: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicated the rendered service that caused this charge. */
    public var service: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies the device, food, drug or other product being charged either by type code or
     * reference to an instance.
     */
    public var product: Product? = null

    /**
     * Account into which this ChargeItems belongs.
     *
     * Systems posting the ChargeItems might not always be able to determine, which accounts the
     * Items need to be places into. It is up to the postprocessing Financial System to apply
     * internal rules to decide based on the Encounter/EpisodeOfCare/Patient/Coverage context and
     * the type of ChargeItem, which Account is appropriate.
     */
    public var account: MutableList<Reference.Builder> = mutableListOf()

    /** Comments made about the event by the performer, subject or other participants. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Further information supporting this charge. */
    public var supportingInformation: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): ChargeItem =
      ChargeItem(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        definitionUri = definitionUri.map { it.build() },
        definitionCanonical = definitionCanonical.map { it.build() },
        status = status,
        partOf = partOf.map { it.build() },
        code = code.build(),
        subject = subject.build(),
        context = context?.build(),
        occurrence = occurrence,
        performer = performer.map { it.build() },
        performingOrganization = performingOrganization?.build(),
        requestingOrganization = requestingOrganization?.build(),
        costCenter = costCenter?.build(),
        quantity = quantity?.build(),
        bodysite = bodysite.map { it.build() },
        factorOverride = factorOverride?.build(),
        priceOverride = priceOverride?.build(),
        overrideReason = overrideReason?.build(),
        enterer = enterer?.build(),
        enteredDate = enteredDate?.build(),
        reason = reason.map { it.build() },
        service = service.map { it.build() },
        product = product,
        account = account.map { it.build() },
        note = note.map { it.build() },
        supportingInformation = supportingInformation.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of a ChargeItem. */
  public enum class ChargeItemStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Planned("planned", "http://hl7.org/fhir/chargeitem-status", "Planned"),
    Billable("billable", "http://hl7.org/fhir/chargeitem-status", "Billable"),
    Not_Billable("not-billable", "http://hl7.org/fhir/chargeitem-status", "Not billable"),
    Aborted("aborted", "http://hl7.org/fhir/chargeitem-status", "Aborted"),
    Billed("billed", "http://hl7.org/fhir/chargeitem-status", "Billed"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/chargeitem-status",
      "Entered in Error",
    ),
    Unknown("unknown", "http://hl7.org/fhir/chargeitem-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ChargeItemStatus =
        when (code) {
          "planned" -> Planned
          "billable" -> Billable
          "not-billable" -> Not_Billable
          "aborted" -> Aborted
          "billed" -> Billed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum ChargeItemStatus")
        }
    }
  }
}
