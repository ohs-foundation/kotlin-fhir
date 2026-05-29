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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionPropertySerializer
import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionRouteOfAdministrationSerializer
import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer
import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
import dev.ohs.fhir.model.r4b.serializers.AdministrableProductDefinitionSerializer
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A medicinal product in the final form which is suitable for administering to a patient (after any
 * mixing of multiple components, dissolution etc. has been performed).
 */
@Serializable(with = AdministrableProductDefinitionSerializer::class)
@SerialName("AdministrableProductDefinition")
public data class AdministrableProductDefinition(
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
  /** An identifier for the administrable product. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status of this administrable product. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of administrable products that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * References a product from which one or more of the constituent parts of that product can be
   * prepared and used as described by this administrable product. If this administrable product
   * describes the administration of a crushed tablet, the 'formOf' would be the product
   * representing a distribution containing tablets and possibly also a cream. This is distinct from
   * the 'producedFrom' which refers to the specific components of the product that are used in this
   * preparation, rather than the product as a whole.
   */
  public val formOf: List<Reference> = listOf(),
  /**
   * The dose form of the final product after necessary reconstitution or processing. Contrasts to
   * the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was
   * 'powder for solution for injection', the administrable dose form could be 'solution for
   * injection' (once mixed with another item having manufactured form 'solvent for solution for
   * injection').
   */
  public val administrableDoseForm: CodeableConcept? = null,
  /**
   * The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as
   * in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').
   */
  public val unitOfPresentation: CodeableConcept? = null,
  /**
   * Indicates the specific manufactured items that are part of the 'formOf' product that are used
   * in the preparation of this specific administrable form. In some cases, an administrable form
   * might use all of the items from the overall product (or there might only be one item), while in
   * other cases, an administrable form might use only a subset of the items available in the
   * overall product. For example, an administrable form might involve combining a liquid and a
   * powder available as part of an overall product, but not involve applying the also supplied
   * cream.
   */
  public val producedFrom: List<Reference> = listOf(),
  /**
   * The ingredients of this administrable medicinal product. This is only needed if the ingredients
   * are not specified either using ManufacturedItemDefiniton (via
   * AdministrableProductDefinition.producedFrom) to state which component items are used to make
   * this, or using by incoming references from the Ingredient resource, to state in detail which
   * substances exist within this. This element allows a basic coded ingredient to be used.
   */
  public val ingredient: List<CodeableConcept> = listOf(),
  /**
   * A device that is integral to the medicinal product, in effect being considered as an
   * "ingredient" of the medicinal product. This is not intended for devices that are just
   * co-packaged.
   */
  public val device: Reference? = null,
  /** Characteristics e.g. a product's onset of action. */
  public val `property`: List<Property> = listOf(),
  /**
   * The path by which the product is taken into or makes contact with the body. In some regions
   * this is referred to as the licenced or approved route. RouteOfAdministration cannot be used
   * when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).
   */
  public val routeOfAdministration: List<RouteOfAdministration>,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, routeOfAdministration.map { it.toBuilder() }.toMutableList()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        formOf = this@with.formOf.map { it.toBuilder() }.toMutableList()
        administrableDoseForm = this@with.administrableDoseForm?.toBuilder()
        unitOfPresentation = this@with.unitOfPresentation?.toBuilder()
        producedFrom = this@with.producedFrom.map { it.toBuilder() }.toMutableList()
        ingredient = this@with.ingredient.map { it.toBuilder() }.toMutableList()
        device = this@with.device?.toBuilder()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Characteristics e.g. a product's onset of action. */
  @Serializable(with = AdministrableProductDefinitionPropertySerializer::class)
  public data class Property(
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
    /** A code expressing the type of characteristic. */
    public val type: CodeableConcept,
    /** A value for the characteristic. */
    public val `value`: Value? = null,
    /** The status of characteristic e.g. assigned or pending. */
    public val status: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          `value` = this@with.`value`
          status = this@with.status?.toBuilder()
        }
      }

    public sealed interface Value {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asDate(): Date? = this as? Date

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asAttachment(): Attachment? = this as? Attachment

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
      ) : Value

      @JvmInline
      public value class Quantity(public val `value`: dev.ohs.fhir.model.r4b.Quantity) : Value

      @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r4b.Date) : Value

      @JvmInline
      public value class Boolean(public val `value`: dev.ohs.fhir.model.r4b.Boolean) : Value

      @JvmInline
      public value class Attachment(public val `value`: dev.ohs.fhir.model.r4b.Attachment) : Value

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
          quantityValue: dev.ohs.fhir.model.r4b.Quantity?,
          dateValue: dev.ohs.fhir.model.r4b.Date?,
          booleanValue: dev.ohs.fhir.model.r4b.Boolean?,
          attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
        ): Value? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (dateValue != null) return Date(dateValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          return null
        }
      }
    }

    public class Builder(
      /** A code expressing the type of characteristic. */
      public var type: CodeableConcept.Builder
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

      /** A value for the characteristic. */
      public var `value`: Value? = null

      /** The status of characteristic e.g. assigned or pending. */
      public var status: CodeableConcept.Builder? = null

      public fun build(): Property =
        Property(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `value` = `value`,
          status = status?.build(),
        )
    }
  }

  /**
   * The path by which the product is taken into or makes contact with the body. In some regions
   * this is referred to as the licenced or approved route. RouteOfAdministration cannot be used
   * when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).
   */
  @Serializable(with = AdministrableProductDefinitionRouteOfAdministrationSerializer::class)
  public data class RouteOfAdministration(
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
    /** Coded expression for the route. */
    public val code: CodeableConcept,
    /**
     * The first dose (dose quantity) administered can be specified for the product, using a
     * numerical value and its unit of measurement.
     */
    public val firstDose: Quantity? = null,
    /**
     * The maximum single dose that can be administered, specified using a numerical value and its
     * unit of measurement.
     */
    public val maxSingleDose: Quantity? = null,
    /**
     * The maximum dose per day (maximum dose quantity to be administered in any one 24-h period)
     * that can be administered.
     */
    public val maxDosePerDay: Quantity? = null,
    /** The maximum dose per treatment period that can be administered. */
    public val maxDosePerTreatmentPeriod: Ratio? = null,
    /** The maximum treatment period during which the product can be administered. */
    public val maxTreatmentPeriod: Duration? = null,
    /** A species for which this route applies. */
    public val targetSpecies: List<TargetSpecies> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          firstDose = this@with.firstDose?.toBuilder()
          maxSingleDose = this@with.maxSingleDose?.toBuilder()
          maxDosePerDay = this@with.maxDosePerDay?.toBuilder()
          maxDosePerTreatmentPeriod = this@with.maxDosePerTreatmentPeriod?.toBuilder()
          maxTreatmentPeriod = this@with.maxTreatmentPeriod?.toBuilder()
          targetSpecies = this@with.targetSpecies.map { it.toBuilder() }.toMutableList()
        }
      }

    /** A species for which this route applies. */
    @Serializable(
      with = AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer::class
    )
    public data class TargetSpecies(
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
      /** Coded expression for the species. */
      public val code: CodeableConcept,
      /** A species specific time during which consumption of animal product is not appropriate. */
      public val withdrawalPeriod: List<WithdrawalPeriod> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(code.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            withdrawalPeriod = this@with.withdrawalPeriod.map { it.toBuilder() }.toMutableList()
          }
        }

      /** A species specific time during which consumption of animal product is not appropriate. */
      @Serializable(
        with =
          AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer::class
      )
      public data class WithdrawalPeriod(
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
         * Coded expression for the type of tissue for which the withdrawal period applies, e.g.
         * meat, milk.
         */
        public val tissue: CodeableConcept,
        /** A value for the time. */
        public val `value`: Quantity,
        /** Extra information about the withdrawal period. */
        public val supportingInformation: String? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(tissue.toBuilder(), `value`.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              supportingInformation = this@with.supportingInformation?.toBuilder()
            }
          }

        public class Builder(
          /**
           * Coded expression for the type of tissue for which the withdrawal period applies, e.g.
           * meat, milk.
           */
          public var tissue: CodeableConcept.Builder,
          /** A value for the time. */
          public var `value`: Quantity.Builder,
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

          /** Extra information about the withdrawal period. */
          public var supportingInformation: String.Builder? = null

          public fun build(): WithdrawalPeriod =
            WithdrawalPeriod(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              tissue = tissue.build(),
              `value` = `value`.build(),
              supportingInformation = supportingInformation?.build(),
            )
        }
      }

      public class Builder(
        /** Coded expression for the species. */
        public var code: CodeableConcept.Builder
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
         * A species specific time during which consumption of animal product is not appropriate.
         */
        public var withdrawalPeriod: MutableList<WithdrawalPeriod.Builder> = mutableListOf()

        public fun build(): TargetSpecies =
          TargetSpecies(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code.build(),
            withdrawalPeriod = withdrawalPeriod.map { it.build() },
          )
      }
    }

    public class Builder(
      /** Coded expression for the route. */
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
       * The first dose (dose quantity) administered can be specified for the product, using a
       * numerical value and its unit of measurement.
       */
      public var firstDose: Quantity.Builder? = null

      /**
       * The maximum single dose that can be administered, specified using a numerical value and its
       * unit of measurement.
       */
      public var maxSingleDose: Quantity.Builder? = null

      /**
       * The maximum dose per day (maximum dose quantity to be administered in any one 24-h period)
       * that can be administered.
       */
      public var maxDosePerDay: Quantity.Builder? = null

      /** The maximum dose per treatment period that can be administered. */
      public var maxDosePerTreatmentPeriod: Ratio.Builder? = null

      /** The maximum treatment period during which the product can be administered. */
      public var maxTreatmentPeriod: Duration.Builder? = null

      /** A species for which this route applies. */
      public var targetSpecies: MutableList<TargetSpecies.Builder> = mutableListOf()

      public fun build(): RouteOfAdministration =
        RouteOfAdministration(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.build(),
          firstDose = firstDose?.build(),
          maxSingleDose = maxSingleDose?.build(),
          maxDosePerDay = maxDosePerDay?.build(),
          maxDosePerTreatmentPeriod = maxDosePerTreatmentPeriod?.build(),
          maxTreatmentPeriod = maxTreatmentPeriod?.build(),
          targetSpecies = targetSpecies.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of this administrable product. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of administrable products that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * The path by which the product is taken into or makes contact with the body. In some regions
     * this is referred to as the licenced or approved route. RouteOfAdministration cannot be used
     * when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).
     */
    public var routeOfAdministration: MutableList<RouteOfAdministration.Builder>,
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

    /** An identifier for the administrable product. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * References a product from which one or more of the constituent parts of that product can be
     * prepared and used as described by this administrable product. If this administrable product
     * describes the administration of a crushed tablet, the 'formOf' would be the product
     * representing a distribution containing tablets and possibly also a cream. This is distinct
     * from the 'producedFrom' which refers to the specific components of the product that are used
     * in this preparation, rather than the product as a whole.
     */
    public var formOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The dose form of the final product after necessary reconstitution or processing. Contrasts to
     * the manufactured dose form (see ManufacturedItemDefinition). If the manufactured form was
     * 'powder for solution for injection', the administrable dose form could be 'solution for
     * injection' (once mixed with another item having manufactured form 'solvent for solution for
     * injection').
     */
    public var administrableDoseForm: CodeableConcept.Builder? = null

    /**
     * The presentation type in which this item is given to a patient. e.g. for a spray - 'puff' (as
     * in 'contains 100 mcg per puff'), or for a liquid - 'vial' (as in 'contains 5 ml per vial').
     */
    public var unitOfPresentation: CodeableConcept.Builder? = null

    /**
     * Indicates the specific manufactured items that are part of the 'formOf' product that are used
     * in the preparation of this specific administrable form. In some cases, an administrable form
     * might use all of the items from the overall product (or there might only be one item), while
     * in other cases, an administrable form might use only a subset of the items available in the
     * overall product. For example, an administrable form might involve combining a liquid and a
     * powder available as part of an overall product, but not involve applying the also supplied
     * cream.
     */
    public var producedFrom: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The ingredients of this administrable medicinal product. This is only needed if the
     * ingredients are not specified either using ManufacturedItemDefiniton (via
     * AdministrableProductDefinition.producedFrom) to state which component items are used to make
     * this, or using by incoming references from the Ingredient resource, to state in detail which
     * substances exist within this. This element allows a basic coded ingredient to be used.
     */
    public var ingredient: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A device that is integral to the medicinal product, in effect being considered as an
     * "ingredient" of the medicinal product. This is not intended for devices that are just
     * co-packaged.
     */
    public var device: Reference.Builder? = null

    /** Characteristics e.g. a product's onset of action. */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

    override fun build(): AdministrableProductDefinition =
      AdministrableProductDefinition(
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
        formOf = formOf.map { it.build() },
        administrableDoseForm = administrableDoseForm?.build(),
        unitOfPresentation = unitOfPresentation?.build(),
        producedFrom = producedFrom.map { it.build() },
        ingredient = ingredient.map { it.build() },
        device = device?.build(),
        `property` = `property`.map { it.build() },
        routeOfAdministration = routeOfAdministration.map { it.build() },
      )
  }
}
