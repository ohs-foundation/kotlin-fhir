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

import dev.ohs.fhir.model.r5.serializers.InventoryItemAssociationSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemCharacteristicSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemDescriptionSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemInstanceSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemNameSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemResponsibleOrganizationSerializer
import dev.ohs.fhir.model.r5.serializers.InventoryItemSerializer
import dev.ohs.fhir.model.r5.terminologies.CommonLanguages
import dev.ohs.fhir.model.r5.terminologies.InventoryItemStatusCodes
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** functional description of an inventory item used in inventory and supply-related workflows. */
@Serializable(with = InventoryItemSerializer::class)
@SerialName("InventoryItem")
public data class InventoryItem(
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
  /** Business identifier for the inventory item. */
  public val identifier: List<Identifier> = listOf(),
  /** Status of the item entry. */
  public val status: Enumeration<InventoryItemStatusCodes>,
  /** Category or class of the item. */
  public val category: List<CodeableConcept> = listOf(),
  /** Code designating the specific type of item. */
  public val code: List<CodeableConcept> = listOf(),
  /** The item name(s) - the brand name, or common name, functional name, generic name. */
  public val name: List<Name> = listOf(),
  /** Organization(s) responsible for the product. */
  public val responsibleOrganization: List<ResponsibleOrganization> = listOf(),
  /** The descriptive characteristics of the inventory item. */
  public val description: Description? = null,
  /**
   * The usage status e.g. recalled, in use, discarded... This can be used to indicate that the
   * items have been taken out of inventory, or are in use, etc.
   */
  public val inventoryStatus: List<CodeableConcept> = listOf(),
  /** The base unit of measure - the unit in which the product is used or counted. */
  public val baseUnit: CodeableConcept? = null,
  /** Net content or amount present in the item. */
  public val netContent: Quantity? = null,
  /** Association with other items or products. */
  public val association: List<Association> = listOf(),
  /** The descriptive or identifying characteristics of the item. */
  public val characteristic: List<Characteristic> = listOf(),
  /** Instances or occurrences of the product. */
  public val instance: Instance? = null,
  /** Link to a product resource used in clinical workflows. */
  public val productReference: Reference? = null,
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder(status)
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.mapToMutableList { it.toBuilder() }
    builder.extension = extension.mapToMutableList { it.toBuilder() }
    builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
    builder.identifier = identifier.mapToMutableList { it.toBuilder() }
    builder.category = category.mapToMutableList { it.toBuilder() }
    builder.code = code.mapToMutableList { it.toBuilder() }
    builder.name = name.mapToMutableList { it.toBuilder() }
    builder.responsibleOrganization = responsibleOrganization.mapToMutableList { it.toBuilder() }
    builder.description = description?.toBuilder()
    builder.inventoryStatus = inventoryStatus.mapToMutableList { it.toBuilder() }
    builder.baseUnit = baseUnit?.toBuilder()
    builder.netContent = netContent?.toBuilder()
    builder.association = association.mapToMutableList { it.toBuilder() }
    builder.characteristic = characteristic.mapToMutableList { it.toBuilder() }
    builder.instance = instance?.toBuilder()
    builder.productReference = productReference?.toBuilder()
    return builder
  }

  /** The item name(s) - the brand name, or common name, functional name, generic name. */
  @Serializable(with = InventoryItemNameSerializer::class)
  public data class Name(
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
    /** The type of name e.g. 'brand-name', 'functional-name', 'common-name'. */
    public val nameType: Coding,
    /** The language that the item name is expressed in. */
    public val language: Enumeration<CommonLanguages>,
    /** The name or designation that the item is given. */
    public val name: String,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder =
        Builder(
          nameType.toBuilder(),
          language,
          name.toBuilder(),
        )
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      return builder
    }

    public class Builder(
      /** The type of name e.g. 'brand-name', 'functional-name', 'common-name'. */
      public var nameType: Coding.Builder,
      /** The language that the item name is expressed in. */
      public var language: Enumeration<CommonLanguages>,
      /** The name or designation that the item is given. */
      public var name: String.Builder,
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

      public fun build(): Name =
        Name(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          nameType = nameType.build(),
          language = language,
          name = name.build(),
        )
    }
  }

  /** Organization(s) responsible for the product. */
  @Serializable(with = InventoryItemResponsibleOrganizationSerializer::class)
  public data class ResponsibleOrganization(
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
    /** The role of the organization e.g. manufacturer, distributor, etc. */
    public val role: CodeableConcept,
    /**
     * An organization that has an association with the item, e.g. manufacturer, distributor,
     * responsible, etc.
     */
    public val organization: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder(role.toBuilder(), organization.toBuilder())
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      return builder
    }

    public class Builder(
      /** The role of the organization e.g. manufacturer, distributor, etc. */
      public var role: CodeableConcept.Builder,
      /**
       * An organization that has an association with the item, e.g. manufacturer, distributor,
       * responsible, etc.
       */
      public var organization: Reference.Builder,
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

      public fun build(): ResponsibleOrganization =
        ResponsibleOrganization(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          role = role.build(),
          organization = organization.build(),
        )
    }
  }

  /** The descriptive characteristics of the inventory item. */
  @Serializable(with = InventoryItemDescriptionSerializer::class)
  public data class Description(
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
     * The language for the item description, when an item must be described in different languages
     * and those languages may be authoritative and not translations of a 'main' language.
     */
    public val language: Enumeration<CommonLanguages>? = null,
    /** Textual description of the item. */
    public val description: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.language = language
      builder.description = description?.toBuilder()
      return builder
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
       * The language for the item description, when an item must be described in different
       * languages and those languages may be authoritative and not translations of a 'main'
       * language.
       */
      public var language: Enumeration<CommonLanguages>? = null

      /** Textual description of the item. */
      public var description: String.Builder? = null

      public fun build(): Description =
        Description(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          language = language,
          description = description?.build(),
        )
    }
  }

  /** Association with other items or products. */
  @Serializable(with = InventoryItemAssociationSerializer::class)
  public data class Association(
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
     * This attribute defined the type of association when establishing associations or relations
     * between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.
     */
    public val associationType: CodeableConcept,
    /** The related item or product. */
    public val relatedItem: Reference,
    /**
     * The quantity of the related product in this product - Numerator is the quantity of the
     * related product. Denominator is the quantity of the present product. For example a value of
     * 20 means that this product contains 20 units of the related product; a value of 1:20 means
     * the inverse - that the contained product contains 20 units of the present product.
     */
    public val quantity: Ratio,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder =
        Builder(associationType.toBuilder(), relatedItem.toBuilder(), quantity.toBuilder())
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      return builder
    }

    public class Builder(
      /**
       * This attribute defined the type of association when establishing associations or relations
       * between items, e.g. 'packaged within' or 'used with' or 'to be mixed with.
       */
      public var associationType: CodeableConcept.Builder,
      /** The related item or product. */
      public var relatedItem: Reference.Builder,
      /**
       * The quantity of the related product in this product - Numerator is the quantity of the
       * related product. Denominator is the quantity of the present product. For example a value of
       * 20 means that this product contains 20 units of the related product; a value of 1:20 means
       * the inverse - that the contained product contains 20 units of the present product.
       */
      public var quantity: Ratio.Builder,
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

      public fun build(): Association =
        Association(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          associationType = associationType.build(),
          relatedItem = relatedItem.build(),
          quantity = quantity.build(),
        )
    }
  }

  /** The descriptive or identifying characteristics of the item. */
  @Serializable(with = InventoryItemCharacteristicSerializer::class)
  public data class Characteristic(
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
    /** The type of characteristic that is being defined. */
    public val characteristicType: CodeableConcept,
    /**
     * The value of the attribute.
     *
     * The string value is used for characteristics that are descriptive and not codeable
     * information. CodeableConcept.text is used when the characteristic is discrete and could
     * otherwise be coded but for which there is no code available.
     */
    public val `value`: Value,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder =
        Builder(
          characteristicType.toBuilder(),
          `value`,
        )
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      return builder
    }

    public sealed interface Value : FhirChoice {
      public fun asString(): String? = this as? String

      public fun asInteger(): Integer? = this as? Integer

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asUrl(): Url? = this as? Url

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAddress(): Address? = this as? Address

      public fun asDuration(): Duration? = this as? Duration

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class String(override val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Integer(override val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      public data class Decimal(override val `value`: dev.ohs.fhir.model.r5.Decimal) : Value

      public data class Boolean(override val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Url(override val `value`: dev.ohs.fhir.model.r5.Url) : Value

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r5.DateTime) : Value

      public data class Quantity(override val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Range(override val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public data class Ratio(override val `value`: dev.ohs.fhir.model.r5.Ratio) : Value

      public data class Annotation(override val `value`: dev.ohs.fhir.model.r5.Annotation) : Value

      public data class Address(override val `value`: dev.ohs.fhir.model.r5.Address) : Value

      public data class Duration(override val `value`: dev.ohs.fhir.model.r5.Duration) : Value

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Value

      public companion object {
        internal fun from(
          stringValue: dev.ohs.fhir.model.r5.String?,
          integerValue: dev.ohs.fhir.model.r5.Integer?,
          decimalValue: dev.ohs.fhir.model.r5.Decimal?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          urlValue: dev.ohs.fhir.model.r5.Url?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          ratioValue: dev.ohs.fhir.model.r5.Ratio?,
          annotationValue: dev.ohs.fhir.model.r5.Annotation?,
          addressValue: dev.ohs.fhir.model.r5.Address?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): Value? {
          if (stringValue != null) return String(stringValue)
          if (integerValue != null) return Integer(integerValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (urlValue != null) return Url(urlValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (addressValue != null) return Address(addressValue)
          if (durationValue != null) return Duration(durationValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /** The type of characteristic that is being defined. */
      public var characteristicType: CodeableConcept.Builder,
      /**
       * The value of the attribute.
       *
       * The string value is used for characteristics that are descriptive and not codeable
       * information. CodeableConcept.text is used when the characteristic is discrete and could
       * otherwise be coded but for which there is no code available.
       */
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

      public fun build(): Characteristic =
        Characteristic(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          characteristicType = characteristicType.build(),
          `value` = `value`,
        )
    }
  }

  /** Instances or occurrences of the product. */
  @Serializable(with = InventoryItemInstanceSerializer::class)
  public data class Instance(
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
    /** The identifier for the physical instance, typically a serial number. */
    public val identifier: List<Identifier> = listOf(),
    /** The lot or batch number of the item. */
    public val lotNumber: String? = null,
    /** The expiry date or date and time for the product. */
    public val expiry: DateTime? = null,
    /** The subject that the item is associated with. */
    public val subject: Reference? = null,
    /** The location that the item is associated with. */
    public val location: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.identifier = identifier.mapToMutableList { it.toBuilder() }
      builder.lotNumber = lotNumber?.toBuilder()
      builder.expiry = expiry?.toBuilder()
      builder.subject = subject?.toBuilder()
      builder.location = location?.toBuilder()
      return builder
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

      /** The identifier for the physical instance, typically a serial number. */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** The lot or batch number of the item. */
      public var lotNumber: String.Builder? = null

      /** The expiry date or date and time for the product. */
      public var expiry: DateTime.Builder? = null

      /** The subject that the item is associated with. */
      public var subject: Reference.Builder? = null

      /** The location that the item is associated with. */
      public var location: Reference.Builder? = null

      public fun build(): Instance =
        Instance(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          identifier = identifier.mapToList { it.build() },
          lotNumber = lotNumber?.build(),
          expiry = expiry?.build(),
          subject = subject?.build(),
          location = location?.build(),
        )
    }
  }

  public class Builder(
    /** Status of the item entry. */
    public var status: Enumeration<InventoryItemStatusCodes>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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

    /** Business identifier for the inventory item. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Category or class of the item. */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Code designating the specific type of item. */
    public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The item name(s) - the brand name, or common name, functional name, generic name. */
    public var name: MutableList<Name.Builder> = mutableListOf()

    /** Organization(s) responsible for the product. */
    public var responsibleOrganization: MutableList<ResponsibleOrganization.Builder> =
      mutableListOf()

    /** The descriptive characteristics of the inventory item. */
    public var description: Description.Builder? = null

    /**
     * The usage status e.g. recalled, in use, discarded... This can be used to indicate that the
     * items have been taken out of inventory, or are in use, etc.
     */
    public var inventoryStatus: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The base unit of measure - the unit in which the product is used or counted. */
    public var baseUnit: CodeableConcept.Builder? = null

    /** Net content or amount present in the item. */
    public var netContent: Quantity.Builder? = null

    /** Association with other items or products. */
    public var association: MutableList<Association.Builder> = mutableListOf()

    /** The descriptive or identifying characteristics of the item. */
    public var characteristic: MutableList<Characteristic.Builder> = mutableListOf()

    /** Instances or occurrences of the product. */
    public var instance: Instance.Builder? = null

    /** Link to a product resource used in clinical workflows. */
    public var productReference: Reference.Builder? = null

    override fun build(): InventoryItem =
      InventoryItem(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.mapToList { it.build() },
        extension = extension.mapToList { it.build() },
        modifierExtension = modifierExtension.mapToList { it.build() },
        identifier = identifier.mapToList { it.build() },
        status = status,
        category = category.mapToList { it.build() },
        code = code.mapToList { it.build() },
        name = name.mapToList { it.build() },
        responsibleOrganization = responsibleOrganization.mapToList { it.build() },
        description = description?.build(),
        inventoryStatus = inventoryStatus.mapToList { it.build() },
        baseUnit = baseUnit?.build(),
        netContent = netContent?.build(),
        association = association.mapToList { it.build() },
        characteristic = characteristic.mapToList { it.build() },
        instance = instance?.build(),
        productReference = productReference?.build(),
      )
  }
}
