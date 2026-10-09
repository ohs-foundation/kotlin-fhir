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

import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialFractionDescriptionSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialOrganismAuthorSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialOrganismHybridSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialOrganismOrganismGeneralSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialOrganismSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialPartDescriptionSerializer
import dev.ohs.fhir.model.r4.serializers.SubstanceSourceMaterialSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Source material shall capture information on the taxonomic and anatomical origins as well as the
 * fraction of a material that can result in or can be modified to form a substance. This set of
 * data elements shall be used to define polymer substances isolated from biological matrices.
 * Taxonomic and anatomical origins shall be described using a controlled vocabulary as required.
 * This information is captured for naturally derived polymers ( . starch) and structurally diverse
 * substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh
 * material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For
 * Herbal preparations, the fraction information will be captured at the Substance information level
 * and additional information for herbal extracts will be captured at the Specified Substance Group
 * 1 information level. See for further explanation the Substance Class: Structurally Diverse and
 * the herbal annex.
 */
@Serializable(with = SubstanceSourceMaterialSerializer::class)
@SerialName("SubstanceSourceMaterial")
public data class SubstanceSourceMaterial(
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
   * General high level classification of the source material specific to the origin of the
   * material.
   */
  public val sourceMaterialClass: CodeableConcept? = null,
  /**
   * The type of the source material shall be specified based on a controlled vocabulary. For
   * vaccines, this subclause refers to the class of infectious agent.
   */
  public val sourceMaterialType: CodeableConcept? = null,
  /** The state of the source material when extracted. */
  public val sourceMaterialState: CodeableConcept? = null,
  /**
   * The unique identifier associated with the source material parent organism shall be specified.
   */
  public val organismId: Identifier? = null,
  /** The organism accepted Scientific name shall be provided based on the organism taxonomy. */
  public val organismName: String? = null,
  /**
   * The parent of the herbal drug Ginkgo biloba, Leaf is the substance ID of the substance (fresh)
   * of Ginkgo biloba L. or Ginkgo biloba L. (Whole plant).
   */
  public val parentSubstanceId: List<Identifier> = listOf(),
  /** The parent substance of the Herbal Drug, or Herbal preparation. */
  public val parentSubstanceName: List<String> = listOf(),
  /**
   * The country where the plant material is harvested or the countries where the plasma is sourced
   * from as laid down in accordance with the Plasma Master File. For “Plasma-derived substances”
   * the attribute country of origin provides information about the countries used for the
   * manufacturing of the Cryopoor plama or Crioprecipitate.
   */
  public val countryOfOrigin: List<CodeableConcept> = listOf(),
  /**
   * The place/region where the plant is harvested or the places/regions where the animal source
   * material has its habitat.
   */
  public val geographicalLocation: List<String> = listOf(),
  /**
   * Stage of life for animals, plants, insects and microorganisms. This information shall be
   * provided only when the substance is significantly different in these stages (e.g. foetal bovine
   * serum).
   */
  public val developmentStage: CodeableConcept? = null,
  /**
   * Many complex materials are fractions of parts of plants, animals, or minerals. Fraction
   * elements are often necessary to define both Substances and Specified Group 1 Substances. For
   * substances derived from Plants, fraction information will be captured at the Substance
   * information level ( . Oils, Juices and Exudates). Additional information for Extracts, such as
   * extraction solvent composition, will be captured at the Specified Substance Group 1 information
   * level. For plasma-derived products fraction information will be captured at the Substance and
   * the Specified Substance Group 1 levels.
   */
  public val fractionDescription: List<FractionDescription> = listOf(),
  /**
   * This subclause describes the organism which the substance is derived from. For vaccines, the
   * parent organism shall be specified based on these subclause elements. As an example, full
   * taxonomy will be described for the Substance Name: ., Leaf.
   */
  public val organism: Organism? = null,
  /** To do. */
  public val partDescription: List<PartDescription> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder()
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.sourceMaterialClass = sourceMaterialClass?.toBuilder()
    builder.sourceMaterialType = sourceMaterialType?.toBuilder()
    builder.sourceMaterialState = sourceMaterialState?.toBuilder()
    builder.organismId = organismId?.toBuilder()
    builder.organismName = organismName?.toBuilder()
    builder.parentSubstanceId = parentSubstanceId.toBuilderList()
    builder.parentSubstanceName = parentSubstanceName.toBuilderList()
    builder.countryOfOrigin = countryOfOrigin.toBuilderList()
    builder.geographicalLocation = geographicalLocation.toBuilderList()
    builder.developmentStage = developmentStage?.toBuilder()
    builder.fractionDescription = fractionDescription.toBuilderList()
    builder.organism = organism?.toBuilder()
    builder.partDescription = partDescription.toBuilderList()
    return builder
  }

  /**
   * Many complex materials are fractions of parts of plants, animals, or minerals. Fraction
   * elements are often necessary to define both Substances and Specified Group 1 Substances. For
   * substances derived from Plants, fraction information will be captured at the Substance
   * information level ( . Oils, Juices and Exudates). Additional information for Extracts, such as
   * extraction solvent composition, will be captured at the Specified Substance Group 1 information
   * level. For plasma-derived products fraction information will be captured at the Substance and
   * the Specified Substance Group 1 levels.
   */
  @Serializable(with = SubstanceSourceMaterialFractionDescriptionSerializer::class)
  public data class FractionDescription(
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
     * This element is capturing information about the fraction of a plant part, or human plasma for
     * fractionation.
     */
    public val fraction: String? = null,
    /**
     * The specific type of the material constituting the component. For Herbal preparations the
     * particulars of the extracts (liquid/dry) is described in Specified Substance Group 1.
     */
    public val materialType: CodeableConcept? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.fraction = fraction?.toBuilder()
      builder.materialType = materialType?.toBuilder()
      return builder
    }

    public class Builder() : FhirBuilder {
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
       * This element is capturing information about the fraction of a plant part, or human plasma
       * for fractionation.
       */
      public var fraction: String.Builder? = null

      /**
       * The specific type of the material constituting the component. For Herbal preparations the
       * particulars of the extracts (liquid/dry) is described in Specified Substance Group 1.
       */
      public var materialType: CodeableConcept.Builder? = null

      override fun build(): FractionDescription =
        FractionDescription(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          fraction = fraction?.build(),
          materialType = materialType?.build(),
        )
    }
  }

  /**
   * This subclause describes the organism which the substance is derived from. For vaccines, the
   * parent organism shall be specified based on these subclause elements. As an example, full
   * taxonomy will be described for the Substance Name: ., Leaf.
   */
  @Serializable(with = SubstanceSourceMaterialOrganismSerializer::class)
  public data class Organism(
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
    /** The family of an organism shall be specified. */
    public val family: CodeableConcept? = null,
    /**
     * The genus of an organism shall be specified; refers to the Latin epithet of the genus element
     * of the plant/animal scientific name; it is present in names for genera, species and
     * infraspecies.
     */
    public val genus: CodeableConcept? = null,
    /**
     * The species of an organism shall be specified; refers to the Latin epithet of the species of
     * the plant/animal; it is present in names for species and infraspecies.
     */
    public val species: CodeableConcept? = null,
    /** The Intraspecific type of an organism shall be specified. */
    public val intraspecificType: CodeableConcept? = null,
    /**
     * The intraspecific description of an organism shall be specified based on a controlled
     * vocabulary. For Influenza Vaccine, the intraspecific description shall contain the syntax of
     * the antigen in line with the WHO convention.
     */
    public val intraspecificDescription: String? = null,
    /** 4.9.13.6.1 Author type (Conditional). */
    public val author: List<Author> = listOf(),
    /** 4.9.13.8.1 Hybrid species maternal organism ID (Optional). */
    public val hybrid: Hybrid? = null,
    /** 4.9.13.7.1 Kingdom (Conditional). */
    public val organismGeneral: OrganismGeneral? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.family = family?.toBuilder()
      builder.genus = genus?.toBuilder()
      builder.species = species?.toBuilder()
      builder.intraspecificType = intraspecificType?.toBuilder()
      builder.intraspecificDescription = intraspecificDescription?.toBuilder()
      builder.author = author.toBuilderList()
      builder.hybrid = hybrid?.toBuilder()
      builder.organismGeneral = organismGeneral?.toBuilder()
      return builder
    }

    /** 4.9.13.6.1 Author type (Conditional). */
    @Serializable(with = SubstanceSourceMaterialOrganismAuthorSerializer::class)
    public data class Author(
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
      /**
       * The type of author of an organism species shall be specified. The parenthetical author of
       * an organism species refers to the first author who published the plant/animal name (of any
       * rank). The primary author of an organism species refers to the first author(s), who validly
       * published the plant/animal name.
       */
      public val authorType: CodeableConcept? = null,
      /**
       * The author of an organism species shall be specified. The author year of an organism shall
       * also be specified when applicable; refers to the year in which the first author(s)
       * published the infraspecific plant/animal name (of any rank).
       */
      public val authorDescription: String? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.authorType = authorType?.toBuilder()
        builder.authorDescription = authorDescription?.toBuilder()
        return builder
      }

      public class Builder() : FhirBuilder {
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
         * The type of author of an organism species shall be specified. The parenthetical author of
         * an organism species refers to the first author who published the plant/animal name (of
         * any rank). The primary author of an organism species refers to the first author(s), who
         * validly published the plant/animal name.
         */
        public var authorType: CodeableConcept.Builder? = null

        /**
         * The author of an organism species shall be specified. The author year of an organism
         * shall also be specified when applicable; refers to the year in which the first author(s)
         * published the infraspecific plant/animal name (of any rank).
         */
        public var authorDescription: String.Builder? = null

        override fun build(): Author =
          Author(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            authorType = authorType?.build(),
            authorDescription = authorDescription?.build(),
          )
      }
    }

    /** 4.9.13.8.1 Hybrid species maternal organism ID (Optional). */
    @Serializable(with = SubstanceSourceMaterialOrganismHybridSerializer::class)
    public data class Hybrid(
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
      /**
       * The identifier of the maternal species constituting the hybrid organism shall be specified
       * based on a controlled vocabulary. For plants, the parents aren’t always known, and it is
       * unlikely that it will be known which is maternal and which is paternal.
       */
      public val maternalOrganismId: String? = null,
      /**
       * The name of the maternal species constituting the hybrid organism shall be specified. For
       * plants, the parents aren’t always known, and it is unlikely that it will be known which is
       * maternal and which is paternal.
       */
      public val maternalOrganismName: String? = null,
      /**
       * The identifier of the paternal species constituting the hybrid organism shall be specified
       * based on a controlled vocabulary.
       */
      public val paternalOrganismId: String? = null,
      /** The name of the paternal species constituting the hybrid organism shall be specified. */
      public val paternalOrganismName: String? = null,
      /** The hybrid type of an organism shall be specified. */
      public val hybridType: CodeableConcept? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.maternalOrganismId = maternalOrganismId?.toBuilder()
        builder.maternalOrganismName = maternalOrganismName?.toBuilder()
        builder.paternalOrganismId = paternalOrganismId?.toBuilder()
        builder.paternalOrganismName = paternalOrganismName?.toBuilder()
        builder.hybridType = hybridType?.toBuilder()
        return builder
      }

      public class Builder() : FhirBuilder {
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
         * The identifier of the maternal species constituting the hybrid organism shall be
         * specified based on a controlled vocabulary. For plants, the parents aren’t always known,
         * and it is unlikely that it will be known which is maternal and which is paternal.
         */
        public var maternalOrganismId: String.Builder? = null

        /**
         * The name of the maternal species constituting the hybrid organism shall be specified. For
         * plants, the parents aren’t always known, and it is unlikely that it will be known which
         * is maternal and which is paternal.
         */
        public var maternalOrganismName: String.Builder? = null

        /**
         * The identifier of the paternal species constituting the hybrid organism shall be
         * specified based on a controlled vocabulary.
         */
        public var paternalOrganismId: String.Builder? = null

        /** The name of the paternal species constituting the hybrid organism shall be specified. */
        public var paternalOrganismName: String.Builder? = null

        /** The hybrid type of an organism shall be specified. */
        public var hybridType: CodeableConcept.Builder? = null

        override fun build(): Hybrid =
          Hybrid(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            maternalOrganismId = maternalOrganismId?.build(),
            maternalOrganismName = maternalOrganismName?.build(),
            paternalOrganismId = paternalOrganismId?.build(),
            paternalOrganismName = paternalOrganismName?.build(),
            hybridType = hybridType?.build(),
          )
      }
    }

    /** 4.9.13.7.1 Kingdom (Conditional). */
    @Serializable(with = SubstanceSourceMaterialOrganismOrganismGeneralSerializer::class)
    public data class OrganismGeneral(
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
      /** The kingdom of an organism shall be specified. */
      public val kingdom: CodeableConcept? = null,
      /** The phylum of an organism shall be specified. */
      public val phylum: CodeableConcept? = null,
      /** The class of an organism shall be specified. */
      public val `class`: CodeableConcept? = null,
      /** The order of an organism shall be specified,. */
      public val order: CodeableConcept? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.kingdom = kingdom?.toBuilder()
        builder.phylum = phylum?.toBuilder()
        builder.`class` = `class`?.toBuilder()
        builder.order = order?.toBuilder()
        return builder
      }

      public class Builder() : FhirBuilder {
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

        /** The kingdom of an organism shall be specified. */
        public var kingdom: CodeableConcept.Builder? = null

        /** The phylum of an organism shall be specified. */
        public var phylum: CodeableConcept.Builder? = null

        /** The class of an organism shall be specified. */
        public var `class`: CodeableConcept.Builder? = null

        /** The order of an organism shall be specified,. */
        public var order: CodeableConcept.Builder? = null

        override fun build(): OrganismGeneral =
          OrganismGeneral(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            kingdom = kingdom?.build(),
            phylum = phylum?.build(),
            `class` = `class`?.build(),
            order = order?.build(),
          )
      }
    }

    public class Builder() : FhirBuilder {
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

      /** The family of an organism shall be specified. */
      public var family: CodeableConcept.Builder? = null

      /**
       * The genus of an organism shall be specified; refers to the Latin epithet of the genus
       * element of the plant/animal scientific name; it is present in names for genera, species and
       * infraspecies.
       */
      public var genus: CodeableConcept.Builder? = null

      /**
       * The species of an organism shall be specified; refers to the Latin epithet of the species
       * of the plant/animal; it is present in names for species and infraspecies.
       */
      public var species: CodeableConcept.Builder? = null

      /** The Intraspecific type of an organism shall be specified. */
      public var intraspecificType: CodeableConcept.Builder? = null

      /**
       * The intraspecific description of an organism shall be specified based on a controlled
       * vocabulary. For Influenza Vaccine, the intraspecific description shall contain the syntax
       * of the antigen in line with the WHO convention.
       */
      public var intraspecificDescription: String.Builder? = null

      /** 4.9.13.6.1 Author type (Conditional). */
      public var author: MutableList<Author.Builder> = mutableListOf()

      /** 4.9.13.8.1 Hybrid species maternal organism ID (Optional). */
      public var hybrid: Hybrid.Builder? = null

      /** 4.9.13.7.1 Kingdom (Conditional). */
      public var organismGeneral: OrganismGeneral.Builder? = null

      override fun build(): Organism =
        Organism(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          family = family?.build(),
          genus = genus?.build(),
          species = species?.build(),
          intraspecificType = intraspecificType?.build(),
          intraspecificDescription = intraspecificDescription?.build(),
          author = author.buildList(),
          hybrid = hybrid?.build(),
          organismGeneral = organismGeneral?.build(),
        )
    }
  }

  /** To do. */
  @Serializable(with = SubstanceSourceMaterialPartDescriptionSerializer::class)
  public data class PartDescription(
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
    /** Entity of anatomical origin of source material within an organism. */
    public val part: CodeableConcept? = null,
    /**
     * The detailed anatomic location when the part can be extracted from different anatomical
     * locations of the organism. Multiple alternative locations may apply.
     */
    public val partLocation: CodeableConcept? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.part = part?.toBuilder()
      builder.partLocation = partLocation?.toBuilder()
      return builder
    }

    public class Builder() : FhirBuilder {
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

      /** Entity of anatomical origin of source material within an organism. */
      public var part: CodeableConcept.Builder? = null

      /**
       * The detailed anatomic location when the part can be extracted from different anatomical
       * locations of the organism. Multiple alternative locations may apply.
       */
      public var partLocation: CodeableConcept.Builder? = null

      override fun build(): PartDescription =
        PartDescription(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          part = part?.build(),
          partLocation = partLocation?.build(),
        )
    }
  }

  public class Builder() : DomainResource.Builder() {
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
     * General high level classification of the source material specific to the origin of the
     * material.
     */
    public var sourceMaterialClass: CodeableConcept.Builder? = null

    /**
     * The type of the source material shall be specified based on a controlled vocabulary. For
     * vaccines, this subclause refers to the class of infectious agent.
     */
    public var sourceMaterialType: CodeableConcept.Builder? = null

    /** The state of the source material when extracted. */
    public var sourceMaterialState: CodeableConcept.Builder? = null

    /**
     * The unique identifier associated with the source material parent organism shall be specified.
     */
    public var organismId: Identifier.Builder? = null

    /** The organism accepted Scientific name shall be provided based on the organism taxonomy. */
    public var organismName: String.Builder? = null

    /**
     * The parent of the herbal drug Ginkgo biloba, Leaf is the substance ID of the substance
     * (fresh) of Ginkgo biloba L. or Ginkgo biloba L. (Whole plant).
     */
    public var parentSubstanceId: MutableList<Identifier.Builder> = mutableListOf()

    /** The parent substance of the Herbal Drug, or Herbal preparation. */
    public var parentSubstanceName: MutableList<String.Builder> = mutableListOf()

    /**
     * The country where the plant material is harvested or the countries where the plasma is
     * sourced from as laid down in accordance with the Plasma Master File. For “Plasma-derived
     * substances” the attribute country of origin provides information about the countries used for
     * the manufacturing of the Cryopoor plama or Crioprecipitate.
     */
    public var countryOfOrigin: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The place/region where the plant is harvested or the places/regions where the animal source
     * material has its habitat.
     */
    public var geographicalLocation: MutableList<String.Builder> = mutableListOf()

    /**
     * Stage of life for animals, plants, insects and microorganisms. This information shall be
     * provided only when the substance is significantly different in these stages (e.g. foetal
     * bovine serum).
     */
    public var developmentStage: CodeableConcept.Builder? = null

    /**
     * Many complex materials are fractions of parts of plants, animals, or minerals. Fraction
     * elements are often necessary to define both Substances and Specified Group 1 Substances. For
     * substances derived from Plants, fraction information will be captured at the Substance
     * information level ( . Oils, Juices and Exudates). Additional information for Extracts, such
     * as extraction solvent composition, will be captured at the Specified Substance Group 1
     * information level. For plasma-derived products fraction information will be captured at the
     * Substance and the Specified Substance Group 1 levels.
     */
    public var fractionDescription: MutableList<FractionDescription.Builder> = mutableListOf()

    /**
     * This subclause describes the organism which the substance is derived from. For vaccines, the
     * parent organism shall be specified based on these subclause elements. As an example, full
     * taxonomy will be described for the Substance Name: ., Leaf.
     */
    public var organism: Organism.Builder? = null

    /** To do. */
    public var partDescription: MutableList<PartDescription.Builder> = mutableListOf()

    override fun build(): SubstanceSourceMaterial =
      SubstanceSourceMaterial(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        sourceMaterialClass = sourceMaterialClass?.build(),
        sourceMaterialType = sourceMaterialType?.build(),
        sourceMaterialState = sourceMaterialState?.build(),
        organismId = organismId?.build(),
        organismName = organismName?.build(),
        parentSubstanceId = parentSubstanceId.buildList(),
        parentSubstanceName = parentSubstanceName.buildList(),
        countryOfOrigin = countryOfOrigin.buildList(),
        geographicalLocation = geographicalLocation.buildList(),
        developmentStage = developmentStage?.build(),
        fractionDescription = fractionDescription.buildList(),
        organism = organism?.build(),
        partDescription = partDescription.buildList(),
      )
  }
}
