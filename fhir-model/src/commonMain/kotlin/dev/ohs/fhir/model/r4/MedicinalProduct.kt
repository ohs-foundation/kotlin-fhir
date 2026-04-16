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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.MedicinalProductManufacturingBusinessOperationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductNameCountryLanguageSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductNameNamePartSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductNameSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductSpecialDesignationIndicationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicinalProductSpecialDesignationSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed definition of a medicinal product, typically for uses other than direct patient care
 * (e.g. regulatory use).
 */
@Serializable(with = MedicinalProductSerializer::class)
@SerialName("MedicinalProduct")
public data class MedicinalProduct(
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
  /** Business identifier for this product. Could be an MPID. */
  public val identifier: List<Identifier> = listOf(),
  /** Regulatory type, e.g. Investigational or Authorized. */
  public val type: CodeableConcept? = null,
  /** If this medicine applies to human or veterinary uses. */
  public val domain: Coding? = null,
  /** The dose form for a single part product, or combined form of a multiple part product. */
  public val combinedPharmaceuticalDoseForm: CodeableConcept? = null,
  /** The legal status of supply of the medicinal product as classified by the regulator. */
  public val legalStatusOfSupply: CodeableConcept? = null,
  /** Whether the Medicinal Product is subject to additional monitoring for regulatory reasons. */
  public val additionalMonitoringIndicator: CodeableConcept? = null,
  /** Whether the Medicinal Product is subject to special measures for regulatory reasons. */
  public val specialMeasures: List<String> = listOf(),
  /** If authorised for use in children. */
  public val paediatricUseIndicator: CodeableConcept? = null,
  /** Allows the product to be classified by various systems. */
  public val productClassification: List<CodeableConcept> = listOf(),
  /** Marketing status of the medicinal product, in contrast to marketing authorizaton. */
  public val marketingStatus: List<MarketingStatus> = listOf(),
  /** Pharmaceutical aspects of product. */
  public val pharmaceuticalProduct: List<Reference> = listOf(),
  /** Package representation for the product. */
  public val packagedMedicinalProduct: List<Reference> = listOf(),
  /** Supporting documentation, typically for regulatory submission. */
  public val attachedDocument: List<Reference> = listOf(),
  /** A master file for to the medicinal product (e.g. Pharmacovigilance System Master File). */
  public val masterFile: List<Reference> = listOf(),
  /** A product specific contact, person (in a role), or an organization. */
  public val contact: List<Reference> = listOf(),
  /** Clinical trials or studies that this product is involved in. */
  public val clinicalTrial: List<Reference> = listOf(),
  /** The product's name, including full name and possibly coded parts. */
  public val name: List<Name>,
  /** Reference to another product, e.g. for linking authorised to investigational product. */
  public val crossReference: List<Identifier> = listOf(),
  /** An operation applied to the product, for manufacturing or adminsitrative purpose. */
  public val manufacturingBusinessOperation: List<ManufacturingBusinessOperation> = listOf(),
  /**
   * Indicates if the medicinal product has an orphan designation for the treatment of a rare
   * disease.
   */
  public val specialDesignation: List<SpecialDesignation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(name.map { it.toBuilder() }.toMutableList()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        type = this@with.type?.toBuilder()
        domain = this@with.domain?.toBuilder()
        combinedPharmaceuticalDoseForm = this@with.combinedPharmaceuticalDoseForm?.toBuilder()
        legalStatusOfSupply = this@with.legalStatusOfSupply?.toBuilder()
        additionalMonitoringIndicator = this@with.additionalMonitoringIndicator?.toBuilder()
        specialMeasures = this@with.specialMeasures.map { it.toBuilder() }.toMutableList()
        paediatricUseIndicator = this@with.paediatricUseIndicator?.toBuilder()
        productClassification =
          this@with.productClassification.map { it.toBuilder() }.toMutableList()
        marketingStatus = this@with.marketingStatus.map { it.toBuilder() }.toMutableList()
        pharmaceuticalProduct =
          this@with.pharmaceuticalProduct.map { it.toBuilder() }.toMutableList()
        packagedMedicinalProduct =
          this@with.packagedMedicinalProduct.map { it.toBuilder() }.toMutableList()
        attachedDocument = this@with.attachedDocument.map { it.toBuilder() }.toMutableList()
        masterFile = this@with.masterFile.map { it.toBuilder() }.toMutableList()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        clinicalTrial = this@with.clinicalTrial.map { it.toBuilder() }.toMutableList()
        crossReference = this@with.crossReference.map { it.toBuilder() }.toMutableList()
        manufacturingBusinessOperation =
          this@with.manufacturingBusinessOperation.map { it.toBuilder() }.toMutableList()
        specialDesignation = this@with.specialDesignation.map { it.toBuilder() }.toMutableList()
      }
    }

  /** The product's name, including full name and possibly coded parts. */
  @Serializable(with = MedicinalProductNameSerializer::class)
  public data class Name(
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
    /** The full product name. */
    public val productName: String,
    /** Coding words or phrases of the name. */
    public val namePart: List<NamePart> = listOf(),
    /** Country where the name applies. */
    public val countryLanguage: List<CountryLanguage> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(productName.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          namePart = this@with.namePart.map { it.toBuilder() }.toMutableList()
          countryLanguage = this@with.countryLanguage.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Coding words or phrases of the name. */
    @Serializable(with = MedicinalProductNameNamePartSerializer::class)
    public data class NamePart(
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
      /** A fragment of a product name. */
      public val part: String,
      /** Idenifying type for this part of the name (e.g. strength part). */
      public val type: Coding,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(part.toBuilder(), type.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** A fragment of a product name. */
        public var part: String.Builder,
        /** Idenifying type for this part of the name (e.g. strength part). */
        public var type: Coding.Builder,
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

        public fun build(): NamePart =
          NamePart(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            part = part.build(),
            type = type.build(),
          )
      }
    }

    /** Country where the name applies. */
    @Serializable(with = MedicinalProductNameCountryLanguageSerializer::class)
    public data class CountryLanguage(
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
      /** Country code for where this name applies. */
      public val country: CodeableConcept,
      /** Jurisdiction code for where this name applies. */
      public val jurisdiction: CodeableConcept? = null,
      /** Language code for this name. */
      public val language: CodeableConcept,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(country.toBuilder(), language.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            jurisdiction = this@with.jurisdiction?.toBuilder()
          }
        }

      public class Builder(
        /** Country code for where this name applies. */
        public var country: CodeableConcept.Builder,
        /** Language code for this name. */
        public var language: CodeableConcept.Builder,
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

        /** Jurisdiction code for where this name applies. */
        public var jurisdiction: CodeableConcept.Builder? = null

        public fun build(): CountryLanguage =
          CountryLanguage(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            country = country.build(),
            jurisdiction = jurisdiction?.build(),
            language = language.build(),
          )
      }
    }

    public class Builder(
      /** The full product name. */
      public var productName: String.Builder
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

      /** Coding words or phrases of the name. */
      public var namePart: MutableList<NamePart.Builder> = mutableListOf()

      /** Country where the name applies. */
      public var countryLanguage: MutableList<CountryLanguage.Builder> = mutableListOf()

      public fun build(): Name =
        Name(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          productName = productName.build(),
          namePart = namePart.map { it.build() },
          countryLanguage = countryLanguage.map { it.build() },
        )
    }
  }

  /** An operation applied to the product, for manufacturing or adminsitrative purpose. */
  @Serializable(with = MedicinalProductManufacturingBusinessOperationSerializer::class)
  public data class ManufacturingBusinessOperation(
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
    /** The type of manufacturing operation. */
    public val operationType: CodeableConcept? = null,
    /** Regulatory authorization reference number. */
    public val authorisationReferenceNumber: Identifier? = null,
    /** Regulatory authorization date. */
    public val effectiveDate: DateTime? = null,
    /** To indicate if this proces is commercially confidential. */
    public val confidentialityIndicator: CodeableConcept? = null,
    /** The manufacturer or establishment associated with the process. */
    public val manufacturer: List<Reference> = listOf(),
    /** A regulator which oversees the operation. */
    public val regulator: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          operationType = this@with.operationType?.toBuilder()
          authorisationReferenceNumber = this@with.authorisationReferenceNumber?.toBuilder()
          effectiveDate = this@with.effectiveDate?.toBuilder()
          confidentialityIndicator = this@with.confidentialityIndicator?.toBuilder()
          manufacturer = this@with.manufacturer.map { it.toBuilder() }.toMutableList()
          regulator = this@with.regulator?.toBuilder()
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

      /** The type of manufacturing operation. */
      public var operationType: CodeableConcept.Builder? = null

      /** Regulatory authorization reference number. */
      public var authorisationReferenceNumber: Identifier.Builder? = null

      /** Regulatory authorization date. */
      public var effectiveDate: DateTime.Builder? = null

      /** To indicate if this proces is commercially confidential. */
      public var confidentialityIndicator: CodeableConcept.Builder? = null

      /** The manufacturer or establishment associated with the process. */
      public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

      /** A regulator which oversees the operation. */
      public var regulator: Reference.Builder? = null

      public fun build(): ManufacturingBusinessOperation =
        ManufacturingBusinessOperation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          operationType = operationType?.build(),
          authorisationReferenceNumber = authorisationReferenceNumber?.build(),
          effectiveDate = effectiveDate?.build(),
          confidentialityIndicator = confidentialityIndicator?.build(),
          manufacturer = manufacturer.map { it.build() },
          regulator = regulator?.build(),
        )
    }
  }

  /**
   * Indicates if the medicinal product has an orphan designation for the treatment of a rare
   * disease.
   */
  @Serializable(with = MedicinalProductSpecialDesignationSerializer::class)
  public data class SpecialDesignation(
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
    /** Identifier for the designation, or procedure number. */
    public val identifier: List<Identifier> = listOf(),
    /** The type of special designation, e.g. orphan drug, minor use. */
    public val type: CodeableConcept? = null,
    /** The intended use of the product, e.g. prevention, treatment. */
    public val intendedUse: CodeableConcept? = null,
    /** Condition for which the medicinal use applies. */
    public val indication: Indication? = null,
    /** For example granted, pending, expired or withdrawn. */
    public val status: CodeableConcept? = null,
    /** Date when the designation was granted. */
    public val date: DateTime? = null,
    /** Animal species for which this applies. */
    public val species: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          intendedUse = this@with.intendedUse?.toBuilder()
          indication = this@with.indication
          status = this@with.status?.toBuilder()
          date = this@with.date?.toBuilder()
          species = this@with.species?.toBuilder()
        }
      }

    @Serializable(with = MedicinalProductSpecialDesignationIndicationSerializer::class)
    public sealed interface Indication {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
        Indication

      public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Indication

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
        ): Indication? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
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

      /** Identifier for the designation, or procedure number. */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** The type of special designation, e.g. orphan drug, minor use. */
      public var type: CodeableConcept.Builder? = null

      /** The intended use of the product, e.g. prevention, treatment. */
      public var intendedUse: CodeableConcept.Builder? = null

      /** Condition for which the medicinal use applies. */
      public var indication: Indication? = null

      /** For example granted, pending, expired or withdrawn. */
      public var status: CodeableConcept.Builder? = null

      /** Date when the designation was granted. */
      public var date: DateTime.Builder? = null

      /** Animal species for which this applies. */
      public var species: CodeableConcept.Builder? = null

      public fun build(): SpecialDesignation =
        SpecialDesignation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier.map { it.build() },
          type = type?.build(),
          intendedUse = intendedUse?.build(),
          indication = indication,
          status = status?.build(),
          date = date?.build(),
          species = species?.build(),
        )
    }
  }

  public class Builder(
    /** The product's name, including full name and possibly coded parts. */
    public var name: MutableList<Name.Builder>
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

    /** Business identifier for this product. Could be an MPID. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Regulatory type, e.g. Investigational or Authorized. */
    public var type: CodeableConcept.Builder? = null

    /** If this medicine applies to human or veterinary uses. */
    public var domain: Coding.Builder? = null

    /** The dose form for a single part product, or combined form of a multiple part product. */
    public var combinedPharmaceuticalDoseForm: CodeableConcept.Builder? = null

    /** The legal status of supply of the medicinal product as classified by the regulator. */
    public var legalStatusOfSupply: CodeableConcept.Builder? = null

    /** Whether the Medicinal Product is subject to additional monitoring for regulatory reasons. */
    public var additionalMonitoringIndicator: CodeableConcept.Builder? = null

    /** Whether the Medicinal Product is subject to special measures for regulatory reasons. */
    public var specialMeasures: MutableList<String.Builder> = mutableListOf()

    /** If authorised for use in children. */
    public var paediatricUseIndicator: CodeableConcept.Builder? = null

    /** Allows the product to be classified by various systems. */
    public var productClassification: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Marketing status of the medicinal product, in contrast to marketing authorizaton. */
    public var marketingStatus: MutableList<MarketingStatus.Builder> = mutableListOf()

    /** Pharmaceutical aspects of product. */
    public var pharmaceuticalProduct: MutableList<Reference.Builder> = mutableListOf()

    /** Package representation for the product. */
    public var packagedMedicinalProduct: MutableList<Reference.Builder> = mutableListOf()

    /** Supporting documentation, typically for regulatory submission. */
    public var attachedDocument: MutableList<Reference.Builder> = mutableListOf()

    /** A master file for to the medicinal product (e.g. Pharmacovigilance System Master File). */
    public var masterFile: MutableList<Reference.Builder> = mutableListOf()

    /** A product specific contact, person (in a role), or an organization. */
    public var contact: MutableList<Reference.Builder> = mutableListOf()

    /** Clinical trials or studies that this product is involved in. */
    public var clinicalTrial: MutableList<Reference.Builder> = mutableListOf()

    /** Reference to another product, e.g. for linking authorised to investigational product. */
    public var crossReference: MutableList<Identifier.Builder> = mutableListOf()

    /** An operation applied to the product, for manufacturing or adminsitrative purpose. */
    public var manufacturingBusinessOperation: MutableList<ManufacturingBusinessOperation.Builder> =
      mutableListOf()

    /**
     * Indicates if the medicinal product has an orphan designation for the treatment of a rare
     * disease.
     */
    public var specialDesignation: MutableList<SpecialDesignation.Builder> = mutableListOf()

    override fun build(): MedicinalProduct =
      MedicinalProduct(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        type = type?.build(),
        domain = domain?.build(),
        combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm?.build(),
        legalStatusOfSupply = legalStatusOfSupply?.build(),
        additionalMonitoringIndicator = additionalMonitoringIndicator?.build(),
        specialMeasures = specialMeasures.map { it.build() },
        paediatricUseIndicator = paediatricUseIndicator?.build(),
        productClassification = productClassification.map { it.build() },
        marketingStatus = marketingStatus.map { it.build() },
        pharmaceuticalProduct = pharmaceuticalProduct.map { it.build() },
        packagedMedicinalProduct = packagedMedicinalProduct.map { it.build() },
        attachedDocument = attachedDocument.map { it.build() },
        masterFile = masterFile.map { it.build() },
        contact = contact.map { it.build() },
        clinicalTrial = clinicalTrial.map { it.build() },
        name = name.map { it.build() },
        crossReference = crossReference.map { it.build() },
        manufacturingBusinessOperation = manufacturingBusinessOperation.map { it.build() },
        specialDesignation = specialDesignation.map { it.build() },
      )
  }
}
