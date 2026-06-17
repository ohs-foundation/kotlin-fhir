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

import dev.ohs.fhir.model.r4.serializers.FamilyMemberHistoryConditionSerializer
import dev.ohs.fhir.model.r4.serializers.FamilyMemberHistorySerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Significant health conditions for a person related to the patient relevant in the context of care
 * for the patient.
 */
@Serializable(with = FamilyMemberHistorySerializer::class)
@SerialName("FamilyMemberHistory")
public data class FamilyMemberHistory(
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
   * Business identifiers assigned to this family member history by the performer or other systems
   * which remain constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this FamilyMemberHistory.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this FamilyMemberHistory.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /**
   * A code specifying the status of the record of the family history of a specific family member.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<FamilyHistoryStatus>,
  /** Describes why the family member's history is not available. */
  public val dataAbsentReason: CodeableConcept? = null,
  /** The person who this history concerns. */
  public val patient: Reference,
  /**
   * The date (and possibly time) when the family member history was recorded or last updated.
   *
   * This should be captured even if the same as the date on the List aggregating the full family
   * history.
   */
  public val date: DateTime? = null,
  /**
   * This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red hair".
   */
  public val name: String? = null,
  /** The type of relationship this person has to the patient (father, mother, brother etc.). */
  public val relationship: CodeableConcept,
  /**
   * The birth sex of the family member.
   *
   * This element should ideally reflect whether the individual is genetically male or female.
   * However, as reported information based on the knowledge of the patient or reporting
   * friend/relative, there may be situations where the reported sex might not be totally accurate.
   * E.g. 'Aunt Sue' might be XY rather than XX. Questions soliciting this information should be
   * phrased to encourage capture of genetic sex where known. However, systems performing analysis
   * should also allow for the possibility of imprecision with this element.
   */
  public val sex: CodeableConcept? = null,
  /** The actual or approximate date of birth of the relative. */
  public val born: Born? = null,
  /**
   * The age of the relative at the time the family member history is recorded.
   *
   * use estimatedAge to indicate whether the age is actual or not.
   */
  public val age: Age? = null,
  /**
   * If true, indicates that the age value specified is an estimated value.
   *
   * This element is labeled as a modifier because the fact that age is estimated can/should change
   * the results of any algorithm that calculates based on the specified age.
   */
  public val estimatedAge: Boolean? = null,
  /**
   * Deceased flag or the actual or approximate age of the relative at the time of death for the
   * family member history record.
   */
  public val deceased: Deceased? = null,
  /**
   * Describes why the family member history occurred in coded or textual form.
   *
   * Textual reasons can be captured using reasonCode.text.
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that justifies
   * this family member history event.
   */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * This property allows a non condition-specific note to the made about the related person.
   * Ideally, the note would be in the condition property, but this is not always possible.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * The significant Conditions (or condition) that the family member had. This is a repeating
   * section to allow a system to represent more than one condition per resource, though there is
   * nothing stopping multiple resources - one per condition.
   */
  public val condition: List<Condition> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          patient.toBuilder(),
          relationship.toBuilder(),
        )
        .apply {
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
          dataAbsentReason = this@with.dataAbsentReason?.toBuilder()
          date = this@with.date?.toBuilder()
          name = this@with.name?.toBuilder()
          sex = this@with.sex?.toBuilder()
          born = this@with.born
          age = this@with.age
          estimatedAge = this@with.estimatedAge?.toBuilder()
          deceased = this@with.deceased
          reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
          reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          condition = this@with.condition.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * The significant Conditions (or condition) that the family member had. This is a repeating
   * section to allow a system to represent more than one condition per resource, though there is
   * nothing stopping multiple resources - one per condition.
   */
  @Serializable(with = FamilyMemberHistoryConditionSerializer::class)
  public data class Condition(
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
     * The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less
     * specific string like 'cancer' depending on how much is known about the condition and the
     * capabilities of the creating system.
     */
    public val code: CodeableConcept,
    /**
     * Indicates what happened following the condition. If the condition resulted in death, deceased
     * date is captured on the relation.
     */
    public val outcome: CodeableConcept? = null,
    /**
     * This condition contributed to the cause of death of the related person. If contributedToDeath
     * is not populated, then it is unknown.
     */
    public val contributedToDeath: Boolean? = null,
    /**
     * Either the age of onset, range of approximate age or descriptive string can be recorded. For
     * conditions with multiple occurrences, this describes the first known occurrence.
     */
    public val onset: Onset? = null,
    /** An area where general notes can be placed about this specific condition. */
    public val note: List<Annotation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          outcome = this@with.outcome?.toBuilder()
          contributedToDeath = this@with.contributedToDeath?.toBuilder()
          onset = this@with.onset
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Onset {
      public fun asAge(): Age? = this as? Age

      public fun asRange(): Range? = this as? Range

      public fun asPeriod(): Period? = this as? Period

      public fun asString(): String? = this as? String

      public data class Age(public val `value`: dev.ohs.fhir.model.r4.Age) : Onset

      public data class Range(public val `value`: dev.ohs.fhir.model.r4.Range) : Onset

      public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Onset

      public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Onset

      public companion object {
        internal fun from(
          ageValue: dev.ohs.fhir.model.r4.Age?,
          rangeValue: dev.ohs.fhir.model.r4.Range?,
          periodValue: dev.ohs.fhir.model.r4.Period?,
          stringValue: dev.ohs.fhir.model.r4.String?,
        ): Onset? {
          if (ageValue != null) return Age(ageValue)
          if (rangeValue != null) return Range(rangeValue)
          if (periodValue != null) return Period(periodValue)
          if (stringValue != null) return String(stringValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less
       * specific string like 'cancer' depending on how much is known about the condition and the
       * capabilities of the creating system.
       */
      public var code: CodeableConcept.Builder
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
       * Indicates what happened following the condition. If the condition resulted in death,
       * deceased date is captured on the relation.
       */
      public var outcome: CodeableConcept.Builder? = null

      /**
       * This condition contributed to the cause of death of the related person. If
       * contributedToDeath is not populated, then it is unknown.
       */
      public var contributedToDeath: Boolean.Builder? = null

      /**
       * Either the age of onset, range of approximate age or descriptive string can be recorded.
       * For conditions with multiple occurrences, this describes the first known occurrence.
       */
      public var onset: Onset? = null

      /** An area where general notes can be placed about this specific condition. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      public fun build(): Condition =
        Condition(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.build(),
          outcome = outcome?.build(),
          contributedToDeath = contributedToDeath?.build(),
          onset = onset,
          note = note.map { it.build() },
        )
    }
  }

  public sealed interface Born {
    public fun asPeriod(): Period? = this as? Period

    public fun asDate(): Date? = this as? Date

    public fun asString(): String? = this as? String

    public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Born

    public data class Date(public val `value`: dev.ohs.fhir.model.r4.Date) : Born

    public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Born

    public companion object {
      internal fun from(
        periodValue: dev.ohs.fhir.model.r4.Period?,
        dateValue: dev.ohs.fhir.model.r4.Date?,
        stringValue: dev.ohs.fhir.model.r4.String?,
      ): Born? {
        if (periodValue != null) return Period(periodValue)
        if (dateValue != null) return Date(dateValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public sealed interface Age {
    public fun asAge(): Age? = this as? Age

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class Age(public val `value`: dev.ohs.fhir.model.r4.Age) : FamilyMemberHistory.Age

    public data class Range(public val `value`: dev.ohs.fhir.model.r4.Range) :
      FamilyMemberHistory.Age

    public data class String(public val `value`: dev.ohs.fhir.model.r4.String) :
      FamilyMemberHistory.Age

    public companion object {
      internal fun from(
        ageValue: dev.ohs.fhir.model.r4.Age?,
        rangeValue: dev.ohs.fhir.model.r4.Range?,
        stringValue: dev.ohs.fhir.model.r4.String?,
      ): FamilyMemberHistory.Age? {
        if (ageValue != null) return Age(ageValue)
        if (rangeValue != null) return Range(rangeValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public sealed interface Deceased {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asAge(): Age? = this as? Age

    public fun asRange(): Range? = this as? Range

    public fun asDate(): Date? = this as? Date

    public fun asString(): String? = this as? String

    public data class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Deceased

    public data class Age(public val `value`: dev.ohs.fhir.model.r4.Age) : Deceased

    public data class Range(public val `value`: dev.ohs.fhir.model.r4.Range) : Deceased

    public data class Date(public val `value`: dev.ohs.fhir.model.r4.Date) : Deceased

    public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Deceased

    public companion object {
      internal fun from(
        booleanValue: dev.ohs.fhir.model.r4.Boolean?,
        ageValue: dev.ohs.fhir.model.r4.Age?,
        rangeValue: dev.ohs.fhir.model.r4.Range?,
        dateValue: dev.ohs.fhir.model.r4.Date?,
        stringValue: dev.ohs.fhir.model.r4.String?,
      ): Deceased? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (ageValue != null) return Age(ageValue)
        if (rangeValue != null) return Range(rangeValue)
        if (dateValue != null) return Date(dateValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A code specifying the status of the record of the family history of a specific family member.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<FamilyHistoryStatus>,
    /** The person who this history concerns. */
    public var patient: Reference.Builder,
    /** The type of relationship this person has to the patient (father, mother, brother etc.). */
    public var relationship: CodeableConcept.Builder,
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
     * Business identifiers assigned to this family member history by the performer or other systems
     * which remain constant as the resource is updated and propagates from server to server.
     *
     * This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
     * adhered to in whole or in part by this FamilyMemberHistory.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this FamilyMemberHistory.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** Describes why the family member's history is not available. */
    public var dataAbsentReason: CodeableConcept.Builder? = null

    /**
     * The date (and possibly time) when the family member history was recorded or last updated.
     *
     * This should be captured even if the same as the date on the List aggregating the full family
     * history.
     */
    public var date: DateTime.Builder? = null

    /**
     * This will either be a name or a description; e.g. "Aunt Susan", "my cousin with the red
     * hair".
     */
    public var name: String.Builder? = null

    /**
     * The birth sex of the family member.
     *
     * This element should ideally reflect whether the individual is genetically male or female.
     * However, as reported information based on the knowledge of the patient or reporting
     * friend/relative, there may be situations where the reported sex might not be totally
     * accurate. E.g. 'Aunt Sue' might be XY rather than XX. Questions soliciting this information
     * should be phrased to encourage capture of genetic sex where known. However, systems
     * performing analysis should also allow for the possibility of imprecision with this element.
     */
    public var sex: CodeableConcept.Builder? = null

    /** The actual or approximate date of birth of the relative. */
    public var born: Born? = null

    /**
     * The age of the relative at the time the family member history is recorded.
     *
     * use estimatedAge to indicate whether the age is actual or not.
     */
    public var age: Age? = null

    /**
     * If true, indicates that the age value specified is an estimated value.
     *
     * This element is labeled as a modifier because the fact that age is estimated can/should
     * change the results of any algorithm that calculates based on the specified age.
     */
    public var estimatedAge: Boolean.Builder? = null

    /**
     * Deceased flag or the actual or approximate age of the relative at the time of death for the
     * family member history record.
     */
    public var deceased: Deceased? = null

    /**
     * Describes why the family member history occurred in coded or textual form.
     *
     * Textual reasons can be captured using reasonCode.text.
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Indicates a Condition, Observation, AllergyIntolerance, or QuestionnaireResponse that
     * justifies this family member history event.
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * This property allows a non condition-specific note to the made about the related person.
     * Ideally, the note would be in the condition property, but this is not always possible.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The significant Conditions (or condition) that the family member had. This is a repeating
     * section to allow a system to represent more than one condition per resource, though there is
     * nothing stopping multiple resources - one per condition.
     */
    public var condition: MutableList<Condition.Builder> = mutableListOf()

    override fun build(): FamilyMemberHistory =
      FamilyMemberHistory(
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
        status = status,
        dataAbsentReason = dataAbsentReason?.build(),
        patient = patient.build(),
        date = date?.build(),
        name = name?.build(),
        relationship = relationship.build(),
        sex = sex?.build(),
        born = born,
        age = age,
        estimatedAge = estimatedAge?.build(),
        deceased = deceased,
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        note = note.map { it.build() },
        condition = condition.map { it.build() },
      )
  }

  /** A code that identifies the status of the family history record. */
  public enum class FamilyHistoryStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Partial("partial", "http://hl7.org/fhir/history-status", "Partial"),
    Completed("completed", "http://hl7.org/fhir/history-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/history-status", "Entered in Error"),
    Health_Unknown("health-unknown", "http://hl7.org/fhir/history-status", "Health Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): FamilyHistoryStatus =
        when (code) {
          "partial" -> Partial
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "health-unknown" -> Health_Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum FamilyHistoryStatus")
        }
    }
  }
}
