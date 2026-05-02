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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.SubstanceSpecificationCodeSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationMoietyAmountSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationMoietySerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationNameOfficialSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationNameSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationPropertyAmountSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationPropertyDefiningSubstanceSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationPropertySerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationRelationshipAmountSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationRelationshipSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationRelationshipSubstanceSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationStructureIsotopeMolecularWeightSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationStructureIsotopeSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationStructureRepresentationSerializer
import com.google.fhir.model.r4.serializers.SubstanceSpecificationStructureSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The detailed description of a substance, typically at a level beyond what is used for
 * prescribing.
 */
@Serializable(with = SubstanceSpecificationSerializer::class)
@SerialName("SubstanceSpecification")
public data class SubstanceSpecification(
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
  override val language: com.google.fhir.model.r4.Code? = null,
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
  /** Identifier by which this substance is known. */
  public val identifier: Identifier? = null,
  /** High level categorization, e.g. polymer or nucleic acid. */
  public val type: CodeableConcept? = null,
  /** Status of substance within the catalogue e.g. approved. */
  public val status: CodeableConcept? = null,
  /** If the substance applies to only human or veterinary use. */
  public val domain: CodeableConcept? = null,
  /** Textual description of the substance. */
  public val description: String? = null,
  /** Supporting literature. */
  public val source: List<Reference> = listOf(),
  /** Textual comment about this record of a substance. */
  public val comment: String? = null,
  /** Moiety, for structural modifications. */
  public val moiety: List<Moiety> = listOf(),
  /** General specifications for this substance, including how it is related to other substances. */
  public val `property`: List<Property> = listOf(),
  /** General information detailing this substance. */
  public val referenceInformation: Reference? = null,
  /** Structural information. */
  public val structure: Structure? = null,
  /** Codes associated with the substance. */
  public val code: List<Code> = listOf(),
  /** Names applicable to this substance. */
  public val name: List<Name> = listOf(),
  /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
  public val molecularWeight: List<Structure.Isotope.MolecularWeight> = listOf(),
  /** A link between this substance and another, with details of the relationship. */
  public val relationship: List<Relationship> = listOf(),
  /** Data items specific to nucleic acids. */
  public val nucleicAcid: Reference? = null,
  /** Data items specific to polymers. */
  public val polymer: Reference? = null,
  /** Data items specific to proteins. */
  public val protein: Reference? = null,
  /** Material or taxonomic/anatomical source for the substance. */
  public val sourceMaterial: Reference? = null,
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
        identifier = this@with.identifier?.toBuilder()
        type = this@with.type?.toBuilder()
        status = this@with.status?.toBuilder()
        domain = this@with.domain?.toBuilder()
        description = this@with.description?.toBuilder()
        source = this@with.source.map { it.toBuilder() }.toMutableList()
        comment = this@with.comment?.toBuilder()
        moiety = this@with.moiety.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        referenceInformation = this@with.referenceInformation?.toBuilder()
        structure = this@with.structure?.toBuilder()
        code = this@with.code.map { it.toBuilder() }.toMutableList()
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        molecularWeight = this@with.molecularWeight.map { it.toBuilder() }.toMutableList()
        relationship = this@with.relationship.map { it.toBuilder() }.toMutableList()
        nucleicAcid = this@with.nucleicAcid?.toBuilder()
        polymer = this@with.polymer?.toBuilder()
        protein = this@with.protein?.toBuilder()
        sourceMaterial = this@with.sourceMaterial?.toBuilder()
      }
    }

  /** Moiety, for structural modifications. */
  @Serializable(with = SubstanceSpecificationMoietySerializer::class)
  public data class Moiety(
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
    /** Molecular formula. */
    public val molecularFormula: String? = null,
    /** Quantitative value for this moiety. */
    public val amount: Amount? = null,
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
        }
      }

    @Serializable(with = SubstanceSpecificationMoietyAmountSerializer::class)
    public sealed interface Amount {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asString(): String? = this as? String

      public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Amount

      public data class String(public val `value`: com.google.fhir.model.r4.String) : Amount

      public companion object {
        internal fun from(
          quantityValue: com.google.fhir.model.r4.Quantity?,
          stringValue: com.google.fhir.model.r4.String?,
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

      /** Molecular formula. */
      public var molecularFormula: String.Builder? = null

      /** Quantitative value for this moiety. */
      public var amount: Amount? = null

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
        )
    }
  }

  /** General specifications for this substance, including how it is related to other substances. */
  @Serializable(with = SubstanceSpecificationPropertySerializer::class)
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
    /** A category for this property, e.g. Physical, Chemical, Enzymatic. */
    public val category: CodeableConcept? = null,
    /** Property type e.g. viscosity, pH, isoelectric point. */
    public val code: CodeableConcept? = null,
    /**
     * Parameters that were used in the measurement of a property (e.g. for viscosity: measured at
     * 20C with a pH of 7.1).
     */
    public val parameters: String? = null,
    /**
     * A substance upon which a defining property depends (e.g. for solubility: in water, in
     * alcohol).
     */
    public val definingSubstance: DefiningSubstance? = null,
    /** Quantitative value for this property. */
    public val amount: Amount? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          category = this@with.category?.toBuilder()
          code = this@with.code?.toBuilder()
          parameters = this@with.parameters?.toBuilder()
          definingSubstance = this@with.definingSubstance
          amount = this@with.amount
        }
      }

    @Serializable(with = SubstanceSpecificationPropertyDefiningSubstanceSerializer::class)
    public sealed interface DefiningSubstance {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) :
        DefiningSubstance

      public data class CodeableConcept(
        public val `value`: com.google.fhir.model.r4.CodeableConcept
      ) : DefiningSubstance

      public companion object {
        internal fun from(
          referenceValue: com.google.fhir.model.r4.Reference?,
          codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
        ): DefiningSubstance? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    @Serializable(with = SubstanceSpecificationPropertyAmountSerializer::class)
    public sealed interface Amount {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asString(): String? = this as? String

      public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Amount

      public data class String(public val `value`: com.google.fhir.model.r4.String) : Amount

      public companion object {
        internal fun from(
          quantityValue: com.google.fhir.model.r4.Quantity?,
          stringValue: com.google.fhir.model.r4.String?,
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

      /** A category for this property, e.g. Physical, Chemical, Enzymatic. */
      public var category: CodeableConcept.Builder? = null

      /** Property type e.g. viscosity, pH, isoelectric point. */
      public var code: CodeableConcept.Builder? = null

      /**
       * Parameters that were used in the measurement of a property (e.g. for viscosity: measured at
       * 20C with a pH of 7.1).
       */
      public var parameters: String.Builder? = null

      /**
       * A substance upon which a defining property depends (e.g. for solubility: in water, in
       * alcohol).
       */
      public var definingSubstance: DefiningSubstance? = null

      /** Quantitative value for this property. */
      public var amount: Amount? = null

      public fun build(): Property =
        Property(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category?.build(),
          code = code?.build(),
          parameters = parameters?.build(),
          definingSubstance = definingSubstance,
          amount = amount,
        )
    }
  }

  /** Structural information. */
  @Serializable(with = SubstanceSpecificationStructureSerializer::class)
  public data class Structure(
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
    /** Stereochemistry type. */
    public val stereochemistry: CodeableConcept? = null,
    /** Optical activity type. */
    public val opticalActivity: CodeableConcept? = null,
    /** Molecular formula. */
    public val molecularFormula: String? = null,
    /**
     * Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical,
     * each moiety separated by a dot.
     */
    public val molecularFormulaByMoiety: String? = null,
    /**
     * Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio.
     */
    public val isotope: List<Isotope> = listOf(),
    /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
    public val molecularWeight: Isotope.MolecularWeight? = null,
    /** Supporting literature. */
    public val source: List<Reference> = listOf(),
    /** Molecular structural representation. */
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
          isotope = this@with.isotope.map { it.toBuilder() }.toMutableList()
          molecularWeight = this@with.molecularWeight?.toBuilder()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
          representation = this@with.representation.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio.
     */
    @Serializable(with = SubstanceSpecificationStructureIsotopeSerializer::class)
    public data class Isotope(
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
      /** Substance identifier for each non-natural or radioisotope. */
      public val identifier: Identifier? = null,
      /** Substance name for each non-natural or radioisotope. */
      public val name: CodeableConcept? = null,
      /** The type of isotopic substitution present in a single substance. */
      public val substitution: CodeableConcept? = null,
      /** Half life - for a non-natural nuclide. */
      public val halfLife: Quantity? = null,
      /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
      public val molecularWeight: MolecularWeight? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            identifier = this@with.identifier?.toBuilder()
            name = this@with.name?.toBuilder()
            substitution = this@with.substitution?.toBuilder()
            halfLife = this@with.halfLife?.toBuilder()
            molecularWeight = this@with.molecularWeight?.toBuilder()
          }
        }

      /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
      @Serializable(with = SubstanceSpecificationStructureIsotopeMolecularWeightSerializer::class)
      public data class MolecularWeight(
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
        /** The method by which the molecular weight was determined. */
        public val method: CodeableConcept? = null,
        /**
         * Type of molecular weight such as exact, average (also known as. number average), weight
         * average.
         */
        public val type: CodeableConcept? = null,
        /**
         * Used to capture quantitative values for a variety of elements. If only limits are given,
         * the arithmetic mean would be the average. If only a single definite value for a given
         * element is given, it would be captured in this field.
         */
        public val amount: Quantity? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder().apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              method = this@with.method?.toBuilder()
              type = this@with.type?.toBuilder()
              amount = this@with.amount?.toBuilder()
            }
          }

        public class Builder() {
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

          /** The method by which the molecular weight was determined. */
          public var method: CodeableConcept.Builder? = null

          /**
           * Type of molecular weight such as exact, average (also known as. number average), weight
           * average.
           */
          public var type: CodeableConcept.Builder? = null

          /**
           * Used to capture quantitative values for a variety of elements. If only limits are
           * given, the arithmetic mean would be the average. If only a single definite value for a
           * given element is given, it would be captured in this field.
           */
          public var amount: Quantity.Builder? = null

          public fun build(): MolecularWeight =
            MolecularWeight(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              method = method?.build(),
              type = type?.build(),
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

        /** Substance identifier for each non-natural or radioisotope. */
        public var identifier: Identifier.Builder? = null

        /** Substance name for each non-natural or radioisotope. */
        public var name: CodeableConcept.Builder? = null

        /** The type of isotopic substitution present in a single substance. */
        public var substitution: CodeableConcept.Builder? = null

        /** Half life - for a non-natural nuclide. */
        public var halfLife: Quantity.Builder? = null

        /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
        public var molecularWeight: MolecularWeight.Builder? = null

        public fun build(): Isotope =
          Isotope(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            identifier = identifier?.build(),
            name = name?.build(),
            substitution = substitution?.build(),
            halfLife = halfLife?.build(),
            molecularWeight = molecularWeight?.build(),
          )
      }
    }

    /** Molecular structural representation. */
    @Serializable(with = SubstanceSpecificationStructureRepresentationSerializer::class)
    public data class Representation(
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
      /** The type of structure (e.g. Full, Partial, Representative). */
      public val type: CodeableConcept? = null,
      /**
       * The structural representation as text string in a format e.g. InChI, SMILES, MOLFILE, CDX.
       */
      public val representation: String? = null,
      /** An attached file with the structural representation. */
      public val attachment: Attachment? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            representation = this@with.representation?.toBuilder()
            attachment = this@with.attachment?.toBuilder()
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

        /** The type of structure (e.g. Full, Partial, Representative). */
        public var type: CodeableConcept.Builder? = null

        /**
         * The structural representation as text string in a format e.g. InChI, SMILES, MOLFILE,
         * CDX.
         */
        public var representation: String.Builder? = null

        /** An attached file with the structural representation. */
        public var attachment: Attachment.Builder? = null

        public fun build(): Representation =
          Representation(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            representation = representation?.build(),
            attachment = attachment?.build(),
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

      /** Stereochemistry type. */
      public var stereochemistry: CodeableConcept.Builder? = null

      /** Optical activity type. */
      public var opticalActivity: CodeableConcept.Builder? = null

      /** Molecular formula. */
      public var molecularFormula: String.Builder? = null

      /**
       * Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical,
       * each moiety separated by a dot.
       */
      public var molecularFormulaByMoiety: String.Builder? = null

      /**
       * Applicable for single substances that contain a radionuclide or a non-natural isotopic
       * ratio.
       */
      public var isotope: MutableList<Isotope.Builder> = mutableListOf()

      /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
      public var molecularWeight: Isotope.MolecularWeight.Builder? = null

      /** Supporting literature. */
      public var source: MutableList<Reference.Builder> = mutableListOf()

      /** Molecular structural representation. */
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
          isotope = isotope.map { it.build() },
          molecularWeight = molecularWeight?.build(),
          source = source.map { it.build() },
          representation = representation.map { it.build() },
        )
    }
  }

  /** Codes associated with the substance. */
  @Serializable(with = SubstanceSpecificationCodeSerializer::class)
  public data class Code(
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
    /** The specific code. */
    public val code: CodeableConcept? = null,
    /** Status of the code assignment. */
    public val status: CodeableConcept? = null,
    /** The date at which the code status is changed as part of the terminology maintenance. */
    public val statusDate: DateTime? = null,
    /** Any comment can be provided in this field, if necessary. */
    public val comment: String? = null,
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
          comment = this@with.comment?.toBuilder()
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

      /** The specific code. */
      public var code: CodeableConcept.Builder? = null

      /** Status of the code assignment. */
      public var status: CodeableConcept.Builder? = null

      /** The date at which the code status is changed as part of the terminology maintenance. */
      public var statusDate: DateTime.Builder? = null

      /** Any comment can be provided in this field, if necessary. */
      public var comment: String.Builder? = null

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
          comment = comment?.build(),
          source = source.map { it.build() },
        )
    }
  }

  /** Names applicable to this substance. */
  @Serializable(with = SubstanceSpecificationNameSerializer::class)
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
    /** The actual name. */
    public val name: String,
    /** Name type. */
    public val type: CodeableConcept? = null,
    /** The status of the name. */
    public val status: CodeableConcept? = null,
    /** If this is the preferred name for this substance. */
    public val preferred: Boolean? = null,
    /** Language of the name. */
    public val language: List<CodeableConcept> = listOf(),
    /**
     * The use context of this name for example if there is a different name a drug active
     * ingredient as opposed to a food colour additive.
     */
    public val domain: List<CodeableConcept> = listOf(),
    /** The jurisdiction where this name applies. */
    public val jurisdiction: List<CodeableConcept> = listOf(),
    /** A synonym of this name. */
    public val synonym: List<Name> = listOf(),
    /** A translation for this name. */
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
    @Serializable(with = SubstanceSpecificationNameOfficialSerializer::class)
    public data class Official(
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
      /** Which authority uses this official name. */
      public val authority: CodeableConcept? = null,
      /** The status of the official name. */
      public val status: CodeableConcept? = null,
      /** Date of official name change. */
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

        /** Which authority uses this official name. */
        public var authority: CodeableConcept.Builder? = null

        /** The status of the official name. */
        public var status: CodeableConcept.Builder? = null

        /** Date of official name change. */
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

      /** Name type. */
      public var type: CodeableConcept.Builder? = null

      /** The status of the name. */
      public var status: CodeableConcept.Builder? = null

      /** If this is the preferred name for this substance. */
      public var preferred: Boolean.Builder? = null

      /** Language of the name. */
      public var language: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The use context of this name for example if there is a different name a drug active
       * ingredient as opposed to a food colour additive.
       */
      public var domain: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The jurisdiction where this name applies. */
      public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A synonym of this name. */
      public var synonym: MutableList<Builder> = mutableListOf()

      /** A translation for this name. */
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
  @Serializable(with = SubstanceSpecificationRelationshipSerializer::class)
  public data class Relationship(
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
    /** A pointer to another substance, as a resource or just a representational code. */
    public val substance: Substance? = null,
    /** For example "salt to parent", "active moiety", "starting material". */
    public val relationship: CodeableConcept? = null,
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
    /** For use when the numeric. */
    public val amountRatioLowLimit: Ratio? = null,
    /** An operator for the amount, for example "average", "approximately", "less than". */
    public val amountType: CodeableConcept? = null,
    /** Supporting literature. */
    public val source: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          substance = this@with.substance
          relationship = this@with.relationship?.toBuilder()
          isDefining = this@with.isDefining?.toBuilder()
          amount = this@with.amount
          amountRatioLowLimit = this@with.amountRatioLowLimit?.toBuilder()
          amountType = this@with.amountType?.toBuilder()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
        }
      }

    @Serializable(with = SubstanceSpecificationRelationshipSubstanceSerializer::class)
    public sealed interface Substance {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) :
        Substance

      public data class CodeableConcept(
        public val `value`: com.google.fhir.model.r4.CodeableConcept
      ) : Substance

      public companion object {
        internal fun from(
          referenceValue: com.google.fhir.model.r4.Reference?,
          codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
        ): Substance? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    @Serializable(with = SubstanceSpecificationRelationshipAmountSerializer::class)
    public sealed interface Amount {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asString(): String? = this as? String

      public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Amount

      public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Amount

      public data class Ratio(public val `value`: com.google.fhir.model.r4.Ratio) : Amount

      public data class String(public val `value`: com.google.fhir.model.r4.String) : Amount

      public companion object {
        internal fun from(
          quantityValue: com.google.fhir.model.r4.Quantity?,
          rangeValue: com.google.fhir.model.r4.Range?,
          ratioValue: com.google.fhir.model.r4.Ratio?,
          stringValue: com.google.fhir.model.r4.String?,
        ): Amount? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
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

      /** A pointer to another substance, as a resource or just a representational code. */
      public var substance: Substance? = null

      /** For example "salt to parent", "active moiety", "starting material". */
      public var relationship: CodeableConcept.Builder? = null

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

      /** For use when the numeric. */
      public var amountRatioLowLimit: Ratio.Builder? = null

      /** An operator for the amount, for example "average", "approximately", "less than". */
      public var amountType: CodeableConcept.Builder? = null

      /** Supporting literature. */
      public var source: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Relationship =
        Relationship(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          substance = substance,
          relationship = relationship?.build(),
          isDefining = isDefining?.build(),
          amount = amount,
          amountRatioLowLimit = amountRatioLowLimit?.build(),
          amountType = amountType?.build(),
          source = source.map { it.build() },
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
    public var language: com.google.fhir.model.r4.Code.Builder? = null

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

    /** Identifier by which this substance is known. */
    public var identifier: Identifier.Builder? = null

    /** High level categorization, e.g. polymer or nucleic acid. */
    public var type: CodeableConcept.Builder? = null

    /** Status of substance within the catalogue e.g. approved. */
    public var status: CodeableConcept.Builder? = null

    /** If the substance applies to only human or veterinary use. */
    public var domain: CodeableConcept.Builder? = null

    /** Textual description of the substance. */
    public var description: String.Builder? = null

    /** Supporting literature. */
    public var source: MutableList<Reference.Builder> = mutableListOf()

    /** Textual comment about this record of a substance. */
    public var comment: String.Builder? = null

    /** Moiety, for structural modifications. */
    public var moiety: MutableList<Moiety.Builder> = mutableListOf()

    /**
     * General specifications for this substance, including how it is related to other substances.
     */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

    /** General information detailing this substance. */
    public var referenceInformation: Reference.Builder? = null

    /** Structural information. */
    public var structure: Structure.Builder? = null

    /** Codes associated with the substance. */
    public var code: MutableList<Code.Builder> = mutableListOf()

    /** Names applicable to this substance. */
    public var name: MutableList<Name.Builder> = mutableListOf()

    /** The molecular weight or weight range (for proteins, polymers or nucleic acids). */
    public var molecularWeight: MutableList<Structure.Isotope.MolecularWeight.Builder> =
      mutableListOf()

    /** A link between this substance and another, with details of the relationship. */
    public var relationship: MutableList<Relationship.Builder> = mutableListOf()

    /** Data items specific to nucleic acids. */
    public var nucleicAcid: Reference.Builder? = null

    /** Data items specific to polymers. */
    public var polymer: Reference.Builder? = null

    /** Data items specific to proteins. */
    public var protein: Reference.Builder? = null

    /** Material or taxonomic/anatomical source for the substance. */
    public var sourceMaterial: Reference.Builder? = null

    override fun build(): SubstanceSpecification =
      SubstanceSpecification(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier?.build(),
        type = type?.build(),
        status = status?.build(),
        domain = domain?.build(),
        description = description?.build(),
        source = source.map { it.build() },
        comment = comment?.build(),
        moiety = moiety.map { it.build() },
        `property` = `property`.map { it.build() },
        referenceInformation = referenceInformation?.build(),
        structure = structure?.build(),
        code = code.map { it.build() },
        name = name.map { it.build() },
        molecularWeight = molecularWeight.map { it.build() },
        relationship = relationship.map { it.build() },
        nucleicAcid = nucleicAcid?.build(),
        polymer = polymer?.build(),
        protein = protein?.build(),
        sourceMaterial = sourceMaterial?.build(),
      )
  }
}
