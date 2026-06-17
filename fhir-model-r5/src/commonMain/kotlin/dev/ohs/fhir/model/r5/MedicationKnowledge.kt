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

import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeCostSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeDefinitionalDrugCharacteristicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeDefinitionalIngredientSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeDefinitionalSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeIndicationGuidelineSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeMedicineClassificationSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeMonitoringProgramSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeMonographSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgePackagingSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeRegulatoryMaxDispenseSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeRegulatorySerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeRegulatorySubstitutionSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeRelatedMedicationKnowledgeSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationKnowledgeStorageGuidelineSerializer
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
   * Business identifier for this medication.
   *
   * This is a business identifier, not a resource identifier (see discussion).
   */
  public val identifier: List<Identifier> = listOf(),
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
   * A code to indicate if the medication referred to by this MedicationKnowledge is in active use
   * within the drug database or inventory system. The status refers to the validity about the
   * information of the medication and not to its medicinal properties.
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
  /** The creator or owner of the knowledge or information about the medication. */
  public val author: Reference? = null,
  /**
   * Lists the jurisdictions that this medication knowledge was written for.
   *
   * The codes could have varying granularity from a country or group of countries down to a
   * specific district.
   */
  public val intendedJurisdiction: List<CodeableConcept> = listOf(),
  /**
   * All of the names for a medication, for example, the name(s) given to a medication in different
   * countries. For example, acetaminophen and paracetamol or salbutamol and albuterol.
   */
  public val name: List<String> = listOf(),
  /**
   * Associated or related medications. For example, if the medication is a branded product (e.g.
   * Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication
   * (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.
   */
  public val relatedMedicationKnowledge: List<RelatedMedicationKnowledge> = listOf(),
  /** Links to associated medications that could be prescribed, dispensed or administered. */
  public val associatedMedication: List<Reference> = listOf(),
  /**
   * Category of the medication or product (e.g. branded product, therapeutic moeity, generic
   * product, innovator product, etc.).
   */
  public val productType: List<CodeableConcept> = listOf(),
  /** Associated documentation about the medication. */
  public val monograph: List<Monograph> = listOf(),
  /** The instructions for preparing the medication. */
  public val preparationInstruction: Markdown? = null,
  /** The price of the medication. */
  public val cost: List<Cost> = listOf(),
  /** The program under which the medication is reviewed. */
  public val monitoringProgram: List<MonitoringProgram> = listOf(),
  /**
   * Guidelines or protocols that are applicable for the administration of the medication based on
   * indication.
   */
  public val indicationGuideline: List<IndicationGuideline> = listOf(),
  /** Categorization of the medication within a formulary or classification system. */
  public val medicineClassification: List<MedicineClassification> = listOf(),
  /** Information that only applies to packages (not products). */
  public val packaging: List<Packaging> = listOf(),
  /**
   * Potential clinical issue with or between medication(s) (for example, drug-drug interaction,
   * drug-disease contraindication, drug-allergy interaction, etc.).
   */
  public val clinicalUseIssue: List<Reference> = listOf(),
  /**
   * Information on how the medication should be stored, for example, refrigeration temperatures and
   * length of stability at a given temperature.
   */
  public val storageGuideline: List<StorageGuideline> = listOf(),
  /** Regulatory information about a medication. */
  public val regulatory: List<Regulatory> = listOf(),
  /**
   * Along with the link to a Medicinal Product Definition resource, this information provides
   * common definitional elements that are needed to understand the specific medication that is
   * being described.
   */
  public val definitional: Definitional? = null,
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
        code = this@with.code?.toBuilder()
        status = this@with.status
        author = this@with.author?.toBuilder()
        intendedJurisdiction = this@with.intendedJurisdiction.map { it.toBuilder() }.toMutableList()
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        relatedMedicationKnowledge =
          this@with.relatedMedicationKnowledge.map { it.toBuilder() }.toMutableList()
        associatedMedication = this@with.associatedMedication.map { it.toBuilder() }.toMutableList()
        productType = this@with.productType.map { it.toBuilder() }.toMutableList()
        monograph = this@with.monograph.map { it.toBuilder() }.toMutableList()
        preparationInstruction = this@with.preparationInstruction?.toBuilder()
        cost = this@with.cost.map { it.toBuilder() }.toMutableList()
        monitoringProgram = this@with.monitoringProgram.map { it.toBuilder() }.toMutableList()
        indicationGuideline = this@with.indicationGuideline.map { it.toBuilder() }.toMutableList()
        medicineClassification =
          this@with.medicineClassification.map { it.toBuilder() }.toMutableList()
        packaging = this@with.packaging.map { it.toBuilder() }.toMutableList()
        clinicalUseIssue = this@with.clinicalUseIssue.map { it.toBuilder() }.toMutableList()
        storageGuideline = this@with.storageGuideline.map { it.toBuilder() }.toMutableList()
        regulatory = this@with.regulatory.map { it.toBuilder() }.toMutableList()
        definitional = this@with.definitional?.toBuilder()
      }
    }

  /**
   * Associated or related medications. For example, if the medication is a branded product (e.g.
   * Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication
   * (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.
   */
  @Serializable(with = MedicationKnowledgeRelatedMedicationKnowledgeSerializer::class)
  public data class RelatedMedicationKnowledge(
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
    /** The date range for which the cost information of the medication is effective. */
    public val effectiveDate: List<Period> = listOf(),
    /**
     * The category of the cost information. For example, manufacturers' cost, patient cost, claim
     * reimbursement cost, actual acquisition cost.
     */
    public val type: CodeableConcept,
    /** The source or owner that assigns the price to the medication. */
    public val source: String? = null,
    /**
     * The price or representation of the cost (for example, Band A, Band B or $, $$) of the
     * medication.
     */
    public val cost: Cost,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            type.toBuilder(),
            cost,
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            effectiveDate = this@with.effectiveDate.map { it.toBuilder() }.toMutableList()
            source = this@with.source?.toBuilder()
          }
      }

    public sealed interface Cost {
      public fun asMoney(): Money? = this as? Money

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Money(public val `value`: dev.ohs.fhir.model.r5.Money) : Cost

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Cost

      public companion object {
        internal fun from(
          moneyValue: dev.ohs.fhir.model.r5.Money?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): Cost? {
          if (moneyValue != null) return Money(moneyValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The category of the cost information. For example, manufacturers' cost, patient cost, claim
       * reimbursement cost, actual acquisition cost.
       */
      public var type: CodeableConcept.Builder,
      /**
       * The price or representation of the cost (for example, Band A, Band B or $, $$) of the
       * medication.
       */
      public var cost: Cost,
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

      /** The date range for which the cost information of the medication is effective. */
      public var effectiveDate: MutableList<Period.Builder> = mutableListOf()

      /** The source or owner that assigns the price to the medication. */
      public var source: String.Builder? = null

      public fun build(): MedicationKnowledge.Cost =
        MedicationKnowledge.Cost(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          effectiveDate = effectiveDate.map { it.build() },
          type = type.build(),
          source = source?.build(),
          cost = cost,
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

  /**
   * Guidelines or protocols that are applicable for the administration of the medication based on
   * indication.
   */
  @Serializable(with = MedicationKnowledgeIndicationGuidelineSerializer::class)
  public data class IndicationGuideline(
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
     * Indication or reason for use of the medication that applies to the specific administration
     * guideline.
     */
    public val indication: List<CodeableReference> = listOf(),
    /** The guidelines for the dosage of the medication for the indication. */
    public val dosingGuideline: List<DosingGuideline> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          indication = this@with.indication.map { it.toBuilder() }.toMutableList()
          dosingGuideline = this@with.dosingGuideline.map { it.toBuilder() }.toMutableList()
        }
      }

    /** The guidelines for the dosage of the medication for the indication. */
    @Serializable(with = MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer::class)
    public data class DosingGuideline(
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
       * The overall intention of the treatment, for example, prophylactic, supporative, curative,
       * etc.
       */
      public val treatmentIntent: CodeableConcept? = null,
      /** Dosage for the medication for the specific guidelines. */
      public val dosage: List<Dosage> = listOf(),
      /**
       * The type of the treatment that the guideline applies to, for example, long term therapy,
       * first line treatment, etc.
       */
      public val administrationTreatment: CodeableConcept? = null,
      /**
       * Characteristics of the patient that are relevant to the administration guidelines (for
       * example, height, weight, gender, etc.).
       */
      public val patientCharacteristic: List<PatientCharacteristic> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            treatmentIntent = this@with.treatmentIntent?.toBuilder()
            dosage = this@with.dosage.map { it.toBuilder() }.toMutableList()
            administrationTreatment = this@with.administrationTreatment?.toBuilder()
            patientCharacteristic =
              this@with.patientCharacteristic.map { it.toBuilder() }.toMutableList()
          }
        }

      /** Dosage for the medication for the specific guidelines. */
      @Serializable(
        with = MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer::class
      )
      public data class Dosage(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The type or category of dosage for a given medication (for example, prophylaxis,
         * maintenance, therapeutic, etc.).
         */
        public val type: CodeableConcept,
        /** Dosage for the medication for the specific guidelines. */
        public val dosage: List<dev.ohs.fhir.model.r5.Dosage>,
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
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              }
          }

        public class Builder(
          /**
           * The type or category of dosage for a given medication (for example, prophylaxis,
           * maintenance, therapeutic, etc.).
           */
          public var type: CodeableConcept.Builder,
          /** Dosage for the medication for the specific guidelines. */
          public var dosage: MutableList<dev.ohs.fhir.model.r5.Dosage.Builder>,
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and managable, there is a strict set of governance applied to the
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
        with =
          MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer::class
      )
      public data class PatientCharacteristic(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The categorization of the specific characteristic that is relevant to the administration
         * guideline (e.g. height, weight, gender).
         */
        public val type: CodeableConcept,
        /** The specific characteristic (e.g. height, weight, gender, etc.). */
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

          public fun asRange(): Range? = this as? Range

          public data class CodeableConcept(
            public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
          ) : Value

          public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

          public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

          public companion object {
            internal fun from(
              codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
              quantityValue: dev.ohs.fhir.model.r5.Quantity?,
              rangeValue: dev.ohs.fhir.model.r5.Range?,
            ): Value? {
              if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
              if (quantityValue != null) return Quantity(quantityValue)
              if (rangeValue != null) return Range(rangeValue)
              return null
            }
          }
        }

        public class Builder(
          /**
           * The categorization of the specific characteristic that is relevant to the
           * administration guideline (e.g. height, weight, gender).
           */
          public var type: CodeableConcept.Builder
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and managable, there is a strict set of governance applied to the
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

          /** The specific characteristic (e.g. height, weight, gender, etc.). */
          public var `value`: Value? = null

          public fun build(): PatientCharacteristic =
            PatientCharacteristic(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              type = type.build(),
              `value` = `value`,
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
         * The overall intention of the treatment, for example, prophylactic, supporative, curative,
         * etc.
         */
        public var treatmentIntent: CodeableConcept.Builder? = null

        /** Dosage for the medication for the specific guidelines. */
        public var dosage: MutableList<Dosage.Builder> = mutableListOf()

        /**
         * The type of the treatment that the guideline applies to, for example, long term therapy,
         * first line treatment, etc.
         */
        public var administrationTreatment: CodeableConcept.Builder? = null

        /**
         * Characteristics of the patient that are relevant to the administration guidelines (for
         * example, height, weight, gender, etc.).
         */
        public var patientCharacteristic: MutableList<PatientCharacteristic.Builder> =
          mutableListOf()

        public fun build(): DosingGuideline =
          DosingGuideline(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            treatmentIntent = treatmentIntent?.build(),
            dosage = dosage.map { it.build() },
            administrationTreatment = administrationTreatment?.build(),
            patientCharacteristic = patientCharacteristic.map { it.build() },
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
       * Indication or reason for use of the medication that applies to the specific administration
       * guideline.
       */
      public var indication: MutableList<CodeableReference.Builder> = mutableListOf()

      /** The guidelines for the dosage of the medication for the indication. */
      public var dosingGuideline: MutableList<DosingGuideline.Builder> = mutableListOf()

      public fun build(): IndicationGuideline =
        IndicationGuideline(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          indication = indication.map { it.build() },
          dosingGuideline = dosingGuideline.map { it.build() },
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
     * The type of category for the medication (for example, therapeutic classification, therapeutic
     * sub-classification).
     */
    public val type: CodeableConcept,
    /** Either a textual source of the classification or a reference to an online source. */
    public val source: Source? = null,
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
          source = this@with.source
          classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Source {
      public fun asString(): String? = this as? String

      public fun asUri(): Uri? = this as? Uri

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Source

      public data class Uri(public val `value`: dev.ohs.fhir.model.r5.Uri) : Source

      public companion object {
        internal fun from(
          stringValue: dev.ohs.fhir.model.r5.String?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
        ): Source? {
          if (stringValue != null) return String(stringValue)
          if (uriValue != null) return Uri(uriValue)
          return null
        }
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

      /** Either a textual source of the classification or a reference to an online source. */
      public var source: Source? = null

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
          source = source,
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
    /** The cost of the packaged medication. */
    public val cost: List<Cost> = listOf(),
    /**
     * A reference to a PackagedProductDefinition that provides the details of the product that is
     * in the packaging and is being priced.
     */
    public val packagedProduct: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          cost = this@with.cost.map { it.toBuilder() }.toMutableList()
          packagedProduct = this@with.packagedProduct?.toBuilder()
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

      /** The cost of the packaged medication. */
      public var cost: MutableList<Cost.Builder> = mutableListOf()

      /**
       * A reference to a PackagedProductDefinition that provides the details of the product that is
       * in the packaging and is being priced.
       */
      public var packagedProduct: Reference.Builder? = null

      public fun build(): Packaging =
        Packaging(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          cost = cost.map { it.build() },
          packagedProduct = packagedProduct?.build(),
        )
    }
  }

  /**
   * Information on how the medication should be stored, for example, refrigeration temperatures and
   * length of stability at a given temperature.
   */
  @Serializable(with = MedicationKnowledgeStorageGuidelineSerializer::class)
  public data class StorageGuideline(
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
    /** Reference to additional information about the storage guidelines. */
    public val reference: Uri? = null,
    /** Additional notes about the storage. */
    public val note: List<Annotation> = listOf(),
    /** Duration that the medication remains stable if the environmentalSetting is respected. */
    public val stabilityDuration: Duration? = null,
    /**
     * Describes a setting/value on the environment for the adequate storage of the medication and
     * other substances. Environment settings may involve temperature, humidity, or exposure to
     * light.
     */
    public val environmentalSetting: List<EnvironmentalSetting> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          reference = this@with.reference?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          stabilityDuration = this@with.stabilityDuration?.toBuilder()
          environmentalSetting =
            this@with.environmentalSetting.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Describes a setting/value on the environment for the adequate storage of the medication and
     * other substances. Environment settings may involve temperature, humidity, or exposure to
     * light.
     */
    @Serializable(with = MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer::class)
    public data class EnvironmentalSetting(
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
       * Identifies the category or type of setting (e.g., type of location, temperature, humidity).
       */
      public val type: CodeableConcept,
      /** Value associated to the setting. E.g., 40° – 50°F for temperature. */
      public val `value`: Value,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              type.toBuilder(),
              `value`,
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            }
        }

      public sealed interface Value {
        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asRange(): Range? = this as? Range

        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

        public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Value

        public companion object {
          internal fun from(
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            rangeValue: dev.ohs.fhir.model.r5.Range?,
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          ): Value? {
            if (quantityValue != null) return Quantity(quantityValue)
            if (rangeValue != null) return Range(rangeValue)
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * Identifies the category or type of setting (e.g., type of location, temperature,
         * humidity).
         */
        public var type: CodeableConcept.Builder,
        /** Value associated to the setting. E.g., 40° – 50°F for temperature. */
        public var `value`: Value,
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

        public fun build(): EnvironmentalSetting =
          EnvironmentalSetting(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.build(),
            `value` = `value`,
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

      /** Reference to additional information about the storage guidelines. */
      public var reference: Uri.Builder? = null

      /** Additional notes about the storage. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      /** Duration that the medication remains stable if the environmentalSetting is respected. */
      public var stabilityDuration: Duration.Builder? = null

      /**
       * Describes a setting/value on the environment for the adequate storage of the medication and
       * other substances. Environment settings may involve temperature, humidity, or exposure to
       * light.
       */
      public var environmentalSetting: MutableList<EnvironmentalSetting.Builder> = mutableListOf()

      public fun build(): StorageGuideline =
        StorageGuideline(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          reference = reference?.build(),
          note = note.map { it.build() },
          stabilityDuration = stabilityDuration?.build(),
          environmentalSetting = environmentalSetting.map { it.build() },
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
    /** The authority that is specifying the regulations. */
    public val regulatoryAuthority: Reference,
    /**
     * Specifies if changes are allowed when dispensing a medication from a regulatory perspective.
     */
    public val substitution: List<Substitution> = listOf(),
    /** Specifies the schedule of a medication in jurisdiction. */
    public val schedule: List<CodeableConcept> = listOf(),
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
       * Specifies if changes are allowed when dispensing a medication from a regulatory
       * perspective.
       */
      public var substitution: MutableList<Substitution.Builder> = mutableListOf()

      /** Specifies the schedule of a medication in jurisdiction. */
      public var schedule: MutableList<CodeableConcept.Builder> = mutableListOf()

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
   * Along with the link to a Medicinal Product Definition resource, this information provides
   * common definitional elements that are needed to understand the specific medication that is
   * being described.
   */
  @Serializable(with = MedicationKnowledgeDefinitionalSerializer::class)
  public data class Definitional(
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
    /** Associated definitions for this medication. */
    public val definition: List<Reference> = listOf(),
    /**
     * Describes the form of the item. Powder; tablets; capsule.
     *
     * When Medication is referenced from MedicationRequest, this is the ordered form. When
     * Medication is referenced within MedicationDispense, this is the dispensed form. When
     * Medication is referenced within MedicationAdministration, this is administered form.
     */
    public val doseForm: CodeableConcept? = null,
    /** The intended or approved route of administration. */
    public val intendedRoute: List<CodeableConcept> = listOf(),
    /** Identifies a particular constituent of interest in the product. */
    public val ingredient: List<Ingredient> = listOf(),
    /** Specifies descriptive properties of the medicine, such as color, shape, imprints, etc. */
    public val drugCharacteristic: List<DrugCharacteristic> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          definition = this@with.definition.map { it.toBuilder() }.toMutableList()
          doseForm = this@with.doseForm?.toBuilder()
          intendedRoute = this@with.intendedRoute.map { it.toBuilder() }.toMutableList()
          ingredient = this@with.ingredient.map { it.toBuilder() }.toMutableList()
          drugCharacteristic = this@with.drugCharacteristic.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Identifies a particular constituent of interest in the product. */
    @Serializable(with = MedicationKnowledgeDefinitionalIngredientSerializer::class)
    public data class Ingredient(
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
      /** A reference to the resource that provides information about the ingredient. */
      public val item: CodeableReference,
      /** Indication of whether this ingredient affects the therapeutic action of the drug. */
      public val type: CodeableConcept? = null,
      /**
       * Specifies how many (or how much) of the items there are in this Medication. For example,
       * 250 mg per tablet. This is expressed as a ratio where the numerator is 250mg and the
       * denominator is 1 tablet but can also be expressed a quantity when the denominator is
       * assumed to be 1 tablet.
       */
      public val strength: Strength? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(item.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            strength = this@with.strength
          }
        }

      public sealed interface Strength {
        public fun asRatio(): Ratio? = this as? Ratio

        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asQuantity(): Quantity? = this as? Quantity

        public data class Ratio(public val `value`: dev.ohs.fhir.model.r5.Ratio) : Strength

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Strength

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Strength

        public companion object {
          internal fun from(
            ratioValue: dev.ohs.fhir.model.r5.Ratio?,
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          ): Strength? {
            if (ratioValue != null) return Ratio(ratioValue)
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (quantityValue != null) return Quantity(quantityValue)
            return null
          }
        }
      }

      public class Builder(
        /** A reference to the resource that provides information about the ingredient. */
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

        /** Indication of whether this ingredient affects the therapeutic action of the drug. */
        public var type: CodeableConcept.Builder? = null

        /**
         * Specifies how many (or how much) of the items there are in this Medication. For example,
         * 250 mg per tablet. This is expressed as a ratio where the numerator is 250mg and the
         * denominator is 1 tablet but can also be expressed a quantity when the denominator is
         * assumed to be 1 tablet.
         */
        public var strength: Strength? = null

        public fun build(): Ingredient =
          Ingredient(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            item = item.build(),
            type = type?.build(),
            strength = strength,
          )
      }
    }

    /** Specifies descriptive properties of the medicine, such as color, shape, imprints, etc. */
    @Serializable(with = MedicationKnowledgeDefinitionalDrugCharacteristicSerializer::class)
    public data class DrugCharacteristic(
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

        public fun asAttachment(): Attachment? = this as? Attachment

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Value

        public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

        public data class Base64Binary(public val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
          Value

        public data class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            stringValue: dev.ohs.fhir.model.r5.String?,
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
            attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          ): Value? {
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (stringValue != null) return String(stringValue)
            if (quantityValue != null) return Quantity(quantityValue)
            if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
            if (attachmentValue != null) return Attachment(attachmentValue)
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

      /** Associated definitions for this medication. */
      public var definition: MutableList<Reference.Builder> = mutableListOf()

      /**
       * Describes the form of the item. Powder; tablets; capsule.
       *
       * When Medication is referenced from MedicationRequest, this is the ordered form. When
       * Medication is referenced within MedicationDispense, this is the dispensed form. When
       * Medication is referenced within MedicationAdministration, this is administered form.
       */
      public var doseForm: CodeableConcept.Builder? = null

      /** The intended or approved route of administration. */
      public var intendedRoute: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Identifies a particular constituent of interest in the product. */
      public var ingredient: MutableList<Ingredient.Builder> = mutableListOf()

      /** Specifies descriptive properties of the medicine, such as color, shape, imprints, etc. */
      public var drugCharacteristic: MutableList<DrugCharacteristic.Builder> = mutableListOf()

      public fun build(): Definitional =
        Definitional(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          definition = definition.map { it.build() },
          doseForm = doseForm?.build(),
          intendedRoute = intendedRoute.map { it.build() },
          ingredient = ingredient.map { it.build() },
          drugCharacteristic = drugCharacteristic.map { it.build() },
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
     * Business identifier for this medication.
     *
     * This is a business identifier, not a resource identifier (see discussion).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

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
     * A code to indicate if the medication referred to by this MedicationKnowledge is in active use
     * within the drug database or inventory system. The status refers to the validity about the
     * information of the medication and not to its medicinal properties.
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

    /** The creator or owner of the knowledge or information about the medication. */
    public var author: Reference.Builder? = null

    /**
     * Lists the jurisdictions that this medication knowledge was written for.
     *
     * The codes could have varying granularity from a country or group of countries down to a
     * specific district.
     */
    public var intendedJurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * All of the names for a medication, for example, the name(s) given to a medication in
     * different countries. For example, acetaminophen and paracetamol or salbutamol and albuterol.
     */
    public var name: MutableList<String.Builder> = mutableListOf()

    /**
     * Associated or related medications. For example, if the medication is a branded product (e.g.
     * Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic
     * medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.
     */
    public var relatedMedicationKnowledge: MutableList<RelatedMedicationKnowledge.Builder> =
      mutableListOf()

    /** Links to associated medications that could be prescribed, dispensed or administered. */
    public var associatedMedication: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Category of the medication or product (e.g. branded product, therapeutic moeity, generic
     * product, innovator product, etc.).
     */
    public var productType: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Associated documentation about the medication. */
    public var monograph: MutableList<Monograph.Builder> = mutableListOf()

    /** The instructions for preparing the medication. */
    public var preparationInstruction: Markdown.Builder? = null

    /** The price of the medication. */
    public var cost: MutableList<Cost.Builder> = mutableListOf()

    /** The program under which the medication is reviewed. */
    public var monitoringProgram: MutableList<MonitoringProgram.Builder> = mutableListOf()

    /**
     * Guidelines or protocols that are applicable for the administration of the medication based on
     * indication.
     */
    public var indicationGuideline: MutableList<IndicationGuideline.Builder> = mutableListOf()

    /** Categorization of the medication within a formulary or classification system. */
    public var medicineClassification: MutableList<MedicineClassification.Builder> = mutableListOf()

    /** Information that only applies to packages (not products). */
    public var packaging: MutableList<Packaging.Builder> = mutableListOf()

    /**
     * Potential clinical issue with or between medication(s) (for example, drug-drug interaction,
     * drug-disease contraindication, drug-allergy interaction, etc.).
     */
    public var clinicalUseIssue: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Information on how the medication should be stored, for example, refrigeration temperatures
     * and length of stability at a given temperature.
     */
    public var storageGuideline: MutableList<StorageGuideline.Builder> = mutableListOf()

    /** Regulatory information about a medication. */
    public var regulatory: MutableList<Regulatory.Builder> = mutableListOf()

    /**
     * Along with the link to a Medicinal Product Definition resource, this information provides
     * common definitional elements that are needed to understand the specific medication that is
     * being described.
     */
    public var definitional: Definitional.Builder? = null

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
        identifier = identifier.map { it.build() },
        code = code?.build(),
        status = status,
        author = author?.build(),
        intendedJurisdiction = intendedJurisdiction.map { it.build() },
        name = name.map { it.build() },
        relatedMedicationKnowledge = relatedMedicationKnowledge.map { it.build() },
        associatedMedication = associatedMedication.map { it.build() },
        productType = productType.map { it.build() },
        monograph = monograph.map { it.build() },
        preparationInstruction = preparationInstruction?.build(),
        cost = cost.map { it.build() },
        monitoringProgram = monitoringProgram.map { it.build() },
        indicationGuideline = indicationGuideline.map { it.build() },
        medicineClassification = medicineClassification.map { it.build() },
        packaging = packaging.map { it.build() },
        clinicalUseIssue = clinicalUseIssue.map { it.build() },
        storageGuideline = storageGuideline.map { it.build() },
        regulatory = regulatory.map { it.build() },
        definitional = definitional?.build(),
      )
  }

  /** MedicationKnowledge Status Codes */
  public enum class MedicationKnowledgeStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/CodeSystem/medicationknowledge-status", "Active"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/CodeSystem/medicationknowledge-status",
      "Entered in Error",
    ),
    Inactive("inactive", "http://hl7.org/fhir/CodeSystem/medicationknowledge-status", "Inactive");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): MedicationKnowledgeStatusCodes =
        when (code) {
          "active" -> Active
          "entered-in-error" -> Entered_In_Error
          "inactive" -> Inactive
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum MedicationKnowledgeStatusCodes"
            )
        }
    }
  }
}
