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

import dev.ohs.fhir.model.r4.serializers.InvoiceLineItemPriceComponentSerializer
import dev.ohs.fhir.model.r4.serializers.InvoiceLineItemSerializer
import dev.ohs.fhir.model.r4.serializers.InvoiceParticipantSerializer
import dev.ohs.fhir.model.r4.serializers.InvoiceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Invoice containing collected ChargeItems from an Account with calculated individual and total
 * price for Billing purpose.
 */
@Serializable(with = InvoiceSerializer::class)
@SerialName("Invoice")
public data class Invoice(
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
   * Identifier of this Invoice, often used for reference in correspondence about this invoice or
   * for tracking of payments.
   */
  public val identifier: List<Identifier> = listOf(),
  /** The current state of the Invoice. */
  public val status: Enumeration<InvoiceStatus>,
  /**
   * In case of Invoice cancellation a reason must be given (entered in error, superseded by
   * corrected invoice etc.).
   *
   * Derived Profiles may choose to add invariants requiring this field to be populated if either
   * priceOverride or factorOverride have been filled.
   */
  public val cancelledReason: String? = null,
  /**
   * Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental,
   * preliminary).
   */
  public val type: CodeableConcept? = null,
  /**
   * The individual or set of individuals receiving the goods and services billed in this invoice.
   */
  public val subject: Reference? = null,
  /** The individual or Organization responsible for balancing of this invoice. */
  public val recipient: Reference? = null,
  /**
   * Date/time(s) of when this Invoice was posted.
   *
   * The list of types may be constrained as appropriate for the type of charge item.
   */
  public val date: DateTime? = null,
  /** Indicates who or what performed or participated in the charged service. */
  public val participant: List<Participant> = listOf(),
  /**
   * The organizationissuing the Invoice.
   *
   * Practitioners and Devices can be associated with multiple organizations. It has to be made
   * clear, on behalf of which Organization the services have been rendered.
   */
  public val issuer: Reference? = null,
  /**
   * Account which is supposed to be balanced with this Invoice.
   *
   * Systems posting the ChargeItems might not always be able to determine, which accounts the Items
   * need to be places into. It is up to the potprocessing Financial System to apply internal rules
   * to decide based on the Encounter/EpisodeOfCare/Patient/Coverage context and the type of
   * ChargeItem, which Account is appropriate.
   */
  public val account: Reference? = null,
  /**
   * Each line item represents one charge for goods and services rendered. Details such as date,
   * code and amount are found in the referenced ChargeItem resource.
   */
  public val lineItem: List<LineItem> = listOf(),
  /**
   * The total amount for the Invoice may be calculated as the sum of the line items with
   * surcharges/deductions that apply in certain conditions. The priceComponent element can be used
   * to offer transparency to the recipient of the Invoice of how the total price was calculated.
   */
  public val totalPriceComponent: List<LineItem.PriceComponent> = listOf(),
  /**
   * Invoice total , taxes excluded.
   *
   * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
   * require a manual override. The list prices or are usually defined in a back catalogue of the
   * billing codes (see ChargeItem.definition). Derived profiles may require a
   * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
   */
  public val totalNet: Money? = null,
  /**
   * Invoice total, tax included.
   *
   * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
   * require a manual override. The list prices or are usually defined in a back catalogue of the
   * billing codes (see ChargeItem.definition). Derived profiles may require a
   * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
   */
  public val totalGross: Money? = null,
  /**
   * Payment details such as banking details, period of payment, deductibles, methods of payment.
   *
   * Derived Profiles may chose to add invariants requiring this field to be populated if either
   * priceOverride or factorOverride have been filled.
   */
  public val paymentTerms: Markdown? = null,
  /** Comments made about the invoice by the issuer, subject, or other participants. */
  public val note: List<Annotation> = listOf(),
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
        cancelledReason = this@with.cancelledReason?.toBuilder()
        type = this@with.type?.toBuilder()
        subject = this@with.subject?.toBuilder()
        recipient = this@with.recipient?.toBuilder()
        date = this@with.date?.toBuilder()
        participant = this@with.participant.map { it.toBuilder() }.toMutableList()
        issuer = this@with.issuer?.toBuilder()
        account = this@with.account?.toBuilder()
        lineItem = this@with.lineItem.map { it.toBuilder() }.toMutableList()
        totalPriceComponent = this@with.totalPriceComponent.map { it.toBuilder() }.toMutableList()
        totalNet = this@with.totalNet?.toBuilder()
        totalGross = this@with.totalGross?.toBuilder()
        paymentTerms = this@with.paymentTerms?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Indicates who or what performed or participated in the charged service. */
  @Serializable(with = InvoiceParticipantSerializer::class)
  public data class Participant(
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
     * Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has
     * been created automatically, the Participant may be a billing engine or another kind of
     * device.
     */
    public val role: CodeableConcept? = null,
    /** The device, practitioner, etc. who performed or participated in the service. */
    public val actor: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(actor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          role = this@with.role?.toBuilder()
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
       * Describes the type of involvement (e.g. transcriptionist, creator etc.). If the invoice has
       * been created automatically, the Participant may be a billing engine or another kind of
       * device.
       */
      public var role: CodeableConcept.Builder? = null

      public fun build(): Participant =
        Participant(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          role = role?.build(),
          actor = actor.build(),
        )
    }
  }

  /**
   * Each line item represents one charge for goods and services rendered. Details such as date,
   * code and amount are found in the referenced ChargeItem resource.
   */
  @Serializable(with = InvoiceLineItemSerializer::class)
  public data class LineItem(
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
    /** Sequence in which the items appear on the invoice. */
    public val sequence: PositiveInt? = null,
    /**
     * The ChargeItem contains information such as the billing code, date, amount etc. If no further
     * details are required for the lineItem, inline billing codes can be added using the
     * CodeableConcept data type instead of the Reference.
     */
    public val chargeItem: ChargeItem,
    /**
     * The price for a ChargeItem may be calculated as a base price with surcharges/deductions that
     * apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors
     * and conditions that apply to a billing code is currently under development. The
     * priceComponent element can be used to offer transparency to the recipient of the Invoice as
     * to how the prices have been calculated.
     */
    public val priceComponent: List<PriceComponent> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(chargeItem).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          sequence = this@with.sequence?.toBuilder()
          priceComponent = this@with.priceComponent.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * The price for a ChargeItem may be calculated as a base price with surcharges/deductions that
     * apply in certain conditions. A ChargeItemDefinition resource that defines the prices, factors
     * and conditions that apply to a billing code is currently under development. The
     * priceComponent element can be used to offer transparency to the recipient of the Invoice as
     * to how the prices have been calculated.
     */
    @Serializable(with = InvoiceLineItemPriceComponentSerializer::class)
    public data class PriceComponent(
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
      /** This code identifies the type of the component. */
      public val type: Enumeration<InvoicePriceComponentType>,
      /**
       * A code that identifies the component. Codes may be used to differentiate between kinds of
       * taxes, surcharges, discounts etc.
       */
      public val code: CodeableConcept? = null,
      /**
       * The factor that has been applied on the base price for calculating this component.
       *
       * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
       * require a manual override. The list prices or are usually defined in a back catalogue of
       * the billing codes (see ChargeItem.definition). Derived profiles may require a
       * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
       */
      public val factor: Decimal? = null,
      /**
       * The amount calculated for this component.
       *
       * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
       * require a manual override. The list prices or are usually defined in a back catalogue of
       * the billing codes (see ChargeItem.definition). Derived profiles may require a
       * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
       */
      public val amount: Money? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            code = this@with.code?.toBuilder()
            factor = this@with.factor?.toBuilder()
            amount = this@with.amount?.toBuilder()
          }
        }

      public class Builder(
        /** This code identifies the type of the component. */
        public var type: Enumeration<InvoicePriceComponentType>
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
         * A code that identifies the component. Codes may be used to differentiate between kinds of
         * taxes, surcharges, discounts etc.
         */
        public var code: CodeableConcept.Builder? = null

        /**
         * The factor that has been applied on the base price for calculating this component.
         *
         * There is no reason to carry the price in the instance of a ChargeItem unless
         * circumstances require a manual override. The list prices or are usually defined in a back
         * catalogue of the billing codes (see ChargeItem.definition). Derived profiles may require
         * a ChargeItem.overrideReason to be provided if either factor or price are manually
         * overridden.
         */
        public var factor: Decimal.Builder? = null

        /**
         * The amount calculated for this component.
         *
         * There is no reason to carry the price in the instance of a ChargeItem unless
         * circumstances require a manual override. The list prices or are usually defined in a back
         * catalogue of the billing codes (see ChargeItem.definition). Derived profiles may require
         * a ChargeItem.overrideReason to be provided if either factor or price are manually
         * overridden.
         */
        public var amount: Money.Builder? = null

        public fun build(): PriceComponent =
          PriceComponent(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type,
            code = code?.build(),
            factor = factor?.build(),
            amount = amount?.build(),
          )
      }
    }

    public sealed interface ChargeItem {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : ChargeItem

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
        ChargeItem

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
        ): ChargeItem? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The ChargeItem contains information such as the billing code, date, amount etc. If no
       * further details are required for the lineItem, inline billing codes can be added using the
       * CodeableConcept data type instead of the Reference.
       */
      public var chargeItem: ChargeItem
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

      /** Sequence in which the items appear on the invoice. */
      public var sequence: PositiveInt.Builder? = null

      /**
       * The price for a ChargeItem may be calculated as a base price with surcharges/deductions
       * that apply in certain conditions. A ChargeItemDefinition resource that defines the prices,
       * factors and conditions that apply to a billing code is currently under development. The
       * priceComponent element can be used to offer transparency to the recipient of the Invoice as
       * to how the prices have been calculated.
       */
      public var priceComponent: MutableList<PriceComponent.Builder> = mutableListOf()

      public fun build(): LineItem =
        LineItem(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          sequence = sequence?.build(),
          chargeItem = chargeItem,
          priceComponent = priceComponent.map { it.build() },
        )
    }
  }

  public class Builder(
    /** The current state of the Invoice. */
    public var status: Enumeration<InvoiceStatus>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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
     * Identifier of this Invoice, often used for reference in correspondence about this invoice or
     * for tracking of payments.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * In case of Invoice cancellation a reason must be given (entered in error, superseded by
     * corrected invoice etc.).
     *
     * Derived Profiles may choose to add invariants requiring this field to be populated if either
     * priceOverride or factorOverride have been filled.
     */
    public var cancelledReason: String.Builder? = null

    /**
     * Type of Invoice depending on domain, realm an usage (e.g. internal/external, dental,
     * preliminary).
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * The individual or set of individuals receiving the goods and services billed in this invoice.
     */
    public var subject: Reference.Builder? = null

    /** The individual or Organization responsible for balancing of this invoice. */
    public var recipient: Reference.Builder? = null

    /**
     * Date/time(s) of when this Invoice was posted.
     *
     * The list of types may be constrained as appropriate for the type of charge item.
     */
    public var date: DateTime.Builder? = null

    /** Indicates who or what performed or participated in the charged service. */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /**
     * The organizationissuing the Invoice.
     *
     * Practitioners and Devices can be associated with multiple organizations. It has to be made
     * clear, on behalf of which Organization the services have been rendered.
     */
    public var issuer: Reference.Builder? = null

    /**
     * Account which is supposed to be balanced with this Invoice.
     *
     * Systems posting the ChargeItems might not always be able to determine, which accounts the
     * Items need to be places into. It is up to the potprocessing Financial System to apply
     * internal rules to decide based on the Encounter/EpisodeOfCare/Patient/Coverage context and
     * the type of ChargeItem, which Account is appropriate.
     */
    public var account: Reference.Builder? = null

    /**
     * Each line item represents one charge for goods and services rendered. Details such as date,
     * code and amount are found in the referenced ChargeItem resource.
     */
    public var lineItem: MutableList<LineItem.Builder> = mutableListOf()

    /**
     * The total amount for the Invoice may be calculated as the sum of the line items with
     * surcharges/deductions that apply in certain conditions. The priceComponent element can be
     * used to offer transparency to the recipient of the Invoice of how the total price was
     * calculated.
     */
    public var totalPriceComponent: MutableList<LineItem.PriceComponent.Builder> = mutableListOf()

    /**
     * Invoice total , taxes excluded.
     *
     * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
     * require a manual override. The list prices or are usually defined in a back catalogue of the
     * billing codes (see ChargeItem.definition). Derived profiles may require a
     * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
     */
    public var totalNet: Money.Builder? = null

    /**
     * Invoice total, tax included.
     *
     * There is no reason to carry the price in the instance of a ChargeItem unless circumstances
     * require a manual override. The list prices or are usually defined in a back catalogue of the
     * billing codes (see ChargeItem.definition). Derived profiles may require a
     * ChargeItem.overrideReason to be provided if either factor or price are manually overridden.
     */
    public var totalGross: Money.Builder? = null

    /**
     * Payment details such as banking details, period of payment, deductibles, methods of payment.
     *
     * Derived Profiles may chose to add invariants requiring this field to be populated if either
     * priceOverride or factorOverride have been filled.
     */
    public var paymentTerms: Markdown.Builder? = null

    /** Comments made about the invoice by the issuer, subject, or other participants. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): Invoice =
      Invoice(
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
        cancelledReason = cancelledReason?.build(),
        type = type?.build(),
        subject = subject?.build(),
        recipient = recipient?.build(),
        date = date?.build(),
        participant = participant.map { it.build() },
        issuer = issuer?.build(),
        account = account?.build(),
        lineItem = lineItem.map { it.build() },
        totalPriceComponent = totalPriceComponent.map { it.build() },
        totalNet = totalNet?.build(),
        totalGross = totalGross?.build(),
        paymentTerms = paymentTerms?.build(),
        note = note.map { it.build() },
      )
  }

  /** Codes indicating the kind of the price component. */
  public enum class InvoicePriceComponentType(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Base("base", "http://hl7.org/fhir/invoice-priceComponentType", "base price"),
    Surcharge("surcharge", "http://hl7.org/fhir/invoice-priceComponentType", "surcharge"),
    Deduction("deduction", "http://hl7.org/fhir/invoice-priceComponentType", "deduction"),
    Discount("discount", "http://hl7.org/fhir/invoice-priceComponentType", "discount"),
    Tax("tax", "http://hl7.org/fhir/invoice-priceComponentType", "tax"),
    Informational(
      "informational",
      "http://hl7.org/fhir/invoice-priceComponentType",
      "informational",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): InvoicePriceComponentType =
        when (code) {
          "base" -> Base
          "surcharge" -> Surcharge
          "deduction" -> Deduction
          "discount" -> Discount
          "tax" -> Tax
          "informational" -> Informational
          else ->
            throw IllegalArgumentException("Unknown code $code for enum InvoicePriceComponentType")
        }
    }
  }

  /** Codes identifying the lifecycle stage of an Invoice. */
  public enum class InvoiceStatus(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Draft("draft", "http://hl7.org/fhir/invoice-status", "draft"),
    Issued("issued", "http://hl7.org/fhir/invoice-status", "issued"),
    Balanced("balanced", "http://hl7.org/fhir/invoice-status", "balanced"),
    Cancelled("cancelled", "http://hl7.org/fhir/invoice-status", "cancelled"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/invoice-status", "entered in error");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): InvoiceStatus =
        when (code) {
          "draft" -> Draft
          "issued" -> Issued
          "balanced" -> Balanced
          "cancelled" -> Cancelled
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum InvoiceStatus")
        }
    }
  }
}
