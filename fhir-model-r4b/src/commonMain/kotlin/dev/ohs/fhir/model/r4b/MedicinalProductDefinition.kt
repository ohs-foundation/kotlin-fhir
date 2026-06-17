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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionCharacteristicSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionContactSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionCrossReferenceSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionNameCountryLanguageSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionNameNamePartSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionNameSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionOperationSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicinalProductDefinitionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed definition of a medicinal product, typically for uses other than direct patient care
 * (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).
 */
@Serializable(with = MedicinalProductDefinitionSerializer::class)
@SerialName("MedicinalProductDefinition")
public data class MedicinalProductDefinition(
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
   * Business identifier for this product. Could be an MPID. When in development or being regulated,
   * products are typically referenced by official identifiers, assigned by a manufacturer or
   * regulator, and unique to a product (which, when compared to a product instance being
   * prescribed, is actually a product type). See also MedicinalProductDefinition.code.
   */
  public val identifier: List<Identifier> = listOf(),
  /** Regulatory type, e.g. Investigational or Authorized. */
  public val type: CodeableConcept? = null,
  /** If this medicine applies to human or veterinary uses. */
  public val domain: CodeableConcept? = null,
  /**
   * A business identifier relating to a specific version of the product, this is commonly used to
   * support revisions to an existing product.
   */
  public val version: String? = null,
  /**
   * The status within the lifecycle of this product record. A high-level status, this is not
   * intended to duplicate details carried elsewhere such as legal status, or authorization status.
   */
  public val status: CodeableConcept? = null,
  /** The date at which the given status became applicable. */
  public val statusDate: DateTime? = null,
  /** General description of this product. */
  public val description: Markdown? = null,
  /**
   * The dose form for a single part product, or combined form of a multiple part product. This is
   * one concept that describes all the components. It does not represent the form with components
   * physically mixed, if that might be necessary, for which see
   * (AdministrableProductDefinition.administrableDoseForm).
   */
  public val combinedPharmaceuticalDoseForm: CodeableConcept? = null,
  /**
   * The path by which the product is taken into or makes contact with the body. In some regions
   * this is referred to as the licenced or approved route. See also AdministrableProductDefinition
   * resource. MedicinalProductDefinition.route is the same concept as
   * AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used together.
   */
  public val route: List<CodeableConcept> = listOf(),
  /**
   * Description of indication(s) for this product, used when structured indications are not
   * required. In cases where structured indications are required, they are captured using the
   * ClinicalUseDefinition resource. An indication is a medical situation for which using the
   * product is appropriate.
   */
  public val indication: Markdown? = null,
  /** The legal status of supply of the medicinal product as classified by the regulator. */
  public val legalStatusOfSupply: CodeableConcept? = null,
  /**
   * Whether the Medicinal Product is subject to additional monitoring for regulatory reasons, such
   * as heightened reporting requirements.
   */
  public val additionalMonitoringIndicator: CodeableConcept? = null,
  /**
   * Whether the Medicinal Product is subject to special measures for regulatory reasons, such as a
   * requirement to conduct post-authorisation studies.
   */
  public val specialMeasures: List<CodeableConcept> = listOf(),
  /** If authorised for use in children, or infants, neonates etc. */
  public val pediatricUseIndicator: CodeableConcept? = null,
  /** Allows the product to be classified by various systems, commonly WHO ATC. */
  public val classification: List<CodeableConcept> = listOf(),
  /**
   * Marketing status of the medicinal product, in contrast to marketing authorization. This refers
   * to the product being actually 'on the market' as opposed to being allowed to be on the market
   * (which is an authorization).
   */
  public val marketingStatus: List<MarketingStatus> = listOf(),
  /** Package type for the product. See also the PackagedProductDefinition resource. */
  public val packagedMedicinalProduct: List<CodeableConcept> = listOf(),
  /**
   * The ingredients of this medicinal product - when not detailed in other resources. This is only
   * needed if the ingredients are not specified by incoming references from the Ingredient
   * resource, or indirectly via incoming AdministrableProductDefinition, PackagedProductDefinition
   * or ManufacturedItemDefinition references. In cases where those levels of detail are not used,
   * the ingredients may be specified directly here as codes.
   */
  public val ingredient: List<CodeableConcept> = listOf(),
  /**
   * Any component of the drug product which is not the chemical entity defined as the drug
   * substance, or an excipient in the drug product. This includes process-related impurities and
   * contaminants, product-related impurities including degradation products.
   */
  public val impurity: List<CodeableReference> = listOf(),
  /** Additional information or supporting documentation about the medicinal product. */
  public val attachedDocument: List<Reference> = listOf(),
  /**
   * A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug
   * master files (DMFs) are documents submitted to regulatory agencies to provide confidential
   * detailed information about facilities, processes or articles used in the manufacturing,
   * processing, packaging and storing of drug products.
   */
  public val masterFile: List<Reference> = listOf(),
  /** A product specific contact, person (in a role), or an organization. */
  public val contact: List<Contact> = listOf(),
  /** Clinical trials or studies that this product is involved in. */
  public val clinicalTrial: List<Reference> = listOf(),
  /**
   * A code that this product is known by, usually within some formal terminology, perhaps assigned
   * by a third party (i.e. not the manufacturer or regulator). Products (types of medications) tend
   * to be known by identifiers during development and within regulatory process. However when they
   * are prescribed they tend to be identified by codes. The same product may be have multiple
   * codes, applied to it by multiple organizations.
   */
  public val code: List<Coding> = listOf(),
  /** The product's name, including full name and possibly coded parts. */
  public val name: List<Name>,
  /**
   * Reference to another product, e.g. for linking authorised to investigational product, or a
   * virtual product.
   */
  public val crossReference: List<CrossReference> = listOf(),
  /**
   * A manufacturing or administrative process or step associated with (or performed on) the
   * medicinal product.
   */
  public val operation: List<Operation> = listOf(),
  /**
   * Allows the key product features to be recorded, such as "sugar free", "modified release",
   * "parallel import".
   */
  public val characteristic: List<Characteristic> = listOf(),
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
        version = this@with.version?.toBuilder()
        status = this@with.status?.toBuilder()
        statusDate = this@with.statusDate?.toBuilder()
        description = this@with.description?.toBuilder()
        combinedPharmaceuticalDoseForm = this@with.combinedPharmaceuticalDoseForm?.toBuilder()
        route = this@with.route.map { it.toBuilder() }.toMutableList()
        indication = this@with.indication?.toBuilder()
        legalStatusOfSupply = this@with.legalStatusOfSupply?.toBuilder()
        additionalMonitoringIndicator = this@with.additionalMonitoringIndicator?.toBuilder()
        specialMeasures = this@with.specialMeasures.map { it.toBuilder() }.toMutableList()
        pediatricUseIndicator = this@with.pediatricUseIndicator?.toBuilder()
        classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        marketingStatus = this@with.marketingStatus.map { it.toBuilder() }.toMutableList()
        packagedMedicinalProduct =
          this@with.packagedMedicinalProduct.map { it.toBuilder() }.toMutableList()
        ingredient = this@with.ingredient.map { it.toBuilder() }.toMutableList()
        impurity = this@with.impurity.map { it.toBuilder() }.toMutableList()
        attachedDocument = this@with.attachedDocument.map { it.toBuilder() }.toMutableList()
        masterFile = this@with.masterFile.map { it.toBuilder() }.toMutableList()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        clinicalTrial = this@with.clinicalTrial.map { it.toBuilder() }.toMutableList()
        code = this@with.code.map { it.toBuilder() }.toMutableList()
        crossReference = this@with.crossReference.map { it.toBuilder() }.toMutableList()
        operation = this@with.operation.map { it.toBuilder() }.toMutableList()
        characteristic = this@with.characteristic.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A product specific contact, person (in a role), or an organization. */
  @Serializable(with = MedicinalProductDefinitionContactSerializer::class)
  public data class Contact(
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
     * Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry Information.
     */
    public val type: CodeableConcept? = null,
    /** A product specific contact, person (in a role), or an organization. */
    public val contact: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(contact.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
        }
      }

    public class Builder(
      /** A product specific contact, person (in a role), or an organization. */
      public var contact: Reference.Builder
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
       * Allows the contact to be classified, for example QPPV, Pharmacovigilance Enquiry
       * Information.
       */
      public var type: CodeableConcept.Builder? = null

      public fun build(): Contact =
        Contact(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          contact = contact.build(),
        )
    }
  }

  /** The product's name, including full name and possibly coded parts. */
  @Serializable(with = MedicinalProductDefinitionNameSerializer::class)
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
    /** Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary. */
    public val type: CodeableConcept? = null,
    /** Coding words or phrases of the name. */
    public val namePart: List<NamePart> = listOf(),
    /** Country and jurisdiction where the name applies, and associated language. */
    public val countryLanguage: List<CountryLanguage> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(productName.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          namePart = this@with.namePart.map { it.toBuilder() }.toMutableList()
          countryLanguage = this@with.countryLanguage.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Coding words or phrases of the name. */
    @Serializable(with = MedicinalProductDefinitionNameNamePartSerializer::class)
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
      /** Identifying type for this part of the name (e.g. strength part). */
      public val type: CodeableConcept,
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
        /** Identifying type for this part of the name (e.g. strength part). */
        public var type: CodeableConcept.Builder,
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

    /** Country and jurisdiction where the name applies, and associated language. */
    @Serializable(with = MedicinalProductDefinitionNameCountryLanguageSerializer::class)
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
      /**
       * Jurisdiction code for where this name applies. A jurisdiction may be a sub- or
       * supra-national entity (e.g. a state or a geographic region).
       */
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

        /**
         * Jurisdiction code for where this name applies. A jurisdiction may be a sub- or
         * supra-national entity (e.g. a state or a geographic region).
         */
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

      /** Type of product name, such as rINN, BAN, Proprietary, Non-Proprietary. */
      public var type: CodeableConcept.Builder? = null

      /** Coding words or phrases of the name. */
      public var namePart: MutableList<NamePart.Builder> = mutableListOf()

      /** Country and jurisdiction where the name applies, and associated language. */
      public var countryLanguage: MutableList<CountryLanguage.Builder> = mutableListOf()

      public fun build(): Name =
        Name(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          productName = productName.build(),
          type = type?.build(),
          namePart = namePart.map { it.build() },
          countryLanguage = countryLanguage.map { it.build() },
        )
    }
  }

  /**
   * Reference to another product, e.g. for linking authorised to investigational product, or a
   * virtual product.
   */
  @Serializable(with = MedicinalProductDefinitionCrossReferenceSerializer::class)
  public data class CrossReference(
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
    /** Reference to another product, e.g. for linking authorised to investigational product. */
    public val product: CodeableReference,
    /**
     * The type of relationship, for instance branded to generic, virtual to actual product, product
     * to development product (investigational), parallel import version.
     */
    public val type: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(product.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
        }
      }

    public class Builder(
      /** Reference to another product, e.g. for linking authorised to investigational product. */
      public var product: CodeableReference.Builder
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
       * The type of relationship, for instance branded to generic, virtual to actual product,
       * product to development product (investigational), parallel import version.
       */
      public var type: CodeableConcept.Builder? = null

      public fun build(): CrossReference =
        CrossReference(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          product = product.build(),
          type = type?.build(),
        )
    }
  }

  /**
   * A manufacturing or administrative process or step associated with (or performed on) the
   * medicinal product.
   */
  @Serializable(with = MedicinalProductDefinitionOperationSerializer::class)
  public data class Operation(
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
     * The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the
     * authorization of this, a RegulatedAuthorization would point to the same plan or activity
     * referenced here.
     */
    public val type: CodeableReference? = null,
    /** Date range of applicability. */
    public val effectiveDate: Period? = null,
    /**
     * The organization or establishment responsible for (or associated with) the particular process
     * or step, examples include the manufacturer, importer, agent.
     */
    public val organization: List<Reference> = listOf(),
    /**
     * Specifies whether this particular business or manufacturing process is considered proprietary
     * or confidential.
     */
    public val confidentialityIndicator: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          effectiveDate = this@with.effectiveDate?.toBuilder()
          organization = this@with.organization.map { it.toBuilder() }.toMutableList()
          confidentialityIndicator = this@with.confidentialityIndicator?.toBuilder()
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

      /**
       * The type of manufacturing operation e.g. manufacturing itself, re-packaging. For the
       * authorization of this, a RegulatedAuthorization would point to the same plan or activity
       * referenced here.
       */
      public var type: CodeableReference.Builder? = null

      /** Date range of applicability. */
      public var effectiveDate: Period.Builder? = null

      /**
       * The organization or establishment responsible for (or associated with) the particular
       * process or step, examples include the manufacturer, importer, agent.
       */
      public var organization: MutableList<Reference.Builder> = mutableListOf()

      /**
       * Specifies whether this particular business or manufacturing process is considered
       * proprietary or confidential.
       */
      public var confidentialityIndicator: CodeableConcept.Builder? = null

      public fun build(): Operation =
        Operation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          effectiveDate = effectiveDate?.build(),
          organization = organization.map { it.build() },
          confidentialityIndicator = confidentialityIndicator?.build(),
        )
    }
  }

  /**
   * Allows the key product features to be recorded, such as "sugar free", "modified release",
   * "parallel import".
   */
  @Serializable(with = MedicinalProductDefinitionCharacteristicSerializer::class)
  public data class Characteristic(
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

      public data class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
      ) : Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r4b.Quantity) : Value

      public data class Date(public val `value`: dev.ohs.fhir.model.r4b.Date) : Value

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r4b.Boolean) : Value

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r4b.Attachment) : Value

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

      public fun build(): Characteristic =
        Characteristic(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `value` = `value`,
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

    /**
     * Business identifier for this product. Could be an MPID. When in development or being
     * regulated, products are typically referenced by official identifiers, assigned by a
     * manufacturer or regulator, and unique to a product (which, when compared to a product
     * instance being prescribed, is actually a product type). See also
     * MedicinalProductDefinition.code.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Regulatory type, e.g. Investigational or Authorized. */
    public var type: CodeableConcept.Builder? = null

    /** If this medicine applies to human or veterinary uses. */
    public var domain: CodeableConcept.Builder? = null

    /**
     * A business identifier relating to a specific version of the product, this is commonly used to
     * support revisions to an existing product.
     */
    public var version: String.Builder? = null

    /**
     * The status within the lifecycle of this product record. A high-level status, this is not
     * intended to duplicate details carried elsewhere such as legal status, or authorization
     * status.
     */
    public var status: CodeableConcept.Builder? = null

    /** The date at which the given status became applicable. */
    public var statusDate: DateTime.Builder? = null

    /** General description of this product. */
    public var description: Markdown.Builder? = null

    /**
     * The dose form for a single part product, or combined form of a multiple part product. This is
     * one concept that describes all the components. It does not represent the form with components
     * physically mixed, if that might be necessary, for which see
     * (AdministrableProductDefinition.administrableDoseForm).
     */
    public var combinedPharmaceuticalDoseForm: CodeableConcept.Builder? = null

    /**
     * The path by which the product is taken into or makes contact with the body. In some regions
     * this is referred to as the licenced or approved route. See also
     * AdministrableProductDefinition resource. MedicinalProductDefinition.route is the same concept
     * as AdministrableProductDefinition.routeOfAdministration.code, and they cannot be used
     * together.
     */
    public var route: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Description of indication(s) for this product, used when structured indications are not
     * required. In cases where structured indications are required, they are captured using the
     * ClinicalUseDefinition resource. An indication is a medical situation for which using the
     * product is appropriate.
     */
    public var indication: Markdown.Builder? = null

    /** The legal status of supply of the medicinal product as classified by the regulator. */
    public var legalStatusOfSupply: CodeableConcept.Builder? = null

    /**
     * Whether the Medicinal Product is subject to additional monitoring for regulatory reasons,
     * such as heightened reporting requirements.
     */
    public var additionalMonitoringIndicator: CodeableConcept.Builder? = null

    /**
     * Whether the Medicinal Product is subject to special measures for regulatory reasons, such as
     * a requirement to conduct post-authorisation studies.
     */
    public var specialMeasures: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** If authorised for use in children, or infants, neonates etc. */
    public var pediatricUseIndicator: CodeableConcept.Builder? = null

    /** Allows the product to be classified by various systems, commonly WHO ATC. */
    public var classification: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Marketing status of the medicinal product, in contrast to marketing authorization. This
     * refers to the product being actually 'on the market' as opposed to being allowed to be on the
     * market (which is an authorization).
     */
    public var marketingStatus: MutableList<MarketingStatus.Builder> = mutableListOf()

    /** Package type for the product. See also the PackagedProductDefinition resource. */
    public var packagedMedicinalProduct: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The ingredients of this medicinal product - when not detailed in other resources. This is
     * only needed if the ingredients are not specified by incoming references from the Ingredient
     * resource, or indirectly via incoming AdministrableProductDefinition,
     * PackagedProductDefinition or ManufacturedItemDefinition references. In cases where those
     * levels of detail are not used, the ingredients may be specified directly here as codes.
     */
    public var ingredient: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Any component of the drug product which is not the chemical entity defined as the drug
     * substance, or an excipient in the drug product. This includes process-related impurities and
     * contaminants, product-related impurities including degradation products.
     */
    public var impurity: MutableList<CodeableReference.Builder> = mutableListOf()

    /** Additional information or supporting documentation about the medicinal product. */
    public var attachedDocument: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A master file for the medicinal product (e.g. Pharmacovigilance System Master File). Drug
     * master files (DMFs) are documents submitted to regulatory agencies to provide confidential
     * detailed information about facilities, processes or articles used in the manufacturing,
     * processing, packaging and storing of drug products.
     */
    public var masterFile: MutableList<Reference.Builder> = mutableListOf()

    /** A product specific contact, person (in a role), or an organization. */
    public var contact: MutableList<Contact.Builder> = mutableListOf()

    /** Clinical trials or studies that this product is involved in. */
    public var clinicalTrial: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A code that this product is known by, usually within some formal terminology, perhaps
     * assigned by a third party (i.e. not the manufacturer or regulator). Products (types of
     * medications) tend to be known by identifiers during development and within regulatory
     * process. However when they are prescribed they tend to be identified by codes. The same
     * product may be have multiple codes, applied to it by multiple organizations.
     */
    public var code: MutableList<Coding.Builder> = mutableListOf()

    /**
     * Reference to another product, e.g. for linking authorised to investigational product, or a
     * virtual product.
     */
    public var crossReference: MutableList<CrossReference.Builder> = mutableListOf()

    /**
     * A manufacturing or administrative process or step associated with (or performed on) the
     * medicinal product.
     */
    public var operation: MutableList<Operation.Builder> = mutableListOf()

    /**
     * Allows the key product features to be recorded, such as "sugar free", "modified release",
     * "parallel import".
     */
    public var characteristic: MutableList<Characteristic.Builder> = mutableListOf()

    override fun build(): MedicinalProductDefinition =
      MedicinalProductDefinition(
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
        version = version?.build(),
        status = status?.build(),
        statusDate = statusDate?.build(),
        description = description?.build(),
        combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm?.build(),
        route = route.map { it.build() },
        indication = indication?.build(),
        legalStatusOfSupply = legalStatusOfSupply?.build(),
        additionalMonitoringIndicator = additionalMonitoringIndicator?.build(),
        specialMeasures = specialMeasures.map { it.build() },
        pediatricUseIndicator = pediatricUseIndicator?.build(),
        classification = classification.map { it.build() },
        marketingStatus = marketingStatus.map { it.build() },
        packagedMedicinalProduct = packagedMedicinalProduct.map { it.build() },
        ingredient = ingredient.map { it.build() },
        impurity = impurity.map { it.build() },
        attachedDocument = attachedDocument.map { it.build() },
        masterFile = masterFile.map { it.build() },
        contact = contact.map { it.build() },
        clinicalTrial = clinicalTrial.map { it.build() },
        code = code.map { it.build() },
        name = name.map { it.build() },
        crossReference = crossReference.map { it.build() },
        operation = operation.map { it.build() },
        characteristic = characteristic.map { it.build() },
      )
  }
}
