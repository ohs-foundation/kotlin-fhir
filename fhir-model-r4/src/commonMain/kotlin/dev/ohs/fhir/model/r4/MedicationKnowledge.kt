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

import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeAdministrationGuidelinesDosageSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeAdministrationGuidelinesSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeCostSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeDrugCharacteristicSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeIngredientSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeKineticsSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeMedicineClassificationSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeMonitoringProgramSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeMonographSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgePackagingSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeRegulatoryMaxDispenseSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeRegulatoryScheduleSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeRegulatorySerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeRegulatorySubstitutionSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeRelatedMedicationKnowledgeSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationKnowledgeSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Information about a medication that is used to support knowledge. */
@Serializable(with = MedicationKnowledgeSerializer::class)
@SerialName("MedicationKnowledge")
public data class MedicationKnowledge(
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
   * A code that specifies this medication, or a textual description if no code is available. Usage
   * note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc.
   * It could also be a national or local formulary code, optionally with translations to other code
   * systems.
   *
   * Depending on the context of use, the code that was actually selected by the user (prescriber,
   * dispenser, etc.) will have the coding.userSelected set to true. As described in the coding
   * datatype: "A coding may be marked as a "userSelected" if a user selected the particular coded
   * value in a user interface (e.g. the user selects an item in a pick-list). If a user selected
   * coding exists, it is the preferred choice for performing translations etc. Other codes can only
   * be literal translations to alternative code systems, or codes at a lower level of granularity
   * (e.g. a generic code for a vendor-specific primary one).
   */
  public val code: CodeableConcept? = null,
  /**
   * A code to indicate if the medication is in active use. The status refers to the validity about
   * the information of the medication and not to its medicinal properties.
   *
   * This status is intended to identify if the medication in a local system is in active use within
   * a drug database or inventory. For example, a pharmacy system may create a new drug file record
   * for a compounded product "ABC Hospital Special Cream" with an active status. At some point in
   * the future, it may be determined that the drug record was created with an error and the status
   * is changed to "entered in error". This status is not intended to specify if a medication is
   * part of a particular formulary. It is possible that the drug record may be referenced by
   * multiple formularies or catalogues and each of those entries would have a separate status.
   */
  public val status: Enumeration<MedicationKnowledgeStatusCodes>? = null,
  /**
   * Describes the details of the manufacturer of the medication product. This is not intended to
   * represent the distributor of a medication product.
   */
  public val manufacturer: Reference? = null,
  /**
   * Describes the form of the item. Powder; tablets; capsule.
   *
   * When Medication is referenced from MedicationRequest, this is the ordered form. When Medication
   * is referenced within MedicationDispense, this is the dispensed form. When Medication is
   * referenced within MedicationAdministration, this is administered form.
   */
  public val doseForm: CodeableConcept? = null,
  /**
   * Specific amount of the drug in the packaged product. For example, when specifying a product
   * that has the same strength (For example, Insulin glargine 100 unit per mL solution for
   * injection), this attribute provides additional clarification of the package amount (For
   * example, 3 mL, 10mL, etc.).
   *
   * This is the quantity of medication in a package. To specify the strength of the medication, the
   * Ingredient.strength attribute is used.
   */
  public val amount: Quantity? = null,
  /**
   * Additional names for a medication, for example, the name(s) given to a medication in different
   * countries. For example, acetaminophen and paracetamol or salbutamol and albuterol.
   */
  public val synonym: List<String> = listOf(),
  /** Associated or related knowledge about a medication. */
  public val relatedMedicationKnowledge: List<RelatedMedicationKnowledge> = listOf(),
  /**
   * Associated or related medications. For example, if the medication is a branded product (e.g.
   * Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication
   * (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor).
   */
  public val associatedMedication: List<Reference> = listOf(),
  /**
   * Category of the medication or product (e.g. branded product, therapeutic moeity, generic
   * product, innovator product, etc.).
   */
  public val productType: List<CodeableConcept> = listOf(),
  /** Associated documentation about the medication. */
  public val monograph: List<Monograph> = listOf(),
  /** Identifies a particular constituent of interest in the product. */
  public val ingredient: List<Ingredient> = listOf(),
  /** The instructions for preparing the medication. */
  public val preparationInstruction: Markdown? = null,
  /** The intended or approved route of administration. */
  public val intendedRoute: List<CodeableConcept> = listOf(),
  /** The price of the medication. */
  public val cost: List<Cost> = listOf(),
  /** The program under which the medication is reviewed. */
  public val monitoringProgram: List<MonitoringProgram> = listOf(),
  /** Guidelines for the administration of the medication. */
  public val administrationGuidelines: List<AdministrationGuidelines> = listOf(),
  /** Categorization of the medication within a formulary or classification system. */
  public val medicineClassification: List<MedicineClassification> = listOf(),
  /** Information that only applies to packages (not products). */
  public val packaging: Packaging? = null,
  /** Specifies descriptive properties of the medicine, such as color, shape, imprints, etc. */
  public val drugCharacteristic: List<DrugCharacteristic> = listOf(),
  /**
   * Potential clinical issue with or between medication(s) (for example, drug-drug interaction,
   * drug-disease contraindication, drug-allergy interaction, etc.).
   */
  public val contraindication: List<Reference> = listOf(),
  /** Regulatory information about a medication. */
  public val regulatory: List<Regulatory> = listOf(),
  /**
   * The time course of drug absorption, distribution, metabolism and excretion of a medication from
   * the body.
   */
  public val kinetics: List<Kinetics> = listOf(),
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
        code = this@with.code?.toBuilder()
        status = this@with.status
        manufacturer = this@with.manufacturer?.toBuilder()
        doseForm = this@with.doseForm?.toBuilder()
        amount = this@with.amount?.toBuilder()
        synonym = this@with.synonym.map { it.toBuilder() }.toMutableList()
        relatedMedicationKnowledge =
          this@with.relatedMedicationKnowledge.map { it.toBuilder() }.toMutableList()
        associatedMedication = this@with.associatedMedication.map { it.toBuilder() }.toMutableList()
        productType = this@with.productType.map { it.toBuilder() }.toMutableList()
        monograph = this@with.monograph.map { it.toBuilder() }.toMutableList()
        ingredient = this@with.ingredient.map { it.toBuilder() }.toMutableList()
        preparationInstruction = this@with.preparationInstruction?.toBuilder()
        intendedRoute = this@with.intendedRoute.map { it.toBuilder() }.toMutableList()
        cost = this@with.cost.map { it.toBuilder() }.toMutableList()
        monitoringProgram = this@with.monitoringProgram.map { it.toBuilder() }.toMutableList()
        administrationGuidelines =
          this@with.administrationGuidelines.map { it.toBuilder() }.toMutableList()
        medicineClassification =
          this@with.medicineClassification.map { it.toBuilder() }.toMutableList()
        packaging = this@with.packaging?.toBuilder()
        drugCharacteristic = this@with.drugCharacteristic.map { it.toBuilder() }.toMutableList()
        contraindication = this@with.contraindication.map { it.toBuilder() }.toMutableList()
        regulatory = this@with.regulatory.map { it.toBuilder() }.toMutableList()
        kinetics = this@with.kinetics.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Associated or related knowledge about a medication. */
  @Serializable(with = MedicationKnowledgeRelatedMedicationKnowledgeSerializer::class)
  public data class RelatedMedicationKnowledge(
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
    /** The category of the associated medication knowledge reference. */
    public val type: CodeableConcept,
    /** Associated documentation about the associated medication knowledge. */
    public val reference: List<Reference>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            type.toBuilder(),
            reference.map { it.toBuilder() }.toMutableList(),
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
      }

    public class Builder(
      /** The category of the associated medication knowledge reference. */
      public var type: CodeableConcept.Builder,
      /** Associated documentation about the associated medication knowledge. */
      public var reference: MutableList<Reference.Builder>,
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

      public fun build(): RelatedMedicationKnowledge =
        RelatedMedicationKnowledge(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          reference = reference.map { it.build() },
        )
    }
  }

  /** Associated documentation about the medication. */
  @Serializable(with = MedicationKnowledgeMonographSerializer::class)
  public data class Monograph(
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
     * The category of documentation about the medication. (e.g. professional monograph, patient
     * education monograph).
     */
    public val type: CodeableConcept? = null,
    /** Associated documentation about the medication. */
    public val source: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          source = this@with.source?.toBuilder()
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
       * The category of documentation about the medication. (e.g. professional monograph, patient
       * education monograph).
       */
      public var type: CodeableConcept.Builder? = null

      /** Associated documentation about the medication. */
      public var source: Reference.Builder? = null

      public fun build(): Monograph =
        Monograph(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          source = source?.build(),
        )
    }
  }

  /** Identifies a particular constituent of interest in the product. */
  @Serializable(with = MedicationKnowledgeIngredientSerializer::class)
  public data class Ingredient(
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
    /** The actual ingredient - either a substance (simple ingredient) or another medication. */
    public val item: Item,
    /** Indication of whether this ingredient affects the therapeutic action of the drug. */
    public val isActive: Boolean? = null,
    /**
     * Specifies how many (or how much) of the items there are in this Medication. For example, 250
     * mg per tablet. This is expressed as a ratio where the numerator is 250mg and the denominator
     * is 1 tablet.
     */
    public val strength: Ratio? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(item).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          isActive = this@with.isActive?.toBuilder()
          strength = this@with.strength?.toBuilder()
        }
      }

    public sealed interface Item {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
        Item

      public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Item

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
        ): Item? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /** The actual ingredient - either a substance (simple ingredient) or another medication. */
      public var item: Item
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

      /** Indication of whether this ingredient affects the therapeutic action of the drug. */
      public var isActive: Boolean.Builder? = null

      /**
       * Specifies how many (or how much) of the items there are in this Medication. For example,
       * 250 mg per tablet. This is expressed as a ratio where the numerator is 250mg and the
       * denominator is 1 tablet.
       */
      public var strength: Ratio.Builder? = null

      public fun build(): Ingredient =
        Ingredient(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          item = item,
          isActive = isActive?.build(),
          strength = strength?.build(),
        )
    }
  }

  /** The price of the medication. */
  @Serializable(with = MedicationKnowledgeCostSerializer::class)
  public data class Cost(
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
     * The category of the cost information. For example, manufacturers' cost, patient cost, claim
     * reimbursement cost, actual acquisition cost.
     */
    public val type: CodeableConcept,
    /** The source or owner that assigns the price to the medication. */
    public val source: String? = null,
    /** The price of the medication. */
    public val cost: Money,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder(), cost.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          source = this@with.source?.toBuilder()
        }
      }

    public class Builder(
      /**
       * The category of the cost information. For example, manufacturers' cost, patient cost, claim
       * reimbursement cost, actual acquisition cost.
       */
      public var type: CodeableConcept.Builder,
      /** The price of the medication. */
      public var cost: Money.Builder,
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

      /** The source or owner that assigns the price to the medication. */
      public var source: String.Builder? = null

      public fun build(): Cost =
        Cost(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          source = source?.build(),
          cost = cost.build(),
        )
    }
  }

  /** The program under which the medication is reviewed. */
  @Serializable(with = MedicationKnowledgeMonitoringProgramSerializer::class)
  public data class MonitoringProgram(
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
    /** Type of program under which the medication is monitored. */
    public val type: CodeableConcept? = null,
    /** Name of the reviewing program. */
    public val name: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          name = this@with.name?.toBuilder()
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

      /** Type of program under which the medication is monitored. */
      public var type: CodeableConcept.Builder? = null

      /** Name of the reviewing program. */
      public var name: String.Builder? = null

      public fun build(): MonitoringProgram =
        MonitoringProgram(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          name = name?.build(),
        )
    }
  }

  /** Guidelines for the administration of the medication. */
  @Serializable(with = MedicationKnowledgeAdministrationGuidelinesSerializer::class)
  public data class AdministrationGuidelines(
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
    /** Dosage for the medication for the specific guidelines. */
    public val dosage: List<Dosage> = listOf(),
    /** Indication for use that apply to the specific administration guidelines. */
    public val indication: Indication? = null,
    /**
     * Characteristics of the patient that are relevant to the administration guidelines (for
     * example, height, weight, gender, etc.).
     */
    public val patientCharacteristics: List<PatientCharacteristics> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          dosage = this@with.dosage.map { it.toBuilder() }.toMutableList()
          indication = this@with.indication
          patientCharacteristics =
            this@with.patientCharacteristics.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Dosage for the medication for the specific guidelines. */
    @Serializable(with = MedicationKnowledgeAdministrationGuidelinesDosageSerializer::class)
    public data class Dosage(
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
      /** The type of dosage (for example, prophylaxis, maintenance, therapeutic, etc.). */
      public val type: CodeableConcept,
      /** Dosage for the medication for the specific guidelines. */
      public val dosage: List<dev.ohs.fhir.model.r4.Dosage>,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              type.toBuilder(),
              dosage.map { it.toBuilder() }.toMutableList(),
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            }
        }

      public class Builder(
        /** The type of dosage (for example, prophylaxis, maintenance, therapeutic, etc.). */
        public var type: CodeableConcept.Builder,
        /** Dosage for the medication for the specific guidelines. */
        public var dosage: MutableList<dev.ohs.fhir.model.r4.Dosage.Builder>,
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

        public fun build(): Dosage =
          Dosage(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.build(),
            dosage = dosage.map { it.build() },
          )
      }
    }

    /**
     * Characteristics of the patient that are relevant to the administration guidelines (for
     * example, height, weight, gender, etc.).
     */
    @Serializable(
      with = MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer::class
    )
    public data class PatientCharacteristics(
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
       * Specific characteristic that is relevant to the administration guideline (e.g. height,
       * weight, gender).
       */
      public val characteristic: Characteristic,
      /** The specific characteristic (e.g. height, weight, gender, etc.). */
      public val `value`: List<String> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(characteristic).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            `value` = this@with.`value`.map { it.toBuilder() }.toMutableList()
          }
        }

      public sealed interface Characteristic {
        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asQuantity(): Quantity? = this as? Quantity

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r4.CodeableConcept
        ) : Characteristic

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) :
          Characteristic

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
            quantityValue: dev.ohs.fhir.model.r4.Quantity?,
          ): Characteristic? {
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (quantityValue != null) return Quantity(quantityValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * Specific characteristic that is relevant to the administration guideline (e.g. height,
         * weight, gender).
         */
        public var characteristic: Characteristic
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

        /** The specific characteristic (e.g. height, weight, gender, etc.). */
        public var `value`: MutableList<String.Builder> = mutableListOf()

        public fun build(): PatientCharacteristics =
          PatientCharacteristics(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            characteristic = characteristic,
            `value` = `value`.map { it.build() },
          )
      }
    }

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

      /** Dosage for the medication for the specific guidelines. */
      public var dosage: MutableList<Dosage.Builder> = mutableListOf()

      /** Indication for use that apply to the specific administration guidelines. */
      public var indication: Indication? = null

      /**
       * Characteristics of the patient that are relevant to the administration guidelines (for
       * example, height, weight, gender, etc.).
       */
      public var patientCharacteristics: MutableList<PatientCharacteristics.Builder> =
        mutableListOf()

      public fun build(): AdministrationGuidelines =
        AdministrationGuidelines(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          dosage = dosage.map { it.build() },
          indication = indication,
          patientCharacteristics = patientCharacteristics.map { it.build() },
        )
    }
  }

  /** Categorization of the medication within a formulary or classification system. */
  @Serializable(with = MedicationKnowledgeMedicineClassificationSerializer::class)
  public data class MedicineClassification(
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
     * The type of category for the medication (for example, therapeutic classification, therapeutic
     * sub-classification).
     */
    public val type: CodeableConcept,
    /**
     * Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive,
     * antibiotic, etc.).
     */
    public val classification: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The type of category for the medication (for example, therapeutic classification,
       * therapeutic sub-classification).
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
       * Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive,
       * antibiotic, etc.).
       */
      public var classification: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): MedicineClassification =
        MedicineClassification(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          classification = classification.map { it.build() },
        )
    }
  }

  /** Information that only applies to packages (not products). */
  @Serializable(with = MedicationKnowledgePackagingSerializer::class)
  public data class Packaging(
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
     * A code that defines the specific type of packaging that the medication can be found in (e.g.
     * blister sleeve, tube, bottle).
     */
    public val type: CodeableConcept? = null,
    /** The number of product units the package would contain if fully loaded. */
    public val quantity: Quantity? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          quantity = this@with.quantity?.toBuilder()
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
       * A code that defines the specific type of packaging that the medication can be found in
       * (e.g. blister sleeve, tube, bottle).
       */
      public var type: CodeableConcept.Builder? = null

      /** The number of product units the package would contain if fully loaded. */
      public var quantity: Quantity.Builder? = null

      public fun build(): Packaging =
        Packaging(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          quantity = quantity?.build(),
        )
    }
  }

  /** Specifies descriptive properties of the medicine, such as color, shape, imprints, etc. */
  @Serializable(with = MedicationKnowledgeDrugCharacteristicSerializer::class)
  public data class DrugCharacteristic(
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
     * A code specifying which characteristic of the medicine is being described (for example,
     * colour, shape, imprint).
     */
    public val type: CodeableConcept? = null,
    /**
     * Description of the characteristic.
     *
     * The description should be provided as a CodeableConcept, SimpleQuantity or an image. The
     * description can be a string only when these others are not available.
     */
    public val `value`: Value? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          `value` = this@with.`value`
        }
      }

    public sealed interface Value {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asString(): String? = this as? String

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
        Value

      public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) : Value

      public data class Base64Binary(public val `value`: dev.ohs.fhir.model.r4.Base64Binary) : Value

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          stringValue: dev.ohs.fhir.model.r4.String?,
          quantityValue: dev.ohs.fhir.model.r4.Quantity?,
          base64BinaryValue: dev.ohs.fhir.model.r4.Base64Binary?,
        ): Value? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (stringValue != null) return String(stringValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
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

      /**
       * A code specifying which characteristic of the medicine is being described (for example,
       * colour, shape, imprint).
       */
      public var type: CodeableConcept.Builder? = null

      /**
       * Description of the characteristic.
       *
       * The description should be provided as a CodeableConcept, SimpleQuantity or an image. The
       * description can be a string only when these others are not available.
       */
      public var `value`: Value? = null

      public fun build(): DrugCharacteristic =
        DrugCharacteristic(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          `value` = `value`,
        )
    }
  }

  /** Regulatory information about a medication. */
  @Serializable(with = MedicationKnowledgeRegulatorySerializer::class)
  public data class Regulatory(
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
    /** The authority that is specifying the regulations. */
    public val regulatoryAuthority: Reference,
    /**
     * Specifies if changes are allowed when dispensing a medication from a regulatory perspective.
     */
    public val substitution: List<Substitution> = listOf(),
    /** Specifies the schedule of a medication in jurisdiction. */
    public val schedule: List<Schedule> = listOf(),
    /** The maximum number of units of the medication that can be dispensed in a period. */
    public val maxDispense: MaxDispense? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(regulatoryAuthority.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          substitution = this@with.substitution.map { it.toBuilder() }.toMutableList()
          schedule = this@with.schedule.map { it.toBuilder() }.toMutableList()
          maxDispense = this@with.maxDispense?.toBuilder()
        }
      }

    /**
     * Specifies if changes are allowed when dispensing a medication from a regulatory perspective.
     */
    @Serializable(with = MedicationKnowledgeRegulatorySubstitutionSerializer::class)
    public data class Substitution(
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
      /** Specifies the type of substitution allowed. */
      public val type: CodeableConcept,
      /** Specifies if regulation allows for changes in the medication when dispensing. */
      public val allowed: Boolean,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type.toBuilder(), allowed.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** Specifies the type of substitution allowed. */
        public var type: CodeableConcept.Builder,
        /** Specifies if regulation allows for changes in the medication when dispensing. */
        public var allowed: Boolean.Builder,
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

        public fun build(): Substitution =
          Substitution(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.build(),
            allowed = allowed.build(),
          )
      }
    }

    /** Specifies the schedule of a medication in jurisdiction. */
    @Serializable(with = MedicationKnowledgeRegulatoryScheduleSerializer::class)
    public data class Schedule(
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
      /** Specifies the specific drug schedule. */
      public val schedule: CodeableConcept,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(schedule.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** Specifies the specific drug schedule. */
        public var schedule: CodeableConcept.Builder
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

        public fun build(): Schedule =
          Schedule(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            schedule = schedule.build(),
          )
      }
    }

    /** The maximum number of units of the medication that can be dispensed in a period. */
    @Serializable(with = MedicationKnowledgeRegulatoryMaxDispenseSerializer::class)
    public data class MaxDispense(
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
      /** The maximum number of units of the medication that can be dispensed. */
      public val quantity: Quantity,
      /** The period that applies to the maximum number of units. */
      public val period: Duration? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(quantity.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            period = this@with.period?.toBuilder()
          }
        }

      public class Builder(
        /** The maximum number of units of the medication that can be dispensed. */
        public var quantity: Quantity.Builder
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

        /** The period that applies to the maximum number of units. */
        public var period: Duration.Builder? = null

        public fun build(): MaxDispense =
          MaxDispense(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            quantity = quantity.build(),
            period = period?.build(),
          )
      }
    }

    public class Builder(
      /** The authority that is specifying the regulations. */
      public var regulatoryAuthority: Reference.Builder
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
       * Specifies if changes are allowed when dispensing a medication from a regulatory
       * perspective.
       */
      public var substitution: MutableList<Substitution.Builder> = mutableListOf()

      /** Specifies the schedule of a medication in jurisdiction. */
      public var schedule: MutableList<Schedule.Builder> = mutableListOf()

      /** The maximum number of units of the medication that can be dispensed in a period. */
      public var maxDispense: MaxDispense.Builder? = null

      public fun build(): Regulatory =
        Regulatory(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          regulatoryAuthority = regulatoryAuthority.build(),
          substitution = substitution.map { it.build() },
          schedule = schedule.map { it.build() },
          maxDispense = maxDispense?.build(),
        )
    }
  }

  /**
   * The time course of drug absorption, distribution, metabolism and excretion of a medication from
   * the body.
   */
  @Serializable(with = MedicationKnowledgeKineticsSerializer::class)
  public data class Kinetics(
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
    /** The drug concentration measured at certain discrete points in time. */
    public val areaUnderCurve: List<Quantity> = listOf(),
    /** The median lethal dose of a drug. */
    public val lethalDose50: List<Quantity> = listOf(),
    /**
     * The time required for any specified property (e.g., the concentration of a substance in the
     * body) to decrease by half.
     */
    public val halfLifePeriod: Duration? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          areaUnderCurve = this@with.areaUnderCurve.map { it.toBuilder() }.toMutableList()
          lethalDose50 = this@with.lethalDose50.map { it.toBuilder() }.toMutableList()
          halfLifePeriod = this@with.halfLifePeriod?.toBuilder()
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

      /** The drug concentration measured at certain discrete points in time. */
      public var areaUnderCurve: MutableList<Quantity.Builder> = mutableListOf()

      /** The median lethal dose of a drug. */
      public var lethalDose50: MutableList<Quantity.Builder> = mutableListOf()

      /**
       * The time required for any specified property (e.g., the concentration of a substance in the
       * body) to decrease by half.
       */
      public var halfLifePeriod: Duration.Builder? = null

      public fun build(): Kinetics =
        Kinetics(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          areaUnderCurve = areaUnderCurve.map { it.build() },
          lethalDose50 = lethalDose50.map { it.build() },
          halfLifePeriod = halfLifePeriod?.build(),
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
     * A code that specifies this medication, or a textual description if no code is available.
     * Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT,
     * IDMP etc. It could also be a national or local formulary code, optionally with translations
     * to other code systems.
     *
     * Depending on the context of use, the code that was actually selected by the user (prescriber,
     * dispenser, etc.) will have the coding.userSelected set to true. As described in the coding
     * datatype: "A coding may be marked as a "userSelected" if a user selected the particular coded
     * value in a user interface (e.g. the user selects an item in a pick-list). If a user selected
     * coding exists, it is the preferred choice for performing translations etc. Other codes can
     * only be literal translations to alternative code systems, or codes at a lower level of
     * granularity (e.g. a generic code for a vendor-specific primary one).
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * A code to indicate if the medication is in active use. The status refers to the validity
     * about the information of the medication and not to its medicinal properties.
     *
     * This status is intended to identify if the medication in a local system is in active use
     * within a drug database or inventory. For example, a pharmacy system may create a new drug
     * file record for a compounded product "ABC Hospital Special Cream" with an active status. At
     * some point in the future, it may be determined that the drug record was created with an error
     * and the status is changed to "entered in error". This status is not intended to specify if a
     * medication is part of a particular formulary. It is possible that the drug record may be
     * referenced by multiple formularies or catalogues and each of those entries would have a
     * separate status.
     */
    public var status: Enumeration<MedicationKnowledgeStatusCodes>? = null

    /**
     * Describes the details of the manufacturer of the medication product. This is not intended to
     * represent the distributor of a medication product.
     */
    public var manufacturer: Reference.Builder? = null

    /**
     * Describes the form of the item. Powder; tablets; capsule.
     *
     * When Medication is referenced from MedicationRequest, this is the ordered form. When
     * Medication is referenced within MedicationDispense, this is the dispensed form. When
     * Medication is referenced within MedicationAdministration, this is administered form.
     */
    public var doseForm: CodeableConcept.Builder? = null

    /**
     * Specific amount of the drug in the packaged product. For example, when specifying a product
     * that has the same strength (For example, Insulin glargine 100 unit per mL solution for
     * injection), this attribute provides additional clarification of the package amount (For
     * example, 3 mL, 10mL, etc.).
     *
     * This is the quantity of medication in a package. To specify the strength of the medication,
     * the Ingredient.strength attribute is used.
     */
    public var amount: Quantity.Builder? = null

    /**
     * Additional names for a medication, for example, the name(s) given to a medication in
     * different countries. For example, acetaminophen and paracetamol or salbutamol and albuterol.
     */
    public var synonym: MutableList<String.Builder> = mutableListOf()

    /** Associated or related knowledge about a medication. */
    public var relatedMedicationKnowledge: MutableList<RelatedMedicationKnowledge.Builder> =
      mutableListOf()

    /**
     * Associated or related medications. For example, if the medication is a branded product (e.g.
     * Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic
     * medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor).
     */
    public var associatedMedication: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Category of the medication or product (e.g. branded product, therapeutic moeity, generic
     * product, innovator product, etc.).
     */
    public var productType: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Associated documentation about the medication. */
    public var monograph: MutableList<Monograph.Builder> = mutableListOf()

    /** Identifies a particular constituent of interest in the product. */
    public var ingredient: MutableList<Ingredient.Builder> = mutableListOf()

    /** The instructions for preparing the medication. */
    public var preparationInstruction: Markdown.Builder? = null

    /** The intended or approved route of administration. */
    public var intendedRoute: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The price of the medication. */
    public var cost: MutableList<Cost.Builder> = mutableListOf()

    /** The program under which the medication is reviewed. */
    public var monitoringProgram: MutableList<MonitoringProgram.Builder> = mutableListOf()

    /** Guidelines for the administration of the medication. */
    public var administrationGuidelines: MutableList<AdministrationGuidelines.Builder> =
      mutableListOf()

    /** Categorization of the medication within a formulary or classification system. */
    public var medicineClassification: MutableList<MedicineClassification.Builder> = mutableListOf()

    /** Information that only applies to packages (not products). */
    public var packaging: Packaging.Builder? = null

    /** Specifies descriptive properties of the medicine, such as color, shape, imprints, etc. */
    public var drugCharacteristic: MutableList<DrugCharacteristic.Builder> = mutableListOf()

    /**
     * Potential clinical issue with or between medication(s) (for example, drug-drug interaction,
     * drug-disease contraindication, drug-allergy interaction, etc.).
     */
    public var contraindication: MutableList<Reference.Builder> = mutableListOf()

    /** Regulatory information about a medication. */
    public var regulatory: MutableList<Regulatory.Builder> = mutableListOf()

    /**
     * The time course of drug absorption, distribution, metabolism and excretion of a medication
     * from the body.
     */
    public var kinetics: MutableList<Kinetics.Builder> = mutableListOf()

    override fun build(): MedicationKnowledge =
      MedicationKnowledge(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        code = code?.build(),
        status = status,
        manufacturer = manufacturer?.build(),
        doseForm = doseForm?.build(),
        amount = amount?.build(),
        synonym = synonym.map { it.build() },
        relatedMedicationKnowledge = relatedMedicationKnowledge.map { it.build() },
        associatedMedication = associatedMedication.map { it.build() },
        productType = productType.map { it.build() },
        monograph = monograph.map { it.build() },
        ingredient = ingredient.map { it.build() },
        preparationInstruction = preparationInstruction?.build(),
        intendedRoute = intendedRoute.map { it.build() },
        cost = cost.map { it.build() },
        monitoringProgram = monitoringProgram.map { it.build() },
        administrationGuidelines = administrationGuidelines.map { it.build() },
        medicineClassification = medicineClassification.map { it.build() },
        packaging = packaging?.build(),
        drugCharacteristic = drugCharacteristic.map { it.build() },
        contraindication = contraindication.map { it.build() },
        regulatory = regulatory.map { it.build() },
        kinetics = kinetics.map { it.build() },
      )
  }

  /** MedicationKnowledge Status Codes */
  public enum class MedicationKnowledgeStatusCodes(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Active("active", "http://terminology.hl7.org/CodeSystem/medicationknowledge-status", "Active"),
    Inactive(
      "inactive",
      "http://terminology.hl7.org/CodeSystem/medicationknowledge-status",
      "Inactive",
    ),
    Entered_In_Error(
      "entered-in-error",
      "http://terminology.hl7.org/CodeSystem/medicationknowledge-status",
      "Entered in Error",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): MedicationKnowledgeStatusCodes =
        fromCodeOrNull(code)
          ?: throw IllegalArgumentException(
            "Unknown code $code for enum MedicationKnowledgeStatusCodes"
          )

      public fun fromCodeOrNull(code: kotlin.String?): MedicationKnowledgeStatusCodes? =
        when (code) {
          "active" -> Active
          "inactive" -> Inactive
          "entered-in-error" -> Entered_In_Error
          else -> null
        }
    }
  }
}
