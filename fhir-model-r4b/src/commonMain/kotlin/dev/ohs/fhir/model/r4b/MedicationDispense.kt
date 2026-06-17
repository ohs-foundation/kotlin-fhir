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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.MedicationDispensePerformerSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationDispenseSerializer
import dev.ohs.fhir.model.r4b.serializers.MedicationDispenseSubstitutionSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates that a medication product is to be or has been dispensed for a named person/patient.
 * This includes a description of the medication product (supply) provided and the instructions for
 * administering the medication. The medication dispense is the result of a pharmacy system
 * responding to a medication order.
 */
@Serializable(with = MedicationDispenseSerializer::class)
@SerialName("MedicationDispense")
public data class MedicationDispense(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
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
   * Identifiers associated with this Medication Dispense that are defined by business processes
   * and/or used to refer to it when a direct URL reference to the resource itself is not
   * appropriate. They are business identifiers assigned to this resource by the performer or other
   * systems and remain constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier.
   */
  public val identifier: List<Identifier> = listOf(),
  /** The procedure that trigger the dispense. */
  public val partOf: List<Reference> = listOf(),
  /**
   * A code specifying the state of the set of dispense events.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<MedicationDispenseStatusCodes>,
  /** Indicates the reason why a dispense was not performed. */
  public val statusReason: StatusReason? = null,
  /**
   * Indicates the type of medication dispense (for example, where the medication is expected to be
   * consumed or administered (i.e. inpatient or outpatient)).
   *
   * The category can be used to include where the medication is expected to be consumed or other
   * types of dispenses. Invariants can be used to bind to different value sets when profiling to
   * bind.
   */
  public val category: CodeableConcept? = null,
  /**
   * Identifies the medication being administered. This is either a link to a resource representing
   * the details of the medication or a simple attribute carrying a code that identifies the
   * medication from a known list of medications.
   *
   * If only a code is specified, then it needs to be a code for a specific product. If more
   * information is required, then the use of the medication resource is recommended. For example,
   * if you require form or lot number, then you must reference the Medication resource.
   */
  public val medication: Medication,
  /**
   * A link to a resource representing the person or the group to whom the medication will be given.
   *
   * SubstanceAdministration->subject->Patient.
   */
  public val subject: Reference? = null,
  /** The encounter or episode of care that establishes the context for this event. */
  public val context: Reference? = null,
  /** Additional information that supports the medication being dispensed. */
  public val supportingInformation: List<Reference> = listOf(),
  /** Indicates who or what performed the event. */
  public val performer: List<Performer> = listOf(),
  /** The principal physical location where the dispense was performed. */
  public val location: Reference? = null,
  /**
   * Indicates the medication order that is being dispensed against.
   *
   * Maps to basedOn in Event logical model.
   */
  public val authorizingPrescription: List<Reference> = listOf(),
  /**
   * Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion
   * of Trial, Partial Fill, Emergency Fill, Samples, etc.
   */
  public val type: CodeableConcept? = null,
  /** The amount of medication that has been dispensed. Includes unit of measure. */
  public val quantity: Quantity? = null,
  /** The amount of medication expressed as a timing amount. */
  public val daysSupply: Quantity? = null,
  /** The time when the dispensed product was packaged and reviewed. */
  public val whenPrepared: DateTime? = null,
  /** The time the dispensed product was provided to the patient or their representative. */
  public val whenHandedOver: DateTime? = null,
  /**
   * Identification of the facility/location where the medication was shipped to, as part of the
   * dispense event.
   */
  public val destination: Reference? = null,
  /**
   * Identifies the person who picked up the medication. This will usually be a patient or their
   * caregiver, but some cases exist where it can be a healthcare professional.
   */
  public val `receiver`: List<Reference> = listOf(),
  /** Extra information about the dispense that could not be conveyed in the other attributes. */
  public val note: List<Annotation> = listOf(),
  /**
   * Indicates how the medication is to be used by the patient.
   *
   * When the dose or rate is intended to change over the entire administration period (e.g.
   * Tapering dose prescriptions), multiple instances of dosage instructions will need to be
   * supplied to convey the different doses/rates. The pharmacist reviews the medication order prior
   * to dispense and updates the dosageInstruction based on the actual product being dispensed.
   */
  public val dosageInstruction: List<Dosage> = listOf(),
  /**
   * Indicates whether or not substitution was made as part of the dispense. In some cases,
   * substitution will be expected but does not happen, in other cases substitution is not expected
   * but does happen. This block explains what substitution did or did not happen and why. If
   * nothing is specified, substitution was not done.
   */
  public val substitution: Substitution? = null,
  /**
   * Indicates an actual or potential clinical issue with or between one or more active or proposed
   * clinical actions for a patient; e.g. drug-drug interaction, duplicate therapy, dosage alert
   * etc.
   *
   * This element can include a detected issue that has been identified either by a decision support
   * system or by a clinician and may include information on the steps that were taken to address
   * the issue.
   */
  public val detectedIssue: List<Reference> = listOf(),
  /**
   * A summary of the events of interest that have occurred, such as when the dispense was verified.
   *
   * This might not include provenances for all versions of the request – only those deemed
   * “relevant” or important. This SHALL NOT include the Provenance associated with this current
   * version of the resource. (If that provenance is deemed to be a “relevant” change, it will need
   * to be added as part of a later update. Until then, it can be queried directly as the Provenance
   * that points to this version using _revinclude All Provenances should have some historical
   * version of this Request as their subject.).
   */
  public val eventHistory: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          medication,
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
          partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
          statusReason = this@with.statusReason
          category = this@with.category?.toBuilder()
          subject = this@with.subject?.toBuilder()
          context = this@with.context?.toBuilder()
          supportingInformation =
            this@with.supportingInformation.map { it.toBuilder() }.toMutableList()
          performer = this@with.performer.map { it.toBuilder() }.toMutableList()
          location = this@with.location?.toBuilder()
          authorizingPrescription =
            this@with.authorizingPrescription.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          quantity = this@with.quantity?.toBuilder()
          daysSupply = this@with.daysSupply?.toBuilder()
          whenPrepared = this@with.whenPrepared?.toBuilder()
          whenHandedOver = this@with.whenHandedOver?.toBuilder()
          destination = this@with.destination?.toBuilder()
          `receiver` = this@with.`receiver`.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          dosageInstruction = this@with.dosageInstruction.map { it.toBuilder() }.toMutableList()
          substitution = this@with.substitution?.toBuilder()
          detectedIssue = this@with.detectedIssue.map { it.toBuilder() }.toMutableList()
          eventHistory = this@with.eventHistory.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Indicates who or what performed the event. */
  @Serializable(with = MedicationDispensePerformerSerializer::class)
  public data class Performer(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
     * Distinguishes the type of performer in the dispense. For example, date enterer, packager,
     * final checker.
     */
    public val function: CodeableConcept? = null,
    /**
     * The device, practitioner, etc. who performed the action. It should be assumed that the actor
     * is the dispenser of the medication.
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
       * The device, practitioner, etc. who performed the action. It should be assumed that the
       * actor is the dispenser of the medication.
       */
      public var actor: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * Distinguishes the type of performer in the dispense. For example, date enterer, packager,
       * final checker.
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

  /**
   * Indicates whether or not substitution was made as part of the dispense. In some cases,
   * substitution will be expected but does not happen, in other cases substitution is not expected
   * but does happen. This block explains what substitution did or did not happen and why. If
   * nothing is specified, substitution was not done.
   */
  @Serializable(with = MedicationDispenseSubstitutionSerializer::class)
  public data class Substitution(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** True if the dispenser dispensed a different drug or product from what was prescribed. */
    public val wasSubstituted: Boolean,
    /** A code signifying whether a different drug was dispensed from what was prescribed. */
    public val type: CodeableConcept? = null,
    /**
     * Indicates the reason for the substitution (or lack of substitution) from what was prescribed.
     */
    public val reason: List<CodeableConcept> = listOf(),
    /** The person or organization that has primary responsibility for the substitution. */
    public val responsibleParty: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(wasSubstituted.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          reason = this@with.reason.map { it.toBuilder() }.toMutableList()
          responsibleParty = this@with.responsibleParty.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** True if the dispenser dispensed a different drug or product from what was prescribed. */
      public var wasSubstituted: Boolean.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** A code signifying whether a different drug was dispensed from what was prescribed. */
      public var type: CodeableConcept.Builder? = null

      /**
       * Indicates the reason for the substitution (or lack of substitution) from what was
       * prescribed.
       */
      public var reason: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The person or organization that has primary responsibility for the substitution. */
      public var responsibleParty: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Substitution =
        Substitution(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          wasSubstituted = wasSubstituted.build(),
          type = type?.build(),
          reason = reason.map { it.build() },
          responsibleParty = responsibleParty.map { it.build() },
        )
    }
  }

  public sealed interface StatusReason {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept) :
      StatusReason

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : StatusReason

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
      ): StatusReason? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public sealed interface Medication {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept) :
      Medication

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Medication

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
      ): Medication? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A code specifying the state of the set of dispense events.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<MedicationDispenseStatusCodes>,
    /**
     * Identifies the medication being administered. This is either a link to a resource
     * representing the details of the medication or a simple attribute carrying a code that
     * identifies the medication from a known list of medications.
     *
     * If only a code is specified, then it needs to be a code for a specific product. If more
     * information is required, then the use of the medication resource is recommended. For example,
     * if you require form or lot number, then you must reference the Medication resource.
     */
    public var medication: Medication,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    public var id: String? = null

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
     * Identifiers associated with this Medication Dispense that are defined by business processes
     * and/or used to refer to it when a direct URL reference to the resource itself is not
     * appropriate. They are business identifiers assigned to this resource by the performer or
     * other systems and remain constant as the resource is updated and propagates from server to
     * server.
     *
     * This is a business identifier, not a resource identifier.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The procedure that trigger the dispense. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /** Indicates the reason why a dispense was not performed. */
    public var statusReason: StatusReason? = null

    /**
     * Indicates the type of medication dispense (for example, where the medication is expected to
     * be consumed or administered (i.e. inpatient or outpatient)).
     *
     * The category can be used to include where the medication is expected to be consumed or other
     * types of dispenses. Invariants can be used to bind to different value sets when profiling to
     * bind.
     */
    public var category: CodeableConcept.Builder? = null

    /**
     * A link to a resource representing the person or the group to whom the medication will be
     * given.
     *
     * SubstanceAdministration->subject->Patient.
     */
    public var subject: Reference.Builder? = null

    /** The encounter or episode of care that establishes the context for this event. */
    public var context: Reference.Builder? = null

    /** Additional information that supports the medication being dispensed. */
    public var supportingInformation: MutableList<Reference.Builder> = mutableListOf()

    /** Indicates who or what performed the event. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /** The principal physical location where the dispense was performed. */
    public var location: Reference.Builder? = null

    /**
     * Indicates the medication order that is being dispensed against.
     *
     * Maps to basedOn in Event logical model.
     */
    public var authorizingPrescription: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion
     * of Trial, Partial Fill, Emergency Fill, Samples, etc.
     */
    public var type: CodeableConcept.Builder? = null

    /** The amount of medication that has been dispensed. Includes unit of measure. */
    public var quantity: Quantity.Builder? = null

    /** The amount of medication expressed as a timing amount. */
    public var daysSupply: Quantity.Builder? = null

    /** The time when the dispensed product was packaged and reviewed. */
    public var whenPrepared: DateTime.Builder? = null

    /** The time the dispensed product was provided to the patient or their representative. */
    public var whenHandedOver: DateTime.Builder? = null

    /**
     * Identification of the facility/location where the medication was shipped to, as part of the
     * dispense event.
     */
    public var destination: Reference.Builder? = null

    /**
     * Identifies the person who picked up the medication. This will usually be a patient or their
     * caregiver, but some cases exist where it can be a healthcare professional.
     */
    public var `receiver`: MutableList<Reference.Builder> = mutableListOf()

    /** Extra information about the dispense that could not be conveyed in the other attributes. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Indicates how the medication is to be used by the patient.
     *
     * When the dose or rate is intended to change over the entire administration period (e.g.
     * Tapering dose prescriptions), multiple instances of dosage instructions will need to be
     * supplied to convey the different doses/rates. The pharmacist reviews the medication order
     * prior to dispense and updates the dosageInstruction based on the actual product being
     * dispensed.
     */
    public var dosageInstruction: MutableList<Dosage.Builder> = mutableListOf()

    /**
     * Indicates whether or not substitution was made as part of the dispense. In some cases,
     * substitution will be expected but does not happen, in other cases substitution is not
     * expected but does happen. This block explains what substitution did or did not happen and
     * why. If nothing is specified, substitution was not done.
     */
    public var substitution: Substitution.Builder? = null

    /**
     * Indicates an actual or potential clinical issue with or between one or more active or
     * proposed clinical actions for a patient; e.g. drug-drug interaction, duplicate therapy,
     * dosage alert etc.
     *
     * This element can include a detected issue that has been identified either by a decision
     * support system or by a clinician and may include information on the steps that were taken to
     * address the issue.
     */
    public var detectedIssue: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A summary of the events of interest that have occurred, such as when the dispense was
     * verified.
     *
     * This might not include provenances for all versions of the request – only those deemed
     * “relevant” or important. This SHALL NOT include the Provenance associated with this current
     * version of the resource. (If that provenance is deemed to be a “relevant” change, it will
     * need to be added as part of a later update. Until then, it can be queried directly as the
     * Provenance that points to this version using _revinclude All Provenances should have some
     * historical version of this Request as their subject.).
     */
    public var eventHistory: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): MedicationDispense =
      MedicationDispense(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        partOf = partOf.map { it.build() },
        status = status,
        statusReason = statusReason,
        category = category?.build(),
        medication = medication,
        subject = subject?.build(),
        context = context?.build(),
        supportingInformation = supportingInformation.map { it.build() },
        performer = performer.map { it.build() },
        location = location?.build(),
        authorizingPrescription = authorizingPrescription.map { it.build() },
        type = type?.build(),
        quantity = quantity?.build(),
        daysSupply = daysSupply?.build(),
        whenPrepared = whenPrepared?.build(),
        whenHandedOver = whenHandedOver?.build(),
        destination = destination?.build(),
        `receiver` = `receiver`.map { it.build() },
        note = note.map { it.build() },
        dosageInstruction = dosageInstruction.map { it.build() },
        substitution = substitution?.build(),
        detectedIssue = detectedIssue.map { it.build() },
        eventHistory = eventHistory.map { it.build() },
      )
  }

  /** MedicationDispense Status Codes */
  public enum class MedicationDispenseStatusCodes(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Preparation(
      "preparation",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Preparation",
    ),
    In_Progress(
      "in-progress",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "In Progress",
    ),
    Cancelled(
      "cancelled",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Cancelled",
    ),
    On_Hold(
      "on-hold",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "On Hold",
    ),
    Completed(
      "completed",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Completed",
    ),
    Entered_In_Error(
      "entered-in-error",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Entered in Error",
    ),
    Stopped(
      "stopped",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Stopped",
    ),
    Declined(
      "declined",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Declined",
    ),
    Unknown(
      "unknown",
      "http://terminology.hl7.org/CodeSystem/medicationdispense-status",
      "Unknown",
    );

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): MedicationDispenseStatusCodes =
        when (code) {
          "preparation" -> Preparation
          "in-progress" -> In_Progress
          "cancelled" -> Cancelled
          "on-hold" -> On_Hold
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "stopped" -> Stopped
          "declined" -> Declined
          "unknown" -> Unknown
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum MedicationDispenseStatusCodes"
            )
        }
    }
  }
}
