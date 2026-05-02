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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionCharacterizationSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionCodeSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionMoietyAmountSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionMoietySerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionMolecularWeightSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionNameOfficialSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionNameSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionPropertySerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionPropertyValueSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionRelationshipAmountSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionRelationshipSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionRelationshipSubstanceDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionSourceMaterialSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionStructureRepresentationSerializer
import dev.ohs.fhir.model.r5.serializers.SubstanceDefinitionStructureSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The detailed description of a substance, typically at a level beyond what is used for
 * prescribing.
 */
@Serializable(with = SubstanceDefinitionSerializer::class)
@SerialName("SubstanceDefinition")
public data class SubstanceDefinition(
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
  override val language: dev.ohs.fhir.model.r5.Code? = null,
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
  /** Identifier by which this substance is known. */
  public val identifier: List<Identifier> = listOf(),
  /** A business level version identifier of the substance. */
  public val version: String? = null,
  /** Status of substance within the catalogue e.g. active, retired. */
  public val status: CodeableConcept? = null,
  /**
   * A high level categorization, e.g. polymer or nucleic acid, or food, chemical, biological, or a
   * lower level such as the general types of polymer (linear or branch chain) or type of impurity
   * (process related or contaminant).
   */
  public val classification: List<CodeableConcept> = listOf(),
  /** If the substance applies to human or veterinary use. */
  public val domain: CodeableConcept? = null,
  /**
   * The quality standard, established benchmark, to which substance complies (e.g. USP/NF, Ph. Eur,
   * JP, BP, Company Standard).
   */
  public val grade: List<CodeableConcept> = listOf(),
  /** Textual description of the substance. */
  public val description: Markdown? = null,
  /** Supporting literature. */
  public val informationSource: List<Reference> = listOf(),
  /** Textual comment about the substance's catalogue or registry record. */
  public val note: List<Annotation> = listOf(),
  /**
   * The entity that creates, makes, produces or fabricates the substance. This is a set of
   * potential manufacturers but is not necessarily comprehensive.
   */
  public val manufacturer: List<Reference> = listOf(),
  /**
   * An entity that is the source for the substance. It may be different from the manufacturer.
   * Supplier is synonymous to a distributor.
   */
  public val supplier: List<Reference> = listOf(),
  /** Moiety, for structural modifications. */
  public val moiety: List<Moiety> = listOf(),
  /** General specifications for this substance. */
  public val characterization: List<Characterization> = listOf(),
  /** General specifications for this substance. */
  public val `property`: List<Property> = listOf(),
  /** General information detailing this substance. */
  public val referenceInformation: Reference? = null,
  /**
   * The average mass of a molecule of a compound compared to 1/12 the mass of carbon 12 and
   * calculated as the sum of the atomic weights of the constituent atoms.
   */
  public val molecularWeight: List<MolecularWeight> = listOf(),
  /** Structural information. */
  public val structure: Structure? = null,
  /** Codes associated with the substance. */
  public val code: List<Code> = listOf(),
  /** Names applicable to this substance. */
  public val name: List<Name> = listOf(),
  /** A link between this substance and another, with details of the relationship. */
  public val relationship: List<Relationship> = listOf(),
  /** Data items specific to nucleic acids. */
  public val nucleicAcid: Reference? = null,
  /** Data items specific to polymers. */
  public val polymer: Reference? = null,
  /** Data items specific to proteins. */
  public val protein: Reference? = null,
  /** Material or taxonomic/anatomical source for the substance. */
  public val sourceMaterial: SourceMaterial? = null,
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
        version = this@with.version?.toBuilder()
        status = this@with.status?.toBuilder()
        classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        domain = this@with.domain?.toBuilder()
        grade = this@with.grade.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        informationSource = this@with.informationSource.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        manufacturer = this@with.manufacturer.map { it.toBuilder() }.toMutableList()
        supplier = this@with.supplier.map { it.toBuilder() }.toMutableList()
        moiety = this@with.moiety.map { it.toBuilder() }.toMutableList()
        characterization = this@with.characterization.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        referenceInformation = this@with.referenceInformation?.toBuilder()
        molecularWeight = this@with.molecularWeight.map { it.toBuilder() }.toMutableList()
        structure = this@with.structure?.toBuilder()
        code = this@with.code.map { it.toBuilder() }.toMutableList()
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        relationship = this@with.relationship.map { it.toBuilder() }.toMutableList()
        nucleicAcid = this@with.nucleicAcid?.toBuilder()
        polymer = this@with.polymer?.toBuilder()
        protein = this@with.protein?.toBuilder()
        sourceMaterial = this@with.sourceMaterial?.toBuilder()
      }
    }

  /** Moiety, for structural modifications. */
  @Serializable(with = SubstanceDefinitionMoietySerializer::class)
  public data class Moiety(
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
    /** Role that the moiety is playing. */
    public val role: CodeableConcept? = null,
    /** Identifier by which this moiety substance is known. */
    public val identifier: Identifier? = null,
    /** Textual name for this moiety substance. */
    public val name: String? = null,
    /** Stereochemistry type. */
    public val stereochemistry: CodeableConcept? = null,
    /** Optical activity type. */
    public val opticalActivity: CodeableConcept? = null,
    /** Molecular formula for this moiety of this substance, typically using the Hill system. */
    public val molecularFormula: String? = null,
    /** Quantitative value for this moiety. */
    public val amount: Amount? = null,
    /**
     * The measurement type of the quantitative value. In capturing the actual relative amounts of
     * substances or molecular fragments it may be necessary to indicate whether the amount refers
     * to, for example, a mole ratio or weight ratio.
     */
    public val measurementType: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          role = this@with.role?.toBuilder()
          identifier = this@with.identifier?.toBuilder()
          name = this@with.name?.toBuilder()
          stereochemistry = this@with.stereochemistry?.toBuilder()
          opticalActivity = this@with.opticalActivity?.toBuilder()
          molecularFormula = this@with.molecularFormula?.toBuilder()
          amount = this@with.amount
          measurementType = this@with.measurementType?.toBuilder()
        }
      }

    @Serializable(with = SubstanceDefinitionMoietyAmountSerializer::class)
    public sealed interface Amount {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asString(): String? = this as? String

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Amount

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Amount

      public companion object {
        internal fun from(
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          stringValue: dev.ohs.fhir.model.r5.String?,
        ): Amount? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (stringValue != null) return String(stringValue)
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

      /** Role that the moiety is playing. */
      public var role: CodeableConcept.Builder? = null

      /** Identifier by which this moiety substance is known. */
      public var identifier: Identifier.Builder? = null

      /** Textual name for this moiety substance. */
      public var name: String.Builder? = null

      /** Stereochemistry type. */
      public var stereochemistry: CodeableConcept.Builder? = null

      /** Optical activity type. */
      public var opticalActivity: CodeableConcept.Builder? = null

      /** Molecular formula for this moiety of this substance, typically using the Hill system. */
      public var molecularFormula: String.Builder? = null

      /** Quantitative value for this moiety. */
      public var amount: Amount? = null

      /**
       * The measurement type of the quantitative value. In capturing the actual relative amounts of
       * substances or molecular fragments it may be necessary to indicate whether the amount refers
       * to, for example, a mole ratio or weight ratio.
       */
      public var measurementType: CodeableConcept.Builder? = null

      public fun build(): Moiety =
        Moiety(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          role = role?.build(),
          identifier = identifier?.build(),
          name = name?.build(),
          stereochemistry = stereochemistry?.build(),
          opticalActivity = opticalActivity?.build(),
          molecularFormula = molecularFormula?.build(),
          amount = amount,
          measurementType = measurementType?.build(),
        )
    }
  }

  /** General specifications for this substance. */
  @Serializable(with = SubstanceDefinitionCharacterizationSerializer::class)
  public data class Characterization(
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
    /** The method used to elucidate the characterization of the drug substance. Example: HPLC. */
    public val technique: CodeableConcept? = null,
    /**
     * Describes the nature of the chemical entity and explains, for instance, whether this is a
     * base or a salt form.
     */
    public val form: CodeableConcept? = null,
    /** The description or justification in support of the interpretation of the data file. */
    public val description: Markdown? = null,
    /**
     * The data produced by the analytical instrument or a pictorial representation of that data.
     * Examples: a JCAMP, JDX, or ADX file, or a chromatogram or spectrum analysis.
     */
    public val `file`: List<Attachment> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          technique = this@with.technique?.toBuilder()
          form = this@with.form?.toBuilder()
          description = this@with.description?.toBuilder()
          `file` = this@with.`file`.map { it.toBuilder() }.toMutableList()
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

      /** The method used to elucidate the characterization of the drug substance. Example: HPLC. */
      public var technique: CodeableConcept.Builder? = null

      /**
       * Describes the nature of the chemical entity and explains, for instance, whether this is a
       * base or a salt form.
       */
      public var form: CodeableConcept.Builder? = null

      /** The description or justification in support of the interpretation of the data file. */
      public var description: Markdown.Builder? = null

      /**
       * The data produced by the analytical instrument or a pictorial representation of that data.
       * Examples: a JCAMP, JDX, or ADX file, or a chromatogram or spectrum analysis.
       */
      public var `file`: MutableList<Attachment.Builder> = mutableListOf()

      public fun build(): Characterization =
        Characterization(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          technique = technique?.build(),
          form = form?.build(),
          description = description?.build(),
          `file` = `file`.map { it.build() },
        )
    }
  }

  /** General specifications for this substance. */
  @Serializable(with = SubstanceDefinitionPropertySerializer::class)
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
    /** A code expressing the type of property. */
    public val type: CodeableConcept,
    /** A value for the property. */
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

    @Serializable(with = SubstanceDefinitionPropertyValueSerializer::class)
    public sealed interface Value {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asDate(): Date? = this as? Date

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asAttachment(): Attachment? = this as? Attachment

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Date(public val `value`: dev.ohs.fhir.model.r5.Date) : Value

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

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
      /** A code expressing the type of property. */
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

      /** A value for the property. */
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
   * The average mass of a molecule of a compound compared to 1/12 the mass of carbon 12 and
   * calculated as the sum of the atomic weights of the constituent atoms.
   */
  @Serializable(with = SubstanceDefinitionMolecularWeightSerializer::class)
  public data class MolecularWeight(
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
    /** The method by which the molecular weight was determined. */
    public val method: CodeableConcept? = null,
    /**
     * Type of molecular weight such as exact, average (also known as. number average), weight
     * average.
     */
    public val type: CodeableConcept? = null,
    /**
     * Used to capture quantitative values for a variety of elements. If only limits are given, the
     * arithmetic mean would be the average. If only a single definite value for a given element is
     * given, it would be captured in this field.
     */
    public val amount: Quantity,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(amount.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          method = this@with.method?.toBuilder()
          type = this@with.type?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Used to capture quantitative values for a variety of elements. If only limits are given,
       * the arithmetic mean would be the average. If only a single definite value for a given
       * element is given, it would be captured in this field.
       */
      public var amount: Quantity.Builder
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

      /** The method by which the molecular weight was determined. */
      public var method: CodeableConcept.Builder? = null

      /**
       * Type of molecular weight such as exact, average (also known as. number average), weight
       * average.
       */
      public var type: CodeableConcept.Builder? = null

      public fun build(): MolecularWeight =
        MolecularWeight(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          method = method?.build(),
          type = type?.build(),
          amount = amount.build(),
        )
    }
  }

  /** Structural information. */
  @Serializable(with = SubstanceDefinitionStructureSerializer::class)
  public data class Structure(
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
    /** Stereochemistry type. */
    public val stereochemistry: CodeableConcept? = null,
    /** Optical activity type. */
    public val opticalActivity: CodeableConcept? = null,
    /**
     * An expression which states the number and type of atoms present in a molecule of a substance.
     */
    public val molecularFormula: String? = null,
    /**
     * Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical,
     * each moiety separated by a dot.
     */
    public val molecularFormulaByMoiety: String? = null,
    /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
    public val molecularWeight: MolecularWeight? = null,
    /**
     * The method used to elucidate the structure of the drug substance. Examples: X-ray, NMR,
     * Peptide mapping, Ligand binding assay.
     */
    public val technique: List<CodeableConcept> = listOf(),
    /** The source of information about the structure. */
    public val sourceDocument: List<Reference> = listOf(),
    /** A depiction of the structure of the substance. */
    public val representation: List<Representation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          stereochemistry = this@with.stereochemistry?.toBuilder()
          opticalActivity = this@with.opticalActivity?.toBuilder()
          molecularFormula = this@with.molecularFormula?.toBuilder()
          molecularFormulaByMoiety = this@with.molecularFormulaByMoiety?.toBuilder()
          molecularWeight = this@with.molecularWeight?.toBuilder()
          technique = this@with.technique.map { it.toBuilder() }.toMutableList()
          sourceDocument = this@with.sourceDocument.map { it.toBuilder() }.toMutableList()
          representation = this@with.representation.map { it.toBuilder() }.toMutableList()
        }
      }

    /** A depiction of the structure of the substance. */
    @Serializable(with = SubstanceDefinitionStructureRepresentationSerializer::class)
    public data class Representation(
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
      /** The kind of structural representation (e.g. full, partial). */
      public val type: CodeableConcept? = null,
      /** The structural representation as a text string in a standard format. */
      public val representation: String? = null,
      /**
       * The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF. The
       * logical content type rather than the physical file format of a document.
       */
      public val format: CodeableConcept? = null,
      /**
       * An attached file with the structural representation e.g. a molecular structure graphic of
       * the substance, a JCAMP or AnIML file.
       */
      public val document: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            representation = this@with.representation?.toBuilder()
            format = this@with.format?.toBuilder()
            document = this@with.document?.toBuilder()
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

        /** The kind of structural representation (e.g. full, partial). */
        public var type: CodeableConcept.Builder? = null

        /** The structural representation as a text string in a standard format. */
        public var representation: String.Builder? = null

        /**
         * The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF. The
         * logical content type rather than the physical file format of a document.
         */
        public var format: CodeableConcept.Builder? = null

        /**
         * An attached file with the structural representation e.g. a molecular structure graphic of
         * the substance, a JCAMP or AnIML file.
         */
        public var document: Reference.Builder? = null

        public fun build(): Representation =
          Representation(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            representation = representation?.build(),
            format = format?.build(),
            document = document?.build(),
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

      /** Stereochemistry type. */
      public var stereochemistry: CodeableConcept.Builder? = null

      /** Optical activity type. */
      public var opticalActivity: CodeableConcept.Builder? = null

      /**
       * An expression which states the number and type of atoms present in a molecule of a
       * substance.
       */
      public var molecularFormula: String.Builder? = null

      /**
       * Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical,
       * each moiety separated by a dot.
       */
      public var molecularFormulaByMoiety: String.Builder? = null

      /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
      public var molecularWeight: MolecularWeight.Builder? = null

      /**
       * The method used to elucidate the structure of the drug substance. Examples: X-ray, NMR,
       * Peptide mapping, Ligand binding assay.
       */
      public var technique: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The source of information about the structure. */
      public var sourceDocument: MutableList<Reference.Builder> = mutableListOf()

      /** A depiction of the structure of the substance. */
      public var representation: MutableList<Representation.Builder> = mutableListOf()

      public fun build(): Structure =
        Structure(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          stereochemistry = stereochemistry?.build(),
          opticalActivity = opticalActivity?.build(),
          molecularFormula = molecularFormula?.build(),
          molecularFormulaByMoiety = molecularFormulaByMoiety?.build(),
          molecularWeight = molecularWeight?.build(),
          technique = technique.map { it.build() },
          sourceDocument = sourceDocument.map { it.build() },
          representation = representation.map { it.build() },
        )
    }
  }

  /** Codes associated with the substance. */
  @Serializable(with = SubstanceDefinitionCodeSerializer::class)
  public data class Code(
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
    /** The specific code. */
    public val code: CodeableConcept? = null,
    /** Status of the code assignment, for example 'provisional', 'approved'. */
    public val status: CodeableConcept? = null,
    /** The date at which the code status was changed as part of the terminology maintenance. */
    public val statusDate: DateTime? = null,
    /** Any comment can be provided in this field, if necessary. */
    public val note: List<Annotation> = listOf(),
    /** Supporting literature. */
    public val source: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code?.toBuilder()
          status = this@with.status?.toBuilder()
          statusDate = this@with.statusDate?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
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

      /** The specific code. */
      public var code: CodeableConcept.Builder? = null

      /** Status of the code assignment, for example 'provisional', 'approved'. */
      public var status: CodeableConcept.Builder? = null

      /** The date at which the code status was changed as part of the terminology maintenance. */
      public var statusDate: DateTime.Builder? = null

      /** Any comment can be provided in this field, if necessary. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      /** Supporting literature. */
      public var source: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Code =
        Code(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code?.build(),
          status = status?.build(),
          statusDate = statusDate?.build(),
          note = note.map { it.build() },
          source = source.map { it.build() },
        )
    }
  }

  /** Names applicable to this substance. */
  @Serializable(with = SubstanceDefinitionNameSerializer::class)
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
    /** The actual name. */
    public val name: String,
    /** Name type, for example 'systematic', 'scientific, 'brand'. */
    public val type: CodeableConcept? = null,
    /** The status of the name, for example 'current', 'proposed'. */
    public val status: CodeableConcept? = null,
    /** If this is the preferred name for this substance. */
    public val preferred: Boolean? = null,
    /** Human language that the name is written in. */
    public val language: List<CodeableConcept> = listOf(),
    /**
     * The use context of this name for example if there is a different name a drug active
     * ingredient as opposed to a food colour additive.
     */
    public val domain: List<CodeableConcept> = listOf(),
    /** The jurisdiction where this name applies. */
    public val jurisdiction: List<CodeableConcept> = listOf(),
    /** A synonym of this particular name, by which the substance is also known. */
    public val synonym: List<Name> = listOf(),
    /** A translation for this name into another human language. */
    public val translation: List<Name> = listOf(),
    /** Details of the official nature of this name. */
    public val official: List<Official> = listOf(),
    /** Supporting literature. */
    public val source: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          status = this@with.status?.toBuilder()
          preferred = this@with.preferred?.toBuilder()
          language = this@with.language.map { it.toBuilder() }.toMutableList()
          domain = this@with.domain.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          synonym = this@with.synonym.map { it.toBuilder() }.toMutableList()
          translation = this@with.translation.map { it.toBuilder() }.toMutableList()
          official = this@with.official.map { it.toBuilder() }.toMutableList()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Details of the official nature of this name. */
    @Serializable(with = SubstanceDefinitionNameOfficialSerializer::class)
    public data class Official(
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
      /** Which authority uses this official name. */
      public val authority: CodeableConcept? = null,
      /** The status of the official name, for example 'draft', 'active', 'retired'. */
      public val status: CodeableConcept? = null,
      /** Date of the official name change. */
      public val date: DateTime? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            authority = this@with.authority?.toBuilder()
            status = this@with.status?.toBuilder()
            date = this@with.date?.toBuilder()
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

        /** Which authority uses this official name. */
        public var authority: CodeableConcept.Builder? = null

        /** The status of the official name, for example 'draft', 'active', 'retired'. */
        public var status: CodeableConcept.Builder? = null

        /** Date of the official name change. */
        public var date: DateTime.Builder? = null

        public fun build(): Official =
          Official(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            authority = authority?.build(),
            status = status?.build(),
            date = date?.build(),
          )
      }
    }

    public class Builder(
      /** The actual name. */
      public var name: String.Builder
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

      /** Name type, for example 'systematic', 'scientific, 'brand'. */
      public var type: CodeableConcept.Builder? = null

      /** The status of the name, for example 'current', 'proposed'. */
      public var status: CodeableConcept.Builder? = null

      /** If this is the preferred name for this substance. */
      public var preferred: Boolean.Builder? = null

      /** Human language that the name is written in. */
      public var language: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The use context of this name for example if there is a different name a drug active
       * ingredient as opposed to a food colour additive.
       */
      public var domain: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The jurisdiction where this name applies. */
      public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A synonym of this particular name, by which the substance is also known. */
      public var synonym: MutableList<Builder> = mutableListOf()

      /** A translation for this name into another human language. */
      public var translation: MutableList<Builder> = mutableListOf()

      /** Details of the official nature of this name. */
      public var official: MutableList<Official.Builder> = mutableListOf()

      /** Supporting literature. */
      public var source: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Name =
        Name(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          type = type?.build(),
          status = status?.build(),
          preferred = preferred?.build(),
          language = language.map { it.build() },
          domain = domain.map { it.build() },
          jurisdiction = jurisdiction.map { it.build() },
          synonym = synonym.map { it.build() },
          translation = translation.map { it.build() },
          official = official.map { it.build() },
          source = source.map { it.build() },
        )
    }
  }

  /** A link between this substance and another, with details of the relationship. */
  @Serializable(with = SubstanceDefinitionRelationshipSerializer::class)
  public data class Relationship(
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
    /** A pointer to another substance, as a resource or just a representational code. */
    public val substanceDefinition: SubstanceDefinition? = null,
    /**
     * For example "salt to parent", "active moiety", "starting material", "polymorph", "impurity
     * of".
     */
    public val type: CodeableConcept,
    /**
     * For example where an enzyme strongly bonds with a particular substance, this is a defining
     * relationship for that enzyme, out of several possible substance relationships.
     */
    public val isDefining: Boolean? = null,
    /**
     * A numeric factor for the relationship, for instance to express that the salt of a substance
     * has some percentage of the active substance in relation to some other.
     */
    public val amount: Amount? = null,
    /** For use when the numeric has an uncertain range. */
    public val ratioHighLimitAmount: Ratio? = null,
    /** An operator for the amount, for example "average", "approximately", "less than". */
    public val comparator: CodeableConcept? = null,
    /** Supporting literature. */
    public val source: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          substanceDefinition = this@with.substanceDefinition
          isDefining = this@with.isDefining?.toBuilder()
          amount = this@with.amount
          ratioHighLimitAmount = this@with.ratioHighLimitAmount?.toBuilder()
          comparator = this@with.comparator?.toBuilder()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
        }
      }

    @Serializable(with = SubstanceDefinitionRelationshipSubstanceDefinitionSerializer::class)
    public sealed interface SubstanceDefinition {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) :
        SubstanceDefinition

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        SubstanceDefinition

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): SubstanceDefinition? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    @Serializable(with = SubstanceDefinitionRelationshipAmountSerializer::class)
    public sealed interface Amount {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asString(): String? = this as? String

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Amount

      public data class Ratio(public val `value`: dev.ohs.fhir.model.r5.Ratio) : Amount

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Amount

      public companion object {
        internal fun from(
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          ratioValue: dev.ohs.fhir.model.r5.Ratio?,
          stringValue: dev.ohs.fhir.model.r5.String?,
        ): Amount? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (stringValue != null) return String(stringValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * For example "salt to parent", "active moiety", "starting material", "polymorph", "impurity
       * of".
       */
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

      /** A pointer to another substance, as a resource or just a representational code. */
      public var substanceDefinition: SubstanceDefinition? = null

      /**
       * For example where an enzyme strongly bonds with a particular substance, this is a defining
       * relationship for that enzyme, out of several possible substance relationships.
       */
      public var isDefining: Boolean.Builder? = null

      /**
       * A numeric factor for the relationship, for instance to express that the salt of a substance
       * has some percentage of the active substance in relation to some other.
       */
      public var amount: Amount? = null

      /** For use when the numeric has an uncertain range. */
      public var ratioHighLimitAmount: Ratio.Builder? = null

      /** An operator for the amount, for example "average", "approximately", "less than". */
      public var comparator: CodeableConcept.Builder? = null

      /** Supporting literature. */
      public var source: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Relationship =
        Relationship(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          substanceDefinition = substanceDefinition,
          type = type.build(),
          isDefining = isDefining?.build(),
          amount = amount,
          ratioHighLimitAmount = ratioHighLimitAmount?.build(),
          comparator = comparator?.build(),
          source = source.map { it.build() },
        )
    }
  }

  /** Material or taxonomic/anatomical source for the substance. */
  @Serializable(with = SubstanceDefinitionSourceMaterialSerializer::class)
  public data class SourceMaterial(
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
     * A classification that provides the origin of the raw material. Example: cat hair would be an
     * Animal source type.
     */
    public val type: CodeableConcept? = null,
    /**
     * The genus of an organism, typically referring to the Latin epithet of the genus element of
     * the plant/animal scientific name.
     */
    public val genus: CodeableConcept? = null,
    /**
     * The species of an organism, typically referring to the Latin epithet of the species of the
     * plant/animal.
     */
    public val species: CodeableConcept? = null,
    /** An anatomical origin of the source material within an organism. */
    public val part: CodeableConcept? = null,
    /** The country or countries where the material is harvested. */
    public val countryOfOrigin: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          genus = this@with.genus?.toBuilder()
          species = this@with.species?.toBuilder()
          part = this@with.part?.toBuilder()
          countryOfOrigin = this@with.countryOfOrigin.map { it.toBuilder() }.toMutableList()
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
       * A classification that provides the origin of the raw material. Example: cat hair would be
       * an Animal source type.
       */
      public var type: CodeableConcept.Builder? = null

      /**
       * The genus of an organism, typically referring to the Latin epithet of the genus element of
       * the plant/animal scientific name.
       */
      public var genus: CodeableConcept.Builder? = null

      /**
       * The species of an organism, typically referring to the Latin epithet of the species of the
       * plant/animal.
       */
      public var species: CodeableConcept.Builder? = null

      /** An anatomical origin of the source material within an organism. */
      public var part: CodeableConcept.Builder? = null

      /** The country or countries where the material is harvested. */
      public var countryOfOrigin: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): SourceMaterial =
        SourceMaterial(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          genus = genus?.build(),
          species = species?.build(),
          part = part?.build(),
          countryOfOrigin = countryOfOrigin.map { it.build() },
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
    public var language: dev.ohs.fhir.model.r5.Code.Builder? = null

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

    /** Identifier by which this substance is known. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A business level version identifier of the substance. */
    public var version: String.Builder? = null

    /** Status of substance within the catalogue e.g. active, retired. */
    public var status: CodeableConcept.Builder? = null

    /**
     * A high level categorization, e.g. polymer or nucleic acid, or food, chemical, biological, or
     * a lower level such as the general types of polymer (linear or branch chain) or type of
     * impurity (process related or contaminant).
     */
    public var classification: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** If the substance applies to human or veterinary use. */
    public var domain: CodeableConcept.Builder? = null

    /**
     * The quality standard, established benchmark, to which substance complies (e.g. USP/NF, Ph.
     * Eur, JP, BP, Company Standard).
     */
    public var grade: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Textual description of the substance. */
    public var description: Markdown.Builder? = null

    /** Supporting literature. */
    public var informationSource: MutableList<Reference.Builder> = mutableListOf()

    /** Textual comment about the substance's catalogue or registry record. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The entity that creates, makes, produces or fabricates the substance. This is a set of
     * potential manufacturers but is not necessarily comprehensive.
     */
    public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

    /**
     * An entity that is the source for the substance. It may be different from the manufacturer.
     * Supplier is synonymous to a distributor.
     */
    public var supplier: MutableList<Reference.Builder> = mutableListOf()

    /** Moiety, for structural modifications. */
    public var moiety: MutableList<Moiety.Builder> = mutableListOf()

    /** General specifications for this substance. */
    public var characterization: MutableList<Characterization.Builder> = mutableListOf()

    /** General specifications for this substance. */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

    /** General information detailing this substance. */
    public var referenceInformation: Reference.Builder? = null

    /**
     * The average mass of a molecule of a compound compared to 1/12 the mass of carbon 12 and
     * calculated as the sum of the atomic weights of the constituent atoms.
     */
    public var molecularWeight: MutableList<MolecularWeight.Builder> = mutableListOf()

    /** Structural information. */
    public var structure: Structure.Builder? = null

    /** Codes associated with the substance. */
    public var code: MutableList<Code.Builder> = mutableListOf()

    /** Names applicable to this substance. */
    public var name: MutableList<Name.Builder> = mutableListOf()

    /** A link between this substance and another, with details of the relationship. */
    public var relationship: MutableList<Relationship.Builder> = mutableListOf()

    /** Data items specific to nucleic acids. */
    public var nucleicAcid: Reference.Builder? = null

    /** Data items specific to polymers. */
    public var polymer: Reference.Builder? = null

    /** Data items specific to proteins. */
    public var protein: Reference.Builder? = null

    /** Material or taxonomic/anatomical source for the substance. */
    public var sourceMaterial: SourceMaterial.Builder? = null

    override fun build(): SubstanceDefinition =
      SubstanceDefinition(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        version = version?.build(),
        status = status?.build(),
        classification = classification.map { it.build() },
        domain = domain?.build(),
        grade = grade.map { it.build() },
        description = description?.build(),
        informationSource = informationSource.map { it.build() },
        note = note.map { it.build() },
        manufacturer = manufacturer.map { it.build() },
        supplier = supplier.map { it.build() },
        moiety = moiety.map { it.build() },
        characterization = characterization.map { it.build() },
        `property` = `property`.map { it.build() },
        referenceInformation = referenceInformation?.build(),
        molecularWeight = molecularWeight.map { it.build() },
        structure = structure?.build(),
        code = code.map { it.build() },
        name = name.map { it.build() },
        relationship = relationship.map { it.build() },
        nucleicAcid = nucleicAcid?.build(),
        polymer = polymer?.build(),
        protein = protein?.build(),
        sourceMaterial = sourceMaterial?.build(),
      )
  }
}
