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

import dev.ohs.fhir.model.r5.serializers.MedicationBatchSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationIngredientSerializer
import dev.ohs.fhir.model.r5.serializers.MedicationSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource is primarily used for the identification and definition of a medication, including
 * ingredients, for the purposes of prescribing, dispensing, and administering a medication as well
 * as for making statements about medication use.
 */
@Serializable(with = MedicationSerializer::class)
@SerialName("Medication")
public data class Medication(
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
   * The serial number could be included as an identifier.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A code (or set of codes) that specify this medication, or a textual description if no code is
   * available. Usage note: This could be a standard medication code such as a code from RxNorm,
   * SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with
   * translations to other code systems.
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
   * A code to indicate if the medication is in active use.
   *
   * This status is intended to identify if the medication in a local system is in active use within
   * a drug database or inventory. For example, a pharmacy system may create a new drug file record
   * for a compounded product "ABC Hospital Special Cream" with an active status. At some point in
   * the future, it may be determined that the drug record was created with an error and the status
   * is changed to "entered in error". This status is not intended to specify if a medication is
   * part of a particular formulary. It is possible that the drug record may be referenced by
   * multiple formularies or catalogues and each of those entries would have a separate status.
   */
  public val status: Enumeration<MedicationStatusCodes>? = null,
  /**
   * The company or other legal entity that has authorization, from the appropriate drug regulatory
   * authority, to market a medicine in one or more jurisdictions. Typically abbreviated MAH.Note:
   * The MAH may manufacture the product and may also contract the manufacturing of the product to
   * one or more companies (organizations).
   */
  public val marketingAuthorizationHolder: Reference? = null,
  /**
   * Describes the form of the item. Powder; tablets; capsule.
   *
   * When Medication is referenced from MedicationRequest, this is the ordered form. When Medication
   * is referenced within MedicationDispense, this is the dispensed form. When Medication is
   * referenced within MedicationAdministration, this is administered form.
   */
  public val doseForm: CodeableConcept? = null,
  /**
   * When the specified product code does not infer a package size, this is the specific amount of
   * drug in the product. For example, when specifying a product that has the same strength (For
   * example, Insulin glargine 100 unit per mL solution for injection), this attribute provides
   * additional clarification of the package amount (For example, 3 mL, 10mL, etc.).
   */
  public val totalVolume: Quantity? = null,
  /**
   * Identifies a particular constituent of interest in the product.
   *
   * The ingredients need not be a complete list. If an ingredient is not specified, this does not
   * indicate whether an ingredient is present or absent. If an ingredient is specified it does not
   * mean that all ingredients are specified. It is possible to specify both inactive and active
   * ingredients.
   */
  public val ingredient: List<Ingredient> = listOf(),
  /** Information that only applies to packages (not products). */
  public val batch: Batch? = null,
  /** A reference to a knowledge resource that provides more information about this medication. */
  public val definition: Reference? = null,
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
        marketingAuthorizationHolder = this@with.marketingAuthorizationHolder?.toBuilder()
        doseForm = this@with.doseForm?.toBuilder()
        totalVolume = this@with.totalVolume?.toBuilder()
        ingredient = this@with.ingredient.map { it.toBuilder() }.toMutableList()
        batch = this@with.batch?.toBuilder()
        definition = this@with.definition?.toBuilder()
      }
    }

  /** Identifies a particular constituent of interest in the product. */
  @Serializable(with = MedicationIngredientSerializer::class)
  public data class Ingredient(
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
     * The ingredient (substance or medication) that the ingredient.strength relates to. This is
     * represented as a concept from a code system or described in another resource (Substance or
     * Medication).
     */
    public val item: CodeableReference,
    /** Indication of whether this ingredient affects the therapeutic action of the drug. */
    public val isActive: Boolean? = null,
    /**
     * Specifies how many (or how much) of the items there are in this Medication. For example, 250
     * mg per tablet. This is expressed as a ratio where the numerator is 250mg and the denominator
     * is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1
     * tablet.
     */
    public val strength: Strength? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(item.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          isActive = this@with.isActive?.toBuilder()
          strength = this@with.strength
        }
      }

    public sealed interface Strength {
      public fun asRatio(): Ratio? = this as? Ratio

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asQuantity(): Quantity? = this as? Quantity

      @JvmInline
      public value class Ratio(public val `value`: dev.ohs.fhir.model.r5.Ratio) : Strength

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Strength

      @JvmInline
      public value class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Strength

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
      /**
       * The ingredient (substance or medication) that the ingredient.strength relates to. This is
       * represented as a concept from a code system or described in another resource (Substance or
       * Medication).
       */
      public var item: CodeableReference.Builder
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

      /** Indication of whether this ingredient affects the therapeutic action of the drug. */
      public var isActive: Boolean.Builder? = null

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
          isActive = isActive?.build(),
          strength = strength,
        )
    }
  }

  /** Information that only applies to packages (not products). */
  @Serializable(with = MedicationBatchSerializer::class)
  public data class Batch(
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
    /** The assigned lot number of a batch of the specified product. */
    public val lotNumber: String? = null,
    /** When this specific batch of product will expire. */
    public val expirationDate: DateTime? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          lotNumber = this@with.lotNumber?.toBuilder()
          expirationDate = this@with.expirationDate?.toBuilder()
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

      /** The assigned lot number of a batch of the specified product. */
      public var lotNumber: String.Builder? = null

      /** When this specific batch of product will expire. */
      public var expirationDate: DateTime.Builder? = null

      public fun build(): Batch =
        Batch(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          lotNumber = lotNumber?.build(),
          expirationDate = expirationDate?.build(),
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
     * The serial number could be included as an identifier.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A code (or set of codes) that specify this medication, or a textual description if no code is
     * available. Usage note: This could be a standard medication code such as a code from RxNorm,
     * SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with
     * translations to other code systems.
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
     * A code to indicate if the medication is in active use.
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
    public var status: Enumeration<MedicationStatusCodes>? = null

    /**
     * The company or other legal entity that has authorization, from the appropriate drug
     * regulatory authority, to market a medicine in one or more jurisdictions. Typically
     * abbreviated MAH.Note: The MAH may manufacture the product and may also contract the
     * manufacturing of the product to one or more companies (organizations).
     */
    public var marketingAuthorizationHolder: Reference.Builder? = null

    /**
     * Describes the form of the item. Powder; tablets; capsule.
     *
     * When Medication is referenced from MedicationRequest, this is the ordered form. When
     * Medication is referenced within MedicationDispense, this is the dispensed form. When
     * Medication is referenced within MedicationAdministration, this is administered form.
     */
    public var doseForm: CodeableConcept.Builder? = null

    /**
     * When the specified product code does not infer a package size, this is the specific amount of
     * drug in the product. For example, when specifying a product that has the same strength (For
     * example, Insulin glargine 100 unit per mL solution for injection), this attribute provides
     * additional clarification of the package amount (For example, 3 mL, 10mL, etc.).
     */
    public var totalVolume: Quantity.Builder? = null

    /**
     * Identifies a particular constituent of interest in the product.
     *
     * The ingredients need not be a complete list. If an ingredient is not specified, this does not
     * indicate whether an ingredient is present or absent. If an ingredient is specified it does
     * not mean that all ingredients are specified. It is possible to specify both inactive and
     * active ingredients.
     */
    public var ingredient: MutableList<Ingredient.Builder> = mutableListOf()

    /** Information that only applies to packages (not products). */
    public var batch: Batch.Builder? = null

    /** A reference to a knowledge resource that provides more information about this medication. */
    public var definition: Reference.Builder? = null

    override fun build(): Medication =
      Medication(
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
        marketingAuthorizationHolder = marketingAuthorizationHolder?.build(),
        doseForm = doseForm?.build(),
        totalVolume = totalVolume?.build(),
        ingredient = ingredient.map { it.build() },
        batch = batch?.build(),
        definition = definition?.build(),
      )
  }

  /** Medication Status Codes */
  public enum class MedicationStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/CodeSystem/medication-status", "Active"),
    Inactive("inactive", "http://hl7.org/fhir/CodeSystem/medication-status", "Inactive"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/CodeSystem/medication-status",
      "Entered in Error",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): MedicationStatusCodes =
        when (code) {
          "active" -> Active
          "inactive" -> Inactive
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException("Unknown code $code for enum MedicationStatusCodes")
        }
    }
  }
}
