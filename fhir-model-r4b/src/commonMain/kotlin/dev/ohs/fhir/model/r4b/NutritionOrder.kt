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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.NutritionOrderEnteralFormulaAdministrationSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderEnteralFormulaSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderOralDietNutrientSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderOralDietSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderOralDietTextureSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderSerializer
import dev.ohs.fhir.model.r4b.serializers.NutritionOrderSupplementSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a
 * patient/resident.
 */
@Serializable(with = NutritionOrderSerializer::class)
@SerialName("NutritionOrder")
public data class NutritionOrder(
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
   * Identifiers assigned to this order by the order sender or by the order receiver.
   *
   * The Identifier.type element can be to indicate filler vs. placer if needed. This is explained
   * in further detail [here](servicerequest.html#notes).
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this NutritionOrder.
   *
   * Note: This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this NutritionOrder.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /**
   * The URL pointing to a protocol, guideline, orderset or other definition that is adhered to in
   * whole or in part by this NutritionOrder.
   */
  public val instantiates: List<Uri> = listOf(),
  /**
   * The workflow status of the nutrition order/request.
   *
   * Typically the system placing the order sets the status to "requested". Thereafter, the order is
   * maintained by the receiver that updates the status as the request is handled. This element is
   * labeled as a modifier because the status contains codes that mark the resource as not currently
   * valid.
   */
  public val status: Enumeration<RequestStatus>,
  /**
   * Indicates the level of authority/intentionality associated with the NutrionOrder and where the
   * request fits into the workflow chain.
   *
   * When resources map to this element, they are free to define as many codes as necessary to cover
   * their space and will map to "proposal, plan or order". Can have multiple codes that map to one
   * of these. E.g. "original order", "encoded order", "reflex order" would all map to "order".
   * Expectation is that the set of codes is mutually exclusive or a strict all-encompassing
   * hierarchy.
   */
  public val intent: Enumeration<RequestIntent>,
  /**
   * The person (patient) who needs the nutrition order for an oral diet, nutritional supplement
   * and/or enteral or formula feeding.
   */
  public val patient: Reference,
  /**
   * An encounter that provides additional information about the healthcare context in which this
   * request is made.
   */
  public val encounter: Reference? = null,
  /** The date and time that this nutrition order was requested. */
  public val dateTime: DateTime,
  /**
   * The practitioner that holds legal responsibility for ordering the diet, nutritional supplement,
   * or formula feedings.
   */
  public val orderer: Reference? = null,
  /**
   * A link to a record of allergies or intolerances which should be included in the nutrition
   * order.
   *
   * Information on a patient's food allergies and intolerances to inform healthcare personnel about
   * the type of foods that the patient shouldn't receive or consume.
   */
  public val allergyIntolerance: List<Reference> = listOf(),
  /**
   * This modifier is used to convey order-specific modifiers about the type of food that should be
   * given. These can be derived from patient allergies, intolerances, or preferences such as Halal,
   * Vegan or Kosher. This modifier applies to the entire nutrition order inclusive of the oral
   * diet, nutritional supplements and enteral formula feedings.
   *
   * Information on a patient's food preferences that inform healthcare personnel about the food
   * that the patient should receive or consume.
   */
  public val foodPreferenceModifier: List<CodeableConcept> = listOf(),
  /**
   * This modifier is used to convey Order-specific modifier about the type of oral food or oral
   * fluids that should not be given. These can be derived from patient allergies, intolerances, or
   * preferences such as No Red Meat, No Soy or No Wheat or Gluten-Free. While it should not be
   * necessary to repeat allergy or intolerance information captured in the referenced
   * AllergyIntolerance resource in the excludeFoodModifier, this element may be used to convey
   * additional specificity related to foods that should be eliminated from the patient’s diet for
   * any reason. This modifier applies to the entire nutrition order inclusive of the oral diet,
   * nutritional supplements and enteral formula feedings.
   *
   * Information on a patient's food allergies, intolerances and preferences to inform healthcare
   * personnel about the type of foods that the patient shouldn't receive or consume.
   */
  public val excludeFoodModifier: List<CodeableConcept> = listOf(),
  /** Diet given orally in contrast to enteral (tube) feeding. */
  public val oralDiet: OralDiet? = null,
  /**
   * Oral nutritional products given in order to add further nutritional value to the patient's
   * diet.
   */
  public val supplement: List<Supplement> = listOf(),
  /**
   * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that
   * delivers nutrition distal to the oral cavity.
   */
  public val enteralFormula: EnteralFormula? = null,
  /**
   * Comments made about the {{title}} by the requester, performer, subject or other participants.
   *
   * This element SHALL NOT be used to supply free text instructions for the diet which are
   * represented in the `.oralDiet.instruction`, `supplement.instruction`, or
   * `enteralFormula.administrationInstruction` elements.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, intent, patient.toBuilder(), dateTime.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        instantiatesCanonical =
          this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
        instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
        instantiates = this@with.instantiates.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        orderer = this@with.orderer?.toBuilder()
        allergyIntolerance = this@with.allergyIntolerance.map { it.toBuilder() }.toMutableList()
        foodPreferenceModifier =
          this@with.foodPreferenceModifier.map { it.toBuilder() }.toMutableList()
        excludeFoodModifier = this@with.excludeFoodModifier.map { it.toBuilder() }.toMutableList()
        oralDiet = this@with.oralDiet?.toBuilder()
        supplement = this@with.supplement.map { it.toBuilder() }.toMutableList()
        enteralFormula = this@with.enteralFormula?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Diet given orally in contrast to enteral (tube) feeding. */
  @Serializable(with = NutritionOrderOralDietSerializer::class)
  public data class OralDiet(
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
    /** The kind of diet or dietary restriction such as fiber restricted diet or diabetic diet. */
    public val type: List<CodeableConcept> = listOf(),
    /**
     * The time period and frequency at which the diet should be given. The diet should be given for
     * the combination of all schedules if more than one schedule is present.
     */
    public val schedule: List<Timing> = listOf(),
    /**
     * Class that defines the quantity and type of nutrient modifications (for example carbohydrate,
     * fiber or sodium) required for the oral diet.
     */
    public val nutrient: List<Nutrient> = listOf(),
    /**
     * Class that describes any texture modifications required for the patient to safely consume
     * various types of solid foods.
     */
    public val texture: List<Texture> = listOf(),
    /**
     * The required consistency (e.g. honey-thick, nectar-thick, thin, thickened.) of liquids or
     * fluids served to the patient.
     */
    public val fluidConsistencyType: List<CodeableConcept> = listOf(),
    /**
     * Free text or additional instructions or information pertaining to the oral diet.
     *
     * Free text dosage instructions can be used for cases where the instructions are too complex to
     * code.
     */
    public val instruction: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          schedule = this@with.schedule.map { it.toBuilder() }.toMutableList()
          nutrient = this@with.nutrient.map { it.toBuilder() }.toMutableList()
          texture = this@with.texture.map { it.toBuilder() }.toMutableList()
          fluidConsistencyType =
            this@with.fluidConsistencyType.map { it.toBuilder() }.toMutableList()
          instruction = this@with.instruction?.toBuilder()
        }
      }

    /**
     * Class that defines the quantity and type of nutrient modifications (for example carbohydrate,
     * fiber or sodium) required for the oral diet.
     */
    @Serializable(with = NutritionOrderOralDietNutrientSerializer::class)
    public data class Nutrient(
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
      /** The nutrient that is being modified such as carbohydrate or sodium. */
      public val modifier: CodeableConcept? = null,
      /** The quantity of the specified nutrient to include in diet. */
      public val amount: Quantity? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            modifier = this@with.modifier?.toBuilder()
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

        /** The nutrient that is being modified such as carbohydrate or sodium. */
        public var modifier: CodeableConcept.Builder? = null

        /** The quantity of the specified nutrient to include in diet. */
        public var amount: Quantity.Builder? = null

        public fun build(): Nutrient =
          Nutrient(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            modifier = modifier?.build(),
            amount = amount?.build(),
          )
      }
    }

    /**
     * Class that describes any texture modifications required for the patient to safely consume
     * various types of solid foods.
     */
    @Serializable(with = NutritionOrderOralDietTextureSerializer::class)
    public data class Texture(
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
       * Any texture modifications (for solid foods) that should be made, e.g. easy to chew,
       * chopped, ground, and pureed.
       *
       * Coupled with the foodType (Meat).
       */
      public val modifier: CodeableConcept? = null,
      /**
       * The food type(s) (e.g. meats, all foods) that the texture modification applies to. This
       * could be all foods types.
       *
       * Coupled with the `texture.modifier`; could be (All Foods).
       */
      public val foodType: CodeableConcept? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            modifier = this@with.modifier?.toBuilder()
            foodType = this@with.foodType?.toBuilder()
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

        /**
         * Any texture modifications (for solid foods) that should be made, e.g. easy to chew,
         * chopped, ground, and pureed.
         *
         * Coupled with the foodType (Meat).
         */
        public var modifier: CodeableConcept.Builder? = null

        /**
         * The food type(s) (e.g. meats, all foods) that the texture modification applies to. This
         * could be all foods types.
         *
         * Coupled with the `texture.modifier`; could be (All Foods).
         */
        public var foodType: CodeableConcept.Builder? = null

        public fun build(): Texture =
          Texture(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            modifier = modifier?.build(),
            foodType = foodType?.build(),
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

      /** The kind of diet or dietary restriction such as fiber restricted diet or diabetic diet. */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The time period and frequency at which the diet should be given. The diet should be given
       * for the combination of all schedules if more than one schedule is present.
       */
      public var schedule: MutableList<Timing.Builder> = mutableListOf()

      /**
       * Class that defines the quantity and type of nutrient modifications (for example
       * carbohydrate, fiber or sodium) required for the oral diet.
       */
      public var nutrient: MutableList<Nutrient.Builder> = mutableListOf()

      /**
       * Class that describes any texture modifications required for the patient to safely consume
       * various types of solid foods.
       */
      public var texture: MutableList<Texture.Builder> = mutableListOf()

      /**
       * The required consistency (e.g. honey-thick, nectar-thick, thin, thickened.) of liquids or
       * fluids served to the patient.
       */
      public var fluidConsistencyType: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Free text or additional instructions or information pertaining to the oral diet.
       *
       * Free text dosage instructions can be used for cases where the instructions are too complex
       * to code.
       */
      public var instruction: String.Builder? = null

      public fun build(): OralDiet =
        OralDiet(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.map { it.build() },
          schedule = schedule.map { it.build() },
          nutrient = nutrient.map { it.build() },
          texture = texture.map { it.build() },
          fluidConsistencyType = fluidConsistencyType.map { it.build() },
          instruction = instruction?.build(),
        )
    }
  }

  /**
   * Oral nutritional products given in order to add further nutritional value to the patient's
   * diet.
   */
  @Serializable(with = NutritionOrderSupplementSerializer::class)
  public data class Supplement(
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
     * The kind of nutritional supplement product required such as a high protein or pediatric clear
     * liquid supplement.
     */
    public val type: CodeableConcept? = null,
    /** The product or brand name of the nutritional supplement such as "Acme Protein Shake". */
    public val productName: String? = null,
    /**
     * The time period and frequency at which the supplement(s) should be given. The supplement
     * should be given for the combination of all schedules if more than one schedule is present.
     */
    public val schedule: List<Timing> = listOf(),
    /** The amount of the nutritional supplement to be given. */
    public val quantity: Quantity? = null,
    /**
     * Free text or additional instructions or information pertaining to the oral supplement.
     *
     * Free text dosage instructions can be used for cases where the instructions are too complex to
     * code.
     */
    public val instruction: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          productName = this@with.productName?.toBuilder()
          schedule = this@with.schedule.map { it.toBuilder() }.toMutableList()
          quantity = this@with.quantity?.toBuilder()
          instruction = this@with.instruction?.toBuilder()
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
       * The kind of nutritional supplement product required such as a high protein or pediatric
       * clear liquid supplement.
       */
      public var type: CodeableConcept.Builder? = null

      /** The product or brand name of the nutritional supplement such as "Acme Protein Shake". */
      public var productName: String.Builder? = null

      /**
       * The time period and frequency at which the supplement(s) should be given. The supplement
       * should be given for the combination of all schedules if more than one schedule is present.
       */
      public var schedule: MutableList<Timing.Builder> = mutableListOf()

      /** The amount of the nutritional supplement to be given. */
      public var quantity: Quantity.Builder? = null

      /**
       * Free text or additional instructions or information pertaining to the oral supplement.
       *
       * Free text dosage instructions can be used for cases where the instructions are too complex
       * to code.
       */
      public var instruction: String.Builder? = null

      public fun build(): Supplement =
        Supplement(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          productName = productName?.build(),
          schedule = schedule.map { it.build() },
          quantity = quantity?.build(),
          instruction = instruction?.build(),
        )
    }
  }

  /**
   * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that
   * delivers nutrition distal to the oral cavity.
   */
  @Serializable(with = NutritionOrderEnteralFormulaSerializer::class)
  public data class EnteralFormula(
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
     * The type of enteral or infant formula such as an adult standard formula with fiber or a
     * soy-based infant formula.
     */
    public val baseFormulaType: CodeableConcept? = null,
    /**
     * The product or brand name of the enteral or infant formula product such as "ACME Adult
     * Standard Formula".
     */
    public val baseFormulaProductName: String? = null,
    /**
     * Indicates the type of modular component such as protein, carbohydrate, fat or fiber to be
     * provided in addition to or mixed with the base formula.
     */
    public val additiveType: CodeableConcept? = null,
    /** The product or brand name of the type of modular component to be added to the formula. */
    public val additiveProductName: String? = null,
    /**
     * The amount of energy (calories) that the formula should provide per specified volume,
     * typically per mL or fluid oz. For example, an infant may require a formula that provides 24
     * calories per fluid ounce or an adult may require an enteral formula that provides 1.5
     * calorie/mL.
     */
    public val caloricDensity: Quantity? = null,
    /**
     * The route or physiological path of administration into the patient's gastrointestinal tract
     * for purposes of providing the formula feeding, e.g. nasogastric tube.
     */
    public val routeofAdministration: CodeableConcept? = null,
    /**
     * Formula administration instructions as structured data. This repeating structure allows for
     * changing the administration rate or volume over time for both bolus and continuous feeding.
     * An example of this would be an instruction to increase the rate of continuous feeding every 2
     * hours.
     *
     * See implementation notes below for further discussion on how to order continuous vs bolus
     * enteral feeding using this resource.
     */
    public val administration: List<Administration> = listOf(),
    /**
     * The maximum total quantity of formula that may be administered to a subject over the period
     * of time, e.g. 1440 mL over 24 hours.
     */
    public val maxVolumeToDeliver: Quantity? = null,
    /**
     * Free text formula administration, feeding instructions or additional instructions or
     * information.
     *
     * Free text dosage instructions can be used for cases where the instructions are too complex to
     * code.
     */
    public val administrationInstruction: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          baseFormulaType = this@with.baseFormulaType?.toBuilder()
          baseFormulaProductName = this@with.baseFormulaProductName?.toBuilder()
          additiveType = this@with.additiveType?.toBuilder()
          additiveProductName = this@with.additiveProductName?.toBuilder()
          caloricDensity = this@with.caloricDensity?.toBuilder()
          routeofAdministration = this@with.routeofAdministration?.toBuilder()
          administration = this@with.administration.map { it.toBuilder() }.toMutableList()
          maxVolumeToDeliver = this@with.maxVolumeToDeliver?.toBuilder()
          administrationInstruction = this@with.administrationInstruction?.toBuilder()
        }
      }

    /**
     * Formula administration instructions as structured data. This repeating structure allows for
     * changing the administration rate or volume over time for both bolus and continuous feeding.
     * An example of this would be an instruction to increase the rate of continuous feeding every 2
     * hours.
     */
    @Serializable(with = NutritionOrderEnteralFormulaAdministrationSerializer::class)
    public data class Administration(
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
       * The time period and frequency at which the enteral formula should be delivered to the
       * patient.
       */
      public val schedule: Timing? = null,
      /**
       * The volume of formula to provide to the patient per the specified administration schedule.
       */
      public val quantity: Quantity? = null,
      /**
       * The rate of administration of formula via a feeding pump, e.g. 60 mL per hour, according to
       * the specified schedule.
       *
       * Ratio is used when the quantity value in the denominator is not "1", otherwise use
       * Quantity. For example, the Ratio datatype is used for "200 mL/4 hrs" versus the Quantity
       * datatype for "50 mL/hr".
       */
      public val rate: Rate? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            schedule = this@with.schedule?.toBuilder()
            quantity = this@with.quantity?.toBuilder()
            rate = this@with.rate
          }
        }

      public sealed interface Rate {
        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asRatio(): Ratio? = this as? Ratio

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r4b.Quantity) : Rate

        public data class Ratio(public val `value`: dev.ohs.fhir.model.r4b.Ratio) : Rate

        public companion object {
          internal fun from(
            quantityValue: dev.ohs.fhir.model.r4b.Quantity?,
            ratioValue: dev.ohs.fhir.model.r4b.Ratio?,
          ): Rate? {
            if (quantityValue != null) return Quantity(quantityValue)
            if (ratioValue != null) return Ratio(ratioValue)
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
         * The time period and frequency at which the enteral formula should be delivered to the
         * patient.
         */
        public var schedule: Timing.Builder? = null

        /**
         * The volume of formula to provide to the patient per the specified administration
         * schedule.
         */
        public var quantity: Quantity.Builder? = null

        /**
         * The rate of administration of formula via a feeding pump, e.g. 60 mL per hour, according
         * to the specified schedule.
         *
         * Ratio is used when the quantity value in the denominator is not "1", otherwise use
         * Quantity. For example, the Ratio datatype is used for "200 mL/4 hrs" versus the Quantity
         * datatype for "50 mL/hr".
         */
        public var rate: Rate? = null

        public fun build(): Administration =
          Administration(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            schedule = schedule?.build(),
            quantity = quantity?.build(),
            rate = rate,
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

      /**
       * The type of enteral or infant formula such as an adult standard formula with fiber or a
       * soy-based infant formula.
       */
      public var baseFormulaType: CodeableConcept.Builder? = null

      /**
       * The product or brand name of the enteral or infant formula product such as "ACME Adult
       * Standard Formula".
       */
      public var baseFormulaProductName: String.Builder? = null

      /**
       * Indicates the type of modular component such as protein, carbohydrate, fat or fiber to be
       * provided in addition to or mixed with the base formula.
       */
      public var additiveType: CodeableConcept.Builder? = null

      /** The product or brand name of the type of modular component to be added to the formula. */
      public var additiveProductName: String.Builder? = null

      /**
       * The amount of energy (calories) that the formula should provide per specified volume,
       * typically per mL or fluid oz. For example, an infant may require a formula that provides 24
       * calories per fluid ounce or an adult may require an enteral formula that provides 1.5
       * calorie/mL.
       */
      public var caloricDensity: Quantity.Builder? = null

      /**
       * The route or physiological path of administration into the patient's gastrointestinal tract
       * for purposes of providing the formula feeding, e.g. nasogastric tube.
       */
      public var routeofAdministration: CodeableConcept.Builder? = null

      /**
       * Formula administration instructions as structured data. This repeating structure allows for
       * changing the administration rate or volume over time for both bolus and continuous feeding.
       * An example of this would be an instruction to increase the rate of continuous feeding every
       * 2 hours.
       *
       * See implementation notes below for further discussion on how to order continuous vs bolus
       * enteral feeding using this resource.
       */
      public var administration: MutableList<Administration.Builder> = mutableListOf()

      /**
       * The maximum total quantity of formula that may be administered to a subject over the period
       * of time, e.g. 1440 mL over 24 hours.
       */
      public var maxVolumeToDeliver: Quantity.Builder? = null

      /**
       * Free text formula administration, feeding instructions or additional instructions or
       * information.
       *
       * Free text dosage instructions can be used for cases where the instructions are too complex
       * to code.
       */
      public var administrationInstruction: String.Builder? = null

      public fun build(): EnteralFormula =
        EnteralFormula(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          baseFormulaType = baseFormulaType?.build(),
          baseFormulaProductName = baseFormulaProductName?.build(),
          additiveType = additiveType?.build(),
          additiveProductName = additiveProductName?.build(),
          caloricDensity = caloricDensity?.build(),
          routeofAdministration = routeofAdministration?.build(),
          administration = administration.map { it.build() },
          maxVolumeToDeliver = maxVolumeToDeliver?.build(),
          administrationInstruction = administrationInstruction?.build(),
        )
    }
  }

  public class Builder(
    /**
     * The workflow status of the nutrition order/request.
     *
     * Typically the system placing the order sets the status to "requested". Thereafter, the order
     * is maintained by the receiver that updates the status as the request is handled. This element
     * is labeled as a modifier because the status contains codes that mark the resource as not
     * currently valid.
     */
    public var status: Enumeration<RequestStatus>,
    /**
     * Indicates the level of authority/intentionality associated with the NutrionOrder and where
     * the request fits into the workflow chain.
     *
     * When resources map to this element, they are free to define as many codes as necessary to
     * cover their space and will map to "proposal, plan or order". Can have multiple codes that map
     * to one of these. E.g. "original order", "encoded order", "reflex order" would all map to
     * "order". Expectation is that the set of codes is mutually exclusive or a strict
     * all-encompassing hierarchy.
     */
    public var intent: Enumeration<RequestIntent>,
    /**
     * The person (patient) who needs the nutrition order for an oral diet, nutritional supplement
     * and/or enteral or formula feeding.
     */
    public var patient: Reference.Builder,
    /** The date and time that this nutrition order was requested. */
    public var dateTime: DateTime.Builder,
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

    /**
     * Identifiers assigned to this order by the order sender or by the order receiver.
     *
     * The Identifier.type element can be to indicate filler vs. placer if needed. This is explained
     * in further detail [here](servicerequest.html#notes).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
     * adhered to in whole or in part by this NutritionOrder.
     *
     * Note: This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this NutritionOrder.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /**
     * The URL pointing to a protocol, guideline, orderset or other definition that is adhered to in
     * whole or in part by this NutritionOrder.
     */
    public var instantiates: MutableList<Uri.Builder> = mutableListOf()

    /**
     * An encounter that provides additional information about the healthcare context in which this
     * request is made.
     */
    public var encounter: Reference.Builder? = null

    /**
     * The practitioner that holds legal responsibility for ordering the diet, nutritional
     * supplement, or formula feedings.
     */
    public var orderer: Reference.Builder? = null

    /**
     * A link to a record of allergies or intolerances which should be included in the nutrition
     * order.
     *
     * Information on a patient's food allergies and intolerances to inform healthcare personnel
     * about the type of foods that the patient shouldn't receive or consume.
     */
    public var allergyIntolerance: MutableList<Reference.Builder> = mutableListOf()

    /**
     * This modifier is used to convey order-specific modifiers about the type of food that should
     * be given. These can be derived from patient allergies, intolerances, or preferences such as
     * Halal, Vegan or Kosher. This modifier applies to the entire nutrition order inclusive of the
     * oral diet, nutritional supplements and enteral formula feedings.
     *
     * Information on a patient's food preferences that inform healthcare personnel about the food
     * that the patient should receive or consume.
     */
    public var foodPreferenceModifier: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * This modifier is used to convey Order-specific modifier about the type of oral food or oral
     * fluids that should not be given. These can be derived from patient allergies, intolerances,
     * or preferences such as No Red Meat, No Soy or No Wheat or Gluten-Free. While it should not be
     * necessary to repeat allergy or intolerance information captured in the referenced
     * AllergyIntolerance resource in the excludeFoodModifier, this element may be used to convey
     * additional specificity related to foods that should be eliminated from the patient’s diet for
     * any reason. This modifier applies to the entire nutrition order inclusive of the oral diet,
     * nutritional supplements and enteral formula feedings.
     *
     * Information on a patient's food allergies, intolerances and preferences to inform healthcare
     * personnel about the type of foods that the patient shouldn't receive or consume.
     */
    public var excludeFoodModifier: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Diet given orally in contrast to enteral (tube) feeding. */
    public var oralDiet: OralDiet.Builder? = null

    /**
     * Oral nutritional products given in order to add further nutritional value to the patient's
     * diet.
     */
    public var supplement: MutableList<Supplement.Builder> = mutableListOf()

    /**
     * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that
     * delivers nutrition distal to the oral cavity.
     */
    public var enteralFormula: EnteralFormula.Builder? = null

    /**
     * Comments made about the {{title}} by the requester, performer, subject or other participants.
     *
     * This element SHALL NOT be used to supply free text instructions for the diet which are
     * represented in the `.oralDiet.instruction`, `supplement.instruction`, or
     * `enteralFormula.administrationInstruction` elements.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): NutritionOrder =
      NutritionOrder(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiatesCanonical = instantiatesCanonical.map { it.build() },
        instantiatesUri = instantiatesUri.map { it.build() },
        instantiates = instantiates.map { it.build() },
        status = status,
        intent = intent,
        patient = patient.build(),
        encounter = encounter?.build(),
        dateTime = dateTime.build(),
        orderer = orderer?.build(),
        allergyIntolerance = allergyIntolerance.map { it.build() },
        foodPreferenceModifier = foodPreferenceModifier.map { it.build() },
        excludeFoodModifier = excludeFoodModifier.map { it.build() },
        oralDiet = oralDiet?.build(),
        supplement = supplement.map { it.build() },
        enteralFormula = enteralFormula?.build(),
        note = note.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of a request. */
  public enum class RequestStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Draft("draft", "http://hl7.org/fhir/request-status", "Draft"),
    Active("active", "http://hl7.org/fhir/request-status", "Active"),
    On_Hold("on-hold", "http://hl7.org/fhir/request-status", "On Hold"),
    Revoked("revoked", "http://hl7.org/fhir/request-status", "Revoked"),
    Completed("completed", "http://hl7.org/fhir/request-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/request-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/request-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestStatus =
        when (code) {
          "draft" -> Draft
          "active" -> Active
          "on-hold" -> On_Hold
          "revoked" -> Revoked
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestStatus")
        }
    }
  }

  /** Codes indicating the degree of authority/intentionality associated with a request. */
  public enum class RequestIntent(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
    Directive("directive", "http://hl7.org/fhir/request-intent", "Directive"),
    Order("order", "http://hl7.org/fhir/request-intent", "Order"),
    Original_Order("original-order", "http://hl7.org/fhir/request-intent", "Original Order"),
    Reflex_Order("reflex-order", "http://hl7.org/fhir/request-intent", "Reflex Order"),
    Filler_Order("filler-order", "http://hl7.org/fhir/request-intent", "Filler Order"),
    Instance_Order("instance-order", "http://hl7.org/fhir/request-intent", "Instance Order"),
    Option("option", "http://hl7.org/fhir/request-intent", "Option");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestIntent =
        when (code) {
          "proposal" -> Proposal
          "plan" -> Plan
          "directive" -> Directive
          "order" -> Order
          "original-order" -> Original_Order
          "reflex-order" -> Reflex_Order
          "filler-order" -> Filler_Order
          "instance-order" -> Instance_Order
          "option" -> Option
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestIntent")
        }
    }
  }
}
