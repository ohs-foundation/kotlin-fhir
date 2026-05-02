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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.ObservationDefinitionQualifiedIntervalSerializer
import com.google.fhir.model.r4b.serializers.ObservationDefinitionQuantitativeDetailsSerializer
import com.google.fhir.model.r4b.serializers.ObservationDefinitionSerializer
import com.google.fhir.model.r4b.terminologies.AdministrativeGender
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Set of definitional characteristics for a kind of observation or measurement produced or consumed
 * by an orderable health care service.
 */
@Serializable(with = ObservationDefinitionSerializer::class)
@SerialName("ObservationDefinition")
public data class ObservationDefinition(
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
   * A code that classifies the general type of observation.
   *
   * This element allows various categorization schemes based on the owner’s definition of the
   * category and effectively multiple categories can be used for one instance of
   * ObservationDefinition. The level of granularity is defined by the category concepts in the
   * value set.
   */
  public val category: List<CodeableConcept> = listOf(),
  /** Describes what will be observed. Sometimes this is called the observation "name". */
  public val code: CodeableConcept,
  /** A unique identifier assigned to this ObservationDefinition artifact. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The data types allowed for the value element of the instance observations conforming to this
   * ObservationDefinition.
   */
  public val permittedDataType: List<Enumeration<ObservationDataType>> = listOf(),
  /**
   * Multiple results allowed for observations conforming to this ObservationDefinition.
   *
   * An example of observation allowing multiple results is "bacteria identified by culture".
   * Conversely, the measurement of a potassium level allows a single result.
   */
  public val multipleResultsAllowed: Boolean? = null,
  /**
   * The method or technique used to perform the observation.
   *
   * Only used if not implicit in observation code.
   */
  public val method: CodeableConcept? = null,
  /**
   * The preferred name to be used when reporting the results of observations conforming to this
   * ObservationDefinition.
   */
  public val preferredReportName: String? = null,
  /** Characteristics for quantitative results of this observation. */
  public val quantitativeDetails: QuantitativeDetails? = null,
  /**
   * Multiple ranges of results qualified by different contexts for ordinal or continuous
   * observations conforming to this ObservationDefinition.
   */
  public val qualifiedInterval: List<QualifiedInterval> = listOf(),
  /**
   * The set of valid coded results for the observations conforming to this ObservationDefinition.
   */
  public val validCodedValueSet: Reference? = null,
  /**
   * The set of normal coded results for the observations conforming to this ObservationDefinition.
   */
  public val normalCodedValueSet: Reference? = null,
  /**
   * The set of abnormal coded results for the observation conforming to this ObservationDefinition.
   */
  public val abnormalCodedValueSet: Reference? = null,
  /**
   * The set of critical coded results for the observation conforming to this ObservationDefinition.
   */
  public val criticalCodedValueSet: Reference? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(code.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        permittedDataType = this@with.permittedDataType.toMutableList()
        multipleResultsAllowed = this@with.multipleResultsAllowed?.toBuilder()
        method = this@with.method?.toBuilder()
        preferredReportName = this@with.preferredReportName?.toBuilder()
        quantitativeDetails = this@with.quantitativeDetails?.toBuilder()
        qualifiedInterval = this@with.qualifiedInterval.map { it.toBuilder() }.toMutableList()
        validCodedValueSet = this@with.validCodedValueSet?.toBuilder()
        normalCodedValueSet = this@with.normalCodedValueSet?.toBuilder()
        abnormalCodedValueSet = this@with.abnormalCodedValueSet?.toBuilder()
        criticalCodedValueSet = this@with.criticalCodedValueSet?.toBuilder()
      }
    }

  /** Characteristics for quantitative results of this observation. */
  @Serializable(with = ObservationDefinitionQuantitativeDetailsSerializer::class)
  public data class QuantitativeDetails(
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
     * Customary unit used to report quantitative results of observations conforming to this
     * ObservationDefinition.
     */
    public val customaryUnit: CodeableConcept? = null,
    /**
     * SI unit used to report quantitative results of observations conforming to this
     * ObservationDefinition.
     */
    public val unit: CodeableConcept? = null,
    /**
     * Factor for converting value expressed with SI unit to value expressed with customary unit.
     */
    public val conversionFactor: Decimal? = null,
    /**
     * Number of digits after decimal separator when the results of such observations are of type
     * Quantity.
     */
    public val decimalPrecision: Integer? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          customaryUnit = this@with.customaryUnit?.toBuilder()
          unit = this@with.unit?.toBuilder()
          conversionFactor = this@with.conversionFactor?.toBuilder()
          decimalPrecision = this@with.decimalPrecision?.toBuilder()
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
       * Customary unit used to report quantitative results of observations conforming to this
       * ObservationDefinition.
       */
      public var customaryUnit: CodeableConcept.Builder? = null

      /**
       * SI unit used to report quantitative results of observations conforming to this
       * ObservationDefinition.
       */
      public var unit: CodeableConcept.Builder? = null

      /**
       * Factor for converting value expressed with SI unit to value expressed with customary unit.
       */
      public var conversionFactor: Decimal.Builder? = null

      /**
       * Number of digits after decimal separator when the results of such observations are of type
       * Quantity.
       */
      public var decimalPrecision: Integer.Builder? = null

      public fun build(): QuantitativeDetails =
        QuantitativeDetails(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          customaryUnit = customaryUnit?.build(),
          unit = unit?.build(),
          conversionFactor = conversionFactor?.build(),
          decimalPrecision = decimalPrecision?.build(),
        )
    }
  }

  /**
   * Multiple ranges of results qualified by different contexts for ordinal or continuous
   * observations conforming to this ObservationDefinition.
   */
  @Serializable(with = ObservationDefinitionQualifiedIntervalSerializer::class)
  public data class QualifiedInterval(
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
     * The category of interval of values for continuous or ordinal observations conforming to this
     * ObservationDefinition.
     */
    public val category: Enumeration<ObservationRangeCategory>? = null,
    /** The low and high values determining the interval. There may be only one of the two. */
    public val range: Range? = null,
    /**
     * Codes to indicate the health context the range applies to. For example, the normal or
     * therapeutic range.
     */
    public val context: CodeableConcept? = null,
    /**
     * Codes to indicate the target population this reference range applies to.
     *
     * If this element is not present then the global population is assumed.
     */
    public val appliesTo: List<CodeableConcept> = listOf(),
    /** Sex of the population the range applies to. */
    public val gender: Enumeration<AdministrativeGender>? = null,
    /**
     * The age at which this reference range is applicable. This is a neonatal age (e.g. number of
     * weeks at term) if the meaning says so.
     *
     * Some analytes vary greatly over age.
     */
    public val age: Range? = null,
    /**
     * The gestational age to which this reference range is applicable, in the context of pregnancy.
     */
    public val gestationalAge: Range? = null,
    /** Text based condition for which the reference range is valid. */
    public val condition: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          category = this@with.category
          range = this@with.range?.toBuilder()
          context = this@with.context?.toBuilder()
          appliesTo = this@with.appliesTo.map { it.toBuilder() }.toMutableList()
          gender = this@with.gender
          age = this@with.age?.toBuilder()
          gestationalAge = this@with.gestationalAge?.toBuilder()
          condition = this@with.condition?.toBuilder()
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
       * The category of interval of values for continuous or ordinal observations conforming to
       * this ObservationDefinition.
       */
      public var category: Enumeration<ObservationRangeCategory>? = null

      /** The low and high values determining the interval. There may be only one of the two. */
      public var range: Range.Builder? = null

      /**
       * Codes to indicate the health context the range applies to. For example, the normal or
       * therapeutic range.
       */
      public var context: CodeableConcept.Builder? = null

      /**
       * Codes to indicate the target population this reference range applies to.
       *
       * If this element is not present then the global population is assumed.
       */
      public var appliesTo: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Sex of the population the range applies to. */
      public var gender: Enumeration<AdministrativeGender>? = null

      /**
       * The age at which this reference range is applicable. This is a neonatal age (e.g. number of
       * weeks at term) if the meaning says so.
       *
       * Some analytes vary greatly over age.
       */
      public var age: Range.Builder? = null

      /**
       * The gestational age to which this reference range is applicable, in the context of
       * pregnancy.
       */
      public var gestationalAge: Range.Builder? = null

      /** Text based condition for which the reference range is valid. */
      public var condition: String.Builder? = null

      public fun build(): QualifiedInterval =
        QualifiedInterval(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category,
          range = range?.build(),
          context = context?.build(),
          appliesTo = appliesTo.map { it.build() },
          gender = gender,
          age = age?.build(),
          gestationalAge = gestationalAge?.build(),
          condition = condition?.build(),
        )
    }
  }

  public class Builder(
    /** Describes what will be observed. Sometimes this is called the observation "name". */
    public var code: CodeableConcept.Builder
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
     * A code that classifies the general type of observation.
     *
     * This element allows various categorization schemes based on the owner’s definition of the
     * category and effectively multiple categories can be used for one instance of
     * ObservationDefinition. The level of granularity is defined by the category concepts in the
     * value set.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** A unique identifier assigned to this ObservationDefinition artifact. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The data types allowed for the value element of the instance observations conforming to this
     * ObservationDefinition.
     */
    public var permittedDataType: MutableList<Enumeration<ObservationDataType>> = mutableListOf()

    /**
     * Multiple results allowed for observations conforming to this ObservationDefinition.
     *
     * An example of observation allowing multiple results is "bacteria identified by culture".
     * Conversely, the measurement of a potassium level allows a single result.
     */
    public var multipleResultsAllowed: Boolean.Builder? = null

    /**
     * The method or technique used to perform the observation.
     *
     * Only used if not implicit in observation code.
     */
    public var method: CodeableConcept.Builder? = null

    /**
     * The preferred name to be used when reporting the results of observations conforming to this
     * ObservationDefinition.
     */
    public var preferredReportName: String.Builder? = null

    /** Characteristics for quantitative results of this observation. */
    public var quantitativeDetails: QuantitativeDetails.Builder? = null

    /**
     * Multiple ranges of results qualified by different contexts for ordinal or continuous
     * observations conforming to this ObservationDefinition.
     */
    public var qualifiedInterval: MutableList<QualifiedInterval.Builder> = mutableListOf()

    /**
     * The set of valid coded results for the observations conforming to this ObservationDefinition.
     */
    public var validCodedValueSet: Reference.Builder? = null

    /**
     * The set of normal coded results for the observations conforming to this
     * ObservationDefinition.
     */
    public var normalCodedValueSet: Reference.Builder? = null

    /**
     * The set of abnormal coded results for the observation conforming to this
     * ObservationDefinition.
     */
    public var abnormalCodedValueSet: Reference.Builder? = null

    /**
     * The set of critical coded results for the observation conforming to this
     * ObservationDefinition.
     */
    public var criticalCodedValueSet: Reference.Builder? = null

    override fun build(): ObservationDefinition =
      ObservationDefinition(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        category = category.map { it.build() },
        code = code.build(),
        identifier = identifier.map { it.build() },
        permittedDataType = permittedDataType,
        multipleResultsAllowed = multipleResultsAllowed?.build(),
        method = method?.build(),
        preferredReportName = preferredReportName?.build(),
        quantitativeDetails = quantitativeDetails?.build(),
        qualifiedInterval = qualifiedInterval.map { it.build() },
        validCodedValueSet = validCodedValueSet?.build(),
        normalCodedValueSet = normalCodedValueSet?.build(),
        abnormalCodedValueSet = abnormalCodedValueSet?.build(),
        criticalCodedValueSet = criticalCodedValueSet?.build(),
      )
  }

  /** Codes identifying the category of observation range. */
  public enum class ObservationRangeCategory(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Reference("reference", "http://hl7.org/fhir/observation-range-category", "reference range"),
    Critical("critical", "http://hl7.org/fhir/observation-range-category", "critical range"),
    Absolute("absolute", "http://hl7.org/fhir/observation-range-category", "absolute range");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ObservationRangeCategory =
        when (code) {
          "reference" -> Reference
          "critical" -> Critical
          "absolute" -> Absolute
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ObservationRangeCategory")
        }
    }
  }

  /** Permitted data type for observation value. */
  public enum class ObservationDataType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Quantity("Quantity", "http://hl7.org/fhir/permitted-data-type", "Quantity"),
    CodeableConcept(
      "CodeableConcept",
      "http://hl7.org/fhir/permitted-data-type",
      "CodeableConcept",
    ),
    String("string", "http://hl7.org/fhir/permitted-data-type", "string"),
    Boolean("boolean", "http://hl7.org/fhir/permitted-data-type", "boolean"),
    Integer("integer", "http://hl7.org/fhir/permitted-data-type", "integer"),
    Range("Range", "http://hl7.org/fhir/permitted-data-type", "Range"),
    Ratio("Ratio", "http://hl7.org/fhir/permitted-data-type", "Ratio"),
    SampledData("SampledData", "http://hl7.org/fhir/permitted-data-type", "SampledData"),
    Time("time", "http://hl7.org/fhir/permitted-data-type", "time"),
    DateTime("dateTime", "http://hl7.org/fhir/permitted-data-type", "dateTime"),
    Period("Period", "http://hl7.org/fhir/permitted-data-type", "Period");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ObservationDataType =
        when (code) {
          "Quantity" -> Quantity
          "CodeableConcept" -> CodeableConcept
          "string" -> String
          "boolean" -> Boolean
          "integer" -> Integer
          "Range" -> Range
          "Ratio" -> Ratio
          "SampledData" -> SampledData
          "time" -> Time
          "dateTime" -> DateTime
          "Period" -> Period
          else -> throw IllegalArgumentException("Unknown code $code for enum ObservationDataType")
        }
    }
  }
}
