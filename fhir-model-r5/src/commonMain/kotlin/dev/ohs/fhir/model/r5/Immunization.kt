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

import dev.ohs.fhir.model.r5.serializers.ImmunizationPerformerSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationProgramEligibilitySerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationProtocolAppliedSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationReactionSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the event of a patient being administered a vaccine or a record of an immunization as
 * reported by a patient, a clinician or another party.
 */
@Serializable(with = ImmunizationSerializer::class)
@SerialName("Immunization")
public data class Immunization(
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
  /** A unique identifier assigned to this immunization record. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A plan, order or recommendation fulfilled in whole or in part by this immunization.
   *
   * Allows tracing of an authorization for the Immunization.
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * Indicates the current status of the immunization event.
   *
   * Will generally be set to show that the immunization has been completed or not done. This
   * element is labeled as a modifier because the status contains codes that mark the resource as
   * not currently valid.
   */
  public val status: Enumeration<ImmunizationStatusCodes>,
  /**
   * Indicates the reason the immunization event was not performed.
   *
   * This is generally only used for the status of "not-done". The reason for performing the
   * immunization event is captured in reasonCode, not here.
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * Vaccine that was administered or was to be administered.
   *
   * The code for the administered vaccine may be reported at various levels of granularity from a
   * very generic code for a general type of vaccine (e.g. the SNOMED or CVX code for the flu
   * vaccine) to a very discrete code for a specific product including the form and packaging (e.g.
   * an NDC code). Because vaccineCode uses the CodeableConcept data type, multiple codes at
   * different levels of granularity may be reported for a single immunization event provided that
   * all codes are appropriate for the same vaccine. For example, both NDC and CVX codes may be
   * provided for a given immunization event by repeating the coding element within vaccineCode.
   */
  public val vaccineCode: CodeableConcept,
  /**
   * An indication of which product was administered to the patient. This is typically a more
   * detailed representation of the concept conveyed by the vaccineCode data element. If a
   * Medication resource is referenced, it may be to a stand-alone resource or a contained resource
   * within the Immunization resource.
   */
  public val administeredProduct: CodeableReference? = null,
  /** Name of vaccine manufacturer. */
  public val manufacturer: CodeableReference? = null,
  /** Lot number of the vaccine product. */
  public val lotNumber: String? = null,
  /** Date vaccine batch expires. */
  public val expirationDate: Date? = null,
  /** The patient who either received or did not receive the immunization. */
  public val patient: Reference,
  /**
   * The visit or admission or other contact between patient and health care provider the
   * immunization was performed as part of.
   */
  public val encounter: Reference? = null,
  /**
   * Additional information that is relevant to the immunization (e.g. for a vaccine recipient who
   * is pregnant, the gestational age of the fetus). The reason why a vaccine was given (e.g.
   * occupation, underlying medical condition) should be conveyed in Immunization.reason, not as
   * supporting information. The reason why a vaccine was not given (e.g. contraindication) should
   * be conveyed in Immunization.statusReason, not as supporting information.
   */
  public val supportingInformation: List<Reference> = listOf(),
  /**
   * Date vaccine administered or was to be administered.
   *
   * When immunizations are given a specific date and time should always be known. When
   * immunizations are patient reported, a specific date might not be known. Although partial dates
   * are allowed, an adult patient might not be able to recall the year a childhood immunization was
   * given. An exact date is always preferable, but the use of the String data type is acceptable
   * when an exact date is not known. A small number of vaccines (e.g. live oral typhoid vaccine)
   * are given as a series of patient self-administered dose over a span of time. In cases like
   * this, often, only the first dose (typically a provider supervised dose) is recorded with the
   * occurrence indicating the date/time of the first dose.
   */
  public val occurrence: Occurrence,
  /**
   * Indicates whether the data contained in the resource was captured by the
   * individual/organization which was responsible for the administration of the vaccine rather than
   * as 'secondary reported' data documented by a third party. A value of 'true' means this data
   * originated with the individual/organization which was responsible for the administration of the
   * vaccine.
   *
   * Reflects the “reliability” of the content.
   */
  public val primarySource: Boolean? = null,
  /**
   * Typically the source of the data when the report of the immunization event is not based on
   * information from the person who administered the vaccine.
   *
   * Typically will not be populated if primarySource = True, not required even if primarySource =
   * False.
   */
  public val informationSource: CodeableReference? = null,
  /** The service delivery location where the vaccine administration occurred. */
  public val location: Reference? = null,
  /** Body site where vaccine was administered. */
  public val site: CodeableConcept? = null,
  /** The path by which the vaccine product is taken into the body. */
  public val route: CodeableConcept? = null,
  /** The quantity of vaccine product that was administered. */
  public val doseQuantity: Quantity? = null,
  /** Indicates who performed the immunization event. */
  public val performer: List<Performer> = listOf(),
  /** Extra information about the immunization that is not conveyed by the other attributes. */
  public val note: List<Annotation> = listOf(),
  /**
   * Describes why the immunization occurred in coded or textual form, or Indicates another resource
   * (Condition, Observation or DiagnosticReport) whose existence justifies this immunization.
   */
  public val reason: List<CodeableReference> = listOf(),
  /**
   * Indication if a dose is considered to be subpotent. By default, a dose should be considered to
   * be potent.
   *
   * Typically, the recognition of the dose being sub-potent is retrospective, after the
   * administration (ex. notification of a manufacturer recall after administration). However, in
   * the case of a partial administration (the patient moves unexpectedly and only some of the dose
   * is actually administered), subpotency may be recognized immediately, but it is still important
   * to record the event.
   */
  public val isSubpotent: Boolean? = null,
  /** Reason why a dose is considered to be subpotent. */
  public val subpotentReason: List<CodeableConcept> = listOf(),
  /** Indicates a patient's eligibility for a funding program. */
  public val programEligibility: List<ProgramEligibility> = listOf(),
  /**
   * Indicates the source of the vaccine actually administered. This may be different than the
   * patient eligibility (e.g. the patient may be eligible for a publically purchased vaccine but
   * due to inventory issues, vaccine purchased with private funds was actually administered).
   */
  public val fundingSource: CodeableConcept? = null,
  /**
   * Categorical data indicating that an adverse event is associated in time to an immunization.
   *
   * A reaction may be an indication of an allergy or intolerance and, if this is determined to be
   * the case, it should be recorded as a new AllergyIntolerance resource instance as most systems
   * will not query against past Immunization.reaction elements.
   */
  public val reaction: List<Reaction> = listOf(),
  /**
   * The protocol (set of recommendations) being followed by the provider who administered the dose.
   */
  public val protocolApplied: List<ProtocolApplied> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          vaccineCode.toBuilder(),
          patient.toBuilder(),
          occurrence,
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
          basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
          statusReason = this@with.statusReason?.toBuilder()
          administeredProduct = this@with.administeredProduct?.toBuilder()
          manufacturer = this@with.manufacturer?.toBuilder()
          lotNumber = this@with.lotNumber?.toBuilder()
          expirationDate = this@with.expirationDate?.toBuilder()
          encounter = this@with.encounter?.toBuilder()
          supportingInformation =
            this@with.supportingInformation.map { it.toBuilder() }.toMutableList()
          primarySource = this@with.primarySource?.toBuilder()
          informationSource = this@with.informationSource?.toBuilder()
          location = this@with.location?.toBuilder()
          site = this@with.site?.toBuilder()
          route = this@with.route?.toBuilder()
          doseQuantity = this@with.doseQuantity?.toBuilder()
          performer = this@with.performer.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          reason = this@with.reason.map { it.toBuilder() }.toMutableList()
          isSubpotent = this@with.isSubpotent?.toBuilder()
          subpotentReason = this@with.subpotentReason.map { it.toBuilder() }.toMutableList()
          programEligibility = this@with.programEligibility.map { it.toBuilder() }.toMutableList()
          fundingSource = this@with.fundingSource?.toBuilder()
          reaction = this@with.reaction.map { it.toBuilder() }.toMutableList()
          protocolApplied = this@with.protocolApplied.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Indicates who performed the immunization event. */
  @Serializable(with = ImmunizationPerformerSerializer::class)
  public data class Performer(
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
    /** Describes the type of performance (e.g. ordering provider, administering provider, etc.). */
    public val function: CodeableConcept? = null,
    /**
     * The practitioner or organization who performed the action.
     *
     * When the individual practitioner who performed the action is known, it is best to send.
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
       * The practitioner or organization who performed the action.
       *
       * When the individual practitioner who performed the action is known, it is best to send.
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
       * Describes the type of performance (e.g. ordering provider, administering provider, etc.).
       */
      public var function: CodeableConcept.Builder? = null

      public fun build(): Performer =
        Performer(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  /** Indicates a patient's eligibility for a funding program. */
  @Serializable(with = ImmunizationProgramEligibilitySerializer::class)
  public data class ProgramEligibility(
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
    /** Indicates which program the patient had their eligility evaluated for. */
    public val program: CodeableConcept,
    /** Indicates the patient's eligility status for for a specific payment program. */
    public val programStatus: CodeableConcept,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(program.toBuilder(), programStatus.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Indicates which program the patient had their eligility evaluated for. */
      public var program: CodeableConcept.Builder,
      /** Indicates the patient's eligility status for for a specific payment program. */
      public var programStatus: CodeableConcept.Builder,
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

      public fun build(): ProgramEligibility =
        ProgramEligibility(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          program = program.build(),
          programStatus = programStatus.build(),
        )
    }
  }

  /** Categorical data indicating that an adverse event is associated in time to an immunization. */
  @Serializable(with = ImmunizationReactionSerializer::class)
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
    /** Date of reaction to the immunization. */
    public val date: DateTime? = null,
    /** Details of the reaction. */
    public val manifestation: CodeableReference? = null,
    /** Self-reported indicator. */
    public val reported: Boolean? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          date = this@with.date?.toBuilder()
          manifestation = this@with.manifestation?.toBuilder()
          reported = this@with.reported?.toBuilder()
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

      /** Date of reaction to the immunization. */
      public var date: DateTime.Builder? = null

      /** Details of the reaction. */
      public var manifestation: CodeableReference.Builder? = null

      /** Self-reported indicator. */
      public var reported: Boolean.Builder? = null

      public fun build(): Reaction =
        Reaction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          date = date?.build(),
          manifestation = manifestation?.build(),
          reported = reported?.build(),
        )
    }
  }

  /**
   * The protocol (set of recommendations) being followed by the provider who administered the dose.
   */
  @Serializable(with = ImmunizationProtocolAppliedSerializer::class)
  public data class ProtocolApplied(
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
     * One possible path to achieve presumed immunity against a disease - within the context of an
     * authority.
     */
    public val series: String? = null,
    /** Indicates the authority who published the protocol (e.g. ACIP) that is being followed. */
    public val authority: Reference? = null,
    /** The vaccine preventable disease the dose is being administered against. */
    public val targetDisease: List<CodeableConcept> = listOf(),
    /**
     * Nominal position in a series as intended by the practitioner administering the dose.
     *
     * The use of an integer is preferred if known. Text should only be used in cases where an
     * integer is not available (such as when documenting a recurring booster dose).
     */
    public val doseNumber: String,
    /**
     * The recommended number of doses to achieve immunity as intended by the practitioner
     * administering the dose.
     *
     * The use of an integer is preferred if known.
     */
    public val seriesDoses: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(doseNumber.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          series = this@with.series?.toBuilder()
          authority = this@with.authority?.toBuilder()
          targetDisease = this@with.targetDisease.map { it.toBuilder() }.toMutableList()
          seriesDoses = this@with.seriesDoses?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Nominal position in a series as intended by the practitioner administering the dose.
       *
       * The use of an integer is preferred if known. Text should only be used in cases where an
       * integer is not available (such as when documenting a recurring booster dose).
       */
      public var doseNumber: String.Builder
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
       * One possible path to achieve presumed immunity against a disease - within the context of an
       * authority.
       */
      public var series: String.Builder? = null

      /** Indicates the authority who published the protocol (e.g. ACIP) that is being followed. */
      public var authority: Reference.Builder? = null

      /** The vaccine preventable disease the dose is being administered against. */
      public var targetDisease: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The recommended number of doses to achieve immunity as intended by the practitioner
       * administering the dose.
       *
       * The use of an integer is preferred if known.
       */
      public var seriesDoses: String.Builder? = null

      public fun build(): ProtocolApplied =
        ProtocolApplied(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          series = series?.build(),
          authority = authority?.build(),
          targetDisease = targetDisease.map { it.build() },
          doseNumber = doseNumber.build(),
          seriesDoses = seriesDoses?.build(),
        )
    }
  }

  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asString(): String? = this as? String

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Occurrence

    public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        stringValue: dev.ohs.fhir.model.r5.String?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * Indicates the current status of the immunization event.
     *
     * Will generally be set to show that the immunization has been completed or not done. This
     * element is labeled as a modifier because the status contains codes that mark the resource as
     * not currently valid.
     */
    public var status: Enumeration<ImmunizationStatusCodes>,
    /**
     * Vaccine that was administered or was to be administered.
     *
     * The code for the administered vaccine may be reported at various levels of granularity from a
     * very generic code for a general type of vaccine (e.g. the SNOMED or CVX code for the flu
     * vaccine) to a very discrete code for a specific product including the form and packaging
     * (e.g. an NDC code). Because vaccineCode uses the CodeableConcept data type, multiple codes at
     * different levels of granularity may be reported for a single immunization event provided that
     * all codes are appropriate for the same vaccine. For example, both NDC and CVX codes may be
     * provided for a given immunization event by repeating the coding element within vaccineCode.
     */
    public var vaccineCode: CodeableConcept.Builder,
    /** The patient who either received or did not receive the immunization. */
    public var patient: Reference.Builder,
    /**
     * Date vaccine administered or was to be administered.
     *
     * When immunizations are given a specific date and time should always be known. When
     * immunizations are patient reported, a specific date might not be known. Although partial
     * dates are allowed, an adult patient might not be able to recall the year a childhood
     * immunization was given. An exact date is always preferable, but the use of the String data
     * type is acceptable when an exact date is not known. A small number of vaccines (e.g. live
     * oral typhoid vaccine) are given as a series of patient self-administered dose over a span of
     * time. In cases like this, often, only the first dose (typically a provider supervised dose)
     * is recorded with the occurrence indicating the date/time of the first dose.
     */
    public var occurrence: Occurrence,
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

    /** A unique identifier assigned to this immunization record. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A plan, order or recommendation fulfilled in whole or in part by this immunization.
     *
     * Allows tracing of an authorization for the Immunization.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Indicates the reason the immunization event was not performed.
     *
     * This is generally only used for the status of "not-done". The reason for performing the
     * immunization event is captured in reasonCode, not here.
     */
    public var statusReason: CodeableConcept.Builder? = null

    /**
     * An indication of which product was administered to the patient. This is typically a more
     * detailed representation of the concept conveyed by the vaccineCode data element. If a
     * Medication resource is referenced, it may be to a stand-alone resource or a contained
     * resource within the Immunization resource.
     */
    public var administeredProduct: CodeableReference.Builder? = null

    /** Name of vaccine manufacturer. */
    public var manufacturer: CodeableReference.Builder? = null

    /** Lot number of the vaccine product. */
    public var lotNumber: String.Builder? = null

    /** Date vaccine batch expires. */
    public var expirationDate: Date.Builder? = null

    /**
     * The visit or admission or other contact between patient and health care provider the
     * immunization was performed as part of.
     */
    public var encounter: Reference.Builder? = null

    /**
     * Additional information that is relevant to the immunization (e.g. for a vaccine recipient who
     * is pregnant, the gestational age of the fetus). The reason why a vaccine was given (e.g.
     * occupation, underlying medical condition) should be conveyed in Immunization.reason, not as
     * supporting information. The reason why a vaccine was not given (e.g. contraindication) should
     * be conveyed in Immunization.statusReason, not as supporting information.
     */
    public var supportingInformation: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Indicates whether the data contained in the resource was captured by the
     * individual/organization which was responsible for the administration of the vaccine rather
     * than as 'secondary reported' data documented by a third party. A value of 'true' means this
     * data originated with the individual/organization which was responsible for the administration
     * of the vaccine.
     *
     * Reflects the “reliability” of the content.
     */
    public var primarySource: Boolean.Builder? = null

    /**
     * Typically the source of the data when the report of the immunization event is not based on
     * information from the person who administered the vaccine.
     *
     * Typically will not be populated if primarySource = True, not required even if primarySource =
     * False.
     */
    public var informationSource: CodeableReference.Builder? = null

    /** The service delivery location where the vaccine administration occurred. */
    public var location: Reference.Builder? = null

    /** Body site where vaccine was administered. */
    public var site: CodeableConcept.Builder? = null

    /** The path by which the vaccine product is taken into the body. */
    public var route: CodeableConcept.Builder? = null

    /** The quantity of vaccine product that was administered. */
    public var doseQuantity: Quantity.Builder? = null

    /** Indicates who performed the immunization event. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /** Extra information about the immunization that is not conveyed by the other attributes. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Describes why the immunization occurred in coded or textual form, or Indicates another
     * resource (Condition, Observation or DiagnosticReport) whose existence justifies this
     * immunization.
     */
    public var reason: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Indication if a dose is considered to be subpotent. By default, a dose should be considered
     * to be potent.
     *
     * Typically, the recognition of the dose being sub-potent is retrospective, after the
     * administration (ex. notification of a manufacturer recall after administration). However, in
     * the case of a partial administration (the patient moves unexpectedly and only some of the
     * dose is actually administered), subpotency may be recognized immediately, but it is still
     * important to record the event.
     */
    public var isSubpotent: Boolean.Builder? = null

    /** Reason why a dose is considered to be subpotent. */
    public var subpotentReason: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates a patient's eligibility for a funding program. */
    public var programEligibility: MutableList<ProgramEligibility.Builder> = mutableListOf()

    /**
     * Indicates the source of the vaccine actually administered. This may be different than the
     * patient eligibility (e.g. the patient may be eligible for a publically purchased vaccine but
     * due to inventory issues, vaccine purchased with private funds was actually administered).
     */
    public var fundingSource: CodeableConcept.Builder? = null

    /**
     * Categorical data indicating that an adverse event is associated in time to an immunization.
     *
     * A reaction may be an indication of an allergy or intolerance and, if this is determined to be
     * the case, it should be recorded as a new AllergyIntolerance resource instance as most systems
     * will not query against past Immunization.reaction elements.
     */
    public var reaction: MutableList<Reaction.Builder> = mutableListOf()

    /**
     * The protocol (set of recommendations) being followed by the provider who administered the
     * dose.
     */
    public var protocolApplied: MutableList<ProtocolApplied.Builder> = mutableListOf()

    override fun build(): Immunization =
      Immunization(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        basedOn = basedOn.map { it.build() },
        status = status,
        statusReason = statusReason?.build(),
        vaccineCode = vaccineCode.build(),
        administeredProduct = administeredProduct?.build(),
        manufacturer = manufacturer?.build(),
        lotNumber = lotNumber?.build(),
        expirationDate = expirationDate?.build(),
        patient = patient.build(),
        encounter = encounter?.build(),
        supportingInformation = supportingInformation.map { it.build() },
        occurrence = occurrence,
        primarySource = primarySource?.build(),
        informationSource = informationSource?.build(),
        location = location?.build(),
        site = site?.build(),
        route = route?.build(),
        doseQuantity = doseQuantity?.build(),
        performer = performer.map { it.build() },
        note = note.map { it.build() },
        reason = reason.map { it.build() },
        isSubpotent = isSubpotent?.build(),
        subpotentReason = subpotentReason.map { it.build() },
        programEligibility = programEligibility.map { it.build() },
        fundingSource = fundingSource?.build(),
        reaction = reaction.map { it.build() },
        protocolApplied = protocolApplied.map { it.build() },
      )
  }

  /**
   * The value set to instantiate this attribute should be drawn from a terminologically robust code
   * system that consists of or contains concepts to support describing the current status of the
   * administered dose of vaccine.
   */
  public enum class ImmunizationStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Completed("completed", "http://hl7.org/fhir/event-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/event-status", "Entered in Error"),
    Not_Done("not-done", "http://hl7.org/fhir/event-status", "Not Done");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ImmunizationStatusCodes =
        when (code) {
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "not-done" -> Not_Done
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ImmunizationStatusCodes")
        }
    }
  }
}
