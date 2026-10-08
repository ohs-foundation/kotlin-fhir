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

import dev.ohs.fhir.model.r5.serializers.NutritionProductCharacteristicSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionProductIngredientSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionProductInstanceSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionProductNutrientSerializer
import dev.ohs.fhir.model.r5.serializers.NutritionProductSerializer
import dev.ohs.fhir.model.r5.terminologies.NutritionProductStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A food or supplement that is consumed by patients. */
@Serializable(with = NutritionProductSerializer::class)
@SerialName("NutritionProduct")
public data class NutritionProduct(
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
   * The code assigned to the product, for example a USDA NDB number, a USDA FDC ID number, or a
   * Langual code.
   */
  public val code: CodeableConcept? = null,
  /**
   * The current state of the product.
   *
   * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
   * when the authoring system is not sure what the current status is.
   */
  public val status: Enumeration<NutritionProductStatus>,
  /**
   * Nutrition products can have different classifications - according to its nutritional
   * properties, preparation methods, etc.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * The organisation (manufacturer, representative or legal authorization holder) that is
   * responsible for the device.
   */
  public val manufacturer: List<Reference> = listOf(),
  /**
   * The product's nutritional information expressed by the nutrients.
   *
   * Note: This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val nutrient: List<Nutrient> = listOf(),
  /** Ingredients contained in this product. */
  public val ingredient: List<Ingredient> = listOf(),
  /** Allergens that are known or suspected to be a part of this nutrition product. */
  public val knownAllergen: List<CodeableReference> = listOf(),
  /** Specifies descriptive properties of the nutrition product. */
  public val characteristic: List<Characteristic> = listOf(),
  /**
   * Conveys instance-level information about this product item. One or several physical, countable
   * instances or occurrences of the product.
   */
  public val instance: List<Instance> = listOf(),
  /** Comments made about the product. */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder(status)
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.mapToMutableList { it.toBuilder() }
    builder.extension = extension.mapToMutableList { it.toBuilder() }
    builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
    builder.code = code?.toBuilder()
    builder.category = category.mapToMutableList { it.toBuilder() }
    builder.manufacturer = manufacturer.mapToMutableList { it.toBuilder() }
    builder.nutrient = nutrient.mapToMutableList { it.toBuilder() }
    builder.ingredient = ingredient.mapToMutableList { it.toBuilder() }
    builder.knownAllergen = knownAllergen.mapToMutableList { it.toBuilder() }
    builder.characteristic = characteristic.mapToMutableList { it.toBuilder() }
    builder.instance = instance.mapToMutableList { it.toBuilder() }
    builder.note = note.mapToMutableList { it.toBuilder() }
    return builder
  }

  /** The product's nutritional information expressed by the nutrients. */
  @Serializable(with = NutritionProductNutrientSerializer::class)
  public data class Nutrient(
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
    /** The (relevant) nutrients in the product. */
    public val item: CodeableReference? = null,
    /**
     * The amount of nutrient expressed in one or more units: X per pack / per serving / per dose.
     */
    public val amount: List<Ratio> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.item = item?.toBuilder()
      builder.amount = amount.mapToMutableList { it.toBuilder() }
      return builder
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

      /** The (relevant) nutrients in the product. */
      public var item: CodeableReference.Builder? = null

      /**
       * The amount of nutrient expressed in one or more units: X per pack / per serving / per dose.
       */
      public var amount: MutableList<Ratio.Builder> = mutableListOf()

      public fun build(): Nutrient =
        Nutrient(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          item = item?.build(),
          amount = amount.mapToList { it.build() },
        )
    }
  }

  /** Ingredients contained in this product. */
  @Serializable(with = NutritionProductIngredientSerializer::class)
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
    /** The ingredient contained in the product. */
    public val item: CodeableReference,
    /** The amount of ingredient that is in the product. */
    public val amount: List<Ratio> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder(item.toBuilder())
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.amount = amount.mapToMutableList { it.toBuilder() }
      return builder
    }

    public class Builder(
      /** The ingredient contained in the product. */
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

      /** The amount of ingredient that is in the product. */
      public var amount: MutableList<Ratio.Builder> = mutableListOf()

      public fun build(): Ingredient =
        Ingredient(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          item = item.build(),
          amount = amount.mapToList { it.build() },
        )
    }
  }

  /** Specifies descriptive properties of the nutrition product. */
  @Serializable(with = NutritionProductCharacteristicSerializer::class)
  public data class Characteristic(
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
     * A code specifying which characteristic of the product is being described (for example,
     * colour, shape).
     */
    public val type: CodeableConcept,
    /**
     * The actual characteristic value corresponding to the type.
     *
     * The description should be provided as a CodeableConcept, SimpleQuantity or an image. The
     * description can be a string only when these others are not available.
     */
    public val `value`: Value,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder =
        Builder(
          type.toBuilder(),
          `value`,
        )
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      return builder
    }

    public sealed interface Value : FhirChoice {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asString(): String? = this as? String

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asBoolean(): Boolean? = this as? Boolean

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Value

      public data class String(override val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Quantity(override val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Base64Binary(override val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
        Value

      public data class Attachment(override val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public data class Boolean(override val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
        ): Value? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (stringValue != null) return String(stringValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (booleanValue != null) return Boolean(booleanValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * A code specifying which characteristic of the product is being described (for example,
       * colour, shape).
       */
      public var type: CodeableConcept.Builder,
      /**
       * The actual characteristic value corresponding to the type.
       *
       * The description should be provided as a CodeableConcept, SimpleQuantity or an image. The
       * description can be a string only when these others are not available.
       */
      public var `value`: Value,
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

      public fun build(): Characteristic =
        Characteristic(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  /**
   * Conveys instance-level information about this product item. One or several physical, countable
   * instances or occurrences of the product.
   */
  @Serializable(with = NutritionProductInstanceSerializer::class)
  public data class Instance(
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
     * The amount of items or instances that the resource considers, for instance when referring to
     * 2 identical units together.
     */
    public val quantity: Quantity? = null,
    /**
     * The identifier for the physical instance, typically a serial number or manufacturer number.
     */
    public val identifier: List<Identifier> = listOf(),
    /** The name for the specific product. */
    public val name: String? = null,
    /** The identification of the batch or lot of the product. */
    public val lotNumber: String? = null,
    /**
     * The time after which the product is no longer expected to be in proper condition, or its use
     * is not advised or not allowed.
     */
    public val expiry: DateTime? = null,
    /**
     * The time after which the product is no longer expected to be in proper condition, or its use
     * is not advised or not allowed.
     */
    public val useBy: DateTime? = null,
    /**
     * An identifier that supports traceability to the event during which material in this product
     * from one or more biological entities was obtained or pooled.
     *
     * Necessary to support mandatory requirements for traceability from donor/source to recipient
     * and vice versa, while also satisfying donor anonymity requirements. The element is defined
     * consistently across BiologicallyDerivedProduct, NutritionProduct, and Device. The identifier
     * references an event that links to a single biological entity such as a blood donor, or to
     * multiple biological entities (e.g. when the product is an embryo or a pooled platelet
     * product). A single biologicalSourceEvent identifier may appear on multiple products of many
     * types derived from a single donation event or source extraction. As an example, a single
     * donation event may provide 2 kidneys and a liver for organ transplantation, 2 corneas for eye
     * surgery, heart valves and arterial tissue for cardiovascular surgery, multiple skin grafts,
     * tendons, multiple shaped bone grafts and a large number of bone putty/paste products; and
     * each of them may be assigned to the same biological source event identifier.
     */
    public val biologicalSourceEvent: Identifier? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.quantity = quantity?.toBuilder()
      builder.identifier = identifier.mapToMutableList { it.toBuilder() }
      builder.name = name?.toBuilder()
      builder.lotNumber = lotNumber?.toBuilder()
      builder.expiry = expiry?.toBuilder()
      builder.useBy = useBy?.toBuilder()
      builder.biologicalSourceEvent = biologicalSourceEvent?.toBuilder()
      return builder
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
       * The amount of items or instances that the resource considers, for instance when referring
       * to 2 identical units together.
       */
      public var quantity: Quantity.Builder? = null

      /**
       * The identifier for the physical instance, typically a serial number or manufacturer number.
       */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** The name for the specific product. */
      public var name: String.Builder? = null

      /** The identification of the batch or lot of the product. */
      public var lotNumber: String.Builder? = null

      /**
       * The time after which the product is no longer expected to be in proper condition, or its
       * use is not advised or not allowed.
       */
      public var expiry: DateTime.Builder? = null

      /**
       * The time after which the product is no longer expected to be in proper condition, or its
       * use is not advised or not allowed.
       */
      public var useBy: DateTime.Builder? = null

      /**
       * An identifier that supports traceability to the event during which material in this product
       * from one or more biological entities was obtained or pooled.
       *
       * Necessary to support mandatory requirements for traceability from donor/source to recipient
       * and vice versa, while also satisfying donor anonymity requirements. The element is defined
       * consistently across BiologicallyDerivedProduct, NutritionProduct, and Device. The
       * identifier references an event that links to a single biological entity such as a blood
       * donor, or to multiple biological entities (e.g. when the product is an embryo or a pooled
       * platelet product). A single biologicalSourceEvent identifier may appear on multiple
       * products of many types derived from a single donation event or source extraction. As an
       * example, a single donation event may provide 2 kidneys and a liver for organ
       * transplantation, 2 corneas for eye surgery, heart valves and arterial tissue for
       * cardiovascular surgery, multiple skin grafts, tendons, multiple shaped bone grafts and a
       * large number of bone putty/paste products; and each of them may be assigned to the same
       * biological source event identifier.
       */
      public var biologicalSourceEvent: Identifier.Builder? = null

      public fun build(): Instance =
        Instance(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          quantity = quantity?.build(),
          identifier = identifier.mapToList { it.build() },
          name = name?.build(),
          lotNumber = lotNumber?.build(),
          expiry = expiry?.build(),
          useBy = useBy?.build(),
          biologicalSourceEvent = biologicalSourceEvent?.build(),
        )
    }
  }

  public class Builder(
    /**
     * The current state of the product.
     *
     * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
     * when the authoring system is not sure what the current status is.
     */
    public var status: Enumeration<NutritionProductStatus>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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
     * The code assigned to the product, for example a USDA NDB number, a USDA FDC ID number, or a
     * Langual code.
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * Nutrition products can have different classifications - according to its nutritional
     * properties, preparation methods, etc.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The organisation (manufacturer, representative or legal authorization holder) that is
     * responsible for the device.
     */
    public var manufacturer: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The product's nutritional information expressed by the nutrients.
     *
     * Note: This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var nutrient: MutableList<Nutrient.Builder> = mutableListOf()

    /** Ingredients contained in this product. */
    public var ingredient: MutableList<Ingredient.Builder> = mutableListOf()

    /** Allergens that are known or suspected to be a part of this nutrition product. */
    public var knownAllergen: MutableList<CodeableReference.Builder> = mutableListOf()

    /** Specifies descriptive properties of the nutrition product. */
    public var characteristic: MutableList<Characteristic.Builder> = mutableListOf()

    /**
     * Conveys instance-level information about this product item. One or several physical,
     * countable instances or occurrences of the product.
     */
    public var instance: MutableList<Instance.Builder> = mutableListOf()

    /** Comments made about the product. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): NutritionProduct =
      NutritionProduct(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.mapToList { it.build() },
        extension = extension.mapToList { it.build() },
        modifierExtension = modifierExtension.mapToList { it.build() },
        code = code?.build(),
        status = status,
        category = category.mapToList { it.build() },
        manufacturer = manufacturer.mapToList { it.build() },
        nutrient = nutrient.mapToList { it.build() },
        ingredient = ingredient.mapToList { it.build() },
        knownAllergen = knownAllergen.mapToList { it.build() },
        characteristic = characteristic.mapToList { it.build() },
        instance = instance.mapToList { it.build() },
        note = note.mapToList { it.build() },
      )
  }
}
