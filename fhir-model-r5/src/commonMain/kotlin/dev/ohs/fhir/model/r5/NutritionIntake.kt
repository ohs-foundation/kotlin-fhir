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

import dev.ohs.fhir.model.r5.serializers.NutritionIntakeConsumedItemSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionIntakeIngredientLabelSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionIntakePerformerSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionIntakeSerializer
import dev.ohs.fhir.model.r5.terminologies.EventStatus
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of food or fluid that is being consumed by a patient. A NutritionIntake may indicate
 * that the patient may be consuming the food or fluid now or has consumed the food or fluid in the
 * past. The source of this information can be the patient, significant other (such as a family
 * member or spouse), or a clinician. A common scenario where this information is captured is during
 * the history taking process during a patient visit or stay or through an app that tracks food or
 * fluids consumed. The consumption information may come from sources such as the patient's memory,
 * from a nutrition label, or from a clinician documenting observed intake.
 */
@Serializable(with = NutritionIntakeSerializer::class)
@SerialName("NutritionIntake")
public data class NutritionIntake(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
   */
  override val id: String? = null,
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
   * Identifiers associated with this Nutrition Intake that are defined by business processes and/or
   * used to refer to it when a direct URL reference to the resource itself is not appropriate. They
   * are business identifiers assigned to this resource by the performer or other systems and remain
   * constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier.
   */
  public val identifier: List<Identifier> = listOf(),
  /** Instantiates FHIR protocol or definition. */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /** Instantiates external protocol or definition. */
  public val instantiatesUri: List<Uri> = listOf(),
  /** A plan, proposal or order that is fulfilled in whole or in part by this event. */
  public val basedOn: List<Reference> = listOf(),
  /** A larger event of which this particular event is a component or step. */
  public val partOf: List<Reference> = listOf(),
  /**
   * A code representing the patient or other source's judgment about the state of the intake that
   * this assertion is about. Generally, this will be active or completed.
   *
   * NutritionIntake is a statement at a point in time. The status is only representative at the
   * point when it was asserted. The value set for NutritionIntake.status contains codes that assert
   * the status of the consumption of the food or fluid by the patient (for example, stopped or on
   * hold) as well as codes that assert the status of the Nutrition Intake itself (for example,
   * entered in error).
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<EventStatus>,
  /**
   * Captures the reason for the current state of the NutritionIntake.
   *
   * This is generally only used for "exception" statuses such as "not-taken", "on-hold",
   * "cancelled" or "entered-in-error". The reason for performing the event at all is captured in
   * reasonCode, not here.
   */
  public val statusReason: List<CodeableConcept> = listOf(),
  /** Overall type of nutrition intake. */
  public val code: CodeableConcept? = null,
  /** The person, animal or group who is/was consuming the food or fluid. */
  public val subject: Reference,
  /** The encounter that establishes the context for this NutritionIntake. */
  public val encounter: Reference? = null,
  /**
   * The interval of time during which it is being asserted that the patient is/was consuming the
   * food or fluid.
   *
   * This attribute reflects the period over which the patient consumed the food fluid and is
   * expected to be populated on the majority of NutritionIntake. If the food or fluid is still
   * being taken and is expected to continue indefinitely at the time the usage is recorded, the
   * "end" date will be omitted. If the end date is known, then it is included as the "end date".
   * The date/time attribute supports a variety of dates - year, year/month and exact date. If
   * something more than this is required, this should be conveyed as text.
   */
  public val occurrence: Occurrence? = null,
  /** The date when the Nutrition Intake was asserted by the information source. */
  public val recorded: DateTime? = null,
  /**
   * The person or organization that provided the information about the consumption of this food or
   * fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.
   */
  public val reported: Reported? = null,
  /** What food or fluid product or item was consumed. */
  public val consumedItem: List<ConsumedItem>,
  /**
   * Total nutrient amounts for the whole meal, product, serving, etc.
   *
   * Individual item nutrients are not currently included in the resource and will likely end up as
   * a reference in nutritionProduct to represent the individual items.
   */
  public val ingredientLabel: List<IngredientLabel> = listOf(),
  /** Who performed the intake and how they were involved. */
  public val performer: List<Performer> = listOf(),
  /** Where the intake occurred. */
  public val location: Reference? = null,
  /**
   * Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information,
   * such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.
   *
   * Likely references would be to AllergyIntolerance, Observation or QuestionnaireAnswers.
   */
  public val derivedFrom: List<Reference> = listOf(),
  /** A reason, Condition or observation for why the food or fluid is /was consumed. */
  public val reason: List<CodeableReference> = listOf(),
  /**
   * Provides extra information about the Nutrition Intake that is not conveyed by the other
   * attributes.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        subject.toBuilder(),
        consumedItem.toBuilderList(),
      )
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.identifier = identifier.toBuilderList()
    builder.instantiatesCanonical = instantiatesCanonical.toBuilderList()
    builder.instantiatesUri = instantiatesUri.toBuilderList()
    builder.basedOn = basedOn.toBuilderList()
    builder.partOf = partOf.toBuilderList()
    builder.statusReason = statusReason.toBuilderList()
    builder.code = code?.toBuilder()
    builder.encounter = encounter?.toBuilder()
    builder.occurrence = occurrence
    builder.recorded = recorded?.toBuilder()
    builder.reported = reported
    builder.ingredientLabel = ingredientLabel.toBuilderList()
    builder.performer = performer.toBuilderList()
    builder.location = location?.toBuilder()
    builder.derivedFrom = derivedFrom.toBuilderList()
    builder.reason = reason.toBuilderList()
    builder.note = note.toBuilderList()
    return builder
  }

  /** What food or fluid product or item was consumed. */
  @Serializable(with = NutritionIntakeConsumedItemSerializer::class)
  public data class ConsumedItem(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** Indicates what a category of item that was consumed: e.g., food, fluid, enteral, etc. */
    public val type: CodeableConcept,
    /**
     * Identifies the food or fluid product that was consumed. This is potentially a link to a
     * resource representing the details of the food product (TBD) or a simple attribute carrying a
     * code that identifies the food from a known list of foods.
     *
     * If only a code is specified, then it needs to be a code for a specific product. If more
     * information is required, then the use of a new nutritionProduct resource is recommended.
     */
    public val nutritionProduct: CodeableReference,
    /** Scheduled frequency of consumption. */
    public val schedule: Timing? = null,
    /** Quantity of the specified food. */
    public val amount: Quantity? = null,
    /** Rate at which enteral feeding was administered. */
    public val rate: Quantity? = null,
    /**
     * Indicator when a patient is in a setting where it is helpful to know if food was not
     * consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If a
     * consumption is being recorded from an app, such as MyFitnessPal, this indicator will likely
     * not be used.
     */
    public val notConsumed: Boolean? = null,
    /** Document the reason the food or fluid was not consumed, such as refused, held, etc. */
    public val notConsumedReason: CodeableConcept? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(type.toBuilder(), nutritionProduct.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.schedule = schedule?.toBuilder()
      builder.amount = amount?.toBuilder()
      builder.rate = rate?.toBuilder()
      builder.notConsumed = notConsumed?.toBuilder()
      builder.notConsumedReason = notConsumedReason?.toBuilder()
      return builder
    }

    public class Builder(
      /** Indicates what a category of item that was consumed: e.g., food, fluid, enteral, etc. */
      public var type: CodeableConcept.Builder,
      /**
       * Identifies the food or fluid product that was consumed. This is potentially a link to a
       * resource representing the details of the food product (TBD) or a simple attribute carrying
       * a code that identifies the food from a known list of foods.
       *
       * If only a code is specified, then it needs to be a code for a specific product. If more
       * information is required, then the use of a new nutritionProduct resource is recommended.
       */
      public var nutritionProduct: CodeableReference.Builder,
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** Scheduled frequency of consumption. */
      public var schedule: Timing.Builder? = null

      /** Quantity of the specified food. */
      public var amount: Quantity.Builder? = null

      /** Rate at which enteral feeding was administered. */
      public var rate: Quantity.Builder? = null

      /**
       * Indicator when a patient is in a setting where it is helpful to know if food was not
       * consumed, such as it was refused, held (as in tube feedings), or otherwise not provided. If
       * a consumption is being recorded from an app, such as MyFitnessPal, this indicator will
       * likely not be used.
       */
      public var notConsumed: Boolean.Builder? = null

      /** Document the reason the food or fluid was not consumed, such as refused, held, etc. */
      public var notConsumedReason: CodeableConcept.Builder? = null

      override fun build(): ConsumedItem =
        ConsumedItem(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type.build(),
          nutritionProduct = nutritionProduct.build(),
          schedule = schedule?.build(),
          amount = amount?.build(),
          rate = rate?.build(),
          notConsumed = notConsumed?.build(),
          notConsumedReason = notConsumedReason?.build(),
        )
    }
  }

  /** Total nutrient amounts for the whole meal, product, serving, etc. */
  @Serializable(with = NutritionIntakeIngredientLabelSerializer::class)
  public data class IngredientLabel(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
     * Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a
     * vitamin and mineral.
     */
    public val nutrient: CodeableReference,
    /** Total amount of nutrient consumed. */
    public val amount: Quantity,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(nutrient.toBuilder(), amount.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public class Builder(
      /**
       * Total nutrient consumed. This could be a macronutrient (protein, fat, carbohydrate), or a
       * vitamin and mineral.
       */
      public var nutrient: CodeableReference.Builder,
      /** Total amount of nutrient consumed. */
      public var amount: Quantity.Builder,
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      override fun build(): IngredientLabel =
        IngredientLabel(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          nutrient = nutrient.build(),
          amount = amount.build(),
        )
    }
  }

  /** Who performed the intake and how they were involved. */
  @Serializable(with = NutritionIntakePerformerSerializer::class)
  public data class Performer(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** Type of performer. */
    public val function: CodeableConcept? = null,
    /** Who performed the intake. */
    public val actor: Reference,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(actor.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.function = function?.toBuilder()
      return builder
    }

    public class Builder(
      /** Who performed the intake. */
      public var actor: Reference.Builder
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** Type of performer. */
      public var function: CodeableConcept.Builder? = null

      override fun build(): Performer =
        Performer(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  public sealed interface Occurrence : FhirChoice {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public data class DateTime(override val `value`: dev.ohs.fhir.model.r5.DateTime) : Occurrence

    public data class Period(override val `value`: dev.ohs.fhir.model.r5.Period) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        periodValue: dev.ohs.fhir.model.r5.Period?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        return null
      }
    }
  }

  public sealed interface Reported : FhirChoice {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asReference(): Reference? = this as? Reference

    public data class Boolean(override val `value`: dev.ohs.fhir.model.r5.Boolean) : Reported

    public data class Reference(override val `value`: dev.ohs.fhir.model.r5.Reference) : Reported

    public companion object {
      internal fun from(
        booleanValue: dev.ohs.fhir.model.r5.Boolean?,
        referenceValue: dev.ohs.fhir.model.r5.Reference?,
      ): Reported? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A code representing the patient or other source's judgment about the state of the intake that
     * this assertion is about. Generally, this will be active or completed.
     *
     * NutritionIntake is a statement at a point in time. The status is only representative at the
     * point when it was asserted. The value set for NutritionIntake.status contains codes that
     * assert the status of the consumption of the food or fluid by the patient (for example,
     * stopped or on hold) as well as codes that assert the status of the Nutrition Intake itself
     * (for example, entered in error).
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<EventStatus>,
    /** The person, animal or group who is/was consuming the food or fluid. */
    public var subject: Reference.Builder,
    /** What food or fluid product or item was consumed. */
    public var consumedItem: MutableList<ConsumedItem.Builder>,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    override var id: String? = null

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
     * Identifiers associated with this Nutrition Intake that are defined by business processes
     * and/or used to refer to it when a direct URL reference to the resource itself is not
     * appropriate. They are business identifiers assigned to this resource by the performer or
     * other systems and remain constant as the resource is updated and propagates from server to
     * server.
     *
     * This is a business identifier, not a resource identifier.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Instantiates FHIR protocol or definition. */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /** Instantiates external protocol or definition. */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** A plan, proposal or order that is fulfilled in whole or in part by this event. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** A larger event of which this particular event is a component or step. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Captures the reason for the current state of the NutritionIntake.
     *
     * This is generally only used for "exception" statuses such as "not-taken", "on-hold",
     * "cancelled" or "entered-in-error". The reason for performing the event at all is captured in
     * reasonCode, not here.
     */
    public var statusReason: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Overall type of nutrition intake. */
    public var code: CodeableConcept.Builder? = null

    /** The encounter that establishes the context for this NutritionIntake. */
    public var encounter: Reference.Builder? = null

    /**
     * The interval of time during which it is being asserted that the patient is/was consuming the
     * food or fluid.
     *
     * This attribute reflects the period over which the patient consumed the food fluid and is
     * expected to be populated on the majority of NutritionIntake. If the food or fluid is still
     * being taken and is expected to continue indefinitely at the time the usage is recorded, the
     * "end" date will be omitted. If the end date is known, then it is included as the "end date".
     * The date/time attribute supports a variety of dates - year, year/month and exact date. If
     * something more than this is required, this should be conveyed as text.
     */
    public var occurrence: Occurrence? = null

    /** The date when the Nutrition Intake was asserted by the information source. */
    public var recorded: DateTime.Builder? = null

    /**
     * The person or organization that provided the information about the consumption of this food
     * or fluid. Note: Use derivedFrom when a NutritionIntake is derived from other resources.
     */
    public var reported: Reported? = null

    /**
     * Total nutrient amounts for the whole meal, product, serving, etc.
     *
     * Individual item nutrients are not currently included in the resource and will likely end up
     * as a reference in nutritionProduct to represent the individual items.
     */
    public var ingredientLabel: MutableList<IngredientLabel.Builder> = mutableListOf()

    /** Who performed the intake and how they were involved. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /** Where the intake occurred. */
    public var location: Reference.Builder? = null

    /**
     * Allows linking the NutritionIntake to the underlying NutritionOrder, or to other information,
     * such as AllergyIntolerance, that supports or is used to derive the NutritionIntake.
     *
     * Likely references would be to AllergyIntolerance, Observation or QuestionnaireAnswers.
     */
    public var derivedFrom: MutableList<Reference.Builder> = mutableListOf()

    /** A reason, Condition or observation for why the food or fluid is /was consumed. */
    public var reason: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Provides extra information about the Nutrition Intake that is not conveyed by the other
     * attributes.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): NutritionIntake =
      NutritionIntake(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        instantiatesCanonical = instantiatesCanonical.buildList(),
        instantiatesUri = instantiatesUri.buildList(),
        basedOn = basedOn.buildList(),
        partOf = partOf.buildList(),
        status = status,
        statusReason = statusReason.buildList(),
        code = code?.build(),
        subject = subject.build(),
        encounter = encounter?.build(),
        occurrence = occurrence,
        recorded = recorded?.build(),
        reported = reported,
        consumedItem = consumedItem.buildList(),
        ingredientLabel = ingredientLabel.buildList(),
        performer = performer.buildList(),
        location = location?.build(),
        derivedFrom = derivedFrom.buildList(),
        reason = reason.buildList(),
        note = note.buildList(),
      )
  }
}
