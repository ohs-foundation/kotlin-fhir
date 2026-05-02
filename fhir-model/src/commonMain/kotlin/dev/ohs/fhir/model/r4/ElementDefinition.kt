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

import com.google.fhir.model.r4.serializers.ElementDefinitionBaseSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionBindingSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionConstraintSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionDefaultValueSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionExampleSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionExampleValueSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionFixedSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionMappingSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionMaxValueSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionMinValueSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionPatternSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionSlicingDiscriminatorSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionSlicingSerializer
import com.google.fhir.model.r4.serializers.ElementDefinitionTypeSerializer
import com.google.fhir.model.r4.terminologies.BindingStrength
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for ElementDefinition Type: Captures constraints on each element within
 * the resource, profile, or extension.
 */
@Serializable(with = ElementDefinitionSerializer::class)
public data class ElementDefinition(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
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
   * element and that modifies the understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met as part of the definition
   * of the extension. Applications processing a resource are required to check for modifier
   * extensions.
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
   * The path identifies the element and is expressed as a "."-separated list of ancestor elements,
   * beginning with the name of the resource or extension.
   */
  public val path: String,
  /**
   * Codes that define how this element is represented in instances, when the deviation varies from
   * the normal case.
   *
   * In resources, this is rarely used except for special cases where the representation deviates
   * from the normal, and can only be done in the base standard (and profiles must reproduce what
   * the base standard does). This element is used quite commonly in Logical models when the logical
   * models represent a specific serialization format (e.g. CDA, v2 etc.).
   */
  public val representation: List<Enumeration<PropertyRepresentation>> = listOf(),
  /**
   * The name of this element definition slice, when slicing is working. The name must be a token
   * with no dots or spaces. This is a unique name referring to a specific set of constraints
   * applied to this element, used to provide a name to different slices of the same element.
   *
   * The name SHALL be unique within the structure within the context of the constrained resource
   * element. (Though to avoid confusion, uniqueness across all elements is recommended.).
   */
  public val sliceName: String? = null,
  /**
   * If true, indicates that this slice definition is constraining a slice definition with the same
   * name in an inherited profile. If false, the slice is not overriding any slice in an inherited
   * profile. If missing, the slice might or might not be overriding a slice in an inherited
   * profile, depending on the sliceName.
   *
   * If set to true, an ancestor profile SHALL have a slicing definition with this name. If set to
   * false, no ancestor profile is permitted to have a slicing definition with this name.
   */
  public val sliceIsConstraining: Boolean? = null,
  /**
   * A single preferred label which is the text to display beside the element indicating its meaning
   * or to use to prompt for the element in a user display or form.
   *
   * See also the extension
   * (http://hl7.org/fhir/StructureDefinition/elementdefinition-question)[extension-elementdefinition-question.html].
   */
  public val label: String? = null,
  /**
   * A code that has the same meaning as the element in a particular terminology.
   *
   * The concept SHALL be properly aligned with the data element definition and other constraints,
   * as defined in the code system, including relationships, of any code listed here. Where multiple
   * codes exist in a terminology that could correspond to the data element, the most granular
   * code(s) should be selected, so long as they are not more restrictive than the data element
   * itself. The mappings may be used to provide more or less granular or structured equivalences in
   * the code system.
   */
  public val code: List<Coding> = listOf(),
  /**
   * Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure
   * definition, there are multiple different constraints on a single element in the base resource).
   * Slicing can be used in any resource that has cardinality ..* on the base resource, or any
   * resource with a choice of types. The set of slices is any elements that come after this in the
   * element sequence that have the same path, until a shorter path occurs (the shorter path
   * terminates the set).
   *
   * The first element in the sequence, the one that carries the slicing, is the definition that
   * applies to all the slices. This is based on the unconstrained element, but can apply any
   * constraints as appropriate. This may include the common constraints on the children of the
   * element.
   */
  public val slicing: Slicing? = null,
  /**
   * A concise description of what this element means (e.g. for use in autogenerated summaries).
   *
   * It is easy for a different short definition to change the meaning of an element and this can
   * have nasty downstream consequences. Please be careful when providing short definitions in a
   * profile.
   */
  public val short: String? = null,
  /**
   * Provides a complete explanation of the meaning of the data element for human readability. For
   * the case of elements derived from existing elements (e.g. constraints), the definition SHALL be
   * consistent with the base definition, but convey the meaning of the element in the particular
   * context of use of the resource. (Note: The text you are reading is specified in
   * ElementDefinition.definition).
   *
   * It is easy for a different definition to change the meaning of an element and this can have
   * nasty downstream consequences. Please be careful when providing definitions in a profile.
   */
  public val definition: Markdown? = null,
  /**
   * Explanatory notes and implementation guidance about the data element, including notes about how
   * to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is
   * specified in ElementDefinition.comment).
   *
   * If it is possible to capture usage rules using constraints, that mechanism should be used in
   * preference to this element.
   */
  public val comment: Markdown? = null,
  /**
   * This element is for traceability of why the element was created and why the constraints exist
   * as they do. This may be used to point to source materials or specifications that drove the
   * structure of this element.
   *
   * This element does not describe the usage of the element (that's done in comments), rather it's
   * for traceability of *why* the element is either needed or why the constraints exist as they do.
   * This may be used to point to source materials or specifications that drove the structure of
   * this data element.
   */
  public val requirements: Markdown? = null,
  /** Identifies additional names by which this element might also be known. */
  public val alias: List<String> = listOf(),
  /** The minimum number of times this element SHALL appear in the instance. */
  public val min: UnsignedInt? = null,
  /** The maximum number of times this element is permitted to appear in the instance. */
  public val max: String? = null,
  /**
   * Information about the base definition of the element, provided to make it unnecessary for tools
   * to trace the deviation of the element through the derived and related profiles. When the
   * element definition is not the original definition of an element - i.g. either in a constraint
   * on another type, or for elements from a super type in a snap shot - then the information in
   * provided in the element definition may be different to the base definition. On the original
   * definition of the element, it will be same.
   *
   * The base information does not carry any information that could not be determined from the path
   * and related profiles, but making this determination requires both that the related profiles are
   * available, and that the algorithm to determine them be available. For tooling simplicity, the
   * base information must always be populated in element definitions in snap shots, even if it is
   * the same.
   */
  public val base: Base? = null,
  /**
   * Identifies an element defined elsewhere in the definition whose content rules should be applied
   * to the current element. ContentReferences bring across all the rules that are in the
   * ElementDefinition for the element, including definitions, cardinality constraints, bindings,
   * invariants etc.
   *
   * ContentReferences can only be defined in specializations, not constrained types, and they
   * cannot be changed and always reference the non-constrained definition.
   */
  public val contentReference: Uri? = null,
  /**
   * The data type or resource that the value of this element is permitted to be.
   *
   * The Type of the element can be left blank in a differential constraint, in which case the type
   * is inherited from the resource. Abstract types are not permitted to appear as a type when
   * multiple types are listed. (I.e. Abstract types cannot be part of a choice).
   */
  public val type: List<Type> = listOf(),
  /**
   * The value that should be used if there is no value stated in the instance (e.g. 'if not
   * otherwise specified, the abstract is false').
   *
   * Specifying a default value means that the property can never been unknown - it must always have
   * a value. Further, the default value can never be changed, or changed in constraints on content
   * models. Defining default values creates many difficulties in implementation (e.g. when is a
   * value missing?). For these reasons, default values are (and should be) used extremely
   * sparingly.
   *
   * No default values are ever defined in the FHIR specification, nor can they be defined in
   * constraints ("profiles") on data types or resources. This element only exists so that default
   * values may be defined in logical models.
   */
  public val defaultValue: DefaultValue? = null,
  /**
   * The Implicit meaning that is to be understood when this element is missing (e.g. 'when this
   * element is missing, the period is ongoing').
   *
   * Implicit meanings for missing values can only be specified on a resource, data type, or
   * extension definition, and never in a profile that applies to one of these. An implicit meaning
   * for a missing value can never be changed, and specifying one has the consequence that
   * constraining its use in profiles eliminates use cases as possibilities, not merely moving them
   * out of scope.
   */
  public val meaningWhenMissing: Markdown? = null,
  /**
   * If present, indicates that the order of the repeating element has meaning and describes what
   * that meaning is. If absent, it means that the order of the element has no meaning.
   *
   * This element can only be asserted on repeating elements and can only be introduced when
   * defining resources or data types. It can be further refined profiled elements but if absent in
   * the base type, a profile cannot assert meaning.
   */
  public val orderMeaning: String? = null,
  /**
   * Specifies a value that SHALL be exactly the value for this element in the instance. For
   * purposes of comparison, non-significant whitespace is ignored, and all values must be an exact
   * match (case and accent sensitive). Missing elements/attributes must also be missing.
   *
   * This is not recommended for Coding and CodeableConcept since these often have highly contextual
   * properties such as version or display.
   */
  public val fixed: Fixed? = null,
  /**
   * Specifies a value that the value in the instance SHALL follow - that is, any value in the
   * pattern must be found in the instance. Other additional values may be found too. This is
   * effectively constraint by example.
   *
   * When pattern[x] is used to constrain a primitive, it means that the value provided in the
   * pattern[x] must match the instance value exactly.
   *
   * When pattern[x] is used to constrain an array, it means that each element provided in the
   * pattern[x] array must (recursively) match at least one element from the instance array.
   *
   * When pattern[x] is used to constrain a complex object, it means that each property in the
   * pattern must be present in the complex object, and its value must recursively match -- i.e.,
   * 1. If primitive: it must match exactly the pattern value
   * 2. If a complex object: it must match (recursively) the pattern value
   * 3. If an array: it must match (recursively) the pattern value.
   *
   * Mostly used for fixing values of CodeableConcept. In general, pattern[x] is not intended for
   * use with primitive types, where is has the same meaning as fixed[x].
   */
  public val pattern: Pattern? = null,
  /**
   * A sample value for this element demonstrating the type of information that would typically be
   * found in the element.
   *
   * Examples will most commonly be present for data where it's not implicitly obvious from either
   * the data type or value set what the values might be. (I.e. Example values for dates or
   * quantities would generally be unnecessary.) If the example value is fully populated, the
   * publication tool can generate an instance automatically.
   */
  public val example: List<Example> = listOf(),
  /**
   * The minimum allowed value for the element. The value is inclusive. This is allowed for the
   * types date, dateTime, instant, time, decimal, integer, and Quantity.
   *
   * Except for date/date/instant, the type of the minValue[x] SHALL be the same as the specified
   * type of the element. For the date/dateTime/instant values, the type of minValue[x] SHALL be
   * either the same, or a [Duration](datatypes.html#Duration) which specifies a relative time limit
   * to the current time. The duration value is positive, and is subtracted from the current clock
   * to determine the minimum allowable value. A minimum value for a Quantity is interpreted as an
   * canonical minimum - e.g. you cannot provide 100mg if the minimum value is 10g.
   */
  public val minValue: MinValue? = null,
  /**
   * The maximum allowed value for the element. The value is inclusive. This is allowed for the
   * types date, dateTime, instant, time, decimal, integer, and Quantity.
   *
   * Except for date/date/instant, the type of the maxValue[x] SHALL be the same as the specified
   * type of the element. For the date/dateTime/instant values, the type of maxValue[x] SHALL be
   * either the same, or a [Duration](datatypes.html#Duration) which specifies a relative time limit
   * to the current time. The duration value is positive, and is added to the current clock to
   * determine the maximum allowable value. A maximum value for a Quantity is interpreted as an
   * canonical maximum - e.g. you cannot provide 10g if the maximum value is 50mg.
   */
  public val maxValue: MaxValue? = null,
  /**
   * Indicates the maximum length in characters that is permitted to be present in conformant
   * instances and which is expected to be supported by conformant consumers that support the
   * element.
   *
   * Receivers are not required to reject instances that exceed the maximum length. The full length
   * could be stored. In some cases, data might be truncated, though truncation should be undertaken
   * with care and an understanding of the consequences of doing so. If not specified, there is no
   * conformance expectation for length support.
   */
  public val maxLength: Integer? = null,
  /**
   * A reference to an invariant that may make additional statements about the cardinality or value
   * in the instance.
   */
  public val condition: List<Id> = listOf(),
  /**
   * Formal constraints such as co-occurrence and other constraints that can be computationally
   * evaluated within the context of the instance.
   *
   * Constraints should be declared on the "context" element - the lowest element in the hierarchy
   * that is common to all nodes referenced by the constraint.
   */
  public val constraint: List<Constraint> = listOf(),
  /**
   * If true, implementations that produce or consume resources SHALL provide "support" for the
   * element in some meaningful way. If false, the element may be ignored and not supported. If
   * false, whether to populate or use the data element in any way is at the discretion of the
   * implementation.
   *
   * "Something useful" is context dependent and impossible to describe in the base FHIR
   * specification. For this reason, tue mustSupport flag is never set to true by the FHIR
   * specification itself - it is only set to true in profiles. A profile on a type can always make
   * musSupport = true if it is false in the base type but cannot make mustSupport = false if it is
   * true in the base type. This is done in [Resource Profiles](profiling.html#mustsupport), where
   * the profile labels an element as mustSupport=true. When a profile does this, it SHALL also make
   * clear exactly what kind of "support" is required, as this can mean many things. Note that an
   * element that has the property IsModifier is not necessarily a "key" element (e.g. one of the
   * important elements to make use of the resource), nor is it automatically mustSupport - however
   * both of these things are more likely to be true for IsModifier elements than for other
   * elements.
   */
  public val mustSupport: Boolean? = null,
  /**
   * If true, the value of this element affects the interpretation of the element or resource that
   * contains it, and the value of the element cannot be ignored. Typically, this is used for
   * status, negation and qualification codes. The effect of this is that the element cannot be
   * ignored by systems: they SHALL either recognize the element and process it, and/or a
   * pre-determination has been made that it is not relevant to their particular system.
   *
   * Only the definition of an element can set IsModifier true - either the specification itself or
   * where an extension is originally defined. Once set, it cannot be changed in derived profiles.
   * An element/extension that has isModifier=true SHOULD also have a minimum cardinality of 1, so
   * that there is no lack of clarity about what to do if it is missing. If it can be missing, the
   * definition SHALL make the meaning of a missing element clear.
   */
  public val isModifier: Boolean? = null,
  /**
   * Explains how that element affects the interpretation of the resource or element that contains
   * it.
   */
  public val isModifierReason: String? = null,
  /**
   * Whether the element should be included if a client requests a search with the parameter
   * _summary=true.
   *
   * Some resources include a set of simple metadata, and some very large data. This element is used
   * to reduce the quantity of data returned in searches. Note that servers may pre-cache summarized
   * resources for optimal performance, so servers might not support per-profile use of the
   * isSummary flag. When a request is made with _summary=true, serailisers only include elements
   * marked as 'isSummary = true'. Other than Attachment.data, all data type properties are included
   * in the summary form. In resource and data type definitions, if an element is at the root or has
   * a parent that is 'mustSupport' and the minimum cardinality is 1 or the element is a modifier,
   * it must be marked as isSummary=true.
   */
  public val isSummary: Boolean? = null,
  /**
   * Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the
   * data types (string, uri).
   *
   * For a CodeableConcept, when no codes are allowed - only text, use a binding of strength
   * "required" with a description explaining that no coded values are allowed and what sort of
   * information to put in the "text" element.
   */
  public val binding: Binding? = null,
  /**
   * Identifies a concept from an external specification that roughly corresponds to this element.
   *
   * Mappings are not necessarily specific enough for safe translation.
   */
  public val mapping: List<Mapping> = listOf(),
) : BackboneElement() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(path.toBuilder()).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        representation = this@with.representation.toMutableList()
        sliceName = this@with.sliceName?.toBuilder()
        sliceIsConstraining = this@with.sliceIsConstraining?.toBuilder()
        label = this@with.label?.toBuilder()
        code = this@with.code.map { it.toBuilder() }.toMutableList()
        slicing = this@with.slicing?.toBuilder()
        short = this@with.short?.toBuilder()
        definition = this@with.definition?.toBuilder()
        comment = this@with.comment?.toBuilder()
        requirements = this@with.requirements?.toBuilder()
        alias = this@with.alias.map { it.toBuilder() }.toMutableList()
        min = this@with.min?.toBuilder()
        max = this@with.max?.toBuilder()
        base = this@with.base?.toBuilder()
        contentReference = this@with.contentReference?.toBuilder()
        type = this@with.type.map { it.toBuilder() }.toMutableList()
        defaultValue = this@with.defaultValue
        meaningWhenMissing = this@with.meaningWhenMissing?.toBuilder()
        orderMeaning = this@with.orderMeaning?.toBuilder()
        fixed = this@with.fixed
        pattern = this@with.pattern
        example = this@with.example.map { it.toBuilder() }.toMutableList()
        minValue = this@with.minValue
        maxValue = this@with.maxValue
        maxLength = this@with.maxLength?.toBuilder()
        condition = this@with.condition.map { it.toBuilder() }.toMutableList()
        constraint = this@with.constraint.map { it.toBuilder() }.toMutableList()
        mustSupport = this@with.mustSupport?.toBuilder()
        isModifier = this@with.isModifier?.toBuilder()
        isModifierReason = this@with.isModifierReason?.toBuilder()
        isSummary = this@with.isSummary?.toBuilder()
        binding = this@with.binding?.toBuilder()
        mapping = this@with.mapping.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure
   * definition, there are multiple different constraints on a single element in the base resource).
   * Slicing can be used in any resource that has cardinality ..* on the base resource, or any
   * resource with a choice of types. The set of slices is any elements that come after this in the
   * element sequence that have the same path, until a shorter path occurs (the shorter path
   * terminates the set).
   */
  @Serializable(with = ElementDefinitionSlicingSerializer::class)
  public data class Slicing(
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
     * Designates which child elements are used to discriminate between the slices when processing
     * an instance. If one or more discriminators are provided, the value of the child elements in
     * the instance data SHALL completely distinguish which slice the element in the resource
     * matches based on the allowed values for those elements in each of the slices.
     *
     * If there is no discriminator, the content is hard to process, so this should be avoided.
     */
    public val discriminator: List<Discriminator> = listOf(),
    /**
     * A human-readable text description of how the slicing works. If there is no discriminator,
     * this is required to be present to provide whatever information is possible about how the
     * slices can be differentiated.
     *
     * If it's really not possible to differentiate them, the design should be re-evaluated to make
     * the content usable.
     */
    public val description: String? = null,
    /**
     * If the matching elements have to occur in the same order as defined in the profile.
     *
     * Order should only be required when it is a pressing concern for presentation. Profile authors
     * should consider making the order a feature of the rules about the narrative, not the rules
     * about the data - requiring ordered data makes the profile much less re-usable.
     */
    public val ordered: Boolean? = null,
    /**
     * Whether additional slices are allowed or not. When the slices are ordered, profile authors
     * can also say that additional slices are only allowed at the end.
     *
     * Allowing additional elements makes for a much for flexible template - it's open for use in
     * wider contexts, but also means that the content of the resource is not closed, and
     * applications have to decide how to handle content not described by the profile.
     */
    public val rules: Enumeration<SlicingRules>,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(rules).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          discriminator = this@with.discriminator.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          ordered = this@with.ordered?.toBuilder()
        }
      }

    /**
     * Designates which child elements are used to discriminate between the slices when processing
     * an instance. If one or more discriminators are provided, the value of the child elements in
     * the instance data SHALL completely distinguish which slice the element in the resource
     * matches based on the allowed values for those elements in each of the slices.
     */
    @Serializable(with = ElementDefinitionSlicingDiscriminatorSerializer::class)
    public data class Discriminator(
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
      /** How the element value is interpreted when discrimination is evaluated. */
      public val type: Enumeration<DiscriminatorType>,
      /**
       * A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is
       * used to identify the element on which discrimination is based.
       *
       * The only FHIRPath functions that are allowed are as(type), resolve(), and extension(url).
       */
      public val path: String,
    ) : Element() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type, path.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** How the element value is interpreted when discrimination is evaluated. */
        public var type: Enumeration<DiscriminatorType>,
        /**
         * A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that
         * is used to identify the element on which discrimination is based.
         *
         * The only FHIRPath functions that are allowed are as(type), resolve(), and extension(url).
         */
        public var path: String.Builder,
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

        public fun build(): Discriminator =
          Discriminator(
            id = id,
            extension = extension.map { it.build() },
            type = type,
            path = path.build(),
          )
      }
    }

    public class Builder(
      /**
       * Whether additional slices are allowed or not. When the slices are ordered, profile authors
       * can also say that additional slices are only allowed at the end.
       *
       * Allowing additional elements makes for a much for flexible template - it's open for use in
       * wider contexts, but also means that the content of the resource is not closed, and
       * applications have to decide how to handle content not described by the profile.
       */
      public var rules: Enumeration<SlicingRules>
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
       * Designates which child elements are used to discriminate between the slices when processing
       * an instance. If one or more discriminators are provided, the value of the child elements in
       * the instance data SHALL completely distinguish which slice the element in the resource
       * matches based on the allowed values for those elements in each of the slices.
       *
       * If there is no discriminator, the content is hard to process, so this should be avoided.
       */
      public var discriminator: MutableList<Discriminator.Builder> = mutableListOf()

      /**
       * A human-readable text description of how the slicing works. If there is no discriminator,
       * this is required to be present to provide whatever information is possible about how the
       * slices can be differentiated.
       *
       * If it's really not possible to differentiate them, the design should be re-evaluated to
       * make the content usable.
       */
      public var description: String.Builder? = null

      /**
       * If the matching elements have to occur in the same order as defined in the profile.
       *
       * Order should only be required when it is a pressing concern for presentation. Profile
       * authors should consider making the order a feature of the rules about the narrative, not
       * the rules about the data - requiring ordered data makes the profile much less re-usable.
       */
      public var ordered: Boolean.Builder? = null

      public fun build(): Slicing =
        Slicing(
          id = id,
          extension = extension.map { it.build() },
          discriminator = discriminator.map { it.build() },
          description = description?.build(),
          ordered = ordered?.build(),
          rules = rules,
        )
    }
  }

  /**
   * Information about the base definition of the element, provided to make it unnecessary for tools
   * to trace the deviation of the element through the derived and related profiles. When the
   * element definition is not the original definition of an element - i.g. either in a constraint
   * on another type, or for elements from a super type in a snap shot - then the information in
   * provided in the element definition may be different to the base definition. On the original
   * definition of the element, it will be same.
   */
  @Serializable(with = ElementDefinitionBaseSerializer::class)
  public data class Base(
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
     * The Path that identifies the base element - this matches the ElementDefinition.path for that
     * element. Across FHIR, there is only one base definition of any element - that is, an element
     * definition on a [StructureDefinition](structuredefinition.html#) without a
     * StructureDefinition.base.
     */
    public val path: String,
    /**
     * Minimum cardinality of the base element identified by the path.
     *
     * This is provided for consistency with max, and may affect code generation of mandatory
     * elements of the base resource are generated differently (some reference implementations have
     * done this).
     */
    public val min: UnsignedInt,
    /**
     * Maximum cardinality of the base element identified by the path.
     *
     * This is provided to code generation, since the serialization representation in JSON differs
     * depending on whether the base element has max > 1. Also, some forms of code generation may
     * differ.
     */
    public val max: String,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(path.toBuilder(), min.toBuilder(), max.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The Path that identifies the base element - this matches the ElementDefinition.path for
       * that element. Across FHIR, there is only one base definition of any element - that is, an
       * element definition on a [StructureDefinition](structuredefinition.html#) without a
       * StructureDefinition.base.
       */
      public var path: String.Builder,
      /**
       * Minimum cardinality of the base element identified by the path.
       *
       * This is provided for consistency with max, and may affect code generation of mandatory
       * elements of the base resource are generated differently (some reference implementations
       * have done this).
       */
      public var min: UnsignedInt.Builder,
      /**
       * Maximum cardinality of the base element identified by the path.
       *
       * This is provided to code generation, since the serialization representation in JSON differs
       * depending on whether the base element has max > 1. Also, some forms of code generation may
       * differ.
       */
      public var max: String.Builder,
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

      public fun build(): Base =
        Base(
          id = id,
          extension = extension.map { it.build() },
          path = path.build(),
          min = min.build(),
          max = max.build(),
        )
    }
  }

  /** The data type or resource that the value of this element is permitted to be. */
  @Serializable(with = ElementDefinitionTypeSerializer::class)
  public data class Type(
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
     * URL of Data type or Resource that is a(or the) type used for this element. References are
     * URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a
     * reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed
     * in logical models.
     *
     * If the element is a reference to another resource, this element contains "Reference", and the
     * targetProfile element defines what resources can be referenced. The targetProfile may be a
     * reference to the general definition of a resource (e.g.
     * http://hl7.org/fhir/StructureDefinition/Patient).
     */
    public val code: Uri,
    /**
     * Identifies a profile structure or implementation Guide that applies to the datatype this
     * element refers to. If any profiles are specified, then the content must conform to at least
     * one of them. The URL can be a local reference - to a contained StructureDefinition, or a
     * reference to another StructureDefinition or Implementation Guide by a canonical URL. When an
     * implementation guide is specified, the type SHALL conform to at least one profile defined in
     * the implementation guide.
     *
     * It is possible to profile backbone element (e.g. part of a resource), using the
     * [profile-element](extension-elementdefinition-profile-element.html) extension.
     */
    public val profile: List<Canonical> = listOf(),
    /**
     * Used when the type is "Reference" or "canonical", and identifies a profile structure or
     * implementation Guide that applies to the target of the reference this element refers to. If
     * any profiles are specified, then the content must conform to at least one of them. The URL
     * can be a local reference - to a contained StructureDefinition, or a reference to another
     * StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide
     * is specified, the target resource SHALL conform to at least one profile defined in the
     * implementation guide.
     */
    public val targetProfile: List<Canonical> = listOf(),
    /**
     * If the type is a reference to another resource, how the resource is or can be aggregated - is
     * it a contained resource, or a reference, and if the context is a bundle, is it included in
     * the bundle.
     *
     * See [Aggregation Rules](elementdefinition.html#aggregation) for further clarification.
     */
    public val aggregation: List<Enumeration<AggregationMode>> = listOf(),
    /**
     * Whether this reference needs to be version specific or version independent, or whether either
     * can be used.
     *
     * The base specification never makes a rule as to which form is allowed, but implementation
     * guides may do this. See [Aggregation Rules](elementdefinition.html#aggregation) for further
     * clarification.
     */
    public val versioning: Enumeration<ReferenceVersionRules>? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          profile = this@with.profile.map { it.toBuilder() }.toMutableList()
          targetProfile = this@with.targetProfile.map { it.toBuilder() }.toMutableList()
          aggregation = this@with.aggregation.toMutableList()
          versioning = this@with.versioning
        }
      }

    public class Builder(
      /**
       * URL of Data type or Resource that is a(or the) type used for this element. References are
       * URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a
       * reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed
       * in logical models.
       *
       * If the element is a reference to another resource, this element contains "Reference", and
       * the targetProfile element defines what resources can be referenced. The targetProfile may
       * be a reference to the general definition of a resource (e.g.
       * http://hl7.org/fhir/StructureDefinition/Patient).
       */
      public var code: Uri.Builder
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
       * Identifies a profile structure or implementation Guide that applies to the datatype this
       * element refers to. If any profiles are specified, then the content must conform to at least
       * one of them. The URL can be a local reference - to a contained StructureDefinition, or a
       * reference to another StructureDefinition or Implementation Guide by a canonical URL. When
       * an implementation guide is specified, the type SHALL conform to at least one profile
       * defined in the implementation guide.
       *
       * It is possible to profile backbone element (e.g. part of a resource), using the
       * [profile-element](extension-elementdefinition-profile-element.html) extension.
       */
      public var profile: MutableList<Canonical.Builder> = mutableListOf()

      /**
       * Used when the type is "Reference" or "canonical", and identifies a profile structure or
       * implementation Guide that applies to the target of the reference this element refers to. If
       * any profiles are specified, then the content must conform to at least one of them. The URL
       * can be a local reference - to a contained StructureDefinition, or a reference to another
       * StructureDefinition or Implementation Guide by a canonical URL. When an implementation
       * guide is specified, the target resource SHALL conform to at least one profile defined in
       * the implementation guide.
       */
      public var targetProfile: MutableList<Canonical.Builder> = mutableListOf()

      /**
       * If the type is a reference to another resource, how the resource is or can be aggregated -
       * is it a contained resource, or a reference, and if the context is a bundle, is it included
       * in the bundle.
       *
       * See [Aggregation Rules](elementdefinition.html#aggregation) for further clarification.
       */
      public var aggregation: MutableList<Enumeration<AggregationMode>> = mutableListOf()

      /**
       * Whether this reference needs to be version specific or version independent, or whether
       * either can be used.
       *
       * The base specification never makes a rule as to which form is allowed, but implementation
       * guides may do this. See [Aggregation Rules](elementdefinition.html#aggregation) for further
       * clarification.
       */
      public var versioning: Enumeration<ReferenceVersionRules>? = null

      public fun build(): Type =
        Type(
          id = id,
          extension = extension.map { it.build() },
          code = code.build(),
          profile = profile.map { it.build() },
          targetProfile = targetProfile.map { it.build() },
          aggregation = aggregation,
          versioning = versioning,
        )
    }
  }

  /**
   * A sample value for this element demonstrating the type of information that would typically be
   * found in the element.
   */
  @Serializable(with = ElementDefinitionExampleSerializer::class)
  public data class Example(
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
    /** Describes the purpose of this example amoung the set of examples. */
    public val label: String,
    /**
     * The actual value for the element, which must be one of the types allowed for this element.
     */
    public val `value`: Value,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(label.toBuilder(), `value`).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        }
      }

    @Serializable(with = ElementDefinitionExampleValueSerializer::class)
    public sealed interface Value {
      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asCode(): Code? = this as? Code

      public fun asDate(): Date? = this as? Date

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asId(): Id? = this as? Id

      public fun asInstant(): Instant? = this as? Instant

      public fun asInteger(): Integer? = this as? Integer

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asOid(): Oid? = this as? Oid

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public fun asString(): String? = this as? String

      public fun asTime(): Time? = this as? Time

      public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

      public fun asUri(): Uri? = this as? Uri

      public fun asUrl(): Url? = this as? Url

      public fun asUuid(): Uuid? = this as? Uuid

      public fun asAddress(): Address? = this as? Address

      public fun asAge(): Age? = this as? Age

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asCoding(): Coding? = this as? Coding

      public fun asContactPoint(): ContactPoint? = this as? ContactPoint

      public fun asCount(): Count? = this as? Count

      public fun asDistance(): Distance? = this as? Distance

      public fun asDuration(): Duration? = this as? Duration

      public fun asHumanName(): HumanName? = this as? HumanName

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asMoney(): Money? = this as? Money

      public fun asPeriod(): Period? = this as? Period

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asReference(): Reference? = this as? Reference

      public fun asSampledData(): SampledData? = this as? SampledData

      public fun asSignature(): Signature? = this as? Signature

      public fun asTiming(): Timing? = this as? Timing

      public fun asContactDetail(): ContactDetail? = this as? ContactDetail

      public fun asContributor(): Contributor? = this as? Contributor

      public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

      public fun asExpression(): Expression? = this as? Expression

      public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

      public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

      public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

      public fun asUsageContext(): UsageContext? = this as? UsageContext

      public fun asDosage(): Dosage? = this as? Dosage

      public fun asMeta(): Meta? = this as? Meta

      public data class Base64Binary(public val `value`: com.google.fhir.model.r4.Base64Binary) :
        Value

      public data class Boolean(public val `value`: com.google.fhir.model.r4.Boolean) : Value

      public data class Canonical(public val `value`: com.google.fhir.model.r4.Canonical) : Value

      public data class Code(public val `value`: com.google.fhir.model.r4.Code) : Value

      public data class Date(public val `value`: com.google.fhir.model.r4.Date) : Value

      public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : Value

      public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : Value

      public data class Id(public val `value`: com.google.fhir.model.r4.Id) : Value

      public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : Value

      public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : Value

      public data class Markdown(public val `value`: com.google.fhir.model.r4.Markdown) : Value

      public data class Oid(public val `value`: com.google.fhir.model.r4.Oid) : Value

      public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) :
        Value

      public data class String(public val `value`: com.google.fhir.model.r4.String) : Value

      public data class Time(public val `value`: com.google.fhir.model.r4.Time) : Value

      public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) :
        Value

      public data class Uri(public val `value`: com.google.fhir.model.r4.Uri) : Value

      public data class Url(public val `value`: com.google.fhir.model.r4.Url) : Value

      public data class Uuid(public val `value`: com.google.fhir.model.r4.Uuid) : Value

      public data class Address(public val `value`: com.google.fhir.model.r4.Address) : Value

      public data class Age(public val `value`: com.google.fhir.model.r4.Age) : Value

      public data class Annotation(public val `value`: com.google.fhir.model.r4.Annotation) : Value

      public data class Attachment(public val `value`: com.google.fhir.model.r4.Attachment) : Value

      public data class CodeableConcept(
        public val `value`: com.google.fhir.model.r4.CodeableConcept
      ) : Value

      public data class Coding(public val `value`: com.google.fhir.model.r4.Coding) : Value

      public data class ContactPoint(public val `value`: com.google.fhir.model.r4.ContactPoint) :
        Value

      public data class Count(public val `value`: com.google.fhir.model.r4.Count) : Value

      public data class Distance(public val `value`: com.google.fhir.model.r4.Distance) : Value

      public data class Duration(public val `value`: com.google.fhir.model.r4.Duration) : Value

      public data class HumanName(public val `value`: com.google.fhir.model.r4.HumanName) : Value

      public data class Identifier(public val `value`: com.google.fhir.model.r4.Identifier) : Value

      public data class Money(public val `value`: com.google.fhir.model.r4.Money) : Value

      public data class Period(public val `value`: com.google.fhir.model.r4.Period) : Value

      public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Value

      public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Value

      public data class Ratio(public val `value`: com.google.fhir.model.r4.Ratio) : Value

      public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) : Value

      public data class SampledData(public val `value`: com.google.fhir.model.r4.SampledData) :
        Value

      public data class Signature(public val `value`: com.google.fhir.model.r4.Signature) : Value

      public data class Timing(public val `value`: com.google.fhir.model.r4.Timing) : Value

      public data class ContactDetail(public val `value`: com.google.fhir.model.r4.ContactDetail) :
        Value

      public data class Contributor(public val `value`: com.google.fhir.model.r4.Contributor) :
        Value

      public data class DataRequirement(
        public val `value`: com.google.fhir.model.r4.DataRequirement
      ) : Value

      public data class Expression(public val `value`: com.google.fhir.model.r4.Expression) : Value

      public data class ParameterDefinition(
        public val `value`: com.google.fhir.model.r4.ParameterDefinition
      ) : Value

      public data class RelatedArtifact(
        public val `value`: com.google.fhir.model.r4.RelatedArtifact
      ) : Value

      public data class TriggerDefinition(
        public val `value`: com.google.fhir.model.r4.TriggerDefinition
      ) : Value

      public data class UsageContext(public val `value`: com.google.fhir.model.r4.UsageContext) :
        Value

      public data class Dosage(public val `value`: com.google.fhir.model.r4.Dosage) : Value

      public data class Meta(public val `value`: com.google.fhir.model.r4.Meta) : Value

      public companion object {
        internal fun from(
          base64BinaryValue: com.google.fhir.model.r4.Base64Binary?,
          booleanValue: com.google.fhir.model.r4.Boolean?,
          canonicalValue: com.google.fhir.model.r4.Canonical?,
          codeValue: com.google.fhir.model.r4.Code?,
          dateValue: com.google.fhir.model.r4.Date?,
          dateTimeValue: com.google.fhir.model.r4.DateTime?,
          decimalValue: com.google.fhir.model.r4.Decimal?,
          idValue: com.google.fhir.model.r4.Id?,
          instantValue: com.google.fhir.model.r4.Instant?,
          integerValue: com.google.fhir.model.r4.Integer?,
          markdownValue: com.google.fhir.model.r4.Markdown?,
          oidValue: com.google.fhir.model.r4.Oid?,
          positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
          stringValue: com.google.fhir.model.r4.String?,
          timeValue: com.google.fhir.model.r4.Time?,
          unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
          uriValue: com.google.fhir.model.r4.Uri?,
          urlValue: com.google.fhir.model.r4.Url?,
          uuidValue: com.google.fhir.model.r4.Uuid?,
          addressValue: com.google.fhir.model.r4.Address?,
          ageValue: com.google.fhir.model.r4.Age?,
          annotationValue: com.google.fhir.model.r4.Annotation?,
          attachmentValue: com.google.fhir.model.r4.Attachment?,
          codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
          codingValue: com.google.fhir.model.r4.Coding?,
          contactPointValue: com.google.fhir.model.r4.ContactPoint?,
          countValue: com.google.fhir.model.r4.Count?,
          distanceValue: com.google.fhir.model.r4.Distance?,
          durationValue: com.google.fhir.model.r4.Duration?,
          humanNameValue: com.google.fhir.model.r4.HumanName?,
          identifierValue: com.google.fhir.model.r4.Identifier?,
          moneyValue: com.google.fhir.model.r4.Money?,
          periodValue: com.google.fhir.model.r4.Period?,
          quantityValue: com.google.fhir.model.r4.Quantity?,
          rangeValue: com.google.fhir.model.r4.Range?,
          ratioValue: com.google.fhir.model.r4.Ratio?,
          referenceValue: com.google.fhir.model.r4.Reference?,
          sampledDataValue: com.google.fhir.model.r4.SampledData?,
          signatureValue: com.google.fhir.model.r4.Signature?,
          timingValue: com.google.fhir.model.r4.Timing?,
          contactDetailValue: com.google.fhir.model.r4.ContactDetail?,
          contributorValue: com.google.fhir.model.r4.Contributor?,
          dataRequirementValue: com.google.fhir.model.r4.DataRequirement?,
          expressionValue: com.google.fhir.model.r4.Expression?,
          parameterDefinitionValue: com.google.fhir.model.r4.ParameterDefinition?,
          relatedArtifactValue: com.google.fhir.model.r4.RelatedArtifact?,
          triggerDefinitionValue: com.google.fhir.model.r4.TriggerDefinition?,
          usageContextValue: com.google.fhir.model.r4.UsageContext?,
          dosageValue: com.google.fhir.model.r4.Dosage?,
          metaValue: com.google.fhir.model.r4.Meta?,
        ): Value? {
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (codeValue != null) return Code(codeValue)
          if (dateValue != null) return Date(dateValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (idValue != null) return Id(idValue)
          if (instantValue != null) return Instant(instantValue)
          if (integerValue != null) return Integer(integerValue)
          if (markdownValue != null) return Markdown(markdownValue)
          if (oidValue != null) return Oid(oidValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          if (stringValue != null) return String(stringValue)
          if (timeValue != null) return Time(timeValue)
          if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
          if (uriValue != null) return Uri(uriValue)
          if (urlValue != null) return Url(urlValue)
          if (uuidValue != null) return Uuid(uuidValue)
          if (addressValue != null) return Address(addressValue)
          if (ageValue != null) return Age(ageValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (codingValue != null) return Coding(codingValue)
          if (contactPointValue != null) return ContactPoint(contactPointValue)
          if (countValue != null) return Count(countValue)
          if (distanceValue != null) return Distance(distanceValue)
          if (durationValue != null) return Duration(durationValue)
          if (humanNameValue != null) return HumanName(humanNameValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (moneyValue != null) return Money(moneyValue)
          if (periodValue != null) return Period(periodValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (sampledDataValue != null) return SampledData(sampledDataValue)
          if (signatureValue != null) return Signature(signatureValue)
          if (timingValue != null) return Timing(timingValue)
          if (contactDetailValue != null) return ContactDetail(contactDetailValue)
          if (contributorValue != null) return Contributor(contributorValue)
          if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
          if (expressionValue != null) return Expression(expressionValue)
          if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
          if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
          if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
          if (usageContextValue != null) return UsageContext(usageContextValue)
          if (dosageValue != null) return Dosage(dosageValue)
          if (metaValue != null) return Meta(metaValue)
          return null
        }
      }
    }

    public class Builder(
      /** Describes the purpose of this example amoung the set of examples. */
      public var label: String.Builder,
      /**
       * The actual value for the element, which must be one of the types allowed for this element.
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

      public fun build(): Example =
        Example(
          id = id,
          extension = extension.map { it.build() },
          label = label.build(),
          `value` = `value`,
        )
    }
  }

  /**
   * Formal constraints such as co-occurrence and other constraints that can be computationally
   * evaluated within the context of the instance.
   */
  @Serializable(with = ElementDefinitionConstraintSerializer::class)
  public data class Constraint(
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
     * Allows identification of which elements have their cardinalities impacted by the constraint.
     * Will not be referenced for constraints that do not affect cardinality.
     */
    public val key: Id,
    /**
     * Description of why this constraint is necessary or appropriate.
     *
     * To be used if the reason for the constraint might not be intuitive to all implementers.
     */
    public val requirements: String? = null,
    /**
     * Identifies the impact constraint violation has on the conformance of the instance.
     *
     * This allows constraints to be asserted as "shall" (error) and "should" (warning).
     */
    public val severity: Enumeration<ConstraintSeverity>,
    /**
     * Text that can be used to describe the constraint in messages identifying that the constraint
     * has been violated.
     *
     * Should be expressed in business terms as much as possible.
     */
    public val human: String,
    /**
     * A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this
     * constraint is met.
     *
     * In the absense of an expression, the expression is likely not enforceable by validators, and
     * might be missed by many systems.
     */
    public val expression: String? = null,
    /**
     * An XPath expression of constraint that can be executed to see if this constraint is met.
     *
     * Elements SHALL use "f" as the namespace prefix for the FHIR namespace, and "x" for the xhtml
     * namespace, and SHALL NOT use any other prefixes. Note: XPath is generally considered not
     * useful because it does not apply to JSON and other formats and because of XSLT implementation
     * issues, and may be removed in the future.
     */
    public val xpath: String? = null,
    /**
     * A reference to the original source of the constraint, for traceability purposes.
     *
     * This is used when, e.g. rendering, where it is not useful to present inherited constraints
     * when rendering the snapshot.
     */
    public val source: Canonical? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(key.toBuilder(), severity, human.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          requirements = this@with.requirements?.toBuilder()
          expression = this@with.expression?.toBuilder()
          xpath = this@with.xpath?.toBuilder()
          source = this@with.source?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Allows identification of which elements have their cardinalities impacted by the
       * constraint. Will not be referenced for constraints that do not affect cardinality.
       */
      public var key: Id.Builder,
      /**
       * Identifies the impact constraint violation has on the conformance of the instance.
       *
       * This allows constraints to be asserted as "shall" (error) and "should" (warning).
       */
      public var severity: Enumeration<ConstraintSeverity>,
      /**
       * Text that can be used to describe the constraint in messages identifying that the
       * constraint has been violated.
       *
       * Should be expressed in business terms as much as possible.
       */
      public var human: String.Builder,
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
       * Description of why this constraint is necessary or appropriate.
       *
       * To be used if the reason for the constraint might not be intuitive to all implementers.
       */
      public var requirements: String.Builder? = null

      /**
       * A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this
       * constraint is met.
       *
       * In the absense of an expression, the expression is likely not enforceable by validators,
       * and might be missed by many systems.
       */
      public var expression: String.Builder? = null

      /**
       * An XPath expression of constraint that can be executed to see if this constraint is met.
       *
       * Elements SHALL use "f" as the namespace prefix for the FHIR namespace, and "x" for the
       * xhtml namespace, and SHALL NOT use any other prefixes. Note: XPath is generally considered
       * not useful because it does not apply to JSON and other formats and because of XSLT
       * implementation issues, and may be removed in the future.
       */
      public var xpath: String.Builder? = null

      /**
       * A reference to the original source of the constraint, for traceability purposes.
       *
       * This is used when, e.g. rendering, where it is not useful to present inherited constraints
       * when rendering the snapshot.
       */
      public var source: Canonical.Builder? = null

      public fun build(): Constraint =
        Constraint(
          id = id,
          extension = extension.map { it.build() },
          key = key.build(),
          requirements = requirements?.build(),
          severity = severity,
          human = human.build(),
          expression = expression?.build(),
          xpath = xpath?.build(),
          source = source?.build(),
        )
    }
  }

  /**
   * Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the
   * data types (string, uri).
   */
  @Serializable(with = ElementDefinitionBindingSerializer::class)
  public data class Binding(
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
     * Indicates the degree of conformance expectations associated with this binding - that is, the
     * degree to which the provided value set must be adhered to in the instances.
     *
     * For further discussion, see [Using Terminologies](terminologies.html).
     */
    public val strength: Enumeration<BindingStrength>,
    /** Describes the intended use of this particular set of codes. */
    public val description: String? = null,
    /**
     * Refers to the value set that identifies the set of codes the binding refers to.
     *
     * The reference may be version-specific or not (e.g. have a |[version] at the end of the
     * canonical URL).
     */
    public val valueSet: Canonical? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(strength).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          valueSet = this@with.valueSet?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Indicates the degree of conformance expectations associated with this binding - that is,
       * the degree to which the provided value set must be adhered to in the instances.
       *
       * For further discussion, see [Using Terminologies](terminologies.html).
       */
      public var strength: Enumeration<BindingStrength>
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

      /** Describes the intended use of this particular set of codes. */
      public var description: String.Builder? = null

      /**
       * Refers to the value set that identifies the set of codes the binding refers to.
       *
       * The reference may be version-specific or not (e.g. have a |[version] at the end of the
       * canonical URL).
       */
      public var valueSet: Canonical.Builder? = null

      public fun build(): Binding =
        Binding(
          id = id,
          extension = extension.map { it.build() },
          strength = strength,
          description = description?.build(),
          valueSet = valueSet?.build(),
        )
    }
  }

  /**
   * Identifies a concept from an external specification that roughly corresponds to this element.
   */
  @Serializable(with = ElementDefinitionMappingSerializer::class)
  public data class Mapping(
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
    /** An internal reference to the definition of a mapping. */
    public val identity: Id,
    /**
     * Identifies the computable language in which mapping.map is expressed.
     *
     * If omitted, then there can be no expectation of computational interpretation of the mapping.
     */
    public val language: Code? = null,
    /**
     * Expresses what part of the target specification corresponds to this element.
     *
     * For most mappings, the syntax is undefined. Syntax will be provided for mappings to the RIM.
     * Multiple mappings may be possible and may include constraints on other resource elements that
     * identify when a particular mapping applies.
     */
    public val map: String,
    /** Comments that provide information about the mapping or its use. */
    public val comment: String? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(identity.toBuilder(), map.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          language = this@with.language?.toBuilder()
          comment = this@with.comment?.toBuilder()
        }
      }

    public class Builder(
      /** An internal reference to the definition of a mapping. */
      public var identity: Id.Builder,
      /**
       * Expresses what part of the target specification corresponds to this element.
       *
       * For most mappings, the syntax is undefined. Syntax will be provided for mappings to the
       * RIM. Multiple mappings may be possible and may include constraints on other resource
       * elements that identify when a particular mapping applies.
       */
      public var map: String.Builder,
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
       * Identifies the computable language in which mapping.map is expressed.
       *
       * If omitted, then there can be no expectation of computational interpretation of the
       * mapping.
       */
      public var language: Code.Builder? = null

      /** Comments that provide information about the mapping or its use. */
      public var comment: String.Builder? = null

      public fun build(): Mapping =
        Mapping(
          id = id,
          extension = extension.map { it.build() },
          identity = identity.build(),
          language = language?.build(),
          map = map.build(),
          comment = comment?.build(),
        )
    }
  }

  @Serializable(with = ElementDefinitionDefaultValueSerializer::class)
  public sealed interface DefaultValue {
    public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asCanonical(): Canonical? = this as? Canonical

    public fun asCode(): Code? = this as? Code

    public fun asDate(): Date? = this as? Date

    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asDecimal(): Decimal? = this as? Decimal

    public fun asId(): Id? = this as? Id

    public fun asInstant(): Instant? = this as? Instant

    public fun asInteger(): Integer? = this as? Integer

    public fun asMarkdown(): Markdown? = this as? Markdown

    public fun asOid(): Oid? = this as? Oid

    public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

    public fun asString(): String? = this as? String

    public fun asTime(): Time? = this as? Time

    public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

    public fun asUri(): Uri? = this as? Uri

    public fun asUrl(): Url? = this as? Url

    public fun asUuid(): Uuid? = this as? Uuid

    public fun asAddress(): Address? = this as? Address

    public fun asAge(): Age? = this as? Age

    public fun asAnnotation(): Annotation? = this as? Annotation

    public fun asAttachment(): Attachment? = this as? Attachment

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asCoding(): Coding? = this as? Coding

    public fun asContactPoint(): ContactPoint? = this as? ContactPoint

    public fun asCount(): Count? = this as? Count

    public fun asDistance(): Distance? = this as? Distance

    public fun asDuration(): Duration? = this as? Duration

    public fun asHumanName(): HumanName? = this as? HumanName

    public fun asIdentifier(): Identifier? = this as? Identifier

    public fun asMoney(): Money? = this as? Money

    public fun asPeriod(): Period? = this as? Period

    public fun asQuantity(): Quantity? = this as? Quantity

    public fun asRange(): Range? = this as? Range

    public fun asRatio(): Ratio? = this as? Ratio

    public fun asReference(): Reference? = this as? Reference

    public fun asSampledData(): SampledData? = this as? SampledData

    public fun asSignature(): Signature? = this as? Signature

    public fun asTiming(): Timing? = this as? Timing

    public fun asContactDetail(): ContactDetail? = this as? ContactDetail

    public fun asContributor(): Contributor? = this as? Contributor

    public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

    public fun asExpression(): Expression? = this as? Expression

    public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

    public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

    public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

    public fun asUsageContext(): UsageContext? = this as? UsageContext

    public fun asDosage(): Dosage? = this as? Dosage

    public fun asMeta(): Meta? = this as? Meta

    public data class Base64Binary(public val `value`: com.google.fhir.model.r4.Base64Binary) :
      DefaultValue

    public data class Boolean(public val `value`: com.google.fhir.model.r4.Boolean) : DefaultValue

    public data class Canonical(public val `value`: com.google.fhir.model.r4.Canonical) :
      DefaultValue

    public data class Code(public val `value`: com.google.fhir.model.r4.Code) : DefaultValue

    public data class Date(public val `value`: com.google.fhir.model.r4.Date) : DefaultValue

    public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) :
      DefaultValue

    public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : DefaultValue

    public data class Id(public val `value`: com.google.fhir.model.r4.Id) : DefaultValue

    public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : DefaultValue

    public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : DefaultValue

    public data class Markdown(public val `value`: com.google.fhir.model.r4.Markdown) :
      DefaultValue

    public data class Oid(public val `value`: com.google.fhir.model.r4.Oid) : DefaultValue

    public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) :
      DefaultValue

    public data class String(public val `value`: com.google.fhir.model.r4.String) : DefaultValue

    public data class Time(public val `value`: com.google.fhir.model.r4.Time) : DefaultValue

    public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) :
      DefaultValue

    public data class Uri(public val `value`: com.google.fhir.model.r4.Uri) : DefaultValue

    public data class Url(public val `value`: com.google.fhir.model.r4.Url) : DefaultValue

    public data class Uuid(public val `value`: com.google.fhir.model.r4.Uuid) : DefaultValue

    public data class Address(public val `value`: com.google.fhir.model.r4.Address) : DefaultValue

    public data class Age(public val `value`: com.google.fhir.model.r4.Age) : DefaultValue

    public data class Annotation(public val `value`: com.google.fhir.model.r4.Annotation) :
      DefaultValue

    public data class Attachment(public val `value`: com.google.fhir.model.r4.Attachment) :
      DefaultValue

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4.CodeableConcept
    ) : DefaultValue

    public data class Coding(public val `value`: com.google.fhir.model.r4.Coding) : DefaultValue

    public data class ContactPoint(public val `value`: com.google.fhir.model.r4.ContactPoint) :
      DefaultValue

    public data class Count(public val `value`: com.google.fhir.model.r4.Count) : DefaultValue

    public data class Distance(public val `value`: com.google.fhir.model.r4.Distance) :
      DefaultValue

    public data class Duration(public val `value`: com.google.fhir.model.r4.Duration) :
      DefaultValue

    public data class HumanName(public val `value`: com.google.fhir.model.r4.HumanName) :
      DefaultValue

    public data class Identifier(public val `value`: com.google.fhir.model.r4.Identifier) :
      DefaultValue

    public data class Money(public val `value`: com.google.fhir.model.r4.Money) : DefaultValue

    public data class Period(public val `value`: com.google.fhir.model.r4.Period) : DefaultValue

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) :
      DefaultValue

    public data class Range(public val `value`: com.google.fhir.model.r4.Range) : DefaultValue

    public data class Ratio(public val `value`: com.google.fhir.model.r4.Ratio) : DefaultValue

    public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) :
      DefaultValue

    public data class SampledData(public val `value`: com.google.fhir.model.r4.SampledData) :
      DefaultValue

    public data class Signature(public val `value`: com.google.fhir.model.r4.Signature) :
      DefaultValue

    public data class Timing(public val `value`: com.google.fhir.model.r4.Timing) : DefaultValue

    public data class ContactDetail(public val `value`: com.google.fhir.model.r4.ContactDetail) :
      DefaultValue

    public data class Contributor(public val `value`: com.google.fhir.model.r4.Contributor) :
      DefaultValue

    public data class DataRequirement(
      public val `value`: com.google.fhir.model.r4.DataRequirement
    ) : DefaultValue

    public data class Expression(public val `value`: com.google.fhir.model.r4.Expression) :
      DefaultValue

    public data class ParameterDefinition(
      public val `value`: com.google.fhir.model.r4.ParameterDefinition
    ) : DefaultValue

    public data class RelatedArtifact(
      public val `value`: com.google.fhir.model.r4.RelatedArtifact
    ) : DefaultValue

    public data class TriggerDefinition(
      public val `value`: com.google.fhir.model.r4.TriggerDefinition
    ) : DefaultValue

    public data class UsageContext(public val `value`: com.google.fhir.model.r4.UsageContext) :
      DefaultValue

    public data class Dosage(public val `value`: com.google.fhir.model.r4.Dosage) : DefaultValue

    public data class Meta(public val `value`: com.google.fhir.model.r4.Meta) : DefaultValue

    public companion object {
      internal fun from(
        base64BinaryValue: com.google.fhir.model.r4.Base64Binary?,
        booleanValue: com.google.fhir.model.r4.Boolean?,
        canonicalValue: com.google.fhir.model.r4.Canonical?,
        codeValue: com.google.fhir.model.r4.Code?,
        dateValue: com.google.fhir.model.r4.Date?,
        dateTimeValue: com.google.fhir.model.r4.DateTime?,
        decimalValue: com.google.fhir.model.r4.Decimal?,
        idValue: com.google.fhir.model.r4.Id?,
        instantValue: com.google.fhir.model.r4.Instant?,
        integerValue: com.google.fhir.model.r4.Integer?,
        markdownValue: com.google.fhir.model.r4.Markdown?,
        oidValue: com.google.fhir.model.r4.Oid?,
        positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
        stringValue: com.google.fhir.model.r4.String?,
        timeValue: com.google.fhir.model.r4.Time?,
        unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
        uriValue: com.google.fhir.model.r4.Uri?,
        urlValue: com.google.fhir.model.r4.Url?,
        uuidValue: com.google.fhir.model.r4.Uuid?,
        addressValue: com.google.fhir.model.r4.Address?,
        ageValue: com.google.fhir.model.r4.Age?,
        annotationValue: com.google.fhir.model.r4.Annotation?,
        attachmentValue: com.google.fhir.model.r4.Attachment?,
        codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
        codingValue: com.google.fhir.model.r4.Coding?,
        contactPointValue: com.google.fhir.model.r4.ContactPoint?,
        countValue: com.google.fhir.model.r4.Count?,
        distanceValue: com.google.fhir.model.r4.Distance?,
        durationValue: com.google.fhir.model.r4.Duration?,
        humanNameValue: com.google.fhir.model.r4.HumanName?,
        identifierValue: com.google.fhir.model.r4.Identifier?,
        moneyValue: com.google.fhir.model.r4.Money?,
        periodValue: com.google.fhir.model.r4.Period?,
        quantityValue: com.google.fhir.model.r4.Quantity?,
        rangeValue: com.google.fhir.model.r4.Range?,
        ratioValue: com.google.fhir.model.r4.Ratio?,
        referenceValue: com.google.fhir.model.r4.Reference?,
        sampledDataValue: com.google.fhir.model.r4.SampledData?,
        signatureValue: com.google.fhir.model.r4.Signature?,
        timingValue: com.google.fhir.model.r4.Timing?,
        contactDetailValue: com.google.fhir.model.r4.ContactDetail?,
        contributorValue: com.google.fhir.model.r4.Contributor?,
        dataRequirementValue: com.google.fhir.model.r4.DataRequirement?,
        expressionValue: com.google.fhir.model.r4.Expression?,
        parameterDefinitionValue: com.google.fhir.model.r4.ParameterDefinition?,
        relatedArtifactValue: com.google.fhir.model.r4.RelatedArtifact?,
        triggerDefinitionValue: com.google.fhir.model.r4.TriggerDefinition?,
        usageContextValue: com.google.fhir.model.r4.UsageContext?,
        dosageValue: com.google.fhir.model.r4.Dosage?,
        metaValue: com.google.fhir.model.r4.Meta?,
      ): DefaultValue? {
        if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
        if (booleanValue != null) return Boolean(booleanValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        if (codeValue != null) return Code(codeValue)
        if (dateValue != null) return Date(dateValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (decimalValue != null) return Decimal(decimalValue)
        if (idValue != null) return Id(idValue)
        if (instantValue != null) return Instant(instantValue)
        if (integerValue != null) return Integer(integerValue)
        if (markdownValue != null) return Markdown(markdownValue)
        if (oidValue != null) return Oid(oidValue)
        if (positiveIntValue != null) return PositiveInt(positiveIntValue)
        if (stringValue != null) return String(stringValue)
        if (timeValue != null) return Time(timeValue)
        if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
        if (uriValue != null) return Uri(uriValue)
        if (urlValue != null) return Url(urlValue)
        if (uuidValue != null) return Uuid(uuidValue)
        if (addressValue != null) return Address(addressValue)
        if (ageValue != null) return Age(ageValue)
        if (annotationValue != null) return Annotation(annotationValue)
        if (attachmentValue != null) return Attachment(attachmentValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (codingValue != null) return Coding(codingValue)
        if (contactPointValue != null) return ContactPoint(contactPointValue)
        if (countValue != null) return Count(countValue)
        if (distanceValue != null) return Distance(distanceValue)
        if (durationValue != null) return Duration(durationValue)
        if (humanNameValue != null) return HumanName(humanNameValue)
        if (identifierValue != null) return Identifier(identifierValue)
        if (moneyValue != null) return Money(moneyValue)
        if (periodValue != null) return Period(periodValue)
        if (quantityValue != null) return Quantity(quantityValue)
        if (rangeValue != null) return Range(rangeValue)
        if (ratioValue != null) return Ratio(ratioValue)
        if (referenceValue != null) return Reference(referenceValue)
        if (sampledDataValue != null) return SampledData(sampledDataValue)
        if (signatureValue != null) return Signature(signatureValue)
        if (timingValue != null) return Timing(timingValue)
        if (contactDetailValue != null) return ContactDetail(contactDetailValue)
        if (contributorValue != null) return Contributor(contributorValue)
        if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
        if (expressionValue != null) return Expression(expressionValue)
        if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
        if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
        if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
        if (usageContextValue != null) return UsageContext(usageContextValue)
        if (dosageValue != null) return Dosage(dosageValue)
        if (metaValue != null) return Meta(metaValue)
        return null
      }
    }
  }

  @Serializable(with = ElementDefinitionFixedSerializer::class)
  public sealed interface Fixed {
    public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asCanonical(): Canonical? = this as? Canonical

    public fun asCode(): Code? = this as? Code

    public fun asDate(): Date? = this as? Date

    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asDecimal(): Decimal? = this as? Decimal

    public fun asId(): Id? = this as? Id

    public fun asInstant(): Instant? = this as? Instant

    public fun asInteger(): Integer? = this as? Integer

    public fun asMarkdown(): Markdown? = this as? Markdown

    public fun asOid(): Oid? = this as? Oid

    public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

    public fun asString(): String? = this as? String

    public fun asTime(): Time? = this as? Time

    public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

    public fun asUri(): Uri? = this as? Uri

    public fun asUrl(): Url? = this as? Url

    public fun asUuid(): Uuid? = this as? Uuid

    public fun asAddress(): Address? = this as? Address

    public fun asAge(): Age? = this as? Age

    public fun asAnnotation(): Annotation? = this as? Annotation

    public fun asAttachment(): Attachment? = this as? Attachment

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asCoding(): Coding? = this as? Coding

    public fun asContactPoint(): ContactPoint? = this as? ContactPoint

    public fun asCount(): Count? = this as? Count

    public fun asDistance(): Distance? = this as? Distance

    public fun asDuration(): Duration? = this as? Duration

    public fun asHumanName(): HumanName? = this as? HumanName

    public fun asIdentifier(): Identifier? = this as? Identifier

    public fun asMoney(): Money? = this as? Money

    public fun asPeriod(): Period? = this as? Period

    public fun asQuantity(): Quantity? = this as? Quantity

    public fun asRange(): Range? = this as? Range

    public fun asRatio(): Ratio? = this as? Ratio

    public fun asReference(): Reference? = this as? Reference

    public fun asSampledData(): SampledData? = this as? SampledData

    public fun asSignature(): Signature? = this as? Signature

    public fun asTiming(): Timing? = this as? Timing

    public fun asContactDetail(): ContactDetail? = this as? ContactDetail

    public fun asContributor(): Contributor? = this as? Contributor

    public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

    public fun asExpression(): Expression? = this as? Expression

    public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

    public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

    public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

    public fun asUsageContext(): UsageContext? = this as? UsageContext

    public fun asDosage(): Dosage? = this as? Dosage

    public fun asMeta(): Meta? = this as? Meta

    public data class Base64Binary(public val `value`: com.google.fhir.model.r4.Base64Binary) :
      Fixed

    public data class Boolean(public val `value`: com.google.fhir.model.r4.Boolean) : Fixed

    public data class Canonical(public val `value`: com.google.fhir.model.r4.Canonical) : Fixed

    public data class Code(public val `value`: com.google.fhir.model.r4.Code) : Fixed

    public data class Date(public val `value`: com.google.fhir.model.r4.Date) : Fixed

    public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : Fixed

    public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : Fixed

    public data class Id(public val `value`: com.google.fhir.model.r4.Id) : Fixed

    public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : Fixed

    public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : Fixed

    public data class Markdown(public val `value`: com.google.fhir.model.r4.Markdown) : Fixed

    public data class Oid(public val `value`: com.google.fhir.model.r4.Oid) : Fixed

    public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) : Fixed

    public data class String(public val `value`: com.google.fhir.model.r4.String) : Fixed

    public data class Time(public val `value`: com.google.fhir.model.r4.Time) : Fixed

    public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) : Fixed

    public data class Uri(public val `value`: com.google.fhir.model.r4.Uri) : Fixed

    public data class Url(public val `value`: com.google.fhir.model.r4.Url) : Fixed

    public data class Uuid(public val `value`: com.google.fhir.model.r4.Uuid) : Fixed

    public data class Address(public val `value`: com.google.fhir.model.r4.Address) : Fixed

    public data class Age(public val `value`: com.google.fhir.model.r4.Age) : Fixed

    public data class Annotation(public val `value`: com.google.fhir.model.r4.Annotation) : Fixed

    public data class Attachment(public val `value`: com.google.fhir.model.r4.Attachment) : Fixed

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4.CodeableConcept
    ) : Fixed

    public data class Coding(public val `value`: com.google.fhir.model.r4.Coding) : Fixed

    public data class ContactPoint(public val `value`: com.google.fhir.model.r4.ContactPoint) :
      Fixed

    public data class Count(public val `value`: com.google.fhir.model.r4.Count) : Fixed

    public data class Distance(public val `value`: com.google.fhir.model.r4.Distance) : Fixed

    public data class Duration(public val `value`: com.google.fhir.model.r4.Duration) : Fixed

    public data class HumanName(public val `value`: com.google.fhir.model.r4.HumanName) : Fixed

    public data class Identifier(public val `value`: com.google.fhir.model.r4.Identifier) : Fixed

    public data class Money(public val `value`: com.google.fhir.model.r4.Money) : Fixed

    public data class Period(public val `value`: com.google.fhir.model.r4.Period) : Fixed

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Fixed

    public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Fixed

    public data class Ratio(public val `value`: com.google.fhir.model.r4.Ratio) : Fixed

    public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) : Fixed

    public data class SampledData(public val `value`: com.google.fhir.model.r4.SampledData) : Fixed

    public data class Signature(public val `value`: com.google.fhir.model.r4.Signature) : Fixed

    public data class Timing(public val `value`: com.google.fhir.model.r4.Timing) : Fixed

    public data class ContactDetail(public val `value`: com.google.fhir.model.r4.ContactDetail) :
      Fixed

    public data class Contributor(public val `value`: com.google.fhir.model.r4.Contributor) : Fixed

    public data class DataRequirement(
      public val `value`: com.google.fhir.model.r4.DataRequirement
    ) : Fixed

    public data class Expression(public val `value`: com.google.fhir.model.r4.Expression) : Fixed

    public data class ParameterDefinition(
      public val `value`: com.google.fhir.model.r4.ParameterDefinition
    ) : Fixed

    public data class RelatedArtifact(
      public val `value`: com.google.fhir.model.r4.RelatedArtifact
    ) : Fixed

    public data class TriggerDefinition(
      public val `value`: com.google.fhir.model.r4.TriggerDefinition
    ) : Fixed

    public data class UsageContext(public val `value`: com.google.fhir.model.r4.UsageContext) :
      Fixed

    public data class Dosage(public val `value`: com.google.fhir.model.r4.Dosage) : Fixed

    public data class Meta(public val `value`: com.google.fhir.model.r4.Meta) : Fixed

    public companion object {
      internal fun from(
        base64BinaryValue: com.google.fhir.model.r4.Base64Binary?,
        booleanValue: com.google.fhir.model.r4.Boolean?,
        canonicalValue: com.google.fhir.model.r4.Canonical?,
        codeValue: com.google.fhir.model.r4.Code?,
        dateValue: com.google.fhir.model.r4.Date?,
        dateTimeValue: com.google.fhir.model.r4.DateTime?,
        decimalValue: com.google.fhir.model.r4.Decimal?,
        idValue: com.google.fhir.model.r4.Id?,
        instantValue: com.google.fhir.model.r4.Instant?,
        integerValue: com.google.fhir.model.r4.Integer?,
        markdownValue: com.google.fhir.model.r4.Markdown?,
        oidValue: com.google.fhir.model.r4.Oid?,
        positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
        stringValue: com.google.fhir.model.r4.String?,
        timeValue: com.google.fhir.model.r4.Time?,
        unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
        uriValue: com.google.fhir.model.r4.Uri?,
        urlValue: com.google.fhir.model.r4.Url?,
        uuidValue: com.google.fhir.model.r4.Uuid?,
        addressValue: com.google.fhir.model.r4.Address?,
        ageValue: com.google.fhir.model.r4.Age?,
        annotationValue: com.google.fhir.model.r4.Annotation?,
        attachmentValue: com.google.fhir.model.r4.Attachment?,
        codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
        codingValue: com.google.fhir.model.r4.Coding?,
        contactPointValue: com.google.fhir.model.r4.ContactPoint?,
        countValue: com.google.fhir.model.r4.Count?,
        distanceValue: com.google.fhir.model.r4.Distance?,
        durationValue: com.google.fhir.model.r4.Duration?,
        humanNameValue: com.google.fhir.model.r4.HumanName?,
        identifierValue: com.google.fhir.model.r4.Identifier?,
        moneyValue: com.google.fhir.model.r4.Money?,
        periodValue: com.google.fhir.model.r4.Period?,
        quantityValue: com.google.fhir.model.r4.Quantity?,
        rangeValue: com.google.fhir.model.r4.Range?,
        ratioValue: com.google.fhir.model.r4.Ratio?,
        referenceValue: com.google.fhir.model.r4.Reference?,
        sampledDataValue: com.google.fhir.model.r4.SampledData?,
        signatureValue: com.google.fhir.model.r4.Signature?,
        timingValue: com.google.fhir.model.r4.Timing?,
        contactDetailValue: com.google.fhir.model.r4.ContactDetail?,
        contributorValue: com.google.fhir.model.r4.Contributor?,
        dataRequirementValue: com.google.fhir.model.r4.DataRequirement?,
        expressionValue: com.google.fhir.model.r4.Expression?,
        parameterDefinitionValue: com.google.fhir.model.r4.ParameterDefinition?,
        relatedArtifactValue: com.google.fhir.model.r4.RelatedArtifact?,
        triggerDefinitionValue: com.google.fhir.model.r4.TriggerDefinition?,
        usageContextValue: com.google.fhir.model.r4.UsageContext?,
        dosageValue: com.google.fhir.model.r4.Dosage?,
        metaValue: com.google.fhir.model.r4.Meta?,
      ): Fixed? {
        if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
        if (booleanValue != null) return Boolean(booleanValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        if (codeValue != null) return Code(codeValue)
        if (dateValue != null) return Date(dateValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (decimalValue != null) return Decimal(decimalValue)
        if (idValue != null) return Id(idValue)
        if (instantValue != null) return Instant(instantValue)
        if (integerValue != null) return Integer(integerValue)
        if (markdownValue != null) return Markdown(markdownValue)
        if (oidValue != null) return Oid(oidValue)
        if (positiveIntValue != null) return PositiveInt(positiveIntValue)
        if (stringValue != null) return String(stringValue)
        if (timeValue != null) return Time(timeValue)
        if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
        if (uriValue != null) return Uri(uriValue)
        if (urlValue != null) return Url(urlValue)
        if (uuidValue != null) return Uuid(uuidValue)
        if (addressValue != null) return Address(addressValue)
        if (ageValue != null) return Age(ageValue)
        if (annotationValue != null) return Annotation(annotationValue)
        if (attachmentValue != null) return Attachment(attachmentValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (codingValue != null) return Coding(codingValue)
        if (contactPointValue != null) return ContactPoint(contactPointValue)
        if (countValue != null) return Count(countValue)
        if (distanceValue != null) return Distance(distanceValue)
        if (durationValue != null) return Duration(durationValue)
        if (humanNameValue != null) return HumanName(humanNameValue)
        if (identifierValue != null) return Identifier(identifierValue)
        if (moneyValue != null) return Money(moneyValue)
        if (periodValue != null) return Period(periodValue)
        if (quantityValue != null) return Quantity(quantityValue)
        if (rangeValue != null) return Range(rangeValue)
        if (ratioValue != null) return Ratio(ratioValue)
        if (referenceValue != null) return Reference(referenceValue)
        if (sampledDataValue != null) return SampledData(sampledDataValue)
        if (signatureValue != null) return Signature(signatureValue)
        if (timingValue != null) return Timing(timingValue)
        if (contactDetailValue != null) return ContactDetail(contactDetailValue)
        if (contributorValue != null) return Contributor(contributorValue)
        if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
        if (expressionValue != null) return Expression(expressionValue)
        if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
        if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
        if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
        if (usageContextValue != null) return UsageContext(usageContextValue)
        if (dosageValue != null) return Dosage(dosageValue)
        if (metaValue != null) return Meta(metaValue)
        return null
      }
    }
  }

  @Serializable(with = ElementDefinitionPatternSerializer::class)
  public sealed interface Pattern {
    public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asCanonical(): Canonical? = this as? Canonical

    public fun asCode(): Code? = this as? Code

    public fun asDate(): Date? = this as? Date

    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asDecimal(): Decimal? = this as? Decimal

    public fun asId(): Id? = this as? Id

    public fun asInstant(): Instant? = this as? Instant

    public fun asInteger(): Integer? = this as? Integer

    public fun asMarkdown(): Markdown? = this as? Markdown

    public fun asOid(): Oid? = this as? Oid

    public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

    public fun asString(): String? = this as? String

    public fun asTime(): Time? = this as? Time

    public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

    public fun asUri(): Uri? = this as? Uri

    public fun asUrl(): Url? = this as? Url

    public fun asUuid(): Uuid? = this as? Uuid

    public fun asAddress(): Address? = this as? Address

    public fun asAge(): Age? = this as? Age

    public fun asAnnotation(): Annotation? = this as? Annotation

    public fun asAttachment(): Attachment? = this as? Attachment

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asCoding(): Coding? = this as? Coding

    public fun asContactPoint(): ContactPoint? = this as? ContactPoint

    public fun asCount(): Count? = this as? Count

    public fun asDistance(): Distance? = this as? Distance

    public fun asDuration(): Duration? = this as? Duration

    public fun asHumanName(): HumanName? = this as? HumanName

    public fun asIdentifier(): Identifier? = this as? Identifier

    public fun asMoney(): Money? = this as? Money

    public fun asPeriod(): Period? = this as? Period

    public fun asQuantity(): Quantity? = this as? Quantity

    public fun asRange(): Range? = this as? Range

    public fun asRatio(): Ratio? = this as? Ratio

    public fun asReference(): Reference? = this as? Reference

    public fun asSampledData(): SampledData? = this as? SampledData

    public fun asSignature(): Signature? = this as? Signature

    public fun asTiming(): Timing? = this as? Timing

    public fun asContactDetail(): ContactDetail? = this as? ContactDetail

    public fun asContributor(): Contributor? = this as? Contributor

    public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

    public fun asExpression(): Expression? = this as? Expression

    public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

    public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

    public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

    public fun asUsageContext(): UsageContext? = this as? UsageContext

    public fun asDosage(): Dosage? = this as? Dosage

    public fun asMeta(): Meta? = this as? Meta

    public data class Base64Binary(public val `value`: com.google.fhir.model.r4.Base64Binary) :
      Pattern

    public data class Boolean(public val `value`: com.google.fhir.model.r4.Boolean) : Pattern

    public data class Canonical(public val `value`: com.google.fhir.model.r4.Canonical) : Pattern

    public data class Code(public val `value`: com.google.fhir.model.r4.Code) : Pattern

    public data class Date(public val `value`: com.google.fhir.model.r4.Date) : Pattern

    public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : Pattern

    public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : Pattern

    public data class Id(public val `value`: com.google.fhir.model.r4.Id) : Pattern

    public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : Pattern

    public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : Pattern

    public data class Markdown(public val `value`: com.google.fhir.model.r4.Markdown) : Pattern

    public data class Oid(public val `value`: com.google.fhir.model.r4.Oid) : Pattern

    public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) :
      Pattern

    public data class String(public val `value`: com.google.fhir.model.r4.String) : Pattern

    public data class Time(public val `value`: com.google.fhir.model.r4.Time) : Pattern

    public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) :
      Pattern

    public data class Uri(public val `value`: com.google.fhir.model.r4.Uri) : Pattern

    public data class Url(public val `value`: com.google.fhir.model.r4.Url) : Pattern

    public data class Uuid(public val `value`: com.google.fhir.model.r4.Uuid) : Pattern

    public data class Address(public val `value`: com.google.fhir.model.r4.Address) : Pattern

    public data class Age(public val `value`: com.google.fhir.model.r4.Age) : Pattern

    public data class Annotation(public val `value`: com.google.fhir.model.r4.Annotation) : Pattern

    public data class Attachment(public val `value`: com.google.fhir.model.r4.Attachment) : Pattern

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4.CodeableConcept
    ) : Pattern

    public data class Coding(public val `value`: com.google.fhir.model.r4.Coding) : Pattern

    public data class ContactPoint(public val `value`: com.google.fhir.model.r4.ContactPoint) :
      Pattern

    public data class Count(public val `value`: com.google.fhir.model.r4.Count) : Pattern

    public data class Distance(public val `value`: com.google.fhir.model.r4.Distance) : Pattern

    public data class Duration(public val `value`: com.google.fhir.model.r4.Duration) : Pattern

    public data class HumanName(public val `value`: com.google.fhir.model.r4.HumanName) : Pattern

    public data class Identifier(public val `value`: com.google.fhir.model.r4.Identifier) : Pattern

    public data class Money(public val `value`: com.google.fhir.model.r4.Money) : Pattern

    public data class Period(public val `value`: com.google.fhir.model.r4.Period) : Pattern

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Pattern

    public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Pattern

    public data class Ratio(public val `value`: com.google.fhir.model.r4.Ratio) : Pattern

    public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) : Pattern

    public data class SampledData(public val `value`: com.google.fhir.model.r4.SampledData) :
      Pattern

    public data class Signature(public val `value`: com.google.fhir.model.r4.Signature) : Pattern

    public data class Timing(public val `value`: com.google.fhir.model.r4.Timing) : Pattern

    public data class ContactDetail(public val `value`: com.google.fhir.model.r4.ContactDetail) :
      Pattern

    public data class Contributor(public val `value`: com.google.fhir.model.r4.Contributor) :
      Pattern

    public data class DataRequirement(
      public val `value`: com.google.fhir.model.r4.DataRequirement
    ) : Pattern

    public data class Expression(public val `value`: com.google.fhir.model.r4.Expression) : Pattern

    public data class ParameterDefinition(
      public val `value`: com.google.fhir.model.r4.ParameterDefinition
    ) : Pattern

    public data class RelatedArtifact(
      public val `value`: com.google.fhir.model.r4.RelatedArtifact
    ) : Pattern

    public data class TriggerDefinition(
      public val `value`: com.google.fhir.model.r4.TriggerDefinition
    ) : Pattern

    public data class UsageContext(public val `value`: com.google.fhir.model.r4.UsageContext) :
      Pattern

    public data class Dosage(public val `value`: com.google.fhir.model.r4.Dosage) : Pattern

    public data class Meta(public val `value`: com.google.fhir.model.r4.Meta) : Pattern

    public companion object {
      internal fun from(
        base64BinaryValue: com.google.fhir.model.r4.Base64Binary?,
        booleanValue: com.google.fhir.model.r4.Boolean?,
        canonicalValue: com.google.fhir.model.r4.Canonical?,
        codeValue: com.google.fhir.model.r4.Code?,
        dateValue: com.google.fhir.model.r4.Date?,
        dateTimeValue: com.google.fhir.model.r4.DateTime?,
        decimalValue: com.google.fhir.model.r4.Decimal?,
        idValue: com.google.fhir.model.r4.Id?,
        instantValue: com.google.fhir.model.r4.Instant?,
        integerValue: com.google.fhir.model.r4.Integer?,
        markdownValue: com.google.fhir.model.r4.Markdown?,
        oidValue: com.google.fhir.model.r4.Oid?,
        positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
        stringValue: com.google.fhir.model.r4.String?,
        timeValue: com.google.fhir.model.r4.Time?,
        unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
        uriValue: com.google.fhir.model.r4.Uri?,
        urlValue: com.google.fhir.model.r4.Url?,
        uuidValue: com.google.fhir.model.r4.Uuid?,
        addressValue: com.google.fhir.model.r4.Address?,
        ageValue: com.google.fhir.model.r4.Age?,
        annotationValue: com.google.fhir.model.r4.Annotation?,
        attachmentValue: com.google.fhir.model.r4.Attachment?,
        codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
        codingValue: com.google.fhir.model.r4.Coding?,
        contactPointValue: com.google.fhir.model.r4.ContactPoint?,
        countValue: com.google.fhir.model.r4.Count?,
        distanceValue: com.google.fhir.model.r4.Distance?,
        durationValue: com.google.fhir.model.r4.Duration?,
        humanNameValue: com.google.fhir.model.r4.HumanName?,
        identifierValue: com.google.fhir.model.r4.Identifier?,
        moneyValue: com.google.fhir.model.r4.Money?,
        periodValue: com.google.fhir.model.r4.Period?,
        quantityValue: com.google.fhir.model.r4.Quantity?,
        rangeValue: com.google.fhir.model.r4.Range?,
        ratioValue: com.google.fhir.model.r4.Ratio?,
        referenceValue: com.google.fhir.model.r4.Reference?,
        sampledDataValue: com.google.fhir.model.r4.SampledData?,
        signatureValue: com.google.fhir.model.r4.Signature?,
        timingValue: com.google.fhir.model.r4.Timing?,
        contactDetailValue: com.google.fhir.model.r4.ContactDetail?,
        contributorValue: com.google.fhir.model.r4.Contributor?,
        dataRequirementValue: com.google.fhir.model.r4.DataRequirement?,
        expressionValue: com.google.fhir.model.r4.Expression?,
        parameterDefinitionValue: com.google.fhir.model.r4.ParameterDefinition?,
        relatedArtifactValue: com.google.fhir.model.r4.RelatedArtifact?,
        triggerDefinitionValue: com.google.fhir.model.r4.TriggerDefinition?,
        usageContextValue: com.google.fhir.model.r4.UsageContext?,
        dosageValue: com.google.fhir.model.r4.Dosage?,
        metaValue: com.google.fhir.model.r4.Meta?,
      ): Pattern? {
        if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
        if (booleanValue != null) return Boolean(booleanValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        if (codeValue != null) return Code(codeValue)
        if (dateValue != null) return Date(dateValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (decimalValue != null) return Decimal(decimalValue)
        if (idValue != null) return Id(idValue)
        if (instantValue != null) return Instant(instantValue)
        if (integerValue != null) return Integer(integerValue)
        if (markdownValue != null) return Markdown(markdownValue)
        if (oidValue != null) return Oid(oidValue)
        if (positiveIntValue != null) return PositiveInt(positiveIntValue)
        if (stringValue != null) return String(stringValue)
        if (timeValue != null) return Time(timeValue)
        if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
        if (uriValue != null) return Uri(uriValue)
        if (urlValue != null) return Url(urlValue)
        if (uuidValue != null) return Uuid(uuidValue)
        if (addressValue != null) return Address(addressValue)
        if (ageValue != null) return Age(ageValue)
        if (annotationValue != null) return Annotation(annotationValue)
        if (attachmentValue != null) return Attachment(attachmentValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (codingValue != null) return Coding(codingValue)
        if (contactPointValue != null) return ContactPoint(contactPointValue)
        if (countValue != null) return Count(countValue)
        if (distanceValue != null) return Distance(distanceValue)
        if (durationValue != null) return Duration(durationValue)
        if (humanNameValue != null) return HumanName(humanNameValue)
        if (identifierValue != null) return Identifier(identifierValue)
        if (moneyValue != null) return Money(moneyValue)
        if (periodValue != null) return Period(periodValue)
        if (quantityValue != null) return Quantity(quantityValue)
        if (rangeValue != null) return Range(rangeValue)
        if (ratioValue != null) return Ratio(ratioValue)
        if (referenceValue != null) return Reference(referenceValue)
        if (sampledDataValue != null) return SampledData(sampledDataValue)
        if (signatureValue != null) return Signature(signatureValue)
        if (timingValue != null) return Timing(timingValue)
        if (contactDetailValue != null) return ContactDetail(contactDetailValue)
        if (contributorValue != null) return Contributor(contributorValue)
        if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
        if (expressionValue != null) return Expression(expressionValue)
        if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
        if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
        if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
        if (usageContextValue != null) return UsageContext(usageContextValue)
        if (dosageValue != null) return Dosage(dosageValue)
        if (metaValue != null) return Meta(metaValue)
        return null
      }
    }
  }

  @Serializable(with = ElementDefinitionMinValueSerializer::class)
  public sealed interface MinValue {
    public fun asDate(): Date? = this as? Date

    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asInstant(): Instant? = this as? Instant

    public fun asTime(): Time? = this as? Time

    public fun asDecimal(): Decimal? = this as? Decimal

    public fun asInteger(): Integer? = this as? Integer

    public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

    public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

    public fun asQuantity(): Quantity? = this as? Quantity

    public data class Date(public val `value`: com.google.fhir.model.r4.Date) : MinValue

    public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : MinValue

    public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : MinValue

    public data class Time(public val `value`: com.google.fhir.model.r4.Time) : MinValue

    public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : MinValue

    public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : MinValue

    public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) :
      MinValue

    public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) :
      MinValue

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : MinValue

    public companion object {
      internal fun from(
        dateValue: com.google.fhir.model.r4.Date?,
        dateTimeValue: com.google.fhir.model.r4.DateTime?,
        instantValue: com.google.fhir.model.r4.Instant?,
        timeValue: com.google.fhir.model.r4.Time?,
        decimalValue: com.google.fhir.model.r4.Decimal?,
        integerValue: com.google.fhir.model.r4.Integer?,
        positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
        unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
        quantityValue: com.google.fhir.model.r4.Quantity?,
      ): MinValue? {
        if (dateValue != null) return Date(dateValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (instantValue != null) return Instant(instantValue)
        if (timeValue != null) return Time(timeValue)
        if (decimalValue != null) return Decimal(decimalValue)
        if (integerValue != null) return Integer(integerValue)
        if (positiveIntValue != null) return PositiveInt(positiveIntValue)
        if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
        if (quantityValue != null) return Quantity(quantityValue)
        return null
      }
    }
  }

  @Serializable(with = ElementDefinitionMaxValueSerializer::class)
  public sealed interface MaxValue {
    public fun asDate(): Date? = this as? Date

    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asInstant(): Instant? = this as? Instant

    public fun asTime(): Time? = this as? Time

    public fun asDecimal(): Decimal? = this as? Decimal

    public fun asInteger(): Integer? = this as? Integer

    public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

    public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

    public fun asQuantity(): Quantity? = this as? Quantity

    public data class Date(public val `value`: com.google.fhir.model.r4.Date) : MaxValue

    public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : MaxValue

    public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : MaxValue

    public data class Time(public val `value`: com.google.fhir.model.r4.Time) : MaxValue

    public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : MaxValue

    public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : MaxValue

    public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) :
      MaxValue

    public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) :
      MaxValue

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : MaxValue

    public companion object {
      internal fun from(
        dateValue: com.google.fhir.model.r4.Date?,
        dateTimeValue: com.google.fhir.model.r4.DateTime?,
        instantValue: com.google.fhir.model.r4.Instant?,
        timeValue: com.google.fhir.model.r4.Time?,
        decimalValue: com.google.fhir.model.r4.Decimal?,
        integerValue: com.google.fhir.model.r4.Integer?,
        positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
        unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
        quantityValue: com.google.fhir.model.r4.Quantity?,
      ): MaxValue? {
        if (dateValue != null) return Date(dateValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (instantValue != null) return Instant(instantValue)
        if (timeValue != null) return Time(timeValue)
        if (decimalValue != null) return Decimal(decimalValue)
        if (integerValue != null) return Integer(integerValue)
        if (positiveIntValue != null) return PositiveInt(positiveIntValue)
        if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
        if (quantityValue != null) return Quantity(quantityValue)
        return null
      }
    }
  }

  public open class Builder(
    /**
     * The path identifies the element and is expressed as a "."-separated list of ancestor
     * elements, beginning with the name of the resource or extension.
     */
    public open var path: String.Builder
  ) {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: kotlin.String? = null

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
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

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
    public open var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * Codes that define how this element is represented in instances, when the deviation varies
     * from the normal case.
     *
     * In resources, this is rarely used except for special cases where the representation deviates
     * from the normal, and can only be done in the base standard (and profiles must reproduce what
     * the base standard does). This element is used quite commonly in Logical models when the
     * logical models represent a specific serialization format (e.g. CDA, v2 etc.).
     */
    public open var representation: MutableList<Enumeration<PropertyRepresentation>> =
      mutableListOf()

    /**
     * The name of this element definition slice, when slicing is working. The name must be a token
     * with no dots or spaces. This is a unique name referring to a specific set of constraints
     * applied to this element, used to provide a name to different slices of the same element.
     *
     * The name SHALL be unique within the structure within the context of the constrained resource
     * element. (Though to avoid confusion, uniqueness across all elements is recommended.).
     */
    public open var sliceName: String.Builder? = null

    /**
     * If true, indicates that this slice definition is constraining a slice definition with the
     * same name in an inherited profile. If false, the slice is not overriding any slice in an
     * inherited profile. If missing, the slice might or might not be overriding a slice in an
     * inherited profile, depending on the sliceName.
     *
     * If set to true, an ancestor profile SHALL have a slicing definition with this name. If set to
     * false, no ancestor profile is permitted to have a slicing definition with this name.
     */
    public open var sliceIsConstraining: Boolean.Builder? = null

    /**
     * A single preferred label which is the text to display beside the element indicating its
     * meaning or to use to prompt for the element in a user display or form.
     *
     * See also the extension
     * (http://hl7.org/fhir/StructureDefinition/elementdefinition-question)[extension-elementdefinition-question.html].
     */
    public open var label: String.Builder? = null

    /**
     * A code that has the same meaning as the element in a particular terminology.
     *
     * The concept SHALL be properly aligned with the data element definition and other constraints,
     * as defined in the code system, including relationships, of any code listed here. Where
     * multiple codes exist in a terminology that could correspond to the data element, the most
     * granular code(s) should be selected, so long as they are not more restrictive than the data
     * element itself. The mappings may be used to provide more or less granular or structured
     * equivalences in the code system.
     */
    public open var code: MutableList<Coding.Builder> = mutableListOf()

    /**
     * Indicates that the element is sliced into a set of alternative definitions (i.e. in a
     * structure definition, there are multiple different constraints on a single element in the
     * base resource). Slicing can be used in any resource that has cardinality ..* on the base
     * resource, or any resource with a choice of types. The set of slices is any elements that come
     * after this in the element sequence that have the same path, until a shorter path occurs (the
     * shorter path terminates the set).
     *
     * The first element in the sequence, the one that carries the slicing, is the definition that
     * applies to all the slices. This is based on the unconstrained element, but can apply any
     * constraints as appropriate. This may include the common constraints on the children of the
     * element.
     */
    public open var slicing: Slicing.Builder? = null

    /**
     * A concise description of what this element means (e.g. for use in autogenerated summaries).
     *
     * It is easy for a different short definition to change the meaning of an element and this can
     * have nasty downstream consequences. Please be careful when providing short definitions in a
     * profile.
     */
    public open var short: String.Builder? = null

    /**
     * Provides a complete explanation of the meaning of the data element for human readability. For
     * the case of elements derived from existing elements (e.g. constraints), the definition SHALL
     * be consistent with the base definition, but convey the meaning of the element in the
     * particular context of use of the resource. (Note: The text you are reading is specified in
     * ElementDefinition.definition).
     *
     * It is easy for a different definition to change the meaning of an element and this can have
     * nasty downstream consequences. Please be careful when providing definitions in a profile.
     */
    public open var definition: Markdown.Builder? = null

    /**
     * Explanatory notes and implementation guidance about the data element, including notes about
     * how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading
     * is specified in ElementDefinition.comment).
     *
     * If it is possible to capture usage rules using constraints, that mechanism should be used in
     * preference to this element.
     */
    public open var comment: Markdown.Builder? = null

    /**
     * This element is for traceability of why the element was created and why the constraints exist
     * as they do. This may be used to point to source materials or specifications that drove the
     * structure of this element.
     *
     * This element does not describe the usage of the element (that's done in comments), rather
     * it's for traceability of *why* the element is either needed or why the constraints exist as
     * they do. This may be used to point to source materials or specifications that drove the
     * structure of this data element.
     */
    public open var requirements: Markdown.Builder? = null

    /** Identifies additional names by which this element might also be known. */
    public open var alias: MutableList<String.Builder> = mutableListOf()

    /** The minimum number of times this element SHALL appear in the instance. */
    public open var min: UnsignedInt.Builder? = null

    /** The maximum number of times this element is permitted to appear in the instance. */
    public open var max: String.Builder? = null

    /**
     * Information about the base definition of the element, provided to make it unnecessary for
     * tools to trace the deviation of the element through the derived and related profiles. When
     * the element definition is not the original definition of an element - i.g. either in a
     * constraint on another type, or for elements from a super type in a snap shot - then the
     * information in provided in the element definition may be different to the base definition. On
     * the original definition of the element, it will be same.
     *
     * The base information does not carry any information that could not be determined from the
     * path and related profiles, but making this determination requires both that the related
     * profiles are available, and that the algorithm to determine them be available. For tooling
     * simplicity, the base information must always be populated in element definitions in snap
     * shots, even if it is the same.
     */
    public open var base: Base.Builder? = null

    /**
     * Identifies an element defined elsewhere in the definition whose content rules should be
     * applied to the current element. ContentReferences bring across all the rules that are in the
     * ElementDefinition for the element, including definitions, cardinality constraints, bindings,
     * invariants etc.
     *
     * ContentReferences can only be defined in specializations, not constrained types, and they
     * cannot be changed and always reference the non-constrained definition.
     */
    public open var contentReference: Uri.Builder? = null

    /**
     * The data type or resource that the value of this element is permitted to be.
     *
     * The Type of the element can be left blank in a differential constraint, in which case the
     * type is inherited from the resource. Abstract types are not permitted to appear as a type
     * when multiple types are listed. (I.e. Abstract types cannot be part of a choice).
     */
    public open var type: MutableList<Type.Builder> = mutableListOf()

    /**
     * The value that should be used if there is no value stated in the instance (e.g. 'if not
     * otherwise specified, the abstract is false').
     *
     * Specifying a default value means that the property can never been unknown - it must always
     * have a value. Further, the default value can never be changed, or changed in constraints on
     * content models. Defining default values creates many difficulties in implementation (e.g.
     * when is a value missing?). For these reasons, default values are (and should be) used
     * extremely sparingly.
     *
     * No default values are ever defined in the FHIR specification, nor can they be defined in
     * constraints ("profiles") on data types or resources. This element only exists so that default
     * values may be defined in logical models.
     */
    public open var defaultValue: DefaultValue? = null

    /**
     * The Implicit meaning that is to be understood when this element is missing (e.g. 'when this
     * element is missing, the period is ongoing').
     *
     * Implicit meanings for missing values can only be specified on a resource, data type, or
     * extension definition, and never in a profile that applies to one of these. An implicit
     * meaning for a missing value can never be changed, and specifying one has the consequence that
     * constraining its use in profiles eliminates use cases as possibilities, not merely moving
     * them out of scope.
     */
    public open var meaningWhenMissing: Markdown.Builder? = null

    /**
     * If present, indicates that the order of the repeating element has meaning and describes what
     * that meaning is. If absent, it means that the order of the element has no meaning.
     *
     * This element can only be asserted on repeating elements and can only be introduced when
     * defining resources or data types. It can be further refined profiled elements but if absent
     * in the base type, a profile cannot assert meaning.
     */
    public open var orderMeaning: String.Builder? = null

    /**
     * Specifies a value that SHALL be exactly the value for this element in the instance. For
     * purposes of comparison, non-significant whitespace is ignored, and all values must be an
     * exact match (case and accent sensitive). Missing elements/attributes must also be missing.
     *
     * This is not recommended for Coding and CodeableConcept since these often have highly
     * contextual properties such as version or display.
     */
    public open var fixed: Fixed? = null

    /**
     * Specifies a value that the value in the instance SHALL follow - that is, any value in the
     * pattern must be found in the instance. Other additional values may be found too. This is
     * effectively constraint by example.
     *
     * When pattern[x] is used to constrain a primitive, it means that the value provided in the
     * pattern[x] must match the instance value exactly.
     *
     * When pattern[x] is used to constrain an array, it means that each element provided in the
     * pattern[x] array must (recursively) match at least one element from the instance array.
     *
     * When pattern[x] is used to constrain a complex object, it means that each property in the
     * pattern must be present in the complex object, and its value must recursively match -- i.e.,
     * 1. If primitive: it must match exactly the pattern value
     * 2. If a complex object: it must match (recursively) the pattern value
     * 3. If an array: it must match (recursively) the pattern value.
     *
     * Mostly used for fixing values of CodeableConcept. In general, pattern[x] is not intended for
     * use with primitive types, where is has the same meaning as fixed[x].
     */
    public open var pattern: Pattern? = null

    /**
     * A sample value for this element demonstrating the type of information that would typically be
     * found in the element.
     *
     * Examples will most commonly be present for data where it's not implicitly obvious from either
     * the data type or value set what the values might be. (I.e. Example values for dates or
     * quantities would generally be unnecessary.) If the example value is fully populated, the
     * publication tool can generate an instance automatically.
     */
    public open var example: MutableList<Example.Builder> = mutableListOf()

    /**
     * The minimum allowed value for the element. The value is inclusive. This is allowed for the
     * types date, dateTime, instant, time, decimal, integer, and Quantity.
     *
     * Except for date/date/instant, the type of the minValue[x] SHALL be the same as the specified
     * type of the element. For the date/dateTime/instant values, the type of minValue[x] SHALL be
     * either the same, or a [Duration](datatypes.html#Duration) which specifies a relative time
     * limit to the current time. The duration value is positive, and is subtracted from the current
     * clock to determine the minimum allowable value. A minimum value for a Quantity is interpreted
     * as an canonical minimum - e.g. you cannot provide 100mg if the minimum value is 10g.
     */
    public open var minValue: MinValue? = null

    /**
     * The maximum allowed value for the element. The value is inclusive. This is allowed for the
     * types date, dateTime, instant, time, decimal, integer, and Quantity.
     *
     * Except for date/date/instant, the type of the maxValue[x] SHALL be the same as the specified
     * type of the element. For the date/dateTime/instant values, the type of maxValue[x] SHALL be
     * either the same, or a [Duration](datatypes.html#Duration) which specifies a relative time
     * limit to the current time. The duration value is positive, and is added to the current clock
     * to determine the maximum allowable value. A maximum value for a Quantity is interpreted as an
     * canonical maximum - e.g. you cannot provide 10g if the maximum value is 50mg.
     */
    public open var maxValue: MaxValue? = null

    /**
     * Indicates the maximum length in characters that is permitted to be present in conformant
     * instances and which is expected to be supported by conformant consumers that support the
     * element.
     *
     * Receivers are not required to reject instances that exceed the maximum length. The full
     * length could be stored. In some cases, data might be truncated, though truncation should be
     * undertaken with care and an understanding of the consequences of doing so. If not specified,
     * there is no conformance expectation for length support.
     */
    public open var maxLength: Integer.Builder? = null

    /**
     * A reference to an invariant that may make additional statements about the cardinality or
     * value in the instance.
     */
    public open var condition: MutableList<Id.Builder> = mutableListOf()

    /**
     * Formal constraints such as co-occurrence and other constraints that can be computationally
     * evaluated within the context of the instance.
     *
     * Constraints should be declared on the "context" element - the lowest element in the hierarchy
     * that is common to all nodes referenced by the constraint.
     */
    public open var constraint: MutableList<Constraint.Builder> = mutableListOf()

    /**
     * If true, implementations that produce or consume resources SHALL provide "support" for the
     * element in some meaningful way. If false, the element may be ignored and not supported. If
     * false, whether to populate or use the data element in any way is at the discretion of the
     * implementation.
     *
     * "Something useful" is context dependent and impossible to describe in the base FHIR
     * specification. For this reason, tue mustSupport flag is never set to true by the FHIR
     * specification itself - it is only set to true in profiles. A profile on a type can always
     * make musSupport = true if it is false in the base type but cannot make mustSupport = false if
     * it is true in the base type. This is done in [Resource Profiles](profiling.html#mustsupport),
     * where the profile labels an element as mustSupport=true. When a profile does this, it SHALL
     * also make clear exactly what kind of "support" is required, as this can mean many things.
     * Note that an element that has the property IsModifier is not necessarily a "key" element
     * (e.g. one of the important elements to make use of the resource), nor is it automatically
     * mustSupport - however both of these things are more likely to be true for IsModifier elements
     * than for other elements.
     */
    public open var mustSupport: Boolean.Builder? = null

    /**
     * If true, the value of this element affects the interpretation of the element or resource that
     * contains it, and the value of the element cannot be ignored. Typically, this is used for
     * status, negation and qualification codes. The effect of this is that the element cannot be
     * ignored by systems: they SHALL either recognize the element and process it, and/or a
     * pre-determination has been made that it is not relevant to their particular system.
     *
     * Only the definition of an element can set IsModifier true - either the specification itself
     * or where an extension is originally defined. Once set, it cannot be changed in derived
     * profiles. An element/extension that has isModifier=true SHOULD also have a minimum
     * cardinality of 1, so that there is no lack of clarity about what to do if it is missing. If
     * it can be missing, the definition SHALL make the meaning of a missing element clear.
     */
    public open var isModifier: Boolean.Builder? = null

    /**
     * Explains how that element affects the interpretation of the resource or element that contains
     * it.
     */
    public open var isModifierReason: String.Builder? = null

    /**
     * Whether the element should be included if a client requests a search with the parameter
     * _summary=true.
     *
     * Some resources include a set of simple metadata, and some very large data. This element is
     * used to reduce the quantity of data returned in searches. Note that servers may pre-cache
     * summarized resources for optimal performance, so servers might not support per-profile use of
     * the isSummary flag. When a request is made with _summary=true, serailisers only include
     * elements marked as 'isSummary = true'. Other than Attachment.data, all data type properties
     * are included in the summary form. In resource and data type definitions, if an element is at
     * the root or has a parent that is 'mustSupport' and the minimum cardinality is 1 or the
     * element is a modifier, it must be marked as isSummary=true.
     */
    public open var isSummary: Boolean.Builder? = null

    /**
     * Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or
     * the data types (string, uri).
     *
     * For a CodeableConcept, when no codes are allowed - only text, use a binding of strength
     * "required" with a description explaining that no coded values are allowed and what sort of
     * information to put in the "text" element.
     */
    public open var binding: Binding.Builder? = null

    /**
     * Identifies a concept from an external specification that roughly corresponds to this element.
     *
     * Mappings are not necessarily specific enough for safe translation.
     */
    public open var mapping: MutableList<Mapping.Builder> = mutableListOf()

    public open fun build(): ElementDefinition =
      ElementDefinition(
        id = id,
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        path = path.build(),
        representation = representation,
        sliceName = sliceName?.build(),
        sliceIsConstraining = sliceIsConstraining?.build(),
        label = label?.build(),
        code = code.map { it.build() },
        slicing = slicing?.build(),
        short = short?.build(),
        definition = definition?.build(),
        comment = comment?.build(),
        requirements = requirements?.build(),
        alias = alias.map { it.build() },
        min = min?.build(),
        max = max?.build(),
        base = base?.build(),
        contentReference = contentReference?.build(),
        type = type.map { it.build() },
        defaultValue = defaultValue,
        meaningWhenMissing = meaningWhenMissing?.build(),
        orderMeaning = orderMeaning?.build(),
        fixed = fixed,
        pattern = pattern,
        example = example.map { it.build() },
        minValue = minValue,
        maxValue = maxValue,
        maxLength = maxLength?.build(),
        condition = condition.map { it.build() },
        constraint = constraint.map { it.build() },
        mustSupport = mustSupport?.build(),
        isModifier = isModifier?.build(),
        isModifierReason = isModifierReason?.build(),
        isSummary = isSummary?.build(),
        binding = binding?.build(),
        mapping = mapping.map { it.build() },
      )
  }

  /** How slices are interpreted when evaluating an instance. */
  public enum class SlicingRules(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Closed("closed", "http://hl7.org/fhir/resource-slicing-rules", "Closed"),
    Open("open", "http://hl7.org/fhir/resource-slicing-rules", "Open"),
    OpenAtEnd("openAtEnd", "http://hl7.org/fhir/resource-slicing-rules", "Open at End");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SlicingRules =
        when (code) {
          "closed" -> Closed
          "open" -> Open
          "openAtEnd" -> OpenAtEnd
          else -> throw IllegalArgumentException("Unknown code $code for enum SlicingRules")
        }
    }
  }

  /** How an element value is interpreted when discrimination is evaluated. */
  public enum class DiscriminatorType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Value("value", "http://hl7.org/fhir/discriminator-type", "Value"),
    Exists("exists", "http://hl7.org/fhir/discriminator-type", "Exists"),
    Pattern("pattern", "http://hl7.org/fhir/discriminator-type", "Pattern"),
    Type("type", "http://hl7.org/fhir/discriminator-type", "Type"),
    Profile("profile", "http://hl7.org/fhir/discriminator-type", "Profile");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DiscriminatorType =
        when (code) {
          "value" -> Value
          "exists" -> Exists
          "pattern" -> Pattern
          "type" -> Type
          "profile" -> Profile
          else -> throw IllegalArgumentException("Unknown code $code for enum DiscriminatorType")
        }
    }
  }

  /** How resource references can be aggregated. */
  public enum class AggregationMode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Contained("contained", "http://hl7.org/fhir/resource-aggregation-mode", "Contained"),
    Referenced("referenced", "http://hl7.org/fhir/resource-aggregation-mode", "Referenced"),
    Bundled("bundled", "http://hl7.org/fhir/resource-aggregation-mode", "Bundled");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AggregationMode =
        when (code) {
          "contained" -> Contained
          "referenced" -> Referenced
          "bundled" -> Bundled
          else -> throw IllegalArgumentException("Unknown code $code for enum AggregationMode")
        }
    }
  }

  /**
   * Whether a reference needs to be version specific or version independent, or whether either can
   * be used.
   */
  public enum class ReferenceVersionRules(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Either(
      "either",
      "http://hl7.org/fhir/reference-version-rules",
      "Either Specific or independent",
    ),
    Independent(
      "independent",
      "http://hl7.org/fhir/reference-version-rules",
      "Version independent",
    ),
    Specific("specific", "http://hl7.org/fhir/reference-version-rules", "Version Specific");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ReferenceVersionRules =
        when (code) {
          "either" -> Either
          "independent" -> Independent
          "specific" -> Specific
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ReferenceVersionRules")
        }
    }
  }

  /** SHALL applications comply with this constraint? */
  public enum class ConstraintSeverity(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Error("error", "http://hl7.org/fhir/constraint-severity", "Error"),
    Warning("warning", "http://hl7.org/fhir/constraint-severity", "Warning");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ConstraintSeverity =
        when (code) {
          "error" -> Error
          "warning" -> Warning
          else -> throw IllegalArgumentException("Unknown code $code for enum ConstraintSeverity")
        }
    }
  }

  /** How a property is represented when serialized. */
  public enum class PropertyRepresentation(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    XmlAttr("xmlAttr", "http://hl7.org/fhir/property-representation", "XML Attribute"),
    XmlText("xmlText", "http://hl7.org/fhir/property-representation", "XML Text"),
    TypeAttr("typeAttr", "http://hl7.org/fhir/property-representation", "Type Attribute"),
    CdaText("cdaText", "http://hl7.org/fhir/property-representation", "CDA Text Format"),
    Xhtml("xhtml", "http://hl7.org/fhir/property-representation", "XHTML");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): PropertyRepresentation =
        when (code) {
          "xmlAttr" -> XmlAttr
          "xmlText" -> XmlText
          "typeAttr" -> TypeAttr
          "cdaText" -> CdaText
          "xhtml" -> Xhtml
          else ->
            throw IllegalArgumentException("Unknown code $code for enum PropertyRepresentation")
        }
    }
  }
}
