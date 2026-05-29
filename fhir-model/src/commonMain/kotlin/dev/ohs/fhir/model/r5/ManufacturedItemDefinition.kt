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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.ManufacturedItemDefinitionComponentConstituentSerializer
import dev.ohs.fhir.model.r5.serializers.ManufacturedItemDefinitionComponentSerializer
import dev.ohs.fhir.model.r5.serializers.ManufacturedItemDefinitionPropertySerializer
import dev.ohs.fhir.model.r5.serializers.ManufacturedItemDefinitionSerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule,
 * as contained in a packaged medicinal product.
 */
@Serializable(with = ManufacturedItemDefinitionSerializer::class)
@SerialName("ManufacturedItemDefinition")
public data class ManufacturedItemDefinition(
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
  /** Unique identifier. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status of this item. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of manufactured items that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /** A descriptive name applied to this item. */
  public val name: String? = null,
  /** Dose form as manufactured and before any transformation into the pharmaceutical product. */
  public val manufacturedDoseForm: CodeableConcept,
  /** The “real-world” units in which the quantity of the manufactured item is described. */
  public val unitOfPresentation: CodeableConcept? = null,
  /** Manufacturer of the item, one of several possible. */
  public val manufacturer: List<Reference> = listOf(),
  /**
   * Allows specifying that an item is on the market for sale, or that it is not available, and the
   * dates and locations associated.
   */
  public val marketingStatus: List<MarketingStatus> = listOf(),
  /**
   * The ingredients of this manufactured item. This is only needed if the ingredients are not
   * specified by incoming references from the Ingredient resource.
   */
  public val ingredient: List<CodeableConcept> = listOf(),
  /** General characteristics of this item. */
  public val `property`: List<Property> = listOf(),
  /**
   * Physical parts of the manufactured item, that it is intrisically made from. This is distinct
   * from the ingredients that are part of its chemical makeup.
   */
  public val component: List<Component> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, manufacturedDoseForm.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        name = this@with.name?.toBuilder()
        unitOfPresentation = this@with.unitOfPresentation?.toBuilder()
        manufacturer = this@with.manufacturer.map { it.toBuilder() }.toMutableList()
        marketingStatus = this@with.marketingStatus.map { it.toBuilder() }.toMutableList()
        ingredient = this@with.ingredient.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        component = this@with.component.map { it.toBuilder() }.toMutableList()
      }
    }

  /** General characteristics of this item. */
  @Serializable(with = ManufacturedItemDefinitionPropertySerializer::class)
  public data class Property(
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
    /** A code expressing the type of characteristic. */
    public val type: CodeableConcept,
    /** A value for the characteristic. */
    public val `value`: Value? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          `value` = this@with.`value`
        }
      }

    public sealed interface Value {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asDate(): Date? = this as? Date

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asReference(): Reference? = this as? Reference

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Value

      @JvmInline
      public value class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Value

      @JvmInline
      public value class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      @JvmInline
      public value class Markdown(public val `value`: dev.ohs.fhir.model.r5.Markdown) : Value

      @JvmInline
      public value class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          dateValue: dev.ohs.fhir.model.r5.Date?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          markdownValue: dev.ohs.fhir.model.r5.Markdown?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Value? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (dateValue != null) return Date(dateValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (markdownValue != null) return Markdown(markdownValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (referenceValue != null) return Reference(referenceValue)
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

      /** A value for the characteristic. */
      public var `value`: Value? = null

      public fun build(): Property =
        Property(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  /**
   * Physical parts of the manufactured item, that it is intrisically made from. This is distinct
   * from the ingredients that are part of its chemical makeup.
   */
  @Serializable(with = ManufacturedItemDefinitionComponentSerializer::class)
  public data class Component(
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
    /** Defining type of the component e.g. shell, layer, ink. */
    public val type: CodeableConcept,
    /**
     * The function of this component within the item e.g. delivers active ingredient, masks taste.
     */
    public val function: List<CodeableConcept> = listOf(),
    /**
     * The measurable amount of total quantity of all substances in the component, expressable in
     * different ways (e.g. by mass or volume).
     */
    public val amount: List<Quantity> = listOf(),
    /**
     * A reference to a constituent of the manufactured item as a whole, linked here so that its
     * component location within the item can be indicated. This not where the item's ingredient are
     * primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).
     */
    public val constituent: List<Constituent> = listOf(),
    /** General characteristics of this component. */
    public val `property`: List<Property> = listOf(),
    /** A component that this component contains or is made from. */
    public val component: List<Component> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function.map { it.toBuilder() }.toMutableList()
          amount = this@with.amount.map { it.toBuilder() }.toMutableList()
          constituent = this@with.constituent.map { it.toBuilder() }.toMutableList()
          `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
          component = this@with.component.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * A reference to a constituent of the manufactured item as a whole, linked here so that its
     * component location within the item can be indicated. This not where the item's ingredient are
     * primarily stated (for which see Ingredient.for or ManufacturedItemDefinition.ingredient).
     */
    @Serializable(with = ManufacturedItemDefinitionComponentConstituentSerializer::class)
    public data class Constituent(
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
       * The measurable amount of the substance, expressable in different ways (e.g. by mass or
       * volume).
       */
      public val amount: List<Quantity> = listOf(),
      /**
       * The physical location of the constituent/ingredient within the component. Example – if the
       * component is the bead in the capsule, then the location would be where the ingredient
       * resides within the product part – intragranular, extra-granular, etc.
       */
      public val location: List<CodeableConcept> = listOf(),
      /** The function of this constituent within the component e.g. binder. */
      public val function: List<CodeableConcept> = listOf(),
      /** The ingredient that is the constituent of the given component. */
      public val hasIngredient: List<CodeableReference> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            amount = this@with.amount.map { it.toBuilder() }.toMutableList()
            location = this@with.location.map { it.toBuilder() }.toMutableList()
            function = this@with.function.map { it.toBuilder() }.toMutableList()
            hasIngredient = this@with.hasIngredient.map { it.toBuilder() }.toMutableList()
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
         * The measurable amount of the substance, expressable in different ways (e.g. by mass or
         * volume).
         */
        public var amount: MutableList<Quantity.Builder> = mutableListOf()

        /**
         * The physical location of the constituent/ingredient within the component. Example – if
         * the component is the bead in the capsule, then the location would be where the ingredient
         * resides within the product part – intragranular, extra-granular, etc.
         */
        public var location: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** The function of this constituent within the component e.g. binder. */
        public var function: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** The ingredient that is the constituent of the given component. */
        public var hasIngredient: MutableList<CodeableReference.Builder> = mutableListOf()

        public fun build(): Constituent =
          Constituent(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            amount = amount.map { it.build() },
            location = location.map { it.build() },
            function = function.map { it.build() },
            hasIngredient = hasIngredient.map { it.build() },
          )
      }
    }

    public class Builder(
      /** Defining type of the component e.g. shell, layer, ink. */
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
       * The function of this component within the item e.g. delivers active ingredient, masks
       * taste.
       */
      public var function: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The measurable amount of total quantity of all substances in the component, expressable in
       * different ways (e.g. by mass or volume).
       */
      public var amount: MutableList<Quantity.Builder> = mutableListOf()

      /**
       * A reference to a constituent of the manufactured item as a whole, linked here so that its
       * component location within the item can be indicated. This not where the item's ingredient
       * are primarily stated (for which see Ingredient.for or
       * ManufacturedItemDefinition.ingredient).
       */
      public var constituent: MutableList<Constituent.Builder> = mutableListOf()

      /** General characteristics of this component. */
      public var `property`: MutableList<Property.Builder> = mutableListOf()

      /** A component that this component contains or is made from. */
      public var component: MutableList<Builder> = mutableListOf()

      public fun build(): Component =
        Component(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          function = function.map { it.build() },
          amount = amount.map { it.build() },
          constituent = constituent.map { it.build() },
          `property` = `property`.map { it.build() },
          component = component.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of this item. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of manufactured items that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
    /** Dose form as manufactured and before any transformation into the pharmaceutical product. */
    public var manufacturedDoseForm: CodeableConcept.Builder,
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

    /** Unique identifier. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A descriptive name applied to this item. */
    public var name: String.Builder? = null

    /** The “real-world” units in which the quantity of the manufactured item is described. */
    public var unitOfPresentation: CodeableConcept.Builder? = null

    /** Manufacturer of the item, one of several possible. */
    public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Allows specifying that an item is on the market for sale, or that it is not available, and
     * the dates and locations associated.
     */
    public var marketingStatus: MutableList<MarketingStatus.Builder> = mutableListOf()

    /**
     * The ingredients of this manufactured item. This is only needed if the ingredients are not
     * specified by incoming references from the Ingredient resource.
     */
    public var ingredient: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** General characteristics of this item. */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

    /**
     * Physical parts of the manufactured item, that it is intrisically made from. This is distinct
     * from the ingredients that are part of its chemical makeup.
     */
    public var component: MutableList<Component.Builder> = mutableListOf()

    override fun build(): ManufacturedItemDefinition =
      ManufacturedItemDefinition(
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
        name = name?.build(),
        manufacturedDoseForm = manufacturedDoseForm.build(),
        unitOfPresentation = unitOfPresentation?.build(),
        manufacturer = manufacturer.map { it.build() },
        marketingStatus = marketingStatus.map { it.build() },
        ingredient = ingredient.map { it.build() },
        `property` = `property`.map { it.build() },
        component = component.map { it.build() },
      )
  }
}
