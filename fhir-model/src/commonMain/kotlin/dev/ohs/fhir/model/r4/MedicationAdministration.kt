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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.MedicationAdministrationDosageSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationAdministrationPerformerSerializer
import dev.ohs.fhir.model.r4.serializers.MedicationAdministrationSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the event of a patient consuming or otherwise being administered a medication. This may
 * be as simple as swallowing a tablet or it may be a long running infusion. Related resources tie
 * this event to the authorizing prescription, and the specific encounter between patient and health
 * care practitioner.
 */
@Serializable(with = MedicationAdministrationSerializer::class)
@SerialName("MedicationAdministration")
public data class MedicationAdministration(
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
   * Identifiers associated with this Medication Administration that are defined by business
   * processes and/or used to refer to it when a direct URL reference to the resource itself is not
   * appropriate. They are business identifiers assigned to this resource by the performer or other
   * systems and remain constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A protocol, guideline, orderset, or other definition that was adhered to in whole or in part by
   * this event.
   */
  public val instantiates: List<Uri> = listOf(),
  /** A larger event of which this particular event is a component or step. */
  public val partOf: List<Reference> = listOf(),
  /**
   * Will generally be set to show that the administration has been completed. For some long running
   * administrations such as infusions, it is possible for an administration to be started but not
   * completed or it may be paused while some other process is under way.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<MedicationAdministrationStatusCodes>,
  /** A code indicating why the administration was not performed. */
  public val statusReason: List<CodeableConcept> = listOf(),
  /** Indicates where the medication is expected to be consumed or administered. */
  public val category: CodeableConcept? = null,
  /**
   * Identifies the medication that was administered. This is either a link to a resource
   * representing the details of the medication or a simple attribute carrying a code that
   * identifies the medication from a known list of medications.
   *
   * If only a code is specified, then it needs to be a code for a specific product. If more
   * information is required, then the use of the medication resource is recommended. For example,
   * if you require form or lot number, then you must reference the Medication resource.
   */
  public val medication: Medication,
  /** The person or animal or group receiving the medication. */
  public val subject: Reference,
  /**
   * The visit, admission, or other contact between patient and health care provider during which
   * the medication administration was performed.
   */
  public val context: Reference? = null,
  /**
   * Additional information (for example, patient height and weight) that supports the
   * administration of the medication.
   */
  public val supportingInformation: List<Reference> = listOf(),
  /**
   * A specific date/time or interval of time during which the administration took place (or did not
   * take place, when the 'notGiven' attribute is true). For many administrations, such as
   * swallowing a tablet the use of dateTime is more appropriate.
   */
  public val effective: Effective,
  /** Indicates who or what performed the medication administration and how they were involved. */
  public val performer: List<Performer> = listOf(),
  /** A code indicating why the medication was given. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * Condition or observation that supports why the medication was administered.
   *
   * This is a reference to a condition that is the reason for the medication request. If only a
   * code exists, use reasonCode.
   */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * The original request, instruction or authority to perform the administration.
   *
   * This is a reference to the MedicationRequest where the intent is either order or
   * instance-order. It should not reference MedicationRequests where the intent is any other value.
   */
  public val request: Reference? = null,
  /**
   * The device used in administering the medication to the patient. For example, a particular
   * infusion pump.
   */
  public val device: List<Reference> = listOf(),
  /**
   * Extra information about the medication administration that is not conveyed by the other
   * attributes.
   */
  public val note: List<Annotation> = listOf(),
  /** Describes the medication dosage information details e.g. dose, rate, site, route, etc. */
  public val dosage: Dosage? = null,
  /**
   * A summary of the events of interest that have occurred, such as when the administration was
   * verified.
   *
   * This might not include provenances for all versions of the request – only those deemed
   * “relevant” or important. This SHALL NOT include the Provenance associated with this current
   * version of the resource. (If that provenance is deemed to be a “relevant” change, it will need
   * to be added as part of a later update. Until then, it can be queried directly as the Provenance
   * that points to this version using _revinclude All Provenances should have some historical
   * version of this Request as their subject.
   */
  public val eventHistory: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, medication, subject.toBuilder(), effective).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        instantiates = this@with.instantiates.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        statusReason = this@with.statusReason.map { it.toBuilder() }.toMutableList()
        category = this@with.category?.toBuilder()
        context = this@with.context?.toBuilder()
        supportingInformation =
          this@with.supportingInformation.map { it.toBuilder() }.toMutableList()
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        request = this@with.request?.toBuilder()
        device = this@with.device.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        dosage = this@with.dosage?.toBuilder()
        eventHistory = this@with.eventHistory.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Indicates who or what performed the medication administration and how they were involved. */
  @Serializable(with = MedicationAdministrationPerformerSerializer::class)
  public data class Performer(
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
    /** Distinguishes the type of involvement of the performer in the medication administration. */
    public val function: CodeableConcept? = null,
    /** Indicates who or what performed the medication administration. */
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
      /** Indicates who or what performed the medication administration. */
      public var actor: Reference.Builder
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
       * Distinguishes the type of involvement of the performer in the medication administration.
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

  /** Describes the medication dosage information details e.g. dose, rate, site, route, etc. */
  @Serializable(with = MedicationAdministrationDosageSerializer::class)
  public data class Dosage(
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
     * Free text dosage can be used for cases where the dosage administered is too complex to code.
     * When coded dosage is present, the free text dosage may still be present for display to
     * humans.
     *
     * The dosage instructions should reflect the dosage of the medication that was administered.
     */
    public val text: String? = null,
    /**
     * A coded specification of the anatomic site where the medication first entered the body. For
     * example, "left arm".
     *
     * If the use case requires attributes from the BodySite resource (e.g. to identify and track
     * separately) then use the standard extension [bodySite](extension-bodysite.html). May be a
     * summary code, or a reference to a very precise definition of the location, or both.
     */
    public val site: CodeableConcept? = null,
    /**
     * A code specifying the route or physiological path of administration of a therapeutic agent
     * into or onto the patient. For example, topical, intravenous, etc.
     */
    public val route: CodeableConcept? = null,
    /**
     * A coded value indicating the method by which the medication is intended to be or was
     * introduced into or on the body. This attribute will most often NOT be populated. It is most
     * commonly used for injections. For example, Slow Push, Deep IV.
     *
     * One of the reasons this attribute is not used often, is that the method is often
     * pre-coordinated with the route and/or form of administration. This means the codes used in
     * route or form may pre-coordinate the method in the route code or the form code. The
     * implementation decision about what coding system to use for route or form code will determine
     * how frequently the method code will be populated e.g. if route or form code pre-coordinate
     * method code, then this attribute will not be populated often; if there is no pre-coordination
     * then method code may be used frequently.
     */
    public val method: CodeableConcept? = null,
    /**
     * The amount of the medication given at one administration event. Use this value when the
     * administration is essentially an instantaneous event such as a swallowing a tablet or giving
     * an injection.
     *
     * If the administration is not instantaneous (rate is present), this can be specified to convey
     * the total amount administered over period of time of a single administration.
     */
    public val dose: Quantity? = null,
    /**
     * Identifies the speed with which the medication was or will be introduced into the patient.
     * Typically, the rate for an infusion e.g. 100 ml per 1 hour or 100 ml/hr. May also be
     * expressed as a rate per unit of time, e.g. 500 ml per 2 hours. Other examples: 200 mcg/min or
     * 200 mcg/1 minute; 1 liter/8 hours.
     *
     * If the rate changes over time, and you want to capture this in MedicationAdministration, then
     * each change should be captured as a distinct MedicationAdministration, with a specific
     * MedicationAdministration.dosage.rate, and the date time when the rate change occurred.
     * Typically, the MedicationAdministration.dosage.rate element is not used to convey an average
     * rate.
     */
    public val rate: Rate? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          text = this@with.text?.toBuilder()
          site = this@with.site?.toBuilder()
          route = this@with.route?.toBuilder()
          method = this@with.method?.toBuilder()
          dose = this@with.dose?.toBuilder()
          rate = this@with.rate
        }
      }

    public sealed interface Rate {
      public fun asRatio(): Ratio? = this as? Ratio

      public fun asQuantity(): Quantity? = this as? Quantity

      public data class Ratio(public val `value`: dev.ohs.fhir.model.r4.Ratio) : Rate

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) : Rate

      public companion object {
        internal fun from(
          ratioValue: dev.ohs.fhir.model.r4.Ratio?,
          quantityValue: dev.ohs.fhir.model.r4.Quantity?,
        ): Rate? {
          if (ratioValue != null) return Ratio(ratioValue)
          if (quantityValue != null) return Quantity(quantityValue)
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
       * Free text dosage can be used for cases where the dosage administered is too complex to
       * code. When coded dosage is present, the free text dosage may still be present for display
       * to humans.
       *
       * The dosage instructions should reflect the dosage of the medication that was administered.
       */
      public var text: String.Builder? = null

      /**
       * A coded specification of the anatomic site where the medication first entered the body. For
       * example, "left arm".
       *
       * If the use case requires attributes from the BodySite resource (e.g. to identify and track
       * separately) then use the standard extension [bodySite](extension-bodysite.html). May be a
       * summary code, or a reference to a very precise definition of the location, or both.
       */
      public var site: CodeableConcept.Builder? = null

      /**
       * A code specifying the route or physiological path of administration of a therapeutic agent
       * into or onto the patient. For example, topical, intravenous, etc.
       */
      public var route: CodeableConcept.Builder? = null

      /**
       * A coded value indicating the method by which the medication is intended to be or was
       * introduced into or on the body. This attribute will most often NOT be populated. It is most
       * commonly used for injections. For example, Slow Push, Deep IV.
       *
       * One of the reasons this attribute is not used often, is that the method is often
       * pre-coordinated with the route and/or form of administration. This means the codes used in
       * route or form may pre-coordinate the method in the route code or the form code. The
       * implementation decision about what coding system to use for route or form code will
       * determine how frequently the method code will be populated e.g. if route or form code
       * pre-coordinate method code, then this attribute will not be populated often; if there is no
       * pre-coordination then method code may be used frequently.
       */
      public var method: CodeableConcept.Builder? = null

      /**
       * The amount of the medication given at one administration event. Use this value when the
       * administration is essentially an instantaneous event such as a swallowing a tablet or
       * giving an injection.
       *
       * If the administration is not instantaneous (rate is present), this can be specified to
       * convey the total amount administered over period of time of a single administration.
       */
      public var dose: Quantity.Builder? = null

      /**
       * Identifies the speed with which the medication was or will be introduced into the patient.
       * Typically, the rate for an infusion e.g. 100 ml per 1 hour or 100 ml/hr. May also be
       * expressed as a rate per unit of time, e.g. 500 ml per 2 hours. Other examples: 200 mcg/min
       * or 200 mcg/1 minute; 1 liter/8 hours.
       *
       * If the rate changes over time, and you want to capture this in MedicationAdministration,
       * then each change should be captured as a distinct MedicationAdministration, with a specific
       * MedicationAdministration.dosage.rate, and the date time when the rate change occurred.
       * Typically, the MedicationAdministration.dosage.rate element is not used to convey an
       * average rate.
       */
      public var rate: Rate? = null

      public fun build(): Dosage =
        Dosage(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          text = text?.build(),
          site = site?.build(),
          route = route?.build(),
          method = method?.build(),
          dose = dose?.build(),
          rate = rate,
        )
    }
  }

  public sealed interface Medication {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
      Medication

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Medication

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4.Reference?,
      ): Medication? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public sealed interface Effective {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Effective

    public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Effective

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
        periodValue: dev.ohs.fhir.model.r4.Period?,
      ): Effective? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * Will generally be set to show that the administration has been completed. For some long
     * running administrations such as infusions, it is possible for an administration to be started
     * but not completed or it may be paused while some other process is under way.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<MedicationAdministrationStatusCodes>,
    /**
     * Identifies the medication that was administered. This is either a link to a resource
     * representing the details of the medication or a simple attribute carrying a code that
     * identifies the medication from a known list of medications.
     *
     * If only a code is specified, then it needs to be a code for a specific product. If more
     * information is required, then the use of the medication resource is recommended. For example,
     * if you require form or lot number, then you must reference the Medication resource.
     */
    public var medication: Medication,
    /** The person or animal or group receiving the medication. */
    public var subject: Reference.Builder,
    /**
     * A specific date/time or interval of time during which the administration took place (or did
     * not take place, when the 'notGiven' attribute is true). For many administrations, such as
     * swallowing a tablet the use of dateTime is more appropriate.
     */
    public var effective: Effective,
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
     * Identifiers associated with this Medication Administration that are defined by business
     * processes and/or used to refer to it when a direct URL reference to the resource itself is
     * not appropriate. They are business identifiers assigned to this resource by the performer or
     * other systems and remain constant as the resource is updated and propagates from server to
     * server.
     *
     * This is a business identifier, not a resource identifier.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A protocol, guideline, orderset, or other definition that was adhered to in whole or in part
     * by this event.
     */
    public var instantiates: MutableList<Uri.Builder> = mutableListOf()

    /** A larger event of which this particular event is a component or step. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /** A code indicating why the administration was not performed. */
    public var statusReason: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates where the medication is expected to be consumed or administered. */
    public var category: CodeableConcept.Builder? = null

    /**
     * The visit, admission, or other contact between patient and health care provider during which
     * the medication administration was performed.
     */
    public var context: Reference.Builder? = null

    /**
     * Additional information (for example, patient height and weight) that supports the
     * administration of the medication.
     */
    public var supportingInformation: MutableList<Reference.Builder> = mutableListOf()

    /** Indicates who or what performed the medication administration and how they were involved. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /** A code indicating why the medication was given. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Condition or observation that supports why the medication was administered.
     *
     * This is a reference to a condition that is the reason for the medication request. If only a
     * code exists, use reasonCode.
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The original request, instruction or authority to perform the administration.
     *
     * This is a reference to the MedicationRequest where the intent is either order or
     * instance-order. It should not reference MedicationRequests where the intent is any other
     * value.
     */
    public var request: Reference.Builder? = null

    /**
     * The device used in administering the medication to the patient. For example, a particular
     * infusion pump.
     */
    public var device: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Extra information about the medication administration that is not conveyed by the other
     * attributes.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Describes the medication dosage information details e.g. dose, rate, site, route, etc. */
    public var dosage: Dosage.Builder? = null

    /**
     * A summary of the events of interest that have occurred, such as when the administration was
     * verified.
     *
     * This might not include provenances for all versions of the request – only those deemed
     * “relevant” or important. This SHALL NOT include the Provenance associated with this current
     * version of the resource. (If that provenance is deemed to be a “relevant” change, it will
     * need to be added as part of a later update. Until then, it can be queried directly as the
     * Provenance that points to this version using _revinclude All Provenances should have some
     * historical version of this Request as their subject.
     */
    public var eventHistory: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): MedicationAdministration =
      MedicationAdministration(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiates = instantiates.map { it.build() },
        partOf = partOf.map { it.build() },
        status = status,
        statusReason = statusReason.map { it.build() },
        category = category?.build(),
        medication = medication,
        subject = subject.build(),
        context = context?.build(),
        supportingInformation = supportingInformation.map { it.build() },
        effective = effective,
        performer = performer.map { it.build() },
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        request = request?.build(),
        device = device.map { it.build() },
        note = note.map { it.build() },
        dosage = dosage?.build(),
        eventHistory = eventHistory.map { it.build() },
      )
  }

  /** MedicationAdministration Status Codes */
  public enum class MedicationAdministrationStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    In_Progress(
      "in-progress",
      "http://terminology.hl7.org/CodeSystem/medication-admin-status",
      "In Progress",
    ),
    Not_Done(
      "not-done",
      "http://terminology.hl7.org/CodeSystem/medication-admin-status",
      "Not Done",
    ),
    On_Hold("on-hold", "http://terminology.hl7.org/CodeSystem/medication-admin-status", "On Hold"),
    Completed(
      "completed",
      "http://terminology.hl7.org/CodeSystem/medication-admin-status",
      "Completed",
    ),
    Entered_In_Error(
      "entered-in-error",
      "http://terminology.hl7.org/CodeSystem/medication-admin-status",
      "Entered in Error",
    ),
    Stopped("stopped", "http://terminology.hl7.org/CodeSystem/medication-admin-status", "Stopped"),
    Unknown("unknown", "http://terminology.hl7.org/CodeSystem/medication-admin-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): MedicationAdministrationStatusCodes =
        when (code) {
          "in-progress" -> In_Progress
          "not-done" -> Not_Done
          "on-hold" -> On_Hold
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "stopped" -> Stopped
          "unknown" -> Unknown
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum MedicationAdministrationStatusCodes"
            )
        }
    }
  }
}
