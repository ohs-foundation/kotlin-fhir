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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.AllergyIntoleranceOnsetSerializer
import dev.ohs.fhir.model.r5.serializers.AllergyIntoleranceParticipantSerializer
import dev.ohs.fhir.model.r5.serializers.AllergyIntoleranceReactionSerializer
import dev.ohs.fhir.model.r5.serializers.AllergyIntoleranceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Risk of harmful or undesirable, physiological response which is unique to an individual and
 * associated with exposure to a substance.
 */
@Serializable(with = AllergyIntoleranceSerializer::class)
@SerialName("AllergyIntolerance")
public data class AllergyIntolerance(
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
   * Business identifiers assigned to this AllergyIntolerance by the performer or other systems
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
   * The clinical status of the allergy or intolerance.
   *
   * AllergyIntolerance.clinicalStatus should be present if verificationStatus is not
   * entered-in-error and the AllergyIntolerance.code isn't negated (No Known Allergy, No Drug
   * Allergy, No Food Allergy, No Latex Allergy). Refer to
   * [discussion](extensibility.html#Special-Case) if clinicalStatus is missing data. The data type
   * is CodeableConcept because clinicalStatus has some clinical judgment involved, such that there
   * might need to be more specificity than the required FHIR value set allows. For example, a
   * SNOMED coding might allow for additional specificity.
   */
  public val clinicalStatus: CodeableConcept? = null,
  /**
   * Assertion about certainty associated with the propensity, or potential risk, of a reaction to
   * the identified substance (including pharmaceutical product). The verification status pertains
   * to the allergy or intolerance, itself, not to any specific AllergyIntolerance attribute.
   *
   * The data type is CodeableConcept because verificationStatus has some clinical judgment
   * involved, such that there might need to be more specificity than the required FHIR value set
   * allows. For example, a SNOMED coding might allow for additional specificity.
   */
  public val verificationStatus: CodeableConcept? = null,
  /**
   * Identification of the underlying physiological mechanism for the reaction risk.
   *
   * Allergic (typically immune-mediated) reactions have been traditionally regarded as an indicator
   * for potential escalation to significant future risk. Contemporary knowledge suggests that some
   * reactions previously thought to be immune-mediated are, in fact, non-immune, but in some cases
   * can still pose a life threatening risk. It is acknowledged that many clinicians might not be in
   * a position to distinguish the mechanism of a particular reaction. Often the term "allergy" is
   * used rather generically and may overlap with the use of "intolerance" - in practice the
   * boundaries between these two concepts might not be well-defined or understood. This data
   * element is included nevertheless, because many legacy systems have captured this attribute.
   * Immunologic testing may provide supporting evidence for the basis of the reaction and the
   * causative substance, but no tests are 100% sensitive or specific for sensitivity to a
   * particular substance. If, as is commonly the case, it is unclear whether the reaction is due to
   * an allergy or an intolerance, then the type element should be omitted from the resource.
   */
  public val type: CodeableConcept? = null,
  /**
   * Category of the identified substance.
   *
   * This data element has been included because it is currently being captured in some clinical
   * systems. This data can be derived from the substance where coding systems are used, and is
   * effectively redundant in that situation. When searching on category, consider the implications
   * of AllergyIntolerance resources without a category. For example, when searching on category =
   * medication, medication allergies that don't have a category valued will not be returned. Refer
   * to [search](search.html) for more information on how to search category with a :missing
   * modifier to get allergies that don't have a category. Additionally, category should be used
   * with caution because category can be subjective based on the sender.
   */
  public val category: List<Enumeration<AllergyIntoleranceCategory>> = listOf(),
  /**
   * Estimate of the potential clinical harm, or seriousness, of the reaction to the identified
   * substance.
   *
   * The default criticality value for any propensity to an adverse reaction should be 'Low Risk',
   * indicating at the very least a relative contraindication to deliberate or voluntary exposure to
   * the substance. 'High Risk' is flagged if the clinician has identified a propensity for a more
   * serious or potentially life-threatening reaction, such as anaphylaxis, and implies an absolute
   * contraindication to deliberate or voluntary exposure to the substance. If this element is
   * missing, the criticality is unknown (though it may be known elsewhere). Systems that capture a
   * severity at the condition level are actually representing the concept of criticality whereas
   * the severity documented at the reaction level is representing the true reaction severity.
   * Existing systems that are capturing both condition criticality and reaction severity may use
   * the term "severity" to represent both. Criticality is the worst it could be in the future (i.e.
   * situation-agnostic) whereas severity is situation-dependent.
   */
  public val criticality: Enumeration<AllergyIntoleranceCriticality>? = null,
  /**
   * Code for an allergy or intolerance statement (either a positive or a negated/excluded
   * statement). This may be a code for a substance or pharmaceutical product that is considered to
   * be responsible for the adverse reaction risk (e.g., "Latex"), an allergy or intolerance
   * condition (e.g., "Latex allergy"), or a negated/excluded code for a specific substance or class
   * (e.g., "No latex allergy") or a general or categorical negated statement (e.g., "No known
   * allergy", "No known drug allergies"). Note: the substance for a specific reaction may be
   * different from the substance identified as the cause of the risk, but it must be consistent
   * with it. For instance, it may be a more specific substance (e.g. a brand medication) or a
   * composite product that includes the identified substance. It must be clinically safe to only
   * process the 'code' and ignore the 'reaction.substance'. If a receiving system is unable to
   * confirm that AllergyIntolerance.reaction.substance falls within the semantic scope of
   * AllergyIntolerance.code, then the receiving system should ignore
   * AllergyIntolerance.reaction.substance.
   *
   * It is strongly recommended that this element be populated using a terminology, where possible.
   * For example, some terminologies used include RxNorm, SNOMED CT, DM+D, NDFRT, ICD-9, IDC-10,
   * UNII, and ATC. Plain text should only be used if there is no appropriate terminology available.
   * Additional details can be specified in the text.
   *
   * When a substance or product code is specified for the 'code' element, the "default" semantic
   * context is that this is a positive statement of an allergy or intolerance (depending on the
   * value of the 'type' element, if present) condition to the specified substance/product. In the
   * corresponding SNOMED CT allergy model, the specified substance/product is the target
   * (destination) of the "Causative agent" relationship.
   *
   * The 'substanceExposureRisk' extension is available as a structured and more flexible
   * alternative to the 'code' element for making positive or negative allergy or intolerance
   * statements. This extension provides the capability to make "no known allergy" (or "no risk of
   * adverse reaction") statements regarding any coded substance/product (including cases when a
   * pre-coordinated "no allergy to x" concept for that substance/product does not exist). If the
   * 'substanceExposureRisk' extension is present, the AllergyIntolerance.code element SHALL be
   * omitted.
   */
  public val code: CodeableConcept? = null,
  /** The patient who has the allergy or intolerance. */
  public val patient: Reference,
  /** The encounter when the allergy or intolerance was asserted. */
  public val encounter: Reference? = null,
  /**
   * Estimated or actual date, date-time, or age when allergy or intolerance was identified.
   *
   * Age is generally used when the patient reports an age at which the AllergyIntolerance was
   * noted. Period is generally used to convey an imprecise onset that occurred within the time
   * period. Range is generally used to convey an imprecise age range (e.g. 4 to 6 years old).
   */
  public val onset: Onset? = null,
  /**
   * The recordedDate represents when this particular AllergyIntolerance record was created in the
   * system, which is often a system-generated date.
   *
   * When onset date is unknown, recordedDate can be used to establish if the allergy or intolerance
   * was present on or before a given date. If the recordedDate is known and provided by a sending
   * system, it is preferred that the receiving system preserve that recordedDate value. If the
   * recordedDate is not provided by the sending system, the receipt timestamp is sometimes used as
   * the recordedDate.
   */
  public val recordedDate: DateTime? = null,
  /**
   * Indicates who or what participated in the activities related to the allergy or intolerance and
   * how they were involved.
   */
  public val participant: List<Participant> = listOf(),
  /**
   * Represents the date and/or time of the last known occurrence of a reaction event.
   *
   * This date may be replicated by one of the Onset of Reaction dates. Where a textual
   * representation of the date of last occurrence is required e.g. 'In Childhood, '10 years ago'
   * the AllergyIntolerance.note element should be used.
   */
  public val lastOccurrence: DateTime? = null,
  /**
   * Additional narrative about the propensity for the Adverse Reaction, not captured in other
   * fields.
   *
   * For example: including reason for flagging a seriousness of 'High Risk'; and instructions
   * related to future exposure or administration of the substance, such as administration within an
   * Intensive Care Unit or under corticosteroid cover. The notes should be related to an allergy or
   * intolerance as a condition in general and not related to any particular episode of it. For
   * episode notes and descriptions, use AllergyIntolerance.event.description and
   * AllergyIntolerance.event.notes.
   */
  public val note: List<Annotation> = listOf(),
  /** Details about each adverse reaction event linked to exposure to the identified substance. */
  public val reaction: List<Reaction> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(patient.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        clinicalStatus = this@with.clinicalStatus?.toBuilder()
        verificationStatus = this@with.verificationStatus?.toBuilder()
        type = this@with.type?.toBuilder()
        category = this@with.category.toMutableList()
        criticality = this@with.criticality
        code = this@with.code?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        onset = this@with.onset
        recordedDate = this@with.recordedDate?.toBuilder()
        participant = this@with.participant.map { it.toBuilder() }.toMutableList()
        lastOccurrence = this@with.lastOccurrence?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        reaction = this@with.reaction.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * Indicates who or what participated in the activities related to the allergy or intolerance and
   * how they were involved.
   */
  @Serializable(with = AllergyIntoleranceParticipantSerializer::class)
  public data class Participant(
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
     * Distinguishes the type of involvement of the actor in the activities related to the allergy
     * or intolerance.
     */
    public val function: CodeableConcept? = null,
    /**
     * Indicates who or what participated in the activities related to the allergy or intolerance.
     */
    public val actor: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(actor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Indicates who or what participated in the activities related to the allergy or intolerance.
       */
      public var actor: Reference.Builder
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
       * Distinguishes the type of involvement of the actor in the activities related to the allergy
       * or intolerance.
       */
      public var function: CodeableConcept.Builder? = null

      public fun build(): Participant =
        Participant(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  /** Details about each adverse reaction event linked to exposure to the identified substance. */
  @Serializable(with = AllergyIntoleranceReactionSerializer::class)
  public data class Reaction(
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
     * Identification of the specific substance (or pharmaceutical product) considered to be
     * responsible for the Adverse Reaction event. Note: the substance for a specific reaction may
     * be different from the substance identified as the cause of the risk, but it must be
     * consistent with it. For instance, it may be a more specific substance (e.g. a brand
     * medication) or a composite product that includes the identified substance. It must be
     * clinically safe to only process the 'code' and ignore the 'reaction.substance'. If a
     * receiving system is unable to confirm that AllergyIntolerance.reaction.substance falls within
     * the semantic scope of AllergyIntolerance.code, then the receiving system should ignore
     * AllergyIntolerance.reaction.substance.
     *
     * Coding of the specific substance (or pharmaceutical product) with a terminology capable of
     * triggering decision support should be used wherever possible. The 'code' element allows for
     * the use of a specific substance or pharmaceutical product, or a group or class of substances.
     * In the case of an allergy or intolerance to a class of substances, (for example,
     * "penicillins"), the 'reaction.substance' element could be used to code the specific substance
     * that was identified as having caused the reaction (for example, "amoxycillin"). Duplication
     * of the value in the 'code' and 'reaction.substance' elements is acceptable when a specific
     * substance has been recorded in 'code'.
     */
    public val substance: CodeableConcept? = null,
    /**
     * Clinical symptoms and/or signs that are observed or associated with the adverse reaction
     * event.
     *
     * Manifestation can be expressed as a single word, phrase or brief description. For example:
     * nausea, rash or no reaction. It is preferable that manifestation should be coded with a
     * terminology, where possible. The values entered here may be used to display on an application
     * screen as part of a list of adverse reactions, as recommended in the UK NHS CUI guidelines.
     * Terminologies commonly used include, but are not limited to, SNOMED CT or ICD10.
     */
    public val manifestation: List<CodeableReference>,
    /**
     * Text description about the reaction as a whole, including details of the manifestation if
     * required.
     *
     * Use the description to provide any details of a particular event of the occurred reaction
     * such as circumstances, reaction specifics, what happened before/after. Information, related
     * to the event, but not describing a particular care should be captured in the note field. For
     * example: at the age of four, the patient was given penicillin for strep throat and
     * subsequently developed severe hives.
     */
    public val description: String? = null,
    /** Record of the date and/or time of the onset of the Reaction. */
    public val onset: DateTime? = null,
    /**
     * Clinical assessment of the severity of the reaction event as a whole, potentially considering
     * multiple different manifestations.
     *
     * It is acknowledged that this assessment is very subjective. There may be some specific
     * practice domains where objective scales have been applied. Objective scales can be included
     * in this model as extensions.
     */
    public val severity: Enumeration<AllergyIntoleranceSeverity>? = null,
    /**
     * Identification of the route by which the subject was exposed to the substance.
     *
     * Coding of the route of exposure with a terminology should be used wherever possible.
     */
    public val exposureRoute: CodeableConcept? = null,
    /**
     * Additional text about the adverse reaction event not captured in other fields.
     *
     * Use this field to record information indirectly related to a particular event and not
     * captured in the description. For example: Clinical records are no longer available, recorded
     * based on information provided to the patient by her mother and her mother is deceased.
     */
    public val note: List<Annotation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(manifestation.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          substance = this@with.substance?.toBuilder()
          description = this@with.description?.toBuilder()
          onset = this@with.onset?.toBuilder()
          severity = this@with.severity
          exposureRoute = this@with.exposureRoute?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Clinical symptoms and/or signs that are observed or associated with the adverse reaction
       * event.
       *
       * Manifestation can be expressed as a single word, phrase or brief description. For example:
       * nausea, rash or no reaction. It is preferable that manifestation should be coded with a
       * terminology, where possible. The values entered here may be used to display on an
       * application screen as part of a list of adverse reactions, as recommended in the UK NHS CUI
       * guidelines. Terminologies commonly used include, but are not limited to, SNOMED CT or
       * ICD10.
       */
      public var manifestation: MutableList<CodeableReference.Builder>
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
       * Identification of the specific substance (or pharmaceutical product) considered to be
       * responsible for the Adverse Reaction event. Note: the substance for a specific reaction may
       * be different from the substance identified as the cause of the risk, but it must be
       * consistent with it. For instance, it may be a more specific substance (e.g. a brand
       * medication) or a composite product that includes the identified substance. It must be
       * clinically safe to only process the 'code' and ignore the 'reaction.substance'. If a
       * receiving system is unable to confirm that AllergyIntolerance.reaction.substance falls
       * within the semantic scope of AllergyIntolerance.code, then the receiving system should
       * ignore AllergyIntolerance.reaction.substance.
       *
       * Coding of the specific substance (or pharmaceutical product) with a terminology capable of
       * triggering decision support should be used wherever possible. The 'code' element allows for
       * the use of a specific substance or pharmaceutical product, or a group or class of
       * substances. In the case of an allergy or intolerance to a class of substances, (for
       * example, "penicillins"), the 'reaction.substance' element could be used to code the
       * specific substance that was identified as having caused the reaction (for example,
       * "amoxycillin"). Duplication of the value in the 'code' and 'reaction.substance' elements is
       * acceptable when a specific substance has been recorded in 'code'.
       */
      public var substance: CodeableConcept.Builder? = null

      /**
       * Text description about the reaction as a whole, including details of the manifestation if
       * required.
       *
       * Use the description to provide any details of a particular event of the occurred reaction
       * such as circumstances, reaction specifics, what happened before/after. Information, related
       * to the event, but not describing a particular care should be captured in the note field.
       * For example: at the age of four, the patient was given penicillin for strep throat and
       * subsequently developed severe hives.
       */
      public var description: String.Builder? = null

      /** Record of the date and/or time of the onset of the Reaction. */
      public var onset: DateTime.Builder? = null

      /**
       * Clinical assessment of the severity of the reaction event as a whole, potentially
       * considering multiple different manifestations.
       *
       * It is acknowledged that this assessment is very subjective. There may be some specific
       * practice domains where objective scales have been applied. Objective scales can be included
       * in this model as extensions.
       */
      public var severity: Enumeration<AllergyIntoleranceSeverity>? = null

      /**
       * Identification of the route by which the subject was exposed to the substance.
       *
       * Coding of the route of exposure with a terminology should be used wherever possible.
       */
      public var exposureRoute: CodeableConcept.Builder? = null

      /**
       * Additional text about the adverse reaction event not captured in other fields.
       *
       * Use this field to record information indirectly related to a particular event and not
       * captured in the description. For example: Clinical records are no longer available,
       * recorded based on information provided to the patient by her mother and her mother is
       * deceased.
       */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      public fun build(): Reaction =
        Reaction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          substance = substance?.build(),
          manifestation = manifestation.map { it.build() },
          description = description?.build(),
          onset = onset?.build(),
          severity = severity,
          exposureRoute = exposureRoute?.build(),
          note = note.map { it.build() },
        )
    }
  }

  @Serializable(with = AllergyIntoleranceOnsetSerializer::class)
  public sealed interface Onset {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asAge(): Age? = this as? Age

    public fun asPeriod(): Period? = this as? Period

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Onset

    public data class Age(public val `value`: dev.ohs.fhir.model.r5.Age) : Onset

    public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Onset

    public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Onset

    public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Onset

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        ageValue: dev.ohs.fhir.model.r5.Age?,
        periodValue: dev.ohs.fhir.model.r5.Period?,
        rangeValue: dev.ohs.fhir.model.r5.Range?,
        stringValue: dev.ohs.fhir.model.r5.String?,
      ): Onset? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (ageValue != null) return Age(ageValue)
        if (periodValue != null) return Period(periodValue)
        if (rangeValue != null) return Range(rangeValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public class Builder(
    /** The patient who has the allergy or intolerance. */
    public var patient: Reference.Builder
  ) : DomainResource.Builder() {
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
     * Business identifiers assigned to this AllergyIntolerance by the performer or other systems
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
     * The clinical status of the allergy or intolerance.
     *
     * AllergyIntolerance.clinicalStatus should be present if verificationStatus is not
     * entered-in-error and the AllergyIntolerance.code isn't negated (No Known Allergy, No Drug
     * Allergy, No Food Allergy, No Latex Allergy). Refer to
     * [discussion](extensibility.html#Special-Case) if clinicalStatus is missing data. The data
     * type is CodeableConcept because clinicalStatus has some clinical judgment involved, such that
     * there might need to be more specificity than the required FHIR value set allows. For example,
     * a SNOMED coding might allow for additional specificity.
     */
    public var clinicalStatus: CodeableConcept.Builder? = null

    /**
     * Assertion about certainty associated with the propensity, or potential risk, of a reaction to
     * the identified substance (including pharmaceutical product). The verification status pertains
     * to the allergy or intolerance, itself, not to any specific AllergyIntolerance attribute.
     *
     * The data type is CodeableConcept because verificationStatus has some clinical judgment
     * involved, such that there might need to be more specificity than the required FHIR value set
     * allows. For example, a SNOMED coding might allow for additional specificity.
     */
    public var verificationStatus: CodeableConcept.Builder? = null

    /**
     * Identification of the underlying physiological mechanism for the reaction risk.
     *
     * Allergic (typically immune-mediated) reactions have been traditionally regarded as an
     * indicator for potential escalation to significant future risk. Contemporary knowledge
     * suggests that some reactions previously thought to be immune-mediated are, in fact,
     * non-immune, but in some cases can still pose a life threatening risk. It is acknowledged that
     * many clinicians might not be in a position to distinguish the mechanism of a particular
     * reaction. Often the term "allergy" is used rather generically and may overlap with the use of
     * "intolerance" - in practice the boundaries between these two concepts might not be
     * well-defined or understood. This data element is included nevertheless, because many legacy
     * systems have captured this attribute. Immunologic testing may provide supporting evidence for
     * the basis of the reaction and the causative substance, but no tests are 100% sensitive or
     * specific for sensitivity to a particular substance. If, as is commonly the case, it is
     * unclear whether the reaction is due to an allergy or an intolerance, then the type element
     * should be omitted from the resource.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * Category of the identified substance.
     *
     * This data element has been included because it is currently being captured in some clinical
     * systems. This data can be derived from the substance where coding systems are used, and is
     * effectively redundant in that situation. When searching on category, consider the
     * implications of AllergyIntolerance resources without a category. For example, when searching
     * on category = medication, medication allergies that don't have a category valued will not be
     * returned. Refer to [search](search.html) for more information on how to search category with
     * a :missing modifier to get allergies that don't have a category. Additionally, category
     * should be used with caution because category can be subjective based on the sender.
     */
    public var category: MutableList<Enumeration<AllergyIntoleranceCategory>> = mutableListOf()

    /**
     * Estimate of the potential clinical harm, or seriousness, of the reaction to the identified
     * substance.
     *
     * The default criticality value for any propensity to an adverse reaction should be 'Low Risk',
     * indicating at the very least a relative contraindication to deliberate or voluntary exposure
     * to the substance. 'High Risk' is flagged if the clinician has identified a propensity for a
     * more serious or potentially life-threatening reaction, such as anaphylaxis, and implies an
     * absolute contraindication to deliberate or voluntary exposure to the substance. If this
     * element is missing, the criticality is unknown (though it may be known elsewhere). Systems
     * that capture a severity at the condition level are actually representing the concept of
     * criticality whereas the severity documented at the reaction level is representing the true
     * reaction severity. Existing systems that are capturing both condition criticality and
     * reaction severity may use the term "severity" to represent both. Criticality is the worst it
     * could be in the future (i.e. situation-agnostic) whereas severity is situation-dependent.
     */
    public var criticality: Enumeration<AllergyIntoleranceCriticality>? = null

    /**
     * Code for an allergy or intolerance statement (either a positive or a negated/excluded
     * statement). This may be a code for a substance or pharmaceutical product that is considered
     * to be responsible for the adverse reaction risk (e.g., "Latex"), an allergy or intolerance
     * condition (e.g., "Latex allergy"), or a negated/excluded code for a specific substance or
     * class (e.g., "No latex allergy") or a general or categorical negated statement (e.g., "No
     * known allergy", "No known drug allergies"). Note: the substance for a specific reaction may
     * be different from the substance identified as the cause of the risk, but it must be
     * consistent with it. For instance, it may be a more specific substance (e.g. a brand
     * medication) or a composite product that includes the identified substance. It must be
     * clinically safe to only process the 'code' and ignore the 'reaction.substance'. If a
     * receiving system is unable to confirm that AllergyIntolerance.reaction.substance falls within
     * the semantic scope of AllergyIntolerance.code, then the receiving system should ignore
     * AllergyIntolerance.reaction.substance.
     *
     * It is strongly recommended that this element be populated using a terminology, where
     * possible. For example, some terminologies used include RxNorm, SNOMED CT, DM+D, NDFRT, ICD-9,
     * IDC-10, UNII, and ATC. Plain text should only be used if there is no appropriate terminology
     * available. Additional details can be specified in the text.
     *
     * When a substance or product code is specified for the 'code' element, the "default" semantic
     * context is that this is a positive statement of an allergy or intolerance (depending on the
     * value of the 'type' element, if present) condition to the specified substance/product. In the
     * corresponding SNOMED CT allergy model, the specified substance/product is the target
     * (destination) of the "Causative agent" relationship.
     *
     * The 'substanceExposureRisk' extension is available as a structured and more flexible
     * alternative to the 'code' element for making positive or negative allergy or intolerance
     * statements. This extension provides the capability to make "no known allergy" (or "no risk of
     * adverse reaction") statements regarding any coded substance/product (including cases when a
     * pre-coordinated "no allergy to x" concept for that substance/product does not exist). If the
     * 'substanceExposureRisk' extension is present, the AllergyIntolerance.code element SHALL be
     * omitted.
     */
    public var code: CodeableConcept.Builder? = null

    /** The encounter when the allergy or intolerance was asserted. */
    public var encounter: Reference.Builder? = null

    /**
     * Estimated or actual date, date-time, or age when allergy or intolerance was identified.
     *
     * Age is generally used when the patient reports an age at which the AllergyIntolerance was
     * noted. Period is generally used to convey an imprecise onset that occurred within the time
     * period. Range is generally used to convey an imprecise age range (e.g. 4 to 6 years old).
     */
    public var onset: Onset? = null

    /**
     * The recordedDate represents when this particular AllergyIntolerance record was created in the
     * system, which is often a system-generated date.
     *
     * When onset date is unknown, recordedDate can be used to establish if the allergy or
     * intolerance was present on or before a given date. If the recordedDate is known and provided
     * by a sending system, it is preferred that the receiving system preserve that recordedDate
     * value. If the recordedDate is not provided by the sending system, the receipt timestamp is
     * sometimes used as the recordedDate.
     */
    public var recordedDate: DateTime.Builder? = null

    /**
     * Indicates who or what participated in the activities related to the allergy or intolerance
     * and how they were involved.
     */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /**
     * Represents the date and/or time of the last known occurrence of a reaction event.
     *
     * This date may be replicated by one of the Onset of Reaction dates. Where a textual
     * representation of the date of last occurrence is required e.g. 'In Childhood, '10 years ago'
     * the AllergyIntolerance.note element should be used.
     */
    public var lastOccurrence: DateTime.Builder? = null

    /**
     * Additional narrative about the propensity for the Adverse Reaction, not captured in other
     * fields.
     *
     * For example: including reason for flagging a seriousness of 'High Risk'; and instructions
     * related to future exposure or administration of the substance, such as administration within
     * an Intensive Care Unit or under corticosteroid cover. The notes should be related to an
     * allergy or intolerance as a condition in general and not related to any particular episode of
     * it. For episode notes and descriptions, use AllergyIntolerance.event.description and
     * AllergyIntolerance.event.notes.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Details about each adverse reaction event linked to exposure to the identified substance. */
    public var reaction: MutableList<Reaction.Builder> = mutableListOf()

    override fun build(): AllergyIntolerance =
      AllergyIntolerance(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        clinicalStatus = clinicalStatus?.build(),
        verificationStatus = verificationStatus?.build(),
        type = type?.build(),
        category = category,
        criticality = criticality,
        code = code?.build(),
        patient = patient.build(),
        encounter = encounter?.build(),
        onset = onset,
        recordedDate = recordedDate?.build(),
        participant = participant.map { it.build() },
        lastOccurrence = lastOccurrence?.build(),
        note = note.map { it.build() },
        reaction = reaction.map { it.build() },
      )
  }

  /**
   * Clinical assessment of the severity of a reaction event as a whole, potentially considering
   * multiple different manifestations.
   */
  public enum class AllergyIntoleranceSeverity(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Mild("mild", "http://hl7.org/fhir/reaction-event-severity", "Mild"),
    Moderate("moderate", "http://hl7.org/fhir/reaction-event-severity", "Moderate"),
    Severe("severe", "http://hl7.org/fhir/reaction-event-severity", "Severe");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AllergyIntoleranceSeverity =
        when (code) {
          "mild" -> Mild
          "moderate" -> Moderate
          "severe" -> Severe
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AllergyIntoleranceSeverity")
        }
    }
  }

  /** Category of an identified substance associated with allergies or intolerances. */
  public enum class AllergyIntoleranceCategory(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Food("food", "http://hl7.org/fhir/allergy-intolerance-category", "Food"),
    Medication("medication", "http://hl7.org/fhir/allergy-intolerance-category", "Medication"),
    Environment("environment", "http://hl7.org/fhir/allergy-intolerance-category", "Environment"),
    Biologic("biologic", "http://hl7.org/fhir/allergy-intolerance-category", "Biologic");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AllergyIntoleranceCategory =
        when (code) {
          "food" -> Food
          "medication" -> Medication
          "environment" -> Environment
          "biologic" -> Biologic
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AllergyIntoleranceCategory")
        }
    }
  }

  /**
   * Estimate of the potential clinical harm, or seriousness, of a reaction to an identified
   * substance.
   */
  public enum class AllergyIntoleranceCriticality(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Low("low", "http://hl7.org/fhir/allergy-intolerance-criticality", "Low Risk"),
    High("high", "http://hl7.org/fhir/allergy-intolerance-criticality", "High Risk"),
    Unable_To_Assess(
      "unable-to-assess",
      "http://hl7.org/fhir/allergy-intolerance-criticality",
      "Unable to Assess Risk",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AllergyIntoleranceCriticality =
        when (code) {
          "low" -> Low
          "high" -> High
          "unable-to-assess" -> Unable_To_Assess
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum AllergyIntoleranceCriticality"
            )
        }
    }
  }
}
