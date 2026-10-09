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

import dev.ohs.fhir.model.r4.serializers.MedicinalProductPackagedBatchIdentifierSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPackagedPackageItemSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductPackagedSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A medicinal product in a container or package. */
@Serializable(with = MedicinalProductPackagedSerializer::class)
@SerialName("MedicinalProductPackaged")
public data class MedicinalProductPackaged(
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
  /** Unique identifier. */
  public val identifier: List<Identifier> = listOf(),
  /** The product with this is a pack for. */
  public val subject: List<Reference> = listOf(),
  /** Textual description. */
  public val description: String? = null,
  /** The legal status of supply of the medicinal product as classified by the regulator. */
  public val legalStatusOfSupply: CodeableConcept? = null,
  /** Marketing information. */
  public val marketingStatus: List<MarketingStatus> = listOf(),
  /** Manufacturer of this Package Item. */
  public val marketingAuthorization: Reference? = null,
  /** Manufacturer of this Package Item. */
  public val manufacturer: List<Reference> = listOf(),
  /** Batch numbering. */
  public val batchIdentifier: List<BatchIdentifier> = listOf(),
  /** A packaging item, as a contained for medicine, possibly with other packaging items within. */
  public val packageItem: List<PackageItem>,
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder(packageItem.toBuilderList())
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.identifier = identifier.toBuilderList()
    builder.subject = subject.toBuilderList()
    builder.description = description?.toBuilder()
    builder.legalStatusOfSupply = legalStatusOfSupply?.toBuilder()
    builder.marketingStatus = marketingStatus.toBuilderList()
    builder.marketingAuthorization = marketingAuthorization?.toBuilder()
    builder.manufacturer = manufacturer.toBuilderList()
    builder.batchIdentifier = batchIdentifier.toBuilderList()
    return builder
  }

  /** Batch numbering. */
  @Serializable(with = MedicinalProductPackagedBatchIdentifierSerializer::class)
  public data class BatchIdentifier(
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
    /** A number appearing on the outer packaging of a specific batch. */
    public val outerPackaging: Identifier,
    /** A number appearing on the immediate packaging (and not the outer packaging). */
    public val immediatePackaging: Identifier? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(outerPackaging.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.immediatePackaging = immediatePackaging?.toBuilder()
      return builder
    }

    public class Builder(
      /** A number appearing on the outer packaging of a specific batch. */
      public var outerPackaging: Identifier.Builder
    ) : FhirBuilder {
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

      /** A number appearing on the immediate packaging (and not the outer packaging). */
      public var immediatePackaging: Identifier.Builder? = null

      override fun build(): BatchIdentifier =
        BatchIdentifier(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          outerPackaging = outerPackaging.build(),
          immediatePackaging = immediatePackaging?.build(),
        )
    }
  }

  /** A packaging item, as a contained for medicine, possibly with other packaging items within. */
  @Serializable(with = MedicinalProductPackagedPackageItemSerializer::class)
  public data class PackageItem(
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
    /** Including possibly Data Carrier Identifier. */
    public val identifier: List<Identifier> = listOf(),
    /** The physical type of the container of the medicine. */
    public val type: CodeableConcept,
    /**
     * The quantity of this package in the medicinal product, at the current level of packaging. The
     * outermost is always 1.
     */
    public val quantity: Quantity,
    /** Material type of the package item. */
    public val material: List<CodeableConcept> = listOf(),
    /** A possible alternate material for the packaging. */
    public val alternateMaterial: List<CodeableConcept> = listOf(),
    /** A device accompanying a medicinal product. */
    public val device: List<Reference> = listOf(),
    /** The manufactured item as contained in the packaged medicinal product. */
    public val manufacturedItem: List<Reference> = listOf(),
    /** Allows containers within containers. */
    public val packageItem: List<PackageItem> = listOf(),
    /** Dimensions, color etc. */
    public val physicalCharacteristics: ProdCharacteristic? = null,
    /** Other codeable characteristics. */
    public val otherCharacteristics: List<CodeableConcept> = listOf(),
    /** Shelf Life and storage information. */
    public val shelfLifeStorage: List<ProductShelfLife> = listOf(),
    /** Manufacturer of this Package Item. */
    public val manufacturer: List<Reference> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(type.toBuilder(), quantity.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.identifier = identifier.toBuilderList()
      builder.material = material.toBuilderList()
      builder.alternateMaterial = alternateMaterial.toBuilderList()
      builder.device = device.toBuilderList()
      builder.manufacturedItem = manufacturedItem.toBuilderList()
      builder.packageItem = packageItem.toBuilderList()
      builder.physicalCharacteristics = physicalCharacteristics?.toBuilder()
      builder.otherCharacteristics = otherCharacteristics.toBuilderList()
      builder.shelfLifeStorage = shelfLifeStorage.toBuilderList()
      builder.manufacturer = manufacturer.toBuilderList()
      return builder
    }

    public class Builder(
      /** The physical type of the container of the medicine. */
      public var type: CodeableConcept.Builder,
      /**
       * The quantity of this package in the medicinal product, at the current level of packaging.
       * The outermost is always 1.
       */
      public var quantity: Quantity.Builder,
    ) : FhirBuilder {
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

      /** Including possibly Data Carrier Identifier. */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** Material type of the package item. */
      public var material: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A possible alternate material for the packaging. */
      public var alternateMaterial: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A device accompanying a medicinal product. */
      public var device: MutableList<Reference.Builder> = mutableListOf()

      /** The manufactured item as contained in the packaged medicinal product. */
      public var manufacturedItem: MutableList<Reference.Builder> = mutableListOf()

      /** Allows containers within containers. */
      public var packageItem: MutableList<Builder> = mutableListOf()

      /** Dimensions, color etc. */
      public var physicalCharacteristics: ProdCharacteristic.Builder? = null

      /** Other codeable characteristics. */
      public var otherCharacteristics: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Shelf Life and storage information. */
      public var shelfLifeStorage: MutableList<ProductShelfLife.Builder> = mutableListOf()

      /** Manufacturer of this Package Item. */
      public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

      override fun build(): PackageItem =
        PackageItem(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          identifier = identifier.buildList(),
          type = type.build(),
          quantity = quantity.build(),
          material = material.buildList(),
          alternateMaterial = alternateMaterial.buildList(),
          device = device.buildList(),
          manufacturedItem = manufacturedItem.buildList(),
          packageItem = packageItem.buildList(),
          physicalCharacteristics = physicalCharacteristics?.build(),
          otherCharacteristics = otherCharacteristics.buildList(),
          shelfLifeStorage = shelfLifeStorage.buildList(),
          manufacturer = manufacturer.buildList(),
        )
    }
  }

  public class Builder(
    /**
     * A packaging item, as a contained for medicine, possibly with other packaging items within.
     */
    public var packageItem: MutableList<PackageItem.Builder>
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

    /** Unique identifier. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The product with this is a pack for. */
    public var subject: MutableList<Reference.Builder> = mutableListOf()

    /** Textual description. */
    public var description: String.Builder? = null

    /** The legal status of supply of the medicinal product as classified by the regulator. */
    public var legalStatusOfSupply: CodeableConcept.Builder? = null

    /** Marketing information. */
    public var marketingStatus: MutableList<MarketingStatus.Builder> = mutableListOf()

    /** Manufacturer of this Package Item. */
    public var marketingAuthorization: Reference.Builder? = null

    /** Manufacturer of this Package Item. */
    public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

    /** Batch numbering. */
    public var batchIdentifier: MutableList<BatchIdentifier.Builder> = mutableListOf()

    override fun build(): MedicinalProductPackaged =
      MedicinalProductPackaged(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        subject = subject.buildList(),
        description = description?.build(),
        legalStatusOfSupply = legalStatusOfSupply?.build(),
        marketingStatus = marketingStatus.buildList(),
        marketingAuthorization = marketingAuthorization?.build(),
        manufacturer = manufacturer.buildList(),
        batchIdentifier = batchIdentifier.buildList(),
        packageItem = packageItem.buildList(),
      )
  }
}
