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

import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionLegalStatusOfSupplySerializer
import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionPackagingContainedItemSerializer
import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionPackagingPropertySerializer
import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionPackagingSerializer
import dev.ohs.fhir.model.r5.serializers.PackagedProductDefinitionSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A medically related item or items, in a container or package. */
@Serializable(with = PackagedProductDefinitionSerializer::class)
@SerialName("PackagedProductDefinition")
public data class PackagedProductDefinition(
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
   * A unique identifier for this package as whole - not the the content of the package. Unique
   * instance identifiers assigned to a package by manufacturers, regulators, drug catalogue
   * custodians or other organizations.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A name for this package. Typically what it would be listed as in a drug formulary or catalogue,
   * inventory etc.
   */
  public val name: String? = null,
  /**
   * A high level category e.g. medicinal product, raw material, shipping/transport container, etc.
   */
  public val type: CodeableConcept? = null,
  /**
   * The product this package model relates to, not the contents of the package (for which see
   * package.containedItem).
   */
  public val packageFor: List<Reference> = listOf(),
  /**
   * The status within the lifecycle of this item. A high level status, this is not intended to
   * duplicate details carried elsewhere such as legal status, or authorization or marketing status.
   */
  public val status: CodeableConcept? = null,
  /** The date at which the given status became applicable. */
  public val statusDate: DateTime? = null,
  /**
   * A total of the complete count of contained items of a particular type/form, independent of
   * sub-packaging or organization. This can be considered as the pack size. This attribute differs
   * from containedItem.amount in that it can give a single aggregated count of all tablet types in
   * a pack, even when these are different manufactured items. For example a pill pack of 21 tablets
   * plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is repeatable so that
   * the different item types in one pack type can be counted (e.g. a count of vials and count of
   * syringes). Each repeat must have different units, so that it is clear what the different sets
   * of counted items are, and it is not intended to allow different counts of similar items (e.g.
   * not '2 tubes and 3 tubes'). Repeats are not to be used to represent different pack sizes (e.g.
   * 20 pack vs. 50 pack) - which would be different instances of this resource.
   */
  public val containedItemQuantity: List<Quantity> = listOf(),
  /** Textual description. Note that this is not the name of the package or product. */
  public val description: Markdown? = null,
  /** The legal status of supply of the packaged item as classified by the regulator. */
  public val legalStatusOfSupply: List<LegalStatusOfSupply> = listOf(),
  /**
   * Allows specifying that an item is on the market for sale, or that it is not available, and the
   * dates and locations associated.
   */
  public val marketingStatus: List<MarketingStatus> = listOf(),
  /**
   * Identifies if the package contains different items, such as when a drug product is supplied
   * with another item e.g. a diluent or adjuvant.
   */
  public val copackagedIndicator: Boolean? = null,
  /**
   * Manufacturer of this package type. When there are multiple it means these are all possible
   * manufacturers.
   */
  public val manufacturer: List<Reference> = listOf(),
  /** Additional information or supporting documentation about the packaged product. */
  public val attachedDocument: List<Reference> = listOf(),
  /**
   * A packaging item, as a container for medically related items, possibly with other packaging
   * items within, or a packaging component, such as bottle cap (which is not a device or a
   * medication manufactured item).
   */
  public val packaging: Packaging? = null,
  /**
   * Allows the key features to be recorded, such as "hospital pack", "nurse prescribable",
   * "calendar pack".
   */
  public val characteristic: List<Packaging.Property> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
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
        type = this@with.type?.toBuilder()
        packageFor = this@with.packageFor.map { it.toBuilder() }.toMutableList()
        status = this@with.status?.toBuilder()
        statusDate = this@with.statusDate?.toBuilder()
        containedItemQuantity =
          this@with.containedItemQuantity.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        legalStatusOfSupply = this@with.legalStatusOfSupply.map { it.toBuilder() }.toMutableList()
        marketingStatus = this@with.marketingStatus.map { it.toBuilder() }.toMutableList()
        copackagedIndicator = this@with.copackagedIndicator?.toBuilder()
        manufacturer = this@with.manufacturer.map { it.toBuilder() }.toMutableList()
        attachedDocument = this@with.attachedDocument.map { it.toBuilder() }.toMutableList()
        packaging = this@with.packaging?.toBuilder()
        characteristic = this@with.characteristic.map { it.toBuilder() }.toMutableList()
      }
    }

  /** The legal status of supply of the packaged item as classified by the regulator. */
  @Serializable(with = PackagedProductDefinitionLegalStatusOfSupplySerializer::class)
  public data class LegalStatusOfSupply(
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
     * The actual status of supply. Conveys in what situation this package type may be supplied for
     * use.
     */
    public val code: CodeableConcept? = null,
    /**
     * The place where the legal status of supply applies. When not specified, this indicates it is
     * unknown in this context.
     */
    public val jurisdiction: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code?.toBuilder()
          jurisdiction = this@with.jurisdiction?.toBuilder()
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
       * The actual status of supply. Conveys in what situation this package type may be supplied
       * for use.
       */
      public var code: CodeableConcept.Builder? = null

      /**
       * The place where the legal status of supply applies. When not specified, this indicates it
       * is unknown in this context.
       */
      public var jurisdiction: CodeableConcept.Builder? = null

      public fun build(): LegalStatusOfSupply =
        LegalStatusOfSupply(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code?.build(),
          jurisdiction = jurisdiction?.build(),
        )
    }
  }

  /**
   * A packaging item, as a container for medically related items, possibly with other packaging
   * items within, or a packaging component, such as bottle cap (which is not a device or a
   * medication manufactured item).
   */
  @Serializable(with = PackagedProductDefinitionPackagingSerializer::class)
  public data class Packaging(
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
     * A business identifier that is specific to this particular part of the packaging, often
     * assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode).
     */
    public val identifier: List<Identifier> = listOf(),
    /** The physical type of the container of the items. */
    public val type: CodeableConcept? = null,
    /**
     * Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging
     * itself (e.g. a bottle or vial). The latter type are designed be a container, but the former
     * are not.
     */
    public val componentPart: Boolean? = null,
    /**
     * The quantity of packaging items contained at this layer of the package. This does not relate
     * to the number of contained items but relates solely to the number of packaging items. When
     * looking at the outermost layer it is always 1. If there are two boxes within, at the next
     * layer it would be 2.
     */
    public val quantity: Integer? = null,
    /** Material type of the package item. */
    public val material: List<CodeableConcept> = listOf(),
    /**
     * A possible alternate material for this part of the packaging, that is allowed to be used
     * instead of the usual material (e.g. different types of plastic for a blister sleeve).
     */
    public val alternateMaterial: List<CodeableConcept> = listOf(),
    /** Shelf Life and storage information. */
    public val shelfLifeStorage: List<ProductShelfLife> = listOf(),
    /**
     * Manufacturer of this packaging item. When there are multiple values each one is a potential
     * manufacturer of this packaging item.
     */
    public val manufacturer: List<Reference> = listOf(),
    /** General characteristics of this item. */
    public val `property`: List<Property> = listOf(),
    /** The item(s) within the packaging. */
    public val containedItem: List<ContainedItem> = listOf(),
    /**
     * Allows containers (and parts of containers) within containers, still as a part of a single
     * packaged product. See also
     * PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition).
     */
    public val packaging: List<Packaging> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          componentPart = this@with.componentPart?.toBuilder()
          quantity = this@with.quantity?.toBuilder()
          material = this@with.material.map { it.toBuilder() }.toMutableList()
          alternateMaterial = this@with.alternateMaterial.map { it.toBuilder() }.toMutableList()
          shelfLifeStorage = this@with.shelfLifeStorage.map { it.toBuilder() }.toMutableList()
          manufacturer = this@with.manufacturer.map { it.toBuilder() }.toMutableList()
          `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
          containedItem = this@with.containedItem.map { it.toBuilder() }.toMutableList()
          packaging = this@with.packaging.map { it.toBuilder() }.toMutableList()
        }
      }

    /** General characteristics of this item. */
    @Serializable(with = PackagedProductDefinitionPackagingPropertySerializer::class)
    public data class Property(
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

        public fun asAttachment(): Attachment? = this as? Attachment

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
        public value class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            dateValue: dev.ohs.fhir.model.r5.Date?,
            booleanValue: dev.ohs.fhir.model.r5.Boolean?,
            attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
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

    /** The item(s) within the packaging. */
    @Serializable(with = PackagedProductDefinitionPackagingContainedItemSerializer::class)
    public data class ContainedItem(
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
       * The actual item(s) of medication, as manufactured, or a device (typically, but not
       * necessarily, a co-packaged one), or other medically related item (such as food,
       * biologicals, raw materials, medical fluids, gases etc.), as contained in the package. This
       * also allows another whole packaged product to be included, which is solely for the case
       * where a package of other entire packages is wanted - such as a wholesale or distribution
       * pack (for layers within one package, use PackagedProductDefinition.packaging.packaging).
       */
      public val item: CodeableReference,
      /**
       * The number of this type of item within this packaging or for continuous items such as
       * liquids it is the quantity (for example 25ml). See also
       * PackagedProductDefinition.containedItemQuantity (especially the long definition).
       */
      public val amount: Quantity? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(item.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            amount = this@with.amount?.toBuilder()
          }
        }

      public class Builder(
        /**
         * The actual item(s) of medication, as manufactured, or a device (typically, but not
         * necessarily, a co-packaged one), or other medically related item (such as food,
         * biologicals, raw materials, medical fluids, gases etc.), as contained in the package.
         * This also allows another whole packaged product to be included, which is solely for the
         * case where a package of other entire packages is wanted - such as a wholesale or
         * distribution pack (for layers within one package, use
         * PackagedProductDefinition.packaging.packaging).
         */
        public var item: CodeableReference.Builder
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
         * The number of this type of item within this packaging or for continuous items such as
         * liquids it is the quantity (for example 25ml). See also
         * PackagedProductDefinition.containedItemQuantity (especially the long definition).
         */
        public var amount: Quantity.Builder? = null

        public fun build(): ContainedItem =
          ContainedItem(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            item = item.build(),
            amount = amount?.build(),
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
       * A business identifier that is specific to this particular part of the packaging, often
       * assigned by the manufacturer. Including possibly Data Carrier Identifier (a GS1 barcode).
       */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** The physical type of the container of the items. */
      public var type: CodeableConcept.Builder? = null

      /**
       * Is this a part of the packaging (e.g. a cap or bottle stopper), rather than the packaging
       * itself (e.g. a bottle or vial). The latter type are designed be a container, but the former
       * are not.
       */
      public var componentPart: Boolean.Builder? = null

      /**
       * The quantity of packaging items contained at this layer of the package. This does not
       * relate to the number of contained items but relates solely to the number of packaging
       * items. When looking at the outermost layer it is always 1. If there are two boxes within,
       * at the next layer it would be 2.
       */
      public var quantity: Integer.Builder? = null

      /** Material type of the package item. */
      public var material: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * A possible alternate material for this part of the packaging, that is allowed to be used
       * instead of the usual material (e.g. different types of plastic for a blister sleeve).
       */
      public var alternateMaterial: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Shelf Life and storage information. */
      public var shelfLifeStorage: MutableList<ProductShelfLife.Builder> = mutableListOf()

      /**
       * Manufacturer of this packaging item. When there are multiple values each one is a potential
       * manufacturer of this packaging item.
       */
      public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

      /** General characteristics of this item. */
      public var `property`: MutableList<Property.Builder> = mutableListOf()

      /** The item(s) within the packaging. */
      public var containedItem: MutableList<ContainedItem.Builder> = mutableListOf()

      /**
       * Allows containers (and parts of containers) within containers, still as a part of a single
       * packaged product. See also
       * PackagedProductDefinition.packaging.containedItem.item(PackagedProductDefinition).
       */
      public var packaging: MutableList<Builder> = mutableListOf()

      public fun build(): Packaging =
        Packaging(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier.map { it.build() },
          type = type?.build(),
          componentPart = componentPart?.build(),
          quantity = quantity?.build(),
          material = material.map { it.build() },
          alternateMaterial = alternateMaterial.map { it.build() },
          shelfLifeStorage = shelfLifeStorage.map { it.build() },
          manufacturer = manufacturer.map { it.build() },
          `property` = `property`.map { it.build() },
          containedItem = containedItem.map { it.build() },
          packaging = packaging.map { it.build() },
        )
    }
  }

  public class Builder() : DomainResource.Builder() {
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
     * A unique identifier for this package as whole - not the the content of the package. Unique
     * instance identifiers assigned to a package by manufacturers, regulators, drug catalogue
     * custodians or other organizations.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A name for this package. Typically what it would be listed as in a drug formulary or
     * catalogue, inventory etc.
     */
    public var name: String.Builder? = null

    /**
     * A high level category e.g. medicinal product, raw material, shipping/transport container,
     * etc.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * The product this package model relates to, not the contents of the package (for which see
     * package.containedItem).
     */
    public var packageFor: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The status within the lifecycle of this item. A high level status, this is not intended to
     * duplicate details carried elsewhere such as legal status, or authorization or marketing
     * status.
     */
    public var status: CodeableConcept.Builder? = null

    /** The date at which the given status became applicable. */
    public var statusDate: DateTime.Builder? = null

    /**
     * A total of the complete count of contained items of a particular type/form, independent of
     * sub-packaging or organization. This can be considered as the pack size. This attribute
     * differs from containedItem.amount in that it can give a single aggregated count of all tablet
     * types in a pack, even when these are different manufactured items. For example a pill pack of
     * 21 tablets plus 7 sugar tablets, can be denoted here as '28 tablets'. This attribute is
     * repeatable so that the different item types in one pack type can be counted (e.g. a count of
     * vials and count of syringes). Each repeat must have different units, so that it is clear what
     * the different sets of counted items are, and it is not intended to allow different counts of
     * similar items (e.g. not '2 tubes and 3 tubes'). Repeats are not to be used to represent
     * different pack sizes (e.g. 20 pack vs. 50 pack) - which would be different instances of this
     * resource.
     */
    public var containedItemQuantity: MutableList<Quantity.Builder> = mutableListOf()

    /** Textual description. Note that this is not the name of the package or product. */
    public var description: Markdown.Builder? = null

    /** The legal status of supply of the packaged item as classified by the regulator. */
    public var legalStatusOfSupply: MutableList<LegalStatusOfSupply.Builder> = mutableListOf()

    /**
     * Allows specifying that an item is on the market for sale, or that it is not available, and
     * the dates and locations associated.
     */
    public var marketingStatus: MutableList<MarketingStatus.Builder> = mutableListOf()

    /**
     * Identifies if the package contains different items, such as when a drug product is supplied
     * with another item e.g. a diluent or adjuvant.
     */
    public var copackagedIndicator: Boolean.Builder? = null

    /**
     * Manufacturer of this package type. When there are multiple it means these are all possible
     * manufacturers.
     */
    public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

    /** Additional information or supporting documentation about the packaged product. */
    public var attachedDocument: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A packaging item, as a container for medically related items, possibly with other packaging
     * items within, or a packaging component, such as bottle cap (which is not a device or a
     * medication manufactured item).
     */
    public var packaging: Packaging.Builder? = null

    /**
     * Allows the key features to be recorded, such as "hospital pack", "nurse prescribable",
     * "calendar pack".
     */
    public var characteristic: MutableList<Packaging.Property.Builder> = mutableListOf()

    override fun build(): PackagedProductDefinition =
      PackagedProductDefinition(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        name = name?.build(),
        type = type?.build(),
        packageFor = packageFor.map { it.build() },
        status = status?.build(),
        statusDate = statusDate?.build(),
        containedItemQuantity = containedItemQuantity.map { it.build() },
        description = description?.build(),
        legalStatusOfSupply = legalStatusOfSupply.map { it.build() },
        marketingStatus = marketingStatus.map { it.build() },
        copackagedIndicator = copackagedIndicator?.build(),
        manufacturer = manufacturer.map { it.build() },
        attachedDocument = attachedDocument.map { it.build() },
        packaging = packaging?.build(),
        characteristic = characteristic.map { it.build() },
      )
  }
}
